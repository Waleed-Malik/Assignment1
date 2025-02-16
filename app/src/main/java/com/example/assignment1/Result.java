package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Result extends AppCompatActivity {

    private TextView userNameText, scoreText;
    private Button shareButton;
    private ImageButton backButton;
    private String userName;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Initializing views
        userNameText = findViewById(R.id.userName);
        scoreText = findViewById(R.id.scoreText);
        shareButton = findViewById(R.id.shareScoreButton);
        backButton = findViewById(R.id.backButton);

        // Getting data from Intent
        Intent intent = getIntent();
        userName = intent.getStringExtra("Username");
        score = intent.getIntExtra("correct_answers", 0);

        // Displaying received name and score
        userNameText.setText(userName);
        scoreText.setText(score + "/10");

        // Share button functionality
        shareButton.setOnClickListener(v -> shareScore());

        // Back button functionality
        backButton.setOnClickListener(v -> goToMainScreen());
    }

    // Function to share score via WhatsApp, Gmail, etc.
    private void shareScore() {
        String shareMessage = "I scored " + score + "/10 in the quiz! 🎉 - " + userName;
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }

    private void goToMainScreen() {
        score = 0;  // Reset score
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}