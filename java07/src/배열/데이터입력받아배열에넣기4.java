package 배열;

import java.util.Scanner;

public class 데이터입력받아배열에넣기4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int[] grade = new int[5];
		int sum = 0;
		for (int i = 0; i < grade.length; i++) {
			System.out.print("성적 입력>> ");
			grade[i] = sc.nextInt();
			sum = sum + grade[i];
		
		}
		System.out.println("평균 성적은 " + 
		          (sum/grade.length) +"입니다.");
	}

}
