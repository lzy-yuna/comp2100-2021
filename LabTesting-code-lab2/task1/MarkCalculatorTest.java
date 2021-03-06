/**
 * Sample code with JUnit 4 for the parameterized test
 * 
 */

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MarkCalculatorTest {
	/**
	 * Return a list of parameters which are different implementation of 
	 * interface {@linkplain MarkCalculator}. 
	 * Do NOT Modify this part
	*/
	@Parameters
    public static Iterable<? extends Object> getImplementations() {
        return Arrays.asList(
                new MarkCalculator0(),
                new MarkCalculator1(),
                new MarkCalculator2(),
                new MarkCalculator3(),
                new MarkCalculator4(),
                new MarkCalculator5(),
                new MarkCalculator6(),
                new MarkCalculator7(),
                new MarkCalculator8(),
                new MarkCalculator9()
        );
    }
	
	@Parameter
	public MarkCalculator calculator;
	
	
	// ########## YOUR CODE STARTS HERE ##########
	
	/* EXAMPLE Test case 1 */
	@Test(expected = ComponentOutOfRangeException.class)
	public void testException() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(-1, 0, 0, 0, true);
	}

	/* EXAMPLE Test case 2 */
	@Test
	public void testGradeN() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(0, Grade.N), this.calculator.calculateMark(0, 0, 0, 0, true));
	}

	// Not attempting the final exam
	@ Test
	public void testGradeNoFinal() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(null, Grade.NCN), this.calculator.calculateMark(0, 0, 0, 0, false));
	}

	// Test for calculating PX Grades
	@ Test
	public void testGradePX() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(45, Grade.PX), this.calculator.calculateMark(3, 3, 3, 55, true));
	}

	// Test for calculating P Grades
	@Test
	public void testGradeP() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(52, Grade.P), this.calculator.calculateMark(4,4,4, 60, true));
	}

	// Test for calculating C Grades
	@Test
	public void testGradeC() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(60, Grade.C), this.calculator.calculateMark(5, 6, 4, 66, true));
	}

	// Test for calculating D Grades
	@Test
	public void testGradeD() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(70, Grade.D), this.calculator.calculateMark(7, 5, 9, 70, true));
	}

	// Test for calculating HD Grades
	@Test
	public void testGradeHD() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(92, Grade.HD), this.calculator.calculateMark(9, 9, 10, 90,true));
	}

	// There's a wrong special case in MarkCalculator4
	@Test
	public void testCalculator4() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(50, Grade.P), this.calculator.calculateMark(2, 7, 8, 43, true));
	}

	// Bugs in determining whether scores are in the given ranges
	@Test (expected = ComponentOutOfRangeException.class)
	public void testCalculator6and9() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(3, 1, 12, 0, false);
	}

	// Because the precision problem of float numbers. Marks are not combined exactly. (MarkCalculator0)
	@Test
	public void testCalculator0() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(59, Grade.P), this.calculator.calculateMark(0, 0, 1, 95, true));
	}
	// ########## YOUR CODE ENDS HERE ##########
}
