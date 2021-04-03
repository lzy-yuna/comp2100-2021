package utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TODO: write a minimum number of JUnit test cases (assertEquals) for
 * {@code MyStringUtil.isMixedCase} that is branch complete.
 */
public class MyStringUtilTest {

	@Test
	public void test() {
		//start your code
		assertFalse(MyStringUtil.isMixedCase(null));
		assertFalse(MyStringUtil.isMixedCase(""));
		assertTrue(MyStringUtil.isMixedCase("Aaa"));
		assertTrue(MyStringUtil.isMixedCase("aA"));
		assertFalse(MyStringUtil.isMixedCase("aa"));
		assertFalse(MyStringUtil.isMixedCase("AA"));
		//end your code
	}

}
