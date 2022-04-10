package giants;

/**
 * Statistics Class		Used to create a Statistics object. Generates statistics
 * 				and outputs them to console.
 * 
 * @author Gray English
 * @author Ramon Meza
 * @version 1.1 3/26/2022
 * @since 1.0 3/6/2022
 */

public class Statistics {

	/**
	 * customers that were simulated
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private Customer custs[];
	
	/**
	 * number of full service checkouts
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.2 4/9/2022
	 */
	
	private int fullCheck;
	
	/**
	 * number of self service checkouts
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.2 4/9/2022
	 */
	
	private int selfCheck;
	
	/**
	 * aggregated time that each line was not queue with customers
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private int lineOpen[];
	
	/**
	 * elapsed total time simulated
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private int totalTime;
	
	/**
	 * creates a Statistics object with customers, line open time, and total time 
	 * from a simulation 
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @param custs			customers that were simulated
	 * @param lineOpen		how long each line was not queued
	 * @param totalTime		total time simulated
	 */
	
	Statistics(Customer custs[], int fullCheck, int selfCheck, int lineOpen[], int totalTime) {
		this.custs = custs;
		this.fullCheck = fullCheck;
		this.selfCheck = selfCheck;
		this.lineOpen = lineOpen;
		this.totalTime = totalTime;
	}
	
	/**
	 * prints statistics to console output
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	public void printStatistics() {
		customerDetails();
		System.out.println("\nThe total time to process all customers was " + totalTime 
				+ " minutes. \n");
		laneUsage();
		sortCustomers();
		averageWait();
		satisfaction();
	}
	
	/**
	 * prints usage of each lane to console output
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private void laneUsage() {
		if (fullCheck > 0) {
			System.out.println("Full Service Lines: ");
		}
		
		for (int i = 0; i < lineOpen.length; i++) {
			//Separates full/self service lines
			if (i == fullCheck) {
				System.out.println("\nSelf Service Lines: ");
			}
			int lineNum = i + 1;
			System.out.println("Line " + lineNum + " was not used"
					+ " for " + lineOpen[i] + " minutes.");
		}
		System.out.println("\n");
	}
	
	/**
	 * sorts customers by absolute arrival time
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private void sortCustomers() {
		Customer temp[] = new Customer[custs.length];
		int custCount = 0;
		
		//sorts customers by arrival time
		for(int i = 0; i <= totalTime; i++) {
			for (int j = 0; j < custs.length; j++) {
				if (custs[j].getArrival() == i) {
					temp[custCount] = custs[j];
					custCount++;
				}
			}
		}
		custs = temp;
	}
	
	/**
	 * prints average wait time of customers to console output
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private void averageWait() {
		int wait = 0;
		for (int i = 0; i < custs.length; i++) {
			wait += custs[i].waitTime();
		}
		
		wait /= custs.length;
		System.out.println("The average wait time for customers was " 
				+ wait + " minutes. \n");
	}
	
	/**
	 * prints number of satisfied and unsatisfied customers to console output
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private void satisfaction() {
		int satisfied = 0;
		for (int i = 0; i < custs.length; i++) {
			if (custs[i].waitTime() < 5) {
				satisfied++;
			}
		}
		int unsatisfied = custs.length - satisfied;
		System.out.println(satisfied + " customers were satisfied. " + unsatisfied 
				+ " customers waited 5 minutes or longer and were unsatified. \n ");
	}
	
	/**
	 * prints details of each customer simulated to console
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private void customerDetails() {
		for (int i = 0; i < custs.length; i++) {
			int custNum = i + 1;
			System.out.println("Customer " + custNum + " " + custs[i].toString()
					+ " Waited: " + custs[i].waitTime() + " (minutes)");
		}
	}
	
}
