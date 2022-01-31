package hw4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 *
 */
public class Main {

	/**
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {

		BST<String, Integer> bst = new VanillaBST<String, Integer>();

		bst.add("tea", 17);
		bst.add("towel", 24);
		bst.add("juice", 5);
		bst.add("glass", 36);

		// Node<String, Integer> node1=new Node<String, Integer>("g",2,1);
		// Node<String, Integer> node2=new Node<String, Integer>("c",2,1);
		// Node<String, Integer> node3=new Node<String, Integer>("h",2,1);
		// Node<String, Integer> node4=new Node<String, Integer>("a",2,1);
		// Node<String, Integer> node5=new Node<String, Integer>("b",2,1);
		// ArrayList<Node<String, Integer>> list=new ArrayList<>();
		//
		// list.add(node1);
		// list.add(node2);
		// list.add(node3);
		// list.add(node4);
		// list.add(node5);
		//
		// BST<String, Integer> bst = new VanillaBST<String, Integer>(list);

		String selection;
		Scanner input = new Scanner(System.in);
		Scanner in;

		do {// show menu
			System.out.println("Choose from these choices");
			System.out.println("----------------------------\n");
			System.out.println(" 1 - Display");
			System.out.println(" 2 - Add node");
			System.out.println(" 3 - Remove node)");
			System.out.println(" 4 - Get node value");
			System.out.println(" 5 - Update node");
			System.out.println(" 6 - Print Keys");
			System.out.println(" 7 - Print Values");
			System.out.println(" 8 - Minimum Value");
			System.out.println(" 9 - Maximum Value");
			System.out.println("10 - Values less than Key");
			System.out.println("11 - Values greater than Key");
			System.out.println("12 - Size");
			System.out.println("13 - Height");
			System.out.println("14 - Is full Tree?");
			System.out.println("15 - Print BST array");
			System.out.println(" q - Quit");
			System.out.println("----------------------------\n");
			System.out.println("Enter your choice: ");

			selection = input.next();

			String key;
			int value;

			switch (selection) {
			case "1":
				bst.display();
				break;
			case "2":
				in = new Scanner(System.in);
				System.out.println("Enter Key: ");
				key = in.nextLine();
				System.out.println("Enter Value: ");
				value = in.nextInt();
				try {
					bst.add(key, value);
					System.out.println("New node successfully added.");
				} catch (Exception e) {
					System.out.println("Error while adding node!");
				}
				break;
			case "3":
				in = new Scanner(System.in);
				System.out.println("Enter Key: ");
				key = in.nextLine();
				try {
					bst.remove(key);
					System.out.println("Node successfully removed.");
				} catch (Exception e) {
					System.out.println("Error while removing node!");
				}
				break;
			case "4":
				in = new Scanner(System.in);
				System.out.println("Enter Key: ");
				key = in.nextLine();
				System.out.println(bst.get(key));
				break;
			case "5":
				in = new Scanner(System.in);
				System.out.println("Enter Key: ");
				key = in.nextLine();
				System.out.println("Enter Value: ");
				value = in.nextInt();
				try {
					bst.update(key, value);
					System.out.println("Node successfully updated.");
				} catch (Exception e) {
					System.out.println("Error while updating node!");
				}
				break;
			case "6":
				for (String k : bst.keys())
					System.out.print(k + ",");
				System.out.print("\n");
				break;
			case "7":
				for (int v : bst.values())
					System.out.print(v + ",");
				System.out.print("\n");
				break;
			case "8":
				System.out.println(bst.min());
				break;
			case "9":
				System.out.println(bst.max());
				break;
			case "10":
				in = new Scanner(System.in);
				System.out.println("Enter Key: ");
				key = in.nextLine();
				for (int v : bst.lessThan(key))
					System.out.print(v + ",");
				System.out.print("\n");
				break;
			case "11":
				in = new Scanner(System.in);
				System.out.println("Enter Key: ");
				key = in.nextLine();
				for (int v : bst.greaterThan(key))
					System.out.print(v + ",");
				System.out.print("\n");
				break;
			case "12":
				System.out.println(bst.size());
				break;
			case "13":
				System.out.println(bst.height());
				break;
			case "14":
				System.out.println(bst.isFullTree());
				break;
			case "15":
				for (Node<String, Integer> node : bst.generateBSTList())
					if (node == null)
						System.out.println("null");
					else
						System.out.println(node.toString());
				break;
			default:
				break;
			}
		} while (!selection.equals("q"));
		System.exit(0);
	}
}
