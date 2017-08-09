///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  GuessingGame.java
// File:             BinaryTreenode.java
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
 * The BinaryTreenode class contains all the methods necessary for a treenode.
 * You can get a nodes data, set it, get its left or right child, and set its 
 * left and right childs data. 
 * 
 * @author Brett Percy, Norman Lin
 *
 * @param <E>
 */
public class BinaryTreenode<E> {

	private E data;	//creates data type E
	private BinaryTreenode<E> left, right; //creates treenodes left and right
	
/**
 * The binary tree node constructor sets the nodes data to null, as well as 
 * setting its left and right children to null
 */
	public BinaryTreenode() {
		this.data = null;	//initializes data in node to null
		this.left = null;	//initializes left child to null
		this.right = null;	//intializes right child to null
	}

/**
 * The BinaryTreenode constructor sets the nodes data to the parameter passed
 * in named data. It sets its left node and right node to null.
 * 
 * @param data is the data passed in to set the nodes data.
 */
	public BinaryTreenode(E data) {
		this.data = data;//initializes data in node to 'data'
		left = null;//initializes left child to null
		right = null;//intializes right child to null
	}
	
/**
 * getData returns the data in the current node.
 * 
 * @return data returns the data in the current node.
 */
	public E getData() {
		return data;
	}

/**
 * getLeft gets the current nodes left child.
 * 	
 * @return left returns the current nodes left child.
 */
	public BinaryTreenode<E> getLeft() {
		return left;
	}
	
/**
 * getright gets the current nodes right child
 *	
 * @return right returns the current nodes right child.
 */
	public BinaryTreenode<E> getRight() {
		return right;
	}
	
/**
 * setData sets the current nodes data to the parameter 'data'
 * 	
 * @param data is the information that will set the data in the current node.
 */
	public void setData(E data) {
		this.data = data;
	}
	
/**
 * setLeft sets the current nodes left child
 * 
 * @param left is the node that will be assigned as the currnet nodes left
 * child
 */
	public void setLeft(E left) {
		this.left = new BinaryTreenode<E>(left);
	}
	
	
/**
 *  setRight sets the current nodes right child
 *  
 * @param right is the node that will be assigned as the current nodes left
 * child
 */
	public void setRight(E right) {
		this.right = new BinaryTreenode<E>(right);
	}
}