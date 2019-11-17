package problemSolving1;

import java.util.Stack;

public class FindLargestRectangleHistogram {

	public static void main(String[] args) {
		int[] a = { 6, 2, 5, 4, 5, 1, 6 };
		// System.out.println(findRect(a));
		System.out.println(findRectUsingStack(a));
	}

	private static int findRectUsingStack(int[] heights) {
		Stack<Integer> s = new Stack<Integer>();
		int max_area = 0;
		int top_area = 0;

		int i = 0;
		int n = heights.length;

		while (i < n) {

			if (s.isEmpty() || heights[s.peek()] <= heights[i]) {
				s.push(i++);
			} else {
				top_area = heights[s.pop()] * (s.isEmpty() ? i : i - s.peek() - 1);
				max_area = Math.max(top_area, max_area);
			}
		}

		while (!s.isEmpty()) {
			top_area = heights[s.pop()] * (s.isEmpty() ? i : i - s.peek() - 1);
			max_area = Math.max(top_area, max_area);
		}

		return max_area;
	}
}
