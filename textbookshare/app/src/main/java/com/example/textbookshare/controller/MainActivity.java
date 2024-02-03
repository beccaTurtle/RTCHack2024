package com.example.textbookshare.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.textbookshare.R;

import com.example.textbookshare.model.*;

import com.example.textbookshare.model.Library;
import com.example.textbookshare.model.Textbook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    User user;
    Library lib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.lib = new Library();
    }

    @Override
    public void onPerformSearch(String searchTerm) {
        List<Textbook> matches = lib.search(searchTerm);
        this.mainView.displaySearchResults(matches);
    }


}