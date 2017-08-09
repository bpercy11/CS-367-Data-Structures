///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Twitter.java
// File:             Tweet.java
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

/**
 * Stores the time, message and user of a Tweet
 */
class Tweet{

	
	private int time;		//holds the time of a tweet
	private String message; // holds the message of a tweet
	private String user;	// holds the users name of the tweet
    /**
     * Constructs a Tweet for user with message at time. 
     * Throws a TweetTooLongException if message over 140 characters.
     * 
     * @param time time at which tweet occured
     * @param message message of the tweet, <=140 characters
     * @param user the person who tweeted the tweet 
     * @throws TweetTooLongException if message over 140 characters 
     */
    public Tweet(int time, String message, String user) throws TweetTooLongException{ 
    	this.time = time;	//initializes time from what time is passed in
    	this.message = message; //intitializes the message from what string is
    							//passed in
    	this.user = user;		//initializes the users name to what string is
    							//passed in
    	
    	//if tweet length is too long, throws a tweet too long exception
	    	if (message.length() > 140){
	    		throw new TweetTooLongException();
	    	}
    }

    /** 
     * Returns the stored message of the Tweet
     * @return the message
     */
    public String getMessage(){
    	return message;
    }
    
    /** 
     * Returns the stored time of the Tweet
     * @return the stored time
     */
    public int getTime(){
    	return time;
    }

    /** 
     * Returns the user who tweeted the Tweet
     * @return the user
     */
    public String getUser(){
    	return user;
 
    }

    /** 
     * Print the Tweet with the following format: <TIME> <USER>:<MESSAGE>
     */
    public void print(){
    	System.out.println(time+" "+user+":"+message);
    }
}