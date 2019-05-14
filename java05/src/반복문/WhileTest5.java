package 반복문;

import java.util.Scanner;

public class WhileTest5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 수를 입력하세요.");
		System.out.print("숫자1 입력: ");
		int num1 = sc.nextInt();
		System.out.print("숫자2 입력: ");
		int num2 = sc.nextInt();
		
		int mul = 1;
		while(num1 <= num2) {
			mul = num1 * mul;
			num1++;
			
		}
		System.out.println(mul);
	}

}
