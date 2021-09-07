package GoogleProblems;

import Utilities.ListNode;

public class LC0206ReverseLinkedList {
	public static ListNode reverseList(ListNode head) {


		 if (head == null || head.next == null) return head;
		    ListNode p = reverseList(head.next);
		    head.next.next = head;
		    head.next = null;
		    return p;


	}


	public static ListNode reverse(ListNode node) {


		if (node.next == null) {
			return node;
		} 

		ListNode reverse = reverse(node.next);
		ListNode head = reverse;

		while(reverse.next != null) {
			reverse = reverse.next;
		}

		reverse.next = node;
		node.next = null;
		return head;

	}




	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		
		l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5;
		
		
		reverseList(l1);



	}

}
