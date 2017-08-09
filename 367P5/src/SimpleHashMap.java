///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  MapBenchmark.java
// File:             SimpleHashMap.java
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


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
/**
 *
 * A map is a data structure that creates a key-value mapping. Keys are
 * unique in the map. That is, there cannot be more than one value associated
 * with a same key. However, two keys can map to a same value.
 *
 * The SimpleHashMap takes two generic parameters, K
 * and V, standing for the types of keys and values respectively.
 *
 */
public class SimpleHashMap<K extends Comparable<K>,V> implements 
SimpleMapADT<K , V> {


	private int[] tableSizes = { 11, 23, 47, 97, 197, 397, 797, 1597, 3203, 
			6421, 12853, 25717, 51437, 102877, 205759, 411527, 823117, 1646237,
			3292489, 6584983, 13169977, 26339969, 52679969, 105359939,
			210719881, 421439783, 842879579, 1685759167};
	private double lf = 0.75;		//intializing load factor to .75
	
	//initializing linked list of type entry array named hashTable. used
	//for chaining buckets to solve collision problems
	private LinkedList<Entry>[] hashTable;	
	
	//a is used to get the next table size in the the array tableSizes once
	//the threshold for the load factor is reached
	private int a = 0;
	
	//count is used to keep track of the amount of items in the hashTable
	int count = 0;


	/**
	 * Constructor for the simple hash map object
	 */
	public SimpleHashMap()
	{
		//initialzes hashTable to an array with LinkedList elements and size
		//11 to begin with
		hashTable = new LinkedList[tableSizes[a]];
		
		//loop to create a new linkedlist object at each element in the array
		for (int i=0; i<tableSizes[a]; i++){
			hashTable[i] = new LinkedList<Entry>();
		}
	}

	/**
	 * hash method is called by other methods to recieve the hashIndex of k 
	 * type K being passed in
	 * 
	 * @param k generic type K 
	 * @return hashIndex the integer in the array to where the element is
	 * indexed
	 */
	private int hash(K k) {
		//checks if k is null. if so, throws NPE
		if (k==null){
			throw new NullPointerException();
		}
		
		//creates the hashIndex by hashCoding the k value passed in then
		//modding it by the table's length
		int hashIndex = k.hashCode() % hashTable.length;
		
		//checking for negative hashIndex's and correcting it
		if (hashIndex < 0){
			hashIndex += hashTable.length;
		}

		//checking if the loadfactor limit has been reached, if so, increases
		//to the next prime in the list of table sizes given
		if (count/hashTable.length > 0.75){
			LinkedList<Entry>[] newTable = Arrays.copyOf(hashTable, 
					tableSizes[a+1]);
			hashTable = newTable;
		}
		return hashIndex;
	} 


	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key.
	 *
	 * @param key the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or null
	 * if this map contains no mapping for the key
	 * @throws NullPointerException if the specified key is null
	 */

	public V get(K key) {
		
		//checks if key passed in is null, if so throws NPE
		if (key == null){
			throw new NullPointerException();
		}
		
		//generic object returnValue used to return the value of the key passed
		//in
		V returnValue = null;
		
		//loop to check if items in the hashTable equal the key. If so, it 
		//returns the value of that key
		if (hashTable[hash(key)] != null){
			Iterator itr = hashTable[hash(key)].iterator();
			while (itr.hasNext()){
				Entry temp = (Entry) itr.next();
				if (temp.getKey().equals(key)){
					returnValue = (V) temp.getValue();
				}
			}
		}
		return returnValue;
	}   



	/**
	 * Associates the specified value with the specified key in this map.
	 * Neither the key nor the value can be null. If the map
	 * previously contained a mapping for the key, the old value is replaced.
	 *
	 * @param key key with which the specified value is to be associated
	 * @param value value to be associated with the specified key
	 * @return the previous value associated with key, or
	 * null if there was no mapping for key.
	 * @throws NullPointerException if the key or value is null
	 */

	public V put(K key, V value) {
		
		//checks if key passed in is null, if so throws NPE
		if (key == null || value == null){
			throw new NullPointerException();
		}

		//generic object V named old
		V old = null;
		
		//checks all elements in that linked list at the hashIndex to see
		//if the key passed in is already in that linked list. if so, it 
		//replaces its old value with the value of the new key passed in
		if (hashTable[hash(key)] != null){
			Iterator itr = hashTable[hash(key)].iterator();
			while (itr.hasNext()){
				Entry temp = (Entry) itr.next();
				if (temp.getKey().equals(key)){
					old = (V) temp.getValue();
					temp.setValue(value);
				}
			}
		}
		
		//if there isn't a key at that hashIndex yet, it places the key and
		//value passed in at that hashIndex
		else{
			hashTable[hash(key)].add(new Entry(key, value));
			count++;
		}
		
		//returns the old value of the key that was replaced by the new key
		return old;
	}   




	/**
	 * Removes the mapping for the specified key from this map if present. This
	 * method does nothing if the key is not in the map.
	 *
	 * @param key key whose mapping is to be removed from the map
	 * @return the previous value associated with key, or null
	 * if there was no mapping for key.
	 * @throws NullPointerException if key is null
	 */

	public V remove(K key) {
		
		//checks if key passed in is null, if so throws NPE
		if (key == null){
			throw new NullPointerException();
		}
		
		int a = 0;
		
		//used to return at end of method
		V old = null;
		
		//loops thru the hashTable to find all entrys with the same key that
		//was passed in. If it finds any, it removes the key and value from
		//the hashTable
		if (hashTable[hash(key)] != null){
			Iterator itr = hashTable[hash(key)].iterator();
			while (itr.hasNext()){
				Entry temp = (Entry) itr.next();
				if (temp.getKey().equals(key)){
					hashTable[hash(key)].remove(a);
					count--;
				}
				a++;
			}
		}
		return old;
	}   

	/**
	 * Returns the greatest key less than or equal to the given key, 
	 * or null if there is no such key. 
	 * Throws NullPointerException if key is null. 
	 * @param key key whose floor should be found
	 * @return the largest key smaller than the one passed to it
	 * @throws NullPointerException if key is null
	 */
/*	public K floorKey(K key){
		
		//checks if key passed in is null, if so throws NPE
		if (key == null){
			throw new NullPointerException();
		}
		
		
		K floorKey = null;
		Iterator itr = hashTable[hash(key)].;
		while (itr.hasNext()){
			K tempK = (K) itr.next();
			if (tempK.compareTo(key) < 0 && tempK.compareTo(floorKey) > 0){
				floorKey = tempK;
			}
		}
		return floorKey;

	}*/
	   public K floorKey(K key){
			if (key == null){
				throw new NullPointerException();
			}
	       /*Iterator itr = hashTable[hash(key)].iterator();
	       while (itr.hasNext()){
	       	K tempK = (K) itr.next();
	       	if (tempK.compareTo(key) < 0 && tempK.compareTo(floorKey) > 0){
	       		floorKey = tempK;
	       	}
	       }*/
	       K floorKey = null;
	       for (int i=0; i<hashTable.length; i++){
	       	if (hashTable[hash(key)] != null){
	   	        Iterator itr = hashTable[i].iterator();
	   	        while(itr.hasNext()){
	   	        	K temp = ((K) ((Entry) itr.next()).getKey());
	   	        	floorKey =  ((K) ((Entry) itr.next()).getKey());
	   	        	if ( temp.compareTo(key) <= 0 &&
	   	        			temp.compareTo(floorKey) > 0){
	   	        		floorKey = temp;
	   	        	}
	   	        }
	       	}
	       }

			return floorKey;

		}
	

}