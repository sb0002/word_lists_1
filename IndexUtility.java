package pa2;

import java.util.Scanner;
//import java.io.*;

public class IndexUtility {
	
	IndexUtility(){
		//filler content
	}
	
	WordList buildIndex() {
		/*
		 * the commented out block below allows the program to be set up to read a file containing text,
		 * which will be parsed exactly as input from the keyboard would be.
		 */
/*		
*		try {
*			   System.setIn(new FileInputStream(new File("/home/bob/eclipse-workspace/pa2/src/pa2/io2.txt")));
*		 } 
*		 catch(Exception e) {
*			   System.out.println("Problem opening input: " + e);
*		 }
*/
		
		/*
		 * This code block generates a fresh word list for the program to play with, then creates a scanner for reading user input.
		 * It also initializes an index, which will increment for each word sent to the add word function as the scanner gets input.
		 */
		WordList wlist=new WordList();
		Scanner skanr=new Scanner(System.in);
		int index=1;
		while(skanr.hasNext()) {
			String phrase=skanr.next();
			wlist.addWord(phrase, index);			//TODO: figure out why passing in phrase.toLowerCase() causes the program to exit before file parsing is fully completed
			index++;
		}
		skanr.close();
		return wlist;
	}
}