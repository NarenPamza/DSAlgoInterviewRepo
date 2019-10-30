package dataStructure;

public class LinkedList {

	public Node root;

	public class Node {
		public int data;

		public Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static Node getIntersectionNode(Node headA, Node headB) {
		Node pa = headA, pb = headB;
		while (pa != pb) {
			pa = (pa != null) ? pa.next : headB;
			pb = (pb != null) ? pb.next : headA;
		}
		return pa;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.root = list.new Node(4);
		Node node1 = list.new Node(10);
		Node node = list.new Node(1);
		Node node2 = list.new Node(5);

		list.root.next = node1;
		list.root.next.next = node;
		list.root.next.next.next = node2;

		// list.remove(5);
		// list.printValues();
		// System.out.println("After Reverse");
		// list.reverse();
		// list.printValues();

		LinkedList list2 = new LinkedList();

		list2.root = list.new Node(7);

		list2.root.next = node;
		list2.root.next.next = node2;

		Node intersectionNode = getIntersectionNode(list.root, list2.root);
		System.out.println(intersectionNode != null ? intersectionNode.data : null);

	}

	public void remove(int data) {

		if (root != null && root.data == data) {
			root = root.next;
			return;
		}

		Node tmp = root;
		Node prevValue = root;
		while (tmp.next != null) {
			prevValue = tmp;
			tmp = tmp.next;
			if (tmp.data == data) {
				break;
			}
		}
		prevValue.next = tmp.next;
	}

	public void reverse() {

		if (root == null && root.next == null) {
			return;
		}

		Node current = root;
		Node prev = null;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		root = prev;
	}

	public void insert(int data) {

		if (root == null) {
			root = new Node(data);
			return;
		}

		Node node = new Node(data);
		Node tmp = root;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = node;
	}

	public void printValues() {

		if (root.next == null) {
			System.out.println(root.data);
			return;
		}

		Node tmp = root;
		while (tmp != null) {
			System.out.print(tmp.data + "->");
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}
