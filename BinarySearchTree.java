package edu.cofc.compsci.csci230;

/**
 * 
 * Computer Science Department
 * College of Charleston
 * CSCI 230 Spring 2014
 *
 */
public class BinarySearchTree extends UndirectedGraph {

	private Node bst_root = null;

	/**
	 * 
	 */
	public BinarySearchTree() {

	} // end constructor


	/**
	 * 
	 * @return
	 */
	public Node getBSTRoot() {

		return bst_root;

	} // end getBSTRoot() method


	/**
	 * 
	 * @param r
	 * @param k
	 * @throws OutOfBoundsException NodeException
	 */
	public void insert( Node r, int k ) throws NodeException, OutOfBoundsException {

		if ( k < 0 ) throw new NodeException( String.format("k=%d Negative Values Not Allowed!", k ) );
		if (this.hasNode(k)) throw new NodeException(String.format("Node %d is already in the tree!", k));
		//if the tree is not empty and r is not in the tree:
		//if (bst_root!=null && !this.hasNode(r.getData())) throw new NodeException(String.format("Root node %d is not in the tree!", r.getData()));

		if (bst_root==null || this.list.size()==0) {
			bst_root = new Node (null, k);
			this.list.add(bst_root);
		}

		else if (k<r.getData()){
			if (!r.hasLeftChild()){	
				Node kid = new Node(null, k);
				kid.setParent(r);
				r.setLeftChild(kid);

				if (!this.hasNode(r.getData()))
					this.list.add(r);
				if (!this.hasNode(k))
					this.list.add(kid);

				}
			else
				insert(r.getLeftChild(), k);
		}

		else if (k>=r.getData()){
			if (!r.hasRightChild()){
				Node kid = new Node(null, k);
				kid.setParent(r);
				r.setRightChild(kid);
				if (!this.hasNode(r.getData()))
					this.list.add(r);
				if (!this.hasNode(k))
					this.list.add(kid);
				
			}
			else 
				insert(r.getRightChild(), k);
		}
		// -------------------------------------
		// TODO: HW7
		// -------------------------------------
		// Fully implement the insert algorithm
		// Don't forget to check for error conditions (throw NodeException)

	} // end insert() method


	/**
	 * 
	 * @param r
	 * @param k
	 */
	public Node search( Node r, int k ) throws NodeException {
		if ( k < 0 ) throw new NodeException( String.format("k=%d Negative Values Not Allowed!", k ) );
		if (!this.hasNode(k)) throw new NodeException(String.format("Node %d is not in the tree!",k));

		if (k==r.getData())
			return r;
		else if (k<r.getData())
			return search(r.getLeftChild(), k);
		else if (k>r.getData())
			return search(r.getRightChild(), k);
		else return null;


		// -------------------------------------
		// TODO: HW7
		// -------------------------------------
		//	Fully implement the search algorithm
		// 	Don't forget to check for error conditions (throw NodeException)


	} // end search() method

	/**
	 * 
	 * @param r
	 * @param k
	 */
	public void delete( Node r, int k ) throws NodeException, OutOfBoundsException {
		if ( k < 0 ) throw new NodeException( String.format("k=%d Negative Values Not Allowed!", k ) );
		if (this.list.size()==0) throw new NodeException("No nodes to delete!");
		Node node = search(r, k);

		if (node.equals(bst_root)){ //root node has no parents, so 1 adjacent node = kids
			if (node.hasRightChild() && node.hasLeftChild()) throw new NodeException(String.format("Node %d has more than one children, case not supported", k));
			else if (node.hasLeftChild() ^ node.hasRightChild()){
				if (bst_root.hasLeftChild()){
					//trying to remove bst_root, bst_root == node
					bst_root=bst_root.getLeftChild();
					//node is now the original bst_root
					bst_root.setParent(null);
				}
				else if (bst_root.hasRightChild()){
					bst_root=bst_root.getRightChild();
					bst_root.setParent(null);
				}
			} 
			else if (!node.hasLeftChild() && !node.hasRightChild())
				this.clear();
			if (this.list.size()>0) removeNode(node.getData());
		}
		
		else if (node.hasParent() && !node.hasLeftChild() && !node.hasRightChild()){ 
			//case without children
			Node parent = node.getParent();

			if (parent.getData()>node.getData()){
				parent.setLeftChild(null);
			}
			else if (parent.getData()<node.getData()){
				parent.setRightChild(null);
			}
			node.setParent(null);
			removeNode(node.getData());
			}

		else if (node.hasParent() && (node.hasRightChild() ^ node.hasLeftChild())){ 
			//case with one child ^ =exclusive or
			Node parent=node.getParent();
			Node newKid = node.hasLeftChild()?node.getLeftChild():node.getRightChild();
			if (parent.getData()>node.getData()){
				parent.setLeftChild(newKid);
				newKid.setParent(parent);
				}
			
			else if (parent.getData()<node.getData()){ //parent < child, so child is left child
				parent.setRightChild(newKid);
				newKid.setParent(parent);
				}
			node.setParent(null);
			removeNode(node.getData());
		}
		else if (node.hasRightChild() && node.hasLeftChild()) throw new NodeException("We don't handle removing nodes with multiple children yet");


		// -------------------------------------
		// TODO: HW7
		// -------------------------------------
		//	Fully implement delete algorithm for case 1 and 2 only
		//  Don't forget to check for error conditions (throw NodeException)




	} // end delete() method

	public void printSelf() {

		if ( list.size() == 0 ) System.out.println( "Empty BST!" );

		try {

			for ( int i=0; i<list.size(); i++ ) {

				System.out.println("---------------------------------------------");

				Node node = list.retrieve( i );

				Node right = node.getRightChild();
				Node left = node.getLeftChild();

				if ( left != null && right != null ) {

					System.out.printf("Node = %d\tright=%d\tleft=%d\n", node.getData(), right.getData(), left.getData() );

				} else if ( left == null && right != null ) {

					System.out.printf("Node = %d\tright=%d\t\tleft=EMPTY\n", node.getData(), right.getData() );

				} else if ( left != null && right == null ) {

					System.out.printf("Node = %d\tright=EMPTY\tleft=%d\n", node.getData(), left.getData() );

				} else {

					System.out.printf("Node = %d\tright=EMPTY\tleft=EMPTY\n", node.getData() );

				}

			}

		} catch( Exception error ) {

			System.out.println( error.getMessage() );

		}

	} // end printSelf() method

} // end BinarySearchTree class definition
