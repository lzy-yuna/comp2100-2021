
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyMathParameterizedTest {
	
    @Parameters
    public static Collection<Object[]> data() {
    	// return list of arrays each of which are mapped to the parameter with corresponding position
        return Arrays.asList(new Object[][] {     
                 { 0.7f, 0.3f, 1}, { 0.4f, 0.2f, 0}  
           });
    }
    
    //first entry of each array
    @Parameter(0)
    public float a;

    //second entry of each array    
    @Parameter(1)
    public float b;

    //third entry of each array    
    @Parameter(2)
    public int expected;
    
    
	@Test
	public void test() {
		MyMath math = new MyMath();
		assertEquals(expected, math.sumAndFloor(a, b));
	}

}
