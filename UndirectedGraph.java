package edu.cofc.compsci.csci230;

/**
 * 
 * Computer Science Department
 * College of Charleston
 * CSCI 230 Spring 2014
 *
 */
public class UndirectedGraph implements Graph {

	private int count = 0;

	// --------------------------------------------
	// Implement UndirectGraph as an Adjacency List 
	// See course textbook for more details
	//
	// The ArrayList represents the adjacency list

	protected ArrayList list = new ArrayList(); //list of nodes in the graph
	
	// --------------------------------------------
	// Stack and Queue are used to implement
	// the dfs and bfs algorithms
	
	private Stack stack = null;
	private Queue queue = null;
	

	/**
	 * 
	 * @param node1_data
	 * @param node2_data
	 * @throws NodeException
	 * @throws OutOfBoundsException
	 */
	public void addEdge(int node1_data, int node2_data) throws NodeException, OutOfBoundsException {
		
		if ( node1_data < 0 || node2_data < 0) throw new NodeException( String.format( "Node data values must be zero or positive integer!" ) );
		if (node1_data==node2_data) throw new NodeException("Duplicates are not allowed, edges are not allowed between identical nodes.");
		Node one;
		Node two;
		
		if (hasNode(node1_data))
			one = getNode(node1_data);
		else {
			one = new Node(null, node1_data);
			list.add(one);
		}
		
		if (hasNode(node2_data))
			two = getNode(node2_data);
		else {
			two = new Node(null, node2_data);
			list.add(two);
		}
		
		//do not recreate the edge if it already exists
		if (!one.hasAdjacentNode(two.getData()) && !two.hasAdjacentNode(one.getData())){
			one.addAdjacentNode(two); 
			two.addAdjacentNode(one);
		}
		
		//---------------------
		// Hint: 
		//	- Use Node class addAdjacentNode method
		//  - Use getNode method to retrieve node object with data value
		//  - Use hasNode method to check if node values are in adjacency list
		//

		
		
		
	} // end addEdge() method

	/**
	 * 
	 * @param node1_data
	 * @param node2_data
	 * @throws NodeException
	 * @throws OutOfBoundsException
	 */
	public void removeEdge(int node1_data, int node2_data) throws NodeException, OutOfBoundsException {
		//throw exception if these nodes don't exist or if the edge doesn't exist
		if (!hasNode(node1_data) || !hasNode(node2_data)) 
			throw new NodeException(String.format("You are attempting to remove an edge from a node that is not in the graph: %d & %d", node1_data, node2_data));
		Node one = getNode(node1_data);
		Node two = getNode(node2_data);
		if (!one.hasAdjacentNode(node2_data) || !two.hasAdjacentNode(node1_data)) 
			throw new NodeException(String.format("No edge is present between nodes %d and %d", node1_data, node2_data));
		one.removeAdjacentNode(node2_data);
		two.removeAdjacentNode(node1_data);
		
		//remove nodes if they are no longer in the graph
		if (one.numberOfAdjacentNodes()==0)
			removeNode(one.getData());
		if (two.numberOfAdjacentNodes()==0)
			removeNode(two.getData());
		
	} // end removeEdge() method
	
	/**
	 * 
	 * @param data
	 * @throws NodeException
	 * @throws OutOfBoundsException
	 */
	public void removeNode(int data) throws NodeException, OutOfBoundsException {
		
		for ( int i=0; i<list.size(); i++ ) {
			if ( list.getData( i ) == data ) { 
				list.remove( i );
				return;
			}
		}
		throw new NodeException( String.format("Node %d does not exist!\n", data ) );
	} // end removeNode() method

	/**
	 * 
	 * @param data
	 * @throws NodeException
	 * @throws OutOfBoundsException
	 */
	public Node getNode(int data) throws NodeException, OutOfBoundsException {

		for ( int i=0; i<list.size(); i++ ) {
			if ( list.getData( i ) == data ) return list.retrieve( i );
		}

		throw new NodeException( String.format("Node %d does not exist!\n", data ) );

	} // end getNode() method

	/**
	 * 
	 * @param data
	 */
	public boolean hasNode( int data ) {

		boolean found = true;

		for ( int i=0; i<list.size(); i++ ) {
			try {
				if ( list.getData( i ) == data ) return found;
			} catch( OutOfBoundsException error ) {
				System.out.println( error.getMessage() );
			}
		}
		return !found;

	} // end hasNode() method

	/**
	 * 
	 */
	public void clear() {
		list = new ArrayList();
	} // end clear() method

	
	/**
	 * 
	 * @throws NodeException
	 * @throws OutOfBoundsException
	 */
	public void depthFirstSearch() throws NodeException, OutOfBoundsException {
		
		// ------------------------------------------------
		// I've reset all the visited variables in each node.
		// Do not modify.
		for ( int i=0; i<list.size(); i++ ) { 
			list.retrieve( i ).setVisited( Node.NOT_VISITED );
		}
			
		stack = new StackImpl();
		count = 0;
		for (int i=0; i<list.size(); i++)
			if (!list.retrieve(i).hasBeenVisited()){
				dfs(list.retrieve(i));
			}
		
		
	} // end depthFirstSearch() method
	
	/**
	 * 
	 * @param node
	 * @throws NodeException
	 * @throws OutOfBoundsException
	 */
	public void dfs( Node node ) throws NodeException, OutOfBoundsException {
		//stack.print();
		count++;
		node.setVisited(count);
		stack.push(node);
		//System.out.println("node "+node.getData()+" puhed onto stack");
		stack.print();
		
		for (int i=0; i<node.numberOfAdjacentNodes(); i++){
			if (!node.getAdjacentNode(i).hasBeenVisited()){
				dfs(node.getAdjacentNode(i));
			}
		}
		stack.pop();
		stack.print();
				
	} // end dfs() method


	/**
	 *
	 * @throws NodeException
	 * @throws OutOfBoundsException
	 */
	public void breadthFirstSearch() throws NodeException, OutOfBoundsException {
		
		// ------------------------------------------------
		// I've reset all the visited variables n each node.
		// Do not modify.
		for ( int i=0; i<list.size(); i++ ) { 
			list.retrieve( i ).setVisited( Node.NOT_VISITED );
		}
		
		queue = new QueueImpl();
		count = 0;
		
		// ------------------------------------------
		// Implement using recursive algorithm on 
		// page 126 in course textbook
		for (int i=0; i<list.size(); i++)
			if (!list.retrieve(i).hasBeenVisited())
				bfs(list.retrieve(i));
		// ------------------------------------------------
		// I've provided the code to print the order
		// the nodes were visited.
		// Do not modify
		
		for ( int i=0; i<list.size(); i++ ) { 
			System.out.printf("Node %d\tVisited %d\n", list.getData( i ), list.retrieve( i ).getVisited() );
		}
		
	} // end breadthFirstSearch() method
	
	/**
	 * 
	 * @param node
	 * @throws NodeException
	 * @throws OutOfBoundsException
	 */
	public void bfs( Node node ) throws NodeException, OutOfBoundsException {
		node.setVisited(count);
		count++;
		while (!queue.isEmpty()){
			for (int y=0; y<node.numberOfAdjacentNodes(); y++){
				Node adj = node.getAdjacentNode(y);
				if (!adj.hasBeenVisited()){
					count++;
					queue.enqueue(adj);
				}
			}
			queue.dequeue();
		}
		// ------------------------------------------
		// Implement using recursive algorithm on 
		// page 126 in course textbook
		
	} // end bfs() method
	
	/**
	 * 
	 */
	public void printSelf() {
		
		if ( list.size() == 0 ) System.out.println( "Empty Graph!" );

		try {

			for ( int i=0; i<list.size(); i++ ) {

				System.out.println("---------------------------------------------");

				Node node = list.retrieve( i );

				int adj_nodes = node.numberOfAdjacentNodes();

				System.out.printf("Node = %d\tAdjacent To [ ", node.getData() );

				for ( int j=0; j<adj_nodes; j++ ) {

					Node adj_node = list.retrieve( i ).getAdjacentNode( j );

					if ( j < adj_nodes-1 )

						System.out.printf("%d, ", adj_node.getData() );

					else

						System.out.printf("%d ", adj_node.getData() );
				}

				System.out.println("]");
				
			}
		} catch( Exception error ) {
			System.out.println( error.getMessage() );
		}
	} // end printSelf() method
} // end UndirectedGraph class definition
