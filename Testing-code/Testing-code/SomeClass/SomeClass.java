/**
 * Example class for testing
 */
public class SomeClass {

	/*
	*  Example method for testing	
	*  @param a examble boolean input
	*  @param b examble boolean input
	*  @param c examble boolean input
	*/
	public static void someMethod(boolean a, boolean b, boolean c) {
		if(a) {
			a = true;
		}else { 
			a = false;
			if(b) b=true;
		}
		if(c) a=true;
	}
}