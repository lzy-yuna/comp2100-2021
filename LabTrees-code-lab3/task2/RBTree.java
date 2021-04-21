
/**
 * Skeleton code for Red Black Tree
 * 
 * @param <T> data type
 * 
 * The given code is provided to assist you to complete the required tasks. But the 
 * given code is often incomplete. You have to read and understand the given code 
 * carefully, before you can apply the code properly. You might need to implement 
 * additional procedures, such as error checking and handling, in order to apply the 
 * code properly.
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
	 * Add a new node into the tree with {@code root} node.
	 * 
	 * @param root Node<T> The root node of the tree where x is being inserted.
	 * @param x    Node<T> New node being inserted.
	 */
	private void insertRecurse(Node<T> root, Node<T> x) {
		int cmp = root.key.compareTo(x.key);
		
		if (cmp > 0) {
			if (root.left.key == null) {
				root.left = x;
				x.parent = root;
			} else {
				insertRecurse(root.left, x);
			}
		} else if (cmp < 0) {
			if (root.right.key == null) {
				root.right = x;
				x.parent = root;
			} else {
				insertRecurse(root.right, x);
			}
		}
		// Do nothing if the tree already has a node with the same key.
	}

	/**
	 * Insert node into RBTree.
	 * 
	 * @param x Node<T> The new node being inserted into the tree.
	 */
	private void insert(Node<T> x) {
		// TODO: Complete this function
		// You need to finish cases 1, 2 and 3; the rest has been done for you

		// Insert node into tree
		if (root == null) {
			root = x;
		} else {
			if(search(x.key) != null) return;
			insertRecurse(root, x);
		}

		// Fix tree
		while (x.key != root.key && x.parent.colour == Colour.RED) {
			boolean left  = x.parent == x.parent.parent.left; // Is parent a left node
			Node<T> uncle = left ? x.parent.parent.right : x.parent.parent.left; // Get opposite "uncle" node to parent

			if (uncle.colour == Colour.RED) {
				// Case 1: Recolour
				// TODO: Implement this part
				// ########## YOUR CODE STARTS HERE ##########
				x.parent.colour = Colour.BLACK;
				uncle.colour = Colour.BLACK;
				x.parent.parent.colour = Colour.RED;
				// ########## YOUR CODE ENDS HERE ##########
				// Check if violated further up the tree
				x = x.parent.parent;
			} else {
				if (x.key == (left ? x.parent.right.key : x.parent.left.key)) {
					// Case 2: Left Rotation, uncle is right node, x is on the right / Right Rotation, uncle is left node, x is on the left
					x = x.parent;
					if (left) {
						// Perform left rotation
						if (x.key == root.key)
							root = x.right; // Update root
						rotateLeft(x);
					} else {
						// This is part of the "then" clause where left and right are swapped
						// Perform right rotation
						// TODO: Implement this part
						// ########## YOUR CODE STARTS HERE ##########
						if (x.key == root.key)
							root = x.left;
						rotateRight(x);
						// ########## YOUR CODE ENDS HERE ##########
					}
				}
				// Adjust colours to ensure correctness after rotation
				x.parent.colour = Colour.BLACK;
				x.parent.parent.colour = Colour.RED;

				// Case 3 : Right Rotation, uncle is right node, x is on the left / Left Rotation, uncle is left node, x is on the right
				// TODO: Complete this part
				if (left) {
					// Perform right rotation
					// ########## YOUR CODE STARTS HERE ##########
					if (x.parent.parent.key == root.key)
						root = x.parent;
					rotateRight(x.parent.parent);
					// ########## YOUR CODE ENDS HERE ##########
				} else {
					// This is part of the "then" clause where left and right are swapped
					// Perform left rotation
					// ########## YOUR CODE STARTS HERE ##########
					if (x.parent.parent.key == root.key)
						root = x.parent;
					rotateLeft(x.parent.parent);
					// ########## YOUR CODE ENDS HERE ##########
				}
			}
		}

		// Ensure property 2 (root and leaves are black) holds
		root.colour = Colour.BLACK;
	}

    /** Rotate the node so it becomes the child of its right branch
    /*
        e.g.
              [x]                    b
             /   \                 /   \
           a       b     == >   [x]     f
          / \     / \           /  \
         c  d    e   f         a    e
                              / \
                             c   d
    */
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

    /** Rotate the node so it becomes the child of its left branch
    /*
        e.g.
              [x]                    a
             /   \                 /   \
           a       b     == >     c     [x]
          / \     / \                   /  \
         c  d    e   f                 d    b
                                           / \
                                          e   f
    */
	public void rotateRight(Node<T> x) {
		// TODO: Implement this function
		// HINT: It is the mirrored version of rotateLeft()
		// ########## YOUR CODE STARTS HERE ##########
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
		// ########## YOUR CODE ENDS HERE ##########
	}

	/**
	 * Demo functions (Safely) insert a key into the tree
	 * 
	 * @param key T The key of the new node being inserted.
	 */
	public void insert(T key) {
		Node<T> node = new Node<T>(key);
		if (node != null)
			insert(node);
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
			return tree.key + (leftStr.isEmpty() ? leftStr : " " + leftStr)
					+ (rightStr.isEmpty() ? rightStr : " " + rightStr);
		}

		return "";
	}

	public String preOrder() {
		return preOrder(root);
	}

	/**
	 * Return the corresponding node of a key, if it exists in the tree
	 * 
	 * @param x Node<T> The root node of the tree we search for the key {@code v}
	 * @param v Node<T> The node that we are looking for
	 * @return
	 */
	private Node<T> find(Node<T> x, T v) {
		if (x.key == null)
			return null;

		int cmp = v.compareTo(x.key);
		if (cmp < 0)
			return find(x.left, v);
		else if (cmp > 0)
			return find(x.right, v);
		else
			return x;
	}

	/**
	 * Returns a node if the key of the node is {@code key}.
	 * 
	 * @param key T The key we are looking for
	 * @return
	 */
	public Node<T> search(T key) {
		return find(root, key);
	}
}