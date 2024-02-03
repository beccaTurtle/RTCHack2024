package com.example.textbookshare.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.textbookshare.R;
import com.example.textbookshare.model.*;

public class MainActivity extends AppCompatActivity {

    Library library;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.library = new Library();
    }
}