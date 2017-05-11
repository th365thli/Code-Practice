package Problems;

public class ReverseLinkedList {
	
	public static Node head;
			
	public static class Node {
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
		}
		
		public String toString() {
			return Integer.toString(value);
		}
	}
	
	
	public static Node reverseLinkedList(Node node)  {
		//return reverseRecursive(node, null);
		return reverseIterative(node);
		
	}
	
	public static Node reverseRecursive(Node currentNode, Node prevNode) {
		Node head;
		if (currentNode.next == null) {
			currentNode.next = prevNode;
			head = currentNode;
			return head;
		}
		
		Node temp = prevNode;
		Node next = currentNode.next;
		prevNode = currentNode;
		prevNode.next = temp;
		return reverseRecursive(next, prevNode);
		
		
	}
	
	public static Node reverseIterative(Node curr) {
		Node prev = null;
		Node tempNext = null;
		while(curr != null) {
			tempNext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tempNext;
		}
		
		return prev;
	}
	
	
	public static void main (String[] args) {
		Node one = new Node(1);
		one.next = new Node(2);
		one.next.next = new Node(3);
		one.next.next.next = new Node(4);
		one.next.next.next.next = new Node(5);
		
		Node rev = reverseLinkedList(one);
		
		while (rev != null) {
			System.out.println(rev.value + " ");
			rev = rev.next;
		}
		
		
	}
	
	
	
	
	
}
