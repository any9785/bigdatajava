package pos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {
   private static JTextField t;
   private static JTextField t1;

   public Login() {
      JFrame f = new JFrame("·Î±×ÀÎ");
      f.setSize(400, 300);
      f.getContentPane().setLayout(null);
      
      JLabel lblNewLabel = new JLabel("ID");
      lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 32));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(38, 69, 57, 47);
      f.getContentPane().add(lblNewLabel);
      
      JLabel lblPw = new JLabel("Pw");
      lblPw.setHorizontalAlignment(SwingConstants.CENTER);
      lblPw.setFont(new Font("±¼¸²", Font.PLAIN, 32));
      lblPw.setBounds(38, 126, 57, 47);
      f.getContentPane().add(lblPw);
      
      t = new JTextField();
      t.setBounds(114, 69, 191, 41);
      f.getContentPane().add(t);
      t.setColumns(10);
      t1 = new JTextField();
      t1.setColumns(10);
      t1.setBounds(114, 126, 191, 41);
      f.getContentPane().add(t1);
      
      JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            String inputid = t.getText();
            String inputpw = t1.getText();
            LoginDAO dao = new LoginDAO();
            LoginDTO dto = dao.login(inputid, inputpw);
         }
      });
      
      btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 32));
      btnNewButton.setBounds(134, 192, 137, 32);
      f.getContentPane().add(btnNewButton);
      f.setVisible(true);

   }
}
