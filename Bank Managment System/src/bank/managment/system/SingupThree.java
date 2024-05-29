
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SingupThree extends JFrame implements ActionListener
{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancle;
    String formno;
    
    SingupThree(String formno)
    {
        setLayout(null);
        this.formno=formno;
        
        
        JLabel l1= new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        
        JLabel type= new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100, 140, 200, 40);
        add(type);
       
        r1=new JRadioButton("Saving Account");
        r1.setBounds(100, 180, 150, 40);
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2=new JRadioButton("Current Account");
        r2.setBounds(100, 220, 200, 40);
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3=new JRadioButton("Fixed Deposit Account");
        r3.setBounds(400, 180, 200, 40);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBounds(400, 220, 300, 40);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup grouping = new ButtonGroup();
        grouping.add(r1);
        grouping.add(r2);
        grouping.add(r3);
        grouping.add(r4);
        
        JLabel card= new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100, 270, 200, 40);
        add(card);
        
        JLabel number= new JLabel("XXXX-XXXX-XXXX-4135");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(350, 270, 400, 40);
        add(number);
        
        JLabel carddetail= new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,14));
        carddetail.setBounds(100, 310, 200, 20);
        add(carddetail);
        
        JLabel pin= new JLabel("Pin Number");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100, 360, 200, 40);
        add(pin);
        
        JLabel pnumber= new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(350, 360, 400, 40);
        add(pnumber);
        
        JLabel pindetail= new JLabel("Your 4 Digit Password");
        pindetail.setFont(new Font("Raleway",Font.BOLD,14));
        pindetail.setBounds(100, 390, 200, 20);
        add(pindetail);
        
        JLabel sevices= new JLabel("Services Required : ");
        sevices.setFont(new Font("Raleway",Font.BOLD,22));
        sevices.setBounds(100, 440, 220, 40);
        add(sevices);

        c1= new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("raleway",Font.BOLD,16));
        c1.setBounds(100, 490, 200, 30);
        add(c1);
        
        c2= new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("raleway",Font.BOLD,16));
        c2.setBounds(330, 490, 200, 30);
        add(c2);
        
        c3= new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("raleway",Font.BOLD,16));
        c3.setBounds(100, 515, 200, 30);
        add(c3);
        
        c4= new JCheckBox("EMAIL & SMS ALERT");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("raleway",Font.BOLD,16));
        c4.setBounds(330, 515, 200, 30);
        add(c4);
        
        c5= new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("raleway",Font.BOLD,16));
        c5.setBounds(100, 540, 200, 30);
        add(c5);
        
        c6= new JCheckBox("E- STATEMENT");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("raleway",Font.BOLD,16));
        c6.setBounds(330, 540, 200, 30);
        add(c6);
        
        c7= new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("raleway",Font.BOLD,12));
        c7.setBounds(100,600, 650, 30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.addActionListener(this);
        submit.setBounds(420, 650, 100, 30);
        add(submit);
        
        cancle=new JButton("Cancle");
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.setFont(new Font("Raleway",Font.BOLD,14));
        cancle.addActionListener(this);
        cancle.setBounds(220, 650, 100, 30);
        add(cancle);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,900);
        setLocation(350,10);
        setVisible(true);
                
    }
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()==submit)
         {
             String accountType=null;
             if(r1.isSelected()){
                 accountType="Saving Account";
                 
             }
             else if(r2.isSelected()){
                 accountType="Current Account";
             }
             else if(r3.isSelected()){
                 accountType="Fixed Deposit Account";
             }
             else if(r4.isSelected()){
                 accountType="Recurring Deposit Account";
             }
             
             Random random= new Random();
             String cardnumber = "" + Math.abs((random.nextLong()% 90000000L) + 5837383100000000L);
             
             String pinnumber = "" + Math.abs((random.nextLong()%9000L)+1000L);
             
             String facility="";
             
             if (c1.isSelected()){
                 facility = facility+"ATM Card";
             } 
             else if(c2.isSelected()){
                 facility = facility+"Internet Banking";
             } 
             else if(c3.isSelected()){
                 facility = facility+"Mobile Banking";
             }
             else if(c4.isSelected()){
                 facility = facility+"Email & SMS service";
             } 
             else if(c5.isSelected()){
                 facility = facility+"Checqu Book";
             } 
             else if(c6.isSelected()){
                 facility = facility+"E- Statement";
             }
             
             try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } 
                else{
                    Conn conn= new Conn();
                    String query1 = "insert into singupthree values('"+formno+"' , '"+accountType+"' , '"+cardnumber+"' , '"+pinnumber+"' , '"+facility+"' )";
                    String query2 = "insert into login values('"+formno+"' , '"+cardnumber+"' , '"+pinnumber+"' )";
                    
                     conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    
                    JOptionPane.showMessageDialog(null,"Card Number: "+ cardnumber + "\n Pin : "+ pinnumber);
                    
                    setVisible(false);
                    new Deposite(pinnumber).setVisible(true);
                }
                
                
             } 
             catch(Exception e){
                 System.out.println(e);
             }
          }

                     
         else if(ae.getSource()==cancle)
         {
             setVisible(false);
             new Login().setVisible(true);
        }
     }
    
    
    public static void main (String args[])
    {
        new SingupThree("");
    }
}
