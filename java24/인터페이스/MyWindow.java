package 인터페이스;

import javax.swing.JButton;

public class MyWindow {

	public MyWindow() {
		setSize(300,300);
		JButton b = new JButton("나를 눌러요.");
		add(b);
		b.addActionListener(action);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		MyWindow name = new MyWindow();
	}

}
