package com.midterm.weatherapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Value implements Serializable {
    @SerializedName("Value")
    private Double value;
    @SerializedName("Unit")
    private String unit;
    public Value() {
    }

    public Value(Double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }
}
