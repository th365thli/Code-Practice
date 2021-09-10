package Elevator;

import java.util.Scanner;

public class App {

	/**
	 * The Elevator runnable application.
	 * 
	 * This applications spawns an thread representing the Elevator entity.
	 * 
	 * It then takes in console input from the user. It parses it and
	 * spawns threads that act as the "people" pushing the elevator buttons.
	 * Console inputs must be of format "inside floorNumber" or "outside floorNumber direction"
	 * 
	 * Included are some robustness checks, such as making sure input is formatted properly,
	 * input is of correct syntax, and other cases such as "6 up" (6 is the highest floor, there 
	 * is no "up" button). 
	 * 
	 * Examples:
	 * "inside 4"
	 * "inside 3"
	 * "outside 6 down"
	 * "outside 3 up"
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String ... args) throws Exception {

		Scanner myObj = new Scanner(System.in);
		Elevator elevator = new Elevator();


		Thread elevatorThread = new Thread(new Runnable() {
			public void run() {
				try {
					elevator.startElevator();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		elevatorThread.start();

		while (true) {
			String input = myObj.nextLine();
			try {

				if (input.equalsIgnoreCase("exit")) {
					myObj.close();
					System.out.println("Exiting the building");
					System.exit(0);
				}
				String[] command = input.split(" ");
				String floor = command[1];
				String inOrOut = command[0];
				
				int intFloor;
				try {
					intFloor = Integer.parseInt(floor);
				} catch (NumberFormatException e) {
					throw new NumberFormatException("Floor must be an integer");
				}
				if (intFloor < 1 || intFloor > 6) {
					throw new NumberFormatException("Floor must be a number between 1 - 6 inclusive");
				}

				if (inOrOut.equalsIgnoreCase("inside")) {
					if (command.length > 2) {
						throw new NumberFormatException("Invalid number of arguments for inside person: " + command.length);
					}
					Thread insidePerson = new Thread(new Runnable() {

						public void run() {
							try {
								elevator.pressInsideButton(intFloor);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}	
					});

					insidePerson.start();
					insidePerson.join();

				}

				else if (inOrOut.equalsIgnoreCase("outside")) {
					if (command.length != 3) {
						throw new NumberFormatException("Invalid number of arguments for outside person: " + command.length);
					}
					
					Thread outsidePerson = new Thread(new Runnable() {

						public void run() {
							try {
								elevator.pressOutsideButton(intFloor, command[2]);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}

						}	
					});

					outsidePerson.start();
					outsidePerson.join();

				}

			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}

		}

	}



}
