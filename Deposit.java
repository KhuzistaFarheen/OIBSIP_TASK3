import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit implements ActionListener {
    private JFrame screen;
    private Image image1,image2;
    private ImageIcon img1,img2;
    private Container box;
    private JLabel label,label0,label1,label2,label3,labelAmount;
    private JTextField textAmount;
    private JButton btnMenu,btnDeopsit,btnExit,btnBalance;
    public static double totalbal,transAMT;
    static ArrayList historyL=new ArrayList();
    public Deposit()
    {
        screen=new JFrame();
        screen.setSize(1000, 700);
        screen.setLocationRelativeTo(null);
        screen.setTitle("DEPOSIT");
        screen.setLayout(null);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        box=screen.getContentPane();
        box.setBounds(0, 0, screen.getWidth(), screen.getHeight());
        box.setBackground(Color.GREEN);

        img1=new ImageIcon(ClassLoader.getSystemResource("Images//deposit.png"));
        label=new JLabel();
        label.setBounds(0,0,1000,700);
        image1=img1.getImage();
        image2=image1.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        img2=new ImageIcon(image2);
        label.setIcon(img2);
        label.setFont(new Font(null, Font.BOLD, 50) );
  
        box.add(label);

        label0=new JLabel("WELCOME");
        label0.setBounds(300, 20, 300, 100);
        label0.setFont(new Font(null,Font.BOLD,50));
        label.add(label0);


        label1=new JLabel("TO");
        label1.setBounds(420,60,100,150);
        label1.setFont(new Font(null, Font.BOLD, 50) );
        label.add(label1);

        label2=new JLabel("BANK OF ODISHA");
        label2.setBounds(240, 160, 500, 50);
        label2.setFont(new Font(null, Font.BOLD, 50) );
        label.add(label2);

        label3=new JLabel("*************************************************");
        label3.setBounds(0,240,1000,30);
        label3.setFont(new Font(null, Font.BOLD, 50) );
        label.add(label3);

        labelAmount=new JLabel("ENTER AMMOUNT:");
        labelAmount.setBounds(100,300,250,100);
        labelAmount.setFont(new Font(null, Font.BOLD, 25) );
        label.add(labelAmount);

        textAmount=new JTextField();
        textAmount.setBounds(350,300,400,100);
        textAmount.setFont(new Font(null, Font.BOLD, 25) );
        label.add(textAmount);

        btnMenu=new JButton();
        btnMenu.setBounds(130,450,200,100);
        btnMenu.setText("Go To Menu");
        btnMenu.setBackground(Color.YELLOW);
        btnMenu.setFont(new Font(null,Font.BOLD,17));
        label.add(btnMenu);
        btnMenu.addActionListener(this);

        btnDeopsit=new JButton();
        btnDeopsit.setBounds(380,450,200,100);
        btnDeopsit.setText("DEPOSIT");
        btnDeopsit.setBackground(Color.YELLOW);
        btnDeopsit.setFont(new Font(null,Font.BOLD,17));
        label.add(btnDeopsit);
        btnDeopsit.addActionListener(this);
        
        btnExit=new JButton();
        btnExit.setBounds(630,450,200,100);
        btnExit.setText("EXIT");
        btnExit.setBackground(Color.YELLOW);
        btnExit.setFont(new Font(null,Font.BOLD,17));
        label.add(btnExit);
        btnExit.addActionListener(this);

        btnBalance=new JButton("Show Balance");
        btnBalance.setBounds(380, 580, 200, 70);
        btnBalance.setBackground(Color.ORANGE);
        btnBalance.setFont(new Font(null, Font.BOLD, 14));
        label.add(btnBalance);
        btnBalance.addActionListener(this);


        screen.setVisible(true);
    }
 
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnMenu)
        {
          new Menu();
        }
        if(e.getSource()==btnDeopsit)
        {
             
             double  balance=0.00,amount;
             double totalbal=0;
                
                String s1=textAmount.getText();
                amount=Double.parseDouble(s1);

                Deposit.totalbal=balance+amount;
                JOptionPane.showMessageDialog(null, "The "+amount+" Has Been Deposited Successfully", "NOTE", JOptionPane.PLAIN_MESSAGE);
                int id = Data.transactionID;
                Data.transactionID=Data.transactionID+1;
                double balance2 = totalbal;


                Transactions.setHistory(id,"Diposite",amount,balance2 ,"Success");
        }
        if(e.getSource()==btnExit)
        {
          System.exit(0);
        }
        if(e.getSource()==btnBalance)
        {
          JOptionPane.showMessageDialog(null, "YOUR CURRENT BALANCE IS  RS :"+Deposit.totalbal+" IN YOUR ACCOUNT", "BALANCE", JOptionPane.INFORMATION_MESSAGE);
        }
       
    }
}
