package ��ǰ�����;

public class �Ž� {

	public static void main(String[] args) {
		Phone p1 = new Phone();
		p1.company = "���";
		p1.shape = "�׸�";
		p1.size = 11;
		
		System.out.println(p1);
		System.out.println("-----------");
		//�޼ҵ� ���鶧 ���ǻ���
		//��ȯ���� ����
		 //���°�� : void / �ִ°��: �ش�Ÿ��, return
		
		//�޼ҵ���(call, �θ���)
		String name = p1.call();
		System.out.println(name + "�� ��ȭ�� �ϴ�");
		System.out.println(p1.call());
		
		//void���� �޼ҵ带 ȣ���Ѱ�쿡�� ���Ϲ��� ���� �����Ƿ� ������ �־��ټ�������, ����Ʈ ���ټ��� ����
		String alarm = p1.alarm();
		System.out.println("�˶��� " + p1.alarm() + "�� ���ߴ�");
		
	}
	

}
