package edu.cofc.compsci.csci230;

/**
 * 
 * @author mattpiazza
 * APR 2014, CSCI 230
 * A Hashing class that allows multiple values to be stored in the same key position
 */
public class OpenHashing {

	private List list = new ArrayList(); //start with an array of empty nodes
	private int size;
	private int filled =0;
	private SLList keys = new SLList();

	public OpenHashing(){};
	
	public OpenHashing(int startingSize){
		this.size=startingSize;
		
		//fill the array with blank nodes for ease of use and to avoid null pointers
		list = new ArrayList(startingSize);
		for (int i=0; i<startingSize; i++){
			list.add(new Node());
		}
	}

	public Node get(String key) throws OutOfBoundsException {
			int addr = hash(key);
			System.out.printf("OH:GET \"%s\" finds address %d with values list length:%d",key,addr, list.retrieve(addr).getValues().size());
			if (list.retrieve(addr).getValues().size() == 0)
				return null;
			else if (list.retrieve(addr).getValues().size()>=1){
				int length = list.retrieve(addr).getValues().size();
				List values = list.retrieve(addr).getValues();
				for (int i=0; i<length; i++){
					if (values.retrieve(i).getKey().equals(key))
						return values.retrieve(i);
				}
			}
			return null;
	}
	
	public void insert(String key) throws OutOfBoundsException, NodeException{
		int addr = hash(key);
		
		//make sure it is not a duplicate key: (wait should this be thrown at all?
		if (get(key) != null) 
			return;
		
		//fill one bucket since you will definitely add a node if you get this far
		keys.add(new Node().setKey(key));
		
		//if this is the first key to be stored at this address:
		if (list.retrieve(addr).getKey()==null){
			filled++;
			Node node = list.retrieve(addr); 
			node.setHash(addr);
			node.setKey(key);
			Node keyNode = new Node();
			keyNode.setKey(key);
			node.addValue(keyNode);
			List db = node.getValues();
			for (int i=0; i<db.size(); i++){
				System.out.println("\nOH:embedded list item:"+i+" has key:"+db.retrieve(i).getKey());
			}
		}
		
		//if there are already value(s) at this has address:
		else if (list.retrieve(addr).getKey() != null){
			Node node = list.retrieve(addr);
			Node add = new Node();
			add.setKey(key);
			node.addValue(add);
			List db = node.getValues();
			for (int i=0; i<db.size(); i++){
				System.out.println("OH:embedded list item:"+i+" has key:"+db.retrieve(i).getKey());
			}
		}
		
	}
	
	public void delete(String key) throws OutOfBoundsException, NodeException{
		int addr = hash(key);
		System.out.printf("\nOH:Before delete %s's values list has length %d\n", key, list.retrieve(addr).getValues().size() );
		
		if (list.retrieve(addr).getKey()==null)
			throw new NodeException(String.format("Key %s not in dictionary, it can't be deleted", key));
		
		filled--;
		if (list.retrieve(addr).getValues().size()==1){
			Node old = list.retrieve(addr);
			old.setKey(null);
			old.getValues().clear();
			System.out.printf("\nOH:now the list's length is %d", list.retrieve(addr).getValues().size());
		}
		else if (list.retrieve(addr).getValues().size()>1){
			Node old = list.retrieve(addr);
			List values = old.getValues();
			for (int i=0; i<values.size(); i++){
				if (values.retrieve(i).getKey().equals(key))
					values.remove(i);
			}
			old.setKey(values.retrieve(0).getKey());
			
			if (old.getKey().equals(key)){
				if (old.getValues().size()>0)
					old.setKey(old.getValues().retrieve(0).getKey());
				else old.setKey(null);
			}
		}
	}
	
	private int hash(String key){
		int total = 1;
		for (int i=0; i<key.length(); i++){
			char letter = key.charAt(i);
			total = total + (int)(letter * .6);
		}
		System.out.printf("\nOH:Hash for key %s is %d\n",key, total % size);
		
		return total % size;
		
	}
	
	public SLList getKeys(){
		SLList results = new SLList();
		try {
			for (int i=0; i<list.size(); i++){
				if (list.retrieve(i).getValues() != null){
					List inside = list.retrieve(i).getValues();
					for (int x=0; x<inside.size(); x++)
						results.add(inside.retrieve(x));
				}
			}
		} catch (OutOfBoundsException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	public double getLoad(){
		return filled/(double)size;
	}
	
	public int getFilled(){
		return filled;
	}
	
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append("\n");
		for (int i=0; i<list.size(); i++){
			try {
				s.append(i).append(": ");
				if (list.retrieve(i).getValues()==null){
					s.append("");
					}
				else {
					List values = list.retrieve(i).getValues();
					int length = values.size();
					for (int p=0; p<length; p++)
						s.append(values.retrieve(p).getKey()).append(", ");
				}
				s.append("\n");
			} catch (OutOfBoundsException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		return s.toString();
	}

}
