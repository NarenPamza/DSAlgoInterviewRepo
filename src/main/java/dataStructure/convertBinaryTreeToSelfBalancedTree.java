package dataStructure;

import java.util.Vector;

/*
 * https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
 */
public class convertBinaryTreeToSelfBalancedTree {

	Node root;

	public static void main(String[] args) {

		convertBinaryTreeToSelfBalancedTree tree = new convertBinaryTreeToSelfBalancedTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(7);
		tree.root.left.left.left = new Node(6);
		tree.root.left.left.left.left = new Node(5);

		tree.root = tree.buildTree(tree.root);
		System.out.println("Preorder traversal of balanced BST is :");
		tree.preOrder(tree.root);

	}

	private void preOrder(Node root2) {
		if (root2 != null) {
			System.out.println(root2.value);
			preOrder(root2.left);
			preOrder(root2.right);
		}

	}

	private Node buildTree(Node root2) {

		Vector<Node> nodes = new Vector<Node>();
		addInOrder(root2, nodes);

		return balanceTree(nodes, 0, nodes.size() - 1);
	}

	private Node balanceTree(Vector<Node> nodes, int start, int end) {

		if (start > end) {
			return null;
		}
		int mid = (end + start) / 2;
		Node node = nodes.get(mid);

		node.left = balanceTree(nodes, start, mid - 1);
		node.right = balanceTree(nodes, mid + 1, end);
		return node;
	}

	private void addInOrder(Node root2, Vector<Node> nodes) {

		if (root2 != null) {
			addInOrder(root2.left, nodes);
			nodes.addElement(root2);
			addInOrder(root2.right, nodes);
		}
	}
}

class Node {
	int value;
	int height;
	Node right, left;

	public Node(int value) {
		this.value = value;
		this.height = 1;
	}
}
