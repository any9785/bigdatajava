package 생성자;

import java.util.Scanner;

public class admin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		mem[] mem = new mem[3];
		String id;
		String pw;
		String rank;
		int mile;
		int sum = 0;
		int aver = 0;
		System.out.println("정보 입력");
		for (int i = 0; i < mem.length; i++) {
			System.out.print("아이디 : ");
			id = sc.next();
			System.out.print("패스워드 : ");
			pw = sc.next();
			System.out.print("등급 : ");
			rank = sc.next();
			System.out.print("마일리지 : ");
			mile = sc.nextInt();
			System.out.println("--------------");
			mem[i] = new mem(id,pw,rank,mile);
			sum += mem[i].mile;
			aver = sum / mem.length;
		}
		System.out.println(mem[0].id + "의 비밀번호는" + mem[0].pw + " 입니다.");
		System.out.println(mem[1].id + "의 등급은" + mem[1].rank + "이고, 마일리지는 " + mem[1].mile + " 입니다");
		System.out.println("총 마일리지는 " + sum + " 입니다.");
		System.out.println("평균은 " + aver + " 입니다.");
	}

}
