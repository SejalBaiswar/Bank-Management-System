
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener
{
    
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
   Pinchange(String pinnumber)
   {
       this.pinnumber = pinnumber;
       setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800,Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN ");
        text.setBounds(240, 220, 700, 35);
        text.setFont(new Font("System",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(165, 260, 180, 25);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setForeground(Color.WHITE);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330, 260, 180, 25);
        add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN: ");
        repintext.setBounds(165, 300, 180, 25);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setForeground(Color.WHITE);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330, 300, 180, 25);
        add(repin);
        
        change = new JButton("Change");
        change.setBounds(400, 375, 120, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(400, 410, 120, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,1500);
        setLocation(300,0);
       // setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
   }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change)
        {
        try{
            String npin=pin.getText();
            String rpin=repin.getText();
            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null, "Entered pin does not match");
                return;
            }
            if(npin.equals(""))
            {
               JOptionPane.showMessageDialog(null, "Plese enter PIN");
               return;
            }
            if(rpin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Plese re-enter new PIN");
                return;
            }
            Conn conn = new Conn();
            String query1 = "update bank set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
            String query2 = "update singupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
            String query3 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null,"PIN changed succussfully");
            
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } 
        catch(Exception e)
        {
            
        }
      }
     else
     {
         setVisible(false);
         new Transactions(pinnumber).setVisible(true);
     }
    }
    
    public static void main(String args[])
    {
        new Pinchange("");
    }
}
