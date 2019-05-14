package 반복문;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자를 입력하세요.");
		System.out.print("문자 1을 입력 : ");
		String w1 = sc.next();
		
		System.out.print("문자 2을 입력 : ");
		String w2 = sc.next();

		System.out.println("**" + w1 + w2 +"**");
	}

}
