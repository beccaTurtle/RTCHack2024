package com.example.textbookshare.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.textbookshare.databinding.FragmentTextbookBinding;
import com.example.textbookshare.model.Textbook;
import com.example.textbookshare.model.User;
import com.example.textbookshare.view.recyclerview.UserAdapter;

import java.util.List;

public class TextbookFragment extends Fragment {

    private Listener listener;
    private FragmentTextbookBinding binding;
    private UserAdapter userAdapter;
    private Textbook textbook;
    private User user;

    public TextbookFragment(Listener listener, Textbook t, User u) {
        this.listener = listener;
        this.textbook = t;
        this.user = u;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentTextbookBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up the RecyclerView using View Binding
        binding.recyclerViewPeople.setLayoutManager(new LinearLayoutManager(view.getContext()));

        // Create an instance of UserAdapter
        userAdapter = new UserAdapter(view.getContext());

        // Set the adapter on the RecyclerView
        binding.recyclerViewPeople.setAdapter(userAdapter);

        // Check if the user has the textbook in their list
        if (userHasTextbook()) {
            // User has the textbook, show "I Gave Away This Textbook" button
            binding.buttonRemoveTextbook.setVisibility(View.VISIBLE);
            binding.buttonRemoveTextbook.setOnClickListener(v -> onIGaveAwayTextbookClicked());
        } else {
            // User doesn't have the textbook, show "I Have This Textbook" button
            binding.buttonGiveTextbook.setVisibility(View.VISIBLE);
            binding.buttonGiveTextbook.setOnClickListener(v -> onIHaveTextbookClicked());
        }


        // Call a method to fill the adapter with data (you may need to change this based on your requirements)
        updateUserData();
    }

    // Check if the user has the textbook in their list
    private boolean userHasTextbook() {
        return user.getTextbooks().contains(textbook);
    }

    // Handle click for "I Gave Away This Textbook" button
    private void onIGaveAwayTextbookClicked() {
        // Remove the textbook from the user's list and add it to the textbook's list
        user.deleteTextbook(textbook);
        textbook.addUser(user);
        // Refresh the RecyclerView
        updateUserData();
    }

    // Handle click for "I Have This Textbook" button
    private void onIHaveTextbookClicked() {
        // Add the user to the textbook's list
        textbook.addUser(user);
        // Refresh the RecyclerView
        updateUserData();
    }

    // Method to update the adapter with data
    private void updateUserData() {
        // Get the list of users from your listener or any other source
        List<User> users = listener.getUsersForTextbook(textbook);
        // Update the adapter with the new data
        userAdapter.setUsers(users);
    }
}
