package Factory;

/**
 * ProducerAndConsumer.java
 * 
 * Fatema Chandoo
 *
 * This is the producer thread for the bounded buffer problem.
 * Work as worker B and C
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

import java.util.*;

public class ProducerAndConsumer extends Thread
{
	private final int COUNT=24; //generate and properly handle 24 widgets
	private BoundedBuffer consumer; 
	private BoundedBuffer production; 
	private String name; 
  
   
   public ProducerAndConsumer(BoundedBuffer consumer, BoundedBuffer production, String name) {
		super();
		this.consumer = consumer;
		this.production = production;
		this.name = name;
	}

public void run()
   {
   Widget wid; 
   for(int i=1; i<=COUNT; i++) {
	   BoundedBuffer.napping();
	   wid = (Widget)consumer.remove(name); 
	   System.out.println("Worker " +this.name+ " is retrieving"+wid+"from the belt that is handled by "+wid.handles()); 
	   wid.handle(name);
	   
	   try {
		   Thread.sleep((long)(2000*Math.random()));
	   }
	   catch(InterruptedException e) {
		   
	   }
	   production.enter(name, wid);
   }
   System.out.println("The Worker "+this.name+" has finished!");
     
      }
   }
   
