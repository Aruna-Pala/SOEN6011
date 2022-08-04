package Function5;

import ScientificCalculator.ScientificCalculator;
import java.util.Scanner;

/**
 * SOEN 6011 Function F5 = ab^x
 * 
 * @author Aruna Devi Pala
 *         Student Id: 40184469
 *
 */

public class Function5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter value for a = ");
		String a = sc.next();
		a = ScientificCalculator.ValidationFunction(a);
		while (a == null) {
			System.out.println("Please enter value for a = ");
			a = sc.next();
			a = ScientificCalculator.ValidationFunction(a);
		}
		System.out.print("Please enter value for b = ");
		String b = sc.next();
		b = ScientificCalculator.ValidationFunction(b);
		while (b == null) {
			System.out.println("Please enter value for b = ");
			b = sc.next();
			b = ScientificCalculator.ValidationFunction(b);
		}
		System.out.print("Please enter value for x = ");
		String x = sc.next();
		x = ScientificCalculator.ValidationFunction(x);
		while (x == null || x.equals("e")) {
			System.out.println("Please enter value for x = ");
			x = sc.next();
			x = ScientificCalculator.ValidationFunction(x);
		}
		String result = "Result is " + ScientificCalculator.function5(a, b, x);

	}

}
