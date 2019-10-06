package dpDfsBackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * Input: nums = [1,2,3] Output: [ [],[1],[1,2], [1,2,3], [1,3],[2], [2,3], [3]]
 * 
 * 
 */
public class SubSet {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		permutate(result, new ArrayList<>(), nums, 0);
		return result;
	}

	private static void permutate(List<List<Integer>> result, List<Integer> arrayList, int[] nums, int startIndex) {
		
		result.add(new ArrayList<>(arrayList));
		for (int j = startIndex; j < nums.length; j++) {
			System.out.println("before" + j);
			arrayList.add(nums[j]);
			
			permutate(result, arrayList, nums, j +1);
			System.out.println("after backTracking" + j);
			arrayList.remove(arrayList.size() - 1);
		}
	}

	public static void main(String[] args) {
		int n[] = { 1, 2, 3 };
		List<List<Integer>> subsets = subsets(n);

		subsets.forEach((k) -> {
			k.forEach(System.out::print);
			System.out.println(" ");
		});
	}
}
