package com.midterm.weatherapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.weatherapp.R;
import com.midterm.weatherapp.model.WeatherDailyForecast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        holder.tvTempMin.setText("/ "+String.valueOf((int)((double) wdf.getTemperature().getMinimumTemperature().getValue())));
        holder.tvTempMax.setText(String.valueOf((int)((double) wdf.getTemperature().getMaximumTemperature().getValue())));
        holder.tvDay.setText(wdf.getDate());
        holder.ivIcon.setImageResource(wdf.getDay().convertIcon(wdf.getDay().getIcon()));

        holder.tvDate.setText((wdf.getDate()).substring(5,10));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date convertedCurrentDate = sdf.parse((wdf.getDate()).substring(0,10));
            String date= new SimpleDateFormat("EEEE").format(convertedCurrentDate);

            holder.tvDay.setText(convertVN(date));
            System.out.println("date============="+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


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
            ivIcon = itemView.findViewById(R.id.iv_icon);
        }
    }

    public String convertVN(String eng)
    {
        switch(eng)
        {
            case "Sunday":
                return "Chủ nhật";
            case "Monday":
                return "Thứ hai";
            case "Tuesday":
                return "Thứ ba";
            case "Wednesday":
                return "Thứ tư";
            case "Thursday":
                return "Thứ năm";
            case "Friday":
                return "Thứ sáu";
            case "Saturday":
                return "Thứ bảy";
            default:
                return eng;
        }
    }


}
