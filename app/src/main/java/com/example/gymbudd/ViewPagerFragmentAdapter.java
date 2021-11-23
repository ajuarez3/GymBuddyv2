package com.example.gymbudd;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.gymbudd.Frag1;
import com.example.gymbudd.Frag2;
import com.example.gymbudd.Frag3;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private String[] titles= new String[]{"Friends","Groups", "Trainers"};
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new Frag1();
            case 1:
                return new Frag2();
            case 2:
                return new Frag3();
        }
        return new Frag1();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
