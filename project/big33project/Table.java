package big33project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
 
import javax.swing.JOptionPane;
 
public class Table {
//변수모음
ArrayList orderList = new ArrayList<>();

String tn; //Table number => tn
String ng; //number of guests =>ng
String ent; //entrance => ent
String exit;
String total;
String zone;
String dur;

//주문내역 클래스 필요

 


//시간변수
Calendar cal = Calendar.getInstance();
TimeZone tz = TimeZone.getTimeZone("GMT");
Date date = new Date();



public Table() throws ClassNotFoundException, SQLException {
super();
}
 
public String getTn() {
return tn;
}
 
public void setTn(String tn) {
this.tn = tn;
}
 
public String getNg(String tn) throws ClassNotFoundException, SQLException {
Class.forName("com.mysql.jdbc.Driver");
 
String url = "jdbc:mysql://localhost:3306/car";
String user = "root";
String password = "1234";
Connection con = DriverManager.getConnection(url, user, password);

String sql = "select * from tabledb " + "where tn = ?";
 


 
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1, tn);

ResultSet rs = ps.executeQuery();

while(rs.next()) {
ng = rs.getString(2);
}
try {
con.close();
} catch (SQLException e) {
e.printStackTrace();
}

return ng;
}
 
public void setNg(String ng) {
this.ng = ng;
}
 
public String getEnt() {
return ent;
}
 
public void setEnt(String ent) {
this.ent = ent;
}
 


 
public String getExit() {
return exit;
}
 
public void setExit(String exit) {
this.exit = exit;
}
 
public String registerTime() {
cal.setTimeZone(tz);
date = cal.getTime();
ent = date.toString();
return ent;
}
 
public void newComer(String tn) throws ClassNotFoundException, SQLException {
ng = JOptionPane.showInputDialog(null, "Number of Guests : ");
ent = registerTime();
 
Class.forName("com.mysql.jdbc.Driver");
 
String url = "jdbc:mysql://localhost:3306/car";
String user = "root";
String password = "1234";
Connection con = DriverManager.getConnection(url, user, password);
String sql = "update tabledb set ng = " + ng + " where tn = " + tn;
 
PreparedStatement ps = con.prepareStatement(sql);
 


ps.executeUpdate();
 
sql= "update tabledb set entT = " + "'" + ent + "'" + " where tn = " + tn;
ps = con.prepareStatement(sql);
ps.executeUpdate();
try {
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}

public void order(int tn) {
Choice c = new Choice(String.valueOf(tn));
c.setVisible(true);
}

public void pay() throws ClassNotFoundException, SQLException {
Class.forName("com.mysql.jdbc.Driver");
 
String url = "jdbc:mysql://localhost:3306/car";
String user = "root";
String password = "1234";
Connection con = DriverManager.getConnection(url, user, password);
String sql = "update tabledb set ng ='', entT = '', total = '' where tn = " + tn;

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
