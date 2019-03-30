package pa2;

/*
 * The workhorse of this program, the WordList class handles the ins and outs of wordlist creation and maintenance.
 * It receives input in the form of a word and its position in the string and checks to see if the word already exists
 * in the string. If so, the positionlist is updated and the addWord method stops. If not, the method creates a new
 * wordlist node and fills it with the data. Then it looks through the list for the proper lexicographical location
 * and places the new node there. The print method outputs each phrase followed by the index of all its occurences.
 */

public class WordList {
	/*
	 * Here we generate a wordlist and some handle nodes for both wordlist and positionlist.
	 */
	WordList wl;
	WLNode sentinel=new WLNode();
	PLNode pln=new PLNode();
	
	WordList(){
		//filler
	}
	
	public void addWord(String word, int position) {
		/*
		 * This function traverses the linked list to make sure the latest word received is not already in the list.
		 * If it is, the corresponding positionlist is updated with another location and the word is not added.		
		 */
		WLNode probe=sentinel.next;
		while(probe!=null) {
			if(probe.word.equals(word)) {
				probe.plist.add(position);
				return;
			}
			probe=probe.next;
		}
		
		PositionList pl=new PositionList();						//a new positionlist is created to go with the new word just received.
		pl.add(position);										//new word means at least one position is filled
	
		WLNode newnode=new WLNode();							//a new home for the new word

		newnode.plist=pl;										//the positionlist is assigned to the new word's node
		newnode.word=word;	
	
		if(sentinel.next==null) {								//if the list was empty, the sentinel will have to jumpstart its construction
			sentinel.next=newnode;								//the sentinel will point to the first node created
			return;
		}
		
		/*
		 * This collection of code's purpose is to find the right place for a new word. "prev" and "curr" traverse the list with
		 * curr in the lead. When curr, pretending to be the new word received, is determined to be alphabetically inferior to whichever
		 * word in the list is being examined, the new word is inserted between previous and current, so that the list is lexicographically
		 * sound.
		 */
		
		WLNode prev, curr;										//welcoming prev and curr
		prev=sentinel;											//prev starts off as far back as possible
		curr=sentinel.next;										//and curr starts off just ahead of that
		while(curr!=null) {										//when the end of the list is reached, there's nothing else to be done.
			if(curr.word.compareTo(word)<0) {
				//do nothing
			} else if (curr.word.compareTo(word)==0){
				//do nothing
			} else {
				newnode.word=word;								//here the new node is filled with the word and placed between prev and curr
				newnode.next=curr;
				prev.next=newnode;
				break;
			}
			prev=curr;											//prev and curr continue their close journey through the list.
			curr=curr.next;
		}
	}
	
	/*
	 * Following is the print method. The blandly named nodes within serve as probes to traverse their
	 * respective linked lists. "bleh" is a word list node, and it moves through the wordlist, giving
	 * node information to the printer to display onscreen. For every iteration of bleh's node moves,
	 * "blah" comes along and prints out the index corresponding to every occurence of the word bleh is 
	 * currently looking at. Several invisible prints are included each time to separate the output 
	 * in a more aesthetic fashion. Truly bleh and blah are a wonderful team.
	 */
	
	public void print() {
		WLNode bleh=sentinel.next;
		while(bleh!=null) {
			System.out.print(bleh.word + " ");
			PLNode blah=bleh.plist.sentinel.next;
			while(blah!=null) {
				String line=blah.pos+",";
				System.out.print(line);
				blah=blah.next;
			}
			System.out.println("");
			bleh=bleh.next;
			System.out.print("");
		}
		return;
	}
}