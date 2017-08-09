///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Title:            Program 5
//Files:            SimpleHashMap.java, SimpleTreeMap.java
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

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class MapBenchmark{

	public static void main(String[] args) {
		int numIter = Integer.parseInt(args[1]);
		boolean done = false;
		
		//two array lists to hold the key and value from the input file
		ArrayList<Integer> fileKeyList = new ArrayList<Integer>();
		ArrayList<String> fileValueList = new ArrayList<String>();


		//reading in the input file
		try{
			File inputFile = new File(args[0]);
			Scanner fileScanner = new Scanner(inputFile);
			while (fileScanner.hasNextLine()){
				String a[] = fileScanner.nextLine().split(" ");
				fileKeyList.add(Integer.parseInt(a[0]));
				fileValueList.add(a[1]);
			}
		}
		catch (FileNotFoundException e){
			System.out.println("Cannot find the File");
			done = true;
		}

		//loops until there are no more lines from the input file to read in
		if (!done){
			
			//treemap object to populate the treemap
			SimpleTreeMap tree = new SimpleTreeMap();
			//hashmap object to populate the hash map with
			SimpleHashMap hash = new SimpleHashMap();

			//arraylists to store all times for each function for number of
			//iterations
			ArrayList treeGet = new ArrayList();
			ArrayList hashGet = new ArrayList();
			ArrayList treePut = new ArrayList();
			ArrayList hashPut = new ArrayList();
			ArrayList treeFloorMap = new ArrayList();
			ArrayList hashFloorMap = new ArrayList();
			ArrayList treeRemove = new ArrayList();
			ArrayList hashRemove = new ArrayList();
			ArrayList<ArrayList> mainList = new ArrayList<ArrayList>();
			
			//adds all of the above array lists into an array list of type
			//arraylist 
			mainList.add(hashGet);
			mainList.add(hashPut);
			mainList.add(hashFloorMap);
			mainList.add(hashRemove);
			mainList.add(treeGet);
			mainList.add(treePut);
			mainList.add(treeFloorMap);
			mainList.add(treeRemove);


			//
			for(int ndx = 0;ndx < numIter;ndx++){
				ArrayList<Integer> randomInt = new ArrayList<Integer>();
				Random r = new Random();
				for (int x=0; x<fileKeyList.size(); x++){
					randomInt.add(r.nextInt(fileKeyList.get(fileKeyList.size
							()-1)));
				}

				//populate treeMap
				long startTime = System.currentTimeMillis();
				for (int k=0; k<fileKeyList.size(); k++){
					tree.put(fileKeyList.get(k), fileValueList.get(k));
				}
				long elapsed = System.currentTimeMillis() - startTime;
				treePut.add(elapsed);	//adding that time to treePut's list
										//of times
				
				//populate hashMap
				long startTime1 = System.currentTimeMillis();
				for (int a=0; a<fileKeyList.size(); a++){
					hash.put(fileKeyList.get(a), fileValueList.get(a));
				}
				long elapsed1 = System.currentTimeMillis() - startTime1;
				hashPut.add(elapsed1);	//adding that time to hashPut's list
										//of times

				//get all key-value pairs from treeMap
				long startTime2 = System.currentTimeMillis();
				for (int b=0; b<fileKeyList.size(); b++){
					tree.get(fileKeyList.get(b));
				}
				long elapsed2 = System.currentTimeMillis() - startTime2;
				treeGet.add(elapsed2);	//adding that time to treeGet's list
										//of times
				
				//get all key-value pairs from hashMap
				long startTime3 = System.currentTimeMillis();
				for (int c=0; c<fileKeyList.size(); c++){
					hash.get(fileKeyList.get(c));
				}
				long elapsed3 = System.currentTimeMillis() - startTime3;
				hashGet.add(elapsed3);	   //adding that time to hashPut's list
											//of times

				//floorKey every value in treeMap
				long startTime4 = System.currentTimeMillis();
				for (int d=0; d<fileKeyList.size(); d++){
					tree.floorKey(randomInt.get(d));
				}
				long elapsed4 = System.currentTimeMillis() - startTime4;
				//adding that time to treeFloorMap's list
				//of times
				treeFloorMap.add(elapsed4);
				
				//floorKey every value in hashMap
				long startTime5 = System.currentTimeMillis();
				for (int e=0; e<fileKeyList.size(); e++){
					hash.floorKey(randomInt.get((e)));
				}
				long elapsed5 = System.currentTimeMillis() - startTime5;
				//adding that time to hashFloorMap's list
				//of times
				hashFloorMap.add(elapsed5);
				
				//remove every key-value pairs in treeMap
				long startTime6 = System.currentTimeMillis();
				for (int f=0; f<fileKeyList.size(); f++){
					tree.remove(fileKeyList.get(f));
				}
				long elapsed6 = System.currentTimeMillis() - startTime6;
				//adding that time to treeRemove's list
				//of times
				treeRemove.add(elapsed6);
				
				//remove every key-value pairs in treeMap
				long startTime7 = System.currentTimeMillis();
				for (int g=0; g<fileKeyList.size(); g++){
					hash.remove(fileKeyList.get(g));
				}
				long elapsed7 = System.currentTimeMillis() - startTime7;
				//adding that time to hashRemove's list
				//of times
				hashRemove.add(elapsed7);
				

				//Basic progress bar
				/*System.out.print(String.format("%.2f",100* ndx/
				 * (float)numIter) +
								"% done \r");*/
			}

			//loop to get all max/min from each function and calculate the
			//mean/strDev
			for (int i=0; i<mainList.size(); i++){
				//minimum time for whichever function i equals in mainList
				//index
				long tempMin = (Long) mainList.get(i).get(0);
				
				//maximum time for whichever function i equals in mainList
				//index
				long tempMax = (Long) mainList.get(i).get(0);
				
				
				long sum = 0;
				double std = 0;
				int array_size = mainList.get(i).size();
				
				//calculating the sum and finding the largest and smallest
				//times
				for (int k=0; k<array_size; k++){
					sum += (Long) mainList.get(i).get(k);
					if (((Long) mainList.get(i).get(k)).compareTo(tempMax)
							> 0){
						tempMax = (Long) mainList.get(i).get(k);
					}
					if (((Long) mainList.get(i).get(k)).compareTo(tempMin)
							< 0){
						tempMin = (Long) mainList.get(i).get(k);
					}
				}
				
				//calculating the mean by the sum of time divided by numIter
				double mean = (double) sum/numIter;
				double calStdTemp = 0;
				
				//calculating standard deviation
				for (int x=0; x<array_size; x++){
					calStdTemp += (((Long) mainList.get(i).get(x)) - mean) * 
							(((Long) mainList.get(i).get(x)) - mean);
				}
				double calStdTemp_2 = ((double) calStdTemp/array_size);
				calStdTemp = (Math.sqrt(calStdTemp_2));
				std = calStdTemp;
				
				//adding the calculated statistic to the end of whichever
				//respective function it was calculated for
				mainList.get(i).add(tempMin);
				mainList.get(i).add(tempMax);
				mainList.get(i).add(mean);
				mainList.get(i).add(std);
			}

			
			//for printing purposes
			treeGet.add("TreeMap: get");
			treePut.add("TreeMap: put");
			treeFloorMap.add("TreeMap: floorKey");
			treeRemove.add("TreeMap: remove");
			hashGet.add("HashMap: get");
			hashPut.add("HashMap: put");
			hashFloorMap.add("HashMap: floorKey");
			hashRemove.add("HashMap: remove");

			
			//displaying results from input file used
			System.out.println("Results from "+numIter+" runs of "+args[0]+
					"\n");
			
			//prints results
			for (int r=0; r<8; r++){
				int size = mainList.get(r).size();
				System.out.println(mainList.get(r).get(size-1));
				System.out.println("--------------------");
				System.out.println("Min : "+mainList.get(r).get(size-5));
				System.out.println("Max : "+mainList.get(r).get(size-4));
				if (mainList.get(r).get(size-3).toString().length()>5){
					System.out.println("Mean: "+mainList.get(r).get(size-3)
							.toString().substring(0, 5));
				}
				else{
					System.out.println("Mean: "+mainList.get(r).get(size-3));
				}

				if (mainList.get(r).get(size-2).toString().length()>5){
					System.out.println("Std Dev : "+mainList.get(r).get(size-2)
							.toString().substring(0, 5)+"\n");
				}
				else{
					System.out.println("Std Dev : "+mainList.get(r)
							.get(size-2)+"\n");
				}
			}

		}
	}
}