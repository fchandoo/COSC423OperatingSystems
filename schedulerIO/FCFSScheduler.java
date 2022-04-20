package schedulerIO;

/**
 *  FATEMA CHANDOO
 * <p>Title: FCFSScheduler</p>
 * <p>Description: Component of the simulate operating system that encapsulates FCFS job scheduling.</p>
 * <p>Copyright: Copyright (c) 2015, 2004</p>
 * <p>Company: </p>
 * @author Matt Evett
 * @version 2.0
 */

import java.util.concurrent.ConcurrentLinkedQueue;

public class FCFSScheduler extends Scheduler {
	ConcurrentLinkedQueue<Job> queue;  //holding the objects of type job
	ConcurrentLinkedQueue<Job> readyQueue; //input queue
	
	
	public FCFSScheduler() {
		super();
		 queue = new ConcurrentLinkedQueue<Job>();
		readyQueue= new ConcurrentLinkedQueue<Job>();
	}

	 
  /*
   * TO_DO: your data structure to support a FCFS scheduler
   * and the abstract methods of Scheduler
   */
    
 
  /**
   * If the ready queue is empty, return false.
   * Otherwise, start the next job in the queue, returning true.  If the queue is empty
   * return false.
   * Make the next job in the ready queue run. You should probably
   * invoke Thread.start() on it.
   */
  public boolean makeRun()
  {
	  //System.out.println("TO_DO: makeRun not yet implemented");

	  /*
	   * Place code here that gets the next Job from the ready queue and
	   * invokes start() on it
	   *
	   */
	   // if the queue is empty 
//	  if(queue.isEmpty()) {
//		 return false; 
//	  }
//	  else {
//		  currentlyRunningJob=queue.poll(); 
//		  currentlyRunningJob.start();
//	  }
//	  return true; // TO_DO ***SHOULDN'T ALWAYS RETURN TRUE***
	  
	  if(this.hasJobsQueued()) {
		  currentlyRunningJob = readyQueue.remove(); 
		  if(hasReadyJobs() || currentlyRunningJob.getBurstTime().size()==0) {
			  currentlyRunningJob.getMyCondition().signal(); 
			  System.out.println(currentlyRunningJob.getNameOf()+ " "+ currentlyRunningJob); 
			  
		  }else {
			  System.out.println("Starting: "+ currentlyRunningJob.getNameOf() ); //something needs to be added
			  currentlyRunningJob.start();
		  }
		  System.out.println("Jobs are on the Ready Queue: "+hasJobsQueued());
		  System.out.println("The number of Jobs that are on the ready queue: "+ readyQueue.size()); 
		  System.out.println("Jobs that are on the list: "+hasReadyJobs()); 
		  System.out.println("The numbers of jobs on the list: "+queue.size()); 
		  return true;   
	  }
	  System.out.println("No jobs are running"); 
	  return false; 
  }
  
  /**
   * blockTilThereIsAJob()  Invoked by OS simulator when it wants to get a new Job to
   * run.  Will block if the ready queue is empty until a Job is added to the queue.
   */
  public synchronized void blockTilThereIsAJob() {
	  if (hasRunningJob()) 
		  return;
	 
	  try {
		  System.out.println("Waiting for a job to be assigned"); 
		  this.wait();
	  }catch(InterruptedException ex) {
		  ex.printStackTrace();
	  }
  
	  //System.out.println("TO_DO: blockTilThereIsAJob not yet implemented");
	  /*
	   * Place code here that will cause the calling thread to block until the ready queue
	   * contains a Job
	   */
	  System.out.println("evidently there is now a job on queue");
	  notify(); 
  }

@Override
public synchronized void add(Job J) {
	readyQueue.add(J);
	notify();
	System.out.println(J.getName() +"Job is added to the ready queue");
}

@Override
public void remove(Job J) {
	// TODO Auto-generated method stub
	readyQueue.remove(); 
	
}

@Override
public boolean hasJobsQueued() {
	return !readyQueue.isEmpty();
}

@Override
public void startIO() {
	if(currentlyRunningJob !=null) {
		queue.add(currentlyRunningJob);
		System.out.println(currentlyRunningJob.getNameOf()+ "" +currentlyRunningJob);///add something
	}
	
}

@Override
public void finishIO(Job J) {
	// TODO Auto-generated method stub
	queue.remove(J); 
	System.out.println(J.getNameOf()+ " "+ J+"removed from the list and added to the readyQueue");
	add(J); 
	
}
public boolean hasInputJobs() {
	return !queue.isEmpty();
}

@Override
public boolean hasReadyJobs() {
	return currentlyRunningJob.isAlive();
}
}
  

