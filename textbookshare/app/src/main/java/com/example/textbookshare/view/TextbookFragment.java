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

    public TextbookFragment(Listener listener, Textbook t) {
        this.listener = listener;
        this.textbook = t;
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

        // Call a method to fill the adapter with data (you may need to change this based on your requirements)
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
