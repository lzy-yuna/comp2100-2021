import org.junit.Test;

public class TestTimeout {
	
	@Test(timeout=1000)//change to 1 ms to fail this test
	public void testTimeout(){
		int sum = 0;
		for(int i =0; i<1000000; i++)
			sum +=i;
	
		System.out.println("Total is: " + sum);
	}
	

}
