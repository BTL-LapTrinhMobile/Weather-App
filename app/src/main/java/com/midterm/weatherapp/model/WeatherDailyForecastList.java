package com.midterm.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class WeatherDailyForecastList implements Serializable {
    @SerializedName("DailyForecasts")
    private ArrayList<WeatherDailyForecast> weatherDailyForecastList;

    @SerializedName("Headline")
    private WeatherDailyForecastPreview preview;

    public WeatherDailyForecastList(ArrayList<WeatherDailyForecast> weatherDailyForecastList, WeatherDailyForecastPreview preview) {
        this.weatherDailyForecastList = weatherDailyForecastList;
        this.preview = preview;
    }

    public ArrayList<WeatherDailyForecast> getWeatherDailyForecastList() {
        return weatherDailyForecastList;
    }

    public void setWeatherDailyForecastList(ArrayList<WeatherDailyForecast> weatherDailyForecastList) {
        this.weatherDailyForecastList = weatherDailyForecastList;
    }

    public WeatherDailyForecastPreview getPreview() {
        return preview;
    }

    public void setPreview(WeatherDailyForecastPreview preview) {
        this.preview = preview;
    }
}
