package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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

		System.out.println(findMinHeightTreesUsingQuque(4, inputs2));

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

	public static List<Integer> findMinHeightTreesUsingQuque(int n, int[][] edges) {

		if (n <= 1)
			return Arrays.asList(0);
		Set<Integer>[] adj = new Set[n];
		for (int i = 0; i < n; i++)
			adj[i] = new HashSet<>();
		for (int[] e : edges) {
			adj[e[0]].add(e[1]);
			adj[e[1]].add(e[0]);
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++)
			if (adj[i].size() == 1)
				q.offer(i);

		for (int i = n; i > 2;) { // Don't use q.size() to decide. Wrong!!!
			for (int j = q.size(); j > 0; j--, i--) { // must handle level by
														// level
				int v1 = q.poll();
				int v2 = adj[v1].iterator().next(); // leaf can only have 1
													// parent (tree)
				adj[v2].remove(v1);
				if (adj[v2].size() == 1)
					q.offer(v2);
			}
		}
		return q.size() == 1 ? Arrays.asList(q.poll()) : Arrays.asList(q.poll(), q.poll());

	}
}
