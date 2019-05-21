package big33project;


import java.awt.Menu;
import java.sql.*;
public class FoodDAO {
	FoodDTO dto;

	public void update(FoodDTO dto) {
		String url = "jdbc:mysql://localhost:3306/car";
		String user = "root";
		String password = "1234";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			String sql = "update tabledb set count = ? where name = ? && tn = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1,dto.getCount());
			pstmt.setString(2,dto.getName());
			pstmt.setString(3,dto.getTn());
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
 
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
}

	public void finish(FoodDTO dto) {
		String url = "jdbc:mysql://localhost:3306/car";
		String user = "root";
		String password = "1234";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			String sql = "update foodOrder set count = '0' where tn = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTn());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}