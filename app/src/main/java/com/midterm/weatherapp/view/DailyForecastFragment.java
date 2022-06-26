package com.midterm.weatherapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.midterm.weatherapp.R;
import com.midterm.weatherapp.databinding.FragmentDailyForecastBinding;
import com.midterm.weatherapp.model.WeatherDailyForecast;

public class DailyForecastFragment extends Fragment {
    private WeatherDailyForecast weatherDailyForecast;
    private FragmentDailyForecastBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            weatherDailyForecast =(WeatherDailyForecast) getArguments().getSerializable("WEATHER_DAILY_FORECAST");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_daily_forecast,null, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(weatherDailyForecast != null)
        {
            binding.setWeatherDailyForecast(weatherDailyForecast);
            binding.iconDay.setImageResource(weatherDailyForecast.getDay().convertIcon(weatherDailyForecast.getDay().getIcon()));
            binding.iconNight.setImageResource(weatherDailyForecast.getNight().convertIcon(weatherDailyForecast.getNight().getIcon()));


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date convertedCurrentDate = sdf.parse((weatherDailyForecast.getDate()).substring(0,10));
                String date= new SimpleDateFormat("EEEE").format(convertedCurrentDate);

                binding.tvDate.setText(convertVN(date)+", "+(weatherDailyForecast.getDate()).substring(5,10));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }
    public String convertVN(String eng)
    {
        switch(eng)
        {
            case "Sunday":
                return "Chủ nhật";
            case "Monday":
                return "Thứ hai";
            case "Tuesday":
                return "Thứ ba";
            case "Wednesday":
                return "Thứ tư";
            case "Thursday":
                return "Thứ năm";
            case "Friday":
                return "Thứ sáu";
            case "Saturday":
                return "Thứ bảy";
            default:
                return eng;
        }
    }
}