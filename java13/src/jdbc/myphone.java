package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class myphone {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. ����̹� ���� OK....");
	
		String url = "jdbc:mysql://localhost:3306/myphone";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		DriverManager.getConnection(url, user, password);
		System.out.println("2. DB���� OK...");
		
		String id = JOptionPane.showInputDialog("ID�Է�");
		String pw = JOptionPane.showInputDialog("PW�Է�");
		String name = JOptionPane.showInputDialog("NAME�Է�");
		String tel = JOptionPane.showInputDialog("TEL�Է�");
		String sql = "insert into product values (?, ?, ?, ?)";
		java.sql.PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ps.setString(3, name);
		ps.setString(4, tel);
	
		ps.executeUpdate();
	}


}
