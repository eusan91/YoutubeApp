package com.santamaria.youtubeappdemo.View;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.santamaria.youtubeappdemo.R;
import com.santamaria.youtubeappdemo.ViewModel.MainActivityViewModel;
import com.santamaria.youtubeappdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MainActivityViewModel();

        binding.setViewModel(viewModel);

        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));

        setTabLayout();
        setPagerAdapter();

    }

    private void setPagerAdapter() {

        PagerAdapter pagerAdapter = new com.santamaria.youtubeappdemo.Adapter.PagerAdapter(getSupportFragmentManager(), binding.tabLayout.getTabCount());
        binding.viewPager.setAdapter(pagerAdapter);
        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));

    }

    private void setTabLayout() {

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.channel_tab));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.playlist_tab));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.life_tab));

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                binding.viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
