package Problems;

public class RemoveNthFromEnd {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int x = removeNth(head, null, 0, n);
		if (x == -1) {
			return null;
		} else if (x == -2) {
			ListNode temp = head.next;
			head = null;
			return temp;
		} else {
			return head;
		}

	}
	public static int removeNth(ListNode node, ListNode prev, int count, int nth) {
		if (node.next == null) {
			if (nth == 1) {
				if (prev != null) {
					prev.next = null;
				} else {
					return -1;
				}
			}
			return 1;
		} 

		count = removeNth(node.next, node, count, nth) + 1;
		if (count == nth) {
			if (prev != null) {
				prev.next = node.next;
			} else {
				return -2;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		/*
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		 */

		ListNode head = new ListNode(1);
		head = removeNthFromEnd(head, 1);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}


}
