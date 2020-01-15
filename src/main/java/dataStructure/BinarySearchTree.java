package dataStructure;

public class BinarySearchTree {

	Node root;

	public static void main(String[] args) {
		BinarySearchTree searchTree = new BinarySearchTree();
		
		searchTree.insert(2);
		searchTree.insert(4);
		searchTree.insert(7);
		searchTree.insert(5);
		searchTree.insert(9);
		searchTree.insert(8);
		searchTree.displayInOrder();

		System.out.println("Displaying Pre Order");
		searchTree.displayPreOrder();

		searchTree.delete(4);
		System.out.println("After Deletion");
		searchTree.displayInOrder();

		System.out.println("IsvalidTree " + searchTree.isValidBST());

		System.out.println("isValuePresent " + searchTree.isValuePresent(4));

	}

	public void displayPreOrder() {
		printPreOrder(root);
	}

	private void printPreOrder(Node root2) {
		if (root2 != null) {
			System.out.println(root2.value);
			printPreOrder(root2.left);
			printPreOrder(root2.right);
		}
	}

	public boolean isValuePresent(int data) {
		return checkValue(root, data);
	}

	private boolean checkValue(Node root2, int data) {

		if (root2 == null) {
			return false;
		}

		if (root2.value == data) {
			return true;
		}

		if (data < root2.value) {
			return checkValue(root2.left, data);
		}

		return checkValue(root2.right, data);
	}

	public void displayInOrder() {
		printInOrder(root);
	}

	private void printInOrder(Node root2) {
		if (root2 != null) {
			printInOrder(root2.left);
			System.out.println(root2.value);
			printInOrder(root2.right);
		}
	}

	class Node {
		int value;
		int height;
		Node right, left;

		Node(int value) {
			this.value = value;
			this.height = 1;
		}
	}

	public void insert(int value) {
		root = insertValue(root, value);
	}

	public boolean isValidBST() {
		return isValid(root);
	}

	int prevValue = -1;

	private boolean isValid(Node root2) {

		if (root2 == null) {
			return true;
		}

		if (!isValid(root2.left)) {
			return false;
		}

		if (!(prevValue < root2.value)) {
			return false;
		}

		prevValue = root2.value;

		return isValid(root2.right);
	}

	private Node insertValue(Node root2, int value) {

		if (root2 == null) {
			root2 = new Node(value);
			return root2;
		}

		if (value < root2.value) {
			root2.left = insertValue(root2.left, value);
		} else if (value > root2.value) {
			root2.right = insertValue(root2.right, value);
		}
		return root2;
	}

	public void delete(int value) {
		root = deleteValue(root, value);
	}

	private Node deleteValue(Node root, int data) {

		if (root == null) {
			return root;
		}

		if (data < root.value) {
			root.left = deleteValue(root.left, data);
		} else if (data > root.value) {
			root.right = deleteValue(root.right, data);
		} else {

			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				root.value = minValue(root.right);
				root.right = deleteValue(root.right, root.value);
			}
		}
		return root;
	}

	private int minValue(Node node) {
		int minValue = 0;
		while (node != null) {
			minValue = node.value;
			node = node.left;
		}
		return minValue;
	}
}