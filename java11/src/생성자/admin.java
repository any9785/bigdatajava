package ������;

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
		System.out.println("���� �Է�");
		for (int i = 0; i < mem.length; i++) {
			System.out.print("���̵� : ");
			id = sc.next();
			System.out.print("�н����� : ");
			pw = sc.next();
			System.out.print("��� : ");
			rank = sc.next();
			System.out.print("���ϸ��� : ");
			mile = sc.nextInt();
			System.out.println("--------------");
			mem[i] = new mem(id,pw,rank,mile);
			sum += mem[i].mile;
			aver = sum / mem.length;
		}
		System.out.println(mem[0].id + "�� ��й�ȣ��" + mem[0].pw + " �Դϴ�.");
		System.out.println(mem[1].id + "�� �����" + mem[1].rank + "�̰�, ���ϸ����� " + mem[1].mile + " �Դϴ�");
		System.out.println("�� ���ϸ����� " + sum + " �Դϴ�.");
		System.out.println("����� " + aver + " �Դϴ�.");
	}

}
