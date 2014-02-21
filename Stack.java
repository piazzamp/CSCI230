package edu.cofc.compsci.csci230;

/**
 * 
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring 2014
 *
 */
public interface Stack {
	
	/*
	 * 
	 * These methods need to be implemented in the StackImpl Class
	 * 
	 */ 
	
	public void push( Node node );
	
	public Node pop();
	
	public Node peek( int index ) throws OutOfBoundsException;

}
