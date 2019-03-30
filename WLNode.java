package pa2;

/*
 * this is a node in the wordlist. it has 3 fields: the word itself, the list containing the location of all its occurences,
 * and a field pointing to the next node in the wordlist
 */
public class WLNode {
	String word;
	PositionList plist;
	WLNode next;
	
	WLNode(){
		
	}
}