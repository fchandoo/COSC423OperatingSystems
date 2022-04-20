package Factory;

/**
 * Widget.java
 * 
 * Fatema Chandoo
 *
 */
import java.util.ArrayList;

public class Widget {
	
	private int num; //to identify the different objects
	private ArrayList<String> handledBy= new ArrayList<String>();




	public Widget(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}
	 public void handle(String h) {
		 handledBy.add(h);
		 //adds the workers who handle and keep track of who did the work
	 }
	 
	 public String handles() {
		 String s="";
		 for (int i=0; i<handledBy.size();i++) {
			 s+= handledBy.get(i)+"";
		 }
		return s;  
	 }

	@Override
	public String toString() {
		// returning the number of the widgets
		return "Widget [num=" + num + "]";
	}
	 
	 
	
	
	
	

}
