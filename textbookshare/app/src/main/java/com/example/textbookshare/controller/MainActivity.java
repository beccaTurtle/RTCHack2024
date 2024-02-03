package com.example.textbookshare.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.textbookshare.R;

import com.example.textbookshare.model.*;

import com.example.textbookshare.model.Library;
import com.example.textbookshare.model.Textbook;
import com.example.textbookshare.view.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Listener {
    User user;
    Library lib;
    MainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.lib = new Library();
        this.mainView = new MainView(this, this);

        Fragment searchFragment = new SearchFragment(this);
        this.mainView.displayFragment(searchFragment, false, "search");

        setContentView( this.mainView.getRootView());

    }


    @Override
    public List<Textbook> onPerformSearch(String searchTerm) {
        List<Textbook> matches = lib.search(searchTerm);

        //this.mainView.displaySearchResults(matches);

        return matches;

    }


}