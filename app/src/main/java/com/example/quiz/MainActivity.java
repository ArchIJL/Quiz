package com.example.quiz;


import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.quiz.model.MyViewModel;

public class MainActivity extends AppCompatActivity {

    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.loadData(this);
        viewModel.loadButtonData(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        viewModel.saveData(this);
        viewModel.saveButtonData(this);
    }

}