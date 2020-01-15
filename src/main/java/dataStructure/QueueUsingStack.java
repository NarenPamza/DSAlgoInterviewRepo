package dataStructure;

//Java Program to implement a queue using one stack 

import java.util.Stack;

public class QueueUsingStack {
	Stack<Integer> stack1 = new Stack<>();

	private void enQueue(int x) {
		stack1.push(x);
	}

	private int deQueue() {
		int x = 0;
		int res = 0;

		// Terminating Condition
		if (stack1.size() == 1) {
			return stack1.pop();
		}

		x = stack1.pop();
		System.out.println("Popped item is " + x);
		res = deQueue();
		System.out.println("pushing item is " + x);
		stack1.push(x);
		return res;
	}

	public static void main(String[] args) {
		QueueUsingStack q = new QueueUsingStack();

		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);

		System.out.print(q.deQueue() + " ");
//		System.out.print(q.deQueue() + " ");
//		System.out.print(q.deQueue() + " ");
	}
}
