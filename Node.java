package hw4;

/**
 *
 * @param <K>
 *            Key type
 * @param <V>
 *            Value type
 */
public class Node<K extends Comparable<K>, V> {

	private K key;
	private V value;
	private Node<K, V> left, right;
	private int N; // number of nodes in subtree
	private int index;

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @param key
	 *            Key value
	 * @param value
	 *            Value
	 * @param N
	 *            number node
	 */
	public Node(K key, V value, int N) {
		this.key = key;
		this.value = value;
		this.N = N;
	}

	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * @return the left node
	 */
	public Node<K, V> getLeft() {
		return left;
	}

	/**
	 * @return the number of nodes in subtree (root is this)
	 */
	public int getN() {
		return N;
	}

	/**
	 * @return the right node
	 */
	public Node<K, V> getRight() {
		return right;
	}

	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * @param left
	 *            the left node to set
	 */
	public void setLeft(Node<K, V> left) {
		this.left = left;
		left.index=2*index+1;
	}

	/**
	 * @param n
	 *            the n to set
	 */
	public void setN(int n) {
		N = n;
	}

	/**
	 * @param right
	 *            the right node to set
	 */
	public void setRight(Node<K, V> right) {
		this.right = right;
		right.index=2*index+2;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * @return formatted string of node for display
	 */
	@Override
	public String toString() {
		return "(" + key.toString() + ", " + value.toString() + ")";

	}

}
