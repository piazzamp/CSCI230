package edu.cofc.compsci.csci230;

/**
 * @author mattpiazza
 * A class to test out some hashing functions
 * 
 */
public class TestHashing {
	
	public static void main(String[] arrrgs){
		//experiments run here
//		OpenHashing oh = new OpenHashing(15);
//		try {
//			oh.insert("Hello!"); //2
//			oh.insert("How");	 //1
//			oh.insert("are");	 //7
//			oh.insert("you"); 	 //14   *
//			oh.insert("today?"); //3
//			oh.insert("alf");	 //4  -
//			oh.insert("sed");	 //10
//			oh.insert("MAC");	 //6
//			oh.insert("future"); //9
//			oh.insert("space");	 //14   *
//			oh.insert("travel"); //0
//			oh.insert("OUTER");	 //14   *
//			oh.insert("outer");	 //4  -
//			
//			System.out.println("\n----------------------\n");
//			
//			oh.delete("outer");
//			oh.get("outer");
//			
//			System.out.println(oh.toString());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		ClosedHashing ch = new ClosedHashing(15, .9);
		try {
			ch.insert("Hello!"); //4
			ch.insert("How");	 //5  
			ch.insert("are");	 //9
			ch.insert("you"); 	 //7
			ch.insert("today?"); //6
			ch.insert("alf");	 //1  * 
			ch.insert("sed");	 //9
			ch.insert("MAC");	 //4
			ch.insert("future"); //3  -
			ch.insert("space");	 //12
			ch.insert("travel"); //11
			ch.insert("OUTER");	 //1  *
			ch.insert("outer");	 //3  -
			
			System.out.println("Hash address for key \"alf\" is: "+ch.get("alf").getHash());
			//System.out.println("Hash address for key \"OUTER\" is: "+ch.get("OUTER").getHash());
			
			System.out.println(ch.toString());
			System.out.println("\n----------delete alf------------\n");
			ch.delete("alf");
			System.out.println(ch.toString()+"\n");
			ch.keys.printList();
			
			//ch.insert("outer");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		
	}

}
