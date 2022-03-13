package giants;

/**
 * Statistics Class		Used to create a Statistics object. Generates statistics
 * 				and outputs them to console.
 * 
 * @author Gray English
 * @author Ramon Meza
 * @version 1.0 3/6/2022
 * @since 1.0
 */

public class Statistics {

	/**
	 * customers that were simulated
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private Customer custs[];
	
	/**
	 * aggregated time that each line was not queue with customers
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private int lineOpen[];
	
	/**
	 * elapsed total time simulated
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private int totalTime;
	
	/**
	 * creates a Statistics object with customers, line open time, and total time 
	 * from a simulation 
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @param custs			customers that were simulated
	 * @param lineOpen		how long each line was not queued
	 * @param totalTime		total time simulated
	 */
	
	Statistics(Customer custs[], int lineOpen[], int totalTime) {
		this.custs = custs;
		this.lineOpen = lineOpen;
		this.totalTime = totalTime;
	}
	
	/**
	 * prints statistics to console output
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	public void printStatistics() {
		System.out.println("The lines were open for " + totalTime 
				+ " minutes. \n");
		laneUsage();
		
		sortCustomers();
		averageWait();
		satisfaction();
		customerDetails();
	}
	
	/**
	 * prints usage of each lane to console output
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private void laneUsage() {
		char[] lineName = {'A', 'B', 'C'};
		for (int i = 0; i < lineOpen.length; i++) {
			System.out.println("Line " + lineName[i] + " was not used"
					+ " for " + lineOpen[i] + " minutes. \n");
		}
	}
	
	/**
	 * sorts customers by absolute arrival time
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
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
	 * @version 1.0 3/6/2022
	 * @since 1.0
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
	 * @version 1.0 3/6/2022
	 * @since 1.0
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
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private void customerDetails() {
		for (int i = 0; i < custs.length; i++) {
			int custNum = i + 1;
			System.out.println("Customer " + custNum + " " + custs[i].toString()
					+ " Waited: " + custs[i].waitTime() + " (minutes)");
		}
	}
	
}
