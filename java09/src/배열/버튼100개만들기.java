package 배열;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class 버튼100개만들기 {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("나의 버튼들....100개");
		f.setSize(1200, 800);
		
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		//버튼 들어갈자리 100개를 만들어둠.
		JButton[] buttons = new JButton[100];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("나는 버튼");
		}
		
		for (int i = 0; i < buttons.length; i++) {
			f.add(buttons[i]);
		}
		f.setVisible(true);
	}

}
