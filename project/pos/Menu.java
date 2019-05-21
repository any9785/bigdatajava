package pos;

import java.awt.event.MouseListener;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

public class Menu extends JFrame implements MouseListener {
   JTextField jtf1, jtf2, jtf3, jtf4;
   JButton jb1, jb2, jb3;
   JPanel jp1, jp2, jp3;
   JScrollPane jsp = null;
   JTable jt;
   Menu1 me = new Menu1();
   String deleteRow = "";

   Menu() {
      jp1 = new JPanel();
      jp2 = new JPanel();

      jtf1 = new JTextField(8);
      jtf2 = new JTextField(8);
      jtf3 = new JTextField(8);
      jtf4 = new JTextField(8);

      jb1 = new JButton("입력");
      jb2 = new JButton("삭제");
      jb3 = new JButton("수정");

      jp1.add(jb1);
      jp1.add(jb2);
      jp1.add(jb3);

      jp2.add(jtf1);
      jp2.add(jtf2);
      jp2.add(jtf3);
      jp2.add(jtf4);

      add(jp1, "South");
      add(jp2, "North");

      jt = me.getJTable();
      jt.addMouseListener(this);

      add(new JScrollPane(jt), "Center");

      // �����ư�� ���� ������ ���
      jb1.addActionListener(new inputAction());
      jb2.addActionListener(new deleteAction());
      jb3.addActionListener(new renewAction());

      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setBounds(300, 300, 300, 300);
      setSize(600, 500);
   }

   public static void main(String args[]) {
      new Menu();
   }

   public void mouseEntered(MouseEvent e) {
   }

   public void mouseExited(MouseEvent e) {
   }

   public void mousePressed(MouseEvent e) {
   }

   public void mouseReleased(MouseEvent e) {
   }

   public void mouseClicked(MouseEvent e) {
      deleteRow = (String) jt.getValueAt(jt.getSelectedRow(), 0);
   }

   class inputAction implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         Menu1 me = new Menu1();

         String tf1 = jtf1.getText();
         String tf2 = jtf2.getText();
         String tf3 = jtf3.getText();
         String tf4 = jtf4.getText();

         me.inputdb(tf1, tf2, tf3, tf4);
         me.redefJTable();
         jt.updateUI();
      }
   }

   class deleteAction implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         me.deleteRow(deleteRow);
         me.redefJTable();
         
      }
   }


   class renewAction implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         Menu1 me = new Menu1();

         String tf1 = jtf1.getText();
         String tf2 = jtf2.getText();
         String tf3 = jtf3.getText();
         String tf4 = jtf4.getText();
   
         me.updatedb(tf1, tf2, tf3, tf4);
   
         me.redefJTable();
         jt.updateUI();
   }

 }
}