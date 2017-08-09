///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  MapBenchmark.java
// File:             SimpleTreeMap.java
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


import java.util.List;
import java.util.TreeMap;
/**
 *
 * A map is a data structure that creates a key-value mapping. Keys are
 * unique in the map. That is, there cannot be more than one value associated
 * with a same key. However, two keys can map to a same value.
 *
 * The SimpleTreeMap takes two generic parameters, K
 * and V, standing for the types of keys and values respectively.
 *
 */
public class SimpleTreeMap<K extends Comparable<K> ,V> implements 
SimpleMapADT<K, V> {

	//TreeMap object named map, holding generic types V and K
    private TreeMap<K,V> map;

    /**
     * Constructor for the TreeMap object. 
     * 
     */
    SimpleTreeMap(){
		 map = new TreeMap<K,V>();
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
    public V put(K key, V value){
    	
    	//checks is either key or value is null. if so, throws NPE
    	if (key == null || value == null){
    		throw new NullPointerException();
    	}
    	
    	//puts key and value into the TreeMap object, returns null
    	else{
    		map.put(key, value);
    		return null;
    	}

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
    public V get(K key){
    	//checks is either key or value is null. if so, throws NPE
    	if (key == null){
    		throw new NullPointerException();
    	}
    	
    	//returns the value of the key being passed in if the map contains
    	//said key. if not, it returns null.
    	else{
    		if (map.containsKey(key)==true){
    			return map.get(key);
    		}
    		else{
    			return null;
    		}
    	}
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
    public V remove(K key){
    	//checks is either key or value is null. if so, throws NPE
    	if (key == null){
    		throw new NullPointerException();
    	}
    	
    	//removes the given key from the map. returns null
    	else{
    		map.remove(key);
    		return null;		
    	}

}
   /**
     * Returns the greatest key less than or equal to the given key, 
     * or null if there is no such key. 
	 * Throws NullPointerException if key is null. 
     * @param key key whose floor should be found
     * @return the largest key smaller than the one passed to it
     * @throws NullPointerException if key is null
     */
    public K floorKey(K key) {
    	
    	//checks is either key or value is null. if so, throws NPE
    	if (key == null){
    		throw new NullPointerException();
    	}
    	
    	//returns the highest key less than the given key.
    	else{
    		return map.floorKey(key);
    	 	}
    }
}