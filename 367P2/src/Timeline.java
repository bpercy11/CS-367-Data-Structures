///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Twitter.java
// File:             Timeline.java
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


import java.util.List;

/**
 * The Timeline class uses SimpleLinkedList to build a time ordered list of
 * following tweets. Tweets with smaller Time fields should come earlier in the
 * list.
 */
class Timeline {

	private SimpleLinkedList<Tweet> list;//creates new simplelinked list of 
	//type tweet
	
	private int numItems;					//creates int numItems

	/**
	 * Constructs an empty timeline
	 */
	public Timeline() {
		list = new SimpleLinkedList<Tweet>();	//initializes list
		numItems = 0;				//initializes numItems = 0
	}

	/**
	 * Adds a single tweet to the Timeline
	 * 
	 * @param tweet
	 *            the tweet to add
	 */
	public void add(Tweet tweet) {
		//if the timeline is empty add the tweet to the first position
		if (numItems == 0){
			list.add(tweet);
			numItems++;
		}
		
		//if timeline isn't empty, checks if tweettime of tweet being added is
		//less than the first tweet in the timeline, if so adds it at pos 0
		else if (tweet.getTime() < list.get(0).getTime()){
			list.add(0, tweet);
			numItems++;
		}
		
		//traverses thru timeline to add the tweet at the correct tweet time 
		//and position
		else{
			int count = 0;
			for (int i=0; i<list.size(); i++){
				if (tweet.getTime()>list.get(i).getTime()){
					count++;
				}
			}
			//adds tweet at position count
			list.add(count, tweet);
			numItems++;
		}
		
	}

	/**
	 * Adds an ordered list of tweets to the Timeline
	 * 
	 * @param tweets
	 *            the list of tweets to add
	 */
	public void add(List<Tweet> tweets) {
		List<Tweet> tws = tweets;	//tws initialized to list tweets passed in
		for(int i=0; i<tweets.size(); i++){
		list.add(tws.get(i));		//adds tws to timeline
		}
	}

	/**
	 * Removes all tweets by user from the Timeline
	 * 
	 * @param user
	 *            the user whose tweets should be removed
	 */
	public void remove(String user) {
		
		for (int i=0; i<list.size(); i++){
			if (list.get(i).getUser().equals(user)){
				list.remove(i);
				i--;	//to prevent the list from skipping the item at the
				//position that was just removed
				numItems--;	//decrement numItems
			}
		}
		
	}

	/**
	 * Create a new Timeline containing only the tweets containing keyword
	 * 
	 * @param keyword
	 *            the keyword to search for
	 * @return a Timeline of tweets containing keyword
	 */
	
	  public Timeline search(String keyword){
		 Timeline newTLine = new Timeline(); //new tl for tweets containing
		 									// the keyword
		 for (int i=0; i<list.size(); i++){
			 if ((list.get(i).getMessage().contains(keyword))){
				 newTLine.add(list.get(i));
			 }
		 }
		 return newTLine;
	 }
	 

	/**
	 * Print each tweet in the timeline
	 */
	public void print() {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).print();
		}
	}

	/**
	 * Print each tweet in the timeline since time
	 * 
	 * @param time
	 *            the largest time to print tweets
	 */
	public void print(int time) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (time > list.get(i).getTime()){
				count++;
			}
		}
		for (int i = 0; i < count; i++) {
			list.get(i).print();
		}
	}
}