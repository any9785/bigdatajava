package ����ƽ;

public class WorkerTest1 {

	public static void main(String[] args) {
		WorkerTest wk1 = new WorkerTest("�Ӿƹ���", "��", 24);
		WorkerTest wk2 = new WorkerTest("��ƹ���", "��", 23);
		WorkerTest wk3 = new WorkerTest("�ھƹ���", "��", 25);
		
		System.out.println("��ü ��������: " + WorkerTest.count);
		System.out.println("�������� ��ճ��̴�: " + wk1.aver());
		System.out.println("��ü ����");
		System.out.println(wk1);
		System.out.println(wk2);
		System.out.println(wk3);
		
		
	}

}
