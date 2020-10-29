package com.example.listviewdemo.model;

import java.util.UUID;

public class Note {

    private String title;
    private String id = UUID.randomUUID().toString(); //default

    public Note(String title, String _id) {
        this.title = title;
        if(_id != null) {
            id = _id;
        }
    }

    public Note(String title) { //brug denne når vi opretter ny Note fra android
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }
}
