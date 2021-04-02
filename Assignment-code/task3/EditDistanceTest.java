import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EditDistanceTest {

    @Test
    public void Test1() {
        String str1 = "abc";
        String str2 = "abd";
        assertEquals(EditDistance.minDistance(str1,str2), 2);
    }

    @Test
    public void Test2() {
        String str1 = "goodmorning";
        String str2 = "goodevening";
        assertEquals(EditDistance.minDistance(str1,str2), 6);
    }

    @Test
    public void Test3() {
        String str1 = "good";
        String str2 = "bad";
        assertEquals(EditDistance.minDistance(str1,str2), 5);
    }

    @Test
    public void Test4() {
        String str1 = "abcde";
        String str2 = "abcde";
        assertEquals(EditDistance.minDistance(str1,str2), 0);
    }

    @Test
    public void Test5() {
        String str1 = "HIEROGLYPHOLOGY";
        String str2 = "MICHAELANGELO";
        assertEquals(EditDistance.minDistance(str1,str2), 18);
    }

    @Test
    public void Test6() {
        String str1 = "";
        String str2 = "";
        assertEquals(EditDistance.minDistance(str1, str2), 0);
    }

    @Test
    public void Test7() {
        String str1 = "ab";
        String str2 = "";
        assertEquals(EditDistance.minDistance(str1, str2), 2);
    }

    @Test
    public void Test8() {
        String str1 = "ab";
        String str2 = "abc";
        assertEquals(EditDistance.minDistance(str1, str2), 1);
    }
}
