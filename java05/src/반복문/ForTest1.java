package 반복문;

public class ForTest1 {
    //int test; //전역변수(global)
	public static void main(String[] args) {
//      for(초기값; 조건식; 증감식) {
		
		int sum = 0; // 지역변수(local)
		int start;
		for(start = 1; start <= 10; start++) {
			sum = start + sum;
			
			
		}
		
		System.out.println("1부터 10까지의 합은: " + sum );

	}

}
