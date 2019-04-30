package 부품만들기;

public class Phone {

		//전화기 => class
		//정적특성 : 모양, 크기, 회사 => 맴버 변수
		String shape;
		int size;
		String company;
		
		//동적특성 : 전화하다, 문자보내다, 알람을맞추다 => 맴버 메소드
		public String call() {
			return "친구";
		}
		public void text() {
			System.out.println("문자하다.");
		}
		public String alarm() {
			return "08:30";
		}
		@Override
		public String toString() {
			return "Phone [shape=" + shape + ", size=" + size + ", company=" + company + "]";
		}
		

}
