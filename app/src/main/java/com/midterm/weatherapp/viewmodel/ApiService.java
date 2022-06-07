package com.midterm.weatherapp.viewmodel;

import com.midterm.weatherapp.model.Temperature;
import com.midterm.weatherapp.model.WeatherCurrent;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static final String BASE_URL="https://api.openweathermap.org";
    private WeatherCurrentApi api;

    public ApiService()
    {
        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(WeatherCurrentApi.class);
    }

    public Single<WeatherCurrent> getWeatherCurrent()
    {
        return api.getWeatherCurrent();
    }

}
