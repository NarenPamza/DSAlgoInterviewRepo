package problemSolving;


public class removeDuplicate {

	public static void main(String[] args) {

		int[] a = {1,1,2,2,3,3,3,4,4};
		
		int j = 0;
		for (int i = 1; i < a.length; i++) {
			
			if(a[i] != a[j]){
				a[++j] = a[i];
			}
			
		}
		
		++j;
		
		System.out.println("lenght is " + j);
		
		for (int i = 0; i < j; i++) {
			System.out.println(a[i]);
		}
	}

}
