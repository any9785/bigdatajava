package jdbc;

import java.util.Iterator;

import javax.swing.JOptionPane;

public class �˻�ó�� {
	
	public static void main(String[] args) throws Exception {
		MemberDAO db = new MemberDAO();
		String id = JOptionPane.showInputDialog("ID�Է�");
		//select * from member where id = ?
		String[] mem = db.select(id);
		for (String s : mem) {
			System.out.println(s);
		}
		
	}

}
