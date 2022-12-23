package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Stars> stars =new ArrayList<>();
        stars.add(new Stars(1));
        stars.add(new Stars(2));
        stars.add(new Stars(3));
        stars.add(new Stars(4));
        stars.add(new Stars(5));
        AdapterOfMainActivity adapter = new AdapterOfMainActivity(stars,this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}