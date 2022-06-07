package com.midterm.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherHourlyForecast {
    @SerializedName("main")
    private Temperature temperature;
    @SerializedName("weather")
    private ArrayList<WeatherPreview> weatherPreviewList;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("dt_txt")
    private String time;

    public WeatherHourlyForecast(Temperature temperature, ArrayList<WeatherPreview> weatherPreviewList, Clouds clouds, Wind wind, String time) {
        this.temperature = temperature;
        this.weatherPreviewList = weatherPreviewList;
        this.clouds = clouds;
        this.wind = wind;
        this.time = time;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public ArrayList<WeatherPreview> getWeatherPreviewList() {
        return weatherPreviewList;
    }

    public void setWeatherPreviewList(ArrayList<WeatherPreview> weatherPreviewList) {
        this.weatherPreviewList = weatherPreviewList;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "WeatherHourlyForecast{" +
                "temperature=" + temperature +
                ", weatherPreviewList=" + weatherPreviewList +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", time='" + time + '\'' +
                '}';
    }
}
