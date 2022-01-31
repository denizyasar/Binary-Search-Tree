package hw4;

import java.util.List;

/**
 *
 * @param <K>
 *            Key type
 * @param <V>
 *            Value type
 */
public interface BST<K extends Comparable<K>, V> {
	/**
	 * Add new node to subtree associating key with value.
	 * If same key found, it's updated with the value in parameter.
	 * @param key
	 *            Node key
	 * @param value
	 *            Node value
	 */
	void add(K key, V value);

	/**
	 * Prints the tree to the console
	 */
	void display();

	/**
	 * @param key
	 *            to be found
	 * @return the value associated with key
	 */
	V get(K key);

	/**
	 * @param key of the smallest node to be used
	 *            ​
	 * @return all the values associated with a larger key than ​key
	 */
	List<V> greaterThan(K key);

	/**
	 * @return Returns the maximum number of values that appear between the
root and any leaf (root and leaf are counted as well)
	 */
	int height();

	/**
	 * Determines whether the tree is full
	 * @return True if the tree is full, false otherwise
	 */
	boolean isFullTree();

	/**
	 * @return all the keys in the tree.
	 */
	List<K> keys();

	/**
	 * @param key of the largest node to be used
	 *            ​
	 * @return all the values associated with a smaller key than ​key.
	 */
	List<V> lessThan(K key);

	/**
	 * @return the value associated with the largest key.
	 */
	V max();

	/**
	 * @return the value associated with the smallest key.
	 */
	V min();

	/**
	 * @param key
	 *            to remove from BST
	 */
	void remove(K key);

	/**
	 * @return the number of values (or keys) in the tree
	 */
	int size();

	/**
	 * @param key
	 *            the value that belongs to
	 * @param value
	 *            the new value of the key​
	 */
	void update(K key, V value);

	/**
	 * @return all the values in the tree.
	 */
	List<V> values();
	
	/**
	 * @return ArrayList of BST
	 */
	List<Node<K, V>> generateBSTList();

}
