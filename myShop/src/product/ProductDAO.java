package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProductDAO {
   DBConnectionMgr mgr;
   public ProductDAO() {
      
      mgr = DBConnectionMgr.getInstance();
   }
   public void insert(ProductDTO dto) throws Exception {
      
      Connection con = mgr.getConnection();
      
      //3단계 sql문 결정
      String sql = "insert into shop values (?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1,dto.getId());
      ps.setString(2,dto.getProduct());
      ps.setString(3,dto.getContent());
      ps.setString(4,dto.getPrice());
      
      //4단계 sql문 전달요청
      ps.executeUpdate();
      mgr.freeConnection(con,ps);
   }
   
   public ProductDTO select(ProductDTO dto) throws Exception {
      
      Connection con = mgr.getConnection();
      String sql ="select * from shop where id = ?";
      
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, dto.getId());
      ResultSet rs = ps.executeQuery();
      
      ProductDTO dto2 = null;
      
      while(rs.next()) {
         dto2 = new ProductDTO();
         String id = rs.getString(1);
         String product = rs.getString(2);
         String content = rs.getString(3);
         String price = rs.getString(4);
         
         dto2.setId(id);
         dto2.setProduct(product);
         dto2.setContent(content);
         dto2.setPrice(price);
      }
      return dto2;
   }
   
   public void update(ProductDTO dto) throws Exception {
	      Connection con = mgr.getConnection();
	      
	      String sql = "update shop set content = ?, price = ? where id = ?";
	      
	      PreparedStatement ps = con.prepareStatement(sql);
	      
	      ps.setString(1, dto.getContent());
	      ps.setString(2, dto.getPrice());
	      ps.setString(3, dto.getId());
	      ps.executeUpdate();
	      mgr.freeConnection(con,ps);
	   }
   
   public void delete(ProductDTO dto)throws Exception {
      Connection con = mgr.getConnection();
      
      String sql = "delete from shop where id = ?";
      
      PreparedStatement ps = con.prepareStatement(sql);
      
      ps.setString(1, dto.getId());
      ps.executeUpdate();
      mgr.freeConnection(con, ps);
   }
   
   public ArrayList selectAll(ProductDTO dto) throws Exception {
	      Connection con = mgr.getConnection();
	      String sql = "select * from shop";
	      
	      PreparedStatement ps = con.prepareStatement(sql);
	      ResultSet rs = ps.executeQuery();
	      ProductDTO dto1 = null;
	      
	      ArrayList list = new ArrayList();
	      
	      while(rs.next()) {
	         dto = new ProductDTO();
	         String id = rs.getString(1);
	         String product = rs.getString(2);
	         String content = rs.getString(3);
	         String price = rs.getString(4);
	         
	         dto.setId(id);
	         dto.setProduct(product);
	         dto.setContent(content);
	         dto.setPrice(price);
	         
	         list.add(dto);
	      }
	      return list;
	   }

}