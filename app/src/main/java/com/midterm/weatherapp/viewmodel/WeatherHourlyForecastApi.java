package com.midterm.weatherapp.viewmodel;

import com.midterm.weatherapp.model.WeatherCurrent;
import com.midterm.weatherapp.model.WeatherHourlyForecastList;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface WeatherHourlyForecastApi {
    @GET("data/2.5/forecast/hourly?units=metric&q=Danang&appid=74726b09b991473fd7f8ad6dedafa163")
    public Single<WeatherHourlyForecastList> getWeatherHourlyForecastList();
}
