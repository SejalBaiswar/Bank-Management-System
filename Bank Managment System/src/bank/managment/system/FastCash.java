
package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
     JButton b1,b2,b3,b4,b5,b6,b7;
     String pinnumber;

    FastCash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800,Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT ");
        text.setBounds(190, 220, 700, 35);
        text.setFont(new Font("System",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        b1=new JButton("Rs 100");
        b1.setBounds(160, 320,150, 25);
        b1.addActionListener(this);
        image.add(b1);
        
        b2=new JButton("Rs 500");
        b2.setBounds(360, 320,150, 25);
        b2.addActionListener(this);
        image.add(b2);
        
        b3=new JButton("Rs 1000");
        b3.setBounds(160, 350,150, 25);
        b3.addActionListener(this);
        image.add(b3);
        
        b4=new JButton("Rs 2000");
        b4.setBounds(360, 350,150, 25);
        b4.addActionListener(this);
        image.add(b4);
        
        b5=new JButton("Rs 5000");
        b5.setBounds(160, 380,150, 25);
        b5.addActionListener(this);
        image.add(b5);
        
        b6=new JButton("Rs 10000");
        b6.setBounds(360, 380,150, 25);
        b6.addActionListener(this);
        image.add(b6);
        
        b7=new JButton("Back ");
        b7.setBounds(360, 410,150, 25);
        b7.addActionListener(this);
        image.add(b7);
        
        
        setSize(900,1500);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        
    }  
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b7){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } 
        else
        {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try {
               ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
               int balance = 0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                   } else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                   }
               }
               if(ae.getSource()!=b7 && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   return;
               }
               Date date = new Date();
               String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+amount+ "')";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Debite Sccussfully");
               
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
            } 
            catch(Exception e)
            {
                System.out.println(e);
            }
        } 
    }
    
    public static void main (String args[])
    {
        new FastCash("");
    }
}


