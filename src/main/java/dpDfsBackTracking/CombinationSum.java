package dpDfsBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations. Input: candidates = [2,3,6,7],
 * target = 7, A solution set is: [ [7], [2,2,3] ]
 */
public class CombinationSum {

	public static void main(String[] args) {
		int a[] = { 2, 3, 6, 7 };
		int target = 7;
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
			tmpList.add(a[i]);
			backTrackComination(result, tmpList, a, i, target - a[i]); // not i + 1 because we can reuse same elements
			tmpList.remove(tmpList.size() - 1);
		}
	}
}
