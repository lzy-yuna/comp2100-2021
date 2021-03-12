/**
 * 
 * EmptyBinaryTree - the is the empty tree.  Note it has no fields so all empty trees are the same.  
 * Note I have added a static factory method that just return the same object.  
 * This saves on creating many objects which are all just the same.
 * 
 */

public class EmptyBinaryTree <T extends Comparable<T>> extends BinaryTree <T>  {
	
	public int size() {
		return 0;
	}

	public BinaryTree<T> insert(T data) {
		return new NonEmptyBinaryTree<T>(data);
	}

	@Override
	public int height() {
		return -1;
	}

	@Override
	public String preOrderShow() {
		return "";
	}

	@Override
	public BinaryTree<T> delete(T data) {
		return this;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public T biggest() {
		return null;
	}

	@Override
	public String treeshow() {
		return " ";
	}

	@Override
	public boolean find(T d) {
		return false;
	}

	@Override
	public T smallest() {
		return null;
	}
}
