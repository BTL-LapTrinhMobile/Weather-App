package com.midterm.weatherapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.midterm.weatherapp.R;

import java.io.Serializable;

public class WeatherHourlyForecast implements Serializable {
    @SerializedName("DateTime")
    private String dateTime;
    @SerializedName("WeatherIcon")
    private int weatherIcon;
    @SerializedName("IconPhrase")
    private String iconPhrase;
    @SerializedName("Icon")
    private int icon;
    @SerializedName("Temperature")
    private Temperature temperature;
    @SerializedName("RealFeelTemperature")
    private Value feelTemperature;
    @SerializedName("Wind")
    private Wind wind;
    @SerializedName("RelativeHumidity")
    private int humidity;
    @SerializedName("Visibility")
    private Value visibility;
    @SerializedName("UVIndexText")
    private String uv;
    @SerializedName("RainProbability")
    private int rainProbability;
    @SerializedName("ThunderstormProbability")
    private int thunderstormProbability;
    @SerializedName("SnowProbability")
    private int snowProbability;
    @SerializedName("IceProbability")
    private int iceProbability;
    @SerializedName("Rain")
    private Value rain;
    @SerializedName("Snow")
    private Value snow;
    @SerializedName("Ice")
    private Value ice;
    @SerializedName("CloudCover")
    private int cloudCover;



    public WeatherHourlyForecast() {
    }

    public WeatherHourlyForecast(String dateTime, int weatherIcon, String iconPhrase, int icon, Temperature temperature, Value feelTemperature, Wind wind, int humidity, Value visibility, String uv, int rainProbability, int thunderstormProbability, int snowProbability, int iceProbability, Value rain, Value snow, Value ice, int cloudCover) {
        this.dateTime = dateTime;
        this.weatherIcon = weatherIcon;
        this.iconPhrase = iconPhrase;
        this.icon = icon;
        this.temperature = temperature;
        this.feelTemperature = feelTemperature;
        this.wind = wind;
        this.humidity = humidity;
        this.visibility = visibility;
        this.uv = uv;
        this.rainProbability = rainProbability;
        this.thunderstormProbability = thunderstormProbability;
        this.snowProbability = snowProbability;
        this.iceProbability = iceProbability;
        this.rain = rain;
        this.snow = snow;
        this.ice = ice;
        this.cloudCover = cloudCover;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Value getFeelTemperature() {
        return feelTemperature;
    }

    public void setFeelTemperature(Value feelTemperature) {
        this.feelTemperature = feelTemperature;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Value getVisibility() {
        return visibility;
    }

    public void setVisibility(Value visibility) {
        this.visibility = visibility;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public int getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(int rainProbability) {
        this.rainProbability = rainProbability;
    }

    public int getThunderstormProbability() {
        return thunderstormProbability;
    }

    public void setThunderstormProbability(int thunderstormProbability) {
        this.thunderstormProbability = thunderstormProbability;
    }

    public int getSnowProbability() {
        return snowProbability;
    }

    public void setSnowProbability(int snowProbability) {
        this.snowProbability = snowProbability;
    }

    public int getIceProbability() {
        return iceProbability;
    }

    public void setIceProbability(int iceProbability) {
        this.iceProbability = iceProbability;
    }

    public Value getRain() {
        return rain;
    }

    public void setRain(Value rain) {
        this.rain = rain;
    }

    public Value getSnow() {
        return snow;
    }

    public void setSnow(Value snow) {
        this.snow = snow;
    }

    public Value getIce() {
        return ice;
    }

    public void setIce(Value ice) {
        this.ice = ice;
    }

    public int getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(int cloudCover) {
        this.cloudCover = cloudCover;
    }

    @Override
    public String toString() {
        return "WeatherCurrent{" +
                "dateTime='" + dateTime + '\'' +
                ", weatherIcon=" + weatherIcon +
                ", iconPhrase='" + iconPhrase + '\'' +
                ", temperature=" + temperature +
                ", feelTemperature=" + feelTemperature +
                ", wind=" + wind +
                ", humidity=" + humidity +
                ", visibility=" + visibility +
                ", uv='" + uv + '\'' +
                ", rainProbability=" + rainProbability +
                ", thunderstormProbability=" + thunderstormProbability +
                ", snowProbability=" + snowProbability +
                ", iceProbability=" + iceProbability +
                ", rain=" + rain +
                ", snow=" + snow +
                ", ice=" + ice +
                ", cloudCover=" + cloudCover +
                '}';
    }

    public int convertIcon(int iconNumber)
    {
        switch (iconNumber)
        {
            case 1:
            case 2:
            case 3:
                return R.drawable.weather_icon_123;
            case 4:
            case 5:
            case 6:
            case 20:
            case 21:
            case 23:
                return R.drawable.weather_icon_4_5_6_20_21_23;
            default:
            case 7:
            case 11:
                return R.drawable.weather_icon_7_11;
            case 8:
            case 19:
            case 22:
            case 24:
                return R.drawable.weather_icon_8_19_22_24;
            case 12_43_44:
                return R.drawable.weather_icon_12_43_44;
            case 13:
            case 14:
                return R.drawable.weather_icon_13_14;
            case 15:
                return R.drawable.weather_icon_15;
            case 16:
            case 17:
                return R.drawable.weather_icon_16_17;
            case 18:
                return R.drawable.weather_icon_18_25_26_29;
            case 33:
            case 34:
            case 35:
                return R.drawable.weather_icon_33_34_35;
            case 36:
            case 37:
            case 38:
                return R.drawable.weather_icon_36_37_38;
            case 39:
                return R.drawable.weather_icon_39;
            case 40:
                return R.drawable.weather_icon_40;
            case 41:
            case 42:
                return R.drawable.weather_icon_41_42;

        }
    }
}