package cal;

public class ifelse01 {

	public static void main(String[] args) {
		int x = 400;
		int result = x%2;
		
		if(result == 0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}	
			System.out.println("----삼항연산자----");
			
			System.out.println(result == 0? "짝수" : "홀수");
		
	}
}
