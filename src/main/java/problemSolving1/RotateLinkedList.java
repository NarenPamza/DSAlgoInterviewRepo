package problemSolving1;

import dataStructure.LinkedList;
import dataStructure.LinkedList.Node;

/**
 * Ref:
 * https://www.geeksforgeeks.org/rotate-a-linked-list/
 * @author Admin
 *
 */
public class RotateLinkedList {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		list.insert(9);

		rotateList(list, 4);

		list.printValues();
	}

	private static void rotateList(LinkedList list, int k) {

		Node tmp = list.root;
		int i = 1;
		Node newHead = null;
		Node prev = null;
		while (tmp.next != null) {
			if (i == k) {
				prev = tmp;
				newHead = tmp.next;
			}
			i++;
			tmp = tmp.next;
		}
		prev.next = null;
		tmp.next = list.root;
		list.root = newHead;

	}
}
