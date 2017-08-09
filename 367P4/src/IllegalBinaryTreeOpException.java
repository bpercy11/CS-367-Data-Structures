///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  GuessingGame.java
// File:             IllegalBinaryTreeOpException.java
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
 * IllegalBinaryTreeOpException extends the Exception class. It is used when
 * a tree operation cannot be executed.
 * 
 * @author Brett Percy, Norman Lin
 *
 */
public class IllegalBinaryTreeOpException extends Exception{
	public IllegalBinaryTreeOpException(){
		
	}
	
	/**
	 * IllegalBinaryTreeOpException prints a tailored message to which tree
	 * operation cannot be executed to inform the user of what went wrong
	 * 
	 * @param message is the tailored message to whatever tree method threw
	 * an exception.
	 */
	public IllegalBinaryTreeOpException(String message){
		super(message);
	}
}