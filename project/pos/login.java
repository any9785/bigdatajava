package pos;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login {
	private static JTextField userid;
	private JPasswordField pwd;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblResult;
	
	private Map <String,String> map;
	
	
	public login() {
		JFrame f = new JFrame("�α���â");
		f.setSize(400, 400);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBounds(77, 132, 57, 35);
		f.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(77, 177, 89, 38);
		f.getContentPane().add(lblNewLabel_1);
		
		userid = new JTextField();
		userid.setBounds(178, 141, 116, 21);
		f.getContentPane().add(userid);
		userid.setColumns(10);
		
		btnNewButton = new JButton("�α���");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = userid.getText();
				String pw = String.valueOf(pwd.getPassword());
				String strID = map.get(id);
				if(strId != null && strId.equals(pw)) {
					lblResult.setText(id+ "�� ȯ���մϴ�.");
				}else {
					lblResult.setText("���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
			}
				
			
		});
		btnNewButton.setBounds(77, 252, 97, 23);
		f.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(f, "���� �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
	            if(result == JOptionPane.NO_OPTION) {
	               
	            }else if(result == JOptionPane.YES_OPTION){
	               System.exit(0);
	            }
			}
		});
		btnNewButton_1.setBounds(197, 252, 97, 23);
		f.getContentPane().add(btnNewButton_1);
		
		pwd = new JPasswordField();
		pwd.setBounds(178, 188, 116, 21);
		f.getContentPane().add(pwd);
		
		
		f.setVisible(true);
	}
}
