
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;


public class Ministatement extends JFrame
{
    Ministatement(String pinnumber)
    {
        setTitle("MiniStatement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 1000, 250);
        add(mini);
        
        JLabel bank = new JLabel("State Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400 , 300, 20);
        add(balance);
        
        try
        {
          Conn conn = new Conn();
          ResultSet rs = conn.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");
          while(rs.next())
          {
           card.setText("Card Number:  "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
          
          }
          
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }
        try
        {
          Conn conn = new Conn();
          int bal=0;
          ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
          while(rs.next())
         {
           mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") +"<br><br><html>" );
            if(rs.getString("type").equals("Deposit"))
            {
               bal += Integer.parseInt(rs.getString("amount"));
            } 
            else
            {
              bal -= Integer.parseInt(rs.getString("amount"));
            }
         
          // balance.setText("Your current balance is Rs " + bal);
       }
         balance.setText("Your current balance is Rs " + bal);
      }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    
    public static void main(String args[])
    {
        new Ministatement("");
    }
}
