package dataStructure;

public class BinarySearchTree {
	
	Node root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Node {
		int value;
		Node right,left;
		
		Node(int value){
			this.value = value;
		}
	}
	
	public void insertRec(int value){
		root = insert(root, value);
	}
	
	public boolean isValidBST(){
		return isValid(root);
	}

	int prevValue = -1;
	private boolean isValid(Node root2) {
		
		if(root2 == null){
			return true;
		}
		
		if(!isValid(root2.left)){
			return false;
		}
		
		if(!(prevValue < root2.value)){
			return false;
		}
		
		prevValue = root2.value;
		
		return isValid(root2.right);
	}

	private Node insert(Node root2, int value) {
		
		if(root2 == null){
			root2 = new Node(value);
			return root2;
		}
		
		if(value < root2.value){
			root2.left = insert(root2.left, value);
		} else if(value > root2.value){
			root2.right = insert(root2.right, value);
		}
		return root2;
	}
}
