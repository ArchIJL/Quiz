package com.example.quiz.userrecord;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.R;

import java.util.List;

public class UserRecordAdapter extends RecyclerView.Adapter<UserRecordAdapter.ViewHolder> {

    private List<UserRecord> userRecords;

    public UserRecordAdapter(List<UserRecord> userRecords) {
        this.userRecords = userRecords;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView positionTextView;
        private TextView nicknameTextView;
        private TextView scoreTextView;

        public ViewHolder(View view) {
            super(view);
            positionTextView = view.findViewById(R.id.positionTextView);
            nicknameTextView = view.findViewById(R.id.nicknameTextView);
            scoreTextView = view.findViewById(R.id.scoreTextView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_record, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserRecord userRecord = userRecords.get(position);
        holder.positionTextView.setText(String.valueOf(position + 1));
        holder.nicknameTextView.setText(userRecord.getNickname());
        holder.scoreTextView.setText(String.valueOf(userRecord.getScore()));
    }

    @Override
    public int getItemCount() {
        return userRecords.size();
    }
}
