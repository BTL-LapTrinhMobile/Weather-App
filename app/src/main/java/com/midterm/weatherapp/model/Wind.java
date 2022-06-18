package com.midterm.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Wind implements Serializable {
    @SerializedName("Speed")
    private Value speed;

    public Wind(Value speed) {
        this.speed = speed;
    }

    public Value getSpeed() {
        return speed;
    }

    public void setSpeed(Value speed) {
        this.speed = speed;
    }
}
