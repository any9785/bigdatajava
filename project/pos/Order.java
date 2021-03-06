package pos;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.Iterator;

import mainm.PosMain;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Order extends JFrame {
	JTable jt;
	JTextField jtf;
	JScrollPane jsp = null;
	JPanel jp1, jp2, jp3;
	JTextField tf = new JTextField(30);
	private JTable table;
	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql;
    String [] colname = {"번호","메뉴명","수량","가격"};
    String [][] data;
    DefaultTableModel model = new DefaultTableModel(data, colname);
    
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
   Order(){
      setTitle("메뉴 주문창");
      	tf.setSize(480, 80);
		tf.setLocation(30, 650);
		getContentPane().add(tf);
      
      setSize(1000, 800);
      getContentPane().setLayout(null);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(14, 44, 510, 593);
      getContentPane().add(scrollPane);
      
      table = new JTable(model);
      scrollPane.setViewportView(table);
      
      JButton b1 = new JButton("할인");
      b1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		JButton b1 = (JButton)e.getSource();
			table.setValueAt(0, table.getSelectedRow(), 3);
      	}
      });
      b1.setBounds(541, 654, 97, 73);
      getContentPane().add(b1);
      
      JButton b2 = new JButton("취소");
      b2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		JButton b2 = (JButton)e.getSource();
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			m.removeRow(table.getSelectedRow());
      	}
      });
      b2.setBounds(650, 654, 97, 73);
      getContentPane().add(b2);
      
      
      JButton b3 = new JButton("주문");
      b3.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      			//주문버튼클릭시 메인화면의 테이블안에 데이터값이 들어감
      		
      		OrderDTO dto = new OrderDTO();
      		OrderDAO dao = new OrderDAO();
      		int row = table.getRowCount();
      		for (int i = 0; i < row; i++) {
      			dto.setNum((String)table.getValueAt(i, 0));
      			dto.setMenu((String)table.getValueAt(i, 1));
      			dto.setAmount((String)table.getValueAt(i, 2));
      			dto.setPrice((String)table.getValueAt(i, 3));
      			dao.insert(dto);
			}
      		dispose();
      	}
			
      });
      b3.setBounds(759, 654, 97, 73);
      getContentPane().add(b3);
      
      JButton b4 = new JButton("결제");
      b4.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		int row = table.getRowCount();
			int sum =0;
			for(int i=0;i<row;i++) {
				sum += Integer.parseInt((String)table.getValueAt(i, 3));
			}
			tf.setText(String.valueOf(" 총 금액 : "+sum + "원"));
      		
      	}
      });
      b4.setBounds(868, 654, 97, 73);
      getContentPane().add(b4);
      JButton[] buttonList = null;
      int rowCount = 0;
      int i = 0, x=538,y=-37,width=122,height=95, cnt=0;
      try {
            conn();
            pstmt = con.prepareStatement("select * from foodlist");
            rs = pstmt.executeQuery();
            rs.last();
            rowCount = rs.getRow();
            //DB의 데이터 받아 와 row입력
            buttonList = new JButton[rowCount];
            rs.beforeFirst();//처음상태로 이동되는거 
            while (rs.next()) {
                buttonList[i] = new JButton(rs.getString(2));
                buttonList[i].setName(rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4));
                x += width+10;
                if(cnt%3 ==0) {
                   x = 538;
                   y += height + 10;
                }
                buttonList[i].addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                      String[] temp = ((JButton)e.getSource()).getName().split("\\|");//스플릿은 문자를 나누는거 
                      model.addRow(new Object[] {temp[0],temp[1],temp[2],temp[3]});
                   }
                });
                
                
                buttonList[i].setBounds(x, y, width, height);
                getContentPane().add(buttonList[i]);
                cnt++;
                i++;
                
             }
             
            } catch (SQLException e) {
             e.printStackTrace();
            }
            finally{
             disconn();
            }
      
      setVisible(true);
      
   }   
   protected void DISPOSE_ON_CLOSE() {
	// TODO Auto-generated method stub
	
}
public static void main(String[] args) {
      new Order();
   }
}