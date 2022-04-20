package Factory;
/*
 * Fatema Chandoo
 * WorkerA.java
 * 
 */

public class WorkerA extends Thread{
	private BoundedBuffer buffer; 
	private String name;
	private final int COUNT=24;
	
	public WorkerA(BoundedBuffer buffer, String name) {
		super();
		this.buffer = buffer;
		this.name = name;
	} 
	
	public void run() {
		Widget wid; 
		   for(int i=1; i<=COUNT; i++) {
			   wid = new Widget(i); 
			   BoundedBuffer.napping();
			   wid.handle(name);
			   System.out.println("Worker A is working on the "+wid+" handled by "+wid.handles()); 
			   wid.handle(name);
			   
			   try {
				   Thread.sleep((long)(2000*Math.random()));
			   }
			   catch(InterruptedException e) {
				   
			   }
			   buffer.enter(name, wid);
	}System.out.println("Worker A has finished the job!");
	
	

}
}
