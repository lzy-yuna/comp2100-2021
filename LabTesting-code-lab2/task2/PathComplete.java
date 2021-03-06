public class PathComplete {

	/*
	 * This method finds something!
	 * 
	 */
	public static int findSomething(int a, int b, int c) {
		if(a > b) {
			if(a > c) {
				System.out.println("a");
				return a;
			}else {
				System.out.println("c");
				return c;
			}
		}else if(b > c) { 
			System.out.println("b");
			return b;
		}else {
			System.out.println("c");
			return c;
		}
	}
}
