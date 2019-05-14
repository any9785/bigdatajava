package pos;

import java.awt.*;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {

	   public static void main(String[] args) {
	      
	      JFrame f = new JFrame("음식점 POS기");
	      f.setSize(1000, 900);
	      f.getContentPane().setLayout(null);
	      
	      
	      JButton b1 = new JButton("\uC885\uB8CC");
	      b1.addActionListener(new ActionListener() {
	    	  
	         public void actionPerformed(ActionEvent e) {
	        	 
	        	 int result = JOptionPane.showConfirmDialog(f, "정말 종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
	             if(result == JOptionPane.NO_OPTION) {
	                
	             }else if(result == JOptionPane.YES_OPTION){
	                System.exit(0);
	             }
	         }
	      });
	      b1.setBounds(29, 25, 81, 39);
	      f.getContentPane().add(b1);
	      
	      JButton b2 = new JButton("\uD68C\uC6D0\uAC00\uC785");
	      b2.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	         }
	      });
	      b2.setBounds(763, 25, 98, 39);
	      f.getContentPane().add(b2);
	      
	      JButton b3 = new JButton("\uB85C\uADF8\uC778");
	      b3.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	         }
	      });
	      b3.setBounds(873, 25, 87, 39);
	      f.getContentPane().add(b3);
	      
	      JButton btnNewButton = new JButton("1");
	      btnNewButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		Menu menu = new Menu();
	      	}
	      });
	      btnNewButton.setVerticalAlignment(SwingConstants.TOP);
	      btnNewButton.setBounds(46, 119, 197, 167);
	      f.getContentPane().add(btnNewButton);
	      
	      JButton button = new JButton("2");
	      button.setVerticalAlignment(SwingConstants.TOP);
	      button.setBounds(295, 119, 197, 167);
	      f.getContentPane().add(button);
	      
	      JButton button_1 = new JButton("3");
	      button_1.setVerticalAlignment(SwingConstants.TOP);
	      button_1.setBounds(523, 119, 197, 167);
	      f.getContentPane().add(button_1);
	      
	      JButton button_2 = new JButton("4");
	      button_2.setVerticalAlignment(SwingConstants.TOP);
	      button_2.setBounds(763, 119, 197, 167);
	      f.getContentPane().add(button_2);
	      
	      JButton button_3 = new JButton("5");
	      button_3.setVerticalAlignment(SwingConstants.TOP);
	      button_3.setBounds(46, 332, 197, 167);
	      f.getContentPane().add(button_3);
	      
	      JButton button_4 = new JButton("6");
	      button_4.setVerticalAlignment(SwingConstants.TOP);
	      button_4.setBounds(295, 332, 197, 167);
	      f.getContentPane().add(button_4);
	      
	      JButton button_5 = new JButton("7");
	      button_5.setVerticalAlignment(SwingConstants.TOP);
	      button_5.setBounds(523, 332, 197, 167);
	      f.getContentPane().add(button_5);
	      
	      JButton button_6 = new JButton("8");
	      button_6.setVerticalAlignment(SwingConstants.TOP);
	      button_6.setBounds(763, 332, 197, 167);
	      f.getContentPane().add(button_6);
	      
	      JButton button_7 = new JButton("9");
	      button_7.setVerticalAlignment(SwingConstants.TOP);
	      button_7.setBounds(46, 551, 197, 167);
	      f.getContentPane().add(button_7);
	      
	      JButton button_8 = new JButton("10");
	      button_8.setVerticalAlignment(SwingConstants.TOP);
	      button_8.setBounds(278, 551, 197, 167);
	      f.getContentPane().add(button_8);
	      
	      JButton button_9 = new JButton("11");
	      button_9.setVerticalAlignment(SwingConstants.TOP);
	      button_9.setBounds(523, 551, 197, 167);
	      f.getContentPane().add(button_9);
	      
	      JButton button_10 = new JButton("12");
	      button_10.setVerticalAlignment(SwingConstants.TOP);
	      button_10.setBounds(763, 551, 197, 167);
	      f.getContentPane().add(button_10);
	      
	      JButton btnNewButton_1 = new JButton("\uBA54\uB274 \uAD00\uB9AC");
	      btnNewButton_1.setBounds(203, 784, 98, 49);
	      f.getContentPane().add(btnNewButton_1);
	      
	      JButton button_11 = new JButton("\uC790\uB9AC\uC774\uB3D9");
	      button_11.setBounds(333, 784, 98, 49);
	      f.getContentPane().add(button_11);
	      
	      JButton button_12 = new JButton("\uB9E4\uCD9C\uD604\uD669");
	      button_12.setBounds(460, 784, 98, 49);
	      f.getContentPane().add(button_12);
	      
	      JButton button_13 = new JButton("\uBC1C\uC8FC\uC2DC\uC2A4\uD15C");
	      button_13.setBounds(590, 784, 98, 49);
	      f.getContentPane().add(button_13);
	      
	      JButton button_14 = new JButton("\uADFC\uD1F4\uAD00\uB9AC");
	      button_14.setBounds(737, 784, 98, 49);
	      f.getContentPane().add(button_14);
	      
	      
	      
	      f.setVisible(true);

	   }
	}