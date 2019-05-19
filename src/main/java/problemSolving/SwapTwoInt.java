package problemSolving;

public class SwapTwoInt {

	public static void main(String[] args) {
		int x = 1280, y = 10;
		x = x ^ y ^ (y = x);
		System.out.println("x: " + x + " ,y: " + y);
	}
}
