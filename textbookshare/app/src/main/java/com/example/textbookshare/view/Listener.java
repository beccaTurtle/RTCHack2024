package com.example.textbookshare.view;

import com.example.textbookshare.model.Textbook;

import java.util.*;

public interface Listener {

    public List<Textbook> onPerformSearch(String searchTerm);

    void onUpdateProfile(String newUsername, String newEmail);

    String getUsername();

    String getEmail();

    void onGoToProfile();

    void onGoToSearch();

    boolean userExists();
}
