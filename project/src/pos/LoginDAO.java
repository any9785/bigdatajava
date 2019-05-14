package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class LoginDAO {
   Connection con;
   PreparedStatement ps;
   ResultSet rs;
   String url;
   String user;
   String password;

   public LoginDTO login(String inputid, String inputpw) {
      String password = "";
      LoginDTO dto = new LoginDTO();
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
         rs= ps.executeQuery();
         if(rs.next()){
              password =  rs.getString("inputpw");
              if(password.equals("inputpw")) {
                 x = 1;
                 JOptionPane.showMessageDialog(null, "성공");
                 
              }else {
                 x = 0;
                 JOptionPane.showMessageDialog(null, "실패");
              }
            }else {
               x = -1;
               JOptionPane.showMessageDialog(null, "실패");
            }
            

      } catch (Exception e) {
         e.printStackTrace();
      }
      return dto;
   }

}