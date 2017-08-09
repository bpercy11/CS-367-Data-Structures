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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



/**
 * 
 * Guessing game is the class that contains the main method. The guessing game
 * class contains the application for the twenty questions program.
 * 
 * @author Brett Percy, Norman Lin
 */
public class GuessingGame {
	
	/**
	 * The main method is the method that allows the user to interact with the
	 * program. It allows the user to enter 4 options- output, play, quit, and
	 * reset. There can be a file used for input to play the game or the user
	 * can create questions with answers to their questions the build the game
	 * themselves.
	 * 
	 * @param args is the array that holds command line arguments
	 */
	public static void main (String args[]){
		
		Scanner scan = new Scanner(System.in);
		
		BinaryTree bTree = new BinaryTree();
		boolean hasInput = false;	//true if there is a file being read
		
		ArrayList<String> inputInfo = new ArrayList<String>();
		//arraylist to record the commands in the file
		if (args.length == 1){
			hasInput = true;
			try {
				File fileReader = new File(args[0]);
				Scanner fileScanner = new Scanner(fileReader);
				while (fileScanner.hasNextLine()){
					inputInfo.add(fileScanner.nextLine());
				}
			} catch (FileNotFoundException e) {
				System.out.println("Cannot find the specified file");
			}
		}
		Iterator<String> itr = inputInfo.iterator();

		try{
			//boolean for whether the user has quit the program
			boolean done = false;
			String userInput = null; //takes the scanned command from user
			//prompts the user for command until user enters to q
			while (!done){
				System.out.println("Please enter a command (o, p, q, r):");
				//if there is a line to read from the input file
				if (itr.hasNext()){
					userInput = itr.next();
				}
				//else asks for user command
				else {
					userInput = scan.nextLine();
				}
				
				if (userInput.equals("o")){
					//if the root is null
					if ( bTree.getCurrent() == null ){
						System.out.println("Empty Tree");
					}
					else {
						bTree.print();
					}
				}
/////////////////////
				else if (userInput.equals("p")){
					bTree.start();
					
					if (bTree.getCurrent() == null){
						//if there is a file from command-line
						if (hasInput){
							System.out.println("Please enter a question.");
							System.out.println("Please enter something that is true for that question.");
							System.out.println("Please enter something that is false for that question.");
							bTree.changeCurrent(itr.next());
							bTree.addLeftChild(itr.next());
							bTree.addRightChild(itr.next());
						}
						//else prompts for users command
						else {
							System.out.println("Please enter a question.");
							String question = scan.nextLine();
							bTree.changeCurrent(question);
							System.out.println("Please enter something that is true for that question.");
							String left = scan.nextLine();
							bTree.addLeftChild(left);
							System.out.println("Please enter something that is false for that question.");
							String right = scan.nextLine();
							bTree.addRightChild(right);
						}
					}
					
					else {
						//while the curr is not pointing at a tree
						while (!bTree.isLeaf()){
							//string for to record the y or n from user
							String yesORno;
							if (hasInput){
								System.out.println(bTree.getCurrent());
								yesORno = itr.next();
							}
							else {
								System.out.println(bTree.getCurrent());
								yesORno = scan.nextLine();
							}
							
							if (yesORno.equalsIgnoreCase("y")){
								try {
									bTree.goLeft();
								} catch (IllegalBinaryTreeOpException e) {
								}
							}
							else if (yesORno.equalsIgnoreCase("n")){
								bTree.goRight();
							}
						}
						if (hasInput){
							System.out.println("I guess: "+bTree.getCurrent()+". Was I right?");
							String yesORno = itr.next();
							if (yesORno.equalsIgnoreCase("y")){
								System.out.println("I win!");
								bTree.start();
							}
							else if (yesORno.equalsIgnoreCase("n")){
								System.out.println("Darn. Ok, tell me a question that is true for your answer, but false for my guess.");
								System.out.println("Thanks! And what were you thinking of?");
								String userQuestion = itr.next();
								String userAnswer = itr.next();
								String temp = (String) bTree.getCurrent();
								bTree.changeCurrent(userQuestion);
								bTree.addLeftChild(userAnswer);
								bTree.addRightChild(temp);
							}
						}
						else {
							System.out.println("I guess: "+bTree.getCurrent()+". Was I right?");
							String yesORno = scan.nextLine();
							if (yesORno.equalsIgnoreCase("y")){
								System.out.println("I win!");
								bTree.start();
							}
							else if (yesORno.equalsIgnoreCase("n")){
								System.out.println("Darn. Ok, tell me a question that is true for your answer, but false for my guess.");
								String userQuestion = scan.nextLine();
								System.out.println("Thanks! And what were you thinking of?");
								String userAnswer = scan.nextLine();
								String temp = (String) bTree.getCurrent();
								bTree.changeCurrent(userQuestion);
								bTree.addLeftChild(userAnswer);
								bTree.addRightChild(temp);
							}
						}
					}
				}
/////////////////////
				else if (userInput.equals("q")){
					done = true;
				}
/////////////////////
				else if (userInput.equals("r")){
					if (hasInput){
						System.out.println("Please enter a question.");
						System.out.println("Please enter something that is true for that question.");
						System.out.println("Please enter something that is false for that question.");
						bTree.changeCurrent(itr.next());
						bTree.addLeftChild(itr.next());
						bTree.addRightChild(itr.next());
					}
					else {
						System.out.println("Please enter a question.");
						String question = scan.nextLine();
						bTree.changeCurrent(question);
						System.out.println("Please enter something that is true for that question.");
						String left = scan.nextLine();
						bTree.addLeftChild(left);
						System.out.println("Please enter something that is false for that question.");
						String right = scan.nextLine();
						bTree.addRightChild(right);
					}
				}
				//if there is no more lines to read in the input file, set
				//hasInput to false and point current back to root
				if (!itr.hasNext()){
					hasInput = false;
					bTree.start();
				}
	///////////////////////////////////////////////////////////////////////			
			}
		}
		catch (IllegalBinaryTreeOpException e){
			
		}
	}
}