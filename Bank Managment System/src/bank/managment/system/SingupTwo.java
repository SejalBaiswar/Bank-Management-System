
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SingupTwo extends JFrame implements ActionListener
{
    
    
    JTextField anumTF,pnumTF;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religionc,cast,inc,EQ,Occu;
    String formno;
    
    
    SingupTwo(String formno)
    {
        
       this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
       
        
        JLabel ADetails=new JLabel("Page 2: Additional Details");
        ADetails.setFont(new Font("Raleway",Font.BOLD,22));
        ADetails.setBounds(270, 30, 400, 40);
        add(ADetails);
        
        JLabel religion= new JLabel("Religion :");
        religion.setFont(new Font("raleway",Font.BOLD,20));
        religion.setBounds(80,120,200,30);
        add(religion);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        
        religionc=new JComboBox(valReligion);
        religionc.setBounds(350, 120, 400, 25);
        religionc.setBackground(Color.WHITE);
        add(religionc);
        
        
        JLabel category = new JLabel("Category :");
        category.setFont(new Font("raleway",Font.BOLD,20));
        category.setBounds(80,170,200,30);
        add(category);
        
        String valCast[]={"Gernal","OBC","SC","ST","Other"};
        
        cast=new JComboBox(valCast);
        cast.setBounds(350, 170, 400, 25);
        cast.setBackground(Color.WHITE);
        add(cast);
        
        JLabel income= new JLabel("Income :");
        income.setFont(new Font("raleway",Font.BOLD,20));
        income.setBounds(80,220,200,30);
        add(income);
        
        String valinc[]={"Null","< 50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
        
        inc=new JComboBox(valinc);
        inc.setBounds(350, 220, 400, 25);
        inc.setBackground(Color.WHITE);
        add(inc);
        
        
        
        
        JLabel educational= new JLabel("Educational");
        educational.setFont(new Font("raleway",Font.BOLD,20));
        educational.setBounds(80,270,200,30);
        add(educational);
        
        
        
        JLabel qualification= new JLabel("Qualification :");
        qualification.setFont(new Font("raleway",Font.BOLD,20));
        qualification.setBounds(80,300,200,30);
        add(qualification);
        
        String valEQ[]={"Non-Graduation","Graduation","Post-Graduation","Doctrate","Other"};
        
        EQ=new JComboBox(valEQ);
        EQ.setBounds(350, 290, 400, 25);
        EQ.setBackground(Color.WHITE);
        add(EQ);
        
       
        JLabel occupation= new JLabel("Occupation :");
        occupation.setFont(new Font("raleway",Font.BOLD,20));
        occupation.setBounds(80,360,200,30);
        add(occupation);
        
        String valOccu[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        Occu=new JComboBox(valOccu);
        Occu.setBounds(350, 360, 400, 25);
        Occu.setBackground(Color.WHITE);
        add(Occu);
       
        
        JLabel anum= new JLabel("AADHAR Number :");
        anum.setFont(new Font("raleway",Font.BOLD,20));
        anum.setBounds(80,420,200,30);
        add(anum);
        
        anumTF = new JTextField();
        anumTF.setFont(new Font("Raleway",Font.BOLD,16));
        anumTF.setBounds(350, 420, 400, 25);
        add(anumTF);
        
        JLabel pnum= new JLabel("PAN Number :");
        pnum.setFont(new Font("raleway",Font.BOLD,20));
        pnum.setBounds(80,480,200,30);
        add(pnum);
        
        pnumTF = new JTextField();
        pnumTF.setFont(new Font("Raleway",Font.BOLD,16));
        pnumTF.setBounds(350, 480, 400, 25);
        add(pnumTF);
        
        JLabel citizen= new JLabel("Senior Citizen :");
        citizen.setFont(new Font("raleway",Font.BOLD,20));
        citizen.setBounds(80,530,200,30);
        add(citizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(350, 530, 100, 20);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(500, 530, 100, 20);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        
        
        ButtonGroup sGroup=new ButtonGroup();
        sGroup.add(syes);
        sGroup.add(sno);
        
        
        JLabel eaccount= new JLabel("Existing Account :");
        eaccount.setFont(new Font("raleway",Font.BOLD,20));
        eaccount.setBounds(80,580,200,30);
        add(eaccount);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(350, 580, 100, 20);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(500, 580, 100, 20);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        
        
        ButtonGroup eGroup=new ButtonGroup();
        eGroup.add(syes);
        eGroup.add(sno);
        
        
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
    public void actionPerformed(ActionEvent ae)
    {
       
        String religion =(String) religionc.getSelectedItem();
        String category = (String) cast.getSelectedItem();
        String income = (String) inc.getSelectedItem();
        String education = (String) EQ.getSelectedItem();
        String occupation = (String) Occu.getSelectedItem();
        String citizenship=null;
        if(syes.isSelected()){
            citizenship = "Yes";
        } else if(sno.isSelected()){
            citizenship="No";
        }
       
        
        String existing=null;
        if(eyes.isSelected()){
            existing = "Yes";
        } else if(eno.isSelected()){
            existing="No";
        } 
        String aadhar =anumTF.getText();
        String pan=pnumTF.getText();
        
        try
        {
          
            Conn c=new Conn();
            String query = "insert into singuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+aadhar+"','"+pan+"','"+citizenship+"','"+existing+"')";
               
            c.s.executeLargeUpdate(query);
            
            setVisible(false);
            new SingupThree(formno).setVisible(true);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    public static void main(String args[])
    {
        new SingupTwo("");
    }
}

   

