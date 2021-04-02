import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class MergeSortTest {
    @Test
    public void Test1() {
        int[] test1 = {5,1,6,2,3,4};
        int[] expected = {1,2,3,4,5,6};        
        
        MergeSort.mergeSort(test1);
        assertArrayEquals(expected,test1);

    }

    @Test
    public void Test2() {
        int[] test2 = {10,9,8,7,6,5};
        int[] expected = {5,6,7,8,9,10};
        
        MergeSort.mergeSort(test2);
        assertArrayEquals(expected,test2);
                
    }

    @Test
    public void Test3() {
        int[] test3 = {30,50,10};
        int[] expected = {10,30,50};
        
        MergeSort.mergeSort(test3);
        assertArrayEquals(expected,test3);
        
    }

    @Test
    public void Test4() {
        int[] test4 = {0};
        int[] expected = {0};
       
        MergeSort.mergeSort(test4);
        assertArrayEquals(expected,test4);
       
    }

    @Test
    public void Test5() {
        int[] test5 = {50,36,23,66,21};
        int[] expected = {21,23,36,50,66};
        
        MergeSort.mergeSort(test5);
        assertArrayEquals(expected,test5);
        
    }

    @Test
    public void Test6() {
        int[] test6 = {67, 45};
        int[] expected = {45, 67};

        MergeSort.mergeSort(test6);
        assertArrayEquals(expected, test6);
    }

    @Test
    public void Test7() {
        int[] test7 = {67, -45, 0, -242, 5314};
        int[] expected = {-242, -45, 0, 67, 5314};

        MergeSort.mergeSort(test7);
        assertArrayEquals(expected, test7);
    }
}