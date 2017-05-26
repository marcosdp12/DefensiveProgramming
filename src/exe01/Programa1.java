package exe01;

import java.util.Scanner;

public class Programa1 {

	static final int INPUT_SIZE = 10;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s1 = getString(scan);
		
		char[] vals = new char[s1.length()];

		copyVals(s1, vals);

		String sub = getSubstring(scan, vals);
		System.out.println("sub string: " + sub);
	}

	public static String getString(Scanner scan) {
		System.out.print("Please type a string: ");
		String s = scan.nextLine();
		
		//garantir que a string digitada seja menor que o limite INPUT_SIZE
		while(s.length() > INPUT_SIZE||s.length()<1){
			System.out.print("Please type a string with length no bigger "
					+"than " + INPUT_SIZE +" caracters:\n");
			s = scan.nextLine();
		}
		return s;
	}

	public static void copyVals(String s, char[] vals) {
		for (int i = 0; i < s.length(); i++) {
			vals[i] = s.charAt(i);
		}
	}

	public static String getSubstring(Scanner scan, char[] vals) {
		System.out.print("Starting point: ");
		int length = vals.length;
		int start;
		int end; 
		String input;
	
		while (true) {
	        input = scan.next();
	        try {
	        	start = Integer.parseInt(input);
	        	if(start > -1 && start < INPUT_SIZE && start < length){
	        		break;
	        	}
	        	else System.out.println("Type a not negative start point less than " + length + ":");;
	        } catch (NumberFormatException ne) {
	            System.out.println("Type a not negative start point less than " + length + ":");
	        }
	    }
		
		System.out.print("Ending point: ");
		while (true) {
	        input = scan.next();
	        try {
	        	end = Integer.parseInt(input);
	        	if(end> -1 && end < length+1 && end > start){
	        		break;
	        	}
	        	else System.out.println("Type a not negative end point less than " + (length+1) + 
	        			" and bigger than " + start + ":");
	        } catch (NumberFormatException ne) {
	            System.out.println("Type a not negative end point less than " 
	                          + (length+1) + " and bigger than " + start + ":");
	        }
	    }

		char[] newChars = getChars(start, end, vals);
		return new String(newChars);
	}

	public static char[] getChars(int start, int end, char[] vals) {
		int sz = end - start;
		char[] result = new char[sz];
		for (int i = 0; i < sz; i++) {
			result[i] = vals[start + i];
		}
		return result;
	}

}
