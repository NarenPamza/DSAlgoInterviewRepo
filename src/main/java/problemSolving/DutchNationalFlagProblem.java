package problemSolving;
import java.util.Arrays;

//Dutch NAtional flag Problem 
public class DutchNationalFlagProblem {
	public static void main(String[] args) {

		int[] a = { 0, 1, 0, 2, 1, 0 };
		int start_index = 0;
		int middle_index = 0;
		int end_index = a.length - 1;
		while (middle_index <= end_index) {
			switch (a[middle_index]) {
			case 0:
				int temp = a[start_index];
				a[start_index] = a[middle_index];
				a[middle_index] = temp;
				start_index++;
				middle_index++;
				break;
			case 1:
				middle_index++;
				break;
			case 2:
				temp = a[middle_index];
				a[middle_index] = a[end_index];
				a[end_index] = temp;
				end_index--;
				break;
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
