package pos;



import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import dialog.SignUpDialog;




public class Main2 extends JFrame{

	private JPanel mainPanel = new JPanel(new GridLayout(17, 0));	

	private JLabel idlabel = new JLabel("���̾�α׿��� �޾ƿ� ���̵� ��");

	private JTextField idText = new JTextField();

	private JLabel pwlabel = new JLabel("���̾�α׿��� �޾ƿ� ��й�ȣ ��");

	private JTextField pwText = new JTextField();

	private JLabel pwchecklabel = new JLabel("���̾�α׿��� �޾ƿ� ��й�ȣ Ȯ�� ��");

	private JTextField pwCheckText = new JTextField();

	private JLabel namelabel = new JLabel("���̾�α׿��� �޾ƿ� �̸� ��");

	private JTextField nameText = new JTextField();

	private JLabel birthYearlabel = new JLabel("���̾�α׿��� �޾ƿ� ���� ���� ��");

	private JTextField birthYearText = new JTextField();

	private JLabel birthMonthlabel = new JLabel("���̾�α׿��� �޾ƿ� ���� �� ��");

	private JTextField birthMonthText = new JTextField();

	private JLabel birthDaylabel = new JLabel("���̾�α׿��� �޾ƿ� ���� ���� ��");

	private JTextField birthDayText = new JTextField();

	private JLabel phoneNumberlabel = new JLabel("���̾�α׿��� �޾ƿ� �ڵ��� ��ȣ ��");

	private JTextField phoneNumberText = new JTextField();

	private JButton signUpbtn = new JButton("���̾�α� â���� ȸ�� ���� ���� �Է� �ϱ� ���� ��ư!");

	private Main2 owner = this;

	

	public Main2() {

		super("����â");		

		

		this.mainPanel.add(idlabel);

		this.mainPanel.add(idText);

		this.mainPanel.add(pwlabel);

		this.mainPanel.add(pwText);

		this.mainPanel.add(pwchecklabel);

		this.mainPanel.add(pwCheckText);

		this.mainPanel.add(namelabel);

		this.mainPanel.add(nameText);

		this.mainPanel.add(birthYearlabel);

		this.mainPanel.add(birthYearText);

		this.mainPanel.add(birthMonthlabel);

		this.mainPanel.add(birthMonthText);

		this.mainPanel.add(birthDaylabel);

		this.mainPanel.add(birthDayText);

		this.mainPanel.add(phoneNumberlabel);

		this.mainPanel.add(phoneNumberText);

		this.mainPanel.add(signUpbtn);

		

		this.setContentPane(mainPanel);

		this.setSize(500,500);

		this.setVisible(true);

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

		//ȸ������ ��ư�� �������� ȸ������ ���̾�α� â ����

		signUpbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				SignUpDialog signup = new SignUpDialog(owner);

				

				signup.setVisible(true);

								

				//���� â���� ȸ������ �Է��� ��� �Ϸ� �Ǿ����� üũ�ϴ� ���� membershipProgress�� �Ǵ�

				if(signup.memberCheck()) {				

					idText.setText(signup.getIdText());

					pwText.setText(signup.getPwText());

					pwCheckText.setText(signup.getPwCheckText());

					nameText.setText(signup.getNameText());

					birthYearText.setText(signup.getBirthYearText());

					birthMonthText.setText(signup.getBirthMonthContent());

					birthDayText.setText(signup.getBirthDayText());

					phoneNumberText.setText(signup.getPhoneNumberText());

				}

			}

		});

		

				

	}

	

	public static void main(String[] args) {

		new Main2();

	}

}

	   