package com.example.textbookshare.model;
import java.util.*;

public class User {

    String username;

    String email;
    int id;

    List<Post> posts;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.posts = new ArrayList<Post>();
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

    public List<Post> getPosts() {
        return posts;
    }

    public List<Post> addPost(Post p){
        posts.add(p);
        return posts;
    }

    public List<Post> deletePost(Post p){
        // finish
        return posts;
    }



}
