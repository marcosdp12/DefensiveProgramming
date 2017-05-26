package exe6;

import java.lang.System;
import java.util.Scanner;


class Ackerman {
	public static void main(String[] args) {
		long ackValue = 1;
		long exp = 0;
		String input;
		
		Scanner scan = new Scanner(System.in);

		System.out.print("Type a number: ");
		
		while (true) {
	        input = scan.next();
	        try {
	        	exp = Integer.parseInt(input);
	        	if(exp <= 3){
	        		break;
	        	}
	        	else System.out.println("Type a number smaller than 4");
	        } catch (NumberFormatException ne) {
	            System.out.println("Type a number smaller than 4");
	        }
	    }
		
		if (exp > 1) {
			ackValue = exp;
			int numLoops = (int) exp;
			for (int i = 1; i < numLoops; i++) {
				exp = ackValue;
				for (int j = 1; j < numLoops; j++) {
					ackValue = ackValue * exp;
					System.out.println("current value is " + ackValue);
				}
			}
			System.out.println("Ackerman vlue: " + ackValue);
		}
	}
}