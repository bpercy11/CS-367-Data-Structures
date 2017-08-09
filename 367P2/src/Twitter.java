///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            Program 2
// Files:            Twitter.java, Timeline.java, DblListnode.java,
//					 TweetTooLongException.java, SimpleLinkedList.java
// Semester:         CS302 Fall 2014
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
// CS Login:         Sheng-hu
// Lecturer's Name:  Jim Skrentny
// Lab Section:      -
//
//                   STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
// Credits:          (list anyone who helped you write your program)
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Twitter {

	/**
	 * main is where the user interacts with the program. it has the functions
	 * of following/unfollowing users, printing timelines, printing from a 
	 * certain time on, listing the users, listing the people you follow,
	 * searching for keywords in the timeline, and eventually exiting.
	 * 
	 * 
	 *
	 * @param args args holds an array of the input files
	 */

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in); // for console input
		
		//for storing users names
		List<String> usersString = new ArrayList<String>(); 
		
		//creates new simplelinkedlist object
		SimpleLinkedList<Tweet> sll = new SimpleLinkedList<Tweet>();
		

		//reading files
		try {
			for (int i = 0; i < args.length; i++) {
				File inputFile = new File(args[i]);
				Scanner fileScanner = new Scanner(inputFile);
				
				//checks if users name is already in usersString
				boolean hasUser = false;

				
				//reads each line in and creates a new tweet for each line
				while (fileScanner.hasNextLine()) {
					Tweet newTweet = null;	//new tweet object
					String tweet;		//the tweet message
					String tweetTime1;	//the tweet time
					String username;	//the user who tweeted

					//splits up each line from input file to set tweet, 
					//tweetTime1, and username
					String[] line = fileScanner.nextLine().split(":");
					int tweetTime = Integer.parseInt(line[0]);
					tweet = line[1];
					username = inputFile.getName().substring(0,
							inputFile.getName().length() - 4);
					
	
					//adds users name to usersString if not already in it
					if (!hasUser){
						usersString.add(username);
						hasUser = true;
					}
					
					//adds new tweet to simple linked list sll at position0
					//if sll is empty or to end if it has objects in it
					try{
						newTweet = new Tweet(tweetTime, tweet, username);
						
						if (sll.isEmpty()){
							sll.add(0, newTweet);	
						}
						else {
							sll.add(newTweet);
						}
					}
					//catches tweet too long exception and doesn't add
					//that tweet to the sll
					catch (TweetTooLongException e){
					}
				}

			}

		}
			//catches if input file isn't found
			catch (FileNotFoundException e) {
				System.out.println("File not found");
			}
		
		
		//for creating a simple linked list object of type tweet for each
		//user (file)
		List<SimpleLinkedList<Tweet>> usersList =
				new ArrayList<SimpleLinkedList<Tweet>>();
		

		//creates a list copy of usersString for referring to who you follow
		List<String> usersString_2 = new ArrayList<String>();
		for (int i=0; i<usersString.size(); i++){
			usersString_2.add(usersString.get(i));
		}
		
		
		
		//adds each simplelinkedlist object to the timeline 
		Timeline tLine = new Timeline();
		for (int i = 0; i < sll.size(); i++){
			tLine.add(sll.get(i));
			
		}
		
		
		 boolean done = false;
	        while (!done) {
	            System.out.print("Enter option : ");
	            String input = stdin.nextLine();

	            //only do something if the user enters at least one character
	            if (input.length() > 0) {
	                String[] commands = input.split(" ");//split on space
	                
	                
	                	//for printing all the users in the program
	                    if (commands[0].equals("list")){
	                    	//checks if it is valid command
	                    	if (commands.length==2){
	                    		//for printing all of the users that were read
		                    	if (commands[1].equals("users")){
			                    	for (int i=0; i<usersString.size(); i++){
			                    		System.out.println(usersString.get(i));
			                    	}
		                    	}
		                    	
		                    	//for printing all of the users you follow
		                    	else if (commands[1].equals("following")){
		                    		for (int i=0; i<usersString_2.size(); i++){
			                    		System.out.println(usersString_2.get(i));
			                    	}
		                    	}
	                    	}
	                    	else {System.out.println("Invalid command");}
	                    }
	                    //for following a user you currently aren't following
	                    else if(commands[0].equals("follow")){
	                    	//checks if the user is valid
	                    	if(!(usersString_2.contains(commands[1])) || commands.length>2){
	                    		System.out.println("Invalid user");
	                    	}
	                    	//checks if the users is already followed
	                    	else if(usersString.contains(commands[1])){
	                    		System.out.println("Warning: User already followed");
	                    	}
	                    	//else FOLLOW!
	                    	else {
	                    		for (int i=0; i<sll.size(); i++){
	                    			if (sll.get(i).getUser().equals(commands[1])){
		                    			tLine.add(sll.get(i));
		                    		}
	                    		}
	                    		usersString.add(commands[1]);
	                    	}
	                    }
	                    
	                    //for unfollowing a user you are already follwoing
	                    else if (commands[0].equals("unfollow")){
	                    	//checks if the user is invalid
	                    	if(commands.length ==1 || (commands.length>2 || !(usersString_2.contains(commands[1])))){
	                    		System.out.println("Invalid user");
	                    	}
	                    	//checks if the user is not followed
	                    	else if (!(usersString.contains(commands[1]))){
	                    		System.out.println("Warning: User not followed");
	                    	}
	                    	//else REMOVE!
	                    	else {
	                    	tLine.remove(commands[1]);
	                    		//the for loop takes the user off from usersString
		                    	for (int i=0; i<usersString.size(); i++){
		                    		if (usersString.get(i).equals(commands[1])){
		                    			usersString.remove(i);
		                    		}
		                    	}
	                    	}
	                    }
	                    

	                    //prints all tweets containg the keyword given
	                    else if (commands[0].equals("search")){
	                    	String str = commands[1];
	                    	Timeline newTimeLine = tLine.search(str);
	                    	newTimeLine.print();
	                    }
	                    
	                    //prints all tweets from users you follow
	                    else if (commands[0].equals("print")){
	                    	if (commands.length==1){
	                    	tLine.print();
	                    	}
	                    	else {
	                    		tLine.print(Integer.parseInt(commands[1]));
	                    	}
	                    }
	                    
	                    //exits program
	                    else if (commands[0].equals("quit")){
	                        done = true;
	                        System.out.println("exit");
	                    }
	                        
	                    else{  //a command with no argument
	                        System.out.println("Invalid Command");
	                    }
	                
	            } //end if
	        } //end while
	    } //end main
}