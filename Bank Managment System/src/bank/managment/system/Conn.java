
package bank.managment.system;

import java.sql.*;


public class Conn {
    
    Connection c;
    Statement s;
    public Conn() {
        try{
            // Class.forName("com.mysql.jdbc.Driver");
             System.out.println(" Data insert Successfully");
            //c=DriverManager.getConnection("jdbc:mysql://localhost:3306 /BankManagmentSystem","root","Root123")
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagmentsystem","root","Root123");   
            s=c.createStatement();
           }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
