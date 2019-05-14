package 반복문;

import java.util.Scanner;

public class WhileTest4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 수를 입력하세요.");
		System.out.print("숫자1 입력: ");
		int num1 = sc.nextInt();
		System.out.print("숫자2 입력: ");
		int num2 = sc.nextInt();
		
		int sum = 0;
		while(num1 <= num2) {
			
			sum = sum + num1;
			num1++;
			
		}
		System.out.println(sum);
		
		
	}

}
