package ScientificCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScientificCalculator {
	
		/* Algorithm 1 which is Recursive approach
		 *  also we used Algorithm 3 which is Divide and Conquer 
		 *  approach where we are dividing our function 5 which ab^x as a * b^x
		*/
		public static double powerHandler(double x, int n) {
			if(n==0) return 1;
			if(n==1) return x;
			if(n%2 == 0) 
				return powerHandler(x*x, n/2);
			return x*powerHandler(x*x, n/2);
		}
		
		/*
		 * Algorithm 1 which is Recursive approach where power of the function handled recursively
		 */
		public static double powerfunction(double x, int n) {
			if(n < 0) {
				return 1.0/powerHandler(x,Math.abs(n));
			}
			return powerHandler(x,n);
		}
		
		/* Algorithm 2 which is Iterative approach used to calculate Function5 
		 * with three parameters which a and b are constants and 
		 * x is real number
		 * User Divide and Conquer approach where we have divided the input 
		 * and calculated the output
		 */
		public static String function5(String a, String b, String x) {
			double y;
			double temp_a = 0, temp_b = 0;
			int temp_x = 0;
			
			if(a.equals("e")) {
				temp_a = 1;
			}else {
				temp_a = Long.parseLong(a);
			}
			
			if(b.equals("e")) {
				y = exponential(Integer.parseInt(x));
				y = temp_a*y;
				
			}else {
				temp_b = Double.parseDouble(b);
				if(x.equals("e")) {
					temp_x = 1;
				}else {
					temp_x = Integer.parseInt(x);
				}
				
				if(temp_b != 0.0) {
					y = powerfunction(temp_b,temp_x);
					y = temp_a*y;
				}else {
					y = 0;
				}
				
			}
			System.out.println("Result = "+ y +"\n");
			return Double.toString(y);
		}
		
		
		
		/* exponential algorithm where recursive approach is used */
		public static double exponential(int n){
			double sum = 1; 
			int x = 10;
	        for (int i = x - 1; i > 0; --i ) {        	
	        	sum = 1 + n * sum / i;
	        }
	        return sum;
	    }
		
		/*
		 * Validating the user input for constants and real numbers
		 */
		
		public static String ValidationFunction(String input) {
			
			if(input.equals("e")) {
				return input;
			}else {
				try {
					double temp_a = Double.parseDouble(input);
					if(temp_a > -100000 && temp_a <= 100000) {
						return input;
					}else {
						System.out.println("Please provide input ranging from -100000 to 100000");
					}
					
				}catch(NumberFormatException e) {
					System.out.println("Input given is invalid - "+e);
				}
				System.out.println("Please enter again");
				return null;
			}
		}
		
		
		public static void menu() {
			int choice = 0;
			Scanner input = new Scanner(System.in);
			System.out.println("Avaiable Function");
			System.out.println("1. Function : tan(x) \n2. Function : sinh(x)\n3. Function : ab^x\n4. Function : x^y\n5. End");
			System.out.print("\nPlease enter your choice (enter function number) = ");
			try {
				choice = input.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Please enter valid integers\n");
				menu();
			}
			
		}
}
