package com.example.textbookshare.model;

public class Post {
    String description;
    User user;
    Textbook textbook;

    public Post(String description, User user, Textbook textbook){
        this.description = description;
        this.user = user;
        this.textbook = textbook;
    }

    public String getDescription(){
        return description;
    }

    public User getUser(){
        return user;
    }

    public Textbook getTextbook(){
        return textbook;
    }

}
