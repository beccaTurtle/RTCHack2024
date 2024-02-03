package com.example.textbookshare.model;
import java.util.*;

public class Textbook implements Comparable<Textbook>{
    String title;
    String author;
    List<User> users;
    int relevance;

    public Textbook(String title, String author){
        this.title = title;
        this.author = author;
        this.users = new ArrayList<User>();
        this.relevance = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public int getRelevance() {
        return relevance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    @Override
    public int compareTo(Textbook t)
    {
        if (this.relevance > t.relevance) {
            return -1;
        }
        else if (this.relevance < t.relevance) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public void addUser(User u){
        users.add(u);
    }

    public void deleteUser(User u){
        users.remove(u);
    }

}
