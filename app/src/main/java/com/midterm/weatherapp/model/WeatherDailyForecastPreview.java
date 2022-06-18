package com.midterm.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WeatherDailyForecastPreview implements Serializable {
    @SerializedName("Text")
    public String weatherPreview;

    public WeatherDailyForecastPreview(String text) {
        this.weatherPreview = text;
    }

    public String getWeatherPreview() {
        return weatherPreview;
    }

    public void setWeatherPreview(String text) {
        this.weatherPreview = text;
    }
}
