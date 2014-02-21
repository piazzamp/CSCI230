package edu.cofc.compsci.csci230;

/**
 * 
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring 2014
 *
 */
public class QueueImpl extends ArrayList implements Queue {
	
	/**
	 * 
	 */
	public void printList() {
		for (int i = 0; i<this.size(); i++)
			try {
				System.out.println("Node ("+i+"): "+this.retrieve(i).getData());
			} catch (OutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
	}
	public int size() {
		return this.size();
	}
	
	public void enqueue(Node node) {
		this.add(node.getData());
			
	} // end enqueue() method

	public Node dequeue() {
		
		Node node = null;
		try {
			node = this.retrieve(0);
			this.remove(0);
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
		if (index<0 || index > this.size()-1)
			throw new OutOfBoundsException(String.format( "index position %d is not valid!\n", index ));
		else 
			node = this.retrieve(index);
		
		return node;
		
	} // end peek() method

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// --------------------------------------------------
		// Add test cases to demonstrate the functionality
		// of methods defined in Queue interface
		QueueImpl Q = new QueueImpl();
		for (int i = 0; i < 15 ; i++)
			this.enqueue(new Node(null,i+100));
		System.out.println("--------------------------------\nBEGIN\n--------------------------------\n");
		Q.printList();
		
		System.out.println("--------------------------------\nEnqueue 99\n--------------------------------\n");
		Q.enqueue(new Node (null,99));
		Q.printList();
		
		System.out.println("--------------------------------\nDequeue two values\n--------------------------------\n");
		System.out.println("First dequeue: "+Q.dequeue().getData());
		System.out.println("Second dequeue: "+Q.dequeue().getData()+"\n");
		Q.printList();
		
		System.out.println("--------------------------------\nPeek at a few nodes\n--------------------------------\n");
		try {
			System.out.println("Peek at index 4: "+Q.peek(4).getData());
			System.out.println("Peek at the last element: "+Q.peek(this.size()-1).getData());
			System.out.println("Peek at element 0: "+Q.peek(0).getData());
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	} // end main() method

}
