package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleGraphProblem {

	public static void main(String[] args) {

		int[][] inputs = { { 0, 1 }, { 3, 1 }, { 1, 3 }, { 3, 2 } };
		System.out.println(canFinish(4, inputs));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean[] result = new boolean[numCourses];
		Map<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
		
		// Construct Adjacency Lists
		for (int[] inputs : prerequisites) {

			if (edges.containsKey(inputs[1])) {
				edges.get(inputs[1]).add(inputs[0]);
			} else {
				List<Integer> neighbours = new ArrayList<Integer>();
				neighbours.add(inputs[0]);
				edges.put(inputs[1], neighbours);
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (dfs(edges, i, result, new ArrayList<Integer>())) {
				return false;
			}
		}

		return true;
	}

	public static boolean dfs(Map<Integer, List<Integer>> edges, int start, boolean[] isVisited,
			List<Integer> visitingList) {
		
		// Finding Cycles
		if (visitingList.contains(start) && start != visitingList.get(visitingList.size() - 1)) {
			return true;
		}

		if (isVisited[start]) {
			return false;
		}

		visitingList.add(start);
		List<Integer> list = edges.get(start);
		if (list != null) {
			for (Integer value : edges.get(start)) {
				if (dfs(edges, value, isVisited, visitingList)) {
					return true;
				}
			}
		}

		visitingList.remove(visitingList.size() - 1);
		isVisited[start] = true;
		return false;
	}
}
