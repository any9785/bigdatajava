package jdbc;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class DB입력 {
	public static void main(String[] args) {
		String id = JOptionPane.showInputDialog("ID입력");
		String pw = JOptionPane.showInputDialog("PW입력");
		String name = JOptionPane.showInputDialog("NAME입력");
		String tel = JOptionPane.showInputDialog("TEL입력");
		
		MemberDAO db = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setTel(tel);
		
		try {
			db.insert(dto);
		} catch (Exception e) {
			System.out.println("에러발생!! 에러발생!!");
			e.printStackTrace(); //에러정보찍을수있는 메소드
		}
		
		
	}
}
