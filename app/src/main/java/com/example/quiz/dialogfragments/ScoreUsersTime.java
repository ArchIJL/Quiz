package com.example.quiz.dialogfragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.R;
import com.example.quiz.userrecord.UserRecord;
import com.example.quiz.userrecord.UserRecordAdapter;
import com.example.quiz.databinding.FragmentScoreUsersTimeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreUsersTime extends DialogFragment {

    private FragmentScoreUsersTimeBinding binding = null;
    private CollectionReference userRef;
    private List<UserRecord> userRecords = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentScoreUsersTimeBinding.inflate(inflater, container, false);

        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.custom_dialog);
        }

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Log.v("UID", uid);
        userRef = FirebaseFirestore.getInstance().collection("users");

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        userRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot querySnapshot, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.e("Firebase Firestore", e.getMessage());
                    return;
                }
                userRecords.clear();
                for (QueryDocumentSnapshot userSnapshot : querySnapshot) {
                    String nickname = userSnapshot.getString("nickname");
                    Integer score = userSnapshot.getLong("ScoreTime").intValue();
                    Log.v("ScoreUser", String.valueOf(score));
                    if (score > 0) {
                        userRecords.add(new UserRecord(nickname, score.intValue()));
                    }
                }
                userRecords.sort((o1, o2) -> o1.getScore() - o2.getScore());
                Collections.reverse(userRecords);
                recyclerView.setAdapter(new UserRecordAdapter(userRecords));
            }
        });

        return binding.getRoot();
    }
}