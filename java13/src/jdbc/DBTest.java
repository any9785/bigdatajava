package jdbc;

import java.sql.*; //전체 임포트

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

public class DBTest {
	public static void main(String[] args) throws Exception {
	//JDBC
	//java --Connector(Driver)--DBMS
		//1. 드라이버 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버 설정 OK....");
		
		//2. DB연결(DB명, id, pw)
		String url = "jdbc:mysql://localhost:3306/bigdata";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		DriverManager.getConnection(url, user, password);
		System.out.println("2. DB연결 OK...");
		
		//3. SQL결정
		String sql = "insert into member values ('win', 'win', 'win', 'win')";
		java.sql.PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 결정 OK...");
		
		//객체화
		//String url = "http://www.naver.com";
		//URL url2 = new URL(url);
		
		//4. SQL전송	
		ps.executeUpdate();
		System.out.println("4, SQL문 전송 OK...");
	}


}
