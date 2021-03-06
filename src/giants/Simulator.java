package giants;

/**
 * Simulator Class		Used to create Simulator objects. Simulates queues
 * 				of customers with linked lists.
 * 
 * @author Gray English
 * @author Ramon Meza
 * @author Noah Mountcastle
 * @version 1.1 3/26/2022
 * @since 1.0 3/6/2022
 */

public class Simulator {

	/**
	 * number of customers to simulate
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private int numCusts;
	
	/**
	 * CustomerCreator object to generate customers
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private CustomerCreator creator;
	
	/**
	 * totalTime elapsed during simulation of queues
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	int currentTime;
	
	/**
	 * simulation customers
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private Customer customers[];
	
	/**
	 * full service checkouts
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 */
	
	private Checkout fullCheck[];
	
	/**
	 * self service checkouts
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 */
	
	private Checkout selfCheck[];
	
	/**
	 * full service queues
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 */
	
	Queue fullQueue[];
	
	/**
	 * self service queue
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 */
	
	Queue selfQueue;
	
	/**
	 * initializes a Simulator object using a CustomerCreator, number of full and self service lines,
	 * and amount of customers to be simulated.
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @param creator			Customer creator object
	 * @param fullService		number of self service lines
	 * @param selfService		number of full service lines
	 * @param custs				number of customers
	 */
	
	public Simulator(CustomerCreator creator, int fullService, int selfService, int custs) {
		//initialize fields
		numCusts = custs;
		customers = new Customer[numCusts];
		currentTime = 0;
		
		//initialize creator
		this.creator = creator;
		
		//initialize checkouts
		fullCheck = new Checkout[fullService];
		for(int i = 0; i < fullCheck.length; i++) {
			fullCheck[i] = new Checkout();
		}
		selfCheck = new Checkout[selfService];
		for(int i = 0; i < selfCheck.length; i++) {
			selfCheck[i] = new Checkout();
		}
		
		//initializes queues
		fullQueue = new Queue[fullService];
		for (int i = 0; i < fullQueue.length; i++) {
			fullQueue[i] = new Queue();
		}
		selfQueue = new Queue();
	}
	
	/**
	 * returns a Statistics object generated by simulating queues of customers
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @return	statistics of simulation
	 */
	
	public Statistics simulate() {
		//initializes variables
		int servedCusts = 0;
		int nextArrival = 0;
		int custCount = 0;
		
		//loops until all customers served
		while (servedCusts < numCusts) {
			
			//gets next customer
			if (nextArrival == 0 && custCount < numCusts) {
				Customer cust = creator.nextCustomer();
				nextArrival = cust.getArrival();
				cust.setArrival(currentTime);
				
				//Puts customer in appropriate queue
				if (cust.getSelfCheckout() == true) {
					selfQueue.enqueue(cust);
				} else {
					selectFullQueue(cust);
				}
				custCount++;
			}
			
			//Moves customers from full service queues/checkouts
			for ( int i = 0; i < fullCheck.length; i++) {
				//Removes full service customers from checkouts
				if (fullCheck[i].getFinishTime(currentTime) == currentTime && fullCheck[i].open() == false) {
					customers[servedCusts] = fullCheck[i].removeCustomer();
					servedCusts++;
				}
				
				//Adds full service customer from queues to checkouts
				if (fullCheck[i].open() == true && fullQueue[i].isEmpty() == false) {
					Customer cust = fullQueue[i].dequeue();
					cust.setFinish(currentTime);
					cust.setLine(i);
					fullCheck[i].newCustomer(cust);
				}
			}
			
			//Removes self service customers from checkouts
			for (int i = 0; i < selfCheck.length; i++) {
				if (selfCheck[i].getFinishTime(currentTime) == currentTime && selfCheck[i].open() == false) {
					customers[servedCusts] = selfCheck[i].removeCustomer();
					servedCusts++;
				}
			}
			
			//Adds self service customers from queue to checkout
			for (int i = 0; i < selfCheck.length; i++) {
				if (selfCheck[i].open() == true) {
					if (selfQueue.isEmpty() == true) {
						break;
					} else {
						Customer cust = selfQueue.dequeue();
						cust.setFinish(currentTime);
						cust.setLine(i + fullCheck.length);
						selfCheck[i].newCustomer(cust);
					}
				}
			}
			
			//counts time
			currentTime++;
			nextArrival--;
		}
		
		//gets wait time for each checkout
		int waitTime[] = new int[fullCheck.length + selfCheck.length];
		for (int i = 0; i < fullCheck.length; i++) {
			waitTime[i] = fullCheck[i].getWaitTime();
		}
		
		for (int i = 0; i < selfCheck.length; i++) {
			waitTime[i + fullCheck.length] = selfCheck[i].getWaitTime();
		}
		
		//returns Statistics object
		currentTime--;
		Statistics stats = new Statistics(customers, fullCheck.length, selfCheck.length, waitTime, currentTime);
		return stats;
	}
	
	/**
	 * Puts customer in queue with least amount of customers or first empty queue
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 * @param cust		customer to place in smallest queue
	 */
	
	private void selectFullQueue(Customer cust) {
		int selectQ = 0;
		int smallest = Integer.MAX_VALUE;
		
		for (int i = 0; i < fullQueue.length; i++) {
			//Checks if empty queue
			if (fullQueue[i].isEmpty()) {
				fullQueue[i].enqueue(cust);
				return;
			} else {
				//Finds smallest queue
				if (fullQueue[i].size() < smallest) {
					smallest = fullQueue[i].size();
					selectQ = i;
				}
			}
		}
		fullQueue[selectQ].enqueue(cust);
		return;
	}
	
}
