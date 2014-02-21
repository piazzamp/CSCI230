package edu.cofc.compsci.csci230;

public class StackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int pcnt = 0;
		
		StackImpl test = new StackImpl();
		
		System.out.println("----------------------------------");
		
		try {
			
			for ( int i=0; i<5; i++ ) test.push( new Node( null, i ) );
			
			if ( test.size() == 5 ) { System.out.println( "[1] Pass" ); pcnt++;  }
			else { System.out.println( "[1] Fail" ); }
			
		} catch( Exception error ) { System.out.println( "[1] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			Node node = test.pop();
			
			if ( test.size() == 4 && node.getData()==4 ) { System.out.println( "[2] Pass" ); pcnt++;  }
			else { System.out.println( "[2] Fail" ); }
			
		} catch( Exception error ) { System.out.println( "[2] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			Node node1 = test.pop();
			Node node2 = test.pop();
			Node node3 = test.pop();
			Node node4 = test.pop();
			
			if ( test.size() == 0 && node1.getData()==3 && node2.getData()==2 && node3.getData()==1 && node4.getData()==0) { System.out.println( "[3] Pass" ); pcnt++;  }
			else { System.out.println( "[3] Fail" ); }
			
		} catch( Exception error ) { System.out.println( "[3] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			Node node1 = test.pop();
			test.push( new Node( null, 10 ) );
			
			if ( test.size() == 1 && node1==null && test.peek( 0 ).getData()==10) { System.out.println( "[4] Pass" ); pcnt++;  }
			else { System.out.println( "[4] Fail" ); }
			
		} catch( Exception error ) { System.out.println( "[4] Fail" ); }	
		
		System.out.println("----------------------------------");
		
		try {
			
			test.pop();
			
			for ( int i=0; i<25; i++ ) test.push( new Node( null, i ) );
			
			boolean pass = true;
			
			for ( int i=0; i<25; i++ ) {
				
				if ( test.peek( i ).getData() != i ) { 
					pass=false;
					break;
				}
				
			}
			
			if ( test.size()==25 && pass ) { System.out.println( "[5] Pass" ); pcnt++;  }
			else { System.out.println( "[5] Fail" ); }
			
		} catch( Exception error ) { System.out.println( "[5] Fail" ); }	
		
		System.out.println("----------------------------------");

		System.out.printf("(%d out of 5 correct)[%d] %.2f%%\n", pcnt,pcnt*5, (((double)pcnt)/5.0)*100.0 );

	}

}
