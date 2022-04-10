package giants;

/**
 * Customer Class	Used to create Customer objects. Objects simulate customer
 * 					queues times.
 * 
 * @author Noah Mountcastle
 * @version 1.1 3/26/2022
 * @since 1.0 3/6/2022
 */

public class Customer {

	/**
	 * arrival time of customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private int arrival;
	
	/**
	 * time it takes customer to be serviced
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private int servTime;
	
	/**
	 * finish time of customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private int finish;
	
	/**
	 * line number customer is in
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private int line;
	
	/**
	 * whether customer used self checkout
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 */
	
	private boolean selfCheckout; 
	
	/**
	 * creates and initializes a Customer object
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @param arrival	arrival time of customer
	 * @param servTime	service time of customer
	 */
	
	public Customer(int arrival, int servTime, boolean selfCheckout) {
		this.arrival = arrival;
		this.servTime = servTime;
		this.selfCheckout = selfCheckout;
	}
	
	/**
	 * used to get a String representation of a Customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @see String Class
	 * @return 	string representation of customer
	 */
	
	public String toString() {
		int lineNum = line + 1;
		return "Served by line " + lineNum + " Arrival time: " + arrival 
				+ " Service time: " + servTime + " Departure time : " + finish ;
	}
	
	/**
	 * calculates the customer wait time between arrival and start of 
	 * service
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @return	wait time of customer
	 */
	
	public int waitTime() {
		return finish - arrival - servTime;
	}

	/**
	 * returns arrival time of customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @return	arrival time
	 */
	
	public int getArrival() {
		return arrival;
	}

	/**
	 * sets arrival time of customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @param arrival	sets arrival time
	 */
	
	public void setArrival(int arrival) {
		this.arrival = arrival;
	}

	/**
	 * returns service time of customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @return	service time
	 */
	
	public int getServTime() {
		return servTime;
	}

	/**
	 * sets service time of customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @param begin		service time
	 */
	
	public void setServTime(int servTime) {
		this.servTime = servTime;
	}

	/**
	 * gets finish time of customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @return	finish time
	 */
	
	public int getFinish() {
		return finish;
	}

	/**
	 * sets finish time of customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @param finish	finish time
	 */
	
	public void setFinish(int finish) {
		this.finish = finish + servTime;
	}
	
	/**
	 * get queue line number of customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @return	queue line number
	 */
	
	public int getLine() {
		return line;
	}
	
	/**
	 * set queue line number of customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @param line		queue line number
	 */
	
	public void setLine(int line) {
		this.line = line;
	}
	
	/**
	 * returns if customer used self checkout line
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 * @return	<code>true</code> customer used self checkout
	 * 		<code>false</code> otherwise
	 */
	
	public boolean getSelfCheckout() {
		return selfCheckout;
	}

}
