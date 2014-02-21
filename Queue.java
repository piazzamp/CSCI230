package edu.cofc.compsci.csci230;

/**
 * 
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring 2014
 *
 */
public interface Queue {
	
	/*
	 * 
	 * These methods need to be implemented in the QueueImpl Class
	 * 
	 */ 
	
	public void enqueue( Node node );
	
	public Node dequeue();
	
	public Node peek( int index ) throws OutOfBoundsException;

}
