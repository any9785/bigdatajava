package 스테틱;

public class Day {
	
	static int total; // 총시간
	static int aver;
	String doing;     
	int time;
	String location;
	static int count;
	
	public Day() {
	}
	public Day(String doing, int time, String location) {
		this.doing = doing;
		this.time = time;
		this.location = location;
		count++;
		total += time;
		aver = total/3;
	}
	public static int getTotal() {
		return total; 
		//static메소드내에 사용되는 멤버변수는 반드시 static변수만!!
		//객체생성과 상관없이 클래스이름으로 접근가능한 변수
	}
	@Override
	public String toString() {
		return "Day [doing=" + doing + ", time=" + time + ", location=" + location + "]";
	}
}