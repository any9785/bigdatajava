package cal;

import java.util.Scanner;

public class me2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("당신의 취미는? ");
		String hobby = sc.next();
		System.out.println("평소 TV시청 시간은 얼마인가요? ");
		int time = sc.nextInt();
		System.out.println("봄여행을 다녀왔나요? "); //예,아니오
		boolean x = sc.nextBoolean();
		System.out.println("---------------");
		
		System.out.println("내 취미는" + hobby + "이고, 평소에 TV를" + time + "도 보지 않아요.\n 봄여행은 x예요." );
		

	}

}
