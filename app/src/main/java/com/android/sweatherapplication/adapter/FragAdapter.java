package com.android.sweatherapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.android.sweatherapplication.WeatherFragment;

import java.util.List;

public class FragAdapter extends FragmentStatePagerAdapter {
    private List<WeatherFragment> weatherFragments;
    public FragAdapter(FragmentManager fm,List<WeatherFragment> weatherFragmentList) {
        super(fm);
        weatherFragments = weatherFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return weatherFragments.get(position);
    }

    @Override
    public int getCount() {
        return weatherFragments == null ? 0 : weatherFragments.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
