package edu.cofc.compsci.csci230;

/**
 * 
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring 2014
 *
 */
public class QueueImpl extends ArrayList implements Queue {
	private List list = new ArrayList();
	/**
	 * 
	 */
	public void printList() {
		for (int i = 0; i<list.size(); i++)
			try {
				System.out.println("Node ("+i+"): "+list.retrieve(i).getData());
			} catch (OutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
	}
	public int size() {
		return list.size();
	}
	
	public void enqueue(Node node) {
		list.add(node.getData());
			
	} // end enqueue() method

	public Node dequeue() {
		
		Node node = null;
		try {
			node = list.retrieve(0);
			list.remove(0);
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		return node;
		
	} // end dequeue() method

	/**
	 * 
	 * Peek method simply returns the node object at the
	 * specified index position in the queue. This operation 
	 * DOES NOT remove the node from the queue.
	 * 
	 */
	public Node peek(int index) throws OutOfBoundsException {
		Node node = null;
		// --------------------------------------------------
		// The peek method will return the Node object at the 
		// given index position in the Queue. For instance, 
		// index=0 would return the Node object at the front 
		// of the queue.
		if (index<0 || index > list.size()-1)
			throw new OutOfBoundsException(String.format( "index position %d is not valid!\n", index ));
		else 
			node = list.retrieve(index);
		
		return node;
		
	} // end peek() method
	
	public boolean isEmpty() { 
		return ( size() == 0 ) ? true : false; 		 
		} // end isEmpty() method


	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// --------------------------------------------------
		// Add test cases to demonstrate the functionality
		// of methods defined in Queue interface
		QueueImpl list = new QueueImpl();
		for (int i = 0; i < 15 ; i++)
			list.enqueue(new Node(null,i+100));
		System.out.println("--------------------------------\nBEGIN\n--------------------------------\n");
		list.printList();
		
		System.out.println("--------------------------------\nEnqueue 99\n--------------------------------\n");
		list.enqueue(new Node (null,99));
		list.printList();
		
		System.out.println("--------------------------------\nDequeue two values\n--------------------------------\n");
		System.out.println("First dequeue: "+list.dequeue().getData());
		System.out.println("Second dequeue: "+list.dequeue().getData()+"\n");
		list.printList();
		
		System.out.println("--------------------------------\nPeek at a few nodes\n--------------------------------\n");
		try {
			System.out.println("Peek at index 4: "+list.peek(4).getData());
			System.out.println("Peek at the last element: "+list.peek(list.size()-1).getData());
			System.out.println("Peek at element 0: "+list.peek(0).getData());
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	} // end main() method

}
