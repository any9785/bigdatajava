package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class member {
	Connection con;
	PreparedStatement ps;
	String url;
	String user;
	String password;
	
	public void insert(String meterial, int warehousing, int stock, int warehousingdate) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/pos";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		DriverManager.getConnection(url, user, password);
		
		String sql = "insert into ordertable values (?, ?, ?, ?)";
		java.sql.PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, meterial);
		ps.setInt(2, warehousing);
		ps.setInt(3, stock);
		ps.setInt(4, warehousingdate);
		
		ps.executeUpdate();
	}
}
