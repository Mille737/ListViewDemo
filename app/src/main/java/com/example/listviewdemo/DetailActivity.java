
package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.listviewdemo.global.Global;
import com.example.listviewdemo.model.Note;

public class DetailActivity extends AppCompatActivity {

    private Note currentNote;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        editText = findViewById(R.id.detailTextView);
        currentNote = (Note) Global.map.get(Global.NOTE_KEY);
        assert currentNote != null;
        editText.setText(currentNote.getTitle());
        currentNote.setTitle(editText.getText().toString());
        System.out.println(editText.getText().toString());
    }

    void saveText() {

    }
}