package linkedListProblem;
/*
 * Reverse Linked List by Group.
 * Reverse first set by Group Size, Skip second group, and reverse third Group
 * 
 * Asked in JP Morgon
 * 
 * i/p -> 1,2,3,4,5,6,7,8,9
 * 0/p -> 3,2,1,4,5,6,9,8,7
 */
public class LinkedListReverseByGroupJP {

	Node root;

	public static void main(String[] args) {

		LinkedListReverseByGroupJP list = new LinkedListReverseByGroupJP();
		list.insert(1);
		list.insert(2);
		list.insert(3);

		list.insert(4);
		list.insert(5);
		list.insert(6);

		list.insert(7);
		list.insert(8);
		list.insert(9);

		list.insert(10);
		list.insert(11);
		list.insert(12);

		list.insert(13);
		list.insert(14);

		// Using Recursion
		list.reverseByEachGroupRecursion(3, list.root, null, true);

		// Using Iterative Approach
		// list.reverseByEachGroupIterative(3, true);
		list.display();

	}

	private void display() {

		Node tmp = root;
		while (tmp != null) {
			System.out.print(tmp.data + ",");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public void insert(int value) {
		Node node = new Node(value);
		if (root == null) {
			root = node;
			return;
		}

		Node tmp = root;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = node;
	}

	/**
	 * Normal Reverse
	 */
	public void reverse() {

		if (root == null) {
			return;
		}

		Node current = root;
		Node prev = null, nextValue = null;
		while (current != null) {
			nextValue = current.next;
			current.next = prev;
			prev = current;
			current = nextValue;
		}
		root = prev;
	}

	public void reverseByEachGroupRecursion(int groupSize, Node startingCurrentNode, Node prevNode, boolean isFirstTime) {

		// Terminating Condition for Recursion
		if (startingCurrentNode == null) {
			return;
		}
		int startIndex = 1;

		// Reverse Logic
		Node current = startingCurrentNode;
		Node prev = null, nextValue = null;
		while (current != null && startIndex <= groupSize) {
			nextValue = current.next;
			current.next = prev;
			prev = current;
			current = nextValue;
			startIndex++;
		}

		if (isFirstTime) {
			root = prev;
		} else {
			if (prevNode != null)
				prevNode.next = prev;
		}

		// After Reverse Linking
		Node tmp = prev;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = current;
		startIndex = 1;

		while (current != null && startIndex <= groupSize) {
			prev = current;
			current = current.next;
			startIndex++;
		}

		reverseByEachGroupRecursion(groupSize, current, prev, false);
	}

	public void reverseByEachGroupIterative(int groupSize, boolean isFirstTime) {

		Node startingCurrentNode = root;
		Node prevNode = null;

		while (startingCurrentNode != null) {
			int startIndex = 1;

			// Reverse Logic
			Node current = startingCurrentNode;
			Node prev = null, nextValue = null;
			while (current != null && startIndex <= groupSize) {
				nextValue = current.next;
				current.next = prev;
				prev = current;
				current = nextValue;
				startIndex++;
			}

			if (isFirstTime) {
				root = prev;
				isFirstTime = false;
			} else {
				if (prevNode != null)
					prevNode.next = prev;
			}

			// After Reverse Linking
			Node tmp = prev;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = current;
			startIndex = 1;

			while (current != null && startIndex <= groupSize) {
				prev = current;
				current = current.next;
				startIndex++;
			}

			startingCurrentNode = current;
			prevNode = prev;
		}
	}

	public class Node {
		public int data;

		public Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
}
