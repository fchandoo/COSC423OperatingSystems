package MultiThreading;

import java.util.Arrays;

//Worker Class
public class Stats extends Thread {
	private int count;
	//private int[] num; 
	private char message; 
	private Stats stat;
	
	public Stats() {
		
	}
	
	public Stats(char message) {
		super();
		
		this.message = message;
		//this.stat = stat;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	} 
	
	public void run() {
		 
		 
		// Sorting the num
		Arrays.sort(Driver.num);
		
		//Average
		if(message == 'a') {
			int sum=0;
			for (int i=0; i< Driver.num.length; i++) {
				sum =sum + Driver.num[i]; 	
			}
			Driver.avg = sum/Driver.num.length; 
			//stat.setCount(avg);
			}
		//Min values
		
		Driver.low = Driver.num[0]; 
//		else if(message == 'm') {
//			for(int i=0; i< num.length;i++) {
//				//if(num[i]<num[i+1] ) 
//				{
//					low = num[i]; 
//				}stat.setCount(low);
//			}
//			
//		}
		//Max Values
		Driver.high = Driver.num[Driver.num.length-1]; 
//		else if(message == 'M') {
//			for(int i=0; i< num.length;i++) {
//				//if(num[i-1]> high ) {
//					high = num[i]; 
//				}stat.setCount(high);
//			}
//			
//		}
	}
	
	

}
