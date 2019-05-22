package pos;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class OrderDAO {
	
	public void insert(OrderDTO dto){
		//for (int i = 0; i < array.length; i++) {
			//ArrayList list = new ArrayList();
			String url = "jdbc:mysql://localhost:3306/pos";
			String user = "root";
			String password = "1234";
			Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			String sql = "insert into ordero values (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getNum());
			pstmt.setString(2, dto.getMenu());
			pstmt.setString(3, dto.getAmount());
			pstmt.setString(4, dto.getPrice());
			
			pstmt.executeUpdate();
			
			/*while (rs.next()) {
				dto.setNum(rs.getString(1));
				dto.setMenu(rs.getString(2));
				dto.setAmount(rs.getString(3));
				dto.setPrice(rs.getString(4));
				list.add(dto.getMenu());
			}*/
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void pay() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/pos";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update ordero set menu ='', amount = '', price = '' where num = ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate();

		try {
		con.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, "결제 완료");
	}
}

