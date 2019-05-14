package 배열;

import java.util.Scanner;

public class 학생성적프로그램 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] name = new String[3];
		int[] score = new int[3];
		int[] score1 = new int[3];
		
		
		for (int i = 0; i < 3; i++) {
			System.out.print("학생이름 >>> ");
			name[i] = sc.next();
			System.out.print("학생점수 (자바) >>> ");
			score[i] = sc.nextInt();
			System.out.print("학생점수 (스프링) >>> ");
			score1[i] = sc.nextInt();
		}
		System.out.println("=================================");
		System.out.println("세 학생의 이름은 " + name[0] +", "+name[1]+", "+name[2]+"입니다.");
		System.out.println("=================================");
		int max = score[0];
		String name1 = null;
		for (int i = 0; i < 3; i++) {
			if(max < score[i]) {
				max = score[i];
				name1 = name[i];
			}
		}
	    int min = score1[0];
		String name2 = null;
		for (int i = 0; i < 3; i++) {
			
			if(min > score1[i]) {
				min = score1[i];
				name2 = name[i];
			
			}
		}
			System.out.println("학생 점수 중 제일 높은 자바 점수는 " + max+"("+name1+")"+"입니다");
			System.out.println("학생 점수 중 제일 낮은 스프링 점수는 " + min+"("+name2+")"+"입니다");
		}
	}
	


