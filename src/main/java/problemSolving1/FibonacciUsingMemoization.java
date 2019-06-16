package problemSolving1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ref:
 * https://www.javabrahman.com/gen-java-programs/recursive-fibonacci-in-java-with-memoization/
 * @author Admin
 *
 */

public class FibonacciUsingMemoization {

	List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {

		int n = 45;
		FibonacciUsingMemoization fibonacciUsingMemoization = new FibonacciUsingMemoization();
		
		System.out.println(fibonacciUsingMemoization.findFibonnaci(n));
		
		System.out.println(Arrays.toString(fibonacciUsingMemoization.list.toArray()));
	}

	int findFibonnaci(int n) {
		list.add(1);
		list.add(1);
		return findFibo(n);
	}

	private int findFibo(int n) {

		if (list.size() > n && list.get(n) != null) {
			return list.get(n);
		} else {
			int fibValue = findFibo(n - 1) + findFibo(n - 2);
			list.add(fibValue);
			return fibValue;
		}

	}
}
