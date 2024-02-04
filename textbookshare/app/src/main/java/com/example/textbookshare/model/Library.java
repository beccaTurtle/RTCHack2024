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
        User u1 = new User("Caroline Smith", "csmith@vassar.edu");
        User u2 = new User("Elta B", "helloworld@gmail.com");
        User u3 = new User("Becca", "beccathebeast@hotmail.com");
        Textbook t1 = new Textbook("Organizational Behavior", "Stephen Robbins");
        t1.addUser(u1);
        u1.addTextbook(t1);
        textbooks.add(t1);
        Textbook t2 = new Textbook("International Business", "John Daniels");
        textbooks.add(t2);
        Textbook t3 = new Textbook("Computer Networks and Internets", "Douglas Comer");
        t3.addUser(u1);
        u1.addTextbook(t3);
        t3.addUser(u2);
        u2.addTextbook(t3);
        textbooks.add(t3);
        Textbook t4 = new Textbook("Computer Ethics", "Deborah Johnson");
        t4.addUser(u2);
        u2.addTextbook(t4);
        textbooks.add(t4);
        Textbook t5 = new Textbook("Database Systems", "Douglas Comer");
        t5.addUser(u3);
        u3.addTextbook(t5);
        textbooks.add(t5);
        Textbook t6 = new Textbook("Architecture of Computer Hardware", "Irv Englander");
        textbooks.add(t6);
    }

}
