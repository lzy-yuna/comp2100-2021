import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConcatenateTest {
	
	@Test
	public void testConcatenate() {
		String result = Concatenate.concatenate("one", "two");

        assertEquals("onetwo", result);
	}

}
