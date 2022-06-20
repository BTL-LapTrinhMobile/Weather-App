package com.midterm.weatherapp.viewmodel;

import com.midterm.weatherapp.model.WeatherDailyForecastList;
import com.midterm.weatherapp.model.WeatherHourlyForecast;
import com.midterm.weatherapp.model.location.Location;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static final String BASE_URL="http://dataservice.accuweather.com";
    private WeatherApi weatherApi;
    private LocationApi locationApi;

    private static ApiService instance;
    public static ApiService getInstance()
    {
        if(instance == null)
        {
            instance =new ApiService();
        }
        return instance;
    }

    public ApiService()
    {
        locationApi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(LocationApi.class);

        weatherApi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(WeatherApi.class);
    }

    public Call<List<Location>> getLocationByName(String locationName){
        return locationApi.getLocationByName(locationName);
    }

    public Call<List<WeatherHourlyForecast>> getWeatherHourlyForecast(String cityKey)
    {
        return weatherApi.getWeatherHourlyForecast(cityKey);
    }

    public Single<WeatherDailyForecastList> getWeatherDailyForecastList(String cityKey)
    {
        return weatherApi.getWeatherDailyForecastList(cityKey);
    }


    public Call<Location> getLocationByLonLat(String locationLonLat){
        return locationApi.getLocationByLonLat(locationLonLat);
    }

}
