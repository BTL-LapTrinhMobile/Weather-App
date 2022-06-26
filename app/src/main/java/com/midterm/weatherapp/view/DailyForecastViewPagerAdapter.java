package com.midterm.weatherapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.midterm.weatherapp.model.WeatherDailyForecast;

import java.util.ArrayList;

public class DailyForecastViewPagerAdapter extends FragmentStateAdapter {
    private ArrayList<WeatherDailyForecast> weatherDailyForecastList;

    public DailyForecastViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<WeatherDailyForecast> weatherDailyForecastList) {
        super(fragmentManager, lifecycle);
        this.weatherDailyForecastList = weatherDailyForecastList;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(weatherDailyForecastList == null || weatherDailyForecastList.isEmpty())
            return null;
        else
        {
            DailyForecastFragment dff = new DailyForecastFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("WEATHER_DAILY_FORECAST",weatherDailyForecastList.get(position));
            dff.setArguments(bundle);

            return dff;
        }
    }

    @Override
    public int getItemCount() {
        if (weatherDailyForecastList != null)
            return weatherDailyForecastList.size();
        return 0;
    }
}
