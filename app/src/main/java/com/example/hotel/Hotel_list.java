package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Hotel_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_list);
        int id = getIntent().getIntExtra("id",0);

        ArrayList<Hotel> hotelList =new ArrayList<>();
        hotelList.add( new Hotel(1,"maarif"));
        hotelList.add( new Hotel(1,"casavoy"));
        hotelList.add( new Hotel(1,"agaoceon"));
        hotelList.add( new Hotel(1,"newFc"));
        hotelList.add( new Hotel(2,"Marriott"));
        hotelList.add( new Hotel(2,"Hilton"));
        hotelList.add( new Hotel(2,"Sheraton"));
        hotelList.add( new Hotel(2,"Hyatt"));
        hotelList.add( new Hotel(3,"InterContinental"));
        hotelList.add( new Hotel(3,"Four Seasons"));
        hotelList.add( new Hotel(3,"agaoceon"));
        hotelList.add( new Hotel(3,"newFc"));
        hotelList.add( new Hotel(4,"maarif"));
        hotelList.add( new Hotel(4,"casavoy"));
        hotelList.add( new Hotel(4,"Sheraton"));
        hotelList.add( new Hotel(4,"newFc"));
        hotelList.add( new Hotel(5,"agaoceon"));
        hotelList.add( new Hotel(5,"casavoy"));
        hotelList.add( new Hotel(5,"InterContinental"));
        hotelList.add( new Hotel(5,"Sheraton"));

        ArrayList<Hotel> myList= new ArrayList<>();
        myList=getHotelsById(id,hotelList);;
        AdapterOfHotels adapter = new AdapterOfHotels(myList);
        RecyclerView recyclerView = findViewById(R.id.recyclerHotel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<Hotel> getHotelsById(int id, List<Hotel> Hotels) {
        Intent intent = getIntent();
        int categoryId = intent.getIntExtra("id", 0);

        ArrayList<Hotel> matchingHotels = new ArrayList<>();
        for (Hotel hotel : Hotels) {
            if (hotel.getId() == categoryId) {
                matchingHotels.add(hotel);
            }
        }
        return matchingHotels;
    }
}