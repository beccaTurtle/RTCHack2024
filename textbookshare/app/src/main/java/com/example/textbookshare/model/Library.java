package com.example.textbookshare.model;
import java.util.*;

public class Library {
    List<Textbook> textbooks;

    public Library(){
        textbooks = new ArrayList<Textbook>();
        loadSampleBooks();
    }

    public List<Textbook> search(String input){
        List<Textbook> results = new ArrayList<Textbook>();
        String[] inputArray = input.toLowerCase().split(" ");

        for (Textbook t : textbooks){
            String[] titleArray = t.getTitle().toLowerCase().split(" ");
            String[] authorArray = t.getAuthor().toLowerCase().split(" ");
            int relevance = 0;

            for (String term : inputArray) {
                for(String titleTerm : titleArray){
                    if(term.equals(titleTerm)){
                        relevance++;
                    }
                }
                for(String authTerm : authorArray){
                    if(term.equals(authTerm)){
                        relevance++;
                    }
                }
            }
            t.setRelevance(relevance);

            if (relevance > 0){
                results.add(t);
            }
        }

        Collections.sort(results);
        return results;
    }

    public void addBook(Textbook newBook) {
        if (!this.inLibrary(newBook)) {
            textbooks.add(newBook);
        }
    }

    private boolean inLibrary(Textbook newBook){
        for (Textbook t : textbooks) {
            if (t.sameTextbook(newBook)){
                return true;
            }
        }
        return false;
    }


    public void loadSampleBooks(){
        Textbook t1 = new Textbook("Title 1", "Author 1");
        textbooks.add(t1);
        Textbook t2 = new Textbook("Title 2", "Author 2");
        textbooks.add(t2);
        Textbook t3 = new Textbook("Another title 2", "Another title 2");
        textbooks.add(t3);
    }

}
