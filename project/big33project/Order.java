package big33project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 
import com.mysql.jdbc.Driver;
 
public class Order {
public void UpData(String total, String tn) throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/car";
	Connection con = DriverManager.getConnection(url, "root", "1234");
	String sql = "update foodOrder set total = "+ total + " where tn = "+ tn;
	PreparedStatement ps = con.prepareStatement(sql);
	ps.executeUpdate();
	}
}