package Problems;

public class Main {
	
	public static void main(String args[]) {
		AddTwoNumbersLinkedList sol = new AddTwoNumbersLinkedList();
		ListNode n1 = new ListNode(9);
		//ListNode n2 = new ListNode(3);
		//n1.next = n2;
		
		ListNode x1 = new ListNode(1);
		ListNode x2 = new ListNode(9);
		x1.next = x2;
		
		ListNode sumNode = sol.addTwoNumbers(x1, n1);
		
		while (sumNode != null) {
			System.out.println(sumNode.val);
			sumNode = sumNode.next;
		}
	}

}
