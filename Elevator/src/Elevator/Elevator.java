package Elevator;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * The Elevator class holding all Elevator functions
 * 
 * It uses a Dequeu structure to hold destinations. 
 * It uses a PriorityQueue to hold and order in between upwards destinations
 * It uses another PriorityQueue in reverse ordering to hold and order in between downwards destinations
 * 
 * @author Jerry
 *
 */
public class Elevator {

	private int currentFloor;
	private boolean up = false;

	public Deque<Integer> floorQueue = new LinkedList<Integer>();
	public PriorityQueue<Integer> inBetweenUp = new PriorityQueue<Integer>();
	public PriorityQueue<Integer> inBetweenDown = new PriorityQueue<Integer>(Collections.reverseOrder());



	public Elevator() {
		System.out.println("Welcome to Zapata Computing");
		System.out.println("Initializing Elevator...");
		System.out.println("Elevator Ready! Begin selecting floors.");
		this.currentFloor = 1;

	}

	/**
	 * Add button press to queue along with direction. If direction equals 
	 * elevator direction, and it's between current floor and destination, add to
	 * inBetween pqueue
	 * @param floor
	 * @param direction
	 * @throws Exception
	 */
	public void pressOutsideButton(int floor, String direction) throws Exception {
		boolean personUp;
		if (direction.equalsIgnoreCase("up")) {
			personUp = true;
		} else if (direction.equalsIgnoreCase("down")) {
			personUp = false;
		} else {
			throw new Exception("Incorrect direction input: " + direction);
		}

		if (floor == 6 && direction.equals("up") || floor == 1 && direction.equalsIgnoreCase("down")) {
			throw new Exception("Incorrect direction input for floor " + floor);
		}


		System.out.println("Someone at floor " + floor + " pressed " + direction);

		synchronized (this) {
			if (floorQueue.isEmpty()) {
				floorQueue.addFirst(floor);
			}
			//If the button direction equals current direction, and the floor pressed
			//is between current floor and destination, add to inBetween dequeue
			else if (up && personUp && floor < floorQueue.peekFirst() && floor > currentFloor) {
				inBetweenUp.offer(floor);
			} 
			else if (!up && !personUp && floor > floorQueue.peekFirst() && floor < currentFloor) {
				inBetweenDown.offer(floor);
				//In all other cases, such as unequal direction, or outside range of 
				//current and destination, add to the main dequeue
			} else {
				floorQueue.addLast(floor);
			}
		}
	}

	/**
	 * Adds button press to queue. If it's a floor in between current and 
	 * destination, adds to an "inBetween" pqueue
	 * @param floor
	 * @throws InterruptedException
	 */
	public void pressInsideButton (int floor) throws InterruptedException {
		System.out.println("Someone inside pressed button " + floor);
		synchronized (this) {
			if (floorQueue.isEmpty()) {
				floorQueue.addFirst(floor);
			}
			else if (up && floor < floorQueue.peekFirst() && floor > currentFloor) {
				inBetweenUp.offer(floor);
			} 
			else if (!up && floor > floorQueue.peekFirst() && floor < currentFloor) {
				inBetweenDown.offer(floor);
			} else {
				floorQueue.addLast(floor);
			}
		}
	}


	/**
	 * Constant loop that checks if queue is occupied. If so, "move" the elevator
	 * @throws InterruptedException
	 */
	public void startElevator() throws InterruptedException {

		while (true) {
			int destination = -1;
			synchronized (this) {
				if (!floorQueue.isEmpty()) {
					destination = floorQueue.peekFirst();
					System.out.println("Moving to floor " + destination);
				}
			}
			
			//Get initial direction when queue is empty
			if (destination != -1) {
				if (destination > currentFloor) {
					up = true;
				} else {
					up = false;
				}

				//We want to check the inBetween queue to see if any floors were added enroute
				checkInBetween(destination);

				
				
			
				currentFloor = destination;
				floorQueue.removeFirst();
				//Calculate direction every time the elevator moves
				synchronized(this) {
					if (!floorQueue.isEmpty()) {
						if (destination < floorQueue.peek()) {
							up = true;
						} else {
							up = false;
						}
					} 
				}
				System.out.println("Arrived at floor " + destination);
				Thread.sleep(10000);

			}


		}
	}

	/**
	 * Checks inBetween queue to see if any floors were added between current floor and destination
	 * @param destination
	 * @throws InterruptedException
	 */
	public void checkInBetween(int destination) throws InterruptedException {
		
		//Sleep the thread to simulate movement. In this time
		//in between floors can be added
		Thread.sleep(4500);
		long t= System.currentTimeMillis();
		long end = t+500;
		int current;
		while(System.currentTimeMillis() < end) {
			current = destination;
			synchronized (this) {
				if (!inBetweenUp.isEmpty() && up) {
					current = inBetweenUp.peek(); 
				} 
				else if (!inBetweenDown.isEmpty() && !up) {
					current = inBetweenDown.peek();
				}
			}
			if (current != destination) {
				System.out.println("Stopping at floor " + current);
				currentFloor = current;
				end = end + 10000;
				Thread.sleep(10000);
				if (up) { inBetweenUp.poll(); } 
				else { inBetweenDown.poll();  }
			}
		}
	}
	
}









