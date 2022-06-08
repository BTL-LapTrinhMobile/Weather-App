package com.midterm.weatherapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.weatherapp.R;
import com.midterm.weatherapp.model.WeatherHourlyForecast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HourlyForecastAdapter extends RecyclerView.Adapter<HourlyForecastAdapter.ViewHolder> {
    private ArrayList<WeatherHourlyForecast> weatherHourlyForecastList;

    public HourlyForecastAdapter(ArrayList<WeatherHourlyForecast> weatherHourlyForecastList) {
        this.weatherHourlyForecastList = weatherHourlyForecastList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hourly_forecast_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeatherHourlyForecast whf = weatherHourlyForecastList.get(position);
        holder.textViewTemp.setText(String.valueOf(whf.getTemperature().getTemp()));
        holder.textViewTime.setText(whf.getTime().substring(11,16));
        holder.textViewWind.setText(String.valueOf(whf.getWind().getSpeed())+"km/h");
        String url = "http://openweathermap.org/img/wn/"+whf.getWeatherPreviewList().get(0).getIcon()+".png";
        Picasso.get().load(url).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        if(weatherHourlyForecastList!=null)
            return weatherHourlyForecastList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTime, textViewTemp, textViewWind;
        private ImageView icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTemp = itemView.findViewById(R.id.tv_temp);
            textViewTime = itemView.findViewById(R.id.tv_time);
            textViewWind = itemView.findViewById(R.id.tv_wind);
            icon = itemView.findViewById(R.id.iv_icon);
        }
    }

}