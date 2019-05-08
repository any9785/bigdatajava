package 스테틱;

public class Clock1 {
	public static void main(String[] args) {
		Clock c1 = new Clock(5000, "시계A", 8 , "AA" );
		Clock c2 = new Clock(6000, "시계B" , 10 , "BB");	
		Clock c3 = new Clock(7000, "시계C", 11, "CC");
		
		System.out.println("가격은 " +  c1.getPrice() + " 회사는 " + c1.getCompany() );
		System.out.println("가격은 " +  c2.getPrice() + " 회사는 " + c2.getCompany() );
		System.out.println("가격은 " +  c3.getPrice() + " 회사는 " + c3.getCompany() );
	}
}
