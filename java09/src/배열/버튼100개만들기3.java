package �迭;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;

public class ��ư100�������3 {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.YELLOW);
		f.setTitle("���� ��ư��....200��");
		f.setSize(1200, 800);
		
		f.getContentPane().setLayout(null); //��ġ��ǰ�� �Ⱦ��ڴ�.
		
		//��ư ���ڸ� 100���� ������.
		JButton[] buttons = new JButton[200];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("���� ��ư" + i);
		}
		
		Random random = new Random();
		for (int i = 0; i < buttons.length; i++) {
			int x = random.nextInt(1000);
			int y = random.nextInt(800);
			buttons[i].setBounds(x, y, 100, 100);
			f.getContentPane().add(buttons[i]);			
		}
		
		
		f.setVisible(true);
	}

}
