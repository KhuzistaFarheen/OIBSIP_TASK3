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
import javax.swing.border.LineBorder;

public class Withdraw implements ActionListener {
    private JFrame screen;
    private ImageIcon img1,img2;
    private Image image1,image2;
    private JLabel label,label0,label1,label2,label3,enterAmt;
    private Container box;
    private JTextField withdrawText;
    private JButton btnMenu,btnWith,btnExit,btnBalance;
    public static double amount;
    static ArrayList historyL=new ArrayList();
    public Withdraw()
    {
      screen=new JFrame();
      screen.setSize(1000, 700);
      screen.setLocationRelativeTo(null);
      screen.setTitle("WITHDRAW");
      screen.setLayout(null);
      screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        box=screen.getContentPane();
        box.setBounds(0, 0, screen.getWidth(), screen.getHeight());
        box.setBackground(Color.GREEN);

        img1=new ImageIcon(ClassLoader.getSystemResource("Images//withdraw.png"));
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
        label0.setForeground(Color.WHITE);
        label0.setFont(new Font(null,Font.BOLD,50));
        label.add(label0);


        label1=new JLabel("TO");
        label1.setBounds(420,60,100,150);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font(null, Font.BOLD, 50) );
        label.add(label1);

        label2=new JLabel("BANK OF ODISHA");
        label2.setBounds(240, 160, 500, 50);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font(null, Font.BOLD, 50) );
        label.add(label2);

        label3=new JLabel("*************************************************");
        label3.setBounds(0,240,1000,30);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font(null, Font.BOLD, 50) );
        label.add(label3);

        withdrawText=new JTextField();
        withdrawText.setBounds(400,320,300,70);
        withdrawText.setFont(new Font(null, Font.BOLD, 17));
        label.add(withdrawText);
        withdrawText.addActionListener(this);
         
        enterAmt=new JLabel();
        enterAmt.setBounds(180,300,220,100);
        enterAmt.setText("ENTER AMMOUNT:");
        enterAmt.setFont(new Font(null, Font.BOLD, 22));
        label.add(enterAmt);

        btnMenu=new JButton();
        btnMenu.setBounds(130,450,200,100);
        btnMenu.setText("Go To Menu");
        btnMenu.setBackground(Color.YELLOW);
        btnMenu.setFont(new Font(null,Font.BOLD,17));
        label.add(btnMenu);
        btnMenu.addActionListener(this);

        btnWith=new JButton();
        btnWith.setBounds(380,450,200,100);
        btnWith.setText("WITHDRAW");
        btnWith.setBackground(Color.YELLOW);
        btnWith.setFont(new Font(null,Font.BOLD,17));
        label.add(btnWith);
        btnWith.addActionListener(this);
        
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
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==withdrawText)
      {
        try {
          long a;
          String s=withdrawText.getText();
          a =Long.parseLong(s);
          
        } catch (Exception n) {
           JOptionPane.showMessageDialog(null, "Please Enter A Numeric Value", "RECOMENDATION", JOptionPane.PLAIN_MESSAGE);
        }
            
      }
      if(e.getSource()==btnMenu)
      {
        new Menu();
      }
      if(e.getSource()==btnWith)
      {
        String f=withdrawText.getText();
        
        amount=Double.parseDouble(f);
  
        if(amount<=Deposit.totalbal)
        {

          JOptionPane.showMessageDialog(null, "The "+amount+" Withdrawn Successfully", "NOTE", JOptionPane.PLAIN_MESSAGE);
          Deposit.totalbal=Deposit.totalbal-amount;

          int id = Data.transactionID;
          Data.transactionID=Data.transactionID+1;
          double balance2 = Deposit.totalbal;

          Transactions.setHistory(id,"Withdraw",amount,balance2 ,"Success");
        }
        else
        {
          withdrawText.setBorder(new LineBorder(Color.RED));
          JOptionPane.showMessageDialog(null, "This Ammount Is Not Available In Your Account", "RECOMENDATION", JOptionPane.PLAIN_MESSAGE);

        }
        
      }
      if(e.getSource()==btnExit)
      {
        System.exit(0);
      }
      if(e.getSource()==btnBalance)
      {
        JOptionPane.showMessageDialog(null, "YOUR CURRENT BALANCE IS RS :"+Deposit.totalbal+" IN YOUR ACCOUNT", "BALANCE", JOptionPane.INFORMATION_MESSAGE);
      }
     
    }
    
  }

