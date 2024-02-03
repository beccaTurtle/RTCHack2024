package com.example.textbookshare.view;

import com.example.textbookshare.model.Textbook;

import java.util.*;

public interface Listener {

    public List<Textbook> onPerformSearch(String searchTerm);
}
