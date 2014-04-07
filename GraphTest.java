package edu.cofc.compsci.csci230;

public class GraphTest {

	public static void main(String[] args) {
		
		// -------------------------------------------------------------
		// For your reference I've provided a TestGraph.java class. 
		// You may use this test class to validate if your unordered 
		// graph implementation is working. 
		//
		// However, this will not be the test case(s) used to evaluate 
		// this assignment. This is just a starting point.
		
		try {
		
			Graph graph = new UndirectedGraph();
		
			graph.addEdge( 55, 23 );
			graph.addEdge( 55, 22 );
			graph.addEdge( 55, 19 );
			
			graph.addEdge( 23, 20 );
			graph.addEdge( 23, 19 );
			
			graph.addEdge( 20, 55 );
			graph.addEdge( 22, 19 );
			
			graph.addEdge( 5, 22 );
			graph.addEdge( 5,  4 );
			
			graph.addEdge( 22, 0);
			
			graph.printSelf();
			
			System.out.print("\n\n");
					
			graph.depthFirstSearch();
			graph.breadthFirstSearch();
			
			graph.removeEdge( 19,  22 );
			graph.removeEdge( 20,  55 );
			
			System.out.print("\n\n");
			
			graph.printSelf();
			
			System.out.print("\n\n");
			
			graph.depthFirstSearch();
			graph.breadthFirstSearch();
			
			graph.clear();
			
			System.out.print("\n\n");
			
			graph.printSelf();
			System.out.println("Error Tests\n-----------------------\n");
			//graph.addEdge(55, 55);
			//graph.addEdge(0, 22);
			//graph.removeEdge(5, 0);
			//graph.removeEdge(22, 0);
			//graph.printSelf();
		
		} catch ( Exception error ) {
			
			error.printStackTrace();
			System.out.println( error.getMessage() );
			
		}

	}

}
