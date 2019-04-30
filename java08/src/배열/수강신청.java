package 배열;

import java.util.Scanner;

public class 수강신청 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];
		
		while(true) {
			System.out.println("수강신청을 진행합니다.");
			System.out.println("원하는 과목을 신청해주세요.");
			System.out.println("----------------------------");
			System.out.println("1)자바 2)스프링 3)안드로이드 4)파이썬 5)제이쿼리");
			System.out.println("----------------------------");
		for (int i = 0; i < 5; i++) {
			System.out.print(num[i]+"    ");			
		}
		System.out.println();
		System.out.println("============================");
		System.out.print("원하는 과목코드를 입력해주세요.(종료 0)");
		int input = sc.nextInt();
		if(input == 0) { //0을 입력하면 break
			break;			
		}else if(num[input-1] != 1) {  
			//배열은 0부터시작되므로 input-1 
			System.out.println("신청가능합니다.");
			num[input-1] = 1;
			System.out.println("신청완료되었습니다.");
		}else {
			System.out.println("신청 불가능합니다.");
			System.out.println("다른  코드번호를 입력해주세요.");
		}
	}
		System.out.println("=============================");
		System.out.println("신청을 종료합니다.\n안녕히가세요");
	}
}

