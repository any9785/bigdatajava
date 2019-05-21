package mainm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import pos.Main;

public class MainPanel extends JPanel {
	int[] num = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
	JButton[] MBtn = new JButton[16];
	String[] menu = {
			"���Ƕ��̽�","��������","��ġ����","�Ұ�ⵤ��",
			"��ġ�","�����","û����","�δ��",
			"���","�ø�","Į����","��ġ����",
			"�ᱹ��","���","���","�쵿"};
	int[] price = {
			6000,6500,5500,6500,
			5000,5000,5500,5500,
			3500,4000,4500,4500,
			4500,2000,7000,4500};
	
	JTextField tf = new JTextField(30);
	JButton[] SBtn = new JButton[4];
	String[] Str = {"����","�������","��ü���","����"};
	String [] ColName = {"�޴���ȣ","�޴�","����","����"};
	String [][] Data ;
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	
	class Screen extends JPanel{
		Screen(){
			setBackground(Color.BLACK);
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("�������", Font.BOLD, 15));
			add(new JScrollPane(table));
		}
	}
	
	class MenuBtn extends JPanel{
		MenuBtn(){
			setLayout(new GridLayout(6,3,3,3));
			setBackground(Color.WHITE);
			for(int i=0;i<MBtn.length;i++) {
				MBtn[i]= new JButton(menu[i]);
				add(MBtn[i]);
			}
		}
	}
	
	class StrBtn extends JPanel{
		StrBtn(){
			setBackground(Color.WHITE);
			setLayout(new GridLayout(1,4,3,3));
			
			for(int i=0;i<Str.length;i++) {
				SBtn[i]= new JButton(Str[i]);
				add(SBtn[i]);
			}
		}
	}
	
	public MainPanel() { //��ü�г�
		setLayout(null);
		setBackground(Color.WHITE);
		MenuBtn mbtn = new MenuBtn();
		StrBtn sbtn = new StrBtn();
		Screen sc = new Screen();
		
		//�ݾ׶�
		tf.setSize(450, 70);
		tf.setLocation(50, 480);
		add(tf);
		
		sc.setSize(500, 500);
		sc.setLocation(25, 20);
		add(sc);
		
		mbtn.setSize(400, 430);
		mbtn.setLocation(530, 23);
		add(mbtn);
		
		sbtn.setSize(400, 70);
		sbtn.setLocation(530, 480);
		add(sbtn);
		
		//�޴��߰�
		for(int i=0;i<MBtn.length;i++) {
			final int index =i;
			MBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)table.getModel();
					m.addRow(new Object[]{num[index],menu[index],count,price[index]});
				}
			});
		}
		//����
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				table.setValueAt(0, table.getSelectedRow(), 3);
			}
		});
		
			//�������
		SBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.removeRow(table.getSelectedRow());
			}
		});
		
		
		//��ü���
		SBtn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.setRowCount(0);
				tf.setText(String.valueOf(""));
			}
		});
		
		//������ư
		SBtn[3].addActionListener(new ActionListener() {
			PosMain m = new PosMain();
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				int rowCont = table.getRowCount();
				int sum =0;
				for(int i=0;i<rowCont;i++) {
					sum += (int)table.getValueAt(i, 3);
				}
				tf.setText(String.valueOf(" �� �ݾ� : "+sum));
				tf.setFont(new Font("�������", Font.BOLD, 40));
				
			}
		});
	}
}
