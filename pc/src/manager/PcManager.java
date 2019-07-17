package manager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PcManager {
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	static PcDTO dto;
	static PcDAO dao;

	public PcManager() {
		JFrame f = new JFrame();

		f.setSize(500, 350);
		f.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("pc°í°´°ü¸® ÇÁ·Î±×·¥");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(149, 26, 206, 32);
		f.getContentPane().add(lblNewLabel);

		JButton b1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		b1.setFont(new Font("±¼¸²", Font.BOLD, 11));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PcDAO dao = new PcDAO();
				PcDTO dto = new PcDTO();
				String id = t1.getText();
				String name = t2.getText();
				String age = t3.getText();
				String tel = t4.getText();
				dto.setId(id);
				dto.setName(name);
				dto.setAge(age);
				dto.setTel(tel);
				boolean ok = dao.Pcmanager(dto);
			}
		});
		b1.setBounds(26, 257, 82, 40);
		f.getContentPane().add(b1);

		JButton b2 = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		b2.setFont(new Font("±¼¸²", Font.BOLD, 11));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PcDTO dto = new PcDTO();
				PcDAO dao = new PcDAO();
				String id = t1.getText();
				dto.setId(id);
				dao.deletePcManager(id);
			}
		});
		b2.setBounds(110, 257, 82, 40);
		f.getContentPane().add(b2);

		JButton b3 = new JButton("\uD68C\uC6D0\uC218\uC815");
		b3.setFont(new Font("±¼¸²", Font.BOLD, 11));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PcDTO dto = new PcDTO();
				PcDAO dao = new PcDAO();
				String id = t1.getText();
				String tel = t4.getText();
				dto.setId(id);
				dto.setTel(tel);
				dao.updatePcManager(dto);
			}
		});
		b3.setBounds(196, 257, 82, 40);
		f.getContentPane().add(b3);

		JButton b4 = new JButton("\uD68C\uC6D0\uAC80\uC0C9");
		b4.setFont(new Font("±¼¸²", Font.BOLD, 11));
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputId = t1.getText();
				PcDAO dao = new PcDAO();
				PcDTO dto = dao.select(inputId);
				String id = dto.getId();
				String name = dto.getName();
				String age = dto.getAge();
				String tel = dto.getTel();
				t1.setText(id);
				t2.setText(name);
				t3.setText(age);
				t4.setText(tel);

			}
		});
		b4.setBounds(282, 257, 82, 40);
		f.getContentPane().add(b4);

		JButton b5 = new JButton("\uC804\uCCB4\uAC80\uC0C9");
		b5.setFont(new Font("±¼¸²", Font.BOLD, 11));
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao = new PcDAO();
				dto = new PcDTO();

				ArrayList list = null;
				try {
					list = dao.selectAll();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println("È¸¿ø ÀüÃ¼ °Ë»ö");
				for (int i = 0; i < list.size(); i++) {
					PcDTO dto = (PcDTO) list.get(i);
					System.out.println(dto.getId() + "\t" + dto.getName() + "\t" + dto.getAge() + "\t" + dto.getTel());
				}
			}

		});
		b5.setBounds(368, 257, 89, 40);
		f.getContentPane().add(b5);

		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(80, 81, 57, 32);
		f.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uC774\uB984");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(80, 123, 57, 32);
		f.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uB098\uC774");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(80, 165, 57, 32);
		f.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(68, 207, 69, 40);
		f.getContentPane().add(lblNewLabel_4);

		t1 = new JTextField();
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		t1.setBounds(149, 87, 206, 21);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setHorizontalAlignment(SwingConstants.CENTER);
		t2.setColumns(10);
		t2.setBounds(149, 129, 206, 21);
		f.getContentPane().add(t2);

		t3 = new JTextField();
		t3.setHorizontalAlignment(SwingConstants.CENTER);
		t3.setColumns(10);
		t3.setBounds(149, 171, 206, 21);
		f.getContentPane().add(t3);

		t4 = new JTextField();
		t4.setHorizontalAlignment(SwingConstants.CENTER);
		t4.setColumns(10);
		t4.setBounds(149, 217, 206, 21);
		f.getContentPane().add(t4);

		f.setVisible(true);
	}

	public static void main(String[] args) {
		PcManager pm = new PcManager();
	}
}
