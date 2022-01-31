package hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @param <K>
 *            Key type
 * @param <V>
 *            Value type
 */
public class VanillaBST<K extends Comparable<K>, V> implements BST<K, V> {

	private Node<K, V> root;
	List<Node<K, V>> VanillaBSTList = new ArrayList<Node<K, V>>();

	/**
	 * 
	 */
	public VanillaBST() {
		super();

	}

	/**
	 * @param list
	 *            Node list
	 */
	public VanillaBST(List<Node<K, V>> list) {
		// sort list for balanced BST
		Comparator<Node> nodeComparator = (o1, o2) -> o1.getKey().compareTo(o2.getKey());
		list.sort(nodeComparator);
		sortedListtoBST(list, 0, list.size() - 1);
	}

	@Override
	public void add(K key, V value) {
		root = add(root, key, value);

	}

	public List<Node<K, V>> generateBSTList() {
		//nodes will be added according to their index
		//so list should be initialized(more than 2*max(index)+2
		VanillaBSTList.clear();
		for (int i = 0; i <= 2 * size(); i++)
			VanillaBSTList.add(i, null);
		return generateBSTList(root);
	}

	private List<Node<K, V>> generateBSTList(Node<K, V> node) {
		if (node == null)
			return null;
		//add root
		VanillaBSTList.add(node.getIndex(), node);
		//add left nodes
		generateBSTList(node.getLeft());
		//add right nodes
		generateBSTList(node.getRight());
		return VanillaBSTList;

	}

	private Node<K, V> add(Node<K, V> node, K key, V value) {		
		//if root null new root created
		if (node == null) {			
			Node<K, V> n = new Node<K, V>(key, value, 1);
			n.setIndex(0);
			return n;
		} else {
			int result = key.compareTo(node.getKey());			
			if (result < 0) //if key is smaller add to left
				node.setLeft(add(node.getLeft(), key, value));
			else if (result > 0) //if key is smaller add to right
				node.setRight(add(node.getRight(), key, value));
			else
				node.setValue(value); //if keys equal, value updated
			node.setN(size(node.getLeft()) + size(node.getRight()) + 1);
			return node;
		}
	}

	@Override
	public void display() {
		display(root, false, "");
	}

	private void display(Node<K, V> node, boolean isLeft, String prefix) {
		String prefix_space = "    ";
		if (node != null) {
			if (node == root) {
				// if root node
				System.out.println("Root: " + node.toString());
				prefix_space = "";
			} else
				System.out.println(prefix + (isLeft ? "|--- Left: " : "\\--- Right: ") + node.toString());
			display(node.getLeft(), true, prefix + (isLeft ? "|    " : prefix_space)); //display left nodes
			display(node.getRight(), false, prefix + (isLeft ? "|    " : prefix_space)); //display right nodes

		} else
			// null nodes
			System.out.println(prefix + (isLeft ? "|--- Left: - " : "\\--- Right: -"));
	}

	@Override
	public V get(K key) {
		return get(root, key);
	}

	private V get(Node<K, V> node, K key) {

		if (node == null)
			return null;
		int result = key.compareTo(node.getKey());
		if (result < 0) //if key is smaller
			return get(node.getLeft(), key);
		else if (result > 0) //if key is larger
			return get(node.getRight(), key);
		else
			return node.getValue(); //key found
	}

	@Override
	public List<V> greaterThan(K key) {
		ArrayList<V> result = new ArrayList<V>();
		return greaterThan(root, result, key);
	}

	private List<V> greaterThan(Node<K, V> node, ArrayList<V> list, K key) {
		if (node == null)
			return list;
		int result = key.compareTo(node.getKey());
		if (result < 0) //find greater-right nodes
			lessThan(node.getRight(), list, key);
		else
			list.add(node.getValue());
		return list;
	}

	@Override
	public int height() {
		return height(root);
	}

	private int height(Node<K, V> node) {
		if (node == null)
			return -1;
		return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	}

	@Override
	public boolean isFullTree() {
		return isFullTree(root);
	}

	private boolean isFullTree(Node<K, V> node) {

		if (node == null)
			return true;
		if (node.getLeft() == null && node.getRight() == null) //check if both left and right nodes exist
			return true;
		if (node.getLeft() != null && node.getRight() != null) //if both leaves exist, check them
			return (isFullTree(node.getLeft()) && isFullTree(node.getRight()));
		return false;
	}

	@Override
	public List<K> keys() {
		ArrayList<K> keyList = new ArrayList<K>();
		return keys(root, keyList);
	}

	private List<K> keys(Node<K, V> node, ArrayList<K> keyList) {

		if (node == null)
			return keyList;
		keyList.add(node.getKey()); //add root key
		keys(node.getLeft(), keyList); //add left keys
		keys(node.getRight(), keyList); //add right keys
		return keyList;

	}

	@Override
	public List<V> lessThan(K key) {
		ArrayList<V> result = new ArrayList<V>();
		return lessThan(root, result, key);
	}

	private List<V> lessThan(Node<K, V> node, ArrayList<V> list, K key) {
		if (node == null)
			return list;
		int cmp = key.compareTo(node.getKey());
		if (cmp < 0)
			lessThan(node.getLeft(), list, key); //add left-smaller key's value
		else
			list.add(node.getValue());
		return list;
	}

	@Override
	public V max() {
		return max(root);
	}

	private V max(Node<K, V> node) {
		if (node.getRight() == null)
			return node.getValue();
		return max(node.getRight()); //move to right leaf
	}

	@Override
	public V min() {
		return min(root);
	}

	private V min(Node<K, V> node) {
		if (node.getLeft() == null)
			return node.getValue();
		return min(node.getLeft()); //move to left leaf
	}

	private Node<K, V> minNode(Node<K, V> node) {
		if (node.getLeft() == null)
			return node;
		return minNode(node.getLeft());//move to left
	}

	@Override
	public void remove(K key) {
		root = remove(root, key);
	}

	private Node<K, V> remove(Node<K, V> node, K key) {
		if (node == null)
			return null;
		int result = key.compareTo(node.getKey());
		if (result < 0)//move left to find key
			node.setLeft(remove(node.getLeft(), key));
		else if (result > 0) //move right to find key
			node.setRight(remove(node.getRight(), key));
		else {
			if (node.getRight() == null)
				return node.getLeft();
			if (node.getLeft() == null)
				return node.getRight();
			Node<K, V> n = node; //store existing node
			//find smallest key in the right subtree
			node = minNode(n.getRight());			
			//change the right and left nodes to smallest key
			node.setRight(removeMin(n.getRight()));
			node.setLeft(n.getLeft());
			node.setIndex(n.getIndex());
		}
		node.setN(size(node.getLeft()) + size(node.getRight()) + 1);
		return node;
	}

	private Node<K, V> removeMin(Node<K, V> node) {
		if (node.getLeft() == null)
			return node.getRight();
		node.setLeft(removeMin(node.getLeft()));
		node.setN(size(node.getLeft()) + size(node.getRight()) + 1);
		return node;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node<K, V> node) {
		if (node == null)
			return 0;
		return node.getN();
	}

	private Node<K, V> sortedListtoBST(List<Node<K, V>> list, int start, int end) {

		if (start > end)
			return null;
		// get the middle node to make it root
		int middle = (start + end) / 2;
		Node<K, V> node = list.get(middle);
		node.setIndex(0);
		add(node.getKey(), node.getValue());
		// add left nodes
		node.setLeft(sortedListtoBST(list, start, middle - 1));
		// add right nodes
		node.setRight(sortedListtoBST(list, middle + 1, end));
		return node;
	}

	@Override
	public void update(K key, V value) {
		update(root, key, value);
	}

	private void update(Node<K, V> node, K key, V value) {

		if (node == null)
			return;
		int result = key.compareTo(node.getKey());
		if (result < 0)//move left leaf
			update(node.getLeft(), key, value);
		else if (result > 0)//move right leaf
			update(node.getRight(), key, value);
		else
			node.setValue(value);//change value
	}

	@Override
	public List<V> values() {
		ArrayList<V> valueList = new ArrayList<V>();
		return values(root, valueList);
	}

	private List<V> values(Node<K, V> node, ArrayList<V> valueList) {

		if (node == null)
			return valueList;
		valueList.add(node.getValue());//add root value
		values(node.getLeft(), valueList);//add left leaves value
		values(node.getRight(), valueList);//add right leaves value
		return valueList;
	}
}
