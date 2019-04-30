package 부품만들기;

public class 내방 {

	public static void main(String[] args) {
		Phone p1 = new Phone();
		p1.company = "apple";
		p1.shape = "네모모양";
		p1.size = 11;
		
		System.out.println(p1.company);
		System.out.println(p1.shape);
		System.out.println(p1.size);
		p1.call();
		p1.text();
		p1.alarm();
		
		Phone p2 = new Phone();
		p2.company = "Galxey";
		p2.shape = "네모모양";
		p2.size = 10;
		
		System.out.println(p2.company);
		System.out.println(p2.shape);
		System.out.println(p2.size);
		p2.call();
		p2.text();
		p2.alarm();
		
				
		
		System.out.println("----------------");
		
		TV tv1 = new TV();
		tv1.color = "검정색"; //변수
		tv1.power = true;
		tv1.size = 50;
		//System.out.println(tv1.color);
		//System.out.println(tv1.power);
		//System.out.println(tv1.size);
		System.out.println(tv1);
		tv1.changeCh(); //메소드
		tv1.connect();
		tv1.sound();
		System.out.println();
		
		//class를 복사해서 만든 tv2를 객체(대상, object)
		//new의 역할 : 객체 생성
		
		TV tv2 = new TV();
		tv2.color = "빨간색";
		tv2.power = false;
		tv2.size = 30;
		//System.out.println(tv2.color);
		//System.out.println(tv2.power);
		//System.out.println(tv2.size);
		tv1.changeCh();
		tv1.connect();
		tv1.sound();
		
		System.out.println(tv2);
		
		}

}
