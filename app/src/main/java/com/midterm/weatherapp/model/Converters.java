package com.midterm.weatherapp.model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.midterm.weatherapp.model.location.AdministrativeArea;
import com.midterm.weatherapp.model.location.Country;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {
    @TypeConverter
    public static ArrayList<Integer> fromString(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayListInteger(ArrayList<Integer> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static AdministrativeArea fromStringAdministrativeArea(String value) {
        Type type = new TypeToken<AdministrativeArea>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromAdministrativeArea(AdministrativeArea value) {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return json;
    }

    @TypeConverter
    public static Country fromStringCountry(String value) {
        Type type = new TypeToken<Country>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromCountry(Country value) {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return json;
    }

    @TypeConverter
    public static Value fromStringValue(String value) {
        Type type = new TypeToken<Value>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromValue(Value value) {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return json;
    }

    @TypeConverter
    public static Temperature fromStringTemperature(String value) {
        Type type = new TypeToken<Temperature>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromTemperature(Temperature value) {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return json;
    }

    @TypeConverter
    public static Wind fromStringWind(String Wind) {
        Type type = new TypeToken<WeatherDailyForecast>() {}.getType();
        return new Gson().fromJson(Wind, type);
    }

    @TypeConverter
    public static String fromWind(Wind value) {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return json;
    }

    @TypeConverter
    public static WeatherHourlyForecast fromStringHourlyForecast(String value) {
        Type type = new TypeToken<WeatherHourlyForecast>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromHourlyForecast(WeatherHourlyForecast value) {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return json;
    }

    @TypeConverter
    public static WeatherDailyForecast fromStringDailyForecast(String value) {
        Type type = new TypeToken<WeatherDailyForecast>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromDailyForecast(WeatherDailyForecast value) {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return json;
    }

    @TypeConverter
    public static ArrayList<WeatherDailyForecast> fromStringArrayDailyForecast(String value) {
        Type type = new TypeToken<ArrayList<WeatherDailyForecast>>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromArrayDailyForecast(ArrayList<WeatherDailyForecast> value) {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return json;
    }

    @TypeConverter
    public static WeatherDailyForecastPreview fromStringWeatherDailyForecastPreview(String value) {
        Type type = new TypeToken<WeatherDailyForecastPreview>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromWeatherDailyForecastPreview(WeatherDailyForecastPreview value) {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return json;
    }

    @TypeConverter
    public static WeatherDailyForecastList fromStringWeatherDailyForecastList(String value) {
        Type type = new TypeToken<WeatherDailyForecastList>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromWeatherDailyForecastList(WeatherDailyForecastList value) {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return json;
    }

    @TypeConverter
    public static ArrayList<WeatherHourlyForecast> fromStringArrayHourlyForecast(String value) {
        Type type = new TypeToken<ArrayList<WeatherHourlyForecast>>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromArrayHourlyForecast(ArrayList<WeatherHourlyForecast> value) {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return json;
    }


}