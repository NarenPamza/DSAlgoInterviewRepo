package problemSolving1;
// Java program to detect and remove loop in linked list 

class DetectLoopFromGeekForGeeks { 

	static Node head; 

	static class Node { 

		int data; 
		Node next; 

		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 

	// Function that detects loop in the list 
	void detectAndRemoveLoop(Node node) { 

		// If list is empty or has only one node 
		// without loop 
		if (node == null || node.next == null) 
			return; 

		Node slow = node, fast = node; 

		// Move slow and fast 1 and 2 steps 
		// ahead respectively. 
		slow = slow.next; 
		fast = fast.next.next; 

		// Search for loop using slow and fast pointers 
		while (fast != null && fast.next != null) { 
			if (slow == fast) 
				break; 
			
			slow = slow.next; 
			fast = fast.next.next; 
		} 

		/* If loop exists */
		if (slow == fast) { 
			slow = node; 
			while (slow.next != fast.next) { 
				slow = slow.next; 
				fast = fast.next; 
			} 

			/* since fast->next is the looping point */
			fast.next = null; /* remove loop */
		} 
	} 

	// Function to print the linked list 
	void printList(Node node) { 
		while (node != null) { 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
	} 

	// Driver program to test above functions 
	public static void main(String[] args) { 
		DetectLoopFromGeekForGeeks list = new DetectLoopFromGeekForGeeks(); 
		list.head = new Node(1); 
		list.head.next = new Node(2); 
		list.head.next.next = new Node(3); 
		list.head.next.next.next = new Node(4); 
//		list.head.next.next.next.next = new Node(10); 

		// Creating a loop for testing 
		head.next.next.next.next = list.head.next; 
		list.detectAndRemoveLoop(head); 
		System.out.println("Linked List after removing loop : "); 
		list.printList(head); 
	} 
} 

// This code has been contributed by Mayank Jaiswal 
