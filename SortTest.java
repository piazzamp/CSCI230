package edu.cofc.compsci.csci230;

public class SortTest {

	public static void main(String[] args) throws OutOfBoundsException {
		//sort queue, sll, & arralylist using each method
		SLList s = new SLList();
		ArrayList a = new ArrayList();
		final int SIZE=20;
//SELECTIONSORT
		
		for (int i=0; i<SIZE; i++){
			s.add( (int)(Math.random()*1000)+1 );
			a.add( (int)(Math.random()*1000)+1 );
		}
		System.out.println("--------------\nHeap Sort\n--------------");
		s=(SLList) Utils.heapSort(s, false);
		a=(ArrayList) Utils.heapSort(a, false);
		boolean spass=true;
		boolean apass=true;
		for (int i=0; i<SIZE-1; i++){
			try {
				if (s.getData(i)<s.getData(i+1))
					spass=false;
				if (a.getData(i)<a.getData(i+1))
					apass=false;
			} catch (OutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println((apass)?"ArrayList successfully sorted by Heap Sort":"ArrayList failed sort on Selection Sort");
		System.out.println((spass)?"SLList successfully sorted by Heap Sort":"SLList failed sort on Selection Sort");
		
		
		a.clear(); s.clear();
		
//BUBBLESORT
		/*
		for (int i=0; i<SIZE; i++){
			s.add((int)(Math.random()*1000)+1);
			a.add((int)(Math.random()*1000)+1);
		}
		System.out.println("--------------\nBubble Sort\n--------------");
		Utils.bubbleSort(s);
		Utils.bubbleSort(a);
		spass=true;
		apass=true;
		for (int i=0; i<SIZE-1; i++){
			try {
				if (s.getData(i)>s.getData(i+1))
					spass=false;
				if (a.getData(i)>a.getData(i+1))
					apass=false;
			} catch (OutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println((apass)?"ArrayList successfully sorted by Bubble Sort":"ArrayList failed sort on Bubble Sort");
		System.out.println((spass)?"SLList successfully sorted by Bubble Sort":"SLList failed sort on Bubble Sort");
		
		
		a.clear(); s.clear();

		
//INSERTIONSORT
		for (int i=0; i<SIZE; i++){
			s.add((int)(Math.random()*1000)+1);
			a.add((int)(Math.random()*1000)+1);
		}
		System.out.println("--------------\nInsertion Sort\n--------------");
		Utils.insertionSort(s);
		Utils.insertionSort(a);
		spass=true;
		apass=true;
		for (int i=0; i<SIZE-1; i++){
			try {
				if (s.getData(i)>s.getData(i+1))
					spass=false;
				if (a.getData(i)>a.getData(i+1))
					apass=false;
			} catch (OutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println((apass)?"ArrayList successfully sorted by Insertion Sort":"ArrayList failed sort on Insertion Sort");
		System.out.println((spass)?"SLList successfully sorted by Insertion Sort":"SLList failed sort on Insertion Sort");
	
		a.clear(); s.clear();


*/
	}

}
