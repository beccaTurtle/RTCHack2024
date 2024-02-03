package com.example.textbookshare.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.textbookshare.R;
import com.example.textbookshare.model.Textbook;
import com.example.textbookshare.view.recyclerview.TextbookAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private EditText editTextSearch;
    private Button buttonSearch;
    private RecyclerView recyclerViewSearchResults;
    private TextbookAdapter textbookAdapter;

    // Sample data for demonstration
    private List<Textbook> sampleTextbookList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // Initialize views
        editTextSearch = view.findViewById(R.id.editTextSearch);
        buttonSearch = view.findViewById(R.id.buttonSearch);
        recyclerViewSearchResults = view.findViewById(R.id.recyclerViewSearchResults);

        // Set up RecyclerView
        recyclerViewSearchResults.setLayoutManager(new LinearLayoutManager(getActivity()));
        textbookAdapter = new TextbookAdapter(); // You need to create a TextbookAdapter class for your Textbook items
        recyclerViewSearchResults.setAdapter(textbookAdapter);

        // Sample data (Replace with your actual data retrieval logic)
        sampleTextbookList = new ArrayList<>();
        sampleTextbookList.add(new Textbook("Textbook Title 1", "Author 1"));
        sampleTextbookList.add(new Textbook("Textbook Title 2", "Author 2"));
        sampleTextbookList.add(new Textbook("Textbook Title 3", "Author 3"));

        // Set click listener for the search button
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

        return view;
    }

    // Method to perform search based on the entered query
    private void performSearch() {
        String query = editTextSearch.getText().toString().trim();

        // Implement your search logic here (e.g., query the database or API)

        // For demonstration, using sampleTextbookList to display results
        List<Textbook> searchResults = filterTextbooksByQuery(query, sampleTextbookList);
        textbookAdapter.setTextbooks(searchResults);
    }

    // Method to filter textbooks based on the search query
    private List<Textbook> filterTextbooksByQuery(String query, List<Textbook> textbookList) {
        List<Textbook> filteredList = new ArrayList<>();
        for (Textbook textbook : textbookList) {
            // Implement your specific filtering logic here (e.g., title or author contains the query)
            if (textbook.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    textbook.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(textbook);
            }
        }
        return filteredList;
    }
}
