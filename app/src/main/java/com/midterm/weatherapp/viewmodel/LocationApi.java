package com.midterm.weatherapp.viewmodel;

import com.midterm.weatherapp.model.location.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LocationApi {

    String API_KEY ="qGaBGMaAYXF5GWA1nUdjF5Bg1Zm7OnKl";

    @GET("/locations/v1/cities/autocomplete?apikey="+API_KEY)
    public Call<List<Location>> getLocationByName(@Query("q") String locationName);


    @GET("/locations/v1/cities/geoposition/search?apikey="+API_KEY)
    public Call<Location> getLocationByLonLat(@Query("q") String locationLonLat);
}
