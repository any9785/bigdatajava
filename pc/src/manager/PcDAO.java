package manager;

import java.sql.*;
import java.util.ArrayList;
import com.mysql.jdbc.ResultSetMetaData;

public class PcDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String url;
	String user;
	String password;
	static PcDTO dto;
	
   public boolean Pcmanager(PcDTO dto) {
	   
	   boolean ok = false;
	   try {
    	  
    	  Class.forName("com.mysql.jdbc.Driver");

    	  url = "jdbc:mysql://localhost:3306/pc";
    	  user = "root";
    	  password = "1234";
    	  
    	  con = DriverManager.getConnection(url, user, password);
    	  String sql = "insert into member values(?,?,?,?)";
    	  ps = con.prepareStatement(sql);
    	  
    	  ps.setString(1,dto.getId());
    	  ps.setString(2,dto.getName());
    	  ps.setString(3,dto.getAge());
    	  ps.setString(4,dto.getTel());
    	  ps.executeUpdate();
      }
      catch(Exception e) {
    	  e.printStackTrace();
      }
	   return ok;
}
   
   public boolean deletePcManager(String id) {
	   boolean ok = false;
	   
	   try {
	    	  
	    	  Class.forName("com.mysql.jdbc.Driver");

	    	  url = "jdbc:mysql://localhost:3306/pc";
	    	  user = "root";
	    	  password = "1234";
	    	  
	    	  con = DriverManager.getConnection(url, user, password);
	    	  String sql = "delete from member where id=?";
	    	  ps = con.prepareStatement(sql);
	    	  
	    	  ps.setString(1, id);
	    	  ps.executeUpdate();
	      }
	      catch(Exception e) {
	    	  e.printStackTrace();
	      }
		   return ok;
   }
   
   public boolean updatePcManager(PcDTO dto) {
	   
	   boolean ok = false;

	   try{
    	   Class.forName("com.mysql.jdbc.Driver");

	    	  url = "jdbc:mysql://localhost:3306/pc";
	    	  user = "root";
	    	  password = "1234";
	    	  
           con = DriverManager.getConnection(url, user, password);           
           String sql = "update member set tel=? where id=?";
          
           ps = con.prepareStatement(sql);
          
           ps.setString(1, dto.getTel());
           ps.setString(2, dto.getId());
         
          
           ps.executeUpdate();
   }
       catch(Exception e) {
    	   e.printStackTrace();
       }
       return ok;
 }
   
   public PcDTO select(String inputId) {
	   PcDTO dto = null;
	   
	   try {
		   Class.forName("com.mysql.jdbc.Driver");
		   
		   url = "jdbc:mysql://localhost:3306/pc";
		   user = "root";
		   password = "1234";
		   
		   con = DriverManager.getConnection(url, user, password);
		   
		   String sql = "select * from member where id = ?";
		   
		   ps = con.prepareStatement(sql);
		   ps.setString(1, inputId);
		   rs = ps.executeQuery();
	   
	   
		   if(rs.next()) {
			   dto = new PcDTO();
			   String id = rs.getString(1);
			   String name = rs.getString(2);
			   String age = rs.getString(3);
			   String tel = rs.getString(4);
			   dto.setId(id);
			   dto.setName(name);
			   dto.setAge(age);
			   dto.setTel(tel);
		   }
	   
	   
	   }
	   catch(Exception e){
		   e.printStackTrace();
		   
	   }
	return dto;
   }
   
   public ArrayList selectAll() throws Exception {
	      
	      Class.forName("com.mysql.jdbc.Driver");
	     
	       url = "jdbc:mysql://localhost:3306/pc";
	       user = "root";
	       password = "1234";
	       con = DriverManager.getConnection(url, user, password);
	      
	      ArrayList list = new ArrayList();
	      try {
	         String sql = "select * from member";
	         ps = con.prepareStatement(sql);

	         rs = ps.executeQuery();


	         while (rs.next()) {
	            dto = new PcDTO();
	            String id = rs.getString(1);
	            String name = rs.getString(2);
	            String age = rs.getString(3);
	            String tel = rs.getString(4);
	            

	            dto.setId(id);
	            dto.setName(name);
	            dto.setAge(age);
	            dto.setTel(tel);
	            
	            list.add(dto);

	         } 

	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      } finally {
	         try {
	            rs.close();
	            ps.close();
	            con.close();
	         } catch (SQLException e) {
	         }
	      } 
	      
	      
	      return list;
	   }
}