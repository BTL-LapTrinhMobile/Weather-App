package com.midterm.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.midterm.weatherapp.databinding.ActivityMainBinding;
import com.midterm.weatherapp.model.Temperature;
import com.midterm.weatherapp.model.WeatherCurrent;
import com.midterm.weatherapp.viewmodel.ApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;
    private ArrayList<Temperature> temperatureList;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.activity_main,null, false);
        setContentView(binding.getRoot());

        temperatureList = new ArrayList<>();
        apiService = new ApiService();
        apiService.getWeatherCurrent()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<WeatherCurrent>() {
                    @Override
                    public void onSuccess(@NonNull WeatherCurrent weatherCurrent) {
                        Log.e("DEBUG", weatherCurrent.getTemperature().toString()+"");
                        Log.e("DEBUG", weatherCurrent.getWind().toString()+"");
                        Log.e("DEBUG", weatherCurrent.getWeatherPreview().toString()+"");

                        binding.setWeatherCurrent(weatherCurrent);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("DEBUG", e.toString());
                    }
                });

    }
}