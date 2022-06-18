package com.midterm.weatherapp.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.midterm.weatherapp.databinding.ActivitySearchLocationBinding;
import com.midterm.weatherapp.model.location.Location;
import com.midterm.weatherapp.viewmodel.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchLocationActivity extends AppCompatActivity {
    private ActivitySearchLocationBinding binding;
    private ArrayList<Location> locationList;
    private SearchLocationAdapter adapter;
    private ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        apiService = new ApiService();
        locationList = new ArrayList<>();
        adapter = new SearchLocationAdapter(locationList,this);

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
                apiService.getLocationByName(binding.edtSearchLocation.getQuery().toString()).enqueue(new Callback<List<Location>>() {
                    @Override
                    public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                        for(Location i : response.body())
                        {
                            locationList.add(i);
                            adapter.notifyDataSetChanged();
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

    }
}