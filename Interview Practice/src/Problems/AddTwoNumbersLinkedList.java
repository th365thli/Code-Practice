package Problems;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbersLinkedList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carryover = 0;
		ListNode prevNode = null;
		ListNode headNode = null;
		while (l1 != null || l2 != null || carryover == 1) {
			ListNode sumNode = new ListNode(0);
			int newValue= 0;
			if (l1 == null && l2 == null) {
				newValue = carryover;
				carryover = 0;
			}
			else if (l1 == null && l2 != null) {
				newValue = l2.val + carryover;
			} else if (l2 == null && l1 != null) {
				newValue = l1.val + carryover;
			} else {
				newValue = l1.val + l2.val + carryover;
			}
			if (newValue >= 10) {
				newValue = newValue % 10;
				carryover = 1;
			} else {
				carryover = 0;
			}
			sumNode.val = newValue;
			if (prevNode == null) {
				prevNode = sumNode;
				headNode = prevNode;
			} else {
				prevNode.next = sumNode;
				prevNode = prevNode.next;
			}
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}


		return headNode;

	}
}

