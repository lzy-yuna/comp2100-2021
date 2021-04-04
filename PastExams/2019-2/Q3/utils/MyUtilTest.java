package utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TODO: write a minimum number of JUnit test cases (assertEquals) for
 * {@code MyUtil.parseDouble} that is code complete.
 * 
 * 
 *
 */
public class MyUtilTest {
	@Test
	public void test() {
		//start your code
		assertEquals(0, MyUtil.parseDouble(null), 0);
		assertEquals(0, MyUtil.parseDouble("aa"), 0);
		assertEquals(123.456, MyUtil.parseDouble("abc123.456efg"), 0);
		//end your code
	}

}
