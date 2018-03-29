package com.santamaria.youtubeappdemo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.santamaria.youtubeappdemo.Fragments.ChannelFragment;
import com.santamaria.youtubeappdemo.Fragments.LifeFragment;
import com.santamaria.youtubeappdemo.Fragments.PlaylistFragment;

/**
 * Created by Santamaria on 27/03/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int numberOfTabs;

    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {


        switch (position){
            case 0:
                return new ChannelFragment();
            case 1:
                return new PlaylistFragment();
            case 2:
                return new LifeFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
