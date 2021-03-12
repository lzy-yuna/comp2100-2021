import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {
	
	BST tree;
	
	@Before
	public void init() {
		this.tree = new BST();
	}
	
	@Test(timeout=1000)
	public void testCommonAncestorParentChild() {
		for (int i = 1; i < 10; i++) {
			this.tree.insert(i);
		}
			
		assertEquals(2, (int) this.tree.lowestCommonAncestor(2, 3));
	}

	@Test(timeout=1000)
	public void testCommonAncestorDirectParent() {
		int[] treevals = {5, 2, 1, 7, 6, 8, 10};
		for(int i :treevals) {
			this.tree.insert(i);
		}
			
		assertEquals(7, (int) this.tree.lowestCommonAncestor(6, 8));
	}
	
	@Test(timeout=1000)
	public void testCommonAncestorRoot() {
		int[] treevals = {6, 2, 1, 7, 5, 8, 10};
		for(int i :treevals) {
			this.tree.insert(i);
		}
			
		assertEquals(6, (int) this.tree.lowestCommonAncestor(1, 8));
	}
	
	@Test(timeout=1000)
	public void testCommonAncestorParentChild2() {
		int[] treevals = {23, 30, 1, 42, 6, 51, 37};
		for(int i : treevals) {
			this.tree.insert(i);
		}
			
		assertEquals(42, (int) this.tree.lowestCommonAncestor(42, 51));		
	}
	
	@Test(timeout=1000)
	public void testCommonAncestorRoot2() {
		int[] treevals = {30, 23, 1, 42, 6, 51, 37};
		for(int i : treevals) {
			this.tree.insert(i);
		}
		
		assertEquals(30, (int) this.tree.lowestCommonAncestor(1, 37));		
	}
	
	@Test(timeout=1000)
	public void testCommonAncestorParentChildLongPathLeaves() {
		int[] treevals = {15,10,5,13,12,11,25,30};
		for(int i : treevals) {
			this.tree.insert(i);
		}

		assertEquals(10, (int) this.tree.lowestCommonAncestor(5, 11));		
	}
	
	@Test(timeout=1000)
	public void testCommonAncestorRootAndLeaf() {
		int[] treevals = {15,10,5,13,12,11,25,30};
		for(int i : treevals) {
			this.tree.insert(i);
		}

		assertEquals(15, (int) this.tree.lowestCommonAncestor(15, 11));		
	}
}
