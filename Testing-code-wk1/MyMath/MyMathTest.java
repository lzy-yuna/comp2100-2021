
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyMathTest{
	private MyMath math;
	
	
	@Before
	public void setUp() {
		math = new MyMath();
		System.out.println("Before.setUp");
	}
	
	@After
	public void tearDown()
	{
		math = null;
		System.out.println("After.tearDown");
	}

	
	@Test
	public void testSumFloor() {
		System.out.println("Test.SumFloor");
		assertEquals(1, math.sumAndFloor(0.6f, 0.7f));
		
		// will not pass the test because of floating point precision, 0.9f-0.1f != 0.8f
		//assertEquals("This case should not work",1, math.sumAndFloor(0.1f, 0.9f));
	}
	
	@Test
	public void testAdd() {
		System.out.println("Test.Add");
		//Basic test
		assertSame(3, math.add(1, 2));
		assertEquals(4, math.add(1, 3));
		
	}
	
	@Test(timeout=1000, expected = ArithmeticException.class)
	public void testDivideZero() {
		System.out.println("Test.DivideZero");
		// divide by zero will raise ArithmeticException
		assertEquals(0, math.divide(1, 0), 1e-10);
	}
	
	@Test
	public void testDivide() {
		System.out.println("Test.Divide");
		// double or float number comparison requires delta
		//assertEquals(0.3333333, 1.0/3.0, 0.1);
		assertEquals(0.3333333, math.divide(1, 3), 0.000001);
	
	}
	
	@Test
	public void testLog2NegativeInput() {
		System.out.println("Test.Log2");
		// double or float number comparison requires delta
		assertEquals(Double.NaN, math.log2(-1), 0.000001); //or
	}
	
	@Test
	public void testLog2NaNInput() {
		System.out.println("Test.Log2");
		// double or float number comparison requires delta
		assertEquals(Double.NaN, math.log2(Double.NaN), 0.000001);
	}
	
	@Test
	public void testLog2PositiveInfinity() {
		System.out.println("Test.Log2");
		// double or float number comparison requires delta
		assertEquals(Double.POSITIVE_INFINITY, math.log2(Double.POSITIVE_INFINITY), 0.000001);
	}
	
	@Test
	public void testLog2NegativeInfinityZero() {
		System.out.println("Test.Log2");
		// double or float number comparison requires delta
		assertEquals(Double.NEGATIVE_INFINITY, math.log2(0.0), 0.000001);
	}
	
	@Test
	public void testLog2NegativeZero() {
		System.out.println("Test.Log2");
		// double or float number comparison requires delta
		assertEquals(Double.NEGATIVE_INFINITY, math.log2(-0.0), 0.000001);
	}
	
	@Test
	public void testLog2RegularCase1() {
		System.out.println("Test.Log2");
		// double or float number comparison requires delta
		assertEquals(0, math.log2(1), 0.000001);
	}
	
	@Test
	public void testLog2RegularCase2() {
		System.out.println("Test.Log2");
		// double or float number comparison requires delta
		assertEquals(3, math.log2(8), 0.000001);
	}
}
