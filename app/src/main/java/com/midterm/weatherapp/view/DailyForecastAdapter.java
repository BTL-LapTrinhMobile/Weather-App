package com.midterm.weatherapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.weatherapp.R;
import com.midterm.weatherapp.model.WeatherDailyForecast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DailyForecastAdapter extends RecyclerView.Adapter<DailyForecastAdapter.ViewHolder> {
    private ArrayList<WeatherDailyForecast> weatherDailyForecastList;

    public DailyForecastAdapter(ArrayList<WeatherDailyForecast> weatherDailyForecastList) {
        this.weatherDailyForecastList = weatherDailyForecastList;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_forecast_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        WeatherDailyForecast wdf = weatherDailyForecastList.get(position);
        holder.tvTempMin.setText(String.valueOf((int)((double) wdf.getTemperature().getMinimumTemperature().getValue())));
        holder.tvTempMax.setText(String.valueOf((int)((double) wdf.getTemperature().getMaximumTemperature().getValue())));
        holder.tvDate.setText((wdf.getDate()).substring(5,10));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date convertedCurrentDate = sdf.parse((wdf.getDate()).substring(0,10));
            String date= new SimpleDateFormat("EEEE").format(convertedCurrentDate);

            holder.tvDay.setText(date);
            System.out.println("date============="+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }



        img_choose(wdf.getDay().getWeatherIcon(),holder.icon);
        System.out.println("id ico ==========="+wdf.getDay().getWeatherIcon());

    }

    @Override
    public int getItemCount() {
        if(weatherDailyForecastList != null)
            return weatherDailyForecastList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDay, tvDate, tvTempMax, tvTempMin;
        private ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate =  itemView.findViewById(R.id.tv_date);
            tvDay = itemView.findViewById(R.id.tv_day);
            tvTempMax = itemView.findViewById(R.id.tv_temp_max);
            tvTempMin = itemView.findViewById(R.id.tv_temp_min);
            icon=itemView.findViewById(R.id.iv_dlicon);
        }
    }
    public void img_choose (int id_api,ImageView img) {
        switch (id_api) {
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
        ;
    }
}