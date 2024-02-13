package com.example.beautyhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.beautyhub.databinding.ActivityMainBinding;

public class OnboardingActivity extends AppCompatActivity  {

    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new OnboardingPagerAdapter(this));

        Button btnSkip = findViewById(R.id.btn_skip);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = viewPager.getCurrentItem() + 1;
                if (nextPage < viewPager.getAdapter().getItemCount()) {
                    viewPager.setCurrentItem(nextPage);
                } else {
                    navigateToMain();
                }
            }
        });
    }

    private void navigateToMain() {
        Intent intent = new Intent(OnboardingActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private static class OnboardingPagerAdapter extends FragmentStateAdapter {
        private static final int NUM_PAGES = 4;

        public OnboardingPagerAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new OnboardingFragment1();
                case 1:
                    return new OnboardingFragment2();
                case 2:
                    return new OnboardingFragment3();
                case 3:
                    return new OnboardingFragment4();
                default:
                    throw new IllegalArgumentException("Invalid position: " + position);
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}
