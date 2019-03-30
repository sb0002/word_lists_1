package pa2;

/*
 * this is a node in the position list. Not too complex, it only has fields for a word's position,
 * and a field to point at the next positions of a word's occurence, if any.
 */
public class PLNode {
	int pos;
	PLNode next;
	PLNode(){
		//filler content
	}
}