package problemSolving1;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7,8};
		for (int i = 0, d=2; d < a.length; i++ , d++) {
			
			int temp = a[i];
			a[i] = a[d];
			a[d]= temp;
		}
		
		System.out.println(Arrays.toString(a));

	}

}
