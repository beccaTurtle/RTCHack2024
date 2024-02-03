package com.example.textbookshare.model;
import java.util.*;

public class User {

    String username;

    String email;
    int id;

    List<Textbook> textbooks;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.textbooks = new ArrayList<Textbook>();
    }

    public String getUsername(){
        return username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Textbook> getTextbooks() {
        return textbooks;
    }

    public List<Textbook> addTextbook(Textbook t){
        textbooks.add(t);
        return textbooks;
    }

    public List<Textbook> deleteTextbook(Textbook t){
        // finish
        textbooks.remove(t);
        return textbooks;
    }



}
