///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            Program 1
// Files:            MovieFlix.java, MovieDatabase.java, Movie.java, 
//                       Capitalize.java
// Semester:         CS367 Fall 2014
//
// Author:           Brett Percy
// Email:            bpercy@wisc.edu	
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
// Email:            slin96@wisc.edu
// CS Login:         sheng-hu
// Lecturer's Name:  Jim Skrentny
// Lab Section:      -
//
//                   STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
// Credits:          (list anyone who helped you write your program)
//////////////////////////// 80 columns wide //////////////////////////////////


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import javax.management.ListenerNotFoundException;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;


/**
 * This class contains the main method for the program. This is where the user
 * will interact with the program via the option menu.
 *
 * <p>Bugs: None known
 *
 * @author Brett Percy, Sheng-Hua Lin
 */
public class MovieFlix {

	
	/**
	 * The main method runs the program. It presents the user with an 
	 * interface that allows them to interact with the database. It has
	 * options c,d,p,r,s,w,x, which all perform different functions on the
	 * database.
	 *
	 * @param args
	 */
   public static void main(String[] args)  {
       //creates a new MovieDatabase object for executing methods in the
	   //MovieDatabase class
	   MovieDatabase mDatabase = new MovieDatabase();
	   
	   //list of integer representing with each index representing each unique
   	   //actor, and the integer representing the number of movies the actor
   	   //is in
   	   List<Integer> actorsList = new ArrayList<Integer>();
	   
       //creates a new MovieDatabase object for executing methods in the
	   //MovieDatabase class 
	   Capitalize cap = new Capitalize();
	   
   	   //creates scanner object used for console input
       Scanner stdin = new Scanner(System.in);  
   	
       //creates boolean done to loop until the user enters 'x'
       boolean done = false;

      
       //new file object for storing the content from the given file of
       //actors and movies
       	File inputFile = new File(args[0]);
   		
           if (args.length < 1){
       		System.out.println("Usage: java MovieFlix FileName");
				System.exit(0);
       	}
       	
       	
           		if (!inputFile.exists())
       			{
       				System.out.println("Error: Cannot access input file");
       				System.exit(0);
       			}
       			else if (!inputFile.canRead()){
       				System.out.println("Error: Cannot access input file");
       				System.exit(0);
       			}		
       	
       			//ArrayList<String> list = new ArrayList<String>();

           try{
        	//scanner object for reading in the inputFile
       		Scanner fileScanner = new Scanner(inputFile);
       		
       		//counts the number of unique actors
       		int numActors = 0;
       		
       		while (fileScanner.hasNextLine()){
       			actorsList.add(new Integer(0));

       			//for storing strings in each line split by each comma
       			String [] strings = fileScanner.nextLine().split(",");
       			
       			//used for determining position in string array, 0 = actor name
       			// anything > 1 = movie name
       			int k = 1;
       			//count the number of movies each unique actor has
       			int numMovies = 0;
       			while (k < strings.length){
       				String k1 = strings[k].toLowerCase();	//converts title 
       				//input to lower case
       				String k2 = cap.toTitleCase(k1);	//capitalizes the first
       				//letter of each word
       				String n1 = strings[0].toLowerCase();	//converts name 
       				//input to lower case
       				String n2 = cap.toTitleCase(n1);	//capitalizes the first
       				//letter of each word
       				
       				mDatabase.addMovie(k2);
       				mDatabase.addActor(n2, k2);
       				k++;
       				numMovies++;
       			}
				actorsList.set(numActors, numMovies);
				numActors++;
       		}	
       		
       	
       	} 
       	catch (FileNotFoundException e) {
       		System.out.println("File not found");	
   		}
           while (!done) {
/*           Movie movieTest = new Movie("new movie!");
       		System.out.println(movieTest.getTitle());*/
        	   
        	   
           System.out.print("Enter option (cdprswx): ");
           //string of the users input
           
           String input = stdin.nextLine();	//input read from scanner
           
           

           //only do something if the user enters at least one character
           if (input.length() > 0) {
               char choice = input.charAt(0); //strip off option character
               String remainder = "";         //will hold the remaining input
               if (input.length() > 1) {      //if there is an argument
                   //trim off any leading or trailing spaces
                   String remainder3 = input.substring(1).trim();	
                   String remainder2 = remainder3.toLowerCase();	//converts
                   //remainder to all lower case
                   remainder = cap.toTitleCase(remainder2);	//capitalizes the
                   //first letter of each word in remainder

                   switch (choice) { //the commands that have arguments

                   case 'c':
                	   if (mDatabase.containsMovie(remainder)){
                		   
                		   //iterator of type movie to traverses through the 
                		   //database of movies
                		   Iterator<Movie> itrMovie = mDatabase.iterator();
                		   while (itrMovie.hasNext()){
                			   
                			   //movie object that gets next movie in list
                			   Movie movieTemp = itrMovie.next();
                			   if (movieTemp.getTitle().equals(remainder)){
                				   
                				   //list that contains actors in a movie
                				   List<String> movieActors = movieTemp.getCast();
                				   if (movieActors==null){
                					   System.out.println("none");
                				   }
                				   else {
                					   //used to see if there is only one Actor
                					   boolean isOneActor = false;
                					   if (movieActors.size()==1){isOneActor = true;}
                					   for (int i=-1; i<movieActors.size()-1; i++){
                						   if (isOneActor){
                							   System.out.println(movieActors.get(i+1));
                						   }
                						   else{
                							   if (i==movieActors.size()-2){
                								   System.out.println(movieActors.get(i+1));
                							   }
                							   else{
                							   System.out.print(movieActors.get(i+1) + ", ");
                							   }
                							   
                						   }
                					   }
                				   }
                			   }
                		   }
                	   }
                	   else {System.out.println("movie not found");}
                       break;

                   case 'p':
                	   //list of movies in which the actor with the given name
                	   //remainder is cast
                	   List<String> movies = mDatabase.getMovies(remainder);
                	   if (!(mDatabase.containsActor(remainder))){
                		   System.out.println("actor not found");
                	   }
                	   else {
                		   
                		   //used for checking if there is one movie
    					   boolean isOneMovie = false;
    					   if (movies.size()==1){isOneMovie = true;}
    					   for (int i=-1; i<movies.size()-1; i++){
    						   if (isOneMovie){
    							   System.out.println(movies.get(i+1));
    						   }
    						   else{
    							   if (i==movies.size()-2){
    								   System.out.println(movies.get(i+1));
    							   }
    							   else{
    							   System.out.print(movies.get(i+1) + ", ");
    							   }
    							   
    						   }
    					   }
    				   }
                		   
                	   
                       break;

                   case 'r':
                	   if (mDatabase.removeMovie(remainder)){
                		   System.out.println("movie removed");
                	   }
                	   else {System.out.println("movie not found");}
                       break;

                   case 's':
                       // The following code reads in a comma-separated sequence 
                       // of strings.  If there are exactly two strings in the 
                       // sequence, the strings are assigned to name1 and name2.
                       // Otherwise, an error message is printed.
                       String[] tokens = remainder.split("[,]+");
                       if (tokens.length != 2) {
                           System.out.println("need to provide exactly two names");
                       }
                       
                       
                       else {
                    	   //string of the first name entered
                           String name1 = tokens[0].trim();
                           //string of the second name entered
                           String name2 = tokens[1].trim();

                          
                           //list of the movies the first actor is in
                           List<String> movieList1 = mDatabase.getMovies(name1);
                           
                           //list of the movies the second actor is in
                           List<String> movieList2 = mDatabase.getMovies(name2);
                           
                           //list for adding if either actors appear in the 
                           //same movie
                           String movieList3 = "";
                    	   
                           for (int i=0; i<movieList1.size(); i++){
                        	   for (int k=0; k<movieList2.size(); k++){
                        		   if (movieList1.get(i).equals(movieList2.get(k))){
                        			   movieList3+=(movieList1.get(i)+", ");
                        		   }
                        	   }
                           }
                           
                           if (movieList3!=""){
                           String movieList4 = movieList3.substring(0,movieList3.length()-2);
                           System.out.println(movieList4);
                           }
                           else {System.out.println("none");}
                       }
                       break;

                   case 'w':
                	   if (mDatabase.containsActor(remainder)){
                		   mDatabase.removeActor(remainder);
                		   System.out.println(remainder + " withdrawn from all movies");
                	   }
                	   else {System.out.println("actor not found");}
                       break;

                   default: //ignore invalid commands
                       System.out.println("Incorrect command.");
                       break;

                   } // end switch
               } // end if
               else { //if there is no argument
                   switch (choice) { //the commands without arguments

                   case 'd': 

                	   //1
                	   List<String> numActors = new ArrayList<String>();	//List of each unique actors
                	   int numMovies = mDatabase.size();	//number of unique movies
                	   Iterator<Movie> itr = mDatabase.iterator();	//iterator for movie database

                	   while (itr.hasNext()){
                		   List<String> currMov = itr.next().getCast();	//gets
                		   //the list of actors of current Movie of the iterator
                		   for (int iCast = 0; iCast<currMov.size(); iCast++){
                			   boolean contains = false; //used to check if the
                			   //cast is a unique actor
                			   for (int iActors = 0; iActors<numActors.size(); iActors++){
                				   if (numActors.get(iActors).equals(currMov.get(iCast))){
                					   contains = true;
                				   }
                			   }
                			   if (!contains) {numActors.add(currMov.get(iCast));}
                		   }
                	   }
                	   System.out.println("Movies: "+numMovies+", Actors: "+numActors.size());

                	   //2
                	   
                	   Iterator<Movie> itr2_1 = mDatabase.iterator();	//used
                	   //to traverse through the database (new one to get the
                	   //first position of database)
                	   int largest = 0;	//the count for the largest number of actors being cast in a movie
                	   int least = itr2_1.next().getCast().size();	// the count for the least number of actors being cast in a movie
                	   int total = 0;	//the count for the total number of casts of all the movies
                	   String largestCast = "";	//string for the Movie Title containing the largest number of cast
                	   String smallestCast = "";	//string for the Movie Title containing the least number of cast
                	   
                	   
					   Iterator<Movie> itr2 = mDatabase.iterator();	//used to
					   //traverse through the database (to compare largest and
					   //least integers)
                	   while (itr2.hasNext()){
                		   Movie temp = itr2.next();
                		   if (temp.getCast().size()>largest){
                			   largest = temp.getCast().size();
                			   
                		   }
                		   else if (temp.getCast().size()<least){
                			   least = temp.getCast().size();
                		   }
                		   total += temp.getCast().size();
                	   }
                	   
            		   Iterator<Movie> itr2_2 = mDatabase.iterator();// used to
            		   //traverse through the iterator to add to largestCast
            		   while (itr2_2.hasNext()){
            			   Movie temp2 = itr2_2.next();	//temp for current
            			   //Movie
            			   if (temp2.getCast().size()==least){
            			   smallestCast+=((temp2.getTitle())+", " + "");
            			   }
            			   if (temp2.getCast().size()==largest){
            				   largestCast+=((temp2.getTitle())+",");
            			   }
            		   }
                	   
                	   double roundUp = (double)total/numMovies;	//double of
                	   //the average number
                	   int average = (int)(roundUp + 0.5);	//casts roundUp +
                	   //0.5 to Int to perform correct rounding of integer
                	   System.out.println("# of actors/movie: most " +largest+", least "+least+", average "+average);

                	   //3
                	   int mLargest = 0;	//count for the actor casting in the largest number of movies
                	   int mLeast = actorsList.get(0);	//count for the actor casting in the least number of movies
                	   int mTotal = 0;	//count for the total number of movies each unique actor is casted in
                	   for (int i=0; i<actorsList.size(); i++){
                		   if (actorsList.get(i) > mLargest){ mLargest = actorsList.get(i);}
                		   else if (actorsList.get(i) < mLeast) { mLeast = actorsList.get(i);}
                		   mTotal += actorsList.get(i);
                	   }
                	   //double of the average number
                	   double mRoundUp = (double)mTotal/actorsList.size();
                	   int mAverage = (int)(mRoundUp + 0.5);//casts mRoundUp +
                	   //0.5 to Int to perform correct rounding of integer
                	   System.out.println("# of movies/actor: most "+mLargest+", least "+mLeast+", average "+ mAverage);
                	   
                	   //4
                	   //takes out the last comma
                	   largestCast = largestCast.substring(0, largestCast.length()-2);
                	   System.out.println("Largest Cast: "+largestCast+" ["+largest+"]");
                	   
                	   //5
                	   //takes out the last comma
                	   smallestCast = smallestCast.substring(0, smallestCast.length()-2);
                	   System.out.println("Smallest Cast: "+smallestCast+" ["+least+"]");


                	   break;
                   	  
                   	   //System.out.println("Movies: "+mDatabase.size()+ ", Actors: "+ mDatabase.getCast(t));

                   case 'x':
                       done = true;
                       System.out.println("exit");
                       break;

                   default:  //a command with no argument
                       System.out.println("Incorrect command.");
                       break;
                   } //end switch
               } //end else  
          } //end if
       } //end while
   } //end main

}