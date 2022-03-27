package giants;
/**
 * Checkout Class		Used to create Checkout objects. Objects simulate customer checkouts.
 * 
 * @author Ramon Meza
 * @version 1.1 3/26/2022
 * @since 1.1 3/26/2022
 */
public class Checkout {

	/**
	 * customer currently in checkout
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 */
	
	private Customer cust;
	
	/**
	 * accumulated time checkout is empty
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 */
	
	private int waitTime;
	
	/**
	 * creates and initializes an empty Checkout object
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 */
	
	public Checkout() {
		cust = null;
		waitTime = 0;
	}
	
	/**
	 * Used to get the finish time of customer in checkout and accumulate waitTime
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 * @param currentTime	time since simulation started
	 * @return		time that customer in checkout is finished
	 */
	
	public int getFinishTime(int currentTime) {
		if(cust == null) {
			waitTime++;
			return currentTime;
		}
		return cust.getFinish();
	}
	
	/**
	 * set next customer to be checked out
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 * @param cust		next customer for checkout
	 */
	
	public void newCustomer(Customer cust) {
		this.cust = cust;
	}
	
	/**
	 * returns if checkout is open
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 * @return		<code>true</code> checkout is open
	 * 				<code>false</code> otherwise
	 */
	
	public boolean open() {
		if (cust == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * returns finished customer from checkout
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 * @return		customer from checkout
	 */
	
	public Customer removeCustomer() {
		Customer temp = cust;
		cust = null;
		return temp;
	}
	
	/**
	 * returns the accumulated time checkout had no customers
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 * @return		accumulated wait time of checkout
	 */
	
	public int getWaitTime() {
		return waitTime;
	}
	
}
