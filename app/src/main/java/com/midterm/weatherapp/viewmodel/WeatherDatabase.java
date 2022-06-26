package com.midterm.weatherapp.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.DeleteTable;
import androidx.room.RenameColumn;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.midterm.weatherapp.model.Converters;
import com.midterm.weatherapp.model.Temperature;
import com.midterm.weatherapp.model.Value;
import com.midterm.weatherapp.model.WeatherDailyForecast;
import com.midterm.weatherapp.model.WeatherDailyForecastList;
import com.midterm.weatherapp.model.WeatherDailyForecastPreview;
import com.midterm.weatherapp.model.WeatherHourlyForecast;
import com.midterm.weatherapp.model.Wind;
import com.midterm.weatherapp.model.location.AdministrativeArea;
import com.midterm.weatherapp.model.location.Country;
import com.midterm.weatherapp.model.location.Location;

@Database(entities = {Location.class}
        ,version = 11,
        autoMigrations = {
                @AutoMigration(from =9, to = 11,spec = WeatherDatabase.MyAutoMigration.class)
        }, exportSchema = true
)
@TypeConverters(Converters.class)
public abstract class WeatherDatabase extends RoomDatabase {
    public abstract WeatherDao weatherDao();
    private static WeatherDatabase instance;
    public static WeatherDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    WeatherDatabase.class, "weather-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }




    static class MyAutoMigration implements AutoMigrationSpec { }


}
