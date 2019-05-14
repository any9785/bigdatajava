package pos;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Main {
	private static JTextField textField;

	public static void main(String[] args) {
		
		JFrame f = new JFrame("À½½ÄÁ¡ POS½Ã½ºÅÛ");
		f.setSize(900, 800);
		f.getContentPane().setLayout(null);
		
		JPanel p = new JPanel();
		p.setBounds(0, 0, 884, 761);
		f.getContentPane().add(p);
		p.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 884, 761);
		f.getContentPane().add(p1);
		p1.setLayout(null);
		
		JButton btnNewButton = new JButton("\uC885\uB8CC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(f, "Á¤¸» Á¾·áÇÏ½Ã°Ú½À´Ï±î?", "Á¾·á", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
	            if(result == JOptionPane.NO_OPTION) {
	               
	            }else if(result == JOptionPane.YES_OPTION){
	               System.exit(0);
	            }
			}
		});
		btnNewButton.setBounds(12, 10, 116, 61);
		p.add(btnNewButton);
		
		JButton button = new JButton("\uB85C\uADF8\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login l = new login();
			}
		});
		button.setBounds(756, 10, 116, 61);
		p.add(button);
		
		JButton button_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				member m = new member();
			}
		});
		button_1.setBounds(608, 10, 116, 61);
		p.add(button_1);
		
		JButton b1 = new JButton("1");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(false);
				p1.setVisible(true);
			}
		});
		b1.setFont(new Font("±¼¸²", Font.BOLD, 15));
		b1.setVerticalAlignment(SwingConstants.TOP);
		b1.setBounds(12, 140, 191, 148);
		p.add(b1);
		
		JButton b2 = new JButton("2");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(false);
				p1.setVisible(true);
			}
		});
		b2.setFont(new Font("±¼¸²", Font.BOLD, 15));
		b2.setVerticalAlignment(SwingConstants.TOP);
		b2.setBounds(237, 140, 191, 148);
		p.add(b2);
		
		JButton b3 = new JButton("3");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(false);
				p1.setVisible(true);
			}
		});
		b3.setFont(new Font("±¼¸²", Font.BOLD, 15));
		b3.setVerticalAlignment(SwingConstants.TOP);
		b3.setBounds(459, 140, 191, 148);
		p.add(b3);
		
		JButton b4 = new JButton("4");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(false);
				p1.setVisible(true);
			}
		});
		b4.setFont(new Font("±¼¸²", Font.BOLD, 15));
		b4.setVerticalAlignment(SwingConstants.TOP);
		b4.setBounds(681, 140, 191, 148);
		p.add(b4);
		
		JButton b5 = new JButton("5");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(false);
				p1.setVisible(true);
			}
		});
		b5.setFont(new Font("±¼¸²", Font.BOLD, 15));
		b5.setVerticalAlignment(SwingConstants.TOP);
		b5.setBounds(12, 298, 191, 148);
		p.add(b5);
		
		JButton b6 = new JButton("6");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(false);
				p1.setVisible(true);
			}
		});
		b6.setFont(new Font("±¼¸²", Font.BOLD, 15));
		b6.setVerticalAlignment(SwingConstants.TOP);
		b6.setBounds(237, 298, 191, 148);
		p.add(b6);
		
		JButton b7 = new JButton("7");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(false);
				p1.setVisible(true);
			}
		});
		b7.setFont(new Font("±¼¸²", Font.BOLD, 15));
		b7.setVerticalAlignment(SwingConstants.TOP);
		b7.setBounds(459, 298, 191, 148);
		p.add(b7);
		
		JButton b8 = new JButton("8");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(false);
				p1.setVisible(true);
			}
		});
		b8.setFont(new Font("±¼¸²", Font.BOLD, 15));
		b8.setVerticalAlignment(SwingConstants.TOP);
		b8.setBounds(681, 298, 191, 148);
		p.add(b8);
		
		JButton b9 = new JButton("9");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(false);
				p1.setVisible(true);
			}
		});
		b9.setFont(new Font("±¼¸²", Font.BOLD, 15));
		b9.setVerticalAlignment(SwingConstants.TOP);
		b9.setBounds(12, 456, 191, 148);
		p.add(b9);
		
		JButton b10 = new JButton("10");
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(false);
				p1.setVisible(true);
			}
		});
		b10.setFont(new Font("±¼¸²", Font.BOLD, 15));
		b10.setVerticalAlignment(SwingConstants.TOP);
		b10.setBounds(237, 456, 191, 148);
		p.add(b10);
		
		JButton b11 = new JButton("11");
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(false);
				p1.setVisible(true);
			}
		});
		b11.setFont(new Font("±¼¸²", Font.BOLD, 15));
		b11.setVerticalAlignment(SwingConstants.TOP);
		b11.setBounds(459, 456, 191, 148);
		p.add(b11);
		
		JButton b12 = new JButton("12");
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(false);
				p1.setVisible(true);
			}
		});
		b12.setFont(new Font("±¼¸²", Font.BOLD, 15));
		b12.setVerticalAlignment(SwingConstants.TOP);
		b12.setBounds(681, 456, 191, 148);
		p.add(b12);
		
		JButton button_13 = new JButton("\uBA54\uB274\uAD00\uB9AC");
		button_13.setBounds(87, 664, 116, 61);
		p.add(button_13);
		
		JButton button_14 = new JButton("\uC790\uB9AC\uC774\uB3D9");
		button_14.setBounds(237, 664, 116, 61);
		p.add(button_14);
		
		JButton button_15 = new JButton("\uB9E4\uCD9C\uD604\uD669");
		button_15.setBounds(390, 664, 116, 61);
		p.add(button_15);
		
		JButton button_16 = new JButton("\uBC1C\uC8FC\uC2DC\uC2A4\uD15C");
		button_16.setBounds(534, 664, 116, 61);
		p.add(button_16);
		
		JButton button_17 = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
			}
		});
		button_17.setBounds(681, 664, 116, 61);
		p.add(button_17);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(324, 44, 240, 61);
		p.add(lblNewLabel_7);
		


		
		JButton bb1 = new JButton("\uC8FC\uBB38");
		bb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.setVisible(false);
				p.setVisible(true);
			}
		});
		bb1.setBounds(769, 559, 103, 192);
		p1.add(bb1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 60, 390, 424);
		p1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("NO.");
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel.setBounds(38, 39, 57, 15);
		p1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC0C1\uD488\uBA85");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_1.setBounds(90, 39, 57, 15);
		p1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC2DC\uAC04");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_2.setBounds(164, 39, 57, 15);
		p1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC218\uB7C9");
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_3.setBounds(233, 39, 57, 15);
		p1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uAE08\uC561");
		lblNewLabel_4.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_4.setBounds(276, 39, 43, 15);
		p1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uCD94\uAC00");
		lblNewLabel_5.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_5.setBounds(331, 39, 35, 15);
		p1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uAD6C\uBD84");
		lblNewLabel_6.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_6.setBounds(377, 39, 43, 15);
		p1.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("\uC2DD\uC0AC\uB958");
		btnNewButton_1.setBounds(432, 35, 108, 43);
		p1.add(btnNewButton_1);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(769, 35, 103, 43);
		p1.add(button_2);
		
		JButton button_3 = new JButton("\uC548\uC8FC\uB958");
		button_3.setBounds(546, 35, 108, 43);
		p1.add(button_3);
		
		JButton button_4 = new JButton("\uC8FC\uB958");
		button_4.setBounds(660, 35, 103, 43);
		p1.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setBounds(432, 82, 108, 43);
		p1.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setBounds(546, 82, 108, 43);
		p1.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setBounds(660, 82, 103, 43);
		p1.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setBounds(769, 82, 103, 43);
		p1.add(button_8);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(432, 131, 108, 97);
		p1.add(btnNewButton_2);
		
		JButton button_9 = new JButton("");
		button_9.setBounds(546, 131, 108, 97);
		p1.add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setBounds(660, 131, 103, 97);
		p1.add(button_10);
		
		JButton button_11 = new JButton("");
		button_11.setBounds(769, 131, 103, 97);
		p1.add(button_11);
		
		JButton button_25 = new JButton("");
		button_25.setBounds(432, 238, 108, 97);
		p1.add(button_25);
		
		JButton button_26 = new JButton("");
		button_26.setBounds(546, 238, 108, 97);
		p1.add(button_26);
		
		JButton button_27 = new JButton("");
		button_27.setBounds(660, 238, 103, 97);
		p1.add(button_27);
		
		JButton button_28 = new JButton("");
		button_28.setBounds(769, 238, 103, 97);
		p1.add(button_28);
		
		JButton button_12 = new JButton("");
		button_12.setBounds(432, 345, 108, 97);
		p1.add(button_12);
		
		JButton button_18 = new JButton("");
		button_18.setBounds(546, 345, 108, 97);
		p1.add(button_18);
		
		JButton button_19 = new JButton("");
		button_19.setBounds(660, 345, 103, 97);
		p1.add(button_19);
		
		JButton button_20 = new JButton("");
		button_20.setBounds(769, 345, 103, 97);
		p1.add(button_20);
		
		JButton button_21 = new JButton("");
		button_21.setBounds(432, 452, 108, 97);
		p1.add(button_21);
		
		JButton button_22 = new JButton("");
		button_22.setBounds(546, 452, 108, 97);
		p1.add(button_22);
		
		JButton button_23 = new JButton("");
		button_23.setBounds(660, 452, 103, 97);
		p1.add(button_23);
		
		JButton button_24 = new JButton("");
		button_24.setBounds(769, 452, 103, 97);
		p1.add(button_24);
		
		JButton btnNewButton_3 = new JButton("\uCDE8\uC18C");
		btnNewButton_3.setBounds(660, 560, 103, 191);
		p1.add(btnNewButton_3);
		
		JButton button_29 = new JButton("\uACB0\uC81C");
		button_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				p1.setVisible(false);
				p.setVisible(true);
			}
		});
		button_29.setBounds(551, 560, 103, 191);
		p1.add(button_29);
		
		JButton button_30 = new JButton("\uD560\uC778");
		button_30.setBounds(437, 560, 103, 191);
		p1.add(button_30);
		
		textField = new JTextField();
		textField.setBounds(30, 494, 390, 257);
		p1.add(textField);
		textField.setColumns(10);
		
		JPanel p2 = new JPanel();
		p2.setBounds(0, 0, 884, 761);
		f.getContentPane().add(p2);
		
		
		p1.setVisible(false);
		f.setVisible(true);
		

	}
}
