package com.example.textbookshare.model;
import java.util.*;

public class Textbook {
    String title;
    String author;
    List<Post> posts;

    public Textbook(String title, String author){
        this.title = title;
        this.author = author;
        this.posts = new ArrayList<Post>();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


}
