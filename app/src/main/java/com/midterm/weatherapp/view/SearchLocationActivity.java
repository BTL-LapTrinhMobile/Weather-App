package com.midterm.weatherapp.view;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.midterm.weatherapp.databinding.ActivitySearchLocationBinding;
import com.midterm.weatherapp.model.location.Location;
import com.midterm.weatherapp.viewmodel.ApiService;
import com.midterm.weatherapp.viewmodel.WeatherDatabase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchLocationActivity extends AppCompatActivity {
    private ActivitySearchLocationBinding binding;
    private ArrayList<Location> locationList, locationListDB;
    private SearchLocationAdapter adapter, adapterDB;
    private ApiService apiService;
    private FusedLocationProviderClient fusedLocationClient ;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fusedLocationClient = LocationServices.getFusedLocationProviderClient( this );

        apiService = new ApiService();
        locationList = new ArrayList<>();


        locationListDB = new ArrayList<>();
        locationListDB = (ArrayList<Location>) (WeatherDatabase.getInstance(SearchLocationActivity.this).weatherDao().getAllLocation());
        adapterDB = new SearchLocationAdapter(locationListDB, this);
        binding.rcvDbLocation.setLayoutManager(new LinearLayoutManager(this));
        binding.rcvDbLocation.setAdapter(adapterDB);
        adapterDB.notifyDataSetChanged();


        adapter = new SearchLocationAdapter(locationList, this);
        binding.rcvSearchLocation.setLayoutManager(new LinearLayoutManager(this));
        binding.rcvSearchLocation.setAdapter(adapter);
        binding.edtSearchLocation.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                locationList.clear();
                binding.tvChoiceLonLat3.setText("");
                apiService.getLocationByName(binding.edtSearchLocation.getQuery().toString()).enqueue(new Callback<List<Location>>() {
                    @Override
                    public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                        for (Location i : response.body()) {
                            locationList.add(i);
                            adapter.notifyDataSetChanged();
                            binding.tvChoiceLonLat3.setText("   Kết quả");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Location>> call, Throwable t) {
                        System.out.println(t.toString());
                    }
                });
                return false;
            }
        });

        binding.tvChoiceLonLat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationList.clear();
                binding.tvChoiceLonLat3.setText("");
                if (ActivityCompat.checkSelfPermission(SearchLocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(SearchLocationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(SearchLocationActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            MY_PERMISSIONS_REQUEST_LOCATION);}
                else
                {
                    fusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<android.location.Location>() {
                        @Override
                        public void onSuccess(android.location.Location location) {
                            System.out.println(location.getLatitude()+"latttt");
                            apiService.getLocationByLonLat(location.getLatitude()+","+location.getLongitude()).enqueue(new Callback<Location>() {
                                @Override
                                public void onResponse(Call<Location> call, Response<Location> response) {
                                    locationList.add(response.body());
                                    adapter.notifyDataSetChanged();
                                    binding.tvChoiceLonLat3.setText("   Kết quả");
                                }

                                @Override
                                public void onFailure(Call<Location> call, Throwable t) {

                                }
                            });
                        }
                    });
                }
                }
            });
    }
}