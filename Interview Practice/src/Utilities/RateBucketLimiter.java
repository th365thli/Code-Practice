package Utilities;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class RateBucketLimiter {

	private int bucket = 0;
	private int capacity = 0;
	private final int ONE_SECOND = 1000;


	public RateBucketLimiter(int capacity) {

		this.capacity = capacity; 

	}


	public  void producer() throws InterruptedException {

		while (true) {

			synchronized(this) {
				if (bucket < capacity) {
					this.bucket++;
					System.out.println(Thread.currentThread().getName() + " dropped a   token");

				}

				notifyAll();
				
			}
			Thread.sleep(ONE_SECOND);

		}

	}

	public void consumer() throws InterruptedException {
		synchronized(this) {
			while (this.bucket == 0) {
				wait();
			}
			
			System.out.println(Thread.currentThread().getName() + " got a token");
			this.bucket--;
		}
		


	}





	public static void main(String[] args) throws InterruptedException {

		HashSet<Thread> allThreads = new HashSet<Thread>();

		RateBucketLimiter bucket = new RateBucketLimiter(5);



		for (int i = 0; i < 10; i++) {

			Thread thread = new Thread(new Runnable() {

				public void run() {
					try {
						bucket.consumer();
					}
					catch(InterruptedException ie) {

					}
				} 
			});

			allThreads.add(thread);
		}


		Thread produceThread = new Thread(new Runnable() {

			public void run() {
				try {
					bucket.producer(); 
				}
				catch(InterruptedException ie) {

				}

			}
		});

		produceThread.start();

		for (Thread t : allThreads) {
			t.start();    
		}

		for (Thread t : allThreads) {
			t.join();    
		}

		produceThread.join();


	}
}
