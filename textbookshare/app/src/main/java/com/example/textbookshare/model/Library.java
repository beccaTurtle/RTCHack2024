package com.example.textbookshare.model;
import java.util.*;

public class Library {
    List<Textbook> textbooks;

    public Library(){
        textbooks = new ArrayList<Textbook>();
    }

    public List<Textbook> search(String input){
        List<Textbook> results = new ArrayList<Textbook>();
        String[] inputArray = input.toLowerCase().split(" ");

        for (Textbook t : textbooks){
            String[] titleArray = t.getTitle().toLowerCase().split(" ");
            String[] authorArray = t.getAuthor().toLowerCase().split(" ");


            for (String term : inputArray) {

            }
        }

    }

}
