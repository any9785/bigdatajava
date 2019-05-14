package 반복문;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("계절[1-4]을 입력하세요=> ");
			int num = sc.nextInt();
			
		if(num == 1 ) {
			System.out.println("봄입니다.");
			break;
		}else if(num == 2 ) {
			System.out.println("여름입니다.");
			break;
		}else if(num == 3 ) {
			System.out.println("가을입니다.");
			break;
		}else if(num == 4){
			System.out.println("겨울입니다.");
			break;
		}
		
		}
		sc.close();
	}
}
