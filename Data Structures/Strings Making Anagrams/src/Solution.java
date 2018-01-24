import java.util.HashMap;
import java.util.Scanner;
public class Solution {
    public static int numberNeeded(String first, String second) {
		HashMap<Character, Integer> map1 = null;
		HashMap<Character, Integer> map2 = null;

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
		
		map1 = doMap(first);
		map2 = doMap(second);

		return findDiff(map1, map2);
	}

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
