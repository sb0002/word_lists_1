package pa2;

//import javax.xml.soap.Node;

public class LinkedListClass {
	Node handle=null;					//handle~~sentinel node
	public void add(int n) {
		Node newnode=new Node();
		newnode.data=n;
		newnode.next=null;
		
		if(handle==null) {
			handle=newnode;
			return;
		}
		
		newnode.next=handle;
		handle=newnode;
		return;
	}
	
	public void print() {
		Node temp=handle;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
		return;
	}
}

class Node{
	int data;
	Node next;
}