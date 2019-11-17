package problemSolving1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * [10, 15, 3, 7] and k of 17
 * 
 * 10 + 7 = 17 return true
 * 
 * @author Admin
 */
public class AddTwoSumToK {

	public static void main(String[] args) {

		int[] a = {10, 12, 10, 15, -1, 7, 6, 
                5, 4, 2, 1, 1, 1};

		int k = 11;

		//System.out.println(Arrays.toString(findTwoSum(a, k)));
		//System.out.println(hasArrayTwoCandidates(a, a.length, k));
		
		System.out.println(findTwoPairsEqualsToKCount(a, k));
	}

	static int findTwoPairsEqualsToKCount(int[] a, int k) {
		int count = 0;
		
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if(map.containsKey(k -a[i])){
				count++;
			}else {
				map.put(a[i], 0);
			}
		}

		return count;
	}

	static boolean hasArrayTwoCandidates(int A[], int arr_size, int sum) {
		int l, r;

		/* Sort the elements */
		Arrays.sort(A);

		/*
		 * Now look for the two candidates in the sorted array
		 */
		l = 0;
		r = arr_size - 1;
		while (l < r) {
			if (A[l] + A[r] == sum)
				return true;
			else if (A[l] + A[r] < sum)
				l++;
			else // A[i] + A[j] > sum
				r--;
		}
		return false;
	}

	private static int[] findTwoSum(int[] nums, int target) {

		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int tmp = target - nums[i];
			if (map.containsKey(tmp)) {
				result[0] = map.get(tmp);
				result[1] = i;
			}
			map.put(nums[i], i);
		}
		return result;
	}
}
