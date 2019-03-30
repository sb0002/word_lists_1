package pa2;

public class Main {
	
	public static void main(String[] args) {
		IndexUtility iu=new IndexUtility();
		WordList wl=iu.buildIndex();
		wl.print();
	}
}