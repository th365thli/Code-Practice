package Elevator;

import java.util.Deque;
import java.util.LinkedList;

public class Elevator {

	private int currentFloor;
	private boolean up = false;

	public Deque<Integer> floorQueue = new LinkedList<Integer>();
	public Deque<Integer> inBetween = new LinkedList<Integer>();


	public Elevator() {
		System.out.println("Welcome to Zapata Computing");
		this.currentFloor = 1;




	}

	
	public void pressOutsideButton(int floor) throws InterruptedException {
		synchronized (this) {
			if (floorQueue.isEmpty()) {
				floorQueue.addFirst(floor);
			}
			else if (up && floor < floorQueue.peekFirst() && floor > currentFloor || !up && floor > floorQueue.peekFirst() && floor < currentFloor ) {
				inBetween.addFirst(floor);
			} else {
				floorQueue.addLast(floor);
			}
		}
	}

	/**
	 * Adds button press to queue. If it's a floor in between current and 
	 * destination, adds to an "inBetween" queue
	 * @param floor
	 * @throws InterruptedException
	 */
	public void pressInsideButton (int floor) throws InterruptedException {
		synchronized (this) {
			if (floorQueue.isEmpty()) {
				floorQueue.addFirst(floor);
			}
			else if (up && floor < floorQueue.peekFirst() && floor > currentFloor || !up && floor > floorQueue.peekFirst() && floor < currentFloor ) {
				inBetween.addFirst(floor);
			} else {
				floorQueue.addLast(floor);
			}
		}
	}


	/**
	 * 
	 * @throws InterruptedException
	 */
	public void startElevator() throws InterruptedException {

		while (true) {
			int destination = -1;
			synchronized (this) {
				if (!floorQueue.isEmpty()) {
					destination = floorQueue.peekFirst();
				}
			}

			if (destination != -1) {
				if (destination > currentFloor) {
					up = true;
					System.out.println("Moving up to floor " + destination);
				} else {
					up = false;
					System.out.println("Moving down to floor " + destination);
				}
				
				
				//We want to check the inBetween queue to see if any floors were added enroute
				checkInBetween(destination);
				
				
				currentFloor = destination;
				System.out.println("Stopping at floor " + destination);
				floorQueue.removeFirst();
				Thread.sleep(3000);

			}


		}
	}

	/**
	 * Checks inBetween queue to see if any floors were added between current floor and destination
	 * @param destination
	 * @throws InterruptedException
	 */
	public void checkInBetween(int destination) throws InterruptedException {
		
		long t= System.currentTimeMillis();
		long end = t+5000;
		int current;
		while(System.currentTimeMillis() < end) {
			current = destination;
			synchronized (this) {
				if (!inBetween.isEmpty()) {
					current = inBetween.peek();
				}
			}
			if (current != destination) {
				currentFloor = current;
				System.out.println("Moving to floor " + current);
				end = end + 3000;
				Thread.sleep(3000);
				System.out.println("Stopping at floor " + current);
				end = end + 3000;
				inBetween.removeLast();
			}
		}
	}
}









