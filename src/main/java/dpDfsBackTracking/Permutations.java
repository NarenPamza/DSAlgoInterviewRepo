package dpDfsBackTracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			System.out.println(" Over with " + Arrays.toString(tempList.toArray()));
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				System.out.println(i);
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				tempList.add(nums[i]);
				
				backtrack(list, tempList, nums);
				System.out.println("Removing last value for i " + i);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {

		int a[] = { 1, 2, 3 };
		List<List<Integer>> permutationList = permute(a);

		permutationList.forEach((k) -> {
			k.forEach(System.out::print);
			System.out.println(" ");
		});

	}
}