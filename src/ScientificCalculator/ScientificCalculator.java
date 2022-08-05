package ScientificCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScientificCalculator {

	/*
	 * Algorithm 1 which is Recursive approach
	 * also we used Algorithm 3 which is Divide and Conquer
	 * approach where we are dividing our function 5 which ab^x as a * b^x
	 */

	/**
     * getting final powerHandler result for b^x
	 * also we used Algorithm 3 which is Divide and Conquer
	 * approach where we are dividing our function 5 which ab^x as a * b^x
     * @param base b
     * @param exponent x
     * @return result of b^x
     */
	public static double powerHandler(double b, double x) {
		double res = 1;

		if (b % 1 == 0 && x % 1 == 0) {

			int x_int = (int) Math.floor(Math.abs(x));
			for (int i = 0; i < x_int; i++) {
				res = res * b;
			}
			if (x < 0)
				return 1 / res;
			else
				return res;
		} else {
			double logRes = getLog(b);
			double exp = x * logRes;
			res = exponent(exp) * 1;
			return res;
		}

	}

	/**
	 * getting log value for exp_base
	 * 
	 * @param exp_base b
	 * @return log value
	 */

	public static double getLog(double b) {

		double exp_res, exp_base, exp_left, exp_right, exp_temp, exp_value;
		exp_value = 2.71828182845905;

		exp_base = b;
		exp_res = 0.0;
		// This speeds up the convergence by calculating the integral
		while (exp_base >= exp_value) {
			exp_base /= exp_value;
			exp_res++;
		}
		exp_res += (exp_base / exp_value);
		exp_base = b;
		int counter = 0;
		do {
			counter++;
			exp_temp = exp_res;
			exp_left = (exp_base / (exponent(exp_res - 1.0)));
			exp_right = ((exp_res - 1.0) * exp_value);
			exp_res = ((exp_left + exp_right) / exp_value);
			if (counter == 5)
				break;
		} while (exp_res != exp_temp);

		return exp_res;

	}

	/**
	 * getting exponent value for the given power
	 * 
	 * @param power p
	 * @return exponent value
	 */

	public static double exponent(double p) {
		double exp_temp, exp_pow, exp_frac, exp_intg, exp_logn;
		exp_temp = p;
		exp_frac = exp_temp;
		exp_pow = (1.0 + exp_temp);
		exp_intg = 1.0;

		do {
			exp_intg++;
			exp_frac *= (exp_temp / exp_intg);
			exp_logn = exp_pow;
			exp_pow += exp_frac;
		} while (exp_logn != exp_pow);

		return exp_pow;
	}

	/*
	 * Algorithm 1 which is Recursive approach where power of the function handled
	 * recursively
	 */
	public static double powerFunction(double b, double x) {
		if (x < 0) {
			return 1.0 / powerHandler(b, Math.abs(x));
		}
		return powerHandler(b, x);
	}

	/*
	 * Algorithm 2 which is Iterative approach used to calculate Function5
	 * with three parameters which a and b are constants and
	 * x is real number
	 * User Divide and Conquer approach where we have divided the input
	 * and calculated the output
	 */
	public static String function5(String a, String b, String x) {
		double y;
		double temp_a = 0, temp_b = 0;
		double temp_x = 0;

		if (a.equals("e")) {
			temp_a = 1;
		} else {
			temp_a = Long.parseLong(a);
		}

		if (b.equals("e")) {
			y = exponential(Integer.parseInt(x));
			y = temp_a * y;

		} else {
			temp_b = Double.parseDouble(b);
			if (x.equals("e")) {
				temp_x = 1;
			} else {
				temp_x = Double.parseDouble(x);
			}

			if (temp_b != 0.0) {
				y = powerFunction(temp_b, temp_x);
				y = temp_a * y;
			} else {
				y = 0;
			}

		}
		System.out.println("Result = " + y + "\n");
		return Double.toString(y);
	}

	/* exponential algorithm where recursive approach is used */
	public static double exponential(int n) {
		double sum = 1;
		int x = 10;
		for (int i = x - 1; i > 0; --i) {
			sum = 1 + n * sum / i;
		}
		return sum;
	}

	/*
	 * Validating the user input for constants and real numbers
	 */

	public static String ValidationFunction(String inputValue) {

		if (inputValue.equals("e")) {
			return inputValue;
		} else {
			try {
				double temp_a = Double.parseDouble(inputValue);
				if (temp_a > -100000 && temp_a <= 100000) {
					return inputValue;
				} else {
					System.out.println(" Please provide input ranging from -100000 to 100000");
				}

			} catch (NumberFormatException exe) {
				System.out.println("Input given is invalid - " + exe);
			}
			System.out.println(" Please enter again");
			return null;
		}
	}
}
