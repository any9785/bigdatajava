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

public class Main {
	Container c;
	CardLayout card;

   public static void main(String[] args) {
      
      JFrame f = new JFrame("음식점 POS기");
      f.setSize(1000, 900);
      
      
      JButton b1 = new JButton("\uC885\uB8CC");
      b1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 int result = JOptionPane.showConfirmDialog(f, "정말 종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        	 if(result == JOptionPane.NO_OPTION) { //아무선택없이 닫은경우
        		 
        	 }else if(result == JOptionPane.YES_OPTION){
        		 System.exit(0); //사용자가 Yes버튼을 누르면 종료
        	 }
         }
      });
      f.getContentPane().setLayout(new CardLayout(0, 0));
      f.getContentPane().add(b1, "name_1060178976139377");
      
      JButton b2 = new JButton("\uD68C\uC6D0\uAC00\uC785");
      b2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      f.getContentPane().add(b2, "name_1060178987874986");
      
      JButton b3 = new JButton("\uB85C\uADF8\uC778");
      b3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });
      f.getContentPane().add(b3, "name_1060178997288960");
      
      JButton btnNewButton = new JButton("1");
      btnNewButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		Menu menu = new Menu();
  
      	}
      });
      btnNewButton.setVerticalAlignment(SwingConstants.TOP);
      f.getContentPane().add(btnNewButton, "name_1060179007182791");
      
      JButton button = new JButton("2");
      button.setVerticalAlignment(SwingConstants.TOP);
      f.getContentPane().add(button, "name_1060179015970986");
      
      JButton button_1 = new JButton("3");
      button_1.setVerticalAlignment(SwingConstants.TOP);
      f.getContentPane().add(button_1, "name_1060179024941226");
      
      JButton button_2 = new JButton("4");
      button_2.setVerticalAlignment(SwingConstants.TOP);
      f.getContentPane().add(button_2, "name_1060179036354844");
      
      JButton button_3 = new JButton("5");
      button_3.setVerticalAlignment(SwingConstants.TOP);
      f.getContentPane().add(button_3, "name_1060179049973191");
      
      JButton button_4 = new JButton("6");
      button_4.setVerticalAlignment(SwingConstants.TOP);
      f.getContentPane().add(button_4, "name_1060179063702186");
      
      JButton button_5 = new JButton("7");
      button_5.setVerticalAlignment(SwingConstants.TOP);
      f.getContentPane().add(button_5, "name_1060179076321564");
      
      JButton button_6 = new JButton("8");
      button_6.setVerticalAlignment(SwingConstants.TOP);
      f.getContentPane().add(button_6, "name_1060179088046364");
      
      JButton button_7 = new JButton("9");
      button_7.setVerticalAlignment(SwingConstants.TOP);
      f.getContentPane().add(button_7, "name_1060179096708551");
      
      JButton button_8 = new JButton("10");
      button_8.setVerticalAlignment(SwingConstants.TOP);
      f.getContentPane().add(button_8, "name_1060179105930524");
      
      JButton button_9 = new JButton("11");
      button_9.setVerticalAlignment(SwingConstants.TOP);
      f.getContentPane().add(button_9, "name_1060179114824249");
      
      JButton button_10 = new JButton("12");
      button_10.setVerticalAlignment(SwingConstants.TOP);
      f.getContentPane().add(button_10, "name_1060179123981653");
      
      JButton btnNewButton_1 = new JButton("\uBA54\uB274 \uAD00\uB9AC");
      f.getContentPane().add(btnNewButton_1, "name_1060179134223075");
      
      JButton button_11 = new JButton("\uC790\uB9AC\uC774\uB3D9");
      f.getContentPane().add(button_11, "name_1060179143018666");
      
      JButton button_12 = new JButton("\uB9E4\uCD9C\uD604\uD669");
      f.getContentPane().add(button_12, "name_1060179152359822");
      
      JButton button_13 = new JButton("\uBC1C\uC8FC\uC2DC\uC2A4\uD15C");
      f.getContentPane().add(button_13, "name_1060179162121671");
      
      JButton button_14 = new JButton("\uADFC\uD1F4\uD604\uD669");
      f.getContentPane().add(button_14, "name_1060179171623253");
      
      
      
      f.setVisible(true);

   }
   
}


