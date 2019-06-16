package dataStructure;

public class LinkedList {
	
	public Node root;
	
	public class Node {
		public int data;
		
		public Node next;
		
		public Node(int data){
			this.data = data;
			next = null;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(5);
		list.insert(6);
		list.insert(9);
		list.insert(7);
		
		list.remove(5);
		list.printValues();
		System.out.println("After Reverse");
		list.reverse();
		list.printValues();

	}
	
	public void remove(int data){
		
		if(root!= null && root.data == data){
			root = root.next;
			return;
		}
		
		Node tmp = root;
		Node prevValue = root;
		while(tmp.next != null){
			prevValue = tmp;
			tmp = tmp.next;
			if(tmp.data == data){
				break;
			}
		}
		prevValue.next = tmp.next;
	}
	
	public void reverse(){
		if(root != null && root.next == null){
			return;
		}
		
		Node current = root;
		Node prev = null,nextValue = null;
		while(current != null){
			nextValue = current.next;
			current.next = prev;
			prev = current;
			current = nextValue;
		}
		root = prev;
	}
	
	public void insert(int data){
		
		if(root == null){
			root = new Node(data);
			return;
		}
		
		Node node = new Node(data);
		Node tmp = root;
		while(tmp.next != null){
			tmp = tmp.next;
		}
		tmp.next = node;
	}
	
	public void printValues(){
		
		if(root.next == null){
			System.out.println(root.data);
			return;
		}
		
		Node tmp = root;
		while(tmp != null){
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
}
