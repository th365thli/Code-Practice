package OldProblems;

public class MergeLinkedList {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) 
			return l2;
		if(l2 == null) 
			return l1;

		if(l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l2.next, l1);
			return l2;
		}
	}



	public static void main (String[] args) {
		ListNode n1 = new ListNode(2);
		n1.next = new ListNode(4);
		n1.next.next = new ListNode(6);

		ListNode n2 = new ListNode(3);
		n2.next = new ListNode(5);

		ListNode merge = mergeTwoLists(n1, n2);
		while (merge != null) {
			System.out.println(merge.val);
			merge = merge.next;
		}
	}

}
