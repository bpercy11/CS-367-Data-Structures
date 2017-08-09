///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  TrainSimulator.java
// File:             SimpleQueue.java
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
 * SimpleQueue class represents a queue and implements QueueADT. It has 
 * enqueue (add), dequeue(remove), and peek(get), functions. It uses an array
 * to store objects, but uses the array in a first in first out manner.
 * 
 * @author Brett Percy, Norman Lin
 */
public class SimpleQueue<E> implements QueueADT{

	private E items[];
	private int capacity;
	private int numItems;
	private int rear;
	private int front;
	
	/**
	 * constructor for a simplequeue object. SimpleQueue uses an array to
	 * execute its queue functions
	 * 
	 * @param capacity capacity is the size of the array
	 */
	public SimpleQueue (int capacity){
		this.capacity = capacity;	//sets size of array used in queue
		items =  (E[]) new Object[capacity];//initializes queue of generic type
										//with size capacity
		rear = 0;	//sets rear equal to 0 where enqueue-ing will take place
		front = -1; //sets front equal to -1 where dequeue-ing wil take place	
		numItems = 0; //sets numItems equal to 0
	}
	
	
	/**
	 * enqueue adds an object to the next open position in the array and
	 * adjusts the rear and front values
	 * 
	 * @param item item is added at the next open position in the array
	 * @throws FullQueueException throws if the queue is full when trying to
	 * add an object to the queue
	 */
	public void enqueue(Object item) throws FullQueueException {
		//throws fullqueueexception if queue is full when trying to enqueue
		if (isFull()){
			throw new FullQueueException();
		}
		
		else{
			
			//handles the case of enqueue-ing when the queue is empty
			if (front == -1){
				front = 0;
				items[front] = (E)item; //puts 'item' at position 0 in the 
										//array used by the queue
				rear++;	 //increments rears position
				numItems++; //increments numItems
			}
			//handles case of enqueue-ing when the queue is not empty
			else{
				items[rear] = (E)item; //puts 'item' at the end of the array
				rear++;	//increments rear
				numItems++; //increments numItems
			}
		}

	}

	
	/**
	 * dequeue returns an item at the front of the queue's array and then 
	 * removes that object from the array.
	 * 
	 * @return the object at the front of the queue's array
	 * @throws EmptyQueueException throws if the queue is empty when trying
	 * to access an object at the front of the array
	 */
	public Object dequeue() throws EmptyQueueException {
		//throws emptyqueueexception if array is empty when trying to dequeue
		if (isEmpty()){
			throw new EmptyQueueException();
		}
		
		else{
			//sets the item in array at the front equal to a temp variable
			E temp = items[front];
			//then sets the item at front position in array equal to null
			items[front] = null;
			front++;
			numItems--;
			return temp; //returns the temp variable
		}

	}

	
	/**
	 * peek returns the object at the front of the queue's array but doesn't
	 * remove the object from queue's array.
	 * 
	 * @return object at the front of the queue's array
	 * @throws EmptyQueueException throws if the queue is empty when trying to 
	 * access an object at the front of the array
	 */
	public Object peek() throws EmptyQueueException {
		//throws emptyqueueexception if queue is empty when trying to peek
		if (isEmpty()){
			throw new EmptyQueueException();
		}
		//returns the item at front of queue's array
		else{
			return items[front];
		}
	}

	/**
	 * isEmpty returns true if the queue is empty
	 * 
	 * @return true if there isn't any objects in the queue
	 */
	public boolean isEmpty() {
		return numItems == 0;
	}

	/**
	 * isFull returns true if the queue is full
	 * 
	 * @return true if the queue is full
	 */
	public boolean isFull() {
		return numItems == capacity;
	}
	

}