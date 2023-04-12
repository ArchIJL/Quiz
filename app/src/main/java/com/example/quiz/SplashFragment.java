package com.example.quiz;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.quiz.databinding.FragmentSplashBinding;
import com.example.quiz.model.QuestionsTaSViewModel;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplashFragment extends Fragment {

    private List<MainActivity.Question> mQuestions;

    private QuestionsTaSViewModel questionsTaSViewModel;

    private FragmentSplashBinding binding = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        questionsTaSViewModel = new ViewModelProvider(requireActivity()).get(QuestionsTaSViewModel.class);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);
        CollectionReference questionsRef = db.collection("time_survival_questions");

        questionsRef.addSnapshotListener((querySnapshot, error) -> {
            if (error != null) {
                Log.w("Error", "Listen failed.", error);
                return;
            }

            if (querySnapshot != null) {
                mQuestions = new ArrayList<>();
                for (QueryDocumentSnapshot document : querySnapshot) {
                    String text = document.getString("text");
                    String option1 = document.getString("option1");
                    String option2 = document.getString("option2");
                    String option3 = document.getString("option3");
                    String option4 = document.getString("option4");

                    MainActivity.Question question = new MainActivity.Question(text, option1, option2, option3, option4);
                    mQuestions.add(question);
                }

                Collections.shuffle(mQuestions);

                questionsTaSViewModel.setQuestions(mQuestions);

                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_main_fragment);
            } else {
                Log.d("TimeFirebase", "Error getting documents: ");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSplashBinding.inflate(inflater, container, false);

        ImageView imageView = binding.questionMark;
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1500);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        imageView.startAnimation(rotateAnimation);

        return  binding.getRoot();
    }
}