package Function5;
import java.util.Scanner;

/**
 * SOEN 6011 Function F5 = ab^x
 * @author Aruna Devi Pala
 * Student Id: 40184469
 *
 */

public class Function5 {
	
	public static double powerHandler(double x, int n) {
		if(n==0) return 1;
		if(n==1) return x;
		if(n%2 == 0) 
			return powerHandler(x*x, n/2);
		return x*powerHandler(x*x, n/2);
	}
	public static double powerfunction(double x, int n) {
		if(n < 0) {
			return 1.0/powerHandler(x,Math.abs(n));
		}
		return powerHandler(x,n);
	}
	
	/* exponential algorithm */
	public static double exponential(int n){
		double sum = 1; 
		int x = 10;
        for (int i = x - 1; i > 0; --i ) {        	
        	sum = 1 + n * sum / i;
        }
        return sum;
    }
	
	  
	
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

	public static void main(String[] args) {
			// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter value for a = ");
		String a = sc.next();
		a = ValidationFunction(a);
		while(a == null) {
			System.out.println("Please enter value for a = ");
			a = sc.next();
			a =ValidationFunction(a);
		}
		System.out.print("Please enter value for b = ");
		String b = sc.next();
		b = ValidationFunction(b);
		while(b == null) {
			System.out.println("Please enter value for b = ");
			b = sc.next();
			b =ValidationFunction(b);
		}
		System.out.print("Please enter value for x = ");
		String x = sc.next();
		x = ValidationFunction(x);
		while(x == null || x.equals("e")) {
			System.out.println("Please enter value for x = ");
			x = sc.next();
			x =ValidationFunction(x);
		}
		String result =  "Result is " + function5(a,b,x);
		
	}
}


