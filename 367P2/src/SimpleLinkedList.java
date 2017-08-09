
///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Twitter.java
// File:             SimpleLinkedList.java
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

public class SimpleLinkedList<E> implements ListADT<E> {

	private DblListnode<E> head;	//creates a double List node object;
	int numItems;	//creates a integer numItems to count
	
	
	/**
	 * constructs an empty linked list w/ numItems = 0
	 *
	 */
	public SimpleLinkedList(){
		head = null;
		numItems = 0;
	}

	
	/**
	 * adds an item to the end of the sll. If null it throws an
	 * illegal argument exception. if the sll is empty it sets item at pos 0
	 *
	 * @param item item is added to the end of the sll
	 */
	public void add(E item) {
		
		//checks if item is null
		if (item == null){
			throw new IllegalArgumentException();
		}
		
		DblListnode<E> curr = head;		//curr for traversing thru sll
		DblListnode<E> newNode = new DblListnode<E>(item); //newNode w/ data
														// from item
		
		//sets head = to newNode if sll is empty
		if (isEmpty()){
			head = newNode;
			numItems++;
		}
		//else traverses thru sll until end to add newNode
		else{
			while(curr.getNext()!= null){
				curr = curr.getNext();
			}
			curr.setNext(newNode);
			newNode.setPrev(curr);
			numItems++;
		}
	}

	/**
	 * adds an item into your sll at the position given
	 *
	 * @param item item is the object being passed into you sll
	 * @param pos pos is the position you want to add item at in your sll
	 */
	public void add(int pos, E item) {
		DblListnode<E> curr = head;		//curr for traversing thru sll
		//checks for bad parameters
		if (pos < 0 || pos > numItems) {
	        throw new IndexOutOfBoundsException();
	    }
		//if sll is empty
		else if (head == null){
			head = new DblListnode<E>(item);
			numItems++;
		}
		//uses add method if position is at the end of sll
		else if (pos == numItems){
			add(item);
		}
		
		//links in if position is 0
		else if (pos == 0){
			DblListnode<E> newNode = new DblListnode<E>(item);
			newNode.setNext(curr.getNext());
			curr.setPrev(newNode);
			head = newNode;
		}
		
		//traveres thru until position and links in
		else{
			//newNode with data item
			DblListnode<E> newNode = new DblListnode<E>(item);
			//traverses thru the listnode to get curr at pos
			for (int k = 0; k < pos-1; k++){
				curr = curr.getNext();
			}
			//if curr is at the end of the listnode
			if(curr.getNext()==null){
				newNode.setPrev(curr);
				curr.setNext(newNode);
				numItems++;
			}
			//if curr is not at the end of the listnode
			else{
			newNode.setPrev(curr);
			newNode.setNext(curr.getNext());
			curr.setNext(newNode);
			curr.getNext().getNext().setPrev(newNode);
			numItems++;
			}
		}
	}

	
	/**
	 * 
	 * contains checks you sll and returns true if your sll contains the item
	 * passed in and false otherwise
	 * 
	 * @param item item is an object passed in to see if your sll contains it
	 * @return returns true if your sll contains the item passed in, false
	 * otherwise
	 */
	public boolean contains(E item) {
		
		DblListnode<E> curr = head;		//curr for traversing thru sll
		
		while (curr.getNext()!=null){
			if (curr.equals(item)){
				return true;
			}
			else{
				curr = curr.getNext();
			}
		}
		if (curr.equals(item)){
			return true;
		}
		return false;
	}

	/**
	 * get returns the data of the object at position pos
	 *
	 * @param pos pos is the position you get the data from item E
	 * @return returns generic type E
	 */
	public E get(int pos) {
	
		DblListnode<E> curr = head;		//curr for traversing thru sll
		if (head==null) return null;	//if listnode is empty
		//else get a item at pos
		else{
			for (int i = 0; i < pos; i++){
				curr = curr.getNext();
			}
			return curr.getData();
		}
	}

	/**
	 * isEmpty checks if your sll is empty or not
	 *
	 * @return returns true if numItems = 0, false otherwise
	 */
	public boolean isEmpty() {
		return numItems == 0;
	}

	/**
	 * remove removes an object at the position pos passed in
	 *
	 * @param pos pos is the position at which you want an object removed from
	 * your sll
	 * @return returns generic type E
	 */
	public E remove(int pos) {
		DblListnode<E> curr = head;	//curr for traversing thru sll
		//checks for bad parameters
		if (pos < 0 || pos > numItems) {
	        throw new IndexOutOfBoundsException();
	    }
		//checks to see if pos is 0 and removes it
		else if (pos == 0){
			head = head.getNext();
			//curr.setNext(curr.getNext());
			numItems--;
		}
		//else removes item at pos
		else{
			for (int i = 0; i < pos; i++){
				curr = curr.getNext();	//sets curr to pos
			}
			if (curr.getNext()==null){	//checks to see if curr is at the end
				curr.getPrev().setNext(null);
			}
			else{
				curr.getPrev().setNext(curr.getNext());
				curr.getNext().setPrev(curr.getPrev());
			}
			numItems--;
		}
		
		return null;
	}

	/**
	 * size returns the size or number of items in you sll
	 *
	 * @return returnas the integer of the size of you sll
	 */
	public int size() {
		return numItems; 
	}

	
}