package dataStructure;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Stack {

	int length = 10;

	private int[] value = new int[length];

	int index = -1;

	Stack(int length) {
		this.length = length;
	}

	Stack() {

	}

	public void insert(int data) {

		if (value.length - 1 == index) {
			System.out.println("Stack Overflow");
			return;
		}

		value[++index] = data;
	}

	public void remove() {
		if (index < 0) {
			System.out.println("Stack underflow");
			return;
		}

		value[index--] = 0;
	}

	public void printlist() {
		IntStream.range(0, index).forEach(i -> System.out.println(value[i]));
	}

	public static void main(String[] args) {
		Stack stack = new Stack();

		stack.insert(2);
		stack.insert(5);
		stack.insert(7);

		stack.printlist();
		stack.remove();
		System.out.println("after Removal of top element");
		stack.printlist();
	}

}
