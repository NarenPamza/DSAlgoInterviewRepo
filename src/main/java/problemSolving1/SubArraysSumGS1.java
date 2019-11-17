package problemSolving1;

// Java program to find number of subarrays 
// with sum exactly equal to k. 
/**
 * 
 * Given an array of integers and an integer k, 
 * you need to find the total number of continuous subarrays whose sum equals to k.
 * https://leetcode.com/problems/subarray-sum-equals-k/solution/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubArraysSumGS1 {

	/*
	 * Best Approach covering all Scenarios
	 */
	public static int subarraySum(List<Integer> arr, int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (Integer value : arr) {
			sum += value;
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {

		List<Integer> al = new ArrayList<Integer>();
		              
		al.add(4);
		al.add(2);
		al.add(2);
		al.add(2);
		al.add(4);
		al.add(5);
		al.add(1);

		System.out.println(subarraySum(al, 6));
	}
}
