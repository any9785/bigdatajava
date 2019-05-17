package pos;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Vector;
public class Menu1 {
   
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql, number, menu, amount, price;
    static Vector col = new Vector();
    static Vector data = new Vector();
    JTable j;
    public void conn() {
        try {
         Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
         cnfe.printStackTrace();
         return;
        }
        try {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root", "1234");
         
        } catch (SQLException ee) {
         ee.printStackTrace();
        }
       }
       public void disconn() {
        // 연결 끊기
        try {
         if (rs != null)
          rs.close();
         if (pstmt != null)
          pstmt.close();
         if (con != null)
          con.close();
        } catch (SQLException ee) {
         ee.printStackTrace();
        }
       }
       public void inputdb(String jtf1, String jtf2, String jtf3, String jtf4) {
           try {
            // 연결
            conn();
            String sql = "insert into foodlist values('" + jtf1 + "','" + jtf2 + "','" + jtf3 + "','" + jtf4 + "')";
            pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
           } catch (SQLException se) {
           }
           finally{
            disconn(); 
           }
           defJTable();
          }
       public void defJTable() {
           try {
            conn();
            pstmt = con.prepareStatement("select * from foodlist");
            rs = pstmt.executeQuery();
            //DB의 데이터 받아 와 row입력
            while (rs.next()) {
             Vector row = new Vector();
             row.addElement(rs.getString("number"));
             row.addElement(rs.getString("menu"));
             row.addElement(rs.getString("amount"));
             row.addElement(rs.getString("price"));
             data.addElement(row);
             
            }
           } catch (SQLException e) {
            e.printStackTrace();
           }
           finally{
            disconn();
           }
          }
          //renew
          public void redefJTable() {
           data.clear();
           try {
            conn();
            pstmt = con.prepareStatement("select * from foodlist");
            rs = pstmt.executeQuery();
            while (rs.next()) {
             Vector row = new Vector();
             row.addElement(rs.getString("number"));
             row.addElement(rs.getString("menu"));
             row.addElement(rs.getString("amount"));
             row.addElement(rs.getString("price"));
             data.addElement(row);
            }
           } catch (SQLException e) {
            e.printStackTrace();
           }
           finally{
            disconn();
           }
          }
          //JTable을 리턴.
          public JTable getJTable(){
           defJTable();
           col.addElement("번호");
           col.addElement("메뉴명");
           col.addElement("수량");
           col.addElement("금액");
           DefaultTableModel model = new DefaultTableModel(data, col){
            public boolean isCellEditable(int row,int column){
             return false;
            }
           };
           j = new JTable(model);
           return j;
          }
          
          public void deleteRow(String number){
           try {
            conn();
            pstmt = con.prepareStatement("delete from foodlist where number = '" + number + "'");
            pstmt.executeUpdate();
            
           } catch (SQLException e) {
            e.printStackTrace();
           }
           finally{
            disconn();
           }
          }
          
          public void updatedb(String jtf1, String jtf2, String jtf3, String jtf4) {
            try { 
             conn();
             String sql = "update foodlist set menu ='" + jtf2+ "',amount = '" + jtf3 + "',price = '" + jtf4 + "'where number ='" + jtf1 +"'";
             pstmt = con.prepareStatement(sql);
             pstmt.executeUpdate();
             
            }catch(SQLException e) {
               e.printStackTrace();
            }
            finally {
               disconn();
            }
            defJTable();
         }
}
