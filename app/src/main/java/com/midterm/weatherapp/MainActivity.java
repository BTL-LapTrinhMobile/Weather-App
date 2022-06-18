package com.midterm.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.midterm.weatherapp.databinding.ActivityMainBinding;
import com.midterm.weatherapp.model.location.Location;
import com.midterm.weatherapp.view.MainViewPagerAdapter;
import com.midterm.weatherapp.viewmodel.ApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;
    private ActivityMainBinding binding;
    private ArrayList<Location> locationList;
    private MainViewPagerAdapter VPAdapter;
//    private AppDatabase appDatabase;
//    private AppDao appDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        apiService = new ApiService();
        locationList = new ArrayList<>();

        VPAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), getLifecycle(),locationList);
        binding.vpMain.setAdapter(VPAdapter);

//        appDatabase = AppDatabase.getInstance(this);
//        appDao = appDatabase.contactDao();

        add("Hoi An");
        System.out.println("No "+locationList.toString());


    }
    public void add(String city)
    {
        apiService.getLocationByName(city).enqueue(new Callback<List<Location>>() {
            @Override
            public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                for(Location i : response.body())
                {
                    locationList.add(i);
                    System.out.println(locationList.toString());
                }
                VPAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Location>> call, Throwable t) {
                System.out.println(t.toString());
            }
        });
    }
}