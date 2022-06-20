package com.midterm.weatherapp.model.location;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Country implements Serializable {
    @SerializedName("ID")
    private String idCountry;
    @SerializedName("LocalizedName")
    private String localizedName;
    @SerializedName("EnglishName")
    private String englishName;

    public Country(String idCountry, String localizedName, String englishName) {
        this.idCountry = idCountry;
        this.localizedName = localizedName;
        this.englishName = englishName;
    }
    public Country(){}


    @NonNull
    public String getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(@NonNull String idCountry) {
        this.idCountry = idCountry;
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
}
