package com.example.gymbudd;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gymbudd.ui.main.SectionsPagerAdapter;
import com.example.gymbudd.databinding.ActivityMessageInboxBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MessageInboxActivity extends AppCompatActivity {

    //private ActivityMessageInboxBinding binding;
    ViewPagerFragmentAdapter viewPagerFragmentAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    private String[] titles= new String[]{"Friends","Groups", "Trainers"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_message_inbox);

        getSupportActionBar();


        tabLayout=findViewById(R.id.tab_layout);
        viewPager2=findViewById(R.id.view_pager);



        viewPagerFragmentAdapter=new ViewPagerFragmentAdapter(this);

        viewPager2.setAdapter(viewPagerFragmentAdapter);
        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) ->tab.setText(titles[position]))).attach();


    }
}