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
import com.google.android.material.snackbar.Snackbar;

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

        // Assign values
        this.binding.textViewTitle.setText(textbook.getTitle());
        this.binding.textViewAuthor.setText(textbook.getAuthor());

        // Set up the RecyclerView using View Binding
        binding.recyclerViewPeople.setLayoutManager(new LinearLayoutManager(view.getContext()));

        // Create an instance of UserAdapter
        userAdapter = new UserAdapter(view.getContext());

        // Set the adapter on the RecyclerView
        binding.recyclerViewPeople.setAdapter(userAdapter);

        changeButtons();

        // Call a method to fill the adapter with data (you may need to change this based on your requirements)
        updateUserData();
    }

    private void changeButtons(){
        // Check if the user has the textbook in their list
        if (userHasTextbook()) {
            // User has the textbook, show "I Gave Away This Textbook" button
            binding.buttonRemoveTextbook.setVisibility(View.VISIBLE);
            binding.buttonGiveTextbook.setVisibility(View.GONE);
            binding.buttonRemoveTextbook.setOnClickListener(v -> onIGaveAwayTextbookClicked());
        } else {
            // User doesn't have the textbook, show "I Have This Textbook" button
            binding.buttonGiveTextbook.setVisibility(View.VISIBLE);
            binding.buttonRemoveTextbook.setVisibility(View.GONE);
            binding.buttonGiveTextbook.setOnClickListener(v -> onIHaveTextbookClicked());
        }
    }

    // Check if the user has the textbook in their list
    private boolean userHasTextbook() {
        try{
            return user.getTextbooks().contains(textbook);
        }
        catch(Exception e){
            return false;
        }
    }

    // Handle click for "I Gave Away This Textbook" button
    private void onIGaveAwayTextbookClicked() {
        // Remove the textbook from the user's list and add it to the textbook's list
        if (user == null) {
            // Show Snackbar if the user is null
            showSnackbar("Please enter name and contact information first!");
        } else {
            // Remove the textbook from the user's list and add it to the textbook's list
            user.deleteTextbook(textbook);
            textbook.deleteUser(user);
            // Refresh the RecyclerView
            updateUserData();
            changeButtons();
        }
    }

    // Handle click for "I Have This Textbook" button
    private void onIHaveTextbookClicked() {
        if (user == null) {
            // Show Snackbar if the user is null
            showSnackbar("Please enter name and contact information first!");
        } else {
            // Add the user to the textbook's list
            textbook.addUser(user);
            user.addTextbook(textbook);
            // Refresh the RecyclerView
            updateUserData();
            changeButtons();
        }
    }

    // Show a Snackbar with the given message
    private void showSnackbar(String message) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show();
    }

    // Method to update the adapter with data
    private void updateUserData() {
        // Get the list of users from your listener or any other source
        List<User> users = listener.getUsersForTextbook(textbook);
        // Update the adapter with the new data
        userAdapter.setUsers(users);
    }
}
