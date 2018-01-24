import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	private class Node {
		int data;
		Node next;
	}


	boolean hasCycle(Node head) {
		if(head == null)
			return false;
	
		Node faster = head;
		Node slower = head;
	
		while(faster.next != null && faster.next.next != null) {
			slower = slower.next;
			faster = faster.next.next;
			
			if(slower == faster)
				return true;
		}
		return false;
	}
}
