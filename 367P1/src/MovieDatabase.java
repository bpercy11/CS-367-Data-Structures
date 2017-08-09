///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  MovieFlix.java
// File:             MovieDatabase.java
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
 * 
 * The MovieDatabase class provides the program with all the operations
 * used for adding, removing, and retrieving movies and actors into the 
 * database.
 *
 * <p>Bugs: none known
 *
 * @author Brett Percy, Sheng-Hua Lin
 */

/**
 * 
 * addMovie adds each movie read in from the input file as a new Movie
 * object.
 *
 * @param String t
 */
public class MovieDatabase {

	//creates database list
	List<Movie> database;
	
	/**
	 * 
	 * This method constructs an empty database
	 *
	 */
	public MovieDatabase(){
		//empty database
		database = new ArrayList<Movie>();
	}
	
	/**
	 * 
	 * List method returns the list 'database' of type Movie
	 *
	 * @return database
	 */
	public List<Movie> getD(){
		
		return database;
	}
	
	
	/**
	 * 
	 * addMovie adds each movie read in from the input file as a new Movie
	 * object.
	 *
	 * @param String t is the Movie Title passed
	 */
	public void addMovie(String t){
		
		//used for checking if the movie already exists in database
		boolean exists = false;
		if (t==null){
			throw new IllegalArgumentException("");
		}
		else {
			
			//iterator for traversing thru database
			Iterator<Movie> itr = database.iterator();
			while (itr.hasNext()){
				
				//movie object that gets next movie in database
				Movie temp = itr.next();
				if (temp.getTitle().equals(t)){
					exists = true;
				}
			}
		}
		if (!exists){
			
		//creates new movie object if one with the same name isn't already
		// in the database
		Movie tempMovie = new Movie(t);
		database.add(tempMovie);
		}
/*		for (int i = 0; i < database.size(); i++){
			System.out.println(database.get(i).getTitle());
		}*/
		
	}
	
	
	/**
	 * 
	 * addActor adds an actor name to whatever Movie object that contains
	 * the movie title that they appear in
	 *
	 * @param String n is the actor name passed
	 * @param String t is the movie title passed
	 */
	public void addActor(String n, String t){

		//iterator for traversing thru database
		Iterator<Movie> itr = database.iterator();
		
		//used for checking if a movie exists
		boolean MovieExists = false;
		
		//used for checking if an actor already exists in database
		boolean ActorExists = false;
		while (itr.hasNext()){
			
			//movie object that gets next movie in database
			Movie temp = itr.next();
			if (temp.getTitle().equals(t)){
			MovieExists = true;
			
			//iterator that traveres thru the cast list
			Iterator<String> castItr = temp.getCast().iterator();
				while (castItr.hasNext()){
					
					//string for getting and holding the next string in the 
					//cast list
					String castTemp = castItr.next();
					if (castTemp.equals(n)){
					ActorExists = true;
					}
				}
				if (!ActorExists){
				temp.getCast().add(n);
				
				}
			}
		}
		if (!MovieExists){
			throw new IllegalArgumentException("");
		}
	}
	
	
	/**
	 * 
	 * removeMovie removes a given movie from the database
	 *
	 * @param String t is the movie title passed
	 * @return boolean foundMovie true if movie is found, false if not found
	 */
	public boolean removeMovie(String t){
		
		//used for checking if the movie that wants to be removed is found
		boolean foundMovie = false;
		if (t==null){
			throw new IllegalArgumentException();
		}
		else {
			
			//iterator for traversing thru the database
			Iterator<Movie> itr = database.iterator();
			while (itr.hasNext()){
				
				//movie object that gets the next movie in database
				Movie temp = itr.next();
				if (temp.getTitle().equals(t)){
					itr.remove();
					foundMovie = true;
				}
			}
		}
		return foundMovie;
	}
	
	
	/**
	 * 
	 * containsMovie goes through the database and checks if the given name
	 * of a movie is already in the database
	 *
	 * @param String t is the actor name passed
	 * 
	 * @return Return true iff a movie with the title t is in the database.
	 */
	public boolean containsMovie(String t){
		if (t==null){
			throw new IllegalArgumentException();
		}
		else {
			//iterator for traversing thru the database
			Iterator<Movie> itr = database.iterator();
			while (itr.hasNext()){
				if ((itr.next().getTitle()).equals(t)){
					return true;
				}
			}
		}
			return false;
	}
	
	
	/**
	 * 
	 * containsActor checks the database if an actor is cast in a movie or not.
	 *
	 * @param String n is the actor name passed
	 * 
	 * @return Return true iff an actor with the name n appears in the cast 
	 * 		   for at least one movie in the database.
	 */
	boolean containsActor(String n){
		//creates movie object to be used in 'else' statement
		Movie temp;
		if (n==null){
			throw new IllegalArgumentException();
		}
		else {
			Iterator<Movie> itr = database.iterator();
			while (itr.hasNext()){
				//initializes movie object to get next movie in database
				temp = itr.next();
				for (int i=0; i<temp.getCast().size(); i++){
					if (temp.getCast().get(i).equals(n)){
						return true;
					}
				}
			}
		}
			return false;
		
	}
	
	
	
	/**
	 * 
	 * isCast checks if an actor is in a given movie in the database.
	 *
	 * @param  String n is the name of the actor passed
	 * @param  String t is the title of the movie passed
	 * @return Returns true iff the given actor n is cast in the movie with
	 * 		   the given title t. If a movie with the title t is not in the 
	 * 		   database, return false.
	 */
	public boolean isCast(String n, String t){
		if (n==null){
			throw new IllegalArgumentException();
		}
		
		//used for checking if the actor is in the given movie
		boolean contains = false;
		
		//creates movie object to be used to get next movie in database
		Movie temp;
		
		//iterator for traversing thru the database
		Iterator<Movie> itr = database.iterator();
		while (itr.hasNext()){
			temp = itr.next();
			if (temp.getTitle().equals(t)){
				for (int i=0; i<temp.getCast().size(); i++){
					if (temp.getCast().get(i).equals(n)){
						contains = true;
					}
				}
			}
			
		}
		return contains;
	}
	
	
	
	
	/**
	 * 
	 * getCast returns a list of the cast in a movie.
	 *
	 * @param String t is the name of the title passed
	 * @return a list of the cast for a given movie.
	 */
	public List<String> getCast(String t){
		
		//list for storing the actors in the given movie
		List<String> actors = new ArrayList<String>();
		
		//iterator for traversing thru the database
		Iterator<Movie> itr = database.iterator();
		
		//creates movie object to be used to get next movie in database
		Movie temp;
		if (t==null){
			throw new IllegalArgumentException();
		}
		else {
			while (itr.hasNext()){
				temp = itr.next();
				if (temp.getTitle().equals(t)){
				 actors = temp.getCast();
				}
			}
		}
		return actors;
	}
	
	
	
	
	/**
	 * 
	 * getMovies gives you all the movies that a given actor is cast in.
	 *
	 * @param  String n is the name of the actor passed
	 * @return a list of Movies that a given actor appears in
	 */
	public List<String> getMovies(String n){
		
		//list for storing the movies an actor appears in
		List<String> movies = new ArrayList<String>();
		
		//creates movie object to be used to get next movie in database
		Movie temp;
		if (n==null){
			throw new IllegalArgumentException();
		}
		else {
			
			//iterator for traversing thru the database
			Iterator<Movie> itr = database.iterator();
			while (itr.hasNext()){
				temp = itr.next();
				
				//stores actors in a certain movie
				List<String> actors = temp.getCast();
				for (int i=0; i<temp.getCast().size(); i++){
					if (actors.get(i).equals(n)){
						movies.add(temp.getTitle());
					}
				}
			}
		}
		return movies;
	}
	
	
	/**
	 * iterator returns a iterator.
	 * 
	 * @return an iterator of the database
	 */
	public Iterator<Movie> iterator(){
		//iterator for traversing thru the database
		Iterator<Movie> itr = database.iterator();
		return itr;
		
	}
	
	
	
	/**
	 * 
	 * size gives you the number of movies in the database.
	 * 
	 * 
	 * @return an integer of the number of movies in the database.
	 */
	public int size(){
		
		//integer used for counting number of movies
		int size = 0;
		
		//iterator for traversing thru the database
		Iterator<Movie> itr = database.iterator();
		while (itr.hasNext()){
			size++;
			itr.next();
		}
		return size;
	}
	
	
	
	/**
	 * 
	 * removeActor removes a given actor from all the movies he was cast in
	 * in the database.
	 *
	 * @param String n is the name of the actor passed
	 * @return true if the actor was removed from the movies he was in.
	 */
	public boolean removeActor(String n){
		
		//used for checking if the actor has been removed from each movie
		//he/she was in
		boolean removed = false;
		//iterator for traversing thru the database
		Iterator<Movie> itr = database.iterator();
		while (itr.hasNext()){
			//movie object that gets next movie in database
			Movie temp = itr.next();
			for (int i=0; i<temp.getCast().size(); i++)
				if (temp.getCast().get(i).equals(n)){
					temp.getCast().remove(n);
				}
		}
		
		return removed;
		
	}
}