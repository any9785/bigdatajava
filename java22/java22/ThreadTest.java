package java22;

public class ThreadTest {

	public static void main(String[] args) {
		ThreadTest1 h1 = new ThreadTest1(); //������ ��ü ����
		ThreadTest2 h2 = new ThreadTest2();
			
		h1.start();
		h2.start();
		
		
	}
	

}
