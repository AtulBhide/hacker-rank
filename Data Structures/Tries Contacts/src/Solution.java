

public class Solution {
	// Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

	// The Node class is defined as follows:
	    class Node {
	        int data;
	        Node left;
	        Node right;
	     }
	//

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean checkBST(Node root) {
		return (checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE ));
    }

	boolean checkBST(Node iNode, int min, int max) {
		if(iNode == null)
			return true;
		if(iNode.data <= min || iNode.data >= max)
			return false;
		return (checkBST(iNode.left, min, iNode.data) && checkBST(iNode.right, iNode.data, max));
	}
}
