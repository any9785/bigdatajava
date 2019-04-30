package 배열;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;

public class 버튼100개만들기3 {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.YELLOW);
		f.setTitle("나의 버튼들....200개");
		f.setSize(1200, 800);
		
		f.getContentPane().setLayout(null); //배치부품들 안쓰겠다.
		
		//버튼 들어갈자리 100개를 만들어둠.
		JButton[] buttons = new JButton[200];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("나는 버튼" + i);
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
