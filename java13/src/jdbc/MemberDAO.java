package jdbc;

import java.sql.*; //��ü ����Ʈ

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;

public class MemberDAO {
	//�������
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String url;
	String user;
	String password;
	
	//Member DAO
	//����޼ҵ�
	public  void insert(MemberDTO dto) throws Exception {
		
		//1. ����̹� ����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. DB����(DB��, id, pw)
		url = "jdbc:mysql://localhost:3306/bigdata";
		user = "root";
		password = "1234";
		con = DriverManager.getConnection(url, user, password);
		DriverManager.getConnection(url, user, password);
		
		//3. SQL����
		String sql = "insert into member values (?, ?, ?, ?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPw());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getTel());
		
		ps.executeUpdate();
		
		//4. SQL����	
		//rs = ps.executeQuery();
		//String[] mem = null;
		//if(rs.next()) { //���ڵ�����
			//mem = new String[4];
			//String s1 = rs.getString(1); //id
			//String s2 = rs.getString(2); //pw
			//String s3 = rs.getString(3); //name
			//String s4 = rs.getString(4); //tel
			//mem[0] = s1;
			//mem[1] = s2;
			//mem[2] = s3;
			//mem[3] = s4;
			//System.out.println("�˻��� ID: " + s1 );
			//System.out.println("�˻��� PW: " + s2 );
			//System.out.println("�˻��� NAME: " + s3 );
			//System.out.println("�˻��� TEL: " + s4 );
		//}else { //���ڵ� ����X
		//}
		//return mem;
	}	

}
