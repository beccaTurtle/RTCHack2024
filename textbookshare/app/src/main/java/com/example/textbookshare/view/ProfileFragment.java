package com.example.textbookshare.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.textbookshare.R;
import com.example.textbookshare.databinding.FragmentProfileBinding;
import com.example.textbookshare.databinding.FragmentSearchBinding;

public class ProfileFragment extends Fragment {

    Listener listener;

    FragmentProfileBinding binding;

    public ProfileFragment(Listener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentProfileBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (this.listener.userExists()){
            this.binding.usernameDisplay.setText("Username: " + this.listener.getUsername());
            this.binding.emailDisplay.setText("Email: " + this.listener.getEmail());
        }
        this.binding.error.setText("");

        this.binding.profileUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable usernameE = ProfileFragment.this.binding.username.getText();
                String newUsername = usernameE.toString();

                Editable emailE = ProfileFragment.this.binding.email.getText();
                String newEmail = emailE.toString();

                if ((newUsername.length() > 3) && (newEmail.length() > 3)) {
                    ProfileFragment.this.listener.onUpdateProfile(newUsername, newEmail);
                    ProfileFragment.this.binding.usernameDisplay.setText("Username: " + ProfileFragment.this.listener.getUsername());
                    ProfileFragment.this.binding.emailDisplay.setText("Email: " + ProfileFragment.this.listener.getEmail());
                    ProfileFragment.this.binding.error.setText("");
                }
                else {
                    ProfileFragment.this.binding.error.setText("Error updating profile");
                }
            }
        });


    }
}