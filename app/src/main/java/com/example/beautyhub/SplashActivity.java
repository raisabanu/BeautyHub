package com.example.beautyhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logoImageView = findViewById(R.id.logoImgView);

        // Load the animation
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Set the animation listener to start the next activity when animation ends
        fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                // Start the next activity (e.g., MainActivity)
                startActivity(new Intent(SplashActivity.this, OnboardingActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        logoImageView.startAnimation(fadeInAnimation);
        logoImageView.setVisibility(View.VISIBLE);
    }
}
