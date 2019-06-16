package problemSolving1;

import dataStructure.LinkedList;
import dataStructure.LinkedList.Node;

public class RemoveLoopFromLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list = new LinkedList();
		list.insert(20);
		list.insert(4);
		list.insert(15);
		list.insert(10);

		list.root.next.next.next.next = list.root;
		// list.root.next.next.next = list.root.next;

		if (removeLoop(list)) {
			list.printValues();
		} else {
			System.out.println("No Loop");
		}

		// detectLoop(list);

	}

	private static boolean removeLoop(LinkedList list) {
		Node firstPointer = list.root;
		Node secondPointer = list.root;
		Node prev = list.root;

		while (secondPointer != null && secondPointer.next != null && firstPointer.next != null) {
			prev = firstPointer;
			secondPointer = secondPointer.next.next;
			firstPointer = firstPointer.next;

			System.out
					.println("First Pointer Value" + firstPointer.data + " Second Pointer Value " + secondPointer.data);

			if (firstPointer.data == secondPointer.data) {

//				if (firstPointer == list.root) {
//					prev.next = null;
//				} else {
//					firstPointer.next = null;
//				}

//				return true;
				break;
			}
		}
		
		/* If loop exists */
        if (firstPointer == secondPointer) { 
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

	static int detectLoop(LinkedList list) {
		Node slow_p = list.root, fast_p = list.root;
		while (slow_p != null && fast_p != null && fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;

			System.out.println("First Pointer Value" + slow_p.data + " Second Pointer Value " + fast_p.data);
			if (slow_p == fast_p) {
				System.out.println("Found loop");
				return 1;
			}
		}
		return 0;
	}
}
