package com.midterm.weatherapp.viewmodel;

import com.midterm.weatherapp.model.Temperature;
import com.midterm.weatherapp.model.WeatherCurrent;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface WeatherCurrentApi {
    @GET("data/2.5/weather?units=metric&q=Danang&appid=74726b09b991473fd7f8ad6dedafa163")
    public Single<WeatherCurrent> getWeatherCurrent();
}
