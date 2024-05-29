
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SingupOne extends JFrame implements ActionListener {
    
    
    long random;
    JTextField nameTF,FnameTF,emailTF,cityTF,stateTF,addressTF,pincodeTF;
    JButton next;
    JRadioButton male, female, married,unmarried,other;
    JDateChooser dateC;
    
    SingupOne(){
        
        Random ran=new Random();
        random = Math.abs((ran.nextLong()%900L)+1000L);
        
        setLayout(null);
        
        JLabel formno=new JLabel("APPLICATION FORM NO."+ random);
        formno.setFont(new Font("Raleway",Font.BOLD,32));
        formno.setBounds(200, 20, 600, 50);
        add(formno);
        
        JLabel PDetails=new JLabel("Page 1: Personal Details");
        PDetails.setFont(new Font("Raleway",Font.BOLD,22));
        PDetails.setBounds(270, 90, 400, 30);
        add(PDetails);
        
        JLabel name= new JLabel("Name :");
        name.setFont(new Font("raleway",Font.BOLD,20));
        name.setBounds(80,150,200,30);
        add(name);
        
        nameTF = new JTextField();
        nameTF.setFont(new Font("Raleway",Font.BOLD,16));
        nameTF.setBounds(350, 150, 400, 25);
        add(nameTF);
        
        JLabel Fname= new JLabel("Father's Name :");
        Fname.setFont(new Font("raleway",Font.BOLD,20));
        Fname.setBounds(80,200,200,30);
        add(Fname);
        
        FnameTF = new JTextField();
        FnameTF.setFont(new Font("Raleway",Font.BOLD,16));
        FnameTF.setBounds(350, 200, 400, 25);
        add(FnameTF);
        
        JLabel DOB= new JLabel("Date Of Birth :");
        DOB.setFont(new Font("raleway",Font.BOLD,20));
        DOB.setBounds(80,250,200,30);
        add(DOB);
        
        dateC = new JDateChooser();
        dateC.setBounds(350, 250, 400, 25);
        add(dateC);
        
        
        JLabel gender= new JLabel("Gender :");
        gender.setFont(new Font("raleway",Font.BOLD,20));
        gender.setBounds(80,300,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(350, 300, 60, 20);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(500, 300, 80, 20);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email= new JLabel("Email Address :");
        email.setFont(new Font("raleway",Font.BOLD,20));
        email.setBounds(80,350,200,30);
        add(email);
        
        emailTF = new JTextField();
        emailTF.setFont(new Font("Raleway",Font.BOLD,16));
        emailTF.setBounds(350, 350, 400, 25);
        add(emailTF);
        
        JLabel Marital= new JLabel("Marital Status :");
        Marital.setFont(new Font("raleway",Font.BOLD,20));
        Marital.setBounds(80,400,200,30);
        add(Marital);
        
        married = new JRadioButton("Married");
        married.setBounds(350, 400, 100, 20);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(500, 400, 100, 20);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(650, 400, 100, 20);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
        
        JLabel address= new JLabel("Address :");
        address.setFont(new Font("raleway",Font.BOLD,20));
        address.setBounds(80,450,200,30);
        add(address);
        
        addressTF = new JTextField();
        addressTF.setFont(new Font("Raleway",Font.BOLD,16));
        addressTF.setBounds(350, 450, 400, 25);
        add(addressTF);
        
        JLabel city= new JLabel("City :");
        city.setFont(new Font("raleway",Font.BOLD,20));
        city.setBounds(80,500,200,30);
        add(city);
        
        cityTF = new JTextField();
        cityTF.setFont(new Font("Raleway",Font.BOLD,16));
        cityTF.setBounds(350, 500, 400, 25);
        add(cityTF);
        
        JLabel state= new JLabel("State :");
        state.setFont(new Font("raleway",Font.BOLD,20));
        state.setBounds(80,550,200,30);
        add(state);
        
        stateTF = new JTextField();
        stateTF.setFont(new Font("Raleway",Font.BOLD,16));
        stateTF.setBounds(350, 550, 400, 25);
        add(stateTF);
        
        JLabel pincode= new JLabel("Pin Code :");
        pincode.setFont(new Font("raleway",Font.BOLD,20));
        pincode.setBounds(80,600,200,30);
        add(pincode);
        
        pincodeTF = new JTextField();
        pincodeTF.setFont(new Font("Raleway",Font.BOLD,16));
        pincodeTF.setBounds(350, 600, 400, 25);
        add(pincodeTF);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620, 650, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
     
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,900);
        setLocation(350,10);
        setVisible(true);
       
    }
    public void actionPerformed(ActionEvent ae){
        String formno="" + random;
        String name=nameTF.getText();
        String fname= FnameTF.getText();
        String dob=((JTextField)dateC.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender = "Male";
        } else if(female.isSelected()){
            gender="Female";
        }
        String email=emailTF.getText();
        String marital=null;
        if(married.isSelected()){
            marital = "Married";
        } else if(unmarried.isSelected()){
            marital="UnMarried";
        } else if(other.isSelected()){
            marital="Other";
        }
        String address=addressTF.getText();
        String city=cityTF.getText();
        String state=stateTF.getText();
        String pincode=pincodeTF.getText();

        try{
           if(name.equals("")){
              JOptionPane.showMessageDialog(null, "Nmae is Required");
           } 
           else if(fname.equals("")){
              JOptionPane.showMessageDialog(null, "Father's Nmae is Required");
           } 
           else if(dob.equals("")){
              JOptionPane.showMessageDialog(null, "DOB is Required");
           } 
           else if(address.equals("")){
              JOptionPane.showMessageDialog(null, "Address is Required");
           }
           else if(email.equals("")){
              JOptionPane.showMessageDialog(null, "Email is Required");
           }
           else if(city.equals("")){
              JOptionPane.showMessageDialog(null, "City is Required");
           } 
           else if(state.equals("")){
              JOptionPane.showMessageDialog(null, "State is Required");
           } 
           else if(pincode.equals("")){
              JOptionPane.showMessageDialog(null, "Gender is Required");
           } 
           else{
               Conn c=new Conn();
               String query = "insert into singup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
               
               c.s.executeLargeUpdate(query);
               
               
               setVisible(false);
               new SingupTwo(formno).setVisible(true);
           }


        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String args[]){
        new SingupOne();
    }
    }

   
