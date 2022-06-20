package com.midterm.weatherapp.viewmodel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.midterm.weatherapp.model.Temperature;
import com.midterm.weatherapp.model.Value;
import com.midterm.weatherapp.model.WeatherDailyForecastList;
import com.midterm.weatherapp.model.WeatherHourlyForecast;
import com.midterm.weatherapp.model.location.AdministrativeArea;
import com.midterm.weatherapp.model.location.Country;
import com.midterm.weatherapp.model.location.Location;

import java.util.List;

@Dao
public interface WeatherDao {

    @Query("SELECT * FROM Location")
    List<Location> getAllLocation();
    @Query("SELECT * FROM Location WHERE `key`=:key")
    Location getLocationByKey(String key);
    @Insert
    void insertLocation(Location... locations);
    @Delete
    void deleteLocation(Location... locations);
    @Update
    void updateLocation(Location location);

}
