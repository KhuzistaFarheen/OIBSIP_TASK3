import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Transactions implements ActionListener {
    private JFrame screen;
    private Image image1,image2;
    private ImageIcon img1,img2;
    private Container box;
    private JLabel label,label0,label1,label2,label3,transID,transType,transAmt,transCbalance,transStatus;
    private JButton btnMenu,btnExit,btnHistory;
    static JTextArea textArea;
    static ArrayList history = new ArrayList();
    public Transactions()
    {
        screen=new JFrame();
        screen.setSize(1000, 700);
        screen.setLocationRelativeTo(null);
        screen.setTitle("TRANSACTIONS HISTORY");
        screen.setLayout(null);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        box=screen.getContentPane();
        box.setBounds(0, 0, screen.getWidth(), screen.getHeight());
        box.setBackground(Color.GREEN);

        img1=new ImageIcon(ClassLoader.getSystemResource("Images//transactions.jpg"));
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

        transID=new JLabel("TransID");
        transID.setBounds(50,250,70,30);
        transID.setForeground(Color.RED);
        transID.setFont(new Font(null, Font.BOLD, 16) );
        label.add(transID);

        transType=new JLabel("TransType");
        transType.setBounds(155,250,90,30);
        transType.setForeground(Color.RED);
        transType.setFont(new Font(null, Font.BOLD, 16) );
        label.add(transType);        

        transAmt=new JLabel("TransAmount");
        transAmt.setBounds(270,250,130,30);
        transAmt.setForeground(Color.RED);
        transAmt.setFont(new Font(null, Font.BOLD, 16) );
        label.add(transAmt);        

        transCbalance=new JLabel("CurrentBalance");
        transCbalance.setBounds(390,250,130,30);
        transCbalance.setForeground(Color.RED);
        transCbalance.setFont(new Font(null, Font.BOLD, 16) );
        label.add(transCbalance);    
        
        transStatus=new JLabel("TransStatus");
        transStatus.setBounds(535,250,130,30);
        transStatus.setForeground(Color.RED);
        transStatus.setFont(new Font(null, Font.BOLD, 16) );
        label.add(transStatus);        

        textArea=new JTextArea();
        textArea.setBounds(50,280,900,300);
        textArea.setFont(new Font(null, Font.BOLD, 17));
        textArea.setEditable(false);
        label.add(textArea);

        btnMenu=new JButton();
        btnMenu.setBounds(100,600,200,50);
        btnMenu.setText("Go To Menu");
        btnMenu.setBackground(Color.YELLOW);
        btnMenu.setFont(new Font(null,Font.BOLD,17));
        label.add(btnMenu);
        btnMenu.addActionListener(this);

        btnHistory=new JButton("Show History");
        btnHistory.setBounds(350,600,200,50);
        btnHistory.setBackground(Color.YELLOW);
        btnHistory.setFont(new Font(null,Font.BOLD,17));
        label.add(btnHistory);
        btnHistory.addActionListener(this);

        btnExit=new JButton();
        btnExit.setBounds(600,600,200,50);
        btnExit.setText("EXIT");
        btnExit.setBackground(Color.YELLOW);
        btnExit.setFont(new Font(null,Font.BOLD,17));
        label.add(btnExit);
        btnExit.addActionListener(this);

        screen.setVisible(true);
    }
   
    public static void setHistory(int transactionID, String transType, double transAmount, double balance, String transStatus)
    {
      ArrayList list = new ArrayList();
      list.add(transactionID);
      list.add(transType);
      list.add(transAmount);
      list.add(balance);
      list.add(transStatus);
  
      history.add(list);
      System.out.println(history);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      
        if(e.getSource()==btnMenu)
        {
            new Menu();
        }
        if(e.getSource()==btnExit)
        {
            System.exit(0);
        }
        if(e.getSource()==btnHistory)
        {
            btnHistory.setVisible(false);
          Iterator ot = history.iterator();
          while(ot.hasNext())
          {
            ArrayList a = (ArrayList) ot.next();
            Iterator it = a.iterator();
            while(it.hasNext())
            {
              String data = it.next().toString();
              if(data.equals("Success") || data.equals("Failed"))
              {
                  textArea.setText(textArea.getText().concat(data+"\n------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"));
              }
              else
              {
              textArea.setText(textArea.getText().concat(data+"\t"));
              }
            }
          }
        }

    
}
}
