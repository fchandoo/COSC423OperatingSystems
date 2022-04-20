package scheduler;

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
	ConcurrentLinkedQueue<Job> queue = new ConcurrentLinkedQueue<Job>(); //holding the objects of type job

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
	  if(queue.isEmpty()) {
		 return false; 
	  }
	  else {
		  currentlyRunningJob=queue.poll(); 
		  currentlyRunningJob.start();
	  }
	  return true; // TO_DO ***SHOULDN'T ALWAYS RETURN TRUE***
  }
  
  /**
   * blockTilThereIsAJob()  Invoked by OS simulator when it wants to get a new Job to
   * run.  Will block if the ready queue is empty until a Job is added to the queue.
   */
  public   synchronized void blockTilThereIsAJob() {
	  if (hasRunningJob()) 
		  return;
	 if(hasJobsQueued()) 
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
  }

@Override
public synchronized void add(Job J) {
	// TODO Auto-generated method stub
	//System.out.println("Add " +J.getName()+ " to the ready Queue"); 
	 
	if(queue.isEmpty()){
		notifyAll();}
	queue.add(J);
	
	
}

@Override
public void remove(Job J) {
	// TODO Auto-generated method stub
	queue.remove(); 
	
}

@Override
public boolean hasJobsQueued() {
	return !queue.isEmpty();
}
}
  

