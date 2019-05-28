package string�׽�Ʈ;

import java.util.Random;

public class MathTest {

	public static void main(String[] args) {
		System.out.println(Math.random());
		int num = (int)(Math.random()+10);
		System.out.println(num);
		
		double num2 = 12345.6789;
		System.out.println(Math.ceil(num2)); //�ݿø��ϰ� �Ҽ�������
		System.out.println(Math.floor(num2));//������ �Ҽ�������
		System.out.println(Math.round(num2));
		
		final double NUM = 1000;
		//UNM = 2000; ����Ұ�
		//����� �ѹ� �־�ΰ� ������ �ʾƾ��ϴ� �����͸� �־�� �� ���
		//����� final Ű���� ���, �� ������ ����Ұ�
		//�Ϲݺ����� ���ϱ� ���� �빮�ڷ� ��δ� ���� �Ϲ���
		
		int num3 = -100;
		System.out.println(Math.abs(num3));
		
		int num4 = -200;
		System.out.println(Math.max(num3, num4)); 
		System.out.println(Math.min(num3, num4));
		
		int num5 = 3;
		System.out.println(Math.pow(num5, 3)); //������

		Random r = new Random();
		r.setSeed(100); //�õ尪������ ���ϰ�, ������ ������
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt(100));
		}
		System.out.println(100);
		
	}

}
