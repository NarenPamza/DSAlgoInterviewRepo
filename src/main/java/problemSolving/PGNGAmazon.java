package problemSolving;

import java.util.Stack;

public class PGNGAmazon {

	public static void main(String[] args) {
int a[] = {3,2,8,15,12,20};
findPGAndNg(a);
	}

	private static void findPGAndNg(int[] a) {

		Stack<Integer> pg = new Stack<>();
		Stack<Integer> ng = new Stack<>();
		
		for (int i = 0; i < a.length; i++) {
			
			System.out.println("Current Element is" + a[i]);
			int j = i-1;
			
			if(i == 0){
				System.out.println("PG is -1");
				pg.push(a[i]);
			}
			else {
				
				if(a[j] > a[i]){
					System.out.println("Pg is" + a[j]);
					continue;
				}
				
				else if(!pg.isEmpty() && pg.peek() > a[i]){
					System.out.println("PG is" + pg.peek());
					continue;
				}
				
				j = i-1;
				while(j >= 0){
					if(a[j] > a[i]){
						System.out.println("Pg is" + a[j]);
						pg.push(a[j]);
						break;
					}
					--j;
				}
				
				System.out.println("PG is -1");
				
			}
		}
	}

}
