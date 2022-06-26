package com.midterm.weatherapp.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.weatherapp.MainActivity;
import com.midterm.weatherapp.R;
import com.midterm.weatherapp.model.location.AdministrativeArea;
import com.midterm.weatherapp.model.location.Location;
import com.midterm.weatherapp.viewmodel.WeatherDao;
import com.midterm.weatherapp.viewmodel.WeatherDatabase;

import java.util.ArrayList;

public class SearchLocationAdapter extends RecyclerView.Adapter<SearchLocationAdapter.ViewHolder> {
    private ArrayList<Location> locationList;
    private Context context;
    private WeatherDatabase weatherDatabase;
    private WeatherDao weatherDao;

    public SearchLocationAdapter(ArrayList<Location> searchList, Context context) {
        this.locationList = searchList;
        this.context = context;
        weatherDatabase = WeatherDatabase.getInstance(context);
        weatherDao = weatherDatabase.weatherDao();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_location_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Location location = locationList.get(position);
        String locationStr = location.getLocalizedName()+", "+location.getAdministrativeArea().getLocalizedName()+", "+location.getCountry().getIdCountry();
        holder.tvLocation.setText(locationStr);

        holder.layoutSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkNewLocation(weatherDao,location.getKey())) {
                    addNewLocation(weatherDao, location);
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if(locationList!= null)
            return locationList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvLocation;
        private LinearLayout layoutSearch;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutSearch = itemView.findViewById(R.id.layout_search_item);
            tvLocation = itemView.findViewById(R.id.tv_location);
        }
    }


    public boolean checkNewLocation(WeatherDao weatherDao, String key)
    {
        try {
            if(weatherDao.getLocationByKey(key)==null) {
                Log.e("DEBUG_DB_LOCATION", "checkNewLocation DONE");
                return true;
            }
            else {
                Log.e("DEBUG_DB_LOCATION", "checkNewLocation FAIL");
                return false;
            }
        }
        catch (Exception e)
        {
            Log.e("DEBUG_DB_LOCATION", "checkNewLocation ERROR"+e);
            return false;
        }
    }

    public void addNewLocation(WeatherDao weatherDao, Location location)
    {
        try{
            weatherDao.insertLocation(location);
        }
        catch (Exception e)
        {
            Log.e("DEBUG_DB_LOCATION", "addNewLocation ERROR"+e);
        }
    }

}