package ����ƽ;

public class Clock1 {
	public static void main(String[] args) {
		Clock c1 = new Clock(5000, "�ð�A", 8 , "AA" );
		Clock c2 = new Clock(6000, "�ð�B" , 10 , "BB");	
		Clock c3 = new Clock(7000, "�ð�C", 11, "CC");
		
		System.out.println("������ " +  c1.getPrice() + " ȸ��� " + c1.getCompany() );
		System.out.println("������ " +  c2.getPrice() + " ȸ��� " + c2.getCompany() );
		System.out.println("������ " +  c3.getPrice() + " ȸ��� " + c3.getCompany() );
	}
}
