package 반복문;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요.");
		System.out.print("숫자 1을 입력 : ");
		int n1 = sc.nextInt();
		
		System.out.print("숫자 2을 입력 : ");
		int n2 = sc.nextInt();
		
		System.out.print("숫자 3을 입력 : ");
		int n3 = sc.nextInt();
		
		int sum = n1 + n2 + n3;

		System.out.println("세개의 수를 더한 수는 " + sum +"입니다.");
	}

}
