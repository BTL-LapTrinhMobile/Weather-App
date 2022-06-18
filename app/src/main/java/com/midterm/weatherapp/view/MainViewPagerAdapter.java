package com.midterm.weatherapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.midterm.weatherapp.model.location.Location;

import java.util.ArrayList;


public class MainViewPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Location> locationList;
    public MainViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Location> locationList) {
        super(fragmentManager, lifecycle);
        this.locationList = locationList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(locationList == null || locationList.isEmpty())
            return null;
        else
        {
            MainFragment dff = new MainFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("LOCATION",locationList.get(position));
            dff.setArguments(bundle);
            return dff;
        }
    }

    @Override
    public int getItemCount() {
        if (locationList != null)
            return locationList.size();
        return 0;
    }

}
