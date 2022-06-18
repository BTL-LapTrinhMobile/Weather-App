package com.midterm.weatherapp.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.weatherapp.MainActivity;
import com.midterm.weatherapp.R;
import com.midterm.weatherapp.model.location.Location;

import java.util.ArrayList;

public class SearchLocationAdapter extends RecyclerView.Adapter<SearchLocationAdapter.ViewHolder> {
    private ArrayList<Location> locationList;
    private Context context;
//    private AppDatabase appDatabase;
//    private AppDao appDao;

    public SearchLocationAdapter(ArrayList<Location> searchList, Context context) {
        this.locationList = searchList;
        this.context = context;
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
//                appDatabase = AppDatabase.getInstance(context);
//                appDao = appDatabase.contactDao();
//                addNewLocation(location);
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
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


//    public void addNewLocation(Location location)
//    {
//        try {
//            AsyncTask.execute(new Runnable() {
//                @Override
//
//                public void run() {
//                    try{
//                        // Kiem tra location trong DB
//                         if(appDao.getLocationByKey(location.getKey())== null)
//                         {
//                             location.setIdAdministrativeArea(location.getAdministrativeArea().getIdAdministrativeArea());
//                             location.setIdCountry(location.getCountry().getIdCountry());
//                             // Kiem tra country trong DB
//                             if(appDao.getCountryByID(location.getIdCountry())==null)
//                             {
//                                 appDao.insertAllCountry(location.getCountry());
//                             }
//                             //Kiem tra administrative trong DB
//                             if(appDao.getAdministrativeAreaByID(location.getIdAdministrativeArea())==null)
//                             {
//                                 appDao.insertAllAdministrativeArea(location.getAdministrativeArea());
//                             }
//                             // Them location vao DB
//                             appDao.insertAllLocation(location);
//                         }
//                    }
//                    catch (Exception ex)
//                    {
//                        Log.e("Exception",ex.toString());
//                    }
//                }
//            });
//        }
//        catch (Exception e)
//        {}
//    }
}
