package graph;

import java.util.Arrays;

public class HamAllPaths {
	
	static int[] x;
	
	static int n;
	
	static int G[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		G = new int [][]{ 
				{ 0, 1, 1, 0, 1 }, 
				{ 1, 0, 1, 1, 1 }, 
				{ 1, 1, 0, 1, 0 }, 
				{ 0, 1, 1, 0, 1 },
				{ 1, 1, 0, 1, 0 }, 
		};
		
		int k = 1;
		n = 4;
		x = new int[5];
		x[0] =1;
		
		hamiltonian(k);

	}
	
	static void hamiltonian(int k){
		do {
			nextVertex(k);
			
			if(x[k] == 0){
				return;
			}
			
			if(k == n){
				System.out.println(Arrays.toString(x));
			} else {
				hamiltonian(k+1);
			}
			
		} while (true);
	}
	
	static void nextVertex(int k){
		
		do {
			x[k] = (x[k]+1) % (n+1);
			
			if(x[k] == 0) return;
			
			if(G[x[k-1]][x[k]] != 0){
				for (int j = 1; j < k-1; j++) {
					if(x[j] == x[k]){
						break;
					}
					if(j == k){
						if( (k<n || k ==n) && G[x[n]][x[1]] != 0){
							return;
						}
					}
				}
			}
			
		}while(true);
	}

}
