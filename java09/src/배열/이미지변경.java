package �迭;

import java.awt.FlowLayout;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class �̹������� {
	static int status = 2;

	public static void main(String[] args) {
		String[] movies = {"m1.PNG", "m2.PNG", "m3.PNG", "m4.PNG"};
		JFrame f = new JFrame();
		
		f.setTitle("�̹��� ����");
		f.setSize(300, 450);
		FlowLayout flow = new FlowLayout();
		f.getContentPane().setLayout(flow);
		JButton img = new JButton();
		f.getContentPane().add(img);
		
		ImageIcon icon = new ImageIcon("m3.PNG");
		
		JButton b1 = new JButton("��������");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( status == 0) {
					ImageIcon icon = new ImageIcon(movies[status-1]);
					img.setIcon(icon);
					status = status - 1;
				}else {
					JOptionPane.showMessageDialog(null, "���ʸ������Դϴ�. ������ưŬ���ϼ���");
				}
			}
		});
		b1.setFont(new Font("����", Font.BOLD | Font.ITALIC, 18));
		b1.setBackground(SystemColor.activeCaption);
		b1.setForeground(Color.BLUE);
		f.getContentPane().add(b1);
		
		JButton b2 = new JButton("����������");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(status + 1 >= 4) {
					ImageIcon icon = new ImageIcon(movies[status-1]);
					img.setIcon(icon);
					status = status - 1;
				}else {
					JOptionPane.showMessageDialog(null, "�����ʸ������Դϴ�. ������ưŬ�����ּ���");
				}
				
			}
			
		});
		b2.setFont(new Font("����", Font.BOLD | Font.ITALIC, 18));
		b2.setBackground(SystemColor.activeCaption);
		b2.setForeground(Color.BLUE);
		f.getContentPane().add(b2);
		//��üȭ ���־�� string�� �ǹ��ְ� �ǽ��Ѵ�.
		f.setVisible(true);

	}
}
