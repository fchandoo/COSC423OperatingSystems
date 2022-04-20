 package schedulerIO;
 /*
  * Fatema Chandoo 
  */

public class IODevice extends Thread  {
	private Job jobs; 
	private int operations; 
	private SystemSimulator kernels;
	
	
	public IODevice(Job jobs, int operations, SystemSimulator kernels) {
		super();
		this.jobs = jobs;
		this.operations = operations;
		this.kernels = kernels;
	} 
	
	public void run() {
		try { 
			sleep(operations);
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println(jobs.getNameOf()+ "" + jobs + "IO operstions"); 
		//kernels.getMyScheduler()
	}
	
	
	

}
