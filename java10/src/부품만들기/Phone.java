package ��ǰ�����;

public class Phone {

		//��ȭ�� => class
		//����Ư�� : ���, ũ��, ȸ�� => �ɹ� ����
		String shape;
		int size;
		String company;
		
		//����Ư�� : ��ȭ�ϴ�, ���ں�����, �˶������ߴ� => �ɹ� �޼ҵ�
		public String call() {
			return "ģ��";
		}
		public void text() {
			System.out.println("�����ϴ�.");
		}
		public String alarm() {
			return "08:30";
		}
		@Override
		public String toString() {
			return "Phone [shape=" + shape + ", size=" + size + ", company=" + company + "]";
		}
		

}
