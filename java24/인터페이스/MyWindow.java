package �������̽�;

import javax.swing.JButton;

public class MyWindow {

	public MyWindow() {
		setSize(300,300);
		JButton b = new JButton("���� ������.");
		add(b);
		b.addActionListener(action);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		MyWindow name = new MyWindow();
	}

}
