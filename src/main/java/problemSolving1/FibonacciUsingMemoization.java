package problemSolving1;

import java.util.ArrayList;
import java.util.List;

/**
 * Ref:
 * https://www.javabrahman.com/gen-java-programs/recursive-fibonacci-in-java-with-memoization/
 * 
 * @author Admin
 *
 */

public class FibonacciUsingMemoization {

	 static List<Long> list = new ArrayList<Long>();

	public static void main(String[] args) {

		String n = "7";

		System.out.println(findFibonnaci(Long.valueOf(n)));

	}

	static long findFibonnaci(long n) {
		list.add(1L);
		list.add(1L);
		return findFibo(n);
	}

	private static long findFibo(long n) {

		if (list.size() > n && list.get((int) n) != null) {
			return list.get((int) n);
		}

		long value = (findFibo(n - 1) + findFibo(n - 2));
		list.add(value);
		return value;

	}
}
