package 반복문;

public class WhileTest2 {

	public static void main(String[] args) {

		
		int start = 1;
		int sum = 0;
		while(start <= 10) {//조건식
			//1부터 10까지를 더하기
			sum = sum + start;
			
			start = start + 1; //start++; 증감식
			
		}
		System.out.println(sum);
		
	}

}
