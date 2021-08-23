package Blind75;

import java.util.Comparator;
import java.util.PriorityQueue;

import Utilities.ListNode;

public class LC0023MergeKWayLists {



	public static ListNode mergeKListsWithQueue(ListNode[] lists) {
		PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
			@Override
			public int compare(ListNode o1,ListNode o2){
				if (o1.val<o2.val)
					return -1;
				else if (o1.val==o2.val)
					return 0;
				else 
					return 1;
			}
		});


		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null ) {
				queue.offer(lists[i]);
			}
		}

		ListNode curr = new ListNode();
		ListNode head = curr;

		while (!queue.isEmpty()) {
			curr.next = queue.poll();

			curr = curr.next;

			if (curr.next != null) {
				queue.offer(curr.next);
			}
		}

		return head.next;


	}


	public static ListNode mergeKLists(ListNode[] lists) {


		ListNode prev = new ListNode();
		ListNode head = prev;
		boolean noNull = true;

		int index = 0;
		int minValue;

		while(true) {
			minValue = Integer.MAX_VALUE;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] != null) {
					noNull = true;
					if (lists[i].val <= minValue) {
						index = i;
						minValue = lists[i].val;
					}
				}

			}

			if (!noNull) {
				break;
			}

			prev.next = lists[index];
			prev = prev.next;
			lists[index] = lists[index].next;

			noNull = false;

		}


		head = head.next;
		return head;
	}


	public static void main(String[] args) {

		//ListNode a1 = new ListNode();

		ListNode a1 = new ListNode(1); ListNode a2 = new ListNode(4); ListNode a3 = new ListNode(5);
		a1.next = a2; a2.next = a3;

		ListNode b1 = new ListNode(1); ListNode b2 = new ListNode(3); ListNode b3 = new ListNode(4);
		b1.next = b2; b2.next = b3;

		ListNode c1 = new ListNode(2); ListNode c2 = new ListNode(6); 
		c1.next = c2; 

		//ListNode[] lists = {a1};
		ListNode[] lists = {a1, b1, c1};

		mergeKListsWithQueue(lists);


	}
}








