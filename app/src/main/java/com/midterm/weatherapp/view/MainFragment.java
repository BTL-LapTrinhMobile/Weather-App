package com.midterm.weatherapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.weatherapp.R;
import com.midterm.weatherapp.databinding.FragmentMainBinding;
import com.midterm.weatherapp.model.WeatherDailyForecast;
import com.midterm.weatherapp.model.WeatherDailyForecastList;
import com.midterm.weatherapp.model.WeatherDailyForecastPreview;
import com.midterm.weatherapp.model.WeatherHourlyForecast;
import com.midterm.weatherapp.model.location.Location;
import com.midterm.weatherapp.viewmodel.ApiService;

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
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            location =(Location) getArguments().getSerializable("LOCATION");
            System.out.println(location.getEnglishName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_main,null, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        weatherHourlyForecastList = new ArrayList<>();
        adapter = new HourlyForecastAdapter(weatherHourlyForecastList);
        binding.rcvHourlyForecast.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
        binding.rcvHourlyForecast.setAdapter(adapter);

        weatherDailyForecastList = new ArrayList<>();
        dailyAdapter = new DailyForecastAdapter(weatherDailyForecastList);
        binding.rcvDailyForecast.setLayoutManager( new LinearLayoutManager(getActivity()));
        binding.rcvDailyForecast.setAdapter(dailyAdapter);

        apiService = new ApiService();
        getDB(apiService,location.getKey());

        binding.btnSearchLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchLocationActivity.class);
                startActivity(intent);
            }
        });

    }
    public void getDB(ApiService apiService,String cityKey){
//        apiService.getWeatherCurrent(cityKey).enqueue(new Callback<List<WeatherCurrent>>() {
//            @Override
//            public void onResponse(Call<List<WeatherCurrent>> call, Response<List<WeatherCurrent>> response) {
//                WeatherCurrent weatherCurrent = response.body().get(0);
//                binding.setWeatherCurrent(weatherCurrent);
//                System.out.println(weatherCurrent.getPressure().getMetric().getValue());
//
//            }
//
//            @Override
//            public void onFailure(Call<List<WeatherCurrent>> call, Throwable t) {
//
//            }
//        });

        apiService.getWeatherHourlyForecast(cityKey).enqueue(new Callback<List<WeatherHourlyForecast>>() {
            @Override
            public void onResponse(Call<List<WeatherHourlyForecast>> call, Response<List<WeatherHourlyForecast>> response) {


                WeatherHourlyForecast weatherCurrent = response.body().get(0);
                binding.setWeatherNextHour(weatherCurrent);
                for (WeatherHourlyForecast i : response.body()) {
                    weatherHourlyForecastList.add(i);
                    adapter.notifyDataSetChanged();
                    img_choose(i.getWeatherIcon(), binding.imIcon);
                }
            }

            @Override
            public void onFailure(Call<List<WeatherHourlyForecast>> call, Throwable t) {

            }
        });

        apiService.getWeatherDailyForecastList(cityKey).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<WeatherDailyForecastList>() {
                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull WeatherDailyForecastList list) {
                        binding.setWeatherDailyForecast(list.getWeatherDailyForecastList().get(0));
                        for (WeatherDailyForecast i : list.getWeatherDailyForecastList()) {
                            weatherDailyForecastList.add(i);
                            dailyAdapter.notifyDataSetChanged();
                        }
                        weatherDailyForecastPreview = list.getPreview();
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }
                });
//        binding.tvDailyForecastDetail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(weatherDailyForecastList != null)
//                {
//                    Intent intent = new Intent(getActivity(), DailyForecastActivity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("WEATHER_DAILY_FORECAST_LIST", weatherDailyForecastList);
//                    bundle.putSerializable("WEATHER_DAILY_FORECAST_PREVIEW", weatherDailyForecastPreview);
//                    intent.putExtras(bundle);
//                    startActivity(intent);
//                }
//            }
//        });

    }
    public void img_choose (int id_api,ImageView img){
        switch (id_api){
            case 1:
                img.setImageResource(R.drawable._01_s);
            case 2:
                img.setImageResource(R.drawable._02_s);
            case 3:
                img.setImageResource(R.drawable._03_s);
            case 4:
                img.setImageResource(R.drawable._04_s);
            case 5:
                img.setImageResource(R.drawable._05_s);
            case 6:
                img.setImageResource(R.drawable._06_s);
            case 7:
                img.setImageResource(R.drawable._07_s);
            case 8:
                img.setImageResource(R.drawable._08_s);
            case 11:
                img.setImageResource(R.drawable._11_s);
            case 12:
                img.setImageResource(R.drawable._12_s);
            case 13:
                img.setImageResource(R.drawable._13_s);
            case 14:
                img.setImageResource(R.drawable._14_s);
            case 15:
                img.setImageResource(R.drawable._15_s);
            case 16:
                img.setImageResource(R.drawable._16_s);
            case 17:
                img.setImageResource(R.drawable._17_s);
            case 18:
                img.setImageResource(R.drawable._18_s);
            case 19:
                img.setImageResource(R.drawable._19_s);
            case 20:
                img.setImageResource(R.drawable._20_s);
            case 21:
                img.setImageResource(R.drawable._21_s);
            case 22:
                img.setImageResource(R.drawable._22_s);
            case 23:
                img.setImageResource(R.drawable._23_s);
            case 24:
                img.setImageResource(R.drawable._24_s);
            case 25:
                img.setImageResource(R.drawable._25_s);
            case 26:
                img.setImageResource(R.drawable._26_s);
            case 29:
                img.setImageResource(R.drawable._29_s);
            case 30:
                img.setImageResource(R.drawable._30_s);
            case 31:
                img.setImageResource(R.drawable._31_s);
            case 32:
                img.setImageResource(R.drawable._32_s);
            case 33:
                img.setImageResource(R.drawable._33_s);
            case 34:
                img.setImageResource(R.drawable._34_s);
            case 35:
                img.setImageResource(R.drawable._35_s);
            case 36:
                img.setImageResource(R.drawable._36_s);
            case 37:
                img.setImageResource(R.drawable._37_s);
            case 38:
                img.setImageResource(R.drawable._38_s);
            case 39:
                img.setImageResource(R.drawable._39_s);
            case 40:
                img.setImageResource(R.drawable._40_s);
            case 41:
                img.setImageResource(R.drawable._41_s);
            case 42:
                img.setImageResource(R.drawable._42_s);
            case 43:
                img.setImageResource(R.drawable._43_s);
            case 44:
                img.setImageResource(R.drawable._44_s);

        }

    };
}