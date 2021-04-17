package linkedListProblem;

public class LinkedListReverseAddition {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.value : 0;
			int y = (q != null) ? q.value : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;

	}

	public static void main(String[] args) {

		ListNode L1 = new ListNode(2);
		L1.next = new ListNode(9);

		ListNode L2 = new ListNode(5);
		L2.next = new ListNode(7);

		ListNode addTwoNumbers = new LinkedListReverseAddition().addTwoNumbers(L1, L2);

		while (addTwoNumbers != null) {
			System.out.println(addTwoNumbers.value);
			addTwoNumbers = addTwoNumbers.next;
		}
	}
}
