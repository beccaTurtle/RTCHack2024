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
        Textbook t1 = new Textbook("Organizational Behavior", "Stephen Robbins");
        textbooks.add(t1);
        Textbook t2 = new Textbook("International Business", "John Daniels");
        textbooks.add(t2);
        Textbook t3 = new Textbook("Computer Networks and Internets", "Douglas Comer");
        textbooks.add(t3);
        Textbook t4 = new Textbook("Computer Ethics", "Deborah Johnson");
        textbooks.add(t4);
        Textbook t5 = new Textbook("Database Systems", "Douglas Comer");
        textbooks.add(t5);
        Textbook t6 = new Textbook("Architecture of Computer Hardware", "Irv Englander");
        textbooks.add(t6);
    }

}
