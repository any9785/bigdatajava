package 부품만들기;

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


public class 메뉴주문연습문제 {
	private static JTextField t1;
	private static JTextField t2;

	static int sum = 0;
	static int count = 0;
	public static void main(String[] args) {
		//틀1개, 버튼3개, 개수1개, 금액1개, 입력칸2개, 그림4개
		String[] foods = {"중국집.jpg", "자장.jpg", "짬뽕.jpg", "우동.jpg"};
		JFrame f = new JFrame();
		f.setTitle("중국집");
		f.setSize(800, 700);
		FlowLayout flow = new FlowLayout();
		f.getContentPane().setLayout(flow);
		JButton img = new JButton();
		
		ImageIcon icon = new ImageIcon("중국집.jpg");
		
		JButton b1 = new JButton("짬뽕");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("짬뽕.jpg");
				img.setIcon(icon);
				sum += count+1;
				t1.setText(String.valueOf(sum));
				t2.setText(String.valueOf(sum*5000));
					
			}
		});
		b1.setBackground(Color.ORANGE);
		b1.setFont(new Font("굴림", Font.PLAIN, 18));
		f.getContentPane().add(b1);
		
		JButton b2 = new JButton("우동");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("우동.jpg");
				img.setIcon(icon);
				sum += count+1;
				t1.setText(String.valueOf(sum));
				t2.setText(String.valueOf(sum*5000));
			}
		});
		b2.setBackground(Color.ORANGE);
		b2.setFont(new Font("굴림", Font.PLAIN, 18));
		f.getContentPane().add(b2);
		
		JButton b3 = new JButton("자장");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("자장.jpg");
				img.setIcon(icon);
				sum += count+1;
				t1.setText(String.valueOf(sum));
				t2.setText(String.valueOf(sum*5000));
			}
		});
		b3.setBackground(Color.ORANGE);
		b3.setFont(new Font("굴림", Font.PLAIN, 18));
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
		img.setFont(new Font("굴림", Font.PLAIN, 6));
		f.getContentPane().add(img);
		img.setIcon(new ImageIcon("\uC911\uAD6D\uC9D1.jpg"));
		
		
		
		
		
		
		f.setVisible(true);
	}

}
