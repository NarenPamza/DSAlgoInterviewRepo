package problemSolving;

public class CanJumpGame {

	public static void main(String[] args) {
		// 0, 1, 2, 3, 4, 5, 6
		int nums[] = { 9, 4, 2, 1, 0, 2, 0 };
		System.out.println(canJump(nums));
		// System.out.println(canJump2(nums));
	}

	public static boolean canJump(int[] nums) {

		int lastPos = nums.length - 1;

		for (int i = nums.length - 1; i >= 0; i--) {

			if (i + nums[i] >= lastPos) {
				lastPos = i;
			}

		}
		return lastPos == 0;
	}

//	public static boolean canJump2(int[] nums) {
//		int n = nums.length;
//		int last = n - 1;
//
//		for (int i = n - 2; i >= 0; i--) {
//			if (i + nums[i] >= last) {
//				last = i;
//			}
//		}
//
//		return last <= 0;
//	}
}
