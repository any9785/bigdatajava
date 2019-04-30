package 배열;

import java.util.Scanner;

public class 파티참석 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = new String[5];
		int[] num = new int[5];
		
		System.out.println("이름과 나이를 입력하세요.");
		
		for (int i = 0; i < 5; i++) {
			System.out.print("입력>>>>> ");
			name[i] = sc.next();
			num[i] = sc.nextInt();	
		}
		int sum = 0;	
		System.out.println("전체 인원수는 " + name.length + "명");
		System.out.println("파티 참석자 전체 명단입니다.");
		
		for (int i = 0; i < 5; i++) {
			System.out.println("이름은: " + name[i] + ", 나이는: " + num[i]+ "세");
			sum += num[i];
		}
		float avg = sum/num.length;
		System.out.println("파티 참석자 평균 나이는 " + avg + "세 입니다.");

		}

	}


