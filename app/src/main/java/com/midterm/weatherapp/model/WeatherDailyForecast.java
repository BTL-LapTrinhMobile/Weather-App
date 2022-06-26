package com.midterm.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WeatherDailyForecast implements Serializable {
    @SerializedName("Date")
    private String date;
    @SerializedName("Temperature")
    private Temperature temperature;
    @SerializedName("Day")
    private WeatherHourlyForecast day;
    @SerializedName("Night")
    private WeatherHourlyForecast night;



    public WeatherDailyForecast() {
    }

    public WeatherDailyForecast(String date, Temperature temperature, WeatherHourlyForecast day, WeatherHourlyForecast night) {
        this.date = date;
        this.temperature = temperature;
        this.day = day;
        this.night = night;

    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public WeatherHourlyForecast getDay() {
        return day;
    }

    public void setDay(WeatherHourlyForecast day) {
        this.day = day;
    }

    public WeatherHourlyForecast getNight() {
        return night;
    }

    public void setNight(WeatherHourlyForecast night) {
        this.night = night;
    }

    @Override
    public String toString() {
        return "WeatherDailyForecast{" +
                "date='" + date + '\'' +
                ", temperature=" + temperature +
                ", day=" + day +
                ", night=" + night +
                '}';
    }
}