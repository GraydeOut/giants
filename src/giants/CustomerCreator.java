package giants;

/**
 * CustomerCreator Class	Used to create a CustomerCreator object. Generates
 * 				Customer objects based on arrival and service parameters.
 * 
 * @author Ramon Meza
 * @version 1.0 3/6/2022
 * @since 1.0
 */

public class CustomerCreator {

	/**
	 * minimum interarrival time of customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private int minArrival;
	
	/**
	 * maximum interarrival time of customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private int maxArrival;
	
	/**
	 * minimum time to service customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private int minService;
	
	/**
	 * maximum time to service customer
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private int maxService;
	
	/**
	 * creates and initializes a CustomerCreator object using arrival and
	 * service parameters
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @param minArr	minimum arrival time
	 * @param maxArr	maximum arrival time
	 * @param minSer	minimum service time
	 * @param maxSer	maximum service time
	 */
	
	public CustomerCreator(int minArr, int maxArr, int minSer, int maxSer) {
		minArrival = minArr;
		maxArrival = maxArr;
		minService = minSer;
		maxService = maxSer;
	}
	
	/**
	 * returns a customer with semi-random arrival and service times
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @return	semi-randomly generated customer
	 */
	
	public Customer nextCustomer() {
		int arrival = (int) (Math.random() * (maxArrival - minArrival)) 
				+ minArrival;
		int service = (int) (Math.random() * (maxService - minService))
				+ minService;
		return new Customer(arrival, service);
	}
	
}
