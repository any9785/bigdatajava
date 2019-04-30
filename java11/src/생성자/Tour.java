package 생성자;

public class Tour {

	public static void main(String[] args) {
		Car car1 = new Car();
		car1.color = "검정색";
		car1.convertible = true;
		System.out.println(car1);
		car1.change();
		int exSpeed = car1.speedUp(100);
		System.out.println(exSpeed + "로 속도를 Up");
		
		System.out.println();
		
		Car car2 = new Car("파랑", false);
		System.out.println(car2);
		System.out.println();
		
		Car car3 = new Car("빨강");
		System.out.println(car3);
		
		//객체가 생성될때 멤버변수값을 대입하면 됨
		//객체 생성될 때 자동으로 호출되는 메소드
		//객체 생성될 때 자동으로 처리해야하는 부분
		//객체 생성될 때 자동으로 호출된다고해서 "생성자" => 생성자 = constructor
		//public 클래스이름()
		//생성자 메소드 이름은 클래스이름과 동일해야하고 대문자로 시작!
		//생성자 메소드는 객체생성시 자동 호출, 여러개 만들수 있다(생성자오버로딩) - 다형성
		//생성자가 하나도 없는 경우 생성자가 자동으로 만들어진다.
		
	}

}
