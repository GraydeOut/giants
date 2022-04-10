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
	
	/**
	 * <code>true</code> full service lines exist
	 * <code>false</code> otherwise
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.2 4/9/2022
	 */
	
	private boolean fullLine;
	
	/**
	 * <code>true</code> self service lines exist
	 * <code>false</code> otherwise
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.2 4/9/2022
	 */
	
	private boolean selfLine;
	
	/**
	 * percentage modifier determining how much long self service line service times are
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 */
	
	private double selfModifier;
	
	/**
	 * creates and initializes a CustomerCreator object using arrival and
	 * service parameters
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @param minArr		minimum arrival time
	 * @param maxArr		maximum arrival time
	 * @param minSer		minimum service time
	 * @param maxSer		maximum service time
	 * @param fullLine		full service lines exist
	 * @param selfLine		self service lines exist
	 * @param SelfMod		self service modifier
	 */
	
	public CustomerCreator(int minArr, int maxArr, int minSer, int maxSer,boolean fullLine, boolean selfLine, double selfMod) {
		minArrival = minArr;
		maxArrival = maxArr;
		minService = minSer;
		maxService = maxSer;
		this.fullLine = fullLine;
		this.selfLine = selfLine;
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
		boolean selfCheckout = false;
		
		if (selfLine == true && fullLine == true ) {
			int coinFlip = (int) (Math.random() * 2) + 1;
			if (coinFlip == 1) {
				service *= selfModifier;
				selfCheckout = true;
			}
		} else if (selfLine == true) {
			service *= selfModifier;
			selfCheckout = true;
		}
		
		return new Customer(arrival, service, selfCheckout);
	}
	
}
