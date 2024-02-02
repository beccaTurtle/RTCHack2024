package com.example.textbookshare.model;
import java.util.*;

public class User {
    String username;
    String email;
    int id;

    List<Post> posts;

    public User(String username, String email, int id) {
        this.username = username;
        this.email = email;
        this.id = id;
        this.posts = new ArrayList<Post>();
    }

    public String getUsername(){
        return username;
    }

    public String getEmail() {
        return email;
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
