package 배열;

import java.util.Scanner;

public class 동아리문제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = {"김아무개", "박아무개", "송아무개", "정아무개", "장아무개"};
		int[] num = {1, 2, 3, 1, 1};
		char[] grade = {'A', 'B', 'C', 'A', 'B'};
		System.out.println("-----------------------------");
		
		for (int i = 0; i < 5; i++) {
			System.out.println("이름: " + name[i] + ", 학년: " + num[i] + ", 학점: " + grade[i]);
			System.out.println();
			int[] numcount = new int[5]; 
			if(num[i] == 1) {
				numcount[0] += 1;
			}else if(num[i] == 2) {
				numcount[1] += 1;
			}else
				numcount[2] += 1;
		}

	}

}
