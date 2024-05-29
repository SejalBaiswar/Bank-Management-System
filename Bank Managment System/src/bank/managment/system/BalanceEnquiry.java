
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;



public class BalanceEnquiry extends JFrame implements ActionListener
{
     
    String pinnumber;
    JButton b7;
    BalanceEnquiry(String pinnumber){
         this.pinnumber = pinnumber;
         
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800,Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
        
        b7=new JButton("Back ");
        b7.setBounds(360, 410,150, 25);
        b7.addActionListener(this);
        image.add(b7);
        
        
            Conn conn=new Conn();
            int balance = 0;
           try {
               ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
             
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                   } else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                   }
               }
           }
           
           
            catch(Exception e)
            {
                System.out.println(e);
            }

        
        JLabel text = new JLabel("Your Current Account balance is Rs "+ balance);
         text.setBounds(170, 230, 400, 30);
         text.setForeground(Color.WHITE);
         image.add(text);
        
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
    }
    
    public static void main(String args[])
    {
        new BalanceEnquiry("");
    }
}
