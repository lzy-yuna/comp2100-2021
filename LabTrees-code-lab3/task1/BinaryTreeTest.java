import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * BinaryTreeTest - Test class for Binary Search Tree. 
 * 
 */

public class BinaryTreeTest {
	
	BinaryTree<Integer> tree;
	
	@Before
    public void beforeEachTestMethod() {
	    tree = new NonEmptyBinaryTree<Integer>(7);
	    tree = tree.insert(3)
	    	.insert(1)
	    	.insert(5)
	    	.insert(4)
	    	.insert(11)
	    	.insert(10)
	    	.insert(15);
    }
	
	@Test(timeout=1000)
	public void testInsert() {
        Assert.assertEquals("7 3 1 5 4 11 10 15", tree.preOrderShow());
	}

	@Test(timeout=1000)
	public void testRemoveNodeWithNoChild() {
        Assert.assertEquals("7 3 1 5 4 11 10", tree.delete(15).preOrderShow());
	}

	@Test(timeout=1000)
	public void testRemoveNodeNotFound() {
        Assert.assertEquals("7 3 1 5 4 11 10 15", tree.delete(1000).preOrderShow());
	}
	
	@Test(timeout=1000)
	public void testRemoveNodeWithOneChild() {
        Assert.assertEquals("7 3 1 4 11 10 15", tree.delete(5).preOrderShow());
	}

	@Test(timeout=1000)
	public void testRemoveNodeWithTwoChildren() {
		String result = tree.delete(3).preOrderShow();

		List<String> expected = Arrays.asList("7 4 1 5 11 10 15", "7 1 5 4 11 10 15");

		Assert.assertTrue(expected.contains(result));
	}
	
	@Test(timeout=1000)
	public void testRemoveRootNode() {
		String result = tree.delete(7).preOrderShow();

		List<String> expected = Arrays.asList("10 3 1 5 4 11 15", "5 3 1 4 11 10 15");

		Assert.assertTrue(expected.contains(result)); 
	}
}
