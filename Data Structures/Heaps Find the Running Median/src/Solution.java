/*
 * @author: Atul Bhide
 * Hacker Rank (Cracking the Coding Interview)
 * 
 * Strings: Making Anagrams
 * 
 * Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions
 * required to make  and  anagrams. Any characters can be deleted from either of the strings.
 */

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	// While we use 2 HashMaps we can do the same with just one HashMaop
	public static int numberNeeded(String first, String second) {
		HashMap<Character, Integer> map1 = null;
		HashMap<Character, Integer> map2 = null;

		// The next few lines is just making sure that the data is safe to process
		int firstLn = 0;
		int secondLn = 0;
		
		if(first != null)
			firstLn = first.length();
		if(second != null)
			secondLn = second.length();

		if(firstLn == 0)
			return secondLn;
		if(secondLn == 0)
			return firstLn;
		
		// Create a (c -> Count) map for each string
		map1 = doMap(first);
		map2 = doMap(second);

		// Compare the diff between the Count of each of the map and return the total
		return findDiff(map1, map2);
	}

	// Given 2 maps of (C1 -> count1) and (C2 -> count2) find the (count1 - count2) for each C1 == C2 
	public static int findDiff(HashMap<Character, Integer> x, HashMap<Character, Integer> y) {
		int diff = 0;

		for(Character key : x.keySet()){
			int xVal = x.get(key);
			int yVal = 0;
			
			if(y.containsKey(key)) {
				yVal = y.remove(key);
			}
			
			if(yVal < xVal) {
				diff += xVal - yVal;
			} else {
				diff += yVal - xVal;
			}
		}

		if(!y.isEmpty()) {
			for(Character key : y.keySet()){
				diff += y.get(key);
			}
		}
		return diff;
	}
	
	public static HashMap<Character, Integer> doMap(String str) {
		HashMap<Character, Integer> strMap = new HashMap<Character, Integer>();

		char[] charArray = str.toCharArray();

		for(int i = 0; i < charArray.length; i++) {
			int val = 1;
			if(strMap.containsKey(charArray[i])) {
				val = strMap.get(charArray[i]) + 1;
			}
			strMap.put(charArray[i], val);
		}
		return strMap;
	}
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        in.close();
        System.out.println(numberNeeded(a, b));
    }
}
