package java22;

public class ThreadTest {

	public static void main(String[] args) {
		ThreadTest1 h1 = new ThreadTest1(); //스레드 객체 생성
		ThreadTest2 h2 = new ThreadTest2();
			
		h1.start();
		h2.start();
		
		
	}
	

}
