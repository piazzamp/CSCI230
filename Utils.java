package edu.cofc.compsci.csci230;

/**
 * 
 * Computer Science Department
 * College of Charleston
 * CSCI 230 
 * Spring 2014
 *
 */
public class Utils {
	
	/**
	 * 
	 */
	private Utils() {
		
	} // end private constructor
	
	/**
	 * 
	 * @param list
	 */
	public static void selectionSort( List list ) {
		for (int i=0; i<=list.size()-2; i++){
			int min = i;
			try {
				for (int j=i+1;j<=list.size()-1; j++)
					if (list.getData(j)<list.getData(min))
						min=j;	
				list.swap(i, min);
			} catch (OutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
	} // end selectionSort() method
	
	/**
	 * 
	 * @param list
	 */
	public static void bubbleSort( List list ) {
		try{
			for (int i=0; i<=list.size()-2; i++){
				for (int j=0;j<=list.size()-2-i; j++){
					if (list.getData(j+1)<list.getData(j))
						list.swap(j+1, j);
				}
			}
		}catch(OutOfBoundsException e){
			System.out.println(e.getMessage());
		}
	} // end bubbleSort() method
	
	/**
	 * 
	 * @param list
	 */
	public static void insertionSort( List list ) {
		try{
		for (int i=1; i<=list.size()-1; i++){
			int v = list.getData(i);
			int j=i-1;
			while (j>=0 && list.getData(j)>v){
				list.retrieve(j+1).setData(list.getData(j));
				j--;
			}
			list.retrieve(j+1).setData(v);
		}
		}catch(OutOfBoundsException e){
			System.out.println(e.getMessage());
		}
	} // end insertionSort() method

}
