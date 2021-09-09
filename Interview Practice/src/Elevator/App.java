package Elevator;

import java.util.Scanner;

public class App {

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
					elevatorThread.join();
					System.exit(0);
				}
				String[] command = input.split(" ");
				if (command.length != 2) {
					throw new NumberFormatException("Input must be of form 'inside/outside floorNum (Example: outside 1)");
				}
				String floor = command[1];
				String inOrOut = command[0];

				int intFloor = Integer.parseInt(floor);
				if (intFloor < 1 || intFloor > 6) {
					throw new NumberFormatException("Floor must be a number between 1 - 6 inclusive");
				}

				if (inOrOut.equalsIgnoreCase("inside")) {
					Thread insidePerson = new Thread(new Runnable() {

						public void run() {
							try {
								System.out.println("Someone pressed button " + intFloor);
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
					Thread outsidePerson = new Thread(new Runnable() {

						public void run() {
							try {
								System.out.println("Someone pressed button " + intFloor);
								elevator.pressOutsideButton(intFloor);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}	
					});

					outsidePerson.start();
					outsidePerson.join();

				}

			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}


			//elevatorThread.join();	
		}



	}



}
