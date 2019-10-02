package dpDfsBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations. Example 1:
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8, A solution set is: [ [1,
 * 7], [1, 2, 5], [2, 6], [1, 1, 6] ] Example 2:
 * 
 * Input: candidates = [2,5,2,1,2], target = 5, A solution set is: [ [1,2,2],
 * [5] ]
 * 
 * @author Admin
 *
 */
public class Combinationsum2 {

	public static void main(String[] args) {
		int a[] = { 2, 5, 2, 1, 2 };
		int target = 5;
		List<List<Integer>> findCombinationSum = findCombinationSum(a, target);
		findCombinationSum.forEach(k -> {
			k.forEach(System.out::print);
			System.out.println(" ");
		});
	}

	private static List<List<Integer>> findCombinationSum(int[] a, int target) {

		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(a);
		backTrackComination(result, new ArrayList<>(), a, 0, target);
		return result;
	}

	private static void backTrackComination(List<List<Integer>> result, List<Integer> tmpList, int[] a, int startIndex,
			int target) {

		if (0 == target) {
			result.add(new ArrayList<>(tmpList));
			return;
		}

		if (target < 0) {
			return;
		}

		for (int i = startIndex; i < a.length; i++) {
			if (i == startIndex || a[i] != a[i - 1]) { // skip duplicates
				tmpList.add(a[i]);
				backTrackComination(result, tmpList, a, i + 1, target - a[i]);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}
}
