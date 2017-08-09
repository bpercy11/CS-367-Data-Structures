///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  TrainSimulator.java
// File:             SimpleStack.java
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
 * SimpleStack represents a stack and implements StackADT. It has push, pop, 
 * and peek functions. It uses an array to allow the functions to happen.
 * 
 * @author Brett Percy, Norman Lin
 */
public class SimpleStack<E> implements StackADT {

	private E items[];
	int numItems;
	int capacity;
	
	
	/**
	 * constructor for the SimpleStack object. Simplestack uses an array to 
	 * execute the stack functions. 
	 * @param capacity
	 */
	public SimpleStack (int capacity) {
		this.capacity = capacity; 	//sets stacks array size
		
		//initializes array of generic type with size capacity
		items =  (E[]) new Object[capacity]; 
											
	}
	
	
	/**
	 * push lets you add objects to the stack. It adds the item to the position
	 * at the array's length.
	 * 
	 * @param item item can be any object you want added to the stack
	 * @throws FullStackException throws if the stack is full
	 */
	public void push(Object item) throws FullStackException {
		//throws a fullstackexception if the stack is full when trying to push
		if (isFull()){
			throw new FullStackException();
		}
		
		//else puts the new object into the array at the end
		else{
		items[numItems] = (E)item;
		numItems++;
		}
		
	}

	/**
	 * pop method returns the train object at the position of the arrays
	 * length. It then sets the object at that position equal to null, removing
	 * it from the array entirely.
	 * 
	 * @return Object returns a train object
	 * @throws EmptyStackException throws if the stack is empty when trying to 
	 * access a object from teh stack
	 */
	public Object pop() throws EmptyStackException {
		//throws emptystackexception if stack is emtpy when trying to pop item
		if (isEmpty()){
			throw new EmptyStackException();
		}
		
		else{
		//sets the last item in the array equal to a temp variable
		//then sets the actual item at that position equal to null
		//and returns the temp variable
		Object temp = items[numItems-1]; 
		items[numItems-1] = null;
		numItems--;
		return temp;
		}
	}

	/**
	 * peek method returns the train object at the position at arrays length
	 * but doesn't remove the train from the array.
	 * 
	 * @return Object returns a train object at position arrays length
	 * @throws EmptyStackException throws if staack is empty when trying to 
	 * get a train object 
	 */
	public Object peek() throws EmptyStackException {
		//throws emptystackexception if stack is emtpy when trying to peek item
		if (isEmpty()){
			throw new EmptyStackException();
		}
		//returns the last item in the array
		else{
		return items[numItems-1];
		}
	}

	/**
	 * isEmpty returns true if the stack is empty
	 * 
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		
		return numItems == 0;	//returns true if stack is empty
	}

	/**
	 * isFull returns true if the stack is full
	 * 
	 * @return true if the stack is at capacity
	 */
	public boolean isFull() {
		return numItems == capacity;	//returns true if stack is full
	}

}





///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Title:            Program 4
//Files:            BinaryTree.java, BinaryTreenode.java, 
//IllegalBinaryTreeOpException.java
//Semester:         CS367 Fall 2014
//
//Author:           Brett Percy
//Email:            bpercy@wisc.edu
//CS Login:         percy
//Lecturer's Name:  Jim Skrentny
//Lab Section:      -
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//If allowed, learn what PAIR-PROGRAMMING IS, 
//choose a partner wisely, and complete this section.
//
//Pair Partner:     Sheng-Hua Lin
//Email:            slin96@wisc.edu
//CS Login:         Sheng-hu
//Lecturer's Name:  Jim Skrentny
//Lab Section:      -
//
//STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
//Credits:          (list anyone who helped you write your program)
////////////////////////////80 columns wide //////////////////////////////////