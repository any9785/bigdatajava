package �迭;

import java.util.Scanner;

public class ��ȭ�������α׷� {

	public static void main(String[] args) {
		int[][] seat = new int[3][10];
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println("-------------------");
		System.out.print("  ");
		for (int i = 0; i < 10; i++) {
			System.out.print(i + 1 + " ");
		}
		System.out.println();
		System.out.println("-------------------");
		
		for (int i = 0; i < seat.length; i++) {
			System.out.print(i + 1 + " ");
			for (int j = 0; j < seat[i].length; j++) {
				System.out.print(seat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("����0, ����1>>");
		int end = sc.nextInt();
		if(end ==0) {
			System.out.println("�ý��� ����...");
			break;
			}else {
				System.out.print("�� �Է�: "); //1~3
				int row = sc.nextInt();
				System.out.print("�� �Է�: "); //1~10
				int col = sc.nextInt();
				//������ �Ǿ����� Ȯ��
				if(seat[row-1][col-1] == 0){
					seat[row-1][col-1] = 1;
					System.out.println("���� �Ϸ�.");
				}else {
					System.out.println("������ �̹� �Ϸ�� �ڸ��Դϴ�.");
					System.out.println("�¼��� ���Է����ּ���.");
				}
				//���డ���ϸ�, ����
				//����Ұ����ϸ�, ���Է� �䱸
			}
		}
	}

}
