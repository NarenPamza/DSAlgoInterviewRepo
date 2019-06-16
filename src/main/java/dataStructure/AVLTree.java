package dataStructure;

/*
 * https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 */
public class AVLTree {

	Node root;

	public static void main(String[] args) {
		
		AVLTree tree = new AVLTree(); 
		  
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10); 
        tree.root = tree.insert(tree.root, 20); 
        tree.root = tree.insert(tree.root, 30); 
        tree.root = tree.insert(tree.root, 30); 
        tree.root = tree.insert(tree.root, 40); 
        tree.root = tree.insert(tree.root, 50); 
        tree.root = tree.insert(tree.root, 25); 
  
        /* The constructed AVL Tree would be 
             30 
            /  \ 
          20   40 
         /  \     \ 
        10  25    50 
        */
        System.out.println("Preorder traversal" + 
                        " of constructed AVL tree is : "); 
        tree.preOrder(tree.root); 

	}

	void insert(int data) {
		root = insert(root, data);
	}

	int height(Node node) {
		if (node == null) {
			return 0;
		}

		return node.height;
	}

	int max(int a, int b) {
		return Math.max(a, b);
	}

	int balance(Node n) {
		if (n == null) {
			return 0;
		}

		return height(n.left) - height(n.right);
	}

	int prevData = -1;

	private Node insert(Node root2, int data) {

		if (root2 == null) {
			Node node = new Node(data);
			return node;
		}

		if (data < root2.value) {
			root2.left = insert(root2.left, data);
		}

		else if (data > root2.value) {
			root2.right = insert(root2.right, data);
		} else {
			// Duplicate Keys not allowed
			return root2;
		}

		/* 2. Update height of this ancestor node */
		root2.height = 1 + max(height(root2.left), height(root2.right));

		// 3. Get Balance
		int balance = balance(root2);

		// 4. Check all four cases
		// Left Left Case
		if (balance > 1 && data < root2.left.value) {
			return rightRotate(root2);
		}

		// Right Right Case
		if (balance < -1 && data > root2.right.value) {
			return leftRotate(root2);
		}

		// Left right Case
		if (balance > 1 && data > root2.left.value) {
			root2.left = leftRotate(root2.left);
			return rightRotate(root2);
		}

		// Right Left Case
		if (balance < -1 && data < root2.right.value) {
			root2.right = rightRotate(root2.right);
			return leftRotate(root2);
		}
		return root2;
	}

	Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		// Perform Rotation
		x.right = y;
		y.left = T2;

		// Update Height
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// Return new Root
		return x;
	}

	Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		// Perform Rotation
		y.left = x;
		x.right = T2;

		// Update Height
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// Return new Root
		return y;
	}
	
	void preOrder(Node node) { 
        if (node != null) { 
            System.out.print(node.value + " "); 
            preOrder(node.left); 
            preOrder(node.right); 
        } 
    } 

}
