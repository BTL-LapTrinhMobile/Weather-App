package com.midterm.weatherapp.model.location;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


@Entity
public class AdministrativeArea implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
