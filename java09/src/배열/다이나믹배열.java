package �迭;

public class ���̳��͹迭 {

	public static void main(String[] args) { //������ ��ձ��ϱ�
		int num[][] = {
				{44, 55, 66}, //1��
				{77, 88, 99, 100} //2��
		};
		
		int avg = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				avg += num[i][j];
		
			}
			System.out.println(i+1 + "���� �����: " + avg/num[i].length);
			avg = 0;
		}
		

	}

}
