/**
Given a binary search tree and two keys of nodes, implement a method to find the key of the lowest common ancestor 
(i.e. the shared ancestor that is located farthest from the root). You can define additional methods of BST and Node 
classes to complete the task. The method signature is:
public Integer lowestCommonAncestor(int x, int y)
Consider that x and y always exist in the tree.
Note that the partial code provided uses slightly different (simplified) implementation of BST, which does not use recursion.
**/
public class BST {

	Node root;

	/**
	 * Please implement this method and feel free to add additional helper methods
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Integer lowestCommonAncestor(int x, int y) {
		// TODO
		// START YOUR CODE

		return null; //you are allowed to change this return statement
		// END YOUR CODE
	}

	public BST() {
		this.root = null;
	}

	/**
	* Find a node given a key
	*
	* @param key of a given node
	* @return the node that contains the key, otherwise null
	*/
	public Node find(Integer key) {
		Node current = root;
		while(current != null) {
			if(current.key.compareTo(key) < 0) {
				current = current.right;
			}else if (current.key.compareTo(key) > 0){
				current = current.left;
			}else if(current.key.compareTo(key) == 0) {
				return current;
			}
		}
		return null;
	}

	/**
	 * This implementation of insert follows the pseudo code in the lecture slide.
	 * Node that we did not use recursion here.
	 *
	 * @param key key of inserted node
	 * @return inserted node (not the entire tree)
	 */
	public Node insert(Integer key) {
		Node parent = null;
		Node current = root;
		while (current != null) {
			if(current.key.compareTo(key) < 0) {
				parent = current;
				current = current.right;
			}else if (current.key.compareTo(key) > 0){
				parent = current;
				current = current.left;
			}
		}

		if (parent == null && current == null) {
			this.root = new Node(key);  // no parent = root is empty
			return this.root;
		}else {
			Node newNode = new Node(key);

			if(parent.key.compareTo(key) < 0) {
				parent.right = newNode;
				newNode.parent = parent;
			}else if(parent.key.compareTo(key) > 0) {
				parent.left = newNode;
				newNode.parent = parent;
			}
			return newNode;
		}
	}

	public class Node {

		Integer key;
		Node parent;
		Node left;
		Node right;

		public Node(Integer key) {
			this.key = key;
			this.parent = null;
			this.left = null;
			this.right = null;
		}
	}
}
