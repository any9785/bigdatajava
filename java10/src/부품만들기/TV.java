package ��ǰ�����;

public class TV {
	
//	TV => class
//			����Ư�� : ������ư����, ������, �� => �ɹ�����
	boolean power;
	int size;
	String color;
//			����Ư�� : ä�κ����ϴ�, �Ҹ��������ϴ�, �迬���ϴ� => �ɹ��޼ҵ�
	public void changeCh() {
		System.out.println("ä�κ����ϴ�");
	}
	public void sound() {
		System.out.println("�Ҹ��� �����ϴ�");
	}
	public void connect() {
		System.out.println("�� �����ϴ�");
	}
	
	public String toString() { 
		//toString() ������ => �θ� ������� �޼ҵ��� ��������� �ٲ㼭 ��� => �������̵�(���)
		//�⺻������:����� , ����������:�ּ����
		return power + " " + size + " " + color;
	}
	
}
