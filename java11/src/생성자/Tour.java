package ������;

public class Tour {

	public static void main(String[] args) {
		Car car1 = new Car();
		car1.color = "������";
		car1.convertible = true;
		System.out.println(car1);
		car1.change();
		int exSpeed = car1.speedUp(100);
		System.out.println(exSpeed + "�� �ӵ��� Up");
		
		System.out.println();
		
		Car car2 = new Car("�Ķ�", false);
		System.out.println(car2);
		System.out.println();
		
		Car car3 = new Car("����");
		System.out.println(car3);
		
		//��ü�� �����ɶ� ����������� �����ϸ� ��
		//��ü ������ �� �ڵ����� ȣ��Ǵ� �޼ҵ�
		//��ü ������ �� �ڵ����� ó���ؾ��ϴ� �κ�
		//��ü ������ �� �ڵ����� ȣ��ȴٰ��ؼ� "������" => ������ = constructor
		//public Ŭ�����̸�()
		//������ �޼ҵ� �̸��� Ŭ�����̸��� �����ؾ��ϰ� �빮�ڷ� ����!
		//������ �޼ҵ�� ��ü������ �ڵ� ȣ��, ������ ����� �ִ�(�����ڿ����ε�) - ������
		//�����ڰ� �ϳ��� ���� ��� �����ڰ� �ڵ����� ���������.
		
	}

}
