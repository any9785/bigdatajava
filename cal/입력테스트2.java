package cal;

import java.util.Scanner;

public class 입력테스트2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); //한번만 작성
		
		System.out.print("당신의 태어난 연도는? ");
		int year = sc.nextInt();
		int age = 2019 - year + 1;
		
		System.out.print("당신의 나이는? ");
		String name = sc.next();
		
		System.out.print("당신의 관심과목은? ");
		String title = sc.next();
		
		System.out.println("-----------------------");
		System.out.print(name + "님은 " + age + "살이고," + title +"에 관심있습니다.");
		
		System.out.println("정확한 나이는 " + age);

	}
}
