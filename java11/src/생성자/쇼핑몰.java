package ������;

import java.util.Scanner;

public class ���θ� {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = new String[3];
		int[] age = new int[3];
		String[] tel = new String[3];
		String[] addr = new String[3];
		
		for (int i = 0; i < addr.length; i++) {
		System.out.print("������ �̸�: ");
		name[i] = sc.next();
		System.out.print("������ ����: ");
		age[i] = sc.nextInt();
		System.out.print("������ ��ȭ��ȣ: ");
		tel[i] = sc.next();
		System.out.print("������ �ּ�: ");
		addr[i] = sc.next();
		System.out.println("-------------");
		}
		Member[]m = new Member[3];
		for (int i = 0; i < m.length; i++) {
			m[i] = new Member(name[i], age[i], tel[i], addr[i]);
		}
		System.out.println();
		System.out.println("���θ� ȸ������ ����Դϴ�");
		System.out.println("=======================");
		System.out.println("�̸�      ����       ����ó      �ּ�");
		System.out.println("-----------------------");
		
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i]);
		}
		
	}
	
}
