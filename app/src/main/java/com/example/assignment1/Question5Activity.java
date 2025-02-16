package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Question5Activity extends AppCompatActivity {

    private RadioButton option1, option2, option3, option4;
    private Button nextBtn, prevBtn;
    private String userName;
    private int correctAnswersCount;
    private final int correctAnswerId = R.id.option3; // Update per question
    private boolean isAnswered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextBtn = findViewById(R.id.nextBtn);
        prevBtn = findViewById(R.id.prevBtn);

        // Get user data
        userName = getIntent().getStringExtra("Username");
        correctAnswersCount = getIntent().getIntExtra("correct_answers", 0);

        option1.setOnClickListener(v -> checkAnswer(option1));
        option2.setOnClickListener(v -> checkAnswer(option2));
        option3.setOnClickListener(v -> checkAnswer(option3));
        option4.setOnClickListener(v -> checkAnswer(option4));

        nextBtn.setOnClickListener(v -> goToNextQuestion());
        prevBtn.setOnClickListener(v -> goToPreviousQuestion());
    }

    private void checkAnswer(RadioButton selectedOption) {
        if (isAnswered) return;

        isAnswered = true;
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);

        if (selectedOption.getId() == correctAnswerId) {
            correctAnswersCount++;
            selectedOption.setBackgroundResource(R.drawable.bg_correct);
        } else {
            selectedOption.setBackgroundResource(R.drawable.bg_wrong);
            findViewById(correctAnswerId).setBackgroundResource(R.drawable.bg_correct);
        }

        nextBtn.setEnabled(true);
    }

    private void goToNextQuestion() {
        Intent intent = new Intent(this, Question6Activity.class);
        intent.putExtra("Username", userName);
        intent.putExtra("correct_answers", correctAnswersCount);
        startActivity(intent);
        finish();
    }

    private void goToPreviousQuestion() {
        Intent intent = new Intent(this, Question4Activity.class);
        intent.putExtra("Username", userName);
        intent.putExtra("correct_answers", correctAnswersCount);
        startActivity(intent);
        finish();
    }
}