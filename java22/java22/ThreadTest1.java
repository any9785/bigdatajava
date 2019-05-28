package java22;

public class ThreadTest1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Áõ°¡ :" + i);
		}
	}
}
