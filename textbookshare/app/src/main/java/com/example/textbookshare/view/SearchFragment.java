package com.example.textbookshare.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.textbookshare.databinding.FragmentSearchBinding;
import com.example.textbookshare.model.Textbook;
import com.example.textbookshare.view.recyclerview.TextbookAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment implements ISearchView, TextbookAdapter.ItemClickListener{

    private final Listener listener;
    private FragmentSearchBinding binding;
    private TextbookAdapter textbookAdapter;

    public SearchFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentSearchBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up the RecyclerView using View Binding
        RecyclerView searchResultsRecyclerView = binding.recyclerViewSearchResults;
        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        textbookAdapter = new TextbookAdapter(view.getContext(), new ArrayList<>(), this);
        searchResultsRecyclerView.setAdapter(textbookAdapter);

//        textbookAdapter = new TextbookAdapter(view.getContext(), new TextbookAdapter.ItemClickListener() {
//            @Override
//            public void onItemClick(Textbook textbook) {
//                // Handle item click, e.g., navigate to textbook details
//                SearchFragment.this.binding.listener.onNavigateToTextbook(textbook);
//            }
//        });
//        searchResultsRecyclerView.setAdapter(textbookAdapter);


        // Set click listener for the search button
        binding.buttonSearch.setOnClickListener(v -> performSearch());

        // Set click listener for the add button

        // Initialize the TextView visibility
        showNoResultsMessage(false);
    }

    private void performSearch() {
        String searchTerm = binding.editTextSearch.getText().toString().trim();
        List<Textbook> searchResults = listener.onPerformSearch(searchTerm);
        updateSearchResults(searchResults);
    }

    public void updateSearchResults(List<Textbook> searchResults) {
        // Update the adapter with the new search results and refresh the RecyclerView
        textbookAdapter.setTextbooks(searchResults);
        textbookAdapter.notifyDataSetChanged();

        // Show or hide the "No results" message based on the search results
        showNoResultsMessage(searchResults.isEmpty());
    }

    public void showNoResultsMessage(boolean show) {
        if (show) {
            binding.noResultsTextView.setVisibility(View.VISIBLE);
        } else {
            binding.noResultsTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onItemClick(Textbook textbook) {
        listener.onNavigateToTextbook(textbook);
    }
}
