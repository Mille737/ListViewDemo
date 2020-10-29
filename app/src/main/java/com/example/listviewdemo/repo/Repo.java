package com.example.listviewdemo.repo;

import com.example.listviewdemo.Updatable;
import com.example.listviewdemo.model.Note;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repo {

    private static Repo repo = new Repo(); //kan kun kører en gang

    private Updatable activity;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String NOTES = "notes";
    private static final String TITLE = "title";
    private List<Note> noteList = new ArrayList<>(); //gemmer Note objekter. Kan opdateres

    public static Repo r() {
        return repo;
    }

    public void setActivity(Updatable a) { //kaldes fra activity som skal blive opdateret
        activity = a;
        startListner();
    }
    public void addNote(Note note) {
        DocumentReference ref = db.collection(NOTES).document(note.getId()); //opret nyt dokument i firebase hvor vi selv angiver document id
        Map<String, String> map = new HashMap<>();
        map.put(TITLE, note.getTitle()); //tilføj selv flere key-value pair efter behov
        ref.set(map); //gemmer hele map i aktuelt document
    }
    public void startListner() { //snapshotlistner lytter hele tiden
        db.collection(NOTES).addSnapshotListener((values, error) -> {
            noteList.clear();
            for(DocumentSnapshot snap : values.getDocuments()) {
                Note note = new Note(snap.get(TITLE).toString(), snap.getId());
                noteList.add(note);
                System.out.println("here" + note);
            }
            activity.update(); //kaldes efter vi har hentet data fra firebase
        });
    }

    public List<Note> notes() {
        return noteList;
    }
    //rud metoder
}
