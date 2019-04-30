package 부품만들기;

public class 계산기 {
	
	//자바는 메소드 이름을 동일하게 할수있다
	//하나의 이름으로 다양한 형태의 기능을 구현하는 기능
	//다형성(overloading)
	//입력값에 사용되는 변수를 매개변수(parameter)
		//add(200,100)
		public int add(int x, int y ) {
			return x + y;
		}
		//add(200, 11.11)
		public void add(int x, double y) {
			System.out.println(x + y);
	}
		//add("홍길동", 1000)
		public void add(String x, int y) {
			System.out.println(x + y);
		}
}
