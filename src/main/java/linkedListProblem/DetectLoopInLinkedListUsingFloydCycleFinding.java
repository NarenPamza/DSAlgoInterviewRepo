package linkedListProblem;

import dataStructure.LinkedList;
import dataStructure.LinkedList.Node;

/**
 * Ref
 * https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
 * @author Admin
 *
 */
public class DetectLoopInLinkedListUsingFloydCycleFinding {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(20); 
		list.insert(4); 
		list.insert(15); 
		list.insert(10); 
		
		list.root.next.next.next.next = list.root; 

		System.out.println(detectLoop(list));
	}

	private static boolean detectLoop(LinkedList list) {
		Node firstPointer = list.root;
		Node secondPointer = list.root;

		while (secondPointer != null && secondPointer.next != null && firstPointer.next != null) {
			secondPointer = secondPointer.next.next;
			firstPointer = firstPointer.next;

			if (firstPointer.data == secondPointer.data) {
				return true;
			}
		}
		return false;
	}

}
