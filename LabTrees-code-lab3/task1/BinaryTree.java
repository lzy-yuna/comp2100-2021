/**
 * BinaryTree - this implements a simple binary search tree for storing a set of
 * integers.
 * 
 */

public abstract class BinaryTree <T extends Comparable<T>> {

	public abstract BinaryTree<T> insert(T d); // add an element to the tree, this returns the new/modified tree

	public abstract int size(); // the number of element in the tree

	public abstract int height(); // the height of the tree

	public abstract String preOrderShow(); // show the tree

	public abstract String treeshow(); // print the tree using an ascii drawing 

	public abstract boolean isEmpty(); // check if the tree is empty

	public abstract BinaryTree<T> delete(T d); // remove an element from the tree, this return the new/modified tree

	public abstract T biggest(); // find the biggest element in the tree
	
	public abstract T smallest(); // find the smallest element in the tree
	
	public abstract boolean find(T d); // check if the element is in the tree
}
