package com.midterm.weatherapp.view;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.weatherapp.MainActivity;
import com.midterm.weatherapp.R;
import com.midterm.weatherapp.databinding.FragmentMainBinding;
import com.midterm.weatherapp.model.Temperature;
import com.midterm.weatherapp.model.WeatherDailyForecast;
import com.midterm.weatherapp.model.WeatherDailyForecastList;
import com.midterm.weatherapp.model.WeatherDailyForecastPreview;
import com.midterm.weatherapp.model.WeatherHourlyForecast;
import com.midterm.weatherapp.model.location.Location;
import com.midterm.weatherapp.viewmodel.ApiService;
import com.midterm.weatherapp.viewmodel.WeatherDao;
import com.midterm.weatherapp.viewmodel.WeatherDatabase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {
    private ApiService apiService;
    private HourlyForecastAdapter adapter;
    private ArrayList<WeatherHourlyForecast> weatherHourlyForecastList;
    private DailyForecastAdapter dailyAdapter;
    private ArrayList<WeatherDailyForecast> weatherDailyForecastList;
    private WeatherDailyForecastPreview weatherDailyForecastPreview;
    private FragmentMainBinding binding;
    private Location location;
    private WeatherDao weatherDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            location = (Location) getArguments().getSerializable("LOCATION");
            System.out.println(location.getEnglishName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_main, null, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        weatherHourlyForecastList = new ArrayList<>();
        adapter = new HourlyForecastAdapter(weatherHourlyForecastList);
        binding.rcvHourlyForecast.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.rcvHourlyForecast.setAdapter(adapter);

        weatherDailyForecastList = new ArrayList<>();
        dailyAdapter = new DailyForecastAdapter(weatherDailyForecastList);
        binding.rcvDailyForecast.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rcvDailyForecast.setAdapter(dailyAdapter);

        weatherDao = WeatherDatabase.getInstance(getActivity()).weatherDao();

        apiService = new ApiService();

        if (internetIsConnected()) {
            getDataAPI(weatherDao, apiService, location);
            Log.e("Check", "connect");
        } else {
            getDataRoom(weatherDao,location);
            Log.e("Check", "disconnect");
        }

        binding.tvCityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchLocationActivity.class);
                startActivity(intent);
            }
        });

        binding.tvDailyForecastDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(getActivity(), SearchLocationActivity.class);
//                startActivity(intent);
                Log.e("ERROR",location.getWeatherDailyForecastList().getWeatherDailyForecastArrayList().get(0).toString());
                if(weatherDailyForecastList != null)
                {
                    Intent intent = new Intent(getActivity(), DailyForecastActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("WEATHER_DAILY_FORECAST_LIST", weatherDailyForecastList);
                    bundle.putSerializable("WEATHER_DAILY_FORECAST_PREVIEW", weatherDailyForecastPreview);
                    bundle.putSerializable("LOCATION", location);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });

    }

    public void getDataAPI(WeatherDao weatherDao, ApiService apiService, Location location) {

        String cityName = location.getLocalizedName()+", "+location.getCountry().getIdCountry();
        binding.tvCityName.setText(cityName);
        apiService.getWeatherHourlyForecast(location.getKey()).enqueue(new Callback<List<WeatherHourlyForecast>>() {
            @Override
            public void onResponse(Call<List<WeatherHourlyForecast>> call, Response<List<WeatherHourlyForecast>> response) {

                ArrayList<WeatherHourlyForecast> hourlyList = (ArrayList<WeatherHourlyForecast>) response.body();

                WeatherHourlyForecast weatherCurrent = hourlyList.get(0);
                binding.setWeatherNextHour(weatherCurrent);
                binding.imIcon.setImageResource(weatherCurrent.convertIcon(weatherCurrent.getWeatherIcon()));

                location.setWeatherHourlyForecastList(hourlyList);
                weatherDao.updateLocation(location);

                for (WeatherHourlyForecast i : response.body()) {
                    weatherHourlyForecastList.add(i);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<WeatherHourlyForecast>> call, Throwable t) {

            }
        });

        apiService.getWeatherDailyForecastList(location.getKey()).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<WeatherDailyForecastList>() {
                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull WeatherDailyForecastList list) {
                        binding.setWeatherDailyForecast(list.getWeatherDailyForecastArrayList().get(0));

                        location.setWeatherDailyForecastList(list);
                        weatherDao.updateLocation(location);

                        for (WeatherDailyForecast i : list.getWeatherDailyForecastArrayList()) {
                            weatherDailyForecastList.add(i);
                            dailyAdapter.notifyDataSetChanged();
                        }
                        weatherDailyForecastPreview = list.getPreview();
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }
                });
    }

    public void getDataRoom(WeatherDao weatherDao, Location location) {
        String cityName = location.getLocalizedName()+", "+location.getCountry().getIdCountry();
        binding.tvCityName.setText(cityName);
        if (location.getWeatherHourlyForecastList() != null) {
            WeatherHourlyForecast weatherCurrent = location.getWeatherHourlyForecastList().get(0);
            binding.setWeatherNextHour(weatherCurrent);
            binding.imIcon.setImageResource(weatherCurrent.convertIcon(weatherCurrent.getWeatherIcon()));
            for (WeatherHourlyForecast i : location.getWeatherHourlyForecastList()) {
                weatherHourlyForecastList.add(i);
                adapter.notifyDataSetChanged();
            }

        }
        if (location.getWeatherDailyForecastList() != null) {
            binding.setWeatherDailyForecast(location.getWeatherDailyForecastList().getWeatherDailyForecastArrayList().get(0));
            for (WeatherDailyForecast i : location.getWeatherDailyForecastList().getWeatherDailyForecastArrayList()) {
                weatherDailyForecastList.add(i);
                dailyAdapter.notifyDataSetChanged();
            }

        }
    }

    public boolean internetIsConnected() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInto = connectivityManager.getActiveNetworkInfo();

            if (networkInto != null) {
                if (networkInto.isConnected()) {
                    return true;
                }
                else
                    return false;
            }
            else return false;
        } catch (Exception e) {
            return false;
        }
    }
}