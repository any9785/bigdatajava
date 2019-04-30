package 생성자;

import java.util.Scanner;

public class 쇼핑몰 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = new String[3];
		int[] age = new int[3];
		String[] tel = new String[3];
		String[] addr = new String[3];
		
		for (int i = 0; i < addr.length; i++) {
		System.out.print("가입할 이름: ");
		name[i] = sc.next();
		System.out.print("가입할 나이: ");
		age[i] = sc.nextInt();
		System.out.print("가입할 전화번호: ");
		tel[i] = sc.next();
		System.out.print("가입할 주소: ");
		addr[i] = sc.next();
		System.out.println("-------------");
		}
		Member[]m = new Member[3];
		for (int i = 0; i < m.length; i++) {
			m[i] = new Member(name[i], age[i], tel[i], addr[i]);
		}
		System.out.println();
		System.out.println("쇼핑몰 회원가입 명단입니다");
		System.out.println("=======================");
		System.out.println("이름      나이       연락처      주소");
		System.out.println("-----------------------");
		
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i]);
		}
		
	}
	
}
