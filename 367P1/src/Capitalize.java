///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  MovieFlix.java
// File:             Capitalize.java
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
 * 
 * The Capitalize class is used for capatilizing the first letter in each word
 * that is read into the database.
 *
 * <p>Bugs: none known
 *
 * @author Brett Percy, Sheng-Hua Lin
 */
public class Capitalize {
	
	
	/**
	 * 
	 * This method changes every letter in each word to lower case then goes 
	 * through and capitalizes the first letter of each word.
	 *
	 * @param String givenString
	 * @return String in the correct form
	 */
	public String toTitleCase(String givenString) {
		//string that adds each word after a blank space
	    String[] toCap = givenString.split(" ");
	    //new string buffer object for adjusting the strings in toCap[]
	    StringBuffer capped = new StringBuffer();

	    for (int i = 0; i < toCap.length; i++) {
	        capped.append(Character.toUpperCase(toCap[i].charAt(0)))
	            .append(toCap[i].substring(1)).append(" ");
	    }          
	    return capped.toString().trim();
	}  
}