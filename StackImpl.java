package edu.cofc.compsci.csci230;

/**
 * 
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring 2014
 *
 */
public class StackImpl implements Stack {
	
	private List list = new SLList();

	/**
	 * 
	 */
	
	public void printList() {
		for (int i =0; i<list.size(); i++)
			try {
				System.out.printf("Node (%d) = %d\n", i, list.retrieve(i).getData());
			} catch (OutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		
	}
	public void push(Node node) {
		list.add(node.getData());
		
	} // end() push() method

	/**
	 * Remove and return the last node object in the stack
	 */
	public Node pop() {
		Node node = null;
		
		try {
			node=list.retrieve(list.size()-1);
			list.remove();
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
			}
		
		return node;
		
	} // end pop() method

	/**
	 * Peek method simply returns the node object at the
	 * specified index position in the stack. This operation 
	 * DOES NOT remove the node from the stack.
	 * 
	 */
	public Node peek(int index) throws OutOfBoundsException {
		
		// --------------------------------------------------
		// The peek method will return the Node object at the 
		// given index position in the Stack. For instance, 
		// index=0 would return the first node object pushed
		// into the stack.
		Node node = null;
		
		if (index < 0 || index >= list.size())
			throw new OutOfBoundsException(String.format("index position %d is not valid!\n", index));
		else {
			node = list.retrieve(index);
		}

		return node;
		
	} // end peek() method
	
	
	/**
	 * 
	 * @return
	 */
	
	public int size() {
		return list.size();
		
	} // end size() method
	public void print() {
		System.out.print(" [ " ); try {
			for ( int i=0; i<list.size(); i++ ) { System.out.printf("%d ", list.getData( i ) );
			}
		} catch( OutOfBoundsException error ) {
			System.out.println( error.getMessage() );
		}
		System.out.println("]\n");
	} // end print() method
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		StackImpl list = new StackImpl();
		for (int i = 0; i<19; i++)
			list.push(new Node(null, i+100));
		System.out.println("-------------------\nBEGIN\n-------------------\n");
		list.printList();
		
		System.out.println("-------------------\nPush 1, 2, 3\n-------------------\n");
		list.push(new Node(null, 1));
		list.push(new Node(null, 2));
		list.push(new Node(null, 3));
		list.printList();
		
		System.out.println("-------------------\nPop five elements\n-------------------\n");
		for (int i = 0; i<5; i++)
			System.out.println("Pop: "+list.pop().getData());
		System.out.println();
		list.printList();
		
		System.out.println("\n-------------------\nPeek at a few Nodes\n-------------------");
		try {
			System.out.println("Peek at node 0: "+ list.peek(0).getData());
			System.out.println("Peek at node 8: "+ list.peek(8).getData());
			System.out.println("Peek at the last node: "+list.peek(list.size()-1).getData());
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n-------------------\nPeek at invalid index\n-------------------\n");
		try {
			System.out.println(list.peek(10000));
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		
	} // end main() method

}
