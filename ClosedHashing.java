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
	private List list = new ArrayList();

	public ClosedHashing(){
		this.size=10;

	};

	public ClosedHashing(int startingSize){
		this.size=startingSize;
		list = new ArrayList(size);
		for (int i=0; i<size; i++){
			list.add(new Node());
		}
	}

	public Node get(String key) throws OutOfBoundsException, NodeException{
		int addr = hash(key);
		if (list.retrieve(addr).getHash()==addr && list.retrieve(addr).getKey()!=null && list.retrieve(addr).getKey().equals(key))
			return list.retrieve(addr);
		else {
			for (int i=1; i<size; i++){
				Node node = list.retrieve((addr+i)%size);
				if (node.getKey()==null)
					return null;
				if (node.getHash()==addr && node.getKey()==key)
					return node;
			}
		}
		return null;
	}

	public void insert(String key) throws OutOfBoundsException, NodeException{

		//if the key is already in the hash do nothing
		if (get(key) != null && get(key).getKey()!=null && get(key).getKey().equals(key)){
			return;
		}
		filled++;
		int addr = hash(key);
		//if that index position is empty put the key there
		if (list.retrieve(addr).getKey()==null || list.retrieve(addr).getKey().equals(" ")){
			list.retrieve(addr).setKey(key);
			list.retrieve(addr).setHash(addr);
		}
		//otherwise find an open position
		else if (list.retrieve(addr).getKey()!=null){
			//go to the next one [and next one, etc] until one is empty but keep the hash address the same
			boolean done = false;
			for (int i=1; i<size && !done; i++){
				if (list.retrieve((addr+i)%size).getKey() == null || list.retrieve((addr+i)%size).getKey().equals(" ")){
					done = true;
					Node node = list.retrieve((addr+i)%size);
					node.setHash(addr);
					node.setKey(key);
				}
			}
		}
		else throw new NodeException(String.format("No open spots available for key %s",key)); 
		//should never happen since they ArrayList automatically resizes
	}

	public void delete(String key) throws OutOfBoundsException, NodeException{
		if (get(key)==null)
			throw new NodeException(String.format("Key %s is not in the dictionary, it can't be deleted!",  key));

		filled--;
		int addr = hash(key);
		if (list.retrieve(addr).getHash()==addr && list.retrieve(addr).getKey().equals(key)){
			Node node = list.retrieve(addr);
			node.setKey(" ");
			node.setHash(-1);
		}
		else {
			for (int i=1; i<size; i++){
				Node del = list.retrieve((addr+i)%size);
				if (del.getHash()==addr & del.getKey().equals(key)){
					del.setKey(" ");
					del.setHash(-1);
					return;
				}
			}
		}
	}

	private int hash(String key){
		System.out.println("CH: filled:"+filled);
		int num = 5731;
		int total = 0;
		for (int i=0; i<key.length(); i++){
			total+=(int)key.charAt(i)*num*Math.pow(-1, i);
		}
		System.out.printf("\nCH: HASH: Key \"%s\" makes hash address %d\n",key, Math.abs(total % size));
		return Math.abs(total % size);
	}

	public double getLoad(){
		return filled/(double)list.size();
	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		try {
			for (int i=0; i<list.size(); i++){
				s.append(i).append(": ");
				if (list.retrieve(i).getKey()!=null)
					s.append(String.format("CH: %s (real hash value %d)\n",list.retrieve(i).getKey(), list.retrieve(i).getHash()));
				else s.append("\n");
			}
		} catch (OutOfBoundsException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return s.toString();
	}

	public int getFilled(){
		return filled;
	}
	
}

