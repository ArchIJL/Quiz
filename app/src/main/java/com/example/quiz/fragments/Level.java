package com.example.quiz.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.example.quiz.R;
import com.example.quiz.databinding.FragmentLevelsBinding;
import com.example.quiz.model.MyViewModel;
import com.example.quiz.model.SettingsViewModel;
import com.example.quiz.questions.QuestionCampaign;

import java.util.ArrayList;
import java.util.Map;


public class Level extends Fragment implements View.OnClickListener {

    private MyViewModel viewModel;
    private SettingsViewModel settingsViewModel;

    private TextView questionTextView;
    private EditText answerEditText;
    private ArrayList<Button> answerButtons;
    private ArrayList<String> originalButtonText;
    private String currentAnswer;
    private String correctAnswer;
    private String buttonText;
    private int questionNumber;
    private String infoAnswer;

    private FragmentLevelsBinding binding = null;

    private ImageButton mInfoButton;
    private PopupWindow mPopupWindow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        settingsViewModel = new ViewModelProvider(requireActivity()).get(SettingsViewModel.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLevelsBinding.inflate(inflater, container, false);

        Toolbar toolbar = binding.toolbar;
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view1 -> requireActivity().onBackPressed());

        FragmentManager fragmentManager = getParentFragmentManager();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        Log.d("BackStack (Level)", "Number of fragments on back stack: " + backStackEntryCount);

        questionTextView = binding.textQuestions;
        answerEditText = binding.editText;

        int categoryId = viewModel.getCategoryId();
        int levelId = viewModel.getLevelId();
        Log.v("LevelId (Level)", String.valueOf(levelId));

        answerButtons = new ArrayList<>();
        answerButtons.add(binding.button1);
        answerButtons.add(binding.button2);
        answerButtons.add(binding.button3);
        answerButtons.add(binding.button4);
        answerButtons.add(binding.button5);
        answerButtons.add(binding.button6);
        answerButtons.add(binding.button7);
        answerButtons.add(binding.button8);
        answerButtons.add(binding.button9);
        answerButtons.add(binding.button10);
        answerButtons.add(binding.button11);
        answerButtons.add(binding.button12);

        viewModel.loadQuestionMap(getContext());
        Log.v("loadQuestionMap", String.valueOf(viewModel.getQuestionMap()));
        Map<String, Map<String, QuestionCampaign>> questionMap = viewModel.getQuestionMap();

        String categorySet = String.format("%03d", categoryId);
        String levelSet = String.format("%03d", levelId);

        QuestionCampaign qc = questionMap.get(categorySet).get(levelSet);
        Log.v("QuestionCampaign", String.valueOf(qc));

        questionTextView.setText(qc.getmText());
        questionNumber = qc.getmQuestionNumber();
        buttonText = qc.getmButtonText();
        correctAnswer = qc.getmCorrectAnswer();
        infoAnswer = qc.getmInfoAnswer();

        mInfoButton = binding.infoButton;
        mInfoButton.setOnClickListener(view -> {
            if (mPopupWindow == null) {
                showPopupWindow(infoAnswer);
            } else {
                hidePopupWindow();
            }
        });

        for (int i = 0; i < answerButtons.size(); i++) {
            answerButtons.get(i).setText(String.valueOf(buttonText.charAt(i)));
        }

        toolbar.setTitle("Уровень " + levelId);
        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));

        if (levelId == 1) {
            binding.toolbarLeftArrow.setVisibility(View.GONE);
        } else if (levelId == 20) {
            binding.toolbarRightArrow.setVisibility(View.GONE);
        }

        if (viewModel.getCompleted(categoryId, levelId)){
            mInfoButton.setVisibility(View.VISIBLE);
        }

        binding.toolbarLeftArrow.setOnClickListener(v -> onMoveBackQuestion());

        binding.toolbarRightArrow.setOnClickListener(v -> onMoveNextQuestion());

        ArrayList<Pair<String, Boolean>> buttonData = viewModel.getButtonData(categoryId, levelId);
        if (buttonData != null) {
            // restore button text and isEnabled state
            for (int i = 0; i < buttonData.size(); i++) {
                Pair<String, Boolean> pair = buttonData.get(i);
                Button button = answerButtons.get(i);
                button.setText(pair.first);
                button.setEnabled(pair.second);
            }
        } else {
            originalButtonText = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                originalButtonText.add(answerButtons.get(i).getText().toString());
                answerButtons.get(i).setEnabled(true);
            }
        }

        for (Button button : answerButtons) {
            button.setOnClickListener(this);
        }

        Button resetButton = binding.resetButton;
        resetButton.setEnabled(viewModel.getResetButtonState(categoryId, levelId));
        resetButton.setOnClickListener(v -> {
            for (Button button : answerButtons) {
                button.setEnabled(true);
            }
            answerEditText.setText("");
            for (int i = 0; i < 12; i++){
                answerButtons.get(i).setText(originalButtonText.get(i));
            }
        });

        answerEditText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(correctAnswer.length())});
        answerEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                currentAnswer = answerEditText.getText().toString();
                if (currentAnswer.length() == correctAnswer.length()) {
                    if (currentAnswer.equalsIgnoreCase(correctAnswer)) {
                        viewModel.setCorrectAnswer(questionNumber, correctAnswer);
                        for (Button button : answerButtons) {
                            button.setEnabled(false);
                        }
                        resetButton.setEnabled(false);

                        ArrayList<Pair<String, Boolean>> buttonData = new ArrayList<>();
                        for (Button button : answerButtons) {
                            buttonData.add(new Pair<>(button.getText().toString(), button.isEnabled()));
                        }
                        viewModel.setResetButtonState(categoryId, levelId, resetButton.isEnabled());
                        viewModel.setButtonData(categoryId, levelId, buttonData);

                        int categoryId = viewModel.getCategoryId();
                        int levelId = viewModel.getLevelId();
                        boolean value = true;
                        viewModel.setCompleted(categoryId, levelId, value);

                        Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                        VibrationEffect vibrationEffect = settingsViewModel.getVibrationEffect();
                        if (vibrationEffect != null && vibrator != null) {
                            vibrator.vibrate(vibrationEffect);
                        }

                        mInfoButton.setVisibility(View.VISIBLE);

                        Toast.makeText(getContext(), "Правильно!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Не правильно!", Toast.LENGTH_SHORT).show();
                        for (Button button : answerButtons) {
                            button.setEnabled(false);
                        }
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return binding.getRoot();
    }

    private void showPopupWindow(String infoAnswer) {
        View popupView = getLayoutInflater().inflate(R.layout.popup_window, null);
        TextView popupText = popupView.findViewById(R.id.popup_text);
        this.infoAnswer = infoAnswer;
        popupText.setText(infoAnswer);

        mPopupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        popupView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        mPopupWindow.setOnDismissListener(() -> mPopupWindow = null);

        int[] location = new int[2];
        mInfoButton.getLocationOnScreen(location);
        mPopupWindow.showAtLocation(mInfoButton, Gravity.TOP, location[0], location[1]);
    }

    private void hidePopupWindow() {
        mPopupWindow.dismiss();
    }

    public void onMoveNextQuestion(){
        int levelId = viewModel.getLevelId();
        viewModel.setLevelId(levelId + 1);
        Navigation.findNavController(getView()).popBackStack();
        NavOptions navOptions = new NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build();
        Navigation.findNavController(requireActivity(), R.id.fragmentContainerView).navigate(R.id.level, null, navOptions);
    }

    public void onMoveBackQuestion(){
        int levelId = viewModel.getLevelId();
        viewModel.setLevelId(levelId - 1);
        Navigation.findNavController(getView()).popBackStack();
        NavOptions navOptions = new NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_left)
                .setExitAnim(R.anim.slide_out_right)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build();
        Navigation.findNavController(requireActivity(), R.id.fragmentContainerView).navigate(R.id.level, null, navOptions);
    }

    @Override
    public void onClick(View view) {
        if (view instanceof Button) {
            Button button = (Button) view;
            String buttonText = button.getText().toString();
            String currentAnswer = answerEditText.getText().toString();
            if (currentAnswer.length() < correctAnswer.length()){
                answerEditText.setText(currentAnswer + buttonText);
            }
            ((Button) view).setText("");
            view.setEnabled(false);
        }
    }
}