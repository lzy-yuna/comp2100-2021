import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * You are given a java class called Something, which has a method called
 * someMethod. Please implement a minimum number of test cases for testing `someMethod`
 * that are branch complete within `someMethod`. Write your test case(s) in test() method in
 * `SomethingTest.java`. You are not allowed to alter the signatures of the given
 * methods and the package structures of the given classes. Please upload the
 * `SomethingTest.java` file to Wattle for marking.
 *
 */
public class SomethingTest {

	@Test
	public void test() {
		// Implement your test cases
		// START YOUR CODE
		assertEquals(0, Something.someMethod(3, 45, 29, 93));
		assertEquals(213, Something.someMethod(36, 36, 45, 30));
		assertEquals(108, Something.someMethod(72, 36, 98, 99));
		// END YOUR CODE
	}
}
