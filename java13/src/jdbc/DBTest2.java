package jdbc;

import java.sql.*; //��ü ����Ʈ

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class DBTest2 {
	public static void main(String[] args) throws Exception {
	//JDBC
	//java --Connector(Driver)--DBMS
		//1. ����̹� ����
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. ����̹� ���� OK....");
		
		//2. DB����(DB��, id, pw)
		String url = "jdbc:mysql://localhost:3306/bigdata";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		DriverManager.getConnection(url, user, password);
		System.out.println("2. DB���� OK...");
		
		//3. SQL����
		String id = JOptionPane.showInputDialog("ID�Է�");
		String title = JOptionPane.showInputDialog("TITLE�Է�");
		String price = JOptionPane.showInputDialog("PRICE�Է�");
		String company = JOptionPane.showInputDialog("COMPANY�Է�");
		//String sql = "insert into member values ('" + id + "' ,'" + pw + "','" + name + "','" + tel + "')";
		String sql = "insert into member values (?, ?, ?, ?)";
		java.sql.PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, title);
		ps.setString(3, price);
		ps.setString(4, company);
		System.out.println("3. SQL�� ���� OK...");
		
		//��üȭ
		//String url = "http://www.naver.com";
		//URL url2 = new URL(url);
		
		//4. SQL����	
		ps.executeUpdate();
		System.out.println("4, SQL�� ���� OK...");
	}


}
