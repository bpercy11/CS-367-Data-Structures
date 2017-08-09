///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  GuessingGame.java
// File:             BinaryTree.java
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
 * BinaryTree represents a binary tree that stores binary treenodes. This class
 * has operations to traverse the tree, set data in certain nodes, change data
 * in certain nodes, and add nodes to the tree. All of the tree's nodes other
 * than the leaf nodes are questions the user will encounter when playing the
 * game. All of the leaf nodes are answers to the questions the user answers.
 * 
 * @author Brett Percy, Norman Lin
 */
public class BinaryTree<E> {
	private E data;
	private BinaryTreenode<E> root;
	private BinaryTreenode<E> curr;
    private int size;
    //creates variables used throughout the BinaryTree class. data of type E
    //is used for storing data in tree nodes. Treenode curr is used for
    //traversing the tree. Treenode root is the root of the tree. Int size is
    //used to keep track of the size of tree(number of nodes)

/**
 * Constructor for the BinaryTree. initializes the root to an empty tree node.
 * Sets another tree node named curr equal to the root in order for traversing
 * through the tree.
 */
	public BinaryTree(){
		this.root = new BinaryTreenode<E>(); //initializes root to empty
											//tree node
		curr = root;	//sets curr equal to root.
		size = 0;
	}
/**
 * Constructor for the BinaryTree. initializes the root to an empty tree node.
 * Sets another tree node named curr equal to the root in order for traversing
 * through the tree.
 * 
 * @param E data is that data stored in the root of the treenode in the tree
 */	
	public BinaryTree(E data){
		this.root = new BinaryTreenode<E>(data);
		//initializes root to a tree node with data in the node
		curr = root;	//initalizes curr to root
		size = 1;
	}
	
/**
 * Start will reset the position of the current node used for traversing the
 * tree. The root node always points to the node at the root of the tree.
 */
	public void start(){
		curr = root;	//resets the treenode curr equal to treenode root
	}
	
	
/**
 * getCurrent returns the data stored in the current node in navigation.
 * 
 * @return E returns whatever data type is used in the node that is currently
 * being visited
 * @throws IllegalBinaryTreeOpException prints message if there is no current
 * node in navigation.
 */
	public E getCurrent() throws IllegalBinaryTreeOpException{
		if (curr == null){
			throw new IllegalBinaryTreeOpException("There is no current node"
					+ " in navigation");
			//throws exception telling user there is no current node
		}
		else {
		return curr.getData(); //returns the current nodes data
		}
	}
	
/**
 * goLeft sets the current node to the left child of the current node.
 * 
 * @throws IllegalBinaryTreeOpException throws if there is no left child for
 * the current node to go to.
 */
	public void goLeft() throws IllegalBinaryTreeOpException{
		if (curr.getLeft() != null){
		curr = curr.getLeft(); //sets the current node to its left child.
		}
		else {
			throw new IllegalBinaryTreeOpException("Cannot go left; there"
					+ " is no left child of this node.");
			//throws the exception if the current node doesn't have a left
			//child
		}
	}
/**
* goRight sets the current node to the right child of the current node.
* 
* @throws IllegalBinaryTreeOpException throws if there is no right child for
* the current node to go to.
*/
	public void goRight() throws IllegalBinaryTreeOpException{
		if (curr.getRight() != null){
			curr = curr.getRight(); //sets the current node to its right child.
			}
			else {
				throw new IllegalBinaryTreeOpException("Cannot go right; "
						+ "there is no left child of this node.");
				//throws the exception if the current node doesn't have a right
				//child
			}
	}
	
	
/**
 * isLeaf checks if the current node doesn't have any children or not.
 * 
 * @return true is the current node is a leaf. Returns false if it is not.
 */
	public boolean isLeaf(){
		if (curr.getRight() == null && curr.getLeft() == null){
			return true;
			//returns true if the current node doens't have a right or left
			//child
		}	
		return false;
	}
	
/**
 * changeCurrent changes the data of the current node.
 * 
 * @param data E data changes the current nodes data to type E with information
 * data.
 */
	public void changeCurrent(E data) {
		curr.setData(data);	 //changes the current nodes data
	}
	
/**
 * addRightChild adds a right child to the current node. 
 * 
 * @param data adds the data to the right child node that is being added.
 * @throws IllegalBinaryTreeOpException throws if the current node already has
 * a right child.
 */
	public void addRightChild(E data) throws IllegalBinaryTreeOpException{
		if (curr.getRight() != null){
			throw new IllegalBinaryTreeOpException("The current node"
					+ " already has a right child!");
			//throws if there already is a right child to the current node
		}
		else {
		curr.setRight(data); //sets the new node w/ data 'data' to the current
							//node
		}
	}
	
/**
* addLeftChild adds a right child to the current node. 
* 
* @param data adds the data to the left child node that is being added.
* @throws IllegalBinaryTreeOpException throws if the current node already has
* a left child.
*/	
	public void addLeftChild(E data) throws IllegalBinaryTreeOpException{
		if (curr.getLeft() != null){
			throw new IllegalBinaryTreeOpException("The current node"
					+ " already has a left child!");
			//throws if there already is a left child to the current node

		}
		else {
		curr.setLeft(data); //sets the new node w/ data 'data' to the current
		//node
		}
	}
	
/**
* print calls a companion method to recursively print the tree in preOrder
* manner
*	
*/
	public void print(){
		preOrder(root, 0);
	}

	
/**
 * preOrder is the companion method to the print method. This recieves the 
 * root node, prints it, then recursively calls itself to print the remaining
 * nodes of the tree.
 * @param t is a binarytree node passed in, normally the root
 * @param level int level is used to indent the different data of each node
 * based on what level of the tree it is in.
 */
	private static void preOrder(BinaryTreenode t, int level) {
		if (t == null) {
			return; //returns if the node trying to be accessed is null
		}
		for (int i=level; i>0; i--){
			System.out.print("   ");	//indenting based on level of tree
		}
		System.out.println(t.getData()); //prints the data in current node
		if (t.getLeft() != null){
			preOrder(t.getLeft(), level+1);	//recursive calls to print rest of
			preOrder(t.getRight(), level+1);//remaining tree
		}
	}
}