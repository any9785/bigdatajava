package �迭;

import java.util.Scanner;

public class ���Ƹ����� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = {"��ƹ���", "�ھƹ���", "�۾ƹ���", "���ƹ���", "��ƹ���"};
		int[] num = {1, 2, 3, 1, 1};
		char[] grade = {'A', 'B', 'C', 'A', 'B'};
		System.out.println("-----------------------------");
		
		for (int i = 0; i < 5; i++) {
			System.out.println("�̸�: " + name[i] + ", �г�: " + num[i] + ", ����: " + grade[i]);
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
