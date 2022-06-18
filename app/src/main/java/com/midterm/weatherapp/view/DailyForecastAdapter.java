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

import java.util.ArrayList;

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
        holder.tvDay.setText(wdf.getDate());
    }

    @Override
    public int getItemCount() {
        if(weatherDailyForecastList != null)
            return weatherDailyForecastList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDay, tvDate, tvTempMax, tvTempMin;
        private ImageView ivIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate =  itemView.findViewById(R.id.tv_date);
            tvDay = itemView.findViewById(R.id.tv_day);
            tvTempMax = itemView.findViewById(R.id.tv_temp_max);
            tvTempMin = itemView.findViewById(R.id.tv_temp_min);
        }
    }
}