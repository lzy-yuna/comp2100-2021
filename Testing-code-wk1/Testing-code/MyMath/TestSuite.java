/**
 * Example of JUnit TestSuite.
 * TestSuite is designed to run multiple JUnit test classes at the same time.
 * 
 * 
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses(
		{
			MyMathTest.class,
			MyMathParameterizedTest.class,
			TestTimeout.class
		}
)

public class TestSuite {
	//This remains empty
}
