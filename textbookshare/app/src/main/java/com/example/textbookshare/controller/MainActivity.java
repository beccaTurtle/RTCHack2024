package com.example.textbookshare.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.textbookshare.model.*;

import com.example.textbookshare.model.Library;
import com.example.textbookshare.model.Textbook;
import com.example.textbookshare.view.*;


import java.util.List;

public class MainActivity extends AppCompatActivity implements Listener, ISearchView.Listener {
    User user;
    Library lib;
    MainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.lib = new Library();
        this.mainView = new MainView(this, this);

        SearchFragment searchFragment = new SearchFragment(this);
        this.mainView.displayFragment(searchFragment, false, "search");

        setContentView(this.mainView.getRootView());

    }


    @Override
    public List<Textbook> onPerformSearch(String searchTerm) {
        List<Textbook> matches = lib.search(searchTerm);
        //this.mainView.displaySearchResults(matches);
        return matches;

    }

    public void onNavigateToTextbook(Textbook t){
        TextbookFragment textFragment = new TextbookFragment(this, t);
        this.mainView.displayFragment(textFragment, true, "textbook");
    }

    @Override
    public void onUpdateProfile(String newUsername, String newEmail) {
        if (this.user == null){
            user = new User(newUsername, newEmail);
        }
        else{
            user.setUsername(newUsername);
            user.setEmail(newEmail);
        }

    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public void onGoToProfile() {
        ProfileFragment profileFragment = new ProfileFragment(this);
        this.mainView.displayFragment(profileFragment, true, "profile");

    }

    @Override
    public void onGoToSearch() {
        SearchFragment searchFragment = new SearchFragment(this);
        this.mainView.displayFragment(searchFragment, true, "profile");


    }

    @Override
    public boolean userExists() {
        return this.user != null;

    }

    public List<User> getUsersForTextbook(Textbook t){
        return t.getUsers();
    }
}

