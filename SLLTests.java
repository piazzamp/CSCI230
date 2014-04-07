package edu.cofc.compsci.csci230;

public class SLLTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int pcnt=0;
		
		SLList test = new SLList();
		
		System.out.println("----------------------------------");
		
		try {
			
			test.add( -1, 0 );
			
			if ( test.size() == 0 ) { System.out.println( "[1] Pass" ); pcnt++; }
			else System.out.println( "[1] Fail" );
			
		} catch( Exception error ) { System.out.println( "[1] Pass" ); pcnt++; }
		
		System.out.println("----------------------------------");
		
		try {
			
			test.add( 1, 0 );
			if ( test.size() == 0 ) { System.out.println( "[2] Pass" ); pcnt++; }
			else System.out.println( "[2] Fail" );
			
		} catch( Exception error ) { System.out.println( "[2] Pass" ); pcnt++; }
	
		System.out.println("----------------------------------");
		
		try {
			
			test.remove( -1 );
			if ( test.size() == 0 ) { System.out.println( "[3] Pass" ); pcnt++; }
			else System.out.println( "[3] Fail" );
			
		} catch( Exception error ) { System.out.println( "[3] Pass" ); pcnt++; }
		
		System.out.println("----------------------------------");
		
		try {
			
			test.remove( 1 );
			if ( test.size() == 0 ) { System.out.println( "[4] Pass" ); pcnt++; }
			else System.out.println( "[4] Fail" );
			
		} catch( Exception error ) { System.out.println( "[4] Pass" ); pcnt++; }
		
		System.out.println("----------------------------------");
		
		try {
			
			for ( int i=0; i<10; i++ ) test.add( i, i );
			
			if ( test.size() == 10 && test.getData( 0 ) == 0 && test.getData( 9 ) == 9 ) { System.out.println( "[5] Pass" ); pcnt++; }
			else System.out.println( "[5] Fail" );
			
			// test.printList();
			
		} catch( Exception error ) { System.out.println( "[5] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			for ( int i=2; i<6; i++ ) test.remove( i );
			
			if ( test.size() == 6 && test.getData( 2 ) == 3 && test.getData( 5 ) == 9 ) { System.out.println( "[6] Pass" ); pcnt++; }
			else System.out.println( "[6] Fail" );
			
			// test.printList();
			
		} catch( Exception error ) { System.out.println( "[6] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			test.remove( 6 );
			if ( test.size() == 6 ) { System.out.println( "[7] Pass" ); pcnt++; }
			else System.out.println( "[7] Fail" );
			
		} catch( Exception error ) { System.out.println( "[7] Pass" ); pcnt++; }
		
		System.out.println("----------------------------------");
		
		try {
			
			test.add( 7, 11 );
			if ( test.size() == 6 ) { System.out.println( "[8] Pass" ); pcnt++; }
			else System.out.println( "[8] Fail" );
			
			//test.printList();
			
		} catch( Exception error ) { System.out.println( "[8] Pass" ); pcnt++; }
		
		System.out.println("----------------------------------");
		
		try {
			
			test.add( 6, 11 );
			if ( test.getData(6) == 11) { System.out.println( "[9] Pass" ); pcnt++; }
			else System.out.println( "[9] Fail" );
			
			test.printList();
			
		} catch( Exception error ) { System.out.println( "[9] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
		
			test.clear();
			if ( test.size() == 0 ) { System.out.println( "[10] Pass" ); pcnt++; }
			else System.out.println("[10] Fail" );
		
		} catch( Exception error ) { System.out.println("[10] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			test.add( 0, 1 );
			if ( test.size()==1 && test.getData( 0 )==1 ) { System.out.println( "[11] Pass" ); pcnt++; }
			else System.out.println( "[11] Fail" );
			
		} catch( Exception error ) { System.out.println( "[11] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			test.add( 0, 3 );
			if ( test.size()==2 && test.getData( 0 )==3 ) { System.out.println( "[12] Pass" ); pcnt++; }
			else System.out.println( "[12] Fail" );
			
		} catch( Exception error ) { System.out.println( "[12] Fail" ); }
			
		System.out.println("----------------------------------");
		
		try {
			
			test.add( 0, 5 );
			if ( test.size()==3 && test.getData( 0 )==5 ) { System.out.println( "[13] Pass" ); pcnt++; }
			else System.out.println( "[13] Fail" );
			
		} catch( Exception error ) { System.out.println( "[13] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			test.remove( 0 );
			if ( test.size()==2 && test.getData( 0 )==3 ) { System.out.println( "[14] Pass" ); pcnt++; }
			else System.out.println( "[14] Fail" );
			
		} catch( Exception error ) { System.out.println( "[14] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			test.remove( 1 );
			if ( test.size()==1 && test.getData( 0 )==3 ) { System.out.println( "[15] Pass" ); pcnt++; }
			else System.out.println( "[15] Fail" );
			
		} catch( Exception error ) { System.out.println( "[15] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			test.add( 1, 8 );
			if ( test.size()==2 && test.getData( 1 )==8 ) { System.out.println( "[16] Pass" ); pcnt++; }
			else System.out.println( "[16] Fail" );
			
			//test.printList();
			
		} catch( Exception error ) { System.out.println( "[16] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			for ( int i=1; i<4; i++ ) {
				test.add( i, i*2 );
			}
			
			if ( test.size()==5 && test.getData( 1 )==2 && test.getData( 2 )==4 && test.getData( 3 ) == 6 ) { System.out.println( "[17] Pass" ); pcnt++; }
			else System.out.println( "[17] Fail" );
			
			//test.printList();
			
		} catch( Exception error ) { System.out.println( "[17] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			for ( int i=3; i>0; i-- ) {
				test.remove( i );
			}
			
			if ( test.size()==2 && test.getData( 0 )==3 && test.getData( 1 )==8 ) { System.out.println( "[18] Pass" ); pcnt++; }
			else System.out.println( "[18] Fail" );
			
			//test.printList();
			
		} catch( Exception error ) { System.out.println( "[18] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			for ( int i=2; i<10; i++ ) {
				test.add( i, 1 );
			}
			
			int sum = 0;
			
			for ( int i=2; i<10; i++ ) {
				
				sum = sum + test.getData( i );
				
			}
			
			if ( test.size()==10 && test.getData( 0 )==3 && test.getData( 1 )==8 & sum==8) { System.out.println( "[19] Pass" ); pcnt++; }
			else System.out.println( "[19] Fail" );
			
			//test.printList();
			
		} catch( Exception error ) { System.out.println( "[19] Fail" ); }
		
		System.out.println("----------------------------------");
		
		try {
			
			test.add( 0, -1);
			
			for ( int i=7; i>4; i-- ) {
				test.remove( i );
			}
			
			int sum = 0;
			
			for ( int i=3; i<8; i++ ) {
				
				sum = sum + test.getData( i );
				
			}
			
			if ( test.size()==8 && test.getData( 0 )==-1 && test.getData( 1 )==3 & sum==5) { System.out.println( "[20] Pass" ); pcnt++; }
			else System.out.println( "[20] Fail" );
			
			// test.printList();
			
		} catch( Exception error ) { System.out.println( "[20] Fail" ); }

		System.out.printf("%.2f\n", (((double)pcnt)/20.0)*100.0 );

	}

}
