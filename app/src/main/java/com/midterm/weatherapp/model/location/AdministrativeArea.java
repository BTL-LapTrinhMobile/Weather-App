package com.midterm.weatherapp.model.location;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class AdministrativeArea implements Serializable {
    @SerializedName("ID")
    private String idAdministrativeArea;
    @SerializedName("LocalizedName")
    private String localizedName;
    @SerializedName("EnglishName")
    private String englishName;

    public AdministrativeArea() {
    }

    public AdministrativeArea(String idAdministrativeArea, String localizedName, String englishName) {
        this.idAdministrativeArea = idAdministrativeArea;
        this.localizedName = localizedName;
        this.englishName = englishName;
    }

    public String getIdAdministrativeArea() {
        return idAdministrativeArea;
    }

    public void setIdAdministrativeArea(String idAdministrativeArea) {
        this.idAdministrativeArea = idAdministrativeArea;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getEnglishName() {
        return this.englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @Override
    public String toString() {
        return "AdministrativeArea{" +
                "idAdministrativeArea='" + idAdministrativeArea + '\'' +
                ", localizedName='" + localizedName + '\'' +
                ", englishName='" + englishName + '\'' +
                '}';
    }
}