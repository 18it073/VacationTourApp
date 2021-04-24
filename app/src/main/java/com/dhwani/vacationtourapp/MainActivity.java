package com.dhwani.vacationtourapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.dhwani.vacationtourapp.adapter.RecentsAdapter;
import com.dhwani.vacationtourapp.adapter.TopPlacesAdapter;
import com.dhwani.vacationtourapp.model.RecentsData;
import com.dhwani.vacationtourapp.model.TopPlacesData;
import com.dhwani.vacationtourapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    ImageView imgHome, imgProfile, imgFlights, imgHotels;

   /* ListView list = (ListView) findViewById(R.id.recent_recycler);
    list.setOnItemClickListener(new AdapterView.OnItemClickListener()) {
        @Override
                public void onItemClick(RecentsAdapter<?> parent, View view; int position; long id) {
                   switch (position) {

                   }
        }
    } */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgHome = findViewById(R.id.imgHome);
        imgProfile = findViewById(R.id.imgProfile);
        imgFlights = findViewById(R.id.imgFlights);
        imgHotels = findViewById(R.id.imgHotels);

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent);


            }

        });

        imgFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, FlightsActivity.class);
                startActivity(intent);


            }

        });

        imgHotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, HotelsActivity.class);
                startActivity(intent);


            }

        });
        // Now here we will add some dummy data in our model class

        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("Srinagar", "India", "From Rs.2000", R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Gulmarg", "India", "From Rs.3000", R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("Leh", "India", "From Rs.2000", R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Pulwama", "India", "From Rs.3000", R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("Vaishno Devi", "India", "From Rs.2000", R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Amarnath", "India", "From Rs.3000", R.drawable.recentimage2));

        setRecentRecycler(recentsDataList);

        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Nagin Valley", "India", "Rs.2000 - Rs.5000", R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Betaab Valley", "India", "Rs.2000 - Rs.5000", R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Wullar Lake", "India", "Rs.2000 - Rs.5000", R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Pangong Lake", "India", "Rs.2000 - Rs.5000", R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Kashmir Valley", "India", "RS.2000 - Rs.5000", R.drawable.topplaces));

        setTopPlacesRecycler(topPlacesDataList);
    }

    private void setRecentRecycler(List<RecentsData> recentsDataList) {

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

    private void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList) {

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);

    }

}