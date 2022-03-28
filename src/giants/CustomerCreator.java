package giants;

/**
 * CustomerCreator Class	Used to create a CustomerCreator object. Generates
 * 				Customer objects based on arrival and service parameters.
 * 
 * @author Ramon Meza
 * @version 1.1 3/26/2022
 * @since 1.0 3/6/2022
 */

public class CustomerCreator {

	/**
	 * minimum interarrival time of customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private int minArrival;
	
	/**
	 * maximum interarrival time of customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private int maxArrival;
	
	/**
	 * minimum time to service customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private int minService;
	
	/**
	 * maximum time to service customer
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private int maxService;
	
	private double selfModifier;
	
	/**
	 * creates and initializes a CustomerCreator object using arrival and
	 * service parameters
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @param minArr	minimum arrival time
	 * @param maxArr	maximum arrival time
	 * @param minSer	minimum service time
	 * @param maxSer	maximum service time
	 */
	
	public CustomerCreator(int minArr, int maxArr, int minSer, int maxSer, double selfMod) {
		minArrival = minArr;
		maxArrival = maxArr;
		minService = minSer;
		maxService = maxSer;
		selfModifier = (100.00 + selfMod) / 100;
	}
	
	/**
	 * returns a customer with semi-random arrival and service times
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @return	semi-randomly generated customer
	 */
	
	public Customer nextCustomer() {
		//Sets service and arrival times
		int arrival = (int) (Math.random() * (maxArrival - minArrival + 1)) 
				+ minArrival;
		int service = (int) (Math.random() * (maxService - minService + 1))
				+ minService;
		
		//Determine if customer is self service and modify's service time if so
		int coinFlip = (int) (Math.random() * 2) + 1;
		boolean selfCheckout;
		if (coinFlip == 1) {
			service *= selfModifier;
			selfCheckout = true;
		} else {
			selfCheckout = false;
		}
		return new Customer(arrival, service, selfCheckout);
	}
	
}
