package Factory;

/**
 * Factory.java
 * 
 * Fatema Chandoo
 *
 * This creates the buffer and the producer and consumer threads.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * @version 2.0 -- Feb. 8, 2010
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

public class Factory
{
	public static void main(String args[]) {
		BoundedBuffer server1 = new BoundedBuffer(1);
		BoundedBuffer server2 = new BoundedBuffer(2);
		BoundedBuffer server3 = new BoundedBuffer(3);

      		// now create the producer and consumer threads
			WorkerA A= new WorkerA(server1, "A"); 
      		ProducerAndConsumer B = new ProducerAndConsumer(server1, server2, "B");
      		ProducerAndConsumer C = new ProducerAndConsumer(server2, server3, "C");
      		WorkerD D= new WorkerD(server3, "D"); 
      		
      		A.start(); 
      		B.start();
      		C.start();
      		D.start(); 
      		
      		//System.out.println("Factory FINSIHED!!!");
	}
}