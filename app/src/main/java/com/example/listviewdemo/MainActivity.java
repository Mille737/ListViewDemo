package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] countries = {"USA", "Danmark", "Norge", "Island"};
        ListView listView = findViewById(R.id.myListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.myrow, R.id.textView, countries);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((_listView, linearLayout, adapterPos, arrPos) -> {
            System.out.println("Klik på række" + arrPos);
        });
    }
}