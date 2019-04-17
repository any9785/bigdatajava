package window;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class window2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame f = new JFrame();
		JButton b1 = new JButton("자바 프로젝트");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("다음주부터 자바프로젝트가 시작됩니다.");
			}
		});
		
		f.setSize(300, 300); 
		f.setTitle("자바 프로젝트 시작");
		f.getContentPane().add(b1);
		//f.add(b1);
		f.setVisible(true);

	}

}
