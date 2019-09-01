package linkedListProblem;

import dataStructure.LinkedList;
import dataStructure.LinkedList.Node;

public class LinkedListMidValue {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);

		System.out.println(findMidValue(list));
	}

	private static int findMidValue(LinkedList list) {
		Node firstNode = list.root;
		Node secondNode = list.root;

		while (firstNode != null && firstNode.next != null) {
			firstNode = firstNode.next.next;
			secondNode = secondNode.next;
		}

		return secondNode.data;
	}
}
