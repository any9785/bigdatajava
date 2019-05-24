package PosProgram;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import javax.swing.Icon;
import java.awt.SystemColor;

public class PosMain extends JFrame implements Runnable{

	private Thread thread;
	private JTextField chargetext;
	private JTextField paytext;
	private JTextField sumtext;
	private String str="";
	private JLabel Timage;
	private ImageIcon img = null;
	private URL imageURL;
	private ImageIcon img1 = null;
	private URL imageURL1;
	private JPanel panel_1 = new JPanel();
	private JPanel panel = new JPanel();
	private JButton bt_sale = new JButton("\uB9E4\uCD9C\uD604\uD669");
	private JButton back_bt = new JButton("\uB4A4\uB85C\uAC00\uAE30");
	private JButton calc_bt = new JButton("\uACB0 \uC81C");
	private JButton exit_bt = new JButton("\uC885\uB8CC");
	private JLabel label_sum = new JLabel("\uD569    \uACC4 :");
	private JButton table1 = new JButton("1");
	private JButton table2 = new JButton("2");
	private JButton table3 = new JButton("3");
	private JButton table4 = new JButton("4");
	private JButton table5 = new JButton("5");
	private JButton table6 = new JButton("6");
	private JButton table7 = new JButton("7");
	private JButton table8 = new JButton("8");
	private JButton table9 = new JButton("9");
	private int[] price= new int[9];
	private JLabel label_charge = new JLabel("\uAC70\uC2A4\uB984\uB3C8 :");
	private boolean[] tableflag = new boolean[9];
	private JLabel label_pay = new JLabel("\uBC1B\uC740\uAE08\uC561 :");
	private int[] cnt = new int[9];
	private int[] cnt1 = new int[9];
	private int[] cnt2 = new int[9];
	private int[] cnt3 = new int[9];
	private int[] cnt4 = new int[9];
	private int[] cnt5 = new int[9];
	private int[] cnt6 = new int[9];
	private int[] cnt7 = new int[9];
	private int[] cnt8 = new int[9];
	private int[] cnt9 = new int[9];

	private JLabel lblTitle = new JLabel("POS");
	private MaeChul mae = new MaeChul(this);
	private PosLogin posLogin;

	public PosMain(PosLogin posLogin) throws IOException {
		main_func(posLogin);
		bt_set(posLogin);//버튼 
		bt_init();//버튼 포커스 초기화
		main_bg();//메인배경
	}
	public void bt_set(PosLogin posLogin) {

		calc_bt.setBackground(new Color(60, 179, 113));
		calc_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!paytext.getText().equals("") && !sumtext.getText().equals("0")){
					if(!(Integer.parseInt(sumtext.getText())>Integer.parseInt(paytext.getText()))){
						int exchange = Integer.parseInt(paytext.getText())-Integer.parseInt(sumtext.getText());
						chargetext.setText(String.valueOf(exchange));
						JLabel ok_label = new JLabel("계산 완료 !");
						ok_label.setFont(new Font("휴먼옛체", Font.PLAIN, 18));
						String[] bt = {"확인"};
						int ret = JOptionPane.showOptionDialog(null,ok_label,"계산", 
								JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE,null,bt,"확인");
						if(ret==JOptionPane.OK_OPTION){
							sumtext.setText("0");
							paytext.setText("");
							chargetext.setText("0");
							table_init(flaginit()+1);
							str="";
						}
						mae.setCnt(cnt);
					}
				}
			}
		});
		calc_bt.setFont(new Font("휴먼옛체", Font.PLAIN, 50));
		calc_bt.setBounds(688, 221, 310, 79);
		getContentPane().add(calc_bt);

		exit_bt.setBackground(new Color(255, 255, 224));
		exit_bt.setFont(new Font("Dialog", Font.BOLD, 23));
		exit_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel label = new JLabel("정말 종료하시겠습니까?");
				label.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
				int result = JOptionPane.showConfirmDialog(null,label,"종료",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});

		exit_bt.setBounds(773, 791, 137, 79);
		getContentPane().add(exit_bt);
		back_bt.setBackground(new Color(255, 255, 224));
		back_bt.setFont(new Font("Dialog", Font.BOLD, 23));
		back_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel label = new JLabel("로그인 화면으로 돌아가시겠습니까?");
				label.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
				int result = JOptionPane.showConfirmDialog(null,label,"돌아가기",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.OK_OPTION){

					posLogin.setVisible(true);
					setVisible(false);
				}
			}
		});
		back_bt.setBounds(566, 791, 137, 79);
		getContentPane().add(back_bt);
	}

	public void input_cnt() {
				
	}
	public void main_bg() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("chickenicon.png")));
		this.setUndecorated(true);
		mae.setVisible(false);
		setTitle("POS \uC2DC\uC2A4\uD15C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Member_List ml = new Member_List();
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 23));
		btnNewButton.setBounds(144, 791, 137, 79);
		getContentPane().add(btnNewButton);
		setSize(1070,920);
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize(); //화면 사이즈를 넣어줌		 
		Dimension dimen1 = getSize(); //프레임 사이즈 입력
		int xpos = (int)(dimen.getWidth())/2-(int)dimen1.getWidth()/2; //화면사이즈/2 - 프레임사이즈/2 (화면중앙)		
		int ypos = (int)(dimen.getHeight())/2 -(int)dimen1.getHeight()/2;		
		setLocation(xpos, ypos); //화면중앙에 위치
		setVisible(true);
		setResizable(false);
	}
	public void main_func(PosLogin posLogin){

		chargetext = new JTextField();
		chargetext.setBackground(new Color(255, 255, 224));
		chargetext.setEditable(false);
		chargetext.setFont(new Font("Dialog", Font.BOLD, 45));
		chargetext.setText("0");
		chargetext.setHorizontalAlignment(SwingConstants.RIGHT);
		chargetext.setBounds(815, 500, 205, 70);
		getContentPane().add(chargetext);
		chargetext.setColumns(10);

		paytext = new JTextField();
		paytext.setBackground(new Color(255, 255, 224));
		paytext.setFont(new Font("Dialog", Font.BOLD, 45));
		paytext.setHorizontalAlignment(SwingConstants.RIGHT);
		paytext.setColumns(10);
		paytext.setBounds(815, 420, 205, 70);
		getContentPane().add(paytext);

		label_sum.setForeground(new Color(0, 0, 0));
		label_sum.setHorizontalAlignment(SwingConstants.RIGHT);
		label_sum.setFont(new Font("휴먼엑스포", Font.BOLD, 27));
		label_sum.setBounds(658, 347, 145, 66);
		getContentPane().add(label_sum);

		label_pay.setForeground(new Color(0, 0, 0));
		label_pay.setHorizontalAlignment(SwingConstants.RIGHT);
		label_pay.setFont(new Font("휴먼엑스포", Font.BOLD, 27));
		label_pay.setBounds(658, 427, 145, 66);
		getContentPane().add(label_pay);

		label_charge.setForeground(new Color(0, 0, 0));
		label_charge.setHorizontalAlignment(SwingConstants.RIGHT);
		label_charge.setFont(new Font("휴먼엑스포", Font.BOLD, 27));
		label_charge.setBounds(658, 507, 145, 66);
		getContentPane().add(label_charge);

		sumtext = new JTextField();
		sumtext.setBackground(new Color(255, 255, 224));
		sumtext.setEditable(false);
		sumtext.setFont(new Font("Dialog", Font.BOLD, 45));
		sumtext.setHorizontalAlignment(SwingConstants.RIGHT);
		sumtext.setText("0");
		sumtext.setColumns(10);
		sumtext.setBounds(815, 340, 205, 70);
		getContentPane().add(sumtext);

		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 228, 225));
		panel_1.setBounds(50, 20, 960, 108);
		getContentPane().add(panel_1);

		lblTitle.setLocation(0, 0);
		lblTitle.setSize(960, 108);
		lblTitle.setForeground(Color.BLACK);
		panel_1.add(lblTitle);
		lblTitle.setBackground(new Color(255, 255, 224));
		lblTitle.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 80));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

		imageURL = getClass().getClassLoader().getResource("aa.gif");
		imageURL1 = getClass().getClassLoader().getResource("gg.gif");
		img = new ImageIcon(imageURL);
		img1 = new ImageIcon(imageURL1);
		Timage = new JLabel((Icon) null);
		Timage.setLocation(31, 0);
		Timage.setSize(146, 110);
		panel_1.add(Timage);
		PosMain ps = this;
		bt_sale.setBounds(353, 791, 137, 79);
		getContentPane().add(bt_sale);
		bt_sale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mae.setVisible(true);
				ps.setVisible(false);

			}
		});
		bt_sale.setBackground(new Color(255, 255, 224));

		bt_sale.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 23));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(50, 218, 626, 541);
		panel.setLayout(null);
		getContentPane().add(panel);
		table1.setForeground(Color.BLACK);
		table1.setBackground(new Color(255, 228, 225));
		table1.setBounds(0, 0, 188, 172);
		panel.add(table1);
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[0]!=0){
						menuinit(0);	
						sumtext.setText(String.valueOf(price[0]));
					}
				}
				else if(e.getClickCount()==2){
					try {
						new Tables("Table 1번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		table1.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table2.setForeground(Color.BLACK);
		table2.setBackground(new Color(255, 228, 225));
		table2.setBounds(200, 0, 188, 172);
		panel.add(table2);
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[1]!=0){
						menuinit(1);		
						sumtext.setText(String.valueOf(price[1]));
					}
				}
				else if(e.getClickCount()==2){
					try {
						new Tables("Table 2번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table2.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table3.setForeground(Color.BLACK);

		table3.setBackground(new Color(255, 228, 225));
		table3.setBounds(400, 0, 188, 172);
		panel.add(table3);
		table3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[2]!=0){
						menuinit(2);		
						sumtext.setText(String.valueOf(price[2]));
					}
				}
				else if(e.getClickCount()==2){
					try {
						new Tables("Table 3번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table3.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table4.setForeground(Color.BLACK);

		table4.setBackground(new Color(255, 228, 225));
		table4.setBounds(0, 182, 188, 172);
		panel.add(table4);
		table4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[3]!=0){
						menuinit(3);	
						sumtext.setText(String.valueOf(price[3]));
					}
				}
				else if(e.getClickCount()==2){
					try {
						new Tables("Table 4번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table4.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table5.setForeground(Color.BLACK);
		table5.setBackground(new Color(255, 228, 225));
		table5.setBounds(200, 182, 188, 172);
		panel.add(table5);
		table5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[4]!=0){
						menuinit(4);	
						sumtext.setText(String.valueOf(price[4]));
					}
				}
				if(e.getClickCount()==2){
					try {
						new Tables("Table 5번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table5.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table6.setForeground(Color.BLACK);
		table6.setBackground(new Color(255, 228, 225));
		table6.setBounds(400, 182, 188, 172);
		panel.add(table6);
		table6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[5]!=0){
						menuinit(5);		
						sumtext.setText(String.valueOf(price[5]));
					}
				}
				if(e.getClickCount()==2){
					try {
						new Tables("Table 6번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table6.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table7.setForeground(Color.BLACK);
		table7.setBackground(new Color(255, 228, 225));
		table7.setBounds(0, 364, 188, 172);
		panel.add(table7);
		table7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[6]!=0){
						menuinit(6);		
						sumtext.setText(String.valueOf(price[6]));
					}
				}
				else if(e.getClickCount()==2){
					try {
						new Tables("Table 7번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table7.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table8.setForeground(Color.BLACK);

		table8.setBackground(new Color(255, 228, 225));
		table8.setBounds(200, 364, 188, 176);
		panel.add(table8);
		table8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[7]!=0){
						menuinit(7);	
						sumtext.setText(String.valueOf(price[7]));
					}
				}
				if(e.getClickCount()==2){
					try {
						new Tables("Table 8번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table8.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table9.setForeground(Color.BLACK);
		table9.setBackground(new Color(255, 228, 225));
		table9.setBounds(400, 364, 188, 176);
		panel.add(table9);
		table9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[8]!=0){
						menuinit(8);		
						sumtext.setText(String.valueOf(price[8]));
					}
				}
				if(e.getClickCount()==2){
					try {
						new Tables("Table 9번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table9.setFont(new Font("Sitka Small", Font.BOLD, 60));
	}
	public void menuinit(int i){
		paytext.setText("");	
		chargetext.setText("0");
		str="";
		tableflag[i]=true;
	}
	public void bt_init(){
		table1.setFocusable(false);
		table2.setFocusable(false);
		table3.setFocusable(false);
		table4.setFocusable(false);
		table5.setFocusable(false);
		table6.setFocusable(false);
		table7.setFocusable(false);
		table8.setFocusable(false);
		table9.setFocusable(false);
		calc_bt.setFocusable(false);
		exit_bt.setFocusable(false);
		back_bt.setFocusable(false);		
		sumtext.setFocusable(false);
		chargetext.setFocusable(false);
		bt_sale.setFocusable(false);
	}
	public int flaginit() {
		int flag=0;
		for(int i=0;i<9;i++){
			if(tableflag[i]){
				flag=i;
				tableflag[i]=false;
			}
		}
		return flag;
	}
	public void table_init(int flag) {
		if(flag==1){
			table1.setText("1");
			table1.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table1.setForeground(Color.BLACK);
			table1.setHorizontalAlignment(SwingConstants.CENTER);
			price[0]=0;
			cnt=cnt1;
		}
		else if(flag==2){
			table2.setText("2");
			table2.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table2.setForeground(Color.BLACK);
			table2.setHorizontalAlignment(SwingConstants.CENTER);
			price[1]=0;
			cnt=cnt2;
		}
		else if(flag==3){
			table3.setText("3");
			table3.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table3.setForeground(Color.BLACK);
			table3.setHorizontalAlignment(SwingConstants.CENTER);
			price[2]=0;
			cnt=cnt3;
		}
		else if(flag==4){
			table4.setText("4");
			table4.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table4.setForeground(Color.BLACK);
			table4.setHorizontalAlignment(SwingConstants.CENTER);
			price[3]=0;
			cnt=cnt4;
		}
		else if(flag==5){
			table5.setText("5");
			table5.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table5.setForeground(Color.BLACK);
			table5.setHorizontalAlignment(SwingConstants.CENTER);
			price[4]=0;
			cnt=cnt5;
		}
		else if(flag==6){
			table6.setText("6");
			table6.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table6.setForeground(Color.BLACK);
			table6.setHorizontalAlignment(SwingConstants.CENTER);
			price[5]=0;
			cnt=cnt6;
		}
		else if(flag==7){
			table7.setText("7");
			table7.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table7.setForeground(Color.BLACK);
			table7.setHorizontalAlignment(SwingConstants.CENTER);
			price[6]=0;
			cnt=cnt7;
		}
		else if(flag==8){
			table8.setText("8");
			table8.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table8.setForeground(Color.BLACK);
			table8.setHorizontalAlignment(SwingConstants.CENTER);
			price[7]=0;
			cnt=cnt8;
		}
		else{
			table9.setText("9");
			table9.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table9.setForeground(Color.BLACK);
			table9.setHorizontalAlignment(SwingConstants.CENTER);
			price[8]=0;
			cnt=cnt9;
		}
	}
	public void setCnt(int i, int count,int table) {

		if(table==1){
			cnt1[i] = count;
		}
		else if(table==2){
			cnt2[i] = count;
		}
		else if(table==3){
			cnt3[i] = count;
		}
		else if(table==4){
			cnt4[i] = count;
		}
		else if(table==5){
			cnt5[i] = count;
		}
		else if(table==6){
			cnt6[i] = count;
		}
		else if(table==7){
			cnt7[i] = count;
		}
		else if(table==8){
			cnt8[i] = count;
		}
		else if(table==9){
			cnt9[i] = count;
		}

	}
	public void setTable1(String str,int price) {
		table1.setText(str);
		table1.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table1.setForeground(Color.BLACK);
		table1.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[0]=price;
	}
	public void setTable2(String str,int price) {
		table2.setText(str);
		table2.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table2.setForeground(Color.BLACK);
		table2.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[1]=price;
	}
	public void setTable3(String str,int price) {
		table3.setText(str);
		table3.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table3.setForeground(Color.BLACK);
		table3.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[2]=price;
	}
	public void setTable4(String str,int price) {
		table4.setText(str);
		table4.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 14));
		table4.setForeground(Color.BLACK);
		table4.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[3]=price;
	}
	public void setTable5(String str,int price) {
		table5.setText(str);
		table5.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table5.setForeground(Color.BLACK);
		table5.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[4]=price;
	}
	public void setTable6(String str,int price) {
		table6.setText(str);
		table6.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table6.setForeground(Color.BLACK);
		table6.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[5]=price;
	}
	public void setTable7(String str,int price) {
		table7.setText(str);
		table7.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table7.setForeground(Color.BLACK);
		table7.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[6]=price;
	}
	public void setTable8(String str,int price) {
		table8.setText(str);
		table8.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table8.setForeground(Color.BLACK);
		table8.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[7]=price;
	}
	public void setTable9(String str,int price) {
		table9.setText(str);
		table9.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table9.setForeground(Color.BLACK);
		table9.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[8]=price;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
