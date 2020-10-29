package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.listviewdemo.global.Global;
import com.example.listviewdemo.model.Note;
import com.example.listviewdemo.repo.Repo;

public class CustomListActivity extends AppCompatActivity implements Updatable {

    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        String[] countries = {"USA", "Danmark", "Norge", "Island"};
        int[] pictures = {R.drawable.car, R.drawable.logo_ticketbutler, R.drawable.car2, R.drawable.car3};
        myAdapter = new MyAdapter(this, Repo.r().notes(), pictures);
        ListView listView = findViewById(R.id.myListView2);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener((_listView, linearLayout, adapterPos, arrPos) -> {
            System.out.println("row clicked" + arrPos);
            Intent intent = new Intent(this, DetailActivity.class);
            Global.map.put(Global.NOTE_KEY, Repo.r().notes().get((int)arrPos));
            startActivity(intent);
        });
        Repo.r().setActivity(this);
    }

    @Override
    public void update() {
        System.out.println("update() er kaldet");
        runOnUiThread(() -> {
            myAdapter.notifyDataSetChanged();
        });
    }

    public void addNote(View view) {
        Note note = new Note("Write here");
        Repo.r().addNote(note); //opretter ny Note + gemmer i firebase
    }
}