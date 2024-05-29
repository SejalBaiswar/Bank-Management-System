
package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener
{
     JButton deposit,withdrawl,fastcash,balance,exit,ministatement,pinchange;
     String pinnumber;

    Transactions(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800,Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(190, 220, 700, 35);
        text.setFont(new Font("System",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(160, 320,150, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Cash Withdrawal");
        withdrawl.setBounds(360, 320,150, 25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(160, 350,150, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(360, 350,150, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(160, 380,150, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance=new JButton("Balance Enquiry");
        balance.setBounds(360, 380,150, 25);
        balance.addActionListener(this);
        image.add(balance);
        
        exit=new JButton("Exit ");
        exit.setBounds(360, 410,150, 25);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(900,1500);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        
    }  
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==exit){
            System.exit(0);
        } else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
                   
        } else if(ae.getSource()==withdrawl){
             setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if(ae.getSource()==fastcash){
            
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if(ae.getSource()==pinchange){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        } else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if(ae.getSource()==ministatement){
            //setVisible(false);
            new Ministatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main (String args[])
    {
        new Transactions("");
    }
}
