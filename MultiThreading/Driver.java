package MultiThreading;

import java.util.Scanner;

//Main Class 
public class Driver {
	public static int avg=0; 
	public static int high =-1; 
	public static int low =0; 
	public static int[] num; 
	//int temp=0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		String input; 
		System.out.println("Welcome to the Stats Calculator");
		System.out.println("Enter the numbers: ");
		input= scan.nextLine();  
		String[] numbers= input.split(" "); 
		 num = new int[numbers.length];
		
		for(int i=0; i <numbers.length; i++) {
			num[i] = Integer.parseInt(numbers[i]);
		}
		
		
		
		Thread average = new Thread(new Stats( 'a')); 
		Thread minimum = new Thread (new Stats( 'm')); 
		Thread maximum = new Stats( 'M');
		
		average.start();
		minimum.start();
		maximum.start();
		try {
		average.join();
		System.out.println("The average value is: "+avg); 
		
		minimum.join();
		System.out.println("The minimum value is: "+low);
		
		maximum.join();
		System.out.println("The maximum value is: "+high);
		}catch(InterruptedException ex) {
			
		}
	}

}
