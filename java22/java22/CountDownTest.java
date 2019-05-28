package java22;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CountDownTest extends JFrame {

    private JLabel x, y;
    
    public CountDownTest() {

        setTitle("카운트다운");
        setSize(800, 800);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        x = new JLabel("Start");
        y = new JLabel();

        x.setFont(new Font("Serif", Font.BOLD, 70));
        y.setFont(new Font("Serif", Font.BOLD, 100));
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(x);
        getContentPane().add(y);

        (new MyThread1()).start();
        (new MyThread2()).start();

        setVisible(true);

    }

    class MyThread1 extends Thread {
        
        public void run() {
            for (int i = 500; i >= 0; i--) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x.setText( "게임을 시작합니다 :" + i + "");
            }
        }
    }
        class MyThread2 extends Thread {
        	String[] imgs = {"1.png", "2.png", "3.png", "4.jpg", "5.png", "6.png", "7.jpg", "8.png", "9.jpg", "10.png" , "11.png"
        			, "12.jpg", "13.png" , "14.jpg", "15.png"};

            public void run() {

                for (int i = 1; i < imgs.length; i++) {
                    try {
                        Thread.sleep(1000);
                        ImageIcon icon = new ImageIcon(imgs[i]);
                        y.setIcon(icon);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
    public static void main(String[] args) {
        CountDownTest t = new CountDownTest();
    }
}



