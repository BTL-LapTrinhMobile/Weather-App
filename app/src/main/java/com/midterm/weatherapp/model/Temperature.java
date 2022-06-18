package com.midterm.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Temperature implements Serializable {
    @SerializedName("Value")
    private double value;
    @SerializedName("Maximum")
    private Value maximumTemperature;
    @SerializedName("Minimum")
    private Value minimumTemperature;

    public Temperature() {
    }

    public Temperature(double value, Value maximumTemperature, Value minimumTemperature) {
        this.value = value;
        this.maximumTemperature = maximumTemperature;
        this.minimumTemperature = minimumTemperature;
    }

    public Value getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(Value maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    public Value getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(Value minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "value=" + value +
                ", maximumTemperature=" + maximumTemperature +
                ", minimumTemperature=" + minimumTemperature +
                '}';
    }
}
