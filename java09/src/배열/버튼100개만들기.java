package �迭;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ��ư100������� {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("���� ��ư��....100��");
		f.setSize(1200, 800);
		
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		//��ư ���ڸ� 100���� ������.
		JButton[] buttons = new JButton[100];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("���� ��ư");
		}
		
		for (int i = 0; i < buttons.length; i++) {
			f.add(buttons[i]);
		}
		f.setVisible(true);
	}

}
