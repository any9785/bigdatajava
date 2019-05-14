package 다른패키지;

import 같은패키지.직원;

public class 직원User2 {
	public static void main(String[] args) {
		직원 work2 = new 직원();
		work2.name = "박아무개"; //다른패키지에서는 퍼블릭만보여요.
	}
}
