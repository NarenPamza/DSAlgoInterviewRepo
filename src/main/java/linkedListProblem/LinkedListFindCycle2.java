package linkedListProblem;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 */
public class LinkedListFindCycle2 {

	ListNode root;

	public static void main(String[] args) {

		LinkedListFindCycle2 list = new LinkedListFindCycle2();
		list.root = new ListNode(1);
		list.root.next = new ListNode(2);
		list.root.next.next = new ListNode(3);
		list.root.next.next.next = new ListNode(4);
		list.root.next.next.next.next = new ListNode(5);

		// Create Loop for tEsting
		list.root.next.next.next.next.next = list.root.next;

		System.out.println(list.isLoopExist(list.root));
		System.out.println(list.findCycleStartNode(list.root).value);
	}

	/*
	 * https://leetcode.com/problems/linked-list-cycle/
	 * 
	 * Just to check, if loop exist or not
	 */
	private boolean isLoopExist(ListNode head) {
		boolean result = false;

		ListNode mainNode = head;
		ListNode refNode = head;

		while (mainNode != null && refNode != null && refNode.next != null) {
			mainNode = mainNode.next;
			refNode = refNode.next.next;

			if (mainNode == refNode) {
				return true;
			}
		}

		return result;
	}

	/*
	 * Check Loop Exist and return the Loop Starting Node
	 * https://leetcode.com/problems/linked-list-cycle-ii/
	 */
	private ListNode findCycleStartNode(ListNode head) {

		if (head == null || head.next == null) {
			return null;
		}

		ListNode mainNode = head;
		ListNode refNode = head;

		while (mainNode != null && refNode != null && refNode.next != null) {
			mainNode = mainNode.next;
			refNode = refNode.next.next;

			if (mainNode == refNode) {
				break;
			}
		}

		mainNode = head;
		while (mainNode != null && refNode != null && mainNode.next != refNode.next) {
			mainNode = mainNode.next;
			refNode = refNode.next;
		}

		if (refNode == head) {
			return head;
		}
		return refNode != null ? refNode.next : null;
	}
}

class ListNode {
	ListNode next;

	int value;

	ListNode(int value) {
		this.value = value;
		this.next = null;
	}
}
