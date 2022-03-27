package giants;

import java.util.Scanner;

/**
 * Menu Class 		Used to create Menu objects. Gets necessary user conditions 
 * 			as input and uses it to generate a Simulator. Produces Statistics 
 * 			using the Simulator and then prints them as console output.
 * 
 * @author Gray English
 * @version 1.1 3/26/2022
 * @since 1.0 3/6/2022
 */

public class Menu {
	
	/**
	 * Simulator object for simulating queues of customers
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private Simulator sim;
	
	/**
	 * Statistics object for generating statistics
	 *
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	private Statistics stats;
	
	/**
	 * Gets and verifies user conditions. Then initializes a Simulator object
	 * to produce a Statistics object. Prints statistics.
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	public void setupSim() {
		Scanner scan = new Scanner(System.in);
		
		//Get user options
		int minArr;
		do {
			System.out.print("Enter minimum interarrival time: ");
			minArr = scan.nextInt();
		} while (validTime(minArr) == false);
		
		int maxArr;
		do {
			System.out.print("Enter maximum interarrival time: ");
			maxArr = scan.nextInt();
		} while (validTime(maxArr) == false);
		
		int minServ;
		do {
			System.out.print("Enter minimum service time: ");
			minServ = scan.nextInt();
		} while (validTime(minServ) == false);
		
		int maxServ;
		do {
			System.out.print("Enter maximum service time: ");
			maxServ = scan.nextInt();
		} while (validTime(maxServ) == false);
		
		double selfPerc;
		do {
			System.out.println("Enter how much longer self service customers take as a percentage (0 to 300): ");
			selfPerc = scan.nextInt();
		} while (validPercent(selfPerc) == false);
		
		int custs;
		do {
			System.out.print("Enter the number of customers to be served: ");
			custs = scan.nextInt();
		} while (validCusts(custs) == false);
		System.out.println();
		
		//create simulator
		sim = new Simulator(minArr, maxArr, minServ, maxServ, selfPerc, custs);
		
		//simulate to get statistics
		stats = sim.simulate();
		stats.printStatistics();
	}
	
	/**
	 * Verify that time entered as a condition as input is valid
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @param time		the time entered as a condition
	 * @return		<code>true</code> if time is a valid number
	 * 			<code>false</code> otherwise 
	 */
	private boolean validTime(int time) {
		if (time <= 0) {
			System.out.println("Invalid time. Must be greater than or equal to 1. \n");
			return false;
		}
		return true;
	}
	
	/**
	 * Verify that percent entered as a condition as input is valid
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 * @param percent
	 * @return		<code>true</code> if percent is a valid number
	 * 			<code>false</code> otherwise
	 */
	
	private boolean validPercent(double percent) {
		if (percent < 0.0 || percent > 300.0) {
			System.out.println("Invalid percentage. Must be between 0 and 100. \n");
			return false;
		}
		return true;
	}
	
	/**
	 * Verify that number of customers entered as input is valid
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @param custs		number of customers
	 * @return		<code>true</code> if custs is a valid number
	 * 			<code>false</code> otherwise
	 */
	private boolean validCusts(int custs) {
		if (custs <= 0) {
			System.out.println("Invalid number of customers. Must be greater than 0. \n");
			return false;
		}
		return true;
	}
	
}
