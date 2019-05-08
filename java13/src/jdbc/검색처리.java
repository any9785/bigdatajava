package jdbc;

import java.util.Iterator;

import javax.swing.JOptionPane;

public class 검색처리 {
	
	public static void main(String[] args) throws Exception {
		MemberDAO db = new MemberDAO();
		String id = JOptionPane.showInputDialog("ID입력");
		//select * from member where id = ?
		String[] mem = db.select(id);
		for (String s : mem) {
			System.out.println(s);
		}
		
	}

}
