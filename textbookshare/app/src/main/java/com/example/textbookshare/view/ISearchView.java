package com.example.textbookshare.view;

import com.example.textbookshare.model.Textbook;

import java.util.List;

public interface ISearchView {

    interface Listener{
        public void onNavigateToTextbook(Textbook t);

        List<Textbook> onPerformSearch(String searchTerm);
    }
}
