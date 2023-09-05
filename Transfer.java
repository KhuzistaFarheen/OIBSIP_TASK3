import java .awt.Color;
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

public class Transfer implements ActionListener {
    private JFrame screen;
    private Image image1,image2;
    private ImageIcon img1,img2;
    private Container box;
    private JLabel label,label0,label1,label2,label3,labelAccNo,labelIfsc,labelAmount;
    private JTextField textAccNo,textIfsc,textAmount;
    private JButton btnMenu,btnTransfer,btnExit,btnBalance;
    static ArrayList historyL=new ArrayList();
    public Transfer()
    {
      screen=new JFrame();
      screen.setSize(1000, 700);
      screen.setLocationRelativeTo((null));
      screen.setTitle("TRANSFER");
      screen.setLayout(null);
      screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      box=screen.getContentPane();
      box.setBounds(0, 0, screen.getWidth(), screen.getHeight());
      box.setBackground(Color.GREEN);

      img1=new ImageIcon(ClassLoader.getSystemResource("Images//transfer.png"));
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

        labelAccNo=new JLabel("ENTER ACCOUNT NO:");
        labelAccNo.setBounds(130,300,220,50);
        labelAccNo.setForeground(Color.YELLOW);
        labelAccNo.setFont(new Font(null, Font.BOLD, 20));
        label.add(labelAccNo);

        textAccNo=new JTextField();
        textAccNo.setBounds(350,300,300,50);
        textAccNo.setFont(new Font(null, Font.BOLD, 18) );
        label.add(textAccNo);

        labelIfsc=new JLabel("ENTER IFSC CODE:");
        labelIfsc.setBounds(130,400,200,50);
        labelIfsc.setForeground(Color.YELLOW);
        labelIfsc.setFont(new Font(null, Font.BOLD, 20));
        label.add(labelIfsc);
        
        textIfsc=new JTextField();
        textIfsc.setBounds(350,400,300,50);
        textIfsc.setFont(new Font(null, Font.BOLD, 18) );
        label.add(textIfsc);

        labelAmount=new JLabel("ENTER AMMOUNT:");
        labelAmount.setBounds(130,500,200,50);
        labelAmount.setForeground(Color.YELLOW);
        labelAmount.setFont(new Font(null, Font.BOLD, 20));
        label.add(labelAmount);
        
        textAmount=new JTextField();
        textAmount.setBounds(350,500,300,50);
        textAmount.setFont(new Font(null, Font.BOLD, 18) );
        label.add(textAmount);

        btnMenu=new JButton();
        btnMenu.setBounds(130,570,200,80);
        btnMenu.setText("Go To Menu");
        btnMenu.setBackground(Color.YELLOW);
        btnMenu.setFont(new Font(null,Font.BOLD,17));
        label.add(btnMenu);
        btnMenu.addActionListener(this);

        btnTransfer=new JButton();
        btnTransfer.setBounds(380,570,200,80);
        btnTransfer.setText("TRANSFER");
        btnTransfer.setBackground(Color.YELLOW);
        btnTransfer.setFont(new Font(null,Font.BOLD,17));
        label.add(btnTransfer);
        btnTransfer.addActionListener(this);
        
        btnExit=new JButton();
        btnExit.setBounds(630,570,200,80);
        btnExit.setText("EXIT");
        btnExit.setBackground(Color.YELLOW);
        btnExit.setFont(new Font(null,Font.BOLD,17));
        label.add(btnExit);
        btnExit.addActionListener(this);

        btnBalance=new JButton("Show Balance");
        btnBalance.setBounds(710, 400, 200, 100);
        btnBalance.setBackground(Color.ORANGE);
        btnBalance.setFont(new Font(null, Font.BOLD, 14));
        label.add(btnBalance);
        btnBalance.addActionListener(this);

      screen.setVisible(true);

    }
   
  
    @Override
    public void actionPerformed(ActionEvent e) 
    {
      if(e.getSource()==btnMenu)
      {
        new Menu();
      }
      if(e.getSource()==btnTransfer)
      {
    
      long accno;
      Double amount;

      long ifsc=859889L;
      long ifsc1;

      String s2=textIfsc.getText();
      ifsc1=Long.parseLong(s2);

      String s=textAccNo.getText();
      accno=Long.parseLong(s);

      String s1=textAmount.getText();
      amount=Double.parseDouble(s1);
      if(accno>=100000000000L && accno<=999999999999L)
      {
        if(ifsc1==ifsc)
        {
          if(amount<=Deposit.totalbal)
          {
              JOptionPane.showConfirmDialog(null, "The Ammount of "+amount+" Has Been Transfered Successfully", "NOTE", JOptionPane.PLAIN_MESSAGE);
              Deposit.totalbal=Deposit.totalbal-amount;

              int id = Data.transactionID;
              Data.transactionID=Data.transactionID+1;
              double balance2 = Deposit.totalbal;

             Transactions.setHistory(id,"Transfer",amount,balance2 ,"Success");
          }
          else
          {
             JOptionPane.showConfirmDialog(null, "The Ammount Is Not Available In Your Account", "WARNING", JOptionPane.PLAIN_MESSAGE);
          }

        }
        else
        {
           JOptionPane.showConfirmDialog(null, "Your IFSC Code Is Wrong", "WARNING", JOptionPane.PLAIN_MESSAGE);
        }

      }
      else
      {
        JOptionPane.showConfirmDialog(null, "Your Account Number Is Wrong", "WARNING", JOptionPane.PLAIN_MESSAGE);
      }

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