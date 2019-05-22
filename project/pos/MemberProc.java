package pos;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
import java.awt.event.*;
 
public class MemberProc extends JFrame implements ActionListener {
   
   
    JPanel p;
    JTextField tfId, tfName, tfAddr, tfEmail;
    JTextField tfTel1, tfTel2, tfTel3; //��ȭ
    JComboBox cbJob; //����
    JPasswordField pfPwd; //��й�ȣ   
    JTextField tfYear, tfMonth, tfDate; //�������
    JRadioButton rbMan, rbWoman; //��, ��
    JTextArea taIntro;
    JButton btnInsert, btnCancel, btnUpdate,btnDelete; //����, ���, ���� , Ż�� ��ư
   
    GridBagLayout gb;
    GridBagConstraints gbc;
    Member_List mList ;
   
    public MemberProc(){ //���Կ� ������
       
        createUI(); // UI�ۼ����ִ� �޼ҵ�
        btnUpdate.setEnabled(false);
        btnUpdate.setVisible(false);
        btnDelete.setEnabled(false);
        btnDelete.setVisible(false);
       
       
    }//������
   
    public MemberProc(Member_List mList){ //���Կ� ������
       
        createUI(); // UI�ۼ����ִ� �޼ҵ�
        btnUpdate.setEnabled(false);
        btnUpdate.setVisible(false);
        btnDelete.setEnabled(false);
        btnDelete.setVisible(false);
        this.mList = mList;
       
    }//������
    public MemberProc(String id,Member_List mList){ // ����/������ ������
        createUI();
        btnInsert.setEnabled(false);
        btnInsert.setVisible(false);
        this.mList = mList;
       
       
        System.out.println("id="+id);
       
        MemberDAO1 dao = new MemberDAO1();
        MemberDTO1 vMem = dao.getMemberDTO(id);
        viewData(vMem);
       
       
    }//id�� ������ ����
 
       
    //MemberDTO �� ȸ�� ������ ������ ȭ�鿡 �������ִ� �޼ҵ�
    private void viewData(MemberDTO1 vMem){
       
        String id = vMem.getId();
        String pwd = vMem.getPwd();
        String name = vMem.getName();
        String tel = vMem.getTel();
        String addr = vMem.getAddr();
        String birth = vMem.getBirth();
        String job = vMem.getJob();
        String gender = vMem.getGender();
        String email= vMem.getEmail();
        String intro = vMem.getIntro();    
       
        //ȭ�鿡 ����
        tfId.setText(id);
        tfId.setEditable(false); //���� �ȵǰ�
        pfPwd.setText(""); //��й�ȣ�� �Ⱥ����ش�.
        tfName.setText(name);
        String[] tels = tel.split("-");
        tfTel1.setText(tels[0]);
        tfTel2.setText(tels[1]);
        tfTel3.setText(tels[2]);
        tfAddr.setText(addr);
       
        tfYear.setText(birth.substring(0, 4));
        tfMonth.setText(birth.substring(4, 6));
        tfDate.setText(birth.substring(6, 8));
       
        cbJob.setSelectedItem(job);
       
       
        if(gender.equals("M")){
            rbMan.setSelected(true);
        }else if(gender.equals("W")){
            rbWoman.setSelected(true);
        }
       
        tfEmail.setText(email);
        taIntro.setText(intro);
   
       
    }//viewData
   
   
   
    private void createUI(){
        this.setTitle("ȸ������");
        gb = new GridBagLayout();
        setLayout(gb);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
       
       
        //���̵�
        JLabel bId = new JLabel("���̵� : ");
        tfId = new JTextField(20);     
        //�׸���鿡 ���̱�
        gbAdd(bId, 0, 0, 1, 1);
        gbAdd(tfId, 1, 0, 3, 1);
       
        //��й�ȣ
        JLabel bPwd = new JLabel("��й�ȣ : ");
        pfPwd = new JPasswordField(20);
        gbAdd(bPwd, 0, 1, 1, 1);
        gbAdd(pfPwd, 1, 1, 3, 1);
       
        //�̸�
        JLabel bName = new JLabel("�̸� :");
        tfName = new JTextField(20);
        gbAdd(bName,0,2,1,1);
        gbAdd(tfName,1,2,3,1);
       
        //��ȭ
        JLabel bTel = new JLabel("��ȭ :");
        JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tfTel1 = new JTextField(6);    
        tfTel2 = new JTextField(6);    
        tfTel3 = new JTextField(6);
        pTel.add(tfTel1);
        pTel.add(new JLabel(" - "));
        pTel.add(tfTel2);
        pTel.add(new JLabel(" - "));
        pTel.add(tfTel3);
        gbAdd(bTel, 0, 3, 1,1);
        gbAdd(pTel, 1, 3, 3,1);
       
        //�ּ�
        JLabel bAddr = new JLabel("�ּ�: ");
        tfAddr = new JTextField(20);
        gbAdd(bAddr, 0,4,1,1);
        gbAdd(tfAddr, 1, 4, 3,1);
       
        //����
        JLabel bBirth= new JLabel("����: ");
        tfYear = new JTextField(6);
        tfMonth = new JTextField(6);
        tfDate = new JTextField(6);
        JPanel pBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pBirth.add(tfYear);
        pBirth.add(new JLabel("/"));
        pBirth.add(tfMonth);
        pBirth.add(new JLabel("/"));
        pBirth.add(tfDate);
        gbAdd(bBirth, 0,5,1,1);
        gbAdd(pBirth, 1, 5, 3,1);
       
        //����       
        JLabel bJob = new JLabel("���� : ");
        String[] arrJob = {"---", "�л�", "������", "�ֺ�"};
        cbJob = new JComboBox(arrJob);
        JPanel pJob = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pJob.add(cbJob);       
        gbAdd(bJob, 0,6,1,1);
        gbAdd(pJob,1,6,3,1);
       
        //����
        JLabel bGender = new JLabel("���� : ");
        JPanel pGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbMan = new JRadioButton("��",true);
        rbWoman = new JRadioButton("��",true);
        ButtonGroup group = new ButtonGroup();
        group.add(rbMan);
        group.add(rbWoman);
        pGender.add(rbMan);
        pGender.add(rbWoman);      
        gbAdd(bGender, 0,7,1,1);
        gbAdd(pGender,1,7,3,1);
       
        //�̸���
        JLabel bEmail = new JLabel("�̸��� : ");
        tfEmail = new JTextField(20);
        gbAdd(bEmail, 0,8,1,1);
        gbAdd(tfEmail,1,8,3,1);
       
        //�ڱ�Ұ�
        JLabel bIntro = new JLabel("�ڱ� �Ұ�: ");
        taIntro = new JTextArea(5, 20); //�� : ��
        JScrollPane pane = new JScrollPane(taIntro);
        gbAdd(bIntro,0,9,1,1);
        gbAdd(pane,1,9,3,1);
       
        //��ư
        JPanel pButton = new JPanel();
        btnInsert = new JButton("����");
        btnUpdate = new JButton("����"); 
        btnDelete = new JButton("Ż��");
        btnCancel = new JButton("���");     
        pButton.add(btnInsert);
        pButton.add(btnUpdate);
        pButton.add(btnDelete);
        pButton.add(btnCancel);    
        gbAdd(pButton, 0, 10, 4, 1);
       
        //��ư�� �����⸦ ������
        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnCancel.addActionListener(this);
        btnDelete.addActionListener(this);
       
        setSize(350,500);
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //���α׷�����
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
       
       
    }//createUI
   
    //�׸���鷹�̾ƿ��� ���̴� �޼ҵ�
    private void gbAdd(JComponent c, int x, int y, int w, int h){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gb.setConstraints(c, gbc);
        gbc.insets = new Insets(2, 2, 2, 2);
        add(c, gbc);
    }//gbAdd
   
    public static void main(String[] args) {
       
        new MemberProc();
    }
   
 
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnInsert){
            insertMember();
            System.out.println("insertMember() ȣ�� ����");
        }else if(ae.getSource() == btnCancel){
            this.dispose(); //â�ݱ� (����â�� ����)
            //system.exit(0)=> ���� ��� ��� â�� �� ����          
        }else if(ae.getSource() == btnUpdate){
            UpdateMember();            
        }else if(ae.getSource() == btnDelete){
            //int x = JOptionPane.showConfirmDialog(this,"���� �����Ͻðڽ��ϱ�?");
            int x = JOptionPane.showConfirmDialog(this,"���� �����Ͻðڽ��ϱ�?","����",JOptionPane.YES_NO_OPTION);
           
            if (x == JOptionPane.OK_OPTION){
                deleteMember();
            }else{
                JOptionPane.showMessageDialog(this, "������ ����Ͽ����ϴ�.");
            }
        }
       
        //jTable���� ���� �޼ҵ� ȣ��
        mList.jTableRefresh();
       
    }//actionPerformed 
   
   
    private void deleteMember() {
        String id = tfId.getText();
        String pwd = pfPwd.getText();
        if(pwd.length()==0){ //���̰� 0�̸�
           
            JOptionPane.showMessageDialog(this, "��й�ȣ�� �� �Է��ϼ���!");
            return; //�޼ҵ� ��
        }
        //System.out.println(mList);
        MemberDAO1 dao = new MemberDAO1();
        boolean ok = dao.deleteMember(id, pwd);
       
        if(ok){
            JOptionPane.showMessageDialog(this, "�����Ϸ�");
            dispose();         
           
        }else{
            JOptionPane.showMessageDialog(this, "��������");
           
        }          
       
    }//deleteMember
   
    private void UpdateMember() {
       
        //1. ȭ���� ������ ��´�.
        MemberDTO1 dto = getViewData();     
        //2. �������� DB�� ����
        MemberDAO1 dao = new MemberDAO1();
        boolean ok = dao.updateMember(dto);
       
        if(ok){
            JOptionPane.showMessageDialog(this, "�����Ǿ����ϴ�.");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "��������: ���� Ȯ���ϼ���");   
        }
    }
 
    private void insertMember(){
       
        //ȭ�鿡�� ����ڰ� �Է��� ������ ��´�.
        MemberDTO1 dto = getViewData();
        MemberDAO1 dao = new MemberDAO1();       
        boolean ok = dao.insertMember(dto);
       
        if(ok){
           
            JOptionPane.showMessageDialog(this, "������ �Ϸ�Ǿ����ϴ�.");
            dispose();
           
        }else{
           
            JOptionPane.showMessageDialog(this, "������ ���������� ó������ �ʾҽ��ϴ�.");
        }
       
       
       
    }//insertMember
   
    public MemberDTO1 getViewData(){
       
        //ȭ�鿡�� ����ڰ� �Է��� ������ ��´�.
        MemberDTO1 dto = new MemberDTO1();
        String id = tfId.getText();
        String pwd = pfPwd.getText();
        String name = tfName.getText();
        String tel1 = tfTel1.getText();
        String tel2 = tfTel2.getText();
        String tel3 = tfTel3.getText();
        String tel = tel1+"-"+tel2+"-"+tel3;
        String addr = tfAddr.getText();
        String birth1 = tfYear.getText();
        String birth2 = tfMonth.getText();
        String birth3 = tfDate.getText();
        //String birth = birth1+"/"+birth2+"/"+birth3;
        String birth = birth1+birth2+birth3;
        String job = (String)cbJob.getSelectedItem();
        String gender = "";
        if(rbMan.isSelected()){
            gender = "M";
        }else if(rbWoman.isSelected()){
            gender = "W";
        }
       
        String email = tfEmail.getText();
        String intro = taIntro.getText();
       
        //dto�� ��´�.
        dto.setId(id);
        dto.setPwd(pwd);
        dto.setName(name);
        dto.setTel(tel);
        dto.setAddr(addr);
        dto.setBirth(birth);
        dto.setJob(job);
        dto.setGender(gender);
        dto.setEmail(email);
        dto.setIntro(intro);
       
        return dto;
    }
   
}//end