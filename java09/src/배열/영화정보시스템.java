package �迭;

import java.awt.FlowLayout;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ��ȭ�����ý��� {

	public static void main(String[] args) {
		String[] movies = {"m1.PNG", "m2.PNG", "m3.PNG", "m4.PNG", "m5.PNG"};
		//�ڹٴ� �ʿ��� �κ��� ��ǰ(class)�� �����ؼ�
		//�����ؼ� �ڵ��ϴ� ���
		//��ǰ(��ü,���) ������ ���α׷�
		//��ü������ ���α׷�(Object-Oriented program, OOP)
		
		//Color.red : static(����)
		//new Button : instance
		
		JFrame f = new JFrame();
		f.setTitle("���� ��ȭ ���� �ý���");
		f.setSize(300, 597);
		//���帣���� �ϳ��� ������� �ٿ��ִ� Ŭ����
		FlowLayout flow = new FlowLayout();
		f.getContentPane().setLayout(flow);
		JButton img = new JButton();
		img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		f.getContentPane().add(img);
		
		//ImageIcon icon = new ImageIcon("m1.PNG");
		//img.setIcon(icon);
		
		JButton b1 = new JButton("<<<<<\uC0DD\uC77C>>>>>");
		b1.setBackground(new Color(0, 0, 0));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon icon = new ImageIcon("m1.PNG");
				img.setIcon(icon);
			}
		});
		b1.setForeground(Color.GREEN);
		b1.setFont(new Font("Dialog", Font.PLAIN, 22));
		f.getContentPane().add(b1);
		
		JButton b2 = new JButton("<<<<<\uD5EC\uBCF4\uC774>>>>>");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("m2.PNG");
				img.setIcon(icon);
			}
		});
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.GREEN);
		b2.setFont(new Font("Dialog", Font.PLAIN, 22));
		f.getContentPane().add(b2);
		
		JButton b3 = new JButton("<<<<<\uB3C8>>>>>");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("m3.PNG");
				img.setIcon(icon);
			}
		});
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.GREEN);
		b3.setFont(new Font("Dialog", Font.PLAIN, 22));
		f.getContentPane().add(b3);
		
		JButton b4 = new JButton("<<<<<\uD30C\uC774\uBE0C\uD53C\uD2B8>>>>>");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("m4.PNG");
				img.setIcon(icon);
			}
		});
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.GREEN);
		b4.setFont(new Font("Dialog", Font.PLAIN, 22));
		f.getContentPane().add(b4);
		
		JButton b5 = new JButton("<<<<<\uC5B4\uC2A4>>>>>");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("m5.PNG");
				img.setIcon(icon);
			}
		});
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.GREEN);
		b5.setFont(new Font("Dialog", Font.PLAIN, 22));
		f.getContentPane().add(b5);
		// ��üȭ�� ���־�� string�� �ǹ��ְ� �ν��Ѵ�.
		
//		URL url = new URL("http://www.naver.com");
//		File file = new File("c:/temp/test.txt");
//		PreparedStatement sql = new PreparedStatement("select * from member");
		
		
		
		
		
		f.setVisible(true);
	}

}
