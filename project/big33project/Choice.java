package big33project;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
 


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
 
public class Choice extends JFrame implements ActionListener {
int countPaella, countJamon, countTomyumgoong, countKebab, countCurryWurst, countPasta, countSangria, countRedWine,
countWhiteWine;
int pricePaella = 10000, priceJamon = 15000, priceTomyumgoong = 18000, priceKebab = 5000, priceCurryWurst = 5000,
pricePasta = 9000, priceSangria = 6000, priceRedWine = 4000, priceWhiteWine = 4000;
int totalPrice;
int tableNum;


JButton order, back, init;
JButton[] menu = null;

JPanel panel, p, p1, p2 ,p3;
 


JPanel bp;//버튼 배열용 패널

JLabel total;
JLabel[] name;
JLabel[] count;
JLabel[] price;
JLabel l1,l2,l3,l4;

String[] food = {"0","1","2","3","4","5","6","7","8"};
String[] numStr = new String[9];
ImageIcon icon;
 
String number;

FoodDTO dto;
FoodDAO dao;

public Choice(String number) {

back = new JButton("뒤로");
init = new JButton("초기화");

total = new JLabel();

dto = new FoodDTO();
dao = new FoodDAO();

this.number = number;
 


dto.setTn(number);

panel = new JPanel();
p = new JPanel();p1 = new JPanel();p2 = new JPanel();
bp = new JPanel(new GridLayout(3, 3, 2, 2));
order = new JButton("주문");
p3 = new JPanel(new GridLayout(9, 3, 2, 2));

l1 = new JLabel("음식명");
l2 = new JLabel("주문수");
l3 = new JLabel("금액");
l4 = new JLabel("총액");

name = new JLabel[9];
count = new JLabel[9];
price = new JLabel[9];

panel.setLayout(new GridLayout(1, 1));
p1.setLayout(new GridLayout(1,3));
p.setLayout(new BorderLayout());

menu = new JButton[numStr.length];
for (int i = 0; i < food.length; i++) {
numStr[i] = food[i]+".jpg";
}
for(int i=0; i<numStr.length; i++) {//버튼 생성용
menu[i] = new JButton();
 


icon = new ImageIcon(numStr[i]);
menu[i].setIcon(icon);
bp.add(menu[i]);
menu[i].addActionListener(this);
}

for (int i = 0; i < name.length; i++) {
ArrayList list = new ArrayList();
String url = "jdbc:mysql://localhost:3306/car";
String user = "root";
String password = "1234";
Connection con = null;
try {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(url, user, password);
String sql = "select name from tabledb where tn =? && count > '0'";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, dto.getTn());
ResultSet rs = pstmt.executeQuery();

while(rs.next()) {
dto.setName(rs.getString(1));
list.add(dto.getName());
}

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
for (int j = 0; j < name.length; j++) {
if(j < list.size()) {
String s = String.valueOf(list.get(j));
name[j] = new JLabel(s);
}else {
name[j] = new JLabel("");
}
}

}
for (int i = 0; i < count.length; i++) {
ArrayList listCount = new ArrayList();
ArrayList listPrice = new ArrayList();
String url = "jdbc:mysql://localhost:3306/car";
String user = "root";
String password = "1234";
Connection con = null;
try {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(url, user, password);
String sql = "select count, price from tabledb where tn =? && count > '0'";
PreparedStatement pstmt = con.prepareStatement(sql);
 


pstmt.setString(1, dto.getTn());
ResultSet rs = pstmt.executeQuery();

while(rs.next()) {
dto.setCount(rs.getString(1));
dto.setPrice(rs.getString(2));
listCount.add(dto.getCount());
listPrice.add(dto.getPrice());
}

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
for (int j = 0; j < count.length; j++) {
if(j < listCount.size()) {
String sCount = String.valueOf(listCount.get(j));
String sPrice = String.valueOf(listPrice.get(j));
count[j] = new JLabel(sCount);
int inCount = Integer.parseInt(sCount);
int inPrice = Integer.parseInt(sPrice);
price[j] = new JLabel((inCount * inPrice) + "");
}else {
 


count[j] = new JLabel("");
price[j] = new JLabel("");
}
}
}
for (int i = 0; i < count.length; i++) {
if(count[i].getText().equals("")) {}
else {
int inPrice = (Integer.parseInt(price[i].getText()));
totalPrice += inPrice;
}
}
total.setText(String.valueOf(totalPrice));
setSize(1200,600);
p1.setBackground(Color.PINK);
p2.setBackground(Color.LIGHT_GRAY);
p1.add(l1);p1.add(l2);p1.add(l3);
p2.add(l4);p2.add(total);p2.add(order);p2.add(init); p2.add(back);

for (int i = 0; i < name.length; i++) {
p3.add(name[i]); p3.add(count[i]); p3.add(price[i]); 
}

p.add(p1, BorderLayout.NORTH);
p.add(p3, BorderLayout.CENTER);
p.add(p2, BorderLayout.SOUTH);
back.addActionListener(this);
order.addActionListener(this);
init.addActionListener(this);
 


panel.add(bp);
panel.add(p);
add(panel);
setResizable(false);
setLocationRelativeTo(null);
}
 
public void actionPerformed(ActionEvent e) {
if(e.getSource() == menu[0]){
for (int i = 0; i < name.length; i++) {
if (name[i].getText().equals("") || name[i].getText().equals("paella")) {
if(name[i].getText().equals("")) {
name[i].setText("paella");

}else if(name[i].getText().equals("paella")){
countPaella = Integer.parseInt(count[i].getText());
}
countPaella++;
count[i].setText(countPaella + "");
int finalPrice = pricePaella * countPaella;
price[i].setText(finalPrice + "");
totalPrice += pricePaella;
total.setText("" + totalPrice);
dto.setName("paella");
dto.setCount(countPaella + "");
dao.update(dto);
break;
}
}
 


}
 
if(e.getSource() == menu[3]){
for (int i = 0; i < name.length; i++) {
if (name[i].getText().equals("") || name[i].getText().equals("jamon")) {
if(name[i].getText().equals("")) {
name[i].setText("jamon");
}
else if(name[i].getText().equals("jamon")) {
countJamon =  Integer.parseInt(count[i].getText());
}
countJamon++;
count[i].setText(countJamon + "");
int finalPrice = priceJamon * countJamon;
price[i].setText(finalPrice + "");
totalPrice += priceJamon;
total.setText("" + totalPrice);
dto.setName("jamon");
dto.setCount(countJamon + "");
dao.update(dto);
break;
}
}
}
if(e.getSource() == menu[1]){
for (int i = 0; i < name.length; i++) {
if (name[i].getText().equals("") || name[i].getText().equals("tomyumgoong")) {
if(name[i].getText().equals("")) {
 


name[i].setText("tomyumgoong");
}
else if(name[i].getText().equals("tomyumgoong")) {
countTomyumgoong =  Integer.parseInt(count[i].getText());
}
countTomyumgoong++;
count[i].setText(countTomyumgoong + "");
int finalPrice = priceTomyumgoong * countTomyumgoong;
price[i].setText(finalPrice + "");
totalPrice += priceTomyumgoong;
total.setText("" + totalPrice);
dto.setName("tomyumgoong");
dto.setCount(countTomyumgoong + "");
dao.update(dto);
break;
}
}
}
if (e.getSource() == menu[4]) {
for (int i = 0; i < name.length; i++) {
if (name[i].getText().equals("") || name[i].getText().equals("kebab")) {
if(name[i].getText().equals("")) {
name[i].setText("kebab");
}
else if(name[i].getText().equals("kebab")) {
countKebab =  Integer.parseInt(count[i].getText());
}
countKebab++;
 


count[i].setText(countKebab + "");
int finalPrice = priceKebab * countKebab;
price[i].setText(finalPrice + "");
totalPrice += priceKebab;
total.setText("" + totalPrice);
dto.setName("kebab");
dto.setCount(countKebab + "");
dao.update(dto);
break;
}
}
}
if (e.getSource() == menu[2]) {
for (int i = 0; i < name.length; i++) {
if (name[i].getText().equals("") || name[i].getText().equals("currywurst")) {
if(name[i].getText().equals("")) {
name[i].setText("currywurst");
}
else if(name[i].getText().equals("currywurst")) {
countCurryWurst =  Integer.parseInt(count[i].getText());
}
countCurryWurst++;
count[i].setText(countCurryWurst + "");
int finalPrice = priceCurryWurst * countCurryWurst;
price[i].setText(finalPrice + "");
totalPrice += priceCurryWurst;
total.setText("" + totalPrice);
dto.setName("currywurst");
 


dto.setCount(countCurryWurst + "");
dao.update(dto);
break;
}
}
}
if (e.getSource() == menu[5]) {
for (int i = 0; i < name.length; i++) {
if (name[i].getText().equals("") || name[i].getText().equals("pasta")) {
if(name[i].getText().equals("")) {
name[i].setText("pasta");
}
else if(name[i].getText().equals("pasta")) {
countPasta =  Integer.parseInt(count[i].getText());
}
countPasta++;
count[i].setText(countPasta + "");
int finalPrice = pricePasta * countPasta;
price[i].setText(finalPrice + "");
totalPrice += pricePasta;
total.setText("" + totalPrice);
dto.setName("pasta");
dto.setCount(countPasta + "");
dao.update(dto);
break;
}
}
}
if (e.getSource() == menu[6]) {
 


for (int i = 0; i < name.length; i++) {
if (name[i].getText().equals("") || name[i].getText().equals("sangria")) {
if(name[i].getText().equals("")) {
name[i].setText("sangria");
}
else if(name[i].getText().equals("sangria")) {
countSangria =  Integer.parseInt(count[i].getText());
}
countSangria++;
count[i].setText(countSangria + "");
int finalPrice = priceSangria * countSangria;
price[i].setText(finalPrice + "");
totalPrice += priceSangria;
total.setText("" + totalPrice);
dto.setName("sangria");
dto.setCount(countSangria + "");
dao.update(dto);
break;
}
}
}
if (e.getSource() == menu[7]) {
for (int i = 0; i < name.length; i++) {
if (name[i].getText().equals("") || name[i].getText().equals("redwine")) {
if(name[i].getText().equals("")) {
name[i].setText("redwine");
}
else if(name[i].getText().equals("redwine")) {
countRedWine =  Integer.parseInt(count[i].getText());
 


}
countRedWine++;
count[i].setText(countRedWine + "");
int finalPrice = priceRedWine * countRedWine;
price[i].setText(finalPrice + "");
totalPrice += priceRedWine;
total.setText("" + totalPrice);
dto.setName("redwine");
dto.setCount(countRedWine + "");
dao.update(dto);
break;
}
}
}
if (e.getSource() == menu[8]) {
for (int i = 0; i < name.length; i++) {
if (name[i].getText().equals("") || name[i].getText().equals("whitewine")) {
if(name[i].getText().equals("")) {
name[i].setText("whitewine");
}
else if(name[i].getText().equals("whitewine")) {
countWhiteWine =  Integer.parseInt(count[i].getText());
}
countWhiteWine++;
count[i].setText(countWhiteWine + "");
int finalPrice = priceWhiteWine * countWhiteWine;
price[i].setText(finalPrice + "");
totalPrice += priceWhiteWine;
 


total.setText("" + totalPrice);
dto.setName("whitewine");
dto.setCount(countWhiteWine + "");
dao.update(dto);
break;
}
}
}
if(e.getSource() == init) {
dao.finish(dto);
for (int i = 0; i < name.length; i++) {
name[i].setText("");
price[i].setText("");
count[i].setText("");
}
total.setText("0");
countPaella= 0; countJamon=0; countTomyumgoong=0; countKebab=0; 
countCurryWurst=0;countPasta=0;countSangria=0;countRedWine=0;
countWhiteWine=0; totalPrice = 0;

}

if(e.getSource() == back) {
try {
TableButton button = new TableButton(number);
} catch (ClassNotFoundException e1) {
e1.printStackTrace();
} catch (SQLException e1) {
e1.printStackTrace();
 


}
dispose();
}
if(e.getSource() == order){
String total = this.total.getText();
String tn = number;
try {
Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e1) {
e1.printStackTrace();
}
String url = "jdbc:mysql://localhost:3306/car";
Connection con = null;
try {
con = DriverManager.getConnection(url, "root", "1234");
} catch (SQLException e1) {
e1.printStackTrace();
}
String sql = "update tabledb set total = ? where tn = ?";
PreparedStatement ps;
try {
ps = con.prepareStatement(sql);
ps.setString(1, total);
ps.setString(2, tn);
ps.executeUpdate();
} catch (SQLException e1) {
e1.printStackTrace();
}
 


JOptionPane.showMessageDialog(null, "완료");
try {
TableButton button = new TableButton(number);
} catch (ClassNotFoundException e1) {
e1.printStackTrace();
} catch (SQLException e1) {
e1.printStackTrace();
}
dispose();
}
}

public void paid() {

dao.finish(dto);
for (int i = 0; i < name.length; i++) {
name[i].setText("");
price[i].setText("");
count[i].setText("");
}
total.setText("0");
countPaella= 0; countJamon=0; countTomyumgoong=0; countKebab=0; 
countCurryWurst=0;countPasta=0;countSangria=0;countRedWine=0;
countWhiteWine=0; totalPrice = 0;

try {
TableButton button = new TableButton(number);
} catch (ClassNotFoundException e1) {
 


e1.printStackTrace();
} catch (SQLException e1) {
e1.printStackTrace();
}
dispose();
}
}