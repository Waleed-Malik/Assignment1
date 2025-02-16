package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    ImageView Logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        Logo = findViewById(R.id.logoimg);

        // Load Fade In Animation
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Logo.startAnimation(fadeIn);

        // Handler for Fade Out Delay
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
            Logo.startAnimation(fadeOut);

            // After fade-out, move to MainActivity
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }, 1000); // Delay same as fade-out duration

        }, 2000); // Wait 2 seconds after fade-in

    }
}