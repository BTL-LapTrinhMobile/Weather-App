package com.midterm.weatherapp.viewmodel;

import com.midterm.weatherapp.model.WeatherDailyForecastList;
import com.midterm.weatherapp.model.WeatherHourlyForecast;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherApi {
    //Duy xuyen : 425992
    //352954
//    String CITY_KEY ="425992";
    String API_KEY ="nAKc9E820HxL0BUM1QDcj67hL4AcXfWk";


    @GET("/forecasts/v1/hourly/12hour/{key}?apikey="+API_KEY+"&language=vi&details=true&metric=true")
    public Call<List<WeatherHourlyForecast>> getWeatherHourlyForecast(@Path("key") String cityKey);

    @GET("/forecasts/v1/daily/5day/{key}?apikey="+API_KEY+"&language=vi&details=true&metric=true")
    public Single<WeatherDailyForecastList> getWeatherDailyForecastList(@Path("key") String cityKey);

}
