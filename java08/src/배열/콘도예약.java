package �迭;

import java.util.Scanner;

public class �ܵ����� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];
		System.out.println("-------------�ܵ� ������ �����մϴ�-------------");
		
		while(true) {
			System.out.println("���ϴ� ������ ��û���ּ���(�� ������ 2����� ��û����)");
			System.out.println("--------------------------------------");
			System.out.println("1)������ 2)���� 3)���� 4)���ֵ� 5)��û��");
			System.out.println("--------------------------------------");
			for (int i = 0; i < 5; i++) {
				System.out.print(num[i] + "        ");
			}
			System.out.println();
			System.out.println("======================================");
			System.out.println("���Ͻô� �����ڵ带 �Է��ϼ���.(�����0)>>");
			int input = sc.nextInt()-1;
			
			if(input>=0 && input<=4) {
				if(num[input]<2) {
					num[input] = num[input]+1;
					System.out.println("��û �����մϴ�.");
					System.out.println("��û�� �Ϸ�Ǿ����ϴ�.");
					System.out.println();
				}else {
					System.out.println("�ο��� �ʰ��Ǿ� ��û�� �Ұ����մϴ�.");
				}
			}else if(input==-1) {
				System.out.println("���α׷� ����"); break;
			}
	}
	}
}
