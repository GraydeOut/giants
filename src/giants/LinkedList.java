package giants;

/**
 * LinkedList Class		Linked list for queuing objects
 * 
 * @author Noah Mountcastle
 * @version 1.1 3/26/2022
 * @since 1.0 3/6/2022
 */

public class LinkedList {

	/**
	 * first Node in the linked list
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private Node first;
	
	/**
	 * last Node in the linked list
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private Node last;
	
	/**
	 * Node class		Creates Node objects for a linked list
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	private static class Node {
		
		/**
		 * Customer object in Node
		 * 
		 * @version 1.1 3/26/2022
		 * @since 1.0 3/6/2022
		 */
		
		Customer cust;
		
		/**
		 * points to next Node in list
		 * 
		 * @version 1.1 3/26/2022
		 * @since 1.0 3/6/2022
		 */
		
		Node next;
		
		/**
		 * points to previous Node in list
		 * 
		 * @version 1.1 3/26/2022
		 * @since 1.0 3/6/2022
		 */
		
		Node prev;
		
		/**
		 * creates Node objects
		 * 
		 * @version 1.1 3/26/2022
		 * @since 1.0 3/6/2022
		 * @param object		object in Node
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
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 */
	
	public LinkedList() {
		first = null;
		last = null;
	}
	
	/**
	 * returns if linked list is empty
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @return	<code>true</code> linked list is empty
	 * 		<code>false</code> otherwise
	 */
	
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * returns how many Nodes are in linked list
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
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
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @param cust	customer to be added
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
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
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
	 * returns first object in the linked list
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @return		first object
	 */
	
	public Customer frontPeek() {
		return first.cust;
	}
	
	/**
	 * returns last object in the linked list
	 * 
	 * @version 1.1 3/26/2022
	 * @since 1.0 3/6/2022
	 * @return		last object
	 */
	
	public Customer rearPeek() {
		return last.cust;
	}
	
}
