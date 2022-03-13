package giants;

/**
 * QueueLL Class	Linked list objects for simulating queues.
 * 
 * @author Noah Mountcastle
 * @version 1.0 3/6/2022
 * @since 1.0
 */

public class QueueLL {

	/**
	 * first Node in the linked list
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private Node first;
	
	/**
	 * last Node in the linked list
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private Node last;
	
	/**
	 * Node class		Creates Node objects for a linked list
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	private class Node {
		
		/**
		 * Customer object in Node
		 * 
		 * @version 1.0 3/6/2022
		 * @since 1.0
		 */
		
		Customer cust;
		
		/**
		 * points to next Node in list
		 * 
		 * @version 1.0 3/6/2022
		 * @since 1.0
		 */
		
		Node next;
		
		/**
		 * points to previous Node in list
		 * 
		 * @version 1.0 3/6/2022
		 * @since 1.0
		 */
		
		Node prev;
		
		/**
		 * creates Node objects
		 * 
		 * @version 1.0 3/6/2022
		 * @since 1.0
		 * @param cust		Customer object in Node
		 * @param next		next Node
		 * @param prev		previous Node
		 */
		
		Node(Customer cust, Node next, Node prev) {
			this.cust = cust;
			this.next = next;
			this.prev = prev;
		}
		
	}
	
	/**
	 * initializes an empty linked list
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 */
	
	public QueueLL() {
		first = null;
		last = null;
	}
	
	/**
	 * returns if linked list is empty
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @return	<code>true</code> linked list is empty
	 * 		<code>false</code> otherwise
	 */
	
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * returns how many Nodes are in linked list
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @return		size of linked list
	 */
	
	public int size() {
		int size = 0;
		Node n = first;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;
	}
	
	/**
	 * adds a customer to the linked list
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @param cust		customer to be added
	 */
	
	public void add(Customer cust) {
		if (isEmpty() ) {
			first = new Node(cust, null, null);
			last = first;
		} else {
			last.next = new Node(cust, null, last);
			last = last.next;
		}
	}
	
	/**
	 * removes and returns the first customer in the linked list
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @return		customer that was removed
	 */
	
	public Customer removeFront() {
		Customer cust = first.cust;
		first = first.next;
		if (first != null) {
		first.prev = null;
		}
		return cust;
	}
	
	/**
	 * returns the finish time of the first customer in the linked list
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @return		first customer finish time
	 */
	
	public int frontPeak() {
		return first.cust.getFinish();
	}
	
	/**
	 * returns the finish time of the last customer in the linked list
	 * 
	 * @version 1.0 3/6/2022
	 * @since 1.0
	 * @return		last customer finish time
	 */
	
	public int rearPeak() {
		return last.cust.getFinish();
	}
	
}
