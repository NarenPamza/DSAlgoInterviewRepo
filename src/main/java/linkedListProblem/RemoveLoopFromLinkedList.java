package linkedListProblem;

import dataStructure.LinkedList;
import dataStructure.LinkedList.Node;

public class RemoveLoopFromLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(20);
		list.insert(4);
		list.insert(15);
		list.insert(10);

		list.printValues();

		 list.root.next.next.next.next = list.root;

		if (removeLoop(list)) {
			list.printValues();
		} else {
			System.out.println("No Loop");
		}
	}

	private static boolean removeLoop(LinkedList list) {
		Node firstPointer = list.root;
		Node secondPointer = list.root;
		Node prev = list.root;

		// Loop Detected
		while (secondPointer != null && secondPointer.next != null && firstPointer.next != null) {
			prev = firstPointer;
			secondPointer = secondPointer.next.next;
			firstPointer = firstPointer.next;

			if (firstPointer == secondPointer) {
				break;
			}
		}

		/* If loop exists */
		if (firstPointer == secondPointer) {

			// If its a root node, then
			if (firstPointer == list.root) {
				prev.next = null;
				return true;
			}

			firstPointer = list.root;
			while (firstPointer.next != secondPointer.next) {
				firstPointer = firstPointer.next;
				secondPointer = secondPointer.next;
			}

			/* since fast->next is the looping point */
			secondPointer.next = null; /* remove loop */

			return true;
		}
		return false;
	}
}
