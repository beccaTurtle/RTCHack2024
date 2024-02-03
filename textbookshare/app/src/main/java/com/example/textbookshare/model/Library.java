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
            int relevance = 0;

            for (String term : inputArray) {
                for(String titleTerm : titleArray){
                    if(term.equals(titleTerm)){
                        relevance++;
                        break;
                    }
                }
                for(String authTerm : titleArray){
                    if(term.equals(authTerm)){
                        relevance++;
                        break;
                    }
                }
            }
            t.setRelevance(relevance);
        }

        Collections.sort(results);
        return results;
    }

}
