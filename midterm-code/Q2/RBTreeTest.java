/*
 * These test cases are provided to assist your implementation.
 * However, note that these test cases may not be used in actual marking.
 * You are encouraged to write your own test case to test the correctness
 * of your implementation.
 */
 
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RBTreeTest {
	RBTree<Integer> tree;
	
	@Before
	public void setUp() {
		tree = new RBTree<Integer>();
		Node.Interval<Integer> node1 = new Node.Interval<Integer>(7,8);
		Node.Interval<Integer> node2 = new Node.Interval<Integer>(5,6);
		Node.Interval<Integer> node3 = new Node.Interval<Integer>(9,10);
		tree.insert(node1);
		tree.insert(node2);
		tree.insert(node3);
	}
	
	@Test(timeout=1000)
	public void testInsert() {
		Assert.assertEquals("(7,8) (5,6) (9,10)", tree.preOrder());
	}
	
	@Test(timeout=1000)
	public void testInsertDuplicate() {
		Node.Interval<Integer> node4 = new Node.Interval<Integer>(9,10);
		tree.insert(node4);
		Assert.assertEquals("(7,8) (5,6) (9,10)", tree.preOrder());
	}

	@Test(timeout=1000)
	public void testInsertNewNode() {
		Node.Interval<Integer> node5 = new Node.Interval<Integer>(9,11);
		tree.insert(node5);
		Assert.assertEquals("(7,8) (5,6) (9,10) (9,11)", tree.preOrder());
	}

	@Test(timeout=1000)
	public void testInsertNewNode1() {
		Node.Interval<Integer> node5 = new Node.Interval<Integer>(9,11);
		Node.Interval<Integer> node8 = new Node.Interval<Integer>(7,6);
		tree.insert(node5);
		tree.insert(node8);
		Assert.assertEquals("(7,8) (5,6) (7,6) (9,10) (9,11)", tree.preOrder());
	}

	@Test(timeout=1000)
	public void testInsertNewNode2() {
		Node.Interval<Integer> node5 = new Node.Interval<Integer>(9,11);
		Node.Interval<Integer> node8 = new Node.Interval<Integer>(7,6);
		Node.Interval<Integer> node9 = new Node.Interval<Integer>(9,8);
		tree.insert(node5);
		tree.insert(node8);
		tree.insert(node9);
		Assert.assertEquals("(7,8) (5,6) (7,6) (9,10) (9,8) (9,11)", tree.preOrder());
	}

	@Test(timeout=1000)
	public void testSearch1() {
		Node.Interval<Integer> node6 = new Node.Interval<Integer>(5,6);
		Assert.assertTrue(tree.search(node6).key.startTime == 5 && tree.search(node6).key.endTime == 6);
	}

	@Test(timeout=1000)
	public void testSearch2() {
		Node.Interval<Integer> node7 = new Node.Interval<Integer>(1,2);
		Assert.assertNull(tree.search(node7));
	}

	@Test(timeout=1000)
	public void testNodeRedToBlack() {
		Node.Interval<Integer> node5 = new Node.Interval<Integer>(9,11);
		Node.Interval<Integer> node3 = new Node.Interval<Integer>(9,10);
		Node.Interval<Integer> node4 = new Node.Interval<Integer>(5,6);
		tree.insert(node5);
		Assert.assertTrue(tree.search(node3).colour == Colour.BLACK && tree.search(node4).colour == Colour.BLACK);
	}

	@Test(timeout=1000)
	public void testInsertNewNodeRed() {
		Node.Interval<Integer> node5 = new Node.Interval<Integer>(9,11);
		tree.insert(node5);
		Assert.assertTrue(tree.search(node5).colour == Colour.RED);
	}

	@Test(timeout=1000)
	public void testInsertNewNodeNoColourChange() {
		Node.Interval<Integer> node1 = new Node.Interval<Integer>(9,11);
		Node.Interval<Integer> node2 = new Node.Interval<Integer>(8,11);
		Node.Interval<Integer> node3 = new Node.Interval<Integer>(9,10);
		Node.Interval<Integer> node4 = new Node.Interval<Integer>(5,6);
		tree.insert(node1);
		tree.insert(node2);
		Assert.assertTrue(tree.search(node3).colour == Colour.BLACK
				&& tree.search(node4).colour == Colour.BLACK
				&& tree.search(node1).colour == Colour.RED
				&& tree.search(node2).colour == Colour.RED);
	}

	@Test(timeout=1000)
	public void testInsertRotate() {
		Node.Interval<Integer> node1 = new Node.Interval<Integer>(9,11);
		Node.Interval<Integer> node2 = new Node.Interval<Integer>(7,1);
		Node.Interval<Integer> node3 = new Node.Interval<Integer>(7,7);
		tree.insert(node1);
		tree.insert(node2);
		tree.insert(node3);
		Assert.assertEquals("(7,8) (7,1) (5,6) (7,7) (9,10) (9,11)", tree.preOrder());
	}

}
