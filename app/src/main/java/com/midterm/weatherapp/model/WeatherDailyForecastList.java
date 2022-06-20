package com.midterm.weatherapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
public class WeatherDailyForecastList implements Serializable {

    @SerializedName("DailyForecasts")
    private ArrayList<WeatherDailyForecast> weatherDailyForecastArrayList;

    @SerializedName("Headline")
    private WeatherDailyForecastPreview preview;

    public WeatherDailyForecastList(ArrayList<WeatherDailyForecast> weatherDailyForecastArrayList, WeatherDailyForecastPreview preview) {
        this.weatherDailyForecastArrayList = weatherDailyForecastArrayList;
        this.preview = preview;
    }

    public ArrayList<WeatherDailyForecast> getWeatherDailyForecastArrayList() {
        return weatherDailyForecastArrayList;
    }

    public void setWeatherDailyForecastArrayList(ArrayList<WeatherDailyForecast> weatherDailyForecastArrayList) {
        this.weatherDailyForecastArrayList = weatherDailyForecastArrayList;
    }

    public WeatherDailyForecastPreview getPreview() {
        return preview;
    }

    public void setPreview(WeatherDailyForecastPreview preview) {
        this.preview = preview;
    }

}