package dpDfsBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/ Given a collection of numbers
 * that might contain duplicates, return all possible unique permutations.
 * 
 * Example:
 * 
 * Input: [1,1,2] Output: [ [1,1,2], [1,2,1], [2,1,1] ] ]
 */
public class Permutations2 {

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		boolean[] isVisted = new boolean[nums.length];
		backTrack(result, new ArrayList<>(), nums, isVisted);
		return result;
	}

	private static void backTrack(List<List<Integer>> result, List<Integer> tmpResult, int[] nums, boolean[] isVisted) {
		if (tmpResult.size() == nums.length) {
			result.add(new ArrayList<>(tmpResult));
		} else {
			for (int i = 0; i < nums.length; i++) {

				if (isVisted[i] || i > 0 && nums[i] == nums[i - 1] && !isVisted[i - 1]) {
					System.out.println(isVisted[i] + " " + i);
					continue;
				}

				isVisted[i] = true;
				tmpResult.add(nums[i]);
				backTrack(result, tmpResult, nums, isVisted);
				isVisted[i] = false;
				tmpResult.remove(tmpResult.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int nums[] = { 1, 1, 2 };
		List<List<Integer>> permuteUnique = permuteUnique(nums);
		permuteUnique.forEach(k -> {
			k.forEach(System.out::print);
			System.out.println(" ");
		});
	}
}
