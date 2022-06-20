package com.midterm.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.midterm.weatherapp.databinding.ActivityMainBinding;
import com.midterm.weatherapp.model.Temperature;
import com.midterm.weatherapp.model.Value;
import com.midterm.weatherapp.model.WeatherDailyForecast;
import com.midterm.weatherapp.model.location.AdministrativeArea;
import com.midterm.weatherapp.model.location.Country;
import com.midterm.weatherapp.model.location.Location;
import com.midterm.weatherapp.view.MainViewPagerAdapter;
import com.midterm.weatherapp.view.SearchLocationActivity;
import com.midterm.weatherapp.viewmodel.ApiService;
import com.midterm.weatherapp.viewmodel.WeatherDao;
import com.midterm.weatherapp.viewmodel.WeatherDatabase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;
    private ActivityMainBinding binding;
    private ArrayList<Location> locationList;
    private MainViewPagerAdapter VPAdapter;
    private WeatherDatabase weatherDatabase;
    private WeatherDao weatherDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        apiService = ApiService.getInstance();
        locationList = new ArrayList<>();

        weatherDatabase = WeatherDatabase.getInstance(this);
        weatherDao = weatherDatabase.weatherDao();
        locationList = getLocation(weatherDao);


        binding.btnSearchLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchLocationActivity.class);
                startActivity(intent);
            }
        });

        if(locationList != null && !locationList.isEmpty())
        {
            VPAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), getLifecycle(),locationList);
            binding.vpMain.setAdapter(VPAdapter);
        }
        else
        {


        }

    }

    public ArrayList<Location> getLocation(WeatherDao weatherDao)
    {
        try {
            return (ArrayList<Location>) weatherDao.getAllLocation();
        }
        catch (Exception e)
        {
            return null;
        }
    }
}