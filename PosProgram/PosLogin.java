package PosProgram;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import pos.MemberDTO1;
import pos.loginDAO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import javax.swing.JPanel;

public class PosLogin extends JFrame {
	private JPasswordField tfpwd;
	private JButton bt_exit = new JButton("\uC885\uB8CC");
	private JButton bt_ok = new JButton("\uB85C\uADF8\uC778");
	private String str="";
	private JLabel lbTitle = new JLabel("LOGIN");
	private PosMain ps;
	private JLabel Timage;
	private ImageIcon img = null;
	private URL imageURL;
	private final JPanel panel2 = new JPanel();
	private final JTextField tfid = new JTextField();
	private final JButton button = new JButton("\uD68C\uC6D0\uAC00\uC785");

	public PosLogin(){
		super("POS");
		tfid.setBounds(245, 51, 240, 44);
		tfid.setColumns(10);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("chickenicon.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		}
		
		login_bt();//로그인 창
		ok_exit_bt();//확인,종료
		num_bt();//숫자버튼
		background();//배경
	}
	public void wrong_dialog(String str){
		JLabel label = new JLabel(str);
		label.setFont(new Font("휴먼옛체", Font.PLAIN , 15));
		JOptionPane.showMessageDialog(null,label,"비밀번호 오류",JOptionPane.PLAIN_MESSAGE);
		tfid.setText("");
		tfpwd.setText("");
	}
	public void correct_dialog(String str){
		JLabel label = new JLabel(str);
		label.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
		JOptionPane.showMessageDialog(null,label,"로그인 성공",JOptionPane.PLAIN_MESSAGE);
	}
	public void login_bt(){

		getContentPane().setFont(new Font("굴림", Font.PLAIN, 12));
		setTitle("POS \uB85C\uADF8\uC778");
		getContentPane().setLayout(null);
	}
	public void ok_exit_bt(){
		bt_ok.setIcon(null);
		bt_ok.setBounds(223, 227, 103, 66);
		panel2.setBackground(new Color(255, 255, 224));
		panel2.add(bt_ok);
		bt_ok.setFont(new Font("Dialog", Font.BOLD, 17));
		bt_ok.setBackground(new Color(250, 235, 215));

		bt_ok.setForeground(new Color(0, 0, 0));
		bt_ok.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) { //로그인 버튼
				//@SuppressWarnings("deprecation")
				String inputid = tfid.getText();
				String inputpwd = tfpwd.getText();
				LoginDAO dao = new LoginDAO();
				PosProgram.MemberDTO1 dto = dao.login(inputid,inputpwd);
				
				if(!inputpwd.equals(tfpwd.getText())){
					wrong_dialog("비밀번호를 다시 입력하세요.");
					str="";
				}
				else{//성공
					correct_dialog("로그인 성공! 반갑습니다.");	
					if(ps==null){//객체가 생성되기 전 로그인시
						try {
							LoginDAO dao1 = new LoginDAO();
							ps = new PosMain(PosLogin.this);
							tfpwd.setText("");
							str="";
						} catch (IOException e1) {
						}
					}
					else{//객체 생성되어서 로그인시
						ps.setVisible(true);
						tfpwd.setText("");
						str="";
					}
					setVisible(false);
				}
			}
		});
		bt_exit.setIcon(null);
		bt_exit.setBounds(355, 227, 96, 66);
		panel2.add(bt_exit);
		bt_exit.setFont(new Font("Dialog", Font.BOLD, 17));
		bt_exit.setForeground(new Color(0, 0, 0));
		bt_exit.setBackground(new Color(250, 235, 215));
		bt_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel label = new JLabel("정말 종료 하시겠습니까?");
				label.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
				int result = JOptionPane.showConfirmDialog(null,label,"종료",
								JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
	}
	public void num_bt(){
	}
	public void focus(){
		bt_exit.setFocusable(false);
		bt_ok.setFocusable(false);
		tfpwd.setFocusable(true);
	}
	public void background(){
		
		
		imageURL = getClass().getClassLoader().getResource("login.gif");
		img = new ImageIcon(imageURL);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setLayout(null);
		panel.setBounds(63, 34, 550, 108);
		getContentPane().add(panel);
		Timage = new JLabel();
		Timage.setBounds(0, 0, 158, 108);
		panel.add(Timage);
		Timage.setBackground(Color.WHITE);
		lbTitle.setForeground(Color.BLUE);
		lbTitle.setBounds(84, 0, 398, 108);
		panel.add(lbTitle);
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Papyrus", Font.BOLD, 75));
		
		panel2.setLayout(null);
		panel2.setBounds(60, 172, 553, 303);
		getContentPane().add(panel2);
		JLabel lbid = new JLabel("\uC544\uC774\uB514");
		lbid.setForeground(new Color(0, 0, 0));
		lbid.setBounds(41, 51, 109, 41);
		panel2.add(lbid);
		lbid.setFont(new Font("Dialog", Font.BOLD, 32));
		
				JLabel lbpwd = new JLabel("\uBE44\uBC00\uBC88\uD638");
				lbpwd.setForeground(new Color(0, 0, 0));
				lbpwd.setBounds(41, 156, 156, 41);
				panel2.add(lbpwd);
				lbpwd.setFont(new Font("Dialog", Font.BOLD, 32));
						
								tfpwd = new JPasswordField();
								tfpwd.setForeground(Color.BLACK);
								tfpwd.setBounds(245, 160, 240, 40);
								panel2.add(tfpwd);
								tfpwd.setFont(new Font("SansSerif", Font.PLAIN, 23));
								tfpwd.setBackground(Color.WHITE);
								
								panel2.add(tfid);
								button.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										MemberProc mp = new MemberProc();
									}
								});
								button.setForeground(Color.BLACK);
								button.setFont(new Font("Dialog", Font.BOLD, 17));
								button.setFocusable(false);
								button.setBackground(new Color(250, 235, 215));
								button.setBounds(94, 227, 103, 66);
								
								panel2.add(button);
		setSize(670,540);
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize(); //화면 사이즈를 넣어줌		 
		Dimension dimen1 = getSize(); //프레임 사이즈 입력
		int xpos = (int)(dimen.getWidth())/2-(int)dimen1.getWidth()/2; //화면사이즈/2 - 프레임사이즈/2 (화면중앙)		
		int ypos = (int)(dimen.getHeight())/2 -(int)dimen1.getHeight()/2;		
		this.setUndecorated(true);
		setLocation(xpos, ypos); //화면중앙에 위치
		setVisible(true);
		setResizable(false);
		focus();
	}
}


//import java.awt.event.*;
//import java.io.IOException;
//
//import javax.swing.*;
//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.*;
//
//
//public class PosLogin extends JFrame{
//   JTextField jtf2;
//   private JPasswordField pf;
//   JButton jb1, jb2;
//   JPanel jp1, jp2;
//   JLabel jl1, jl2;
//   private PosMain ps;
//   
//   PosLogin(){
//      setTitle("로그인창");
//      
//      jp1 = new JPanel();
//      jp2 = new JPanel();
//      
//      
//      jl1 = new JLabel("ID");
//      jl1.setBounds(44, 42, 26, 27);
//      jl2 = new JLabel("PW");
//      jl2.setBounds(44, 79, 26, 27);
//      
//      jb1 = new JButton("회원가입");
//      jb1.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            MemberProc mp = new MemberProc();
//         }
//      });
//      jb2 = new JButton("로그인");
//      jb2.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            String inputid = jtf2.getText();
//			String inputpw = pf.getText();
//            LoginDAO dao = new LoginDAO();
//            MemberDTO1 dto = dao.login(inputid,inputpw);
//            //ps = new PosMain();
//					//try {
//						//ps = new PosMain(PosLogin.this);
//					//} catch (IOException e1) {
//					//}
//				//setVisible(false);
//			}
//      });
//      jp1.setLayout(null);
//      
//      jp1.add(jl1);
//	   jp1.add(jl2);
//	   jtf2 = new JTextField(10);
//      jtf2.setBounds(82, 42, 171, 21);
//      jp1.add(jtf2);
//      
//      jp2.add(jb1);
//      jp2.add(jb2);
//     
//      getContentPane().add(jp1, BorderLayout.CENTER);
//      
//      pf = new JPasswordField();
//      pf.setBounds(82, 82, 171, 21);
//      jp1.add(pf);
//      getContentPane().add(jp2, "South");
//      
//      setSize(300, 200);
//      
//      setVisible(true);
//   }
//   
//   
//   public static void main(String args[]) {
//      new PosLogin();   
//      }
//
//
//}
