
/**
 * Example class for testing
 */

public class MyMath {
	
	public int a;
	public int b;
	
	public MyMath()
	{}

	/**
	 * This method will return floored result of two floating numbers.
	 * @param	a	The first floating number
	 * @param	b	The second floating number
	 * @return	floored sum of two floating number {@code a} and {@code b}
	 */
	public int sumAndFloor(double a, double b) {
		return (int)(((a + 0.1f) + (b - 0.1f)));
	}
	
	/**
	 * This methods will perform {@code a}/{@code b}.
	 * @param a numerator
	 * @param b denominator
	 * @return
	 * @throws ArithmeticException
	 */
	public double divide(double a, double b) throws ArithmeticException {
		if(b==0) {
			throw new ArithmeticException();
		}
		
		return a/b;
	}
	
	/**
	 * Return sum of two integer {@code a} and {@code b}.
	 * @param a The first integer value
	 * @param b The second integer value
	 * @return sum of two values
	 */
	public int add(int a, int b) {
		return (a+b);
	}
	
	/**
	* This method will return the log2 of {@code}.
	* @param a The double to calculate log base 2 of. It must be > 0.
	* @returns log base 2 of {@code a}
	*
	*/
	public double log2 (double a)
	{
		return 1.4426950408889634 * Math.log(a); //multiply by that number to convert from log10 to log2
	}
}