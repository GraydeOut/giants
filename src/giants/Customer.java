package giants;

/**
 * Customer Class	Used to create Customer objects. Objects simulate customer
 * 			queues times.
 * 
 * @author Noah Mountcastle
 * @version 1.0 3/6/2022
 * @since 1.0
 */

public class Customer {

	/**
	 * arrival time of customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private int arrival;
	
	/**
	 * time it takes customer to be serviced
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private int servTime;
	
	/**
	 * finish time of customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private int finish;
	
	/**
	 * line number customer is in
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private int line;
	
	/**
	 * creates and initializes a Customer object
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @param arrival	arrival time of customer
	 * @param servTime	service time of customer
	 */
	
	public Customer(int arrival, int servTime) {
		this.arrival = arrival;
		this.servTime = servTime;
	}
	
	/**
	 * used to get a String representation of a Customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @see String Class
	 * @return 	string representation of customer
	 */
	
	public String toString() {
		char lineName = ' ';
		switch (line) {
			case 0:
				lineName = 'A';
				break;
			case 1:
				lineName = 'B';
				break;
			case 2:
				lineName = 'C';
				break;
			default:
				System.out.println("Invalid line.");
				break;
		}
		
		return "Served by line " + lineName + " Arrival time: " + arrival 
				+ " Service time: " + servTime + " Departure time : " + finish ;
	}
	
	/**
	 * calculates the customer wait time between arrival and start of 
	 * service
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @return	wait time of customer
	 */
	
	public int waitTime() {
		return finish - arrival - servTime;
	}

	/**
	 * returns arrival time of customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @return	arrival time
	 */
	
	public int getArrival() {
		return arrival;
	}

	/**
	 * sets arrival time of customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @param arrival	sets arrival time
	 */
	
	public void setArrival(int arrival) {
		this.arrival = arrival;
	}

	/**
	 * returns service time of customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @return	service time
	 */
	
	public int getServTime() {
		return servTime;
	}

	/**
	 * sets service time of customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @param begin		service time
	 */
	
	public void setServTime(int servTime) {
		this.servTime = servTime;
	}

	/**
	 * gets finish time of customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @return	finish time
	 */
	
	public int getFinish() {
		return finish;
	}

	/**
	 * sets finish time of customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @param finish	finish time
	 */
	
	public void setFinish(int finish) {
		this.finish = finish;
	}
	
	/**
	 * get queue line number of customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0 
	 * @return	queue line number
	 */
	
	public int getLine() {
		return line;
	}
	
	/**
	 * set queue line number of customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @param line		queue line number
	 */
	
	public void setLine(int line) {
		this.line = line;
	}

}
