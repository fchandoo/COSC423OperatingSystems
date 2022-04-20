package Factory;
/**
 * WorkerD.java
 * 
 * Fatema Chandoo
 */

public class WorkerD extends Thread{
	private BoundedBuffer buffer; 
	private String name;
	private final int COUNT=24;
	
	public WorkerD(BoundedBuffer buffer, String name) {
		super();
		this.buffer = buffer;
		this.name = name;
	} 
	
	public void run() {
		Widget wid; 
		   for(int i=1; i<=COUNT; i++) {
			   wid = (Widget)buffer.remove(name);
			   System.out.println("Worker D is is retrieving "+wid+" from belt handled by "+wid.handles()); 
			   
			   try {
				   Thread.sleep((long)(2000*Math.random()));
			   }
			   catch(InterruptedException e) {
				   
			   }
			   System.out.println("Worker D has finished the" +wid);
	}System.out.println("Worker D has finished the job");
	
	

}
}
