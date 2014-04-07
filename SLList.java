package edu.cofc.compsci.csci230;

/**
 * 
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring
 *         2014
 * 
 */
public class SLList implements List {

	private Node head = null;
	private int size = 0;

	/**
	 * 
	 * @param data
	 * 
	 *            Append new data to end of singly linked list
	 * 
	 */
	public void add(int data) {

		if (head == null) {

			head = new Node(null, data);

		} else {

			try {

				Node next = new Node(null, data);

				Node prev = retrieve(size - 1);

				prev.setNextNode(next);

			} catch (OutOfBoundsException error) {

				System.out.println(error.getMessage());

			}

		}

		size++;

	} // end add() method

	/**
	 * 
	 * @param index
	 * @return
	 * @throws OutOfBoundsException
	 * 
	 *             Retrieve the node at position 'index' in the singly linked
	 *             list
	 * 
	 */
	public Node retrieve(int index) throws OutOfBoundsException {

		if (index < size) {

			Node node = head;

			if (index == 0)
				return node;

			for (int i = 0; i < index; i++) {

				node = node.getNextNode();

			}

			return node;

		} else {

			String message = String.format("index (%d) >= size (%d) of list\n",
					index, size);

			throw new OutOfBoundsException(message);

		}

	} // end retrieve() method

	/**
	 * 
	 * @param index
	 * @return
	 * @throws OutOfBoundsException
	 * 
	 *             Get the data at a specific 'index' position in the singly
	 *             linked list
	 * 
	 */
	public int getData(int index) throws OutOfBoundsException {

		return retrieve(index).getData();

	} // end getData() method

	/**
	 * 
	 * Remove the last node from the singly linked list
	 * 
	 */
	public void remove() {

		if (size() > 1) {

			Node node = head;

			for (int i = 0; i < size() - 1; i++) {

				node = node.getNextNode();

			}

			if (node != null) {

				node.setNextNode(null);
				size--;

			}

		} else if (size() == 1) {

			head = null;
			size--;

		}

	} // end remove() method

	/**
	 * 
	 * @return
	 * 
	 *         Get the size (i.e. number of nodes) in the singly linked list
	 * 
	 */
	public int size() {

		return size;

	} // end size() method

	/**
	 * 
	 */
	public void printList() {

		for (int i = 0; i < size(); i++) {

			try {

				System.out.printf("Node (%d) = %d\n", i, getData(i));

			} catch (OutOfBoundsException error) {

				System.out.println(error.getMessage());

			}

		}

	} // end printList() method

	/**
	 * 
	 * Given a specific 'index' position in the singly linked list remove the
	 * Node. Make sure the next pointer at Node[index-1] is now pointing at
	 * Node[index+1]
	 * 
	 */
	public void remove(int index) throws OutOfBoundsException {

		try {
			if (index == 0) {
				head = retrieve(1);
				size--;
			} else if (index == size - 1) {
				retrieve(index - 1).setNextNode(null);
				size--;
			} else {
				Node current = retrieve(index);
				Node left = retrieve(index - 1);
				Node right = retrieve(index + 1);
				left.setNextNode(right);
				current.setNextNode(null);
				size--;
			}
		} catch (OutOfBoundsException error) {
			System.out.println(error.getMessage());
		}
		

	} // end remove() method

	/**
	 * 
	 * Given a specific 'index' position in the singly linked list add a new
	 * Node object with the specified data integer value. Make sure the next
	 * pointer in Node[index-1] now points Node[index], and the next pointer in
	 * Node[index] now points at Node[index+1]
	 * 
	 */
	public void add(int index, int data) throws OutOfBoundsException {

		if (index == 0) {
			Node right = head;
			head = new Node(right, data);
		} else if (index == size) {
			Node left = retrieve(size - 1);
			left.setNextNode(new Node(null, data));

		} else {
			Node left = retrieve(index - 1);
			Node right = retrieve(index);
			Node noo = new Node(right, data);
			left.setNextNode(noo);
		}
		size++;
	} // end add() method

	public void swap(int i, int j) throws OutOfBoundsException {
		//swap element at index i with element at index j
		if (i==j);//you don't have to do anything if the indices are ==
		else if (i<0 || j<0 || i>=size || j>=size)
			throw new OutOfBoundsException("indices "+i+" & "+j+" are not in the set of available indices for this list.");
		
		else{
			Node eye = retrieve(i);
			Node jay = retrieve(j);
			int temp = eye.getData();
			eye.setData(jay.getData()); //now i has j's data
			jay.setData(temp); 			//and jay has i's which was stored in temp at line 230
		}
		
		
	}

	/**
	 * 
	 * Remove all Node objects in the singly linked list.
	 * 
	 */
	public void clear() {
		head = null;
		size = 0;

	} // end clear() method

	public void add( Node node ) { 		 
		 // will implement in future code 
		} // end add() method 
		/** 
		* 
		*/ 
		public void add(int index, Node node ) throws OutOfBoundsException { 
		 // will implement in future code 
		} // end add() method 

	/**
	 * 
	 * @param args
	 * 
	 *            Main method that demonstrates simple operations on the singly
	 *            linked list
	 * 
	 */
	public static void main(String[] args) {

		List list = new SLList();

		System.out.println("----------------------------------------");
		System.out.println("Append new data to end of singly linked list");
		System.out.println("----------------------------------------");
		System.out.println();

		list.add(15);
		list.add(5);
		list.add(100);
		list.add(23);
		list.add(47);

		list.printList();

		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("Remove last two nodes in singly linked list");
		System.out.println("----------------------------------------");
		System.out.println();

		list.remove();
		list.remove();

		list.printList();

		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("Append a new node in singly linked list");
		System.out.println("----------------------------------------");
		System.out.println();

		list.add(-34);

		list.printList();

		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("Remove node 0");
		System.out.println("----------------------------------------");
		System.out.println();

		try {
			list.remove(0);
		} catch (OutOfBoundsException e) {
			e.printStackTrace();
		}

		list.printList();

		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("Remove node 2");
		System.out.println("----------------------------------------");
		System.out.println();

		try {
			list.remove(2);
		} catch (OutOfBoundsException e) {
			e.printStackTrace();
		}

		list.printList();

		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("Add 333 at index 0");
		System.out.println("----------------------------------------");
		System.out.println();

		try {
			list.add(0, 333);
		} catch (OutOfBoundsException e) {
			e.printStackTrace();
		}
		list.printList();

		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("Add 90 at index 2");
		System.out.println("----------------------------------------");
		System.out.println();

		try {
			list.add(2, 90);
		} catch (OutOfBoundsException e) {
			e.printStackTrace();
		}
		list.printList();
		
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("Add -8 at index 4");
		System.out.println("----------------------------------------");
		System.out.println();

		try {
			list.add(4, -8);
		} catch (OutOfBoundsException e) {
			e.printStackTrace();
		}
		list.printList();
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("swap indices 0 & 4");
		System.out.println("----------------------------------------");
		System.out.println();

		try {
			list.swap(0, 4);
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		list.printList();

		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("swap indices 1 & 2");
		System.out.println("----------------------------------------");
		System.out.println();

		try {
			list.swap(1, 2);
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		list.printList();
		
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("swap indices 3 & 3");
		System.out.println("----------------------------------------");
		System.out.println();

		try {
			list.swap(3, 3);
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		list.printList();
		
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("swap indices 1 & 5");
		System.out.println("----------------------------------------");
		System.out.println();

		try {
			list.swap(1, 5);
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		list.printList();



		
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("CLEAR LIST / ABANDON SHIP");
		System.out.println("----------------------------------------");
		System.out.println();

		list.clear();
		list.printList();
		System.out.println("list.printList(); has run");

	} // end main() method

}
