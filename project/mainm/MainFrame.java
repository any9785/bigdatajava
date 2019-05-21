package mainm;

import javax.swing.JFrame;
//import p1.POSPanel;

public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("POS 프로그램");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setContentPane(new MainPanel());

		setSize(985,660);
		setVisible(true);
	}

}
