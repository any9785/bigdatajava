package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class loginDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String url;
	String user;
	String password;
	boolean ok = false;

	public void login(loginDTO dto) throws Exception {
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		url = "jdbc:mysql://localhost:3306/pos";
		user = "root";
		password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
	}
	public memberDTO select(String inputid, String inputpw)  {
       memberDTO dto = null;
		try {
			int x = -1;
			Class.forName("com.mysql.jdbc.Driver");
			
			url = "jdbc:mysql://localhost:3306/pos";
			user = "root";
			password = "1234";
			
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "select * from member where id = ? pw = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, inputid);
			ps.setString(2, inputpw);
			rs = ps.executeQuery();
			
				 
			if(rs.next()) {
				x=1;
				JOptionPane.showMessageDialog(null, "로그인 완료");
				
			}else {
			    x=-1;
			    JOptionPane.showMessageDialog(null, "아이디와 패스워드를 확인해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
		
		
		
	}
	
 
}

