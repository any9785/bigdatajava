package ��ǰ�����;

public class ���� {
	
	//�ڹٴ� �޼ҵ� �̸��� �����ϰ� �Ҽ��ִ�
	//�ϳ��� �̸����� �پ��� ������ ����� �����ϴ� ���
	//������(overloading)
	//�Է°��� ���Ǵ� ������ �Ű�����(parameter)
		//add(200,100)
		public int add(int x, int y ) {
			return x + y;
		}
		//add(200, 11.11)
		public void add(int x, double y) {
			System.out.println(x + y);
	}
		//add("ȫ�浿", 1000)
		public void add(String x, int y) {
			System.out.println(x + y);
		}
}
