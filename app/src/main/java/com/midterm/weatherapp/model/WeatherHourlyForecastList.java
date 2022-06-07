package com.midterm.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherHourlyForecastList {
    @SerializedName("list")
    private ArrayList<WeatherHourlyForecast> weatherHourlyForecastList;

    public WeatherHourlyForecastList(ArrayList<WeatherHourlyForecast> weatherHourlyForecastList) {
        this.weatherHourlyForecastList = weatherHourlyForecastList;
    }

    public ArrayList<WeatherHourlyForecast> getWeatherHourlyForecastList() {
        return weatherHourlyForecastList;
    }

    public void setWeatherHourlyForecastList(ArrayList<WeatherHourlyForecast> weatherHourlyForecastList) {
        this.weatherHourlyForecastList = weatherHourlyForecastList;
    }
}
