/**
 * Base class for node
 *
 * @param <T> data type
 */

public class Node<T extends Comparable<T>> {

	Colour colour;			// Node colour
	Interval<T> key; 		// Node key, which is an interval
	Node<T> parent; 		// Parent node
	Node<T> left, right; 	// Child nodes

	public Node(Interval<T> key) {
		this.key  = key;
		this.colour = Colour.RED; //property 3 (if a node is red, both children are black) may be violated if parent is red

		this.parent = null;

		// Initialise children leaf nodes
		this.left 			= new Node<T>();  //leaf node
		this.right 			= new Node<T>();  //leaf node
		this.left.parent 	= this; //reference to parent
		this.right.parent 	= this; //reference to parent
	}

	// Leaf node
	public Node() {
		this.key 	= null; //leaf nodes are null
		this.colour = Colour.BLACK; //leaf nodes are always black
	}

	// For a pair of intervals i1, i2, we write i1 < i2, if
	//(1)	i1. startTime < i2. startTime, or
	//(2)	i1. startTime = i2. startTime, and i1. endTime < i2.endTime
	public static class Interval<T extends Comparable<T>>{
		public final T startTime;
		public final T endTime;
		public Interval(T startTime, T endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
}