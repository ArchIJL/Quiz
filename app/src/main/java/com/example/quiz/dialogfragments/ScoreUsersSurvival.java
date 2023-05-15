package com.example.quiz.dialogfragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.R;
import com.example.quiz.userrecord.UserRecord;
import com.example.quiz.userrecord.UserRecordAdapter;
import com.example.quiz.databinding.FragmentScoreUsersSurvivalBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ScoreUsersSurvival extends DialogFragment {

    private FragmentScoreUsersSurvivalBinding binding = null;
    private CollectionReference userRef;
    private List<UserRecord> userRecords = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentScoreUsersSurvivalBinding.inflate(inflater, container, false);

        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.custom_dialog);
        }

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Log.v("UID", uid);
        userRef = FirebaseFirestore.getInstance().collection("users");

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        userRef.addSnapshotListener((querySnapshot, e) -> {
            if (e != null) {
                Log.e("Firebase Firestore", e.getMessage());
                return;
            }
            userRecords.clear();
            for (QueryDocumentSnapshot userSnapshot : querySnapshot) {
                String nickname = userSnapshot.getString("nickname");
                Integer score = userSnapshot.getLong("ScoreSurvival").intValue();
                Log.v("ScoreUser", String.valueOf(score));
                if (score > 0) {
                    userRecords.add(new UserRecord(nickname, score.intValue()));
                }
            }
            userRecords.sort((o1, o2) -> o1.getScore() - o2.getScore());
            Collections.reverse(userRecords);
            recyclerView.setAdapter(new UserRecordAdapter(userRecords));
        });

        return binding.getRoot();
    }
}