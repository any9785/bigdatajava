package java22;

public class ForTest2 extends Thread {
	
	@Override
	public void run() { //���ÿ� ó���ǰ� �ϰ���� ������ �� �޼ҵ忡 ����
		for (int i = 1; i < 100; i++) {
			System.out.print("��");
		}
	}
}
