package com.example.beautyhub;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class OnboardingPagerAdapter extends FragmentStateAdapter {

    private static final int pagecount = 4;

    public OnboardingPagerAdapter(@NonNull FragmentManager fragmentManager,@NonNull Lifecycle lifecycle) {
        super(fragmentManager,lifecycle);
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
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return pagecount;
    }
}
