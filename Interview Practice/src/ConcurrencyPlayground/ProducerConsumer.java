package ConcurrencyPlayground;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	Queue<Integer> queue = new LinkedList<Integer>();
	private final int capacity;


	public ProducerConsumer(int capacity) {


		this.capacity = capacity;


	}


	public synchronized void produce() {

		while (queue.size() == capacity) {
			try {
				System.out.println("Producer " + Thread.currentThread().getName() + " is waiting. Capacity is " + queue.size());
				wait();
			} catch (InterruptedException e) {
				//do something
			}
		}

		queue.add(1);
		System.out.println("Producer " + Thread.currentThread().getName() + " produced. Capacity now: " + queue.size());

		notifyAll();

	}


	public synchronized void consume() {

		while (queue.size() == 0 ) {
			try {
				System.out.println("Consumer " + Thread.currentThread().getName() + " is waiting. Capacity is " + queue.size());
				wait();
			} catch (InterruptedException e) {
				//do something
			}
		}

		queue.poll();
		System.out.println("Consumer " + Thread.currentThread().getName() + " consumed. Capacity now: " + queue.size());
		
		notifyAll();


	}


	public static void main(String[] args) throws InterruptedException {

		ProducerConsumer test = new ProducerConsumer(3);
		HashSet<Thread> threadPool = new HashSet<Thread>();

		for (int i = 0; i < 10; i++) {

			Thread thread = new Thread(new Runnable() { 
				@Override
				public void run() {
					test.produce();
				}
			});
			
			threadPool.add(thread);
			thread.setName("Thread " + i);
		}
		
		for (int i = 0; i < 10; i++) {

			Thread thread = new Thread(new Runnable() { 
				@Override
				public void run() {
					test.consume();
				}
			});
			
			threadPool.add(thread);
			thread.setName("Thread " + i);
		}
		
		
		for (Thread t : threadPool) {
			t.start();
		}
		
		for (Thread t : threadPool) {
			t.join();
		}



	}




}
