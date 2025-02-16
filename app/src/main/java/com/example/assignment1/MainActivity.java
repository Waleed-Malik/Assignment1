package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText NameEt;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        NameEt = findViewById(R.id.roundedEt);
        startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(v -> {
            String name = NameEt.getText().toString().trim();
            if(name.isEmpty()) {
                NameEt.setError("Name field can't be empty");
            }
            else {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("Username", name);
                startActivity(intent);
            }
        });

    }
}