package 배열;

import java.util.Scanner;

public class 극장예매시스템구현 {

	public static void main(String[] args) {
		int[] seat = new int[10];
		Scanner sc = new Scanner(System.in);
		while(true) {		
		System.out.println("----------------------------------");
		for (int i = 0; i < 10; i++) {
			System.out.print(i + 1 + "  ");
		}
		System.out.println();
		System.out.println("----------------------------------");
		for (int i= 0; i< seat.length; i++) {
			System.out.print(seat[i] + "  ");
		}
		System.out.println();
		System.out.println("==================================");
		System.out.print("종료는 x, 예매는 o >>> ");
		String end = sc.next();
		if(end.equals("x")) {
			System.out.println("예매 시스템을 종료합니다.");
			break;
		}
		System.out.print("예매할 좌석번호 입력 >>> ");
		int input = sc.nextInt();
		if(seat[input - 1] != 1) {
		    seat[input - 1] = 1;//예매처리
		    System.out.println("좌석 예매 완료.!!");
		}else {
			System.out.println("이미 예매된 자석입니다.");
			System.out.println("다른 좌석을 선택해주세요.");
		}
		
		
	 }//while
		
	}

}
