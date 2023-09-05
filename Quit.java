import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Quit implements ActionListener {
    private JFrame screen;
    private Image image1,image2;
    private ImageIcon img1,img2;
    private Container box;
    private JLabel label,label0,label1,label2,label3,label4 ,label5;
    private JButton btnClear,btnQuit;
    public Quit()
    {
        screen=new JFrame();
        screen.setSize(1000, 700);
        screen.setLocationRelativeTo(null);
        screen.setTitle("Quit");
        screen.setLayout(null);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        box=screen.getContentPane();
        box.setBounds(0, 0, screen.getWidth(), screen.getHeight());
        box.setBackground(Color.GREEN);

        img1=new ImageIcon(ClassLoader.getSystemResource("Images//quit.png"));
        label=new JLabel();
        label.setBounds(0,0,1000,700);
        image1=img1.getImage();
        image2=image1.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        img2=new ImageIcon(image2);
        label.setIcon(img2);
        label.setFont(new Font(null, Font.BOLD, 50) );
  
        box.add(label);

        
        label0=new JLabel("BANK");
        label0.setBounds(310, 20, 600, 100);
        label0.setForeground(Color.WHITE);
        label0.setFont(new Font(null,Font.BOLD,90));
        label.add(label0);


        label1=new JLabel("OF");
        label1.setBounds(360,70,600,150);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font(null, Font.BOLD, 90) );
        label.add(label1);

        label2=new JLabel("ODISHA");
        label2.setBounds(290, 180, 1000, 100);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font(null, Font.BOLD, 90) );
        label.add(label2);

        label3=new JLabel("*************************************************");
        label3.setBounds(0,300,1000,30);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font(null, Font.BOLD, 50) );
        label.add(label3);
        
        label4=new JLabel("THANK YOU");
        label4.setBounds(290, 330, 500, 100);
        label4.setForeground(Color.YELLOW);
        label4.setFont(new Font(null, Font.BOLD, 50) );
        label.add(label4);

        label5=new JLabel("VISIT AGAIN");
        label5.setBounds(290, 390, 600, 100);
        label5.setForeground(Color.YELLOW);
        label5.setFont(new Font(null, Font.BOLD, 50) );
        label.add(label5);

        btnClear=new JButton("CLEAR SCREEN");
        btnClear.setBounds(250,530,200,100);
        btnClear.setBackground(Color.YELLOW);
        btnClear.setFont(new Font(null, Font.BOLD, 20));
        label.add(btnClear);
        btnClear.addActionListener(this);
   
        btnQuit=new JButton("QUIT");
        btnQuit.setBounds(550,530,200,100);
        btnQuit.setBackground(Color.YELLOW);
        btnQuit.setFont(new Font(null, Font.BOLD, 20));
        label.add(btnQuit); 
        btnQuit.addActionListener(this);    

        screen.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnClear)
        {
            System.out.println("\033[H\033[2J");
            System.out.flush();
        }
        if(e.getSource()==btnQuit)
        {
            System.exit(0);
        }
    }
}
