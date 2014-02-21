package edu.cofc.compsci.csci230;

/**
 * 
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring 2014
 *
 */
public interface List {
	
	/*
	 * 
	 * These methods are already implemented in the SSList Class
	 * 
	 */
	
	public void add( int data );
	
	public Node retrieve( int index ) throws OutOfBoundsException;
	
	public int getData( int index ) throws OutOfBoundsException;
	
	public void remove();
	
	public int size();
	
	public void printList();
	
	/*
	 * 
	 * These methods need to be implemented in the SSList Class
	 * 
	 */ 
	
	public void remove( int index ) throws OutOfBoundsException;
	
	public void add( int index, int data ) throws OutOfBoundsException;
	
	public void clear();

}
