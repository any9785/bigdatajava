package ��ǰ�����;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class �޴��ֹ��������� {
	private static JTextField t1;
	private static JTextField t2;

	static int sum = 0;
	static int count = 0;
	public static void main(String[] args) {
		//Ʋ1��, ��ư3��, ����1��, �ݾ�1��, �Է�ĭ2��, �׸�4��
		String[] foods = {"�߱���.jpg", "����.jpg", "«��.jpg", "�쵿.jpg"};
		JFrame f = new JFrame();
		f.setTitle("�߱���");
		f.setSize(800, 700);
		FlowLayout flow = new FlowLayout();
		f.getContentPane().setLayout(flow);
		JButton img = new JButton();
		
		ImageIcon icon = new ImageIcon("�߱���.jpg");
		
		JButton b1 = new JButton("«��");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("«��.jpg");
				img.setIcon(icon);
				sum += count+1;
				t1.setText(String.valueOf(sum));
				t2.setText(String.valueOf(sum*5000));
					
			}
		});
		b1.setBackground(Color.ORANGE);
		b1.setFont(new Font("����", Font.PLAIN, 18));
		f.getContentPane().add(b1);
		
		JButton b2 = new JButton("�쵿");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("�쵿.jpg");
				img.setIcon(icon);
				sum += count+1;
				t1.setText(String.valueOf(sum));
				t2.setText(String.valueOf(sum*5000));
			}
		});
		b2.setBackground(Color.ORANGE);
		b2.setFont(new Font("����", Font.PLAIN, 18));
		f.getContentPane().add(b2);
		
		JButton b3 = new JButton("����");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("����.jpg");
				img.setIcon(icon);
				sum += count+1;
				t1.setText(String.valueOf(sum));
				t2.setText(String.valueOf(sum*5000));
			}
		});
		b3.setBackground(Color.ORANGE);
		b3.setFont(new Font("����", Font.PLAIN, 18));
		f.getContentPane().add(b3);
		
		JLabel label = new JLabel("\uAC1C\uC218");
		f.getContentPane().add(label);
		
		t1 = new JTextField();
		f.getContentPane().add(t1);
		t1.setColumns(4);
		
		JLabel lblNewLabel = new JLabel("\uAE08\uC561");
		f.getContentPane().add(lblNewLabel);
		
		t2 = new JTextField();
		f.getContentPane().add(t2);
		t2.setColumns(7);
		img.setForeground(Color.WHITE);
		img.setFont(new Font("����", Font.PLAIN, 6));
		f.getContentPane().add(img);
		img.setIcon(new ImageIcon("\uC911\uAD6D\uC9D1.jpg"));
		
		
		
		
		
		
		f.setVisible(true);
	}

}
