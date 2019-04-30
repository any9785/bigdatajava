package 배열;

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

public class 영화정보시스템 {

	public static void main(String[] args) {
		String[] movies = {"m1.PNG", "m2.PNG", "m3.PNG", "m4.PNG", "m5.PNG"};
		//자바는 필요한 부분의 부품(class)을 복사해서
		//조립해서 코딩하는 방식
		//부품(객체,대상) 조립식 프로그램
		//객체지향형 프로그램(Object-Oriented program, OOP)
		
		//Color.red : static(정적)
		//new Button : instance
		
		JFrame f = new JFrame();
		f.setTitle("나의 영화 정보 시스템");
		f.setSize(300, 597);
		//물흐르듯이 하나씩 순서대로 붙여주는 클래스
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
		// 객체화를 해주어야 string을 의미있게 인식한다.
		
//		URL url = new URL("http://www.naver.com");
//		File file = new File("c:/temp/test.txt");
//		PreparedStatement sql = new PreparedStatement("select * from member");
		
		
		
		
		
		f.setVisible(true);
	}

}
