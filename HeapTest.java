package edu.cofc.compsci.csci230;

import java.util.Collections;
import java.util.Random;

public class HeapTest {
	
	public static boolean increasing = true;

	/**
	 * 
	 * @param slist
	 * @param tlist
	 * @return
	 */
	public static boolean compare( List slist, java.util.List<Integer> tlist ) {
		
		if ( increasing ) {
		
			Collections.sort( tlist );
			
		} else {
			
			Collections.sort( tlist, Collections.reverseOrder() );
			
		}
		
		if ( tlist.size() != slist.size() ) return false;
		
		for ( int i=0; i<slist.size(); i++ ) {
			
			try {
			
				if ( tlist.get( i ) != slist.getData( i ) ) return false;
			
			} catch( OutOfBoundsException error ) {
				
				System.out.println( error.getMessage() );
				
				return false;
				
			}
			
		}
		
		return true;
		
	} // compare() method
	
	
	/**
	 * 
	 * @param listType
	 * @param sortAlgo
	 * @param list
	 */
	public static int testSortAlgorithm( String listType, String sortAlgo, List list ) {
		
		java.util.List<Integer> tList = new java.util.ArrayList<Integer>();
		
		Random numGen = new Random();
		
		int high = 100;
		int low = -100;
		
		int pass = 0;
		int N = 100;
		
		for ( int r=0; r<N; r++ ) {
			
			tList.clear();
			list.clear();
		
			int n = numGen.nextInt( 100 );
			
			for ( int i=0; i<n; i++ ) {
				
				int r_num = ( numGen.nextInt( high-low ) + low );
				
				list.add( r_num );
				tList.add( r_num );
				
			}
			
			try {
			
				if ( sortAlgo.equalsIgnoreCase("selection") ) {
				
					Utils.selectionSort( list );
				
				} else if ( sortAlgo.equalsIgnoreCase( "bubble") ) {
					
					Utils.bubbleSort( list );
					
				} else if ( sortAlgo.equalsIgnoreCase("heap") ) {
					
					list = Utils.heapSort( list, increasing );
					
				} else {
					
					Utils.insertionSort( list );
					
				}
			
			} catch( Exception error ) {
				
				
			}
			
			if ( compare( list, tList ) ) pass++;
		
		}
		
		System.out.printf( "[%s] %d of %d %s Sort Tests Passed [%.2f]\n", listType, pass, N, sortAlgo, (((double)pass)/((double)N))*100 );
		
		return pass;
		
		
	} // end testSelectionSort() 


	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		List list = new ArrayList();
		
		int[] P = new int[4];
		
		System.out.println("----------------------------");
		increasing = true;
		P[0] = testSortAlgorithm( "ArrayList", "heap", list );
		increasing = false;
		P[1] = testSortAlgorithm( "ArrayList", "heap", list );
		
		list = new SLList();
		
		System.out.println("----------------------------");
		increasing = true;
		P[2] = testSortAlgorithm( "SinglyLinkedList", "heap", list );
		increasing = false;
		P[3] = testSortAlgorithm( "SinglyLinkedList", "heap", list );
		
		double sum = (double)(P[0]+P[1]+P[2]+P[3]);
		double max = 400.0;
		
		System.out.println("----------------------------");
		System.out.printf("Total Score = %.2f\n", (sum/max)*100.0);
		System.out.println("----------------------------");

	} // end main() method

}
