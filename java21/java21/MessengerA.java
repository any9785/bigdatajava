package java21;

import java.awt.BorderLayout;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MessengerA extends JFrame{
	JTextArea list;
	JTextField input;
	DatagramSocket socket;
	
	public MessengerA() throws Exception {
		socket = new DatagramSocket(6000); //����Ʈ
		list = new JTextArea(6, 20);
		list.setFont(new Font("Monospaced", Font.BOLD, 30));
		list.setBackground(Color.YELLOW);
		input = new JTextField();
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = input.getText();
				//System.out.println("���� �Է��� ��: " + data);
				list.append("����ȣ>> " + str + "\n"); //�����»��
				input.setText("");
				
					//DatagramSocket socket;
					try {
						DatagramSocket socket = new DatagramSocket();
						//�������� ��Ŷ�� �����Ѵ�.
						byte[] data = str.getBytes();
						InetAddress ip = InetAddress.getByName("192.168.0.120");
						DatagramPacket packet = new DatagramPacket(data, data.length,ip,5000); //�޴»����Ʈ
						
						socket.send(packet);
						socket.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		input.setFont(new Font("����", Font.BOLD, 30));
		input.setBackground(Color.GREEN);
		input.setForeground(Color.RED);
		setTitle("�޽���A ä��ȭ��");
		getContentPane().add(list, BorderLayout.CENTER);
		getContentPane().add(input, BorderLayout.SOUTH);
		pack();
		list.setEditable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	public void process() throws Exception {
		//��Ŷ�޴��ڵ�(���ѷ���)
		while(true) {
			
		byte[] data = new byte[256];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		socket.receive(packet);
		list.append("�ֱ���>> " + new String(data) + "\n"); //�޴»��
		}
	}
	public static void main(String[] args) throws Exception {
		MessengerA name = new MessengerA();
		name.process(); //���������� �޴� �ڵ尡 ���� ���ư�����
	}

}
