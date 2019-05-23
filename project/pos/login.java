package pos;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class login extends JFrame{
   JTextField jtf2;
   private JPasswordField pf;
   JButton jb1, jb2;
   JPanel jp1, jp2;
   JLabel jl1, jl2;
   
   
   login(){
      setTitle("로그인창");
      
      jp1 = new JPanel();
      jp2 = new JPanel();
      
      
      jl1 = new JLabel("ID");
      jl1.setBounds(44, 42, 26, 27);
      jl2 = new JLabel("PW");
      jl2.setBounds(44, 79, 26, 27);
      
      jb1 = new JButton("회원가입");
      jb1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            MemberProc mp = new MemberProc();
         }
      });
      jb2 = new JButton("로그인");
      jb2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String inputid = jtf2.getText();
            String inputpw = pf.getText();
            loginDAO dao = new loginDAO();
            MemberDTO1 dto = dao.login(inputid,inputpw);
         }
      });
      jp1.setLayout(null);
      
      jp1.add(jl1);
      jp1.add(jl2);
      jtf2 = new JTextField(10);
      jtf2.setBounds(82, 42, 171, 21);
      jp1.add(jtf2);
      
      jp2.add(jb1);
      jp2.add(jb2);
      
      getContentPane().add(jp1, BorderLayout.CENTER);
      
      pf = new JPasswordField();
      pf.setBounds(82, 82, 171, 21);
      jp1.add(pf);
      getContentPane().add(jp2, "South");
      
      
      
      
      
      
      
      setSize(300, 200);
      
      setVisible(true);
   }
   
   
   public static void main(String args[]) {
      new login();   
      }


}
