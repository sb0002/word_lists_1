package pa2;
/*
 * This here is the position list. For each phrase in the word list, it keeps track of all the positions in which that word occurs.
 */
public class PositionList {
	PLNode sentinel;							//make a handy sentinel node
	PositionList(){
		sentinel=new PLNode();					//initialize the sentinel to a new blank position list node
	}
	
	public void add(int data) {
		PLNode newnode=new PLNode();			//make a new blank node to hold the incoming data
		newnode.pos=data;
		
		PLNode temp=sentinel;					
		while(temp.next!=null) {				//this loop uses the temporary node created before to traverse the position list until it reaches the end
			temp=temp.next;
		}
		temp.next=newnode;						//at the end of the list, the new node is inserted
	}
}