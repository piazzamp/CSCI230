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

	/** 
	 * 
	 * @param list 
	 * @throws OutOfBoundsException 
	 */ 
	public static void maxHeapify( List list ) throws OutOfBoundsException { 
		for (int i=(int)((list.size()-2)/2); i>=0; i--){ //k is the "parent" for this step
			int k = i; 
			Node v = list.retrieve(k) ;
			boolean heap = false;
			
			while (!heap && 2*k+2<=list.size()){ 
				int child = 2*k+1; 
				if (child+1<list.size()){ //child is not the last child
					if (list.getData(child)<list.getData(child+1))
						child+=1; //child is now the biggest child
				}
				//System.out.printf("largest child of %d is %d at index %d\n", list.retrieve(k).getData(), list.retrieve(child).getData(), child);
				if (v.getData()>list.getData(child)) //if the parent is in fact bigger than the kids
					heap=true;
				else {
					//System.out.printf("swap(%d, %d) (%d, %d)\n", child, k, list.getData(child), list.getData(k));
					list.swap(k, child);
					k=child;
				}
			}
			//list.retrieve(k).setData(v.getData());
		}
		
	} 
	/** 
	 * 
	 * @param list 
	 * @throws OutOfBoundsException 
	 */ 
	public static void minHeapify( List list ) throws OutOfBoundsException { 
		for (int i=(int)((list.size()-2)/2); i>=0; i--){ //k is the "parent" for this step
			int k = i; 
			Node v = list.retrieve(k) ;
			boolean heap = false;
			
			while (!heap && 2*k+2<=list.size()){ 
				int child = 2*k+1; 
				if (child+1<list.size()){ //child is not the last child
					if (list.getData(child)>list.getData(child+1))
						child+=1; //child is now the biggest child
				}
				//System.out.printf("largest child of %d is %d at index %d\n", list.retrieve(k).getData(), list.retrieve(child).getData(), child);
				if (v.getData()<list.getData(child)) //if the parent is in fact SMALLER than the kids
					heap=true;
				else {
					//System.out.printf("swap(%d, %d) (%d, %d)\n", child, k, list.getData(child), list.getData(k));
					list.swap(k, child);
					k=child;
				}
			}
		}
	} 
	/** 
	 * 
	 * @param list 
	 * @param increasing 
	 * @return 
	 * @throws OutOfBoundsException 
	 */ 
	public static List heapSort( List list, boolean increasing ) throws 
	OutOfBoundsException { 
		List result = (list instanceof ArrayList? new ArrayList() : new SLList() ); //return whatever you were given
		List orig = (list instanceof ArrayList? new ArrayList() : new SLList() ); //so you don't kill the original list
		int length = list.size();
		for (int i=0; i<length; i++)
			orig.add(i, list.retrieve(i).getData());
		if (increasing){
			minHeapify(orig);
			for (int i =0; i<length; i++){
				result.add(i, orig.retrieve(0).getData()); //the smallest value is at the root, index 0
				orig.remove(0);
				minHeapify(orig);
			}
		}
		else {
			maxHeapify(orig);
			for (int i =0; i<length; i++){
				result.add(i, orig.retrieve(0).getData()); //the largest value is at the root, index 0
				orig.remove(0);
				maxHeapify(orig);
			}
		}
		return result;
	}
}
