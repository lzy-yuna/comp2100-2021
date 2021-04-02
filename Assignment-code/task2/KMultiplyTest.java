import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KMultiplyTest {

    @Test
    public void Test1() {
        
        int x = 1;
        int y = 5;
        assertEquals(5, MultiplicationAlgorithm.KMultiply(x,y));
        
    }

    @Test
    public void Test2() {
        
        int x = 33333;
        int y = 18520;
        assertEquals(617327160, MultiplicationAlgorithm.KMultiply(x,y));
        
    }

    @Test
    public void Test3() {        
        
        int x = 2021;
        int y = 2029;
        assertEquals(4100609, MultiplicationAlgorithm.KMultiply(x,y));
        
    }

    @Test
    public void Test4() {
                
        int x = 12;
        int y = 32;
        assertEquals(384, MultiplicationAlgorithm.KMultiply(x,y));
                
    }

    @Test
    public void Test5() {
        
        int x = 333;
        int y = 444;
        assertEquals(147852,MultiplicationAlgorithm.KMultiply(x,y));
        
    }

    @Test
    public void Test6() {

        long x = 7619535;
        long y = 9457546;
        assertEquals(72062102761110L, MultiplicationAlgorithm.KMultiply(x, y));
    }

    @Test
    public void Test7() {

        int x = 10;
        int y = 10;
        assertEquals(100, MultiplicationAlgorithm.KMultiply(x, y));
    }
}
