package com.example.quiz.fragments;

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

import com.example.quiz.R;
import com.example.quiz.databinding.FragmentSplashBinding;
import com.example.quiz.model.MyViewModel;
import com.example.quiz.model.QuestionsTaSViewModel;
import com.example.quiz.questions.Question;
import com.example.quiz.questions.QuestionCampaign;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplashFragment extends Fragment {

    private List<Question> mQuestions;

    private Map<String, Map<String, QuestionCampaign>> questionMap = new HashMap<>();
    boolean questionsLoaded = false;
    boolean questionMapLoaded = false;
    private QuestionsTaSViewModel questionsTaSViewModel;
    private MyViewModel viewModel;
    private FragmentSplashBinding binding = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        questionsTaSViewModel = new ViewModelProvider(requireActivity()).get(QuestionsTaSViewModel.class);
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        CollectionReference versionRef = db.collection("version_database");
        versionRef.document("currentVersion").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                String dbVersion = task.getResult().getString("version");

                Log.v("dbVersion", dbVersion);
                Log.v("Version Database", viewModel.getVersionDatabase());

                if (dbVersion.equals(viewModel.getVersionDatabase())) {
                    Navigation.findNavController(SplashFragment.this.requireView()).navigate(R.id.action_splashFragment_to_main_fragment);
                } else {
                    viewModel.setVersionDatabase(dbVersion);

                    CollectionReference qR = db.collection("categoryId");
                    qR.get().addOnCompleteListener(task1 -> {
                        if (task1.isSuccessful()) {
                            Map<String, Map<String, QuestionCampaign>> questionMap = new HashMap<>();

                            for (QueryDocumentSnapshot documentSnapshot : task1.getResult()) {
                                String categoryId = documentSnapshot.getId();
                                Log.v("categoryId", categoryId);

                                Map<String, QuestionCampaign> levelMap = new HashMap<>();

                                CollectionReference qR1 = documentSnapshot.getReference().collection("levelId");
                                qR1.get().addOnCompleteListener(task2 -> {
                                    if (task2.isSuccessful()) {
                                        for (QueryDocumentSnapshot documentSnapshot1 : task2.getResult()) {
                                            String levelId = documentSnapshot1.getId();
                                            Log.v("levelId", levelId);

                                            String text = documentSnapshot1.getString("text");
                                            int questionNumber = documentSnapshot1.getLong("questionNumber").intValue();
                                            String buttonText = documentSnapshot1.getString("buttonText");
                                            String correctAnswer = documentSnapshot1.getString("correctAnswer");
                                            String infoAnswer = documentSnapshot1.getString("infoAnswer");

                                            QuestionCampaign questionCampaign = new QuestionCampaign(text, questionNumber, buttonText, correctAnswer, infoAnswer);

                                            levelMap.put(levelId, questionCampaign);
                                        }
                                        questionMap.put(categoryId, levelMap);

                                        if (questionMap.size() == 7) { // Проверка, что загружены все категории уровней
                                            viewModel.setQuestionMap(questionMap);
                                            viewModel.saveQuestionMap(requireContext());
                                            questionMapLoaded = true;
                                            if (questionsLoaded) {
                                                Navigation.findNavController(SplashFragment.this.requireView()).navigate(R.id.action_splashFragment_to_main_fragment);
                                            }
                                        }
                                    } else {
                                        Log.w("Error Questions Campaign", "Listen failed.", task1.getException());
                                    }
                                });
                            }
                        } else {
                            Log.w("Error Questions Campaign", "Listen failed.", task.getException());
                        }
                    });

                    // Second database
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

                                Question question = new Question(text, option1, option2, option3, option4);
                                mQuestions.add(question);
                            }

                            Collections.shuffle(mQuestions);

                            questionsTaSViewModel.setQuestions(mQuestions);
                            questionsTaSViewModel.saveQuestionsToPrefs(requireContext());

                            questionsLoaded = true;
                            if (questionMapLoaded) {
                                Navigation.findNavController(SplashFragment.this.requireView()).navigate(R.id.action_splashFragment_to_main_fragment);
                            }

                        } else {
                            Log.d("TimeFirebase", "Error getting documents: ");
                        }
                    });
                }
            } else {
                Log.w("Error getting database version", "Failed to get database version from Firebase", task.getException());
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