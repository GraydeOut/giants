package giants;

/**
 * Queue Class		queue for simulating customer throughput
 * 
 * @author Ramon Meza
 * @version 1.1 3/26/2022
 * @since 1.1 3/26/2022
 */

public class Queue {

	/**
	 * linked list object for Queue class
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 */
	
	private LinkedList list;
	
	/**
	 * creates and initializes an empty queue object
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 */
	
	public Queue() {
		list = new LinkedList();
	}
	
	/**
	 * adds a customer to rear of list
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 * @param object	object to be added
	 */
	
	public void enqueue(Customer cust) {
		list.add(cust);
	}
	
	/**
	 * removes and returns the first customer in list
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/26/2022
	 * @return		object that was removed
	 */
	
	public Customer dequeue() {
		return list.removeFront();
	}
	
	/**
	 * returns if list is empty
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 * @return	<code>true</code> list is empty
	 * 		<code>false</code> otherwise
	 */
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * returns first customer in list
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 * @return		first object
	 */
	
	public Customer frontPeek() {
		return list.frontPeek();
	}
	
	/**
	 * returns last customer in list
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 * @return		last object
	 */
	
	public Customer rearPeek() {
		return list.rearPeek();
	}
	
	/**
	 * returns how many customers are in list
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.1 3/26/2022
	 * @return		size of list
	 */
	
	public int size() {
		return list.size();
	}
	
}
