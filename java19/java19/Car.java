package java19;

public class Car {
	String color;
	int speed;
	public Car() {
		System.out.println("차 객체 생성...");
	}
	
	public Car(String color, int speed) {
		super();
		this.color = color;
		this.speed = speed;
	}
	
	
}
//자식객체생성시 무조건 부모기본생성자를 호출하게 되어있음(묵시적,자동 호출)
//부모의 파라메터 있는 생성자를 호출하고 싶으면, 수동으로 해줘야한다(명시적,수동 호출)