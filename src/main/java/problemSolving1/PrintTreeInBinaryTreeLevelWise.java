package problemSolving1;

/**
 * Print the nodes in a binary tree level-wise. For example, the following
 * should print 1, 2, 3, 4, 5. 1 / \ 2 3 / \ 4 5
 * 
 * @author Admin
 *
 */
public class PrintTreeInBinaryTreeLevelWise {

	Node root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrintTreeInBinaryTreeLevelWise tree = new PrintTreeInBinaryTreeLevelWise();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.printTree(tree.root, 3);

	}

	public void printTree(Node node, int height) {

		if (node == null) {
			return;
		}

		if (node == root) {
			printSpace(height - 1);
			System.out.println(node.data);
		}

		if (node != root) {
			System.out.print("/");
			printSpace(1);
			System.out.println("\\");
		}

		printTree(node.left, height);
		printTree(node.right, height);
	}

	public void printSpace(int numberOfSpace) {
		for (int i = 1; i <= numberOfSpace; i++) {
			System.out.print(" ");
		}
	}

}

class Node {

	Node(int data) {
		this.data = data;

	}

	Node right, left;
	int data;
}
