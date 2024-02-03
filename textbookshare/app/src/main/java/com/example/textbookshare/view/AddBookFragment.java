package com.example.textbookshare.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

import com.example.textbookshare.R;
import com.example.textbookshare.databinding.FragmentAddBookBinding;
import com.example.textbookshare.databinding.FragmentProfileBinding;
import com.example.textbookshare.model.Library;
import com.example.textbookshare.model.Textbook;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddBookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddBookFragment extends Fragment {

    Listener listener;

    FragmentAddBookBinding binding;

    public AddBookFragment(Listener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentAddBookBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        this.binding.addBookBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String bookName = AddBookFragment.this.binding.bookName.getText().toString();
                String authorName = AddBookFragment.this.binding.authorName.getText().toString();

                if(TextUtils.isEmpty(bookName) || TextUtils.isEmpty(authorName)){
                    //Display a message or handle the case where required fields are empty
                    Toast.makeText(getContext(), "Book name and author name are required", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Proceed with adding the book, including optional fields
                    Textbook newBook = new Textbook(bookName, authorName);

                    AddBookFragment.this.listener.onAddToLibrary(newBook);


                    Toast.makeText(getContext(), "Book added successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
