///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  TrainSimulator.java
// File:             Platform.java
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
 * Platform represents a train stations platform that stores train objects. It
 * implements PlatformADT. It acts like a stack where the trains can be stored
 * and accessed in a last in first out fashion
 * 
 * @author Brett Percy, Norman Lin
 *
 */
public class Platform implements PlatformADT{
	private int capacity;
	SimpleStack<Train> sStack;
	
	/**
	 * Constructor for the platform object which uses a simple stack object
	 * to store things or remove things in the platform. The array used by
	 * the simple stack object is initialized by the parameter int capacity 
	 * 
	 * @param capacity capacity is the size of the array used by simplestack
	 * object
	 */
	public Platform(int capacity){
		this.capacity = capacity;	//sets the platforms capacity based on 
									//the files input on the stations info
		
		//initializes a simple stack object of type train with size capacity
		sStack = new SimpleStack<Train>(capacity);
	}
	
	
	/**
	 * put method is equivalent to the a stacks push function. It puts a train
	 * object into the platform in a last in first out manner. The parameter
	 * is the train you want to put into the platform.
	 * 
	 * @param item item is a train object you want to put into the platform
	 * @throws FullPlatformException throws if platform is at capacity
	 */
	public void put(Train item) throws FullPlatformException{
		try {
			//pushes a train item into the simple stack if its not full
			sStack.push(item);
			
		} 
			//catches fullstackexception if stack is full, handles exception
			//by throwing a new fullplatformexception
		catch (FullStackException e) {
			throw new FullPlatformException();
		}
	}

	
	/**
	 * get method is equivalent to a stacks pop function. It returns a train
	 * object that was in the first position in the platform. 
	 * 
	 * @return Train train in teh first position in the platform is returned
	 * @throws EmptyPlatformException throws if platform is empty when trying
	 * to get a train object
	 */
	public Train get() throws EmptyPlatformException{
		Train temp;
		try {
			//sets train item in last position of simple stack array equal
			//to a temp variable
			temp = (Train) sStack.pop();
		} 
			//catches empty stack exception and handles by throwing a new
			//empty platform exception
		catch (EmptyStackException e) {
			throw new EmptyPlatformException();
		}
		//returns the temp variable holding a train item
		return temp;
	}

	
	/**
	 * check looks into the information of the train in the first position on
	 * the platform. It doesn't remove the train. Check is equivalent to a 
	 * stacks peek function
	 * 
	 * @return Train train in the first position of the platform is returned
	 * @throws EmptyPlatformException throws if platform is empty when trying 
	 * to check for a train object
	 */
	public Train check() throws EmptyPlatformException{
		
		try {
			//returns train item in last position in array of simple stack
			//object
			return (Train) sStack.peek();
		} catch (EmptyStackException e) {
			throw new EmptyPlatformException();
		}
	}

	
	/**
	 * isEmpty returns true if the platform doesn't have any trains in it
	 * 
	 * @return true if the platform is empty
	 */
	public boolean isEmpty() {
		return sStack.isEmpty();
	}

	
	/**
	 * isFull returns true if the platform can't fit any more trains in it
	 * 
	 * @return true is the platform is full
	 */
	public boolean isFull() {
		return sStack.isFull();
	}

}