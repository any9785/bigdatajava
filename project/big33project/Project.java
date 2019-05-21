package big33project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class Project extends JFrame implements ActionListener {
	JPanel panel, p, p1;
	JTextField t1, t2;
	JButton login, out;
	JLabel l1,l2, img;

public Project() {
	String file ="김치찌개.jpg";
	panel = new JPanel();
	p = new JPanel();p1 = new JPanel();
	t1 = new JTextField(15);t2 = new JTextField(15);

	login = new JButton("로그인");out = new JButton("종료");
	l1 = new JLabel("ID");l2 = new JLabel("PW");
	img = new JLabel();
	setSize(450, 450);
	setTitle("식당 관리 프로그램");
	login.addActionListener(this);
	out.addActionListener(this);
	ImageIcon icon = new ImageIcon(file);
	img.setIcon(icon);
	panel.setBackground(new Color(162, 239, 219));
	p1.setBackground(new Color(212, 237, 189));
	p.add(l1); p.add(t1);
	p.add(l2); p.add(t2);
	p1.add(login);p1.add(out);
	panel.add(img);
	panel.add(p);
	panel.add(p1);
	add(panel);
	setResizable(false);
	setLocationRelativeTo(null);
	setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String id = t1.getText();
		String pw = t2.getText();
		String myid = "a";
		String mypw = "s";
 
		if (e.getSource() == login) {
			if (id.equals(myid) && pw.equals(mypw)) {
				TableMain run = null;
				try {
					run = new TableMain();
					run.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}//테이블
				t1.setText("");
				t2.setText("");
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "틀림");
				t1.setText("");
				t2.setText("");
			}
		}
		if (e.getSource() == out) {
			dispose();
		}
	}

		public static void main(String[] args) {
			new Project();
		}
}
