package GoogleProblems;

import Utilities.ListNode;

public class LC0002AddTwoNumbers {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	     

	        ListNode sum = new ListNode();
	        int tempSum = 0;
	        ListNode head = sum;
	        boolean carry = false;
	        while (true) {
	            if (l1 == null && l2 == null && carry == false) {
	                break;   
	            } 
	            
	            if (carry) { tempSum++; }
	            carry = false;
	            if (l1 != null) { tempSum = tempSum + l1.val; }
	            if (l2 != null) { tempSum = tempSum + l2.val; }
	            
	            if (tempSum >= 10) { 
	                tempSum = tempSum - 10; 
	                carry = true;
	            }
	            
	            /*
	             * It's always best to set node.next as the target, as 
	             * opposed to the node itself. This is because if set the 
	             * node itself, then create a new node for node.next, if
	             * you exit out of the loop, there will be an empty extra 
	             * dangling node at the end. 
	             */
	            sum.next = new ListNode(tempSum);
	            sum = sum.next;
	            
	            if (l1 != null) { l1 = l1.next; }
	            if (l2 != null) { l2 = l2.next; }
	            tempSum = 0;
	            
	        }
	        return head.next;
			
	    }
	}
}
