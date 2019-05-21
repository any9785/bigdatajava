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
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 


import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
public class TableButton extends JFrame implements ActionListener{
 
	FoodDTO dto = new FoodDTO();
	FoodDAO dao;

	JLabel[] name = new JLabel[9];
	JLabel[] count = new JLabel[9];
	JLabel[] price = new JLabel[9];

	JButton orderB;
	JButton payB;
	JButton editB;
	JButton back;

	JPanel panel;
	JPanel panel2;
	JLabel numGuest;
	JLabel orderList;
	JLabel entrance;
	JLabel totalPrice;

	JOptionPane insertNG;

	Table tb = new Table();

	String guest;
	Choice cho;

	int tableNumber;

	public TableButton(String tn) throws ClassNotFoundException, SQLException {

		setSize(600,600);
		tb.tn = tn;
		dto.setTn(tn);
		guest = tb.getNg(tn);

		tableNumber = Integer.parseInt(tb.tn);

		for (int i = 0; i < name.length; i++) {
			name[i] = new JLabel();
			count[i] = new JLabel();
			price[i] = new JLabel();
		}

		orderB = new JButton("주문");
		payB = new JButton("결제");
		editB = new JButton("등록");
		back = new JButton("뒤로");

		numGuest = new JLabel();
		totalPrice = new JLabel();
 



		panel = new JPanel();
		panel2 = new JPanel(new GridLayout(9, 3));

		for(int i = 0; i < name.length; i++) {
			panel2.add(name[i]);
			panel2.add(count[i]);
			panel2.add(price[i]);
		}

		numGuest.setText("손님 수 : " + guest);

		orderB.addActionListener(this);
		payB.addActionListener(this);
		editB.addActionListener(this);
		back.addActionListener(this);

		panel.add(numGuest);
		panel.add(totalPrice);
		panel.add(orderB);
		panel.add(payB);
		panel.add(editB);
		panel.add(back);


		add(panel2, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

 


		panel.setVisible(true);
		panel2.setVisible(true);
		displayOrder(tb.tn);
		setVisible(true);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == editB) {
	try {
	tb.newComer(tb.tn);
	} catch (ClassNotFoundException | SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	}
	
	dispose();
	try {
	TableButton tableButton = new TableButton(tb.tn);
	} catch (ClassNotFoundException | SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
		}
	
	}

	if(e.getSource() == orderB) {
		tb.order(tableNumber);
		dispose();
	}

	if(e.getSource() == payB) {
		cho = new Choice(tb.tn);
		try {
			tb.pay();
			cho.paid();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dispose();
		repaint();
	}

	if(e.getSource() == back) {
		try {
			TableMain tm = new TableMain();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dispose();
	}
	}

	public void displayOrder(String tn) {
		
		dto.setTn(tn);
		
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
 
				while (rs.next()) {
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
				if (j < list.size()) {
					String s = String.valueOf(list.get(j));
					name[j].setText(s);
				} else {
					name[j].setText("");;
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
 
 


while (rs.next()) {
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
if (j < listCount.size()) {
String sCount = String.valueOf(listCount.get(j));
String sPrice = String.valueOf(listPrice.get(j));
count[j].setText(sCount);
int inCount = Integer.parseInt(sCount);
int inPrice = Integer.parseInt(sPrice);
price[j].setText((inCount * inPrice) + "");
} else {
count[j].setText("");
price[j].setText("");
}
 


}
}

int calc = 0;
int total = 0;

for(int q = 0; q < price.length; q++) {
if(price[q].getText().equals("")) {

}else {
calc = Integer.parseInt(price[q].getText());
total += calc;
}
}
totalPrice.setText("총액 : "+ total + "");
}

}