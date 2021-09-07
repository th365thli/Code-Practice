package Utilities;

import java.util.HashMap;

public class LC0146LRUCache {
	
	
	public class Node {
		Node prev;
		Node next;
		int key;
		int value;
	}
	
	
	private int capacity;
	private Node head;
	private Node tail;
	private HashMap<Integer, Node> cache = new HashMap<Integer, Node>();
	
	public LC0146LRUCache(int cap) {
		
		this.capacity = cap;
		
		head = new Node();
		tail = new Node();
		
		head.next = tail;
		tail.prev = head;
		
	}
	
	
	public void addToHead(Node node) {
		
		node.prev = head;
		node.next = head.next;
		
		head.next.prev = node;
		head.next = node;
		
	}
	
	public void removeNode(Node node) {
		
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.next = null;
		node.prev = null;
		
	}
	
	public void removeLRU() {
		Node node = tail.prev;
		node.prev.next = tail;
		tail.prev = node.prev;
	}
	
	
	public void put(int key, int value) {
		
		Node node = new Node();
		node.key = key; node.value = value;
		
		
		cache.put(key, node);
		
		addToHead(node);
		
		
		if (cache.size() > capacity) {
			removeLRU();
		}
		
	}
	
	public int get(int key) {
		Node node = cache.get(key);
		
		removeNode(node);
		addToHead(node);
		
		return node.value;
			
	}
	
	
	public static void main(String[] args) {
		
		LC0146LRUCache cache = new LC0146LRUCache(5);
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		
		cache.get(4);
		
		
	}
	
	

}
