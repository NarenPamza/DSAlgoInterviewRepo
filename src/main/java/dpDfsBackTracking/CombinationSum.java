package dpDfsBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {

		int[] candidates = { 1, 1, 2, 5, 6, 7, 10 };
		int target = 8;
		List<List<Integer>> combinationSum2 = combinationSum2(candidates, target);

		combinationSum2.forEach((k) -> {
			k.forEach(System.out::print);
			System.out.println(" ");
		});

	}

	private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> combinationSum2 = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		dfs_sum(candidates, 0, target, path, combinationSum2);
		return combinationSum2;
	}

	private static void dfs_sum(int[] candidates, int index, int target, List<Integer> current,
			List<List<Integer>> res) {  
		if (target == 0) {
			System.out.println("Over with " + Arrays.toString(current.toArray()));
			res.add(new ArrayList<>(current));
			return;
		}

		if (target < 0) {
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			System.out.println(i);
			if (i == index || candidates[i] != candidates[i - 1]) {
				current.add(candidates[i]);
				dfs_sum(candidates, i + 1, target - candidates[i], current, res);
				current.remove(current.size() - 1);
			}
		}
	}
}
