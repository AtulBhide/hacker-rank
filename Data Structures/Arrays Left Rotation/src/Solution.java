import java.util.Scanner;

public class Solution {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
    	int retVals[] = new int[n];
    	
    	if(k >= n)
    		k %= n;
    	
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
