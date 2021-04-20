/**
 * These test cases are provided to assist your implementation.
 * However, note that these test cases may not be used in actual marking.
 * You are encouraged to write your own test case to test the correctness
 * of your implementation.
 */
 
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinarySearchTest {
    Element<Integer>[][] testMatrix;
    BinarySearch<Integer> bs = new BinarySearch<Integer>();

    @Before
    public void beforeTest(){
        testMatrix = new Element[10][10];        
        int _key = 1;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                testMatrix[i][j] = new Element<Integer>(_key,_key+1);
                _key++;                
            }
        }
    }

    @Test(timeout=1000)
    public void Test1(){
        Element<Integer> expected1 = new Element<Integer>(1,2);
        Element<Integer> actual1 = bs.search(testMatrix,0,9,0,9,1);
        assertEquals(expected1.key, actual1.key);
        assertEquals(expected1.value, actual1.value);
    }

    @Test(timeout=1000)
    public void Test2(){
        Element<Integer> expected2 = new Element<Integer>(10,11);
        Element<Integer> actual2 = bs.search(testMatrix,0,9,0,9,10);
        assertEquals(expected2.key, actual2.key);
        assertEquals(expected2.value, actual2.value);
    }

    @Test(timeout=1000)
    public void Test3(){
        Element<Integer> expected3 = new Element<Integer>(32,33);
        Element<Integer> actual3 = bs.search(testMatrix,0,9,0,9,32);
        assertEquals(expected3.key, actual3.key);
        assertEquals(expected3.value, actual3.value);
    }

    @Test(timeout=1000)
    public void Test4(){
        Element<Integer> expected4 = new Element<Integer>(57,58);
        Element<Integer> actual4 = bs.search(testMatrix,0,9,0,9,57);
        assertEquals(expected4.key, actual4.key);
        assertEquals(expected4.value, actual4.value);
    }

    @Test(timeout=1000)
    public void Test5(){
        assertEquals(null, bs.search(testMatrix,0,9,0,9,101));
    }

    @Test(timeout=1000)
    public void Test6() {
        int[][] custom = {{1, 4, 17, 20}, {2, 8, 30, 42}, {3, 9, 37, 48}, {4, 19, 40, 50}};
        Element<Integer>[][] newTestMatrix = new Element[4][4];
        for (int i = 0; i < custom.length; i++) {
            for (int j = 0; j < custom[0].length; j++) {
                newTestMatrix[i][j] = new Element<>(custom[i][j], 1);
            }
        }
        assertEquals(new Element<>(40, 1).key, bs.search(newTestMatrix, 0, 3, 0, 3, 40).key);
        assertEquals(new Element<>(40, 1).value, bs.search(newTestMatrix, 0, 3, 0, 3, 40).value);
    }
}