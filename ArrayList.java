package edu.cofc.compsci.csci230;

/**
 * 
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring 2014
 *
 */
public class ArrayList implements List {
	
	private Node[] nodeArray = new Node[10];
	private int emptyIndex = 0;
	
	public ArrayList(){};
	
	public ArrayList(int startingSize){
		this.nodeArray = new Node[startingSize];
	}

	/**
	 * 
	 * Add new Node object to first index position 
	 * that does not have a node object
	 * 
	 */
	public void add(int data) {
		
		if (emptyIndex >= nodeArray.length) {
			
			Node[] temp = new Node[nodeArray.length*2];
			
			System.arraycopy( nodeArray, 0, temp, 0, nodeArray.length );
			
			nodeArray = temp;
			
		} 
		
		nodeArray[emptyIndex++] = new Node(null,data);
		
	} // end add() method

	/**
	 * 
	 * Get the integer value stored in the node 
	 * object at the specified index position
	 * 
	 */
	public int getData(int index) throws OutOfBoundsException {
		
		return retrieve( index ).getData();
		
	} // end getData() method
	

	/**
	 * 
	 */
	public void printList() {
		
		try {
			
			if ( size() == 0 ) {
				
				System.out.println("Array List is empty!" );
				
			} else {

				for (int i=0; i<size(); i++ ) {
					
					System.out.printf("Node(%d)=%d\n", i+1, getData( i ) );
					
				} 
			
			}
			
		} catch( OutOfBoundsException error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
	} // end printList() method

	/**
	 * 
	 * Remove the last node object in the array and
	 * resize array if less than 50% of capacity is
	 * being used
	 * 
	 */
	public void remove() {
		
		nodeArray[--emptyIndex]=null;
		
		emptyIndex = ( emptyIndex < 0 ) ? 0 : emptyIndex;
		
		if ( emptyIndex < ((int)(nodeArray.length*0.5)) ) {
			
			Node[] temp = new Node[((int)(nodeArray.length*0.5))];
			
			System.arraycopy( nodeArray, 0, temp, 0, ((int)(nodeArray.length*0.5)) );
			
			nodeArray = temp;
			
		}
		
	} // end remove() method
	
	
	/**
	 * 
	 */
	public Node retrieve(int index) throws OutOfBoundsException {

		if ( index >= 0 && index < size() ) {
			
			return nodeArray[index];
			
		} else {
			
			String message = String.format( "index position %d is not valid!\n", index );
			throw new OutOfBoundsException( message );
			
		}
		
	} // end retrieve() method

	/**
	 * 
	 * Return the number of node objects stored 
	 * in the array list
	 * 
	 */
	public int size() {
	
		return emptyIndex;
		
	} // end size() method
	
	public void add(int index, int data) throws OutOfBoundsException {
		if (index>emptyIndex){
			String message = String.format( "index position %d is past the end of your array!\n", index );
			throw new OutOfBoundsException(message);
		}
		else {
			if (emptyIndex >= nodeArray.length) { //double it if it's about to run out of space don't add node yet
				Node[] temp = new Node[nodeArray.length*2];
				System.arraycopy( nodeArray, 0, temp, 0, nodeArray.length );
				nodeArray = temp;
			}
			if (emptyIndex == index) {
				this.add(data);
			}
			else if (index<=emptyIndex){ //split the array in half at the index and stick the new data in and reassemble
				Node[] temp = new Node[nodeArray.length];
				System.arraycopy(nodeArray, 0, temp, 0, index); //copy the first chunk
				temp[index]=new Node(null,data);				//add the element
				//copy the second chunk
				System.arraycopy(nodeArray, index, temp, index+1, temp.length-index-1);
				nodeArray=temp;
				emptyIndex++;
			}
		}
	} // end add() method
	
	public void clear() {
		nodeArray = new Node[10];
		emptyIndex=0;
	} // end clear() method

	
	public void remove(int index) throws OutOfBoundsException {
		if (index >= emptyIndex || index< 0) 
			throw new OutOfBoundsException(String.format( "index position %d is not valid!\n", index ));
		else if (emptyIndex==0)
			throw new OutOfBoundsException("You can't remove any elements if you don't have any to begin with!");
		else if (index == emptyIndex-1){
			this.remove();
		}
		else {
			System.arraycopy(nodeArray, index+1, nodeArray, index, this.size()-index-1);
			emptyIndex--;
		}
		//resize
		if ( emptyIndex < ((int)(nodeArray.length*0.5)) ) {
			Node[] temp = new Node[((int)(nodeArray.length*0.5))];
			System.arraycopy( nodeArray, 0, temp, 0, ((int)(nodeArray.length*0.5)) );
			nodeArray = temp;
		}


	} // end remove() method

	
	@Override
	public void swap(int i, int j) throws OutOfBoundsException {
		if (i==j);//you don't have to do anything if the indices are ==
		else if (i<0 || j<0 || i>=emptyIndex || j>=emptyIndex)
			throw new OutOfBoundsException("indices "+i+" & "+j+" are not in the set of available indices for this list.");
		else {
			int temp = this.retrieve(i).getData();  				//store i's data
			this.retrieve(i).setData(this.retrieve(j).getData());	//set i to j
			this.retrieve(j).setData(temp);							//set j to i
		}
		
	}
	
	/** 
	* 
	* Add new Node object to first index position 
	* that does not have a node object 
	* 
	*/ 
	public void add( Node node ) { 
		if (emptyIndex >= nodeArray.length) { 
			Node[] temp = new Node[nodeArray.length*2]; 
			System.arraycopy( nodeArray, 0, temp, 0, nodeArray.length ); 
			nodeArray = temp; 
		} 
		nodeArray[emptyIndex++] = node; 
	} // end add() method 
	
	@Override
	public void add(int index, Node node) throws OutOfBoundsException {
		if (index>emptyIndex){
			String message = String.format( "index position %d is past the end of your array!\n", index );
			throw new OutOfBoundsException(message);
		}
		else {
			if (emptyIndex >= nodeArray.length) { //double it if it's about to run out of space don't add node yet
				Node[] temp = new Node[nodeArray.length*2];
				System.arraycopy( nodeArray, 0, temp, 0, nodeArray.length );
				nodeArray = temp;
			}
			
			if (emptyIndex == index) {
				this.add(node);
			}
			else if (index<=emptyIndex){ //split the array in half at the index and stick the new data in and reassemble
				Node[] temp = new Node[nodeArray.length];
				System.arraycopy(nodeArray, 0, temp, 0, index); //copy the first chunk
				temp[index]=node;				//add the element
				//copy the second chunk
				System.arraycopy(nodeArray, index, temp, index+1, temp.length-index-1);
				nodeArray=temp;
				emptyIndex++;
			}
		}
		
	}

	/**
	 * 
	 * Testing array list functionality
	 * 
	 */
	public static void main(String[] args) {
		
		List list = new ArrayList();
		
		System.out.println("\n-------------------------------\nList:");
		for ( int i=0; i<30; i++ ) {
			list.add( i*2 );
		}
		list.printList();
		
		System.out.println("\n-------------------------------\nRemove 15 elements\n-------------------------------\n");
		for ( int i=0; i<15; i++ ) {
			
			list.remove();
			
		}
		
		list.printList();
		
		System.out.println("\n-------------------------------\nAdd ten more elements back\n-------------------------------\n");
		for ( int i=0; i<10; i++ ) {
			
			list.add( i*2 );
			
		}
		
		
		list.printList();
		
		System.out.println("\n------------------------------- \nAdd 77 @ 0");
		try {
			list.add(0,77);
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		list.printList();
		
		System.out.println("\n------------------------------- \nAdd 10 @ 2, 13 @ 5, 111 at the end");
		try {
			list.add(2,10);
			list.add(5,13);
			list.add(list.size(),111);//good
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		list.printList();
		
		//remover
		System.out.println("\n------------------------------- \nRemove the element at index 7");
		try {
			list.remove(7); //good
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		list.printList();
		
		System.out.println("\n------------------------------- \nRemove the last and first element");
		try {
			list.remove(0);
			list.remove(list.size());
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		list.printList();
		
		System.out.println("\n------------------------------- \nAdd 100 99's all at index 10");
		try {
			for (int i = 0; i<100; i++)
				list.add(10,99);
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		list.printList();
		
		System.out.println("\n------------------------------- \nRemove 99 99's at index 10");
		try {
			for (int i = 0; i<99; i++)
				list.remove(10);
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		list.printList();
		
		System.out.println("\n-------------CLEAR-------------");
		list.clear();
		list.printList();
		
		System.out.println("\n-----------------------\nRemove one from none\n-----------------------\n");
		try {
			list.remove(0);
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		list.printList();
	} // end main() method

}
