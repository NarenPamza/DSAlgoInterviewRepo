package linkedListProblem;

import dataStructure.LinkedList;
import dataStructure.LinkedList.Node;

public class LinkedListNthNodeFromEnd {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();	
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		
		int n = 2;
		findNthNode(list,n);
	}

	private static void findNthNode(LinkedList list, int n) {
		Node mainPointer = list.root;
		Node refPointer = list.root;
		
		int i = 1;
		while(refPointer.next != null){
			if(i ==n){
				break;
			}
			i++;
			refPointer = refPointer.next;
		}
		
		while(refPointer.next != null){
			mainPointer = mainPointer.next;
			refPointer = refPointer.next;
		}
		
		System.out.println(mainPointer.data);
	}
}
