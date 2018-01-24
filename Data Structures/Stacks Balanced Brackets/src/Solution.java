import java.util.Scanner;
import java.util.Stack;

public class Solution {
    
    public static boolean isBalanced(String expression) {
    	// Empty or NULL Strings are by default balanced
    	if(expression == null || expression.length() == 0)
    		return true;

    	// String with ODD length will never be balanced
    	if((expression.length() % 2) != 0)
    			return false;

    	char[] arr = expression.toCharArray();
    	Stack<Character> chArr = new Stack<Character>();
    	
    	for(char ch : arr) {
    		switch(ch) {
    		case '[':
    		case '{':
    		case '(':
    			chArr.push(ch);
    			break;

    		case ']':
    			if(chArr.isEmpty() || chArr.pop() != '[')
    				return false;
    			break;
    		case '}':
    			if(chArr.isEmpty() || chArr.pop() != '{')
    				return false;
    			break;
    		case ')':
    			if(chArr.isEmpty() || chArr.pop() != '(')
    				return false;
    			break;
    		default:
    			return false;
    		}
    	}
    	
    	if(!chArr.empty())
    		return false;
        return true;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
        in.close();
    }
}
