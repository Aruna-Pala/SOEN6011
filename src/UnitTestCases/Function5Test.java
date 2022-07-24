package UnitTestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Function5.Function5;

/**
 * SOEN 6011 Test Cases for F5 = ab^x
 * @author Aruna Devi Pala
 * Student Id: 40184469
 *
 */

public class Function5Test {

	/**
	 * ID = TC1
	 * Test Case = checking the input given by user using ValidationFunction
	 * Function Included = ValidationFunction
	 * Functional Requirement ID = FR1, FR2
	 */
	
	@Test
    public void testCheckInput() {
        assertEquals("e", Function5.ValidationFunction("e"));
        assertEquals("22", Function5.ValidationFunction("22"));
        assertEquals("-23.4", Function5.ValidationFunction("-23.4"));
	}
	
	/**
	 * ID = TC2
	 * Test  Case =  the calculation for constant such as "e"
	 * Function Included = exponential, Function5
	 * Functional Requirement ID = FR5
	 */
	
	@Test
    public void testMagicalNumbere() {
        double sum = Function5.exponential(2);
        String result = Double.toString(sum);
        assertEquals(result, Function5.function5("1", "e", "2"));
	}
	
	/**
	 * ID = TC3
	 * Test  Case =  the calculation for positive and negative numbers
	 * Function Included = function5
	 * Functional Requirement ID = FR6,FR7
	 */
	@Test
    public void testfunction5() {
        assertEquals("54.0", Function5.function5("2", "3", "3"));
        assertEquals("-54.0", Function5.function5("-2", "3", "3"));
	}
	
	/**
	 * ID = TC4
	 * Test  Case =  testing power function for the constant as base to the power x
	 * Function Included = powerfunction
	 * Functional Requirement ID = FR3, FR7
	 */
	@Test
    public void testNegativeF5PowerFunction() {
        assertEquals(25.0, Function5.powerfunction(-5,2),1);
        assertEquals(-19683.0, Function5.powerfunction(-3,9),1);
	}
	
	/**
	 * ID = TC5
	 * Test  Case =  testing bigInteger for ab^x function
	 * Function Included = function5
	 * Functional Requirement ID = FR3
	 */
	@Test
    public void testBigIntegerPower() {
		assertEquals("Infinity", Function5.function5("20", "2", "6000"));
        assertEquals("-Infinity", Function5.function5("-2", "2", "10000"));
	}
	
	/**
	 * ID = TC6
	 * Test  Case =  testing function with 0 as base and 0 in power
	 * Function Included = function5
	 * Functional Requirement ID = FR1
	 */
	@Test
    public void testAnythingPowerZero() {
		assertEquals("20.0", Function5.function5("20", "2", "0"));
        assertEquals("0.0", Function5.function5("2", "0", "0"));
	}

}
