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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PinId implements ActionListener {

    private JFrame screen;
    private Container box;
    private Image image1,image2;
    private ImageIcon img1,img2;
    private JLabel label,label0,label1,label2,label3,label4,label5,labelpin,labelID;
    private JTextField textId;
    private JPasswordField password;
    private JButton btn;
    public PinId()
    {
      screen=new JFrame();
      screen.setSize(1000, 700);
      screen.setLocationRelativeTo(null);
      screen.setTitle("PIN AND ID");
      screen.setLayout(null);
      screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      box=screen.getContentPane();
      box.setLayout(null);
   

        img1=new ImageIcon(ClassLoader.getSystemResource("Images//pinid.png"));
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
    
        label4=new JLabel("ENTER PIN:");
        label4.setBounds(50,300,150,100);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font(null, Font.BOLD, 25));
        label.add(label4);

        labelpin=new JLabel("Your Password Must Be 6 Digits Password");
        labelpin.setBounds(200,250,350,60);
        labelpin.setFont(new Font(null, Font.BOLD, 16));
        labelpin.setForeground(Color.WHITE);
        label.add(labelpin);

        password=new JPasswordField();
        password.setBounds(200,300,300,100);
        password.setFont(new Font(null, Font.BOLD, 20));
        label.add(password);

        label5=new JLabel("ENTER ID:");
        label5.setBounds(520,300,150,100);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font(null, Font.BOLD, 25));
        label.add(label5);

        labelID=new JLabel("Your ID Must Be 10 Digits ID");
        labelID.setBounds(680,250,300,60);
        labelID.setFont(new Font(null, Font.BOLD, 16));
        labelID.setForeground(Color.WHITE);
        label.add(labelID);
        
        textId=new JTextField();
        textId.setBounds(660,300,300,100);
        textId.setFont(new Font(null, Font.BOLD, 20));
        label.add(textId);

        btn=new JButton("DONE");
        btn.setBounds(400,500,200,100);
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.BLACK);
        btn.setFont(new Font(null, Font.BOLD, 20));
        label.add(btn);
        btn.addActionListener(this);
        
        screen.setVisible(true);
    }
   
    public boolean checkPIn()
    {
      String pin1="786900";
       pin1 = password.getText();
      if(pin1.matches("[0-9]+")&& pin1.length()==6)
      {
        return true;
      }
      else
      {
        password.setBorder(new LineBorder(Color.RED));
        JOptionPane.showMessageDialog(null, "Your Password Must Be 6 Digits Password","WARNING", JOptionPane.WARNING_MESSAGE);
        return false;
      }
    }
    public boolean checkID()
    {
        String id="8598890000";
         id = textId.getText();
        if(id.matches("[0-9]+")&& id.length()==10)
        {
          return true;
        }
        else
        {
          textId.setBorder(new LineBorder(Color.RED));
          JOptionPane.showMessageDialog(null, "Your Id Must Be 10 Digits Id","WARNING", JOptionPane.WARNING_MESSAGE);
          return false;
        }
    }
    public void actionPerformed(ActionEvent e) 
    {
      if(e.getSource()==btn)
      {
        if(checkID() & checkPIn())
        {
          new Menu();
        }
      
      }

    }
    }