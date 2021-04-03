package tree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tree.BST.Node;

public class Task2Test {
	BST simpleBst;
	BST complexBst;
	BST additional1;
	BST additional2;
	BST additional3;

	public static String preOrderTraversal(Node node) {
		if (node == null)
			return "";
		if (node.left == null && node.right == null)
			return node.value.toString();
		else {
			String leftStr = "";
			String rightStr = "";
			if (node.left != null) {
				leftStr = preOrderTraversal(node.left);
			}
			if (node.right != null) {
				rightStr = preOrderTraversal(node.right);
			}
			return node.value.toString() + (leftStr.isEmpty() ? leftStr : " " + leftStr)
					+ (rightStr.isEmpty() ? rightStr : " " + rightStr);
		}
	}

	@Before
	public void constructTree() {
		simpleBst = new BST();
		for (int i = 0; i < 10; i++) {
			simpleBst.insert(i);
		}

		complexBst = new BST();
		complexBst.insert(10);
		complexBst.insert(7);
		complexBst.insert(3);
		complexBst.insert(15);
		complexBst.insert(12);
		complexBst.insert(17);
		complexBst.insert(16);
		complexBst.insert(20);

		additional1 = new BST();
		additional1.insert(10);
		additional1.insert(9);
		additional1.insert(8);
		additional1.insert(7);
		additional1.insert(6);
		additional1.insert(5);

		additional2 = new BST();
		additional2.insert(1);
		additional2.insert(2);
		additional2.insert(3);
		additional2.insert(4);
		additional2.insert(5);
		additional2.insert(6);

		additional3 = new BST();
		additional3.insert(10);
	}
	
	@Test
	public void deleteSimpleTest1() {
		simpleBst.delete(1);
		assertEquals("0 2 3 4 5 6 7 8 9", preOrderTraversal(simpleBst.root).trim());
	}
	
	@Test
	public void deleteSimpleTest2() {
		simpleBst.delete(9);
		assertEquals("0 1 2 3 4 5 6 7 8", preOrderTraversal(simpleBst.root).trim());
	}

	@Test
	public void deleteComplexTest1() {
		complexBst.delete(15);
		assertEquals("10 7 3 16 12 17 20", preOrderTraversal(complexBst.root).trim());
	}
	
	@Test
	public void deleteComplexTest2() {
		complexBst.delete(10);
		assertEquals("12 7 3 15 17 16 20", preOrderTraversal(complexBst.root).trim());
	}

	@Test
	public void additional1() {
		additional1.delete(10);
		assertEquals("9 8 7 6 5", preOrderTraversal(additional1.root).trim());
	}

	@Test
	public void additional2() {
		additional1.delete(7);
		assertEquals("10 9 8 6 5", preOrderTraversal(additional1.root).trim());
	}

	@Test
	public void additional3() {
		additional2.delete(1);
		assertEquals("2 3 4 5 6", preOrderTraversal(additional2.root).trim());
	}

	@Test
	public void additional4() {
		additional2.delete(4);
		assertEquals("1 2 3 5 6", preOrderTraversal(additional2.root).trim());
	}

	@Test
	public void additional5() {
		additional3.delete(10);
		assertEquals("", preOrderTraversal(additional3.root).trim());
	}
}
