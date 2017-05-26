package exe2;

import java.util.Scanner;

public class Overflow2 {
	public static void main(String[] args) {
		int[] tests = new int[10];
		int test;
		int count;
		String input;
		Scanner scan = new Scanner(System.in);

		System.out.print("How many numbers? ");
		while (true) {
	        input = scan.next();
	        try {
	        	 count = Integer.parseInt(input);
	        	if(count > 0 && count < 11){
	        		break;
	        	}
	        	else System.out.println("Type a positive number less than 11:");
	        } catch (NumberFormatException ne) {
	            System.out.println("Type a positive number less than 11:");
	        }
	    }
		
		for (int i = 0; i < count; i++) {
			System.out.print("Please type a number: ");
			while (true) {
		        input = scan.next();
		        try {
		        	test = Integer.parseInt(input);
		        	break;
		        } catch (NumberFormatException ne) {
		            System.out.println("OVERFLOW! Type a smaller number:");
		        }
		    }
			tests[i] = test;
		}
	}
}