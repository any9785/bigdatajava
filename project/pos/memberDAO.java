package pos;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class memberDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String url;
	String user;
	String password;
	boolean ok = false;

	public void member(memberDTO dto) throws Exception {
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		url = "jdbc:mysql://localhost:3306/pos";
		user = "root";
		password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		try {
			
			String sql = "insert into member values (?,?,?,?,?)";
			ps = con.prepareStatement(sql); 
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getBirth());
			ps.setString(5, dto.getTel());
			
			
			int r = ps.executeUpdate();
			if(r>0) {
				JOptionPane.showMessageDialog(null, "가입완료");
				ok = true;
			}else {
				JOptionPane.showMessageDialog(null, "가입불가");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
       
		
	}
	public memberDTO insert(String inputid)  {
       memberDTO dto = null;
		try {
			int x = -1;
			Class.forName("com.mysql.jdbc.Driver");
			
			url = "jdbc:mysql://localhost:3306/pos";
			user = "root";
			password = "1234";
			
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "select * from member where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, inputid);
			rs = ps.executeQuery();
			
				 
			if(rs.next()) {
				x=1;
				JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
				
			}else {
			    x=-1;
				JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
			}
			
		} catch (Exception e) {
		}
		return dto;
		
		
		
	}
	
 
}
