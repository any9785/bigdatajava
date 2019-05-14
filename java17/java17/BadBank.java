package java17;

public class BadBank extends Bank {
	double rate1 = rate * 10;
	public void getInterestRate() {
		System.out.println("BadBank의 이자율 : " + rate1 + "입니다.");
	}
}
