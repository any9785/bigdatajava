package 배열;

import java.util.Scanner;

public class 데이터입력받아배열에넣기3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//1번 문제
		String[] sub = new String[3];
		for (int i = 0; i < sub.length; i++) {
			System.out.print("과목 입력>>");
			sub[i] = sc.next();
		}
		
		System.out.println("**" + sub[0] + "보다는 " + sub[2] + "**");
		//2번문제
		int[] num = new int[3];
		for (int i = 0; i < num.length; i++) {
			System.out.print("숫자 입력>>");
			num[i] = sc.nextInt();
		}
		int result = num[0] + num[2];
		System.out.println(num[0] +" + " + num[2] + "은 " + result + "입니다." );

	}

}
