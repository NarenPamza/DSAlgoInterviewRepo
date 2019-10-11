package problemSolving;

import java.util.Stack;

/*
 * Ref: https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 */
public class StackToGetMin {

	Stack<Integer> stack ;
	
	private int minElement;
	
	public StackToGetMin() {
		stack = new Stack<Integer>();
	}
	
	public void push(int data){
		
		if(stack.isEmpty()){
			stack.push(data);
			minElement = data;
			return;
		}
		
		if(data < minElement){
			int value = 2*data - minElement;
			minElement = data;
			stack.push(value);
		}else {
			stack.push(data);
		}
	}
	
	public int getMin(){
		System.out.println("Min element is " + minElement);
		return minElement;
	}
	
	public void pop(){
		
		int value = stack.pop();
		if(value < minElement){
			System.out.println("Pop Value is " + minElement);
			minElement = 2*minElement - value;
		}
		else {
			System.out.println(value);
		}
		
	}
	
	public void peek(){
		System.out.println("Top element is " + stack.peek());
		;
	}
	
	public static void main(String[] args) {
		StackToGetMin s = new StackToGetMin();
		
		s.push(2);
		s.push(1);
		s.push(5);
//		s.push(1);
		s.pop();
		s.getMin();
//		s.push(3);
//	    s.push(5);
//	    s.getMin();
//	    s.push(2);
//	    s.push(1);
//	    s.getMin();
//	    s.pop();
//	    s.getMin();
//	    s.pop();
//	    s.peek();
	}
}
