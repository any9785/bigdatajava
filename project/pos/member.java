package pos;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class member {
	private static JTextField t;
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;
	

	public member() {
		
		
		JFrame f = new JFrame("회원가입");
		f.setSize(400, 400);
		f.getContentPane().setLayout(null);
		
		t = new JTextField();
		t.setBounds(87, 67, 200, 30);
		f.getContentPane().add(t);
		t.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 68, 63, 27);
		f.getContentPane().add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(87, 107, 200, 30);
		f.getContentPane().add(t1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(87, 148, 200, 30);
		f.getContentPane().add(t2);
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uAC00\uC785 \uC815\uBCF4 \uC785\uB825");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(22, 24, 338, 31);
		f.getContentPane().add(lblNewLabel_1);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(87, 188, 200, 30);
		f.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(87, 226, 200, 30);
		f.getContentPane().add(t4);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(12, 108, 63, 27);
		f.getContentPane().add(lblPassword);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(12, 148, 63, 27);
		f.getContentPane().add(lblName);
		
		JLabel lblBirth = new JLabel("Birth");
		lblBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBirth.setBounds(12, 188, 63, 27);
		f.getContentPane().add(lblBirth);
		
		JLabel lblTel = new JLabel("Tel");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setBounds(12, 226, 63, 27);
		f.getContentPane().add(lblTel);
		
		JButton btnNewButton = new JButton("\uAC00\uC785");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				memberDAO dao = new memberDAO();
				memberDTO dto = new memberDTO();
				String id = t.getText();
				String pw = t1.getText();
				String name = t2.getText();
				String birth = t3.getText();
				String tel = t4.getText();
				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				dto.setBirth(birth);
				dto.setTel(tel);
				
				try {
					dao.member(dto);
				} catch (Exception e) {
					System.out.println("에러발생!!에러발생!!");
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(87, 292, 87, 41);
		f.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\uCDE8\uC18C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(f, "정말 취소하시겠습니까?", "취소", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
	            if(result == JOptionPane.NO_OPTION) {
	               
	            }else if(result == JOptionPane.YES_OPTION){
	               f.dispose();
	            }  
			}
		});
		button.setBounds(200, 292, 87, 41);
		f.getContentPane().add(button);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputid = t.getText();
				memberDAO dao = new memberDAO();
				memberDTO dto = dao.insert(inputid);
			}
		});
		btnNewButton_1.setBounds(299, 65, 73, 32);
		f.getContentPane().add(btnNewButton_1);
		
		
		
		f.setVisible(true);

	}

}