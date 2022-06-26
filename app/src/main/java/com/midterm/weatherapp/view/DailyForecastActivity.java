package com.midterm.weatherapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.midterm.weatherapp.MainActivity;
import com.midterm.weatherapp.R;
import com.midterm.weatherapp.databinding.ActivityDailyForecastBinding;
import com.midterm.weatherapp.model.WeatherDailyForecast;
import com.midterm.weatherapp.model.WeatherDailyForecastPreview;
import com.midterm.weatherapp.model.location.Location;

import java.util.ArrayList;

public class DailyForecastActivity extends AppCompatActivity {
    private ActivityDailyForecastBinding binding;
    private ArrayList<WeatherDailyForecast> weatherDailyForecastList = new ArrayList<>();
    private WeatherDailyForecastPreview weatherDailyForecastPreview;
    private DailyForecastViewPagerAdapter VPAdapter;
    private Location location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.activity_daily_forecast,null, false);
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        weatherDailyForecastList = (ArrayList<WeatherDailyForecast>) bundle.getSerializable("WEATHER_DAILY_FORECAST_LIST");
        weatherDailyForecastPreview = (WeatherDailyForecastPreview) bundle.getSerializable("WEATHER_DAILY_FORECAST_PREVIEW") ;
        location = (Location)  bundle.getSerializable("LOCATION");
        binding.setWeatherDailyForecastPreview(weatherDailyForecastPreview);
        VPAdapter = new DailyForecastViewPagerAdapter(getSupportFragmentManager(), getLifecycle(),weatherDailyForecastList);
        binding.vpDailyForecast.setAdapter(VPAdapter);
        binding.tvCityName.setText(location.getLocalizedName()+", "+location.getCountry().getIdCountry());


    }
}