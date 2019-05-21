package big33project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
 
public class TableMain extends JFrame implements ActionListener {
 
JButton tb1;
JButton tb2;
JButton tb3;
JButton tb4;
JButton tb5;
JButton tb6;
JButton tb7;
JButton tb8;
JButton tb9;
JButton logout;
 
JPanel mainPanel ,p;
 
GridLayout grid;
 
String tableNumber;

JLabel clock;


static int revenue = 0;

 
public TableMain() throws ClassNotFoundException, SQLException {
setSize(600, 600);

clock = new JLabel();
try {
clock.setText(clock());
} catch (InterruptedException e) {
// TODO Auto-generated catch block
 


e.printStackTrace();
}
 
tb1 = new JButton("Table 1");
tb2 = new JButton("Table 2");
tb3 = new JButton("Table 3");
tb4 = new JButton("Table 4");
tb5 = new JButton("Table 5");
tb6 = new JButton("Table 6");
tb7 = new JButton("Table 7");
tb8 = new JButton("Table 8");
tb9 = new JButton("Table 9");
logout = new JButton("·Î±×¾Æ¿ô");
p = new JPanel();
 
mainPanel = new JPanel(new GridLayout(3, 3, 30, 30));
 
mainPanel.add(tb1);
mainPanel.add(tb2);
mainPanel.add(tb3);
mainPanel.add(tb4);
mainPanel.add(tb5);
mainPanel.add(tb6);
mainPanel.add(tb7);
mainPanel.add(tb8);
mainPanel.add(tb9);

tb1.addActionListener(this);
 


tb2.addActionListener(this);
tb3.addActionListener(this);
tb4.addActionListener(this);
tb5.addActionListener(this);
tb6.addActionListener(this);
tb7.addActionListener(this);
tb8.addActionListener(this);
tb9.addActionListener(this);
logout.addActionListener(this);
 
mainPanel.setVisible(true);
p.add(clock);
p.add(logout);
 
add(mainPanel, BorderLayout.CENTER);
add(p, BorderLayout.SOUTH);
 
setLocationRelativeTo(null);
setVisible(true);
}
 
public static void main(String[] args) throws ClassNotFoundException, SQLException {
TableMain run = new TableMain();
}
 
@Override
public void actionPerformed(ActionEvent e) {
if (e.getSource() == tb1) {
tableNumber = "1";
 


try {
TableButton tableButton = new TableButton(tableNumber);
} catch (ClassNotFoundException | SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
dispose();
}
if (e.getSource() == tb2) {
tableNumber = "2";
try {
TableButton tableButton = new TableButton(tableNumber);
} catch (ClassNotFoundException | SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
dispose();
}
if (e.getSource() == tb3) {
tableNumber = "3";
try {
TableButton tableButton = new TableButton(tableNumber);
} catch (ClassNotFoundException | SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
dispose();
}
if (e.getSource() == tb4) {
 


tableNumber = "4";
try {
TableButton tableButton = new TableButton(tableNumber);
} catch (ClassNotFoundException | SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
dispose();
}
if (e.getSource() == tb5) {
tableNumber = "5";
try {
TableButton tableButton = new TableButton(tableNumber);
} catch (ClassNotFoundException | SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
dispose();
}
if (e.getSource() == tb6) {
tableNumber = "6";
try {
TableButton tableButton = new TableButton(tableNumber);
} catch (ClassNotFoundException | SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
dispose();
}
 


if (e.getSource() == tb7) {
tableNumber = "7";
try {
TableButton tableButton = new TableButton(tableNumber);
} catch (ClassNotFoundException | SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
dispose();
}
if (e.getSource() == tb8) {
tableNumber = "8";
try {
TableButton tableButton = new TableButton(tableNumber);
} catch (ClassNotFoundException | SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
dispose();
}
 
if (e.getSource() == tb9) {
tableNumber = "9";
try {
TableButton tableButton = new TableButton(tableNumber);
} catch (ClassNotFoundException | SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
 


dispose();
}
if(e.getSource()==logout) {
Project pro = new Project();
dispose();
}
 
}

public String clock() throws InterruptedException{
TimeZone zon = TimeZone.getTimeZone("GMT");
Calendar cal = Calendar.getInstance();
Date date = new Date();
String timeString;

while(true) {
timeString = date.toString();
Thread.sleep(100);
invalidate();
validate();
return timeString;
}

}
 
}