

public class TokenizerDemo {
	
	static String text1 = "inc(inc(10));";
	static String text2 = "dec(dec(10));";
	
	public static void main(String[] args) {
		Tokenizer tz = new MySimpleTokenizer(text1);
		
		System.out.println("Tokenizing the first text");
		while(tz.hasNext()) {
			Object token = tz.current();
			System.out.println(token);
			tz.next();
		}
		
		Tokenizer tz2 = new MySimpleTokenizer(text2);
		
		System.out.println("Tokenizing the second text");
		while(tz2.hasNext()) {
			Object token = tz2.current();
			System.out.println(token);
			tz2.next();
		}		
	}

}
