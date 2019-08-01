package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class BFSBinaryTree {

	Node root;

	public static void main(String[] args) {
		BFSBinaryTree tree = new BFSBinaryTree();
		tree.createTree();
		
		tree.doBFS();

	}

	public void doBFS() {
		java.util.Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		printBFS(queue);
	}

	private void printBFS(Queue<Node> queue) {
		
		if(queue.isEmpty()){
			return;
		}
		Node top = queue.peek();
		System.out.println(queue.remove().toString());
		
		if(top.left != null)
			queue.add(top.left);
		
		
		if(top.right!= null)
			queue.add(top.right);
		
		
		printBFS(queue);
		
	}

	public void createTree() {

		this.root = new Node("F");
		root.left = new Node("D");
		root.right = new Node("J");

		root.left.left = new Node("B");
		root.left.right = new Node("E");

		root.right.left = new Node("G");
		root.right.right = new Node("K");

	}

	class Node {
		String value;
		Node right, left;

		Node(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.value;
		}
	}

}
