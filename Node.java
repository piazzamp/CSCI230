package edu.cofc.compsci.csci230;

/**
 * 
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring 2014
 *
 */
public class Node {
	
	private Node next = null;
	private int data = 0;
	
	/**
	 * 
	 * @param next
	 * @param data
	 */
	public Node( Node next, int data ) {
		
		this.next = next;
		this.data = data;
		
	} // end overloaded constructor
	
	/**
	 * 
	 * @param next
	 */
	public void setNextNode( Node next ) {
		
		this.next = next;
		
	} // end setNextNode() method
	
	/**
	 * 
	 * @return
	 */
	public Node getNextNode() {
		
		return next;
		
	} // end getNextNode() method
	
	/**
	 * 
	 * @param data
	 */
	public void setData( int data ) {
		
		this.data = data;
		
	} // end setData() method
	
	/**
	 * 
	 * @return
	 */
	public int getData() {
		
		return data;
		
	} // end getData() method
	
	/**
	 * 
	 */
	public void printSelf() {
		
		System.out.printf("Node value = %d\n", getData() );
		
	} // end printSelf() method

}
