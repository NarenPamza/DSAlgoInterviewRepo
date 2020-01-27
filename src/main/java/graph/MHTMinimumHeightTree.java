package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 * 
 * @author Admin
 *
 */
public class MHTMinimumHeightTree {

	public static void main(String[] args) {

		int[][] inputs = {};
		System.out.println(mht(0, inputs));

		int[][] inputs2 = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		System.out.println(mht(4, inputs2));

	}

	public static List<Integer> mht(int n, int[][] edges) {

		if (n == 0) {
			return Arrays.asList();
		}
		if (n == 1) {
			return Arrays.asList(0);
		}

		int[] deg = new int[n];
		int[] graph = new int[n];

		for (int[] e : edges) {
			for (int v : e) {
				++deg[v];
				graph[v] ^= (e[0] == v ? e[1] : e[0]);
			}
		}

		List<Integer> leavesNode = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			if (deg[i] == 1) {
				leavesNode.add(i);
			}
		}

		for (int i = n; i > 2;) {
			i -= leavesNode.size();
			List<Integer> nAns = new ArrayList<>();
			for (int v : leavesNode) {
				graph[graph[v]] ^= v;
				if (--deg[graph[v]] == 1) {
					nAns.add(graph[v]);
				}
			}
			leavesNode = nAns;
		}
		return leavesNode;
	}
}
