package com.midterm.weatherapp.model.location;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Location implements Serializable {

    @ColumnInfo
    @SerializedName("Key")
    private String key;

    @ColumnInfo
    @SerializedName("Type")
    private String type;

    @ColumnInfo
    @SerializedName("LocalizedName")
    private String localizedName;

    @ColumnInfo
    @SerializedName("EnglishName")
    private String englishName;

    @ColumnInfo
    private String idAdministrativeArea;
    @ColumnInfo
    private String idCountry;

    @Ignore
    @SerializedName("Country")
    private Country country;

    @Ignore
    @SerializedName("AdministrativeArea")
    private AdministrativeArea administrativeArea;

    public Location() {
    }

    public Location(String key, String type, String localizedName, String englishName, String idAdministrativeArea, String idCountry, Country country, AdministrativeArea administrativeArea) {
        this.key = key;
        this.type = type;
        this.localizedName = localizedName;
        this.englishName = englishName;
        this.idAdministrativeArea = idAdministrativeArea;
        this.idCountry = idCountry;
        this.country = country;
        this.administrativeArea = administrativeArea;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getIdAdministrativeArea() {
        return idAdministrativeArea;
    }

    public void setIdAdministrativeArea(String idAdministrativeArea) {
        this.idAdministrativeArea = idAdministrativeArea;
    }

    public String getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public AdministrativeArea getAdministrativeArea() {
        return administrativeArea;
    }

    public void setAdministrativeArea(AdministrativeArea administrativeArea) {
        this.administrativeArea = administrativeArea;
    }

    @Override
    public String toString() {
        return "Location{" +
                ", key='" + key + '\'' +
                ", type='" + type + '\'' +
                ", localizedName='" + localizedName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", idAdministrativeArea='" + idAdministrativeArea + '\'' +
                ", idCountry='" + idCountry + '\'' +
                ", country=" + country +
                ", administrativeArea=" + administrativeArea +
                '}';
    }
}
