package window;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class window {
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setSize(500, 500);      //.은 접근연산자
		f.setTitle("나의 첫번째 그래픽 프로그램");  //제목
		
		JButton b1 = new JButton("나를 눌러주세요..!!!!"); 
		//f.add(b1); = 버튼생성 후 open with-> WindowBulider Editor생성
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		f.getContentPane().add(b1);
		
		f.setVisible(true);     //화면 보여줌 but false면 안보여줌
		
	}

}
