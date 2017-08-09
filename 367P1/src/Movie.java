///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  MovieFlix.java
// File:             Movie.java
// Semester:         CS367 Fall 2014
//
// Author:           Brett Percy	
// CS Login:         percy
// Lecturer's Name:  Jim Skrentny
// Lab Section:      -
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                   If allowed, learn what PAIR-PROGRAMMING IS, 
//                   choose a partner wisely, and complete this section.
//
// Pair Partner:     Sheng-Hua Lin
// CS Login:         sheng-hu
// Lecturer's Name:  Jim Skrentny
// Lab Section:      -
//
//                   STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
// Credits:          (list anyone who helped you write your program)
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.*;

/**
 * The Movie class represents a single movie that keeps track of its
 * title and cast of actors.
 * 
 * @author CS 367 copyright 2014
 */
public class Movie {

    private String title;       // the movie title
    private List<String> cast;  // the list of actors in the movie
    
    /**
     * Constructs a movie with the given title and an empty cast.
     * 
     * @param title The title of this movie.
     */
    public Movie(String title) {
        this.title = title;
        cast = new ArrayList<String>();
    }
    
    /**
     * Returns the title of this movie.
     * 
     * @return The title of this movie.
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Returns the cast of actors in this movie.
     * 
     * @return The cast for this movie.
     */
    public List<String> getCast() {
        return cast;
    }
}