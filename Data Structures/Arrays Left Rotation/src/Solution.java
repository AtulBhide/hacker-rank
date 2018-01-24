/*
 * @author: Atul Bhide
 * Hacker Rank (Cracking the Coding Interview)
 * 
 * Arrays: Left Rotation
 * 
 * Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single
 * line of space-separated integers.
 */

import java.util.Scanner;

public class Solution {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
    	int retVals[] = new int[n];
   
    	// If K [rotation count] > N [Size of the Array] we cut it down to size
    	if(k >= n)
    		k %= n;
    	
    	// With K < N the logic becomes simple
    	for(int x = 0; x < n; x++) {
    		retVals[x] = a[(x+k)%n];
    	}
    	return retVals;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        in.close();
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
}
