package jdbc;

import java.util.Iterator;

import javax.swing.JOptionPane;

public class �˻�ó��2 {
	
	public static void main(String[] args) throws Exception {
		MemberDAO db = new MemberDAO();
		String id = JOptionPane.showInputDialog("ID�Է�");
		//select * from member where id = ?
		String[] mem = db.insert(id);
		for (String s : mem) {
			JOptionPane.showMessageDialog(null, s);
		}
		
	}

}
