package �迭;

import java.util.Scanner;

public class ��Ƽ���� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = new String[5];
		int[] num = new int[5];
		
		System.out.println("�̸��� ���̸� �Է��ϼ���.");
		
		for (int i = 0; i < 5; i++) {
			System.out.print("�Է�>>>>> ");
			name[i] = sc.next();
			num[i] = sc.nextInt();	
		}
		int sum = 0;	
		System.out.println("��ü �ο����� " + name.length + "��");
		System.out.println("��Ƽ ������ ��ü ����Դϴ�.");
		
		for (int i = 0; i < 5; i++) {
			System.out.println("�̸���: " + name[i] + ", ���̴�: " + num[i]+ "��");
			sum += num[i];
		}
		float avg = sum/num.length;
		System.out.println("��Ƽ ������ ��� ���̴� " + avg + "�� �Դϴ�.");

		}

	}


