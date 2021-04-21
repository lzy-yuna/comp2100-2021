/**
 * Skeleton code for Red Black Tree.
 * You are required to implement the search & insert methods, where the keys are intervals.
 * You may add additional helper methods.  
 *
 * The given code is provided to assist you to complete the required tasks. But the 
 * given code is often incomplete. You have to read and understand the given code 
 * carefully, before you can apply the code properly. You might need to implement 
 * additional procedures, such as error checking and handling, in order to apply the 
 * code properly.
 *
 * @param <T> data type
 */

public class RBTree<T extends Comparable<T>> {
	
	Node<T> root; // The root node of the tree

	/**
	 * Initialize empty RBTree
	 */
	public RBTree() {
		root = null;
	}


	/**
	 * (Safely) insert a key into the tree
	 * Note that if a node with duplicate key is inserted into the red-black tree, 
	 * it will replace the old node with the same key.
	 * 
	 * @param key T The key of the new node being inserted.
	 */
	public void insert(Node.Interval<T> key) {
		Node<T> node = new Node<T>(key);

		// TODO: Complete this method
		// START YOUR CODE
		if (root == null) {
			root = node;
		} else {
			if(search(node.key) != null) return;
			insertRecurse(root, node);
		}

		// Fix tree
		while (node.key != root.key && node.parent.colour == Colour.RED) {
			boolean left  = node.parent == node.parent.parent.left; // Is parent a left node
			Node<T> uncle = left ? node.parent.parent.right : node.parent.parent.left; // Get opposite "uncle" node to parent

			if (uncle.colour == Colour.RED) {
				// Case 1: Recolour
				node.parent.colour = Colour.BLACK;
				uncle.colour = Colour.BLACK;
				node.parent.parent.colour = Colour.RED;
				// Check if violated further up the tree
				node = node.parent.parent;
			} else {
				if (node.key == (left ? node.parent.right.key : node.parent.left.key)) {
					// Case 2: Left Rotation, uncle is right node, x is on the right / Right Rotation, uncle is left node, x is on the left
					node = node.parent;
					if (left) {
						// Perform left rotation
						if (node.key == root.key)
							root = node.right; // Update root
						rotateLeft(node);
					} else {
						// This is part of the "then" clause where left and right are swapped
						// Perform right rotation
						if (node.key == root.key)
							root = node.left;
						rotateRight(node);
					}
				}
				// Adjust colours to ensure correctness after rotation
				node.parent.colour = Colour.BLACK;
				node.parent.parent.colour = Colour.RED;

				// Case 3 : Right Rotation, uncle is right node, x is on the left / Left Rotation, uncle is left node, x is on the right
				if (left) {
					// Perform right rotation
					if (root.key == node.parent.parent.key)
						this.root = node.parent;
					rotateRight(node.parent.parent);
				} else {
					// This is part of the "then" clause where left and right are swapped
					// Perform left rotation
					if (root.key == node.parent.parent.key)
						this.root = node.parent;
					rotateLeft(node.parent.parent);
				}
			}
		}

		// Ensure property 2 (root and leaves are black) holds
		root.colour = Colour.BLACK;
		// END YOUR CODE

	}

	private void insertRecurse(Node<T> root, Node<T> x) {
		boolean cmp = x.key.startTime.compareTo(root.key.startTime) < 0 ||
				(x.key.startTime.compareTo(root.key.startTime) == 0 && x.key.endTime.compareTo(root.key.endTime) < 0);

		if (cmp) {
			if (root.left.key == null) {
				root.left = x;
				x.parent = root;
			} else {
				insertRecurse(root.left, x);
			}
		} else {
			if (root.right.key == null) {
				root.right = x;
				x.parent = root;
			} else {
				insertRecurse(root.right, x);
			}
		}
		// Do nothing if the tree already has a node with the same key.
	}

	public void rotateLeft(Node<T> x) {
		// Make parent (if it exists) and right branch point to each other
		if (x.parent != null) {
			// Determine whether this node is the left or right child of its parent
			if (x.parent.left.key == x.key) {
				x.parent.left = x.right;
			} else {
				x.parent.right = x.right;
			}
		}
		x.right.parent = x.parent;

		x.parent = x.right;
		// Take right node's left branch
		x.right = x.parent.left;
		x.right.parent = x;
		// Take the place of the right node's left branch
		x.parent.left = x;
	}

	public void rotateRight(Node<T> x) {
		if (x.parent != null) {
			if (x.key == x.parent.right.key)
				x.parent.right = x.left;
			else
				x.parent.left = x.left;
		}
		x.left.parent = x.parent;
		x.parent = x.left;
		x.left = x.parent.right;
		x.left.parent = x;
		x.parent.right = x;
	}

	/**
	 * Returns a node if the key of the node is {@code key}.
	 * Otherwise, return null.
	 *
	 * @param key T The key we are looking for
	 * @return
	 */
	public Node<T> search(Node.Interval<T> key) {
		// TODO: Complete this method
		// START YOUR CODE
		return searchHelper(key, this.root);
		// END YOUR CODE
	}

	public Node<T> searchHelper(Node.Interval<T> key, Node<T> root) {
		if (root == null || key == null || root.key == null) {
			return null;
		} else if (key.startTime.equals(root.key.startTime) && key.endTime.equals(root.key.endTime)) {
			return root;
		} else if (key.startTime.compareTo(root.key.startTime) < 0 ||
				(key.startTime.compareTo(root.key.startTime) == 0 &&
						key.endTime.compareTo(root.key.endTime) < 0)) {
				return searchHelper(key, root.left);
		} else {
			return searchHelper(key, root.right);
		}
	}

	/**
	 * Return the result of a pre-order traversal of the tree
	 * 
	 * @param tree Tree we want to pre-order traverse
	 * @return pre-order traversed tree
	 */
	private String preOrder(Node<T> tree) {
		if (tree != null && tree.key != null) {
			String leftStr = preOrder(tree.left);
			String rightStr = preOrder(tree.right);
			return "("+tree.key.startTime + "," + tree.key.endTime +")" + (leftStr.isEmpty() ? leftStr : " " + leftStr)
					+ (rightStr.isEmpty() ? rightStr : " " + rightStr);
		}

		return "";
	}

	public String preOrder() {
		return preOrder(root);
	}

}