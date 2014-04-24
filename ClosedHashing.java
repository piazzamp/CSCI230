package edu.cofc.compsci.csci230;
/**
 * 
 * @author mattpiazza
 * APR 2014, CSCI 230
 * A Hashing class that linearly probes the list for open keys and only allows one value per key
 */
public class ClosedHashing {
	
	private int size;
	private int filled;
	private double load;
	private List list = new ArrayList();
	public SLList keys = new SLList();
	
	public ClosedHashing(){};
	
	public ClosedHashing(int startingSize, double loadFactor){
		this.load=loadFactor;
		this.size=startingSize;
		list = new ArrayList(size);
		for (int i=0; i<size; i++){
			list.add(new Node());
		}
	}

	public Node get(String key) throws OutOfBoundsException, NodeException{
		int addr = hash(key);
		if (list.retrieve(addr).getHash()==addr && list.retrieve(addr).getKey().equals(key))
			return list.retrieve(addr);
		else {
			for (int i=1; i<size; i++){
				Node node = list.retrieve((addr+i)%size);
				if (node.getHash()==addr && node.getKey()==key)
					return node;
			}
		}
		return null;
		//throw new NodeException(String.format("key %s is not in the dictionary!", key));
	}
	
	public void insert(String key) throws OutOfBoundsException, NodeException{
		int addr = hash(key);
		if (get(key) != null)
			throw new NodeException(String.format("Key %s is already in the dictionary, no duplicates allowed!", key));
		//add the key to the simple list of keys:
		keys.add(new Node().setKey(key)); 
		filled++;
		
		//check to see if this insert will go over the load factor
		if ((filled/(double)size)>load){
			//double the array length
		}
		
		if (list.retrieve(addr).getKey()==null){
			list.retrieve(addr).setKey(key);
			list.retrieve(addr).setHash(addr);
		}
		else if (list.retrieve(addr).getKey()!=null){
			//go to the next one [and next one, etc] until one is empty but keep the hash address the same
			boolean done = false;
			for (int i=1; i<size && !done; i++){
				if (list.retrieve((addr+i)%size).getKey() == null){
					done = true;
					Node node = list.retrieve((addr+i)%size);
					node.setHash(addr);
					node.setKey(key);
				}
			}
		}
		else throw new NodeException(String.format("No open spots available for key %s",key));
	}

	public void delete(String key) throws OutOfBoundsException, NodeException{
		if (get(key)==null)
			throw new NodeException(String.format("Key %s is not in the dictionary, it can't be deleted!",  key));
		
		int addr = hash(key);
		if (list.retrieve(addr).getHash()==addr && list.retrieve(addr).getKey().equals(key)){
			Node node = list.retrieve(addr);
			node.setKey(null);
			node.setHash(0);
		}
		else {
			for (int i=1; i<size; i++){
				if (list.retrieve((addr+i)%size).getHash()==addr & list.retrieve((addr+i)%size).getKey().equals(key)){
					list.remove((addr+i)%size);
					return;
				}
			}
		}
	}
	
	public int hash(String key){
		int num = 5731;
		int total = 0;
		for (int i=0; i<key.length(); i++){
			total+=(int)key.charAt(i)*num*Math.pow(-1, i);
		}
		System.out.printf("\nHASH: Key \"%s\" makes hash address %d\n",key, Math.abs(total % size));
		return Math.abs(total % size);
	}
	
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		try {
			for (int i=0; i<list.size(); i++){
				s.append(i).append(": ");
				if (list.retrieve(i).getKey()!=null)
					s.append(String.format("%s (real hash value %d)\n",list.retrieve(i).getKey(), list.retrieve(i).getHash()));
				else s.append("\n");
			}
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return s.toString();
	}
}
