package problemSolving;

public class TreeSubsetOfTree {

	public static void main(String[] args) {

		TreeNode childRoot = new TreeNode(1);
		childRoot.left = new TreeNode(2);
		childRoot.right = new TreeNode(3);

		TreeNode ParentRoot = new TreeNode(4);
		ParentRoot.left = new TreeNode(1);
		ParentRoot.right = new TreeNode(5);
		ParentRoot.left.left = new TreeNode(2);
		ParentRoot.left.right = new TreeNode(3);

		System.out.println(isSubTree(ParentRoot, childRoot));
	}

	private static boolean isSubTree(TreeNode parentRoot, TreeNode childRoot) {

		if (childRoot == null || parentRoot == null) {
			return false;
		}

		if (isSame(childRoot, parentRoot)) {
			return true;
		}

		return isSubTree(childRoot, parentRoot.right) || isSubTree(childRoot, parentRoot.left);
	}

	private static boolean isSame(TreeNode parentRoot, TreeNode childRoot) {

		if (childRoot == null && parentRoot == null) {
			return true;
		}

		if (childRoot == null || parentRoot == null) {
			return false;
		}
		return childRoot.data == parentRoot.data && isSame(childRoot.left, parentRoot.left)
				&& isSame(childRoot.right, parentRoot.right);
	}
}

class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int value) {
		data = value;
	}
}
