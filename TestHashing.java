package edu.cofc.compsci.csci230;

import java.io.File;
import java.util.Scanner;

/**
 * @author mattpiazza
 * A class to test out some hashing functions
 * 
 */
public class TestHashing {
	public static void main(String[] argz){
		

		int wordCount=0;
		OpenHashing oh = new OpenHashing(2000);
		ClosedHashing ch = new ClosedHashing(11000); //has to be big enough to fit all the keys
		
		System.out.println(System.getProperty("user.dir")); //where your program runs, where I put pion.fun

        try {
        	File full = new File("./pion.fun"); 				//pion.fun contains 10,248 words
			Scanner input = new Scanner(full);
        	while(input.hasNext()){
				String word = input.next();
				wordCount++;
				ch.insert(word);
				oh.insert(word);
			}
			System.out.println(oh.toString());
			System.out.println(ch.toString());
			input.close();
			
			File suc = new File("./success.txt");
			Scanner success = new Scanner(suc);
			
			long chSStart = System.currentTimeMillis();
			while (success.hasNext()){
				ch.get(success.next());
			}
			long chSEnd = System.currentTimeMillis();
			success.close();
			
			success = new Scanner(suc); //reset the scanner
			long ohSStart = System.currentTimeMillis();
			while (success.hasNext()){
				oh.get(success.next());
			}
			long ohSEnd = System.currentTimeMillis();
			success.close();
			
			//unsuccessful searches
			long ohStart=System.currentTimeMillis();
			for (int m=0; m<1000; m++){
				oh.get(String.valueOf(System.currentTimeMillis()));
			}
			long ohEnd=System.currentTimeMillis();
			
			long chStart=System.currentTimeMillis();
			for (int m=0; m<1000; m++){
				ch.get(String.valueOf(System.currentTimeMillis()));
			}
			long chEnd=System.currentTimeMillis();
			success.close();
			
			System.out.printf("\n\nEmpirical time: Open Success: %dms Closed Success: %dms", ohSEnd-ohSStart, chSEnd-chSStart);
			System.out.printf("\n\t    Open Fail: %dms Closed Fail: %dms", ohEnd-ohStart, chEnd-chStart);

        }catch (Exception e){
			e.printStackTrace();
		}
		
		System.out.printf("\nFilled Spots: Open:%d Closed:%d \nLoad Factor: Open:%f Closed:%f", oh.getFilled(), ch.getFilled(), oh.getLoad(), ch.getLoad());
		
	}

}
