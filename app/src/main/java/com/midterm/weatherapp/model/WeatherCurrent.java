package com.midterm.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherCurrent {
    @SerializedName("base")
    private String base;
    @SerializedName("main")
    private Temperature temperature;
    @SerializedName("weather")
    private ArrayList<WeatherPreview> weatherPreviewList;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("clouds")
    private Clouds clouds;

    public WeatherCurrent(String base, Temperature temperature, ArrayList<WeatherPreview> weatherPreviewList, Wind wind, Clouds clouds) {
        this.base = base;
        this.temperature = temperature;
        this.weatherPreviewList = weatherPreviewList;
        this.wind = wind;
        this.clouds = clouds;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public ArrayList<WeatherPreview> getWeatherPreview() {
        return weatherPreviewList;
    }

    public void setWeatherPreview(ArrayList<WeatherPreview> weatherPreviewList) {
        this.weatherPreviewList = weatherPreviewList;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    @Override
    public String toString() {
        return "WeatherCurrent{" +
                "base='" + base + '\'' +
                ", temperature=" + temperature +
                ", weatherPreview=" + weatherPreviewList.toString() +
                ", wind=" + wind +
                ", clouds=" + clouds +
                '}';
    }
}
