
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

public class Menu implements ActionListener {
    private JFrame screen;
    private Container box;
    private JLabel label,label1,label2,label3,label0;
    private ImageIcon img1,img2;
    private Image image1,image2;
    private Font f;
    private JButton withdraw,deposit,transfer,create,quit;
    static JButton transHis;
    public Menu()
    {
      screen=new JFrame();
      screen.setSize(1000, 700);
      screen.setLocationRelativeTo(null);
      screen.setTitle("ATM");
      screen.setLayout(null);
      screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    box=screen.getContentPane();
    box.setLayout(null);
  
    img1=new ImageIcon(ClassLoader.getSystemResource("Images//Money.png"));
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

    transHis=new JButton();
    transHis.setBounds(100,280,250,100);
    transHis.setText("TRANSACTIONS HISTORY");
    transHis.setBackground(Color.LIGHT_GRAY);
    transHis.setFont(new Font(null, Font.BOLD, 16) );
    label.add(transHis);
    transHis.addActionListener(this);

    withdraw=new JButton();
    withdraw.setBounds(100,420,250,100);
    withdraw.setText("WITHDRAW");
    withdraw.setBackground(Color.LIGHT_GRAY);
    withdraw.setFont(new Font(null, Font.BOLD, 16) );
    label.add(withdraw);
    withdraw.addActionListener(this);

    deposit=new JButton();
    deposit.setBounds(100, 560, 250, 100);
    deposit.setText("DEPOSIT");
    deposit.setBackground(Color.LIGHT_GRAY);
    deposit.setFont(new Font(null, Font.BOLD, 16) );
    label.add(deposit);
    deposit.addActionListener(this);

    transfer=new JButton();
    transfer.setBounds(640,280,250,100);
    transfer.setText("TRANSFER");
    transfer.setBackground(Color.LIGHT_GRAY);
    transfer.setFont(new Font(null, Font.BOLD, 16) );
    label.add(transfer);
    transfer.addActionListener(this);

    create=new JButton();
    create.setBounds(640,420,250,100);
    create.setText("CREATE ACCOUNT");
    create.setBackground(Color.LIGHT_GRAY);
    create.setFont(new Font(null, Font.BOLD, 16) );
    label.add(create);
    create.addActionListener(this);

    quit=new JButton();
    quit.setBounds(640,560,250,100);
    quit.setText("QUIT");
    quit.setBackground(Color.LIGHT_GRAY);
    quit.setFont(new Font(null, Font.BOLD, 16) );
    label.add(quit);
    quit.addActionListener(this);

    screen.setVisible(true);
    }
   

    public void actionPerformed(ActionEvent e) 
    {
      if(e.getSource()==transHis)
      {
        new Transactions();
        
      }
      if(e.getSource()==withdraw)
      {
        new Withdraw();
      }
      if(e.getSource()==deposit)
      {
        new Deposit();
      }
      if(e.getSource()==transfer)
      {
        new Transfer();
      }
      if(e.getSource()==create)
      {
        new CreateAc();
      }
      if(e.getSource()==quit)
      {
         new Quit();
      }
    }
  }
    
