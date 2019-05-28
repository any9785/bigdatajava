package string테스트;

import java.util.Random;

public class MathTest {

	public static void main(String[] args) {
		System.out.println(Math.random());
		int num = (int)(Math.random()+10);
		System.out.println(num);
		
		double num2 = 12345.6789;
		System.out.println(Math.ceil(num2)); //반올림하고 소수점삭제
		System.out.println(Math.floor(num2));//내리고 소수점삭제
		System.out.println(Math.round(num2));
		
		final double NUM = 1000;
		//UNM = 2000; 변경불가
		//상수는 한번 넣어두고 변하지 않아야하는 데이터를 넣어둘 때 사용
		//상수는 final 키워드 사용, 들어간 데이터 변경불가
		//일반변수와 비교하기 위해 대문자로 써두는 것이 일반적
		
		int num3 = -100;
		System.out.println(Math.abs(num3));
		
		int num4 = -200;
		System.out.println(Math.max(num3, num4)); 
		System.out.println(Math.min(num3, num4));
		
		int num5 = 3;
		System.out.println(Math.pow(num5, 3)); //제곱값

		Random r = new Random();
		r.setSeed(100); //시드값있으면 동일값, 없으면 랜덤값
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt(100));
		}
		System.out.println(100);
		
	}

}
