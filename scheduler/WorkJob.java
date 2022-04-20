package scheduler;
/*
 *  FATEMA CHANDOO
 */

public class WorkJob implements JobWorkable {
	private String creator; 
	private String current; 
	
	private int numJob; 
	private int count; 
	private int counting; 
	private String mess; //the message that is generated
	

public WorkJob(int num) {
	creator = Thread.currentThread().getName();
	numJob= num; 
	count=0;
	counting= 1000; 
	mess=""; 
		
	}


	public String getCurrent() {
		return current;
	}


	public int getNumJob() {
		return numJob;
	}

	public int getCount() {
		return count;
	}

	public String getMess() {
		return mess;
	}


@Override
public void doWork() {
	current= Thread.currentThread().getName(); 

	
	//mess= "Job- "+String.valueOf(numJob)+"counted: "+(calculate +count) +"on thread: "+current+"Created by: "+creator; 
	System.out.println(current +"Doing work ");
	
}
}
