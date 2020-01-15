package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
	}

	public Node(int _val, List<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
};


/**
 * https://leetcode.com/problems/clone-graph/
 * @author Admin
 *
 */
class CloneGraphProblem {

	public static void main(String[] args) {
		List<Node> list1 = new ArrayList<Node>();
		Node node = new Node(1, list1);

		List<Node> list2 = new ArrayList<Node>();
		Node node2 = new Node(2, list2);

		list1.add(node2);
		list2.add(node);

		new CloneGraphProblem().cloneGraph(node);
	}

	Map<Integer, Node> nodesMap = new HashMap<Integer, Node>();

	public Node cloneGraph(Node node) {
		List<Node> list = null;
		if (nodesMap.containsKey(node.val)) {
			return nodesMap.get(node.val);
		}

		list = new ArrayList<Node>();
		Node clonedNode = new Node(node.val, list);
		nodesMap.put(node.val, clonedNode);
		List<Node> nodes = node.neighbors;
		for (Node subNode : nodes) {
			if (!nodesMap.containsKey(subNode.val)) {
				list.add(cloneGraph(subNode));
			} else {
				list.add(nodesMap.get(subNode.val));
			}
		}
		return clonedNode;
	}
}