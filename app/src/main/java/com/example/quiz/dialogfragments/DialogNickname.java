package com.example.quiz.dialogfragments;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.Navigation;

import com.example.quiz.R;
import com.example.quiz.databinding.FragmentDialogNicknameBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class DialogNickname extends DialogFragment {

    private FragmentDialogNicknameBinding binding = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDialogNicknameBinding.inflate(inflater, container, false);

        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.custom_dialog);
        }

        Button acceptButton = binding.acceptNickname;
        EditText nicknameEditText = binding.nickname;

        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(6);
        nicknameEditText.setFilters(filters);

        acceptButton.setOnClickListener(v -> {
            String nickname = nicknameEditText.getText().toString().trim();
            if (!TextUtils.isEmpty(nickname)) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                DocumentReference userRef = db.collection("users").document(uid);
                userRef.update("nickname", nickname).addOnSuccessListener(unused -> {
                    userRef.get().addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot != null && documentSnapshot.exists() && !documentSnapshot.contains("ScoreTime")) {
                            userRef.update("ScoreTime", 0);
                        }
                        if (documentSnapshot != null && documentSnapshot.exists() && !documentSnapshot.contains("ScoreSurvival")) {
                            userRef.update("ScoreSurvival", 0);
                        }
                    });
                    DialogNickname.this.dismiss();
                    Navigation.findNavController(DialogNickname.this.requireActivity(), R.id.fragmentContainerView).navigate(R.id.settings, null);
                })
                        .addOnFailureListener(e -> Log.w("Error Nickname", "Error updating document", e));
            } else {
                Toast.makeText(getActivity(), "Введите свой никнейм", Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }
}