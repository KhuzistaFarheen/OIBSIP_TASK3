import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CreateAc implements ActionListener {
    private JFrame screen;
    private JTextField text1,text2,text3,text4,text5,text6,text7;
    private Container box;
    private JLabel label,fName,mName,lName,age,adharno,dob,mob,occup,gender;
    private Image image1,image2;
    private ImageIcon img1,img2;
    private JButton btnMenu,btnCtreate,btnExit;
    JComboBox combox;
    JRadioButton jbtnMale,jbtnFemale,jbtnOther;

    public CreateAc()
    {
        screen=new JFrame();
        screen.setSize(1000, 700);
        screen.setLocationRelativeTo(null);
        screen.setTitle("CREATE ACCOUNT");
        screen.setLayout(null);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        box=screen.getContentPane();
        box.setBounds(0, 0, screen.getWidth(), screen.getHeight());
        box.setBackground(Color.GREEN);

        img1=new ImageIcon(ClassLoader.getSystemResource("Images//create.jpg"));
        label=new JLabel();
        label.setBounds(0,0,1000,700);
        image1=img1.getImage();
        image2=image1.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        img2=new ImageIcon(image2);
        label.setIcon(img2);
        label.setFont(new Font(null, Font.BOLD, 50) );
  
        box.add(label);
        
        text1=new JTextField();
        text1.setBounds(100, 50, 300, 70);
        text1.setFont(new Font(null, Font.BOLD, 16) );
        label.add(text1);

        fName=new JLabel();
        fName.setBounds(10,50,100,70);
        fName.setText("First Name:");
        fName.setForeground(Color.WHITE );
        fName.setFont(new Font(null, Font.BOLD, 16) );
        label.add(fName);

        text2=new JTextField();
        text2.setBounds(100,150,300,70);
        text2.setFont(new Font(null, Font.BOLD, 16) );
        label.add(text2);

        mName=new JLabel("Mid Name:");
        mName.setBounds(10, 150, 100, 70);
        mName.setForeground(Color.WHITE);
        mName.setFont(new Font(null,Font.BOLD,16));
        label.add(mName);

        text3=new JTextField();
        text3.setBounds(100,250,300,70);
        text3.setFont(new Font(null, Font.BOLD, 16) );
        label.add(text3);

        lName=new JLabel("Last Name:");
        lName.setBounds(10, 250, 100, 70);
        lName.setForeground(Color.WHITE);
        lName.setFont(new Font(null,Font.BOLD,16));
        label.add(lName);

        text4=new JTextField();
        text4.setBounds(100,350,300,70);
        text4.setFont(new Font(null, Font.BOLD, 16) );
        label.add(text4);
        text4.addActionListener(this);

        age=new JLabel("Age:");
        age.setBounds(10, 350, 100, 70);
        age.setForeground(Color.WHITE);
        age.setFont(new Font(null,Font.BOLD,16));
        label.add(age);

        text5=new JTextField();
        text5.setBounds(100,450,300,70);
        text5.setFont(new Font(null, Font.BOLD, 16));
        label.add(text5);
        text5.addActionListener(this);

        adharno=new JLabel("Adhar No:");
        adharno.setBounds(10, 450, 100, 70);
        adharno.setForeground(Color.WHITE);
        adharno.setFont(new Font(null,Font.BOLD,16));
        label.add(adharno);


        btnMenu=new JButton();
        btnMenu.setBounds(100,550,200,100);
        btnMenu.setText("Go To Menu");
        btnMenu.setFont(new Font(null,Font.BOLD,17));
        label.add(btnMenu);
        btnMenu.addActionListener(this);

        btnCtreate=new JButton();
        btnCtreate.setBounds(400,550,200,100);
        btnCtreate.setText("CREATE");
        btnCtreate.setFont(new Font(null,Font.BOLD,17));
        label.add(btnCtreate);
        btnCtreate.addActionListener(this);
        
        btnExit=new JButton();
        btnExit.setBounds(700,550,200,100);
        btnExit.setText("Exit");
        btnExit.setFont(new Font(null,Font.BOLD,17));
        label.add(btnExit);
        btnExit.addActionListener(this);

        

        dob=new JLabel();
        dob.setBounds(450,50,110,70);
        dob.setText("Date Of Birth:");
        dob.setForeground(Color.WHITE);
        dob.setFont(new Font(null,Font.BOLD,16));
        label.add(dob);

        text6=new JTextField();
        text6.setBounds(560,50,300,70);
        text6.setFont(new Font(null, Font.BOLD, 17));
        label.add(text6);
        
        mob=new JLabel();
        mob.setBounds(450,150,100,70);
        mob.setText("Mobile No:");
        mob.setForeground(Color.WHITE);
        mob.setFont(new Font(null,Font.BOLD,18)); 
        label.add(mob);

        text7=new JTextField();
        text7.setBounds(560,150,300,70);
        text7.setText("+91");
        text7.setFont(new Font(null, Font.BOLD, 17));
        label.add(text7);
        text7.addActionListener(this);

        occup=new JLabel("Occupation:");
        occup.setBounds(450,250,100,70);
        occup.setFont(new Font(null,Font.BOLD,17));
        label.add(occup);


        String s[]={" ","Student","Business","Job","Other"};
        combox=new JComboBox(s);
        combox.setBounds(560,250,300,70);
        combox.setFont(new Font(null,Font.BOLD,20));
        label.add(combox);

        gender=new JLabel("Gender:");
        gender.setBounds(450,330,100,70);
        gender.setFont(new Font(null,Font.BOLD,17));
        label.add(gender);

        
        jbtnMale=new JRadioButton("Male");
        jbtnMale.setBounds(560,350,70,50);
        jbtnMale.setFont(new Font(null,Font.BOLD,17));
        label.add(jbtnMale);

         
        jbtnFemale=new JRadioButton("Female");
        jbtnFemale.setBounds(650,350,100,50);
        jbtnFemale.setFont(new Font(null,Font.BOLD,16));
        label.add(jbtnFemale);

         
        jbtnOther=new JRadioButton("Other");
        jbtnOther.setBounds(780,350,100,50);
        jbtnOther.setFont(new Font(null,Font.BOLD,16));
        label.add(jbtnOther);

        ButtonGroup bg=new ButtonGroup();
        bg.add(jbtnMale);
        bg.add(jbtnFemale);
        bg.add(jbtnOther);



        screen.setVisible(true);
    }
    

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnMenu)
        {
            new Menu();
        }
        if(e.getSource()==btnCtreate)
        {
            JOptionPane.showMessageDialog(null, "Your Account Is Created Successfully", "ACCOUNT", JOptionPane.PLAIN_MESSAGE);
        }
        if(e.getSource()==btnExit)
        {
            System.exit(0);
        }
        if(e.getSource()==text4)
        {
         try {
            int a;
         String s=text4.getText();
         a=Integer.parseInt(s);
            
         } catch (Exception k) {
            
            JOptionPane.showMessageDialog(null, "Please Enter A Numeric Value", "RECOMENDATION", JOptionPane.PLAIN_MESSAGE);
         }

        }
        if(e.getSource()==text5)
        {
            try {

                long b;
                String s1=text4.getText();
                b =Long.parseLong(s1);

                if(b>=100000000000000L && b<=99999999999999L)
                {
                   
                }
            
                
            } catch (Exception l) 
            {
                JOptionPane.showMessageDialog(null, "Please Enter Numbers Between 15 Digits", "RECOMENDATION", JOptionPane.PLAIN_MESSAGE);
            }
        }
        if(e.getSource()==text7)
        {
            try {
                long c;
                String s2=text4.getText();
                c =Long.parseLong(s2);
                if(c>=1000000000L && c<=9999999999L)
                {
                    
                }
                
            } catch (Exception m) {
             
                JOptionPane.showMessageDialog(null, "Please Enter Numbers Between 10 Digits","RECOMENDATION", JOptionPane.PLAIN_MESSAGE);

            }
        }

    }
    
}
