
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login, singup, clear;
    JTextField cardTF;
    JPasswordField PinTF;
    Login(){
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 =i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(100, 10, 100, 100);
        add(label);
     
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(220, 40, 1000, 40);
        text.setFont(new Font("Osward",Font.BOLD,38 ));
        add(text);
        
        JLabel cardno = new JLabel("Card NO.:");
        cardno.setBounds(180, 150, 400, 40);
        cardno.setFont(new Font("Raleway",Font.BOLD,28 ));
        add(cardno);
        
        cardTF=new JTextField();
        cardTF.setBounds(350,150,250,30);
        cardTF.setFont(new Font("Arial",Font.BOLD,14));
        cardTF.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(cardTF);
        
        JLabel pin = new JLabel("PIN:");
        pin.setBounds(180, 230, 400, 40);
        pin.setFont(new Font("Raleway",Font.BOLD,28 ));
        add(pin);
        
        PinTF=new JPasswordField();
        PinTF.setBounds(350,230,250,30);
        PinTF.setFont(new Font("Arial",Font.BOLD,14));
       // PinTF.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1);
        PinTF.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(PinTF);
        
        login = new JButton("SING IN");
        login.setBounds(350, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground( Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        clear = new JButton("CLEAR");
        clear.setBounds(500, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground( Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        singup = new JButton("SINGUP");
        singup.setBounds(350, 350, 250, 30);
        singup.setBackground(Color.BLACK);
        singup.setForeground( Color.WHITE);
        singup.addActionListener(this);
        add(singup);
                
                
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTF.setText("");
            PinTF.setText("");
        }
        else if(ae.getSource()==login){
            Conn conn = new Conn();
            String cardnumber = cardTF.getText();
            String pinnumber = PinTF.getText();
            String query = ("select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'");
            try{
             ResultSet rs = conn.s.executeQuery(query);
             if ( rs.next()){
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
             } else{
                 JOptionPane.showMessageDialog(null, "Incorrect Card number or Pin");
             }
            } 
            
            catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource()==singup){
            setVisible(false);
            new SingupOne().setVisible(true);
        }
        
    }
    public static void main(String args[]){
        new Login();
    }
}
