package 부품만들기;

public class TV {
	
//	TV => class
//			정적특성 : 전원버튼유무, 사이즈, 색 => 맴버변수
	boolean power;
	int size;
	String color;
//			동적특성 : 채널변경하다, 소리를조절하다, 잭연결하다 => 맴버메소드
	public void changeCh() {
		System.out.println("채널변경하다");
	}
	public void sound() {
		System.out.println("소리를 조절하다");
	}
	public void connect() {
		System.out.println("잭 연결하다");
	}
	
	public String toString() { 
		//toString() 재정의 => 부모가 상속해준 메소드의 원래기능을 바꿔서 사용 => 오버라이드(덮어씀)
		//기본형변수:값출력 , 참조형변수:주소출력
		return power + " " + size + " " + color;
	}
	
}
