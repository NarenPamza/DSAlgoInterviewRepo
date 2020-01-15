package dpDfsBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 *
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * Input: [1,2,2] Output: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */
public class SubSet2 {

	public static void main(String[] args) {
		int nums[] = { 1,2,2 };

		List<List<Integer>> subSet = findSubSet(nums);

		subSet.forEach(k -> {
			k.forEach(System.out::print);
			System.out.println(" ");
		});

	}

	private static List<List<Integer>> findSubSet(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backTrack(result, new ArrayList<>(), nums, 0);
		return result;
	}

	private static void backTrack(List<List<Integer>> result, List<Integer> arrayList, int[] nums, int start) {
		result.add(new ArrayList<>(arrayList));

		for (int i = start; i < nums.length; i++) {
			
			if (i == start || nums[i] != nums[i - 1]) { // Skip Duplicates
				arrayList.add(nums[i]);
				backTrack(result, arrayList, nums, i + 1);
				arrayList.remove(arrayList.size() - 1);
			}else {
				System.out.println();
			}
		}
	}
}
