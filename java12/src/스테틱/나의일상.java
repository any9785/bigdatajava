package 스테틱;

public class 나의일상 {

	public static void main(String[] args) {
		Day day1 = new Day("자바공부", 10, "강남");
		System.out.println(Day.count);
		Day day2 = new Day("여행	", 15, "강원도");
		System.out.println(Day.count);
		Day day3 = new Day("운동", 11, "피트니스");
		System.out.println(Day.count);
		
		System.out.println(day1);
		System.out.println(day2);
		System.out.println(day3);
		
		System.out.println();
		System.out.println("전체하는일의 시간은: " + Day.total);
		System.out.println(Day.getTotal());
		System.out.println("평균하는일의 시간은: " + Day.aver);
		System.out.println("몇일간 햇는지?" + Day.count);
	}

}
