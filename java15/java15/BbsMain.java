package java15;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BbsMain {
   private JTextField idText;
   private JTextField titleText;
   private JTextField contentText;
   private JTextField etcText;
   public BbsMain() {
      JFrame f = new JFrame("³ªÀÇ °Ô½ÃÆÇ ¸¸µé±â");
      f.getContentPane().setForeground(Color.GREEN);
      f.setSize(400, 650);
      FlowLayout flow = new FlowLayout();
      f.getContentPane().setLayout(flow);
      
      JLabel lblNewLabel = new JLabel("<\uC544\uC774\uB514>");
      lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 30));
      f.getContentPane().add(lblNewLabel);
      
      idText = new JTextField();
      idText.setBackground(Color.YELLOW);
      idText.setFont(new Font("±¼¸²", Font.BOLD, 30));
      f.getContentPane().add(idText);
      idText.setColumns(10);
      
      JLabel label = new JLabel("<<\uC81C\uBAA9>>");
      label.setFont(new Font("±¼¸²", Font.BOLD, 30));
      f.getContentPane().add(label);
      
      titleText = new JTextField();
      titleText.setBackground(Color.YELLOW);
      titleText.setFont(new Font("±¼¸²", Font.BOLD, 30));
      titleText.setColumns(10);
      f.getContentPane().add(titleText);
      
      JLabel label_1 = new JLabel("<<\uB0B4\uC6A9>>");
      label_1.setFont(new Font("±¼¸²", Font.BOLD, 30));
      f.getContentPane().add(label_1);
      
      contentText = new JTextField();
      contentText.setBackground(Color.YELLOW);
      contentText.setFont(new Font("±¼¸²", Font.BOLD, 30));
      contentText.setColumns(10);
      f.getContentPane().add(contentText);
      
      JLabel label_2 = new JLabel("<<\uAE30\uD0C0>>");
      label_2.setFont(new Font("±¼¸²", Font.BOLD, 30));
      f.getContentPane().add(label_2);
      
      etcText = new JTextField();
      etcText.setFont(new Font("±¼¸²", Font.BOLD, 30));
      etcText.setColumns(10);
      f.getContentPane().add(etcText);
      
      JButton btnNewButton = new JButton("BBS \uAC80\uC0C9\uD558\uAE30");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            String inputId = idText.getText();
            BbsDAO dao = new BbsDAO();
             BbsDTO dto = dao.select(inputId);
             String id = dto.getId();
             String title = dto.getTitle();
             String content = dto.getContent();
             String etc = dto.getEtc();
             idText.setText(id);
             titleText.setText(title);
             contentText.setText(content);
             etcText.setText(etc);
             
         }
      });
      btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 30));
      f.getContentPane().add(btnNewButton);
      
      JButton btnBbs = new JButton("BBS \uC0BD\uC785\uD558\uAE30");
      btnBbs.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
         }
      });
      btnBbs.setFont(new Font("±¼¸²", Font.BOLD, 30));
      f.getContentPane().add(btnBbs);
      
      JButton btnBbs_1 = new JButton("BBS \uC218\uC815\uD558\uAE30");
      btnBbs_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnBbs_1.setFont(new Font("±¼¸²", Font.BOLD, 30));
      f.getContentPane().add(btnBbs_1);
      
      JButton btnBbs_2 = new JButton("BBS \uC81C\uAC70\uD558\uAE30");
      btnBbs_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnBbs_2.setFont(new Font("±¼¸²", Font.BOLD, 30));
      f.getContentPane().add(btnBbs_2);
      
      
      
      f.setVisible(true);
      
   }

   public static void main(String[] args) {
      BbsMain name = new BbsMain();

   }

}