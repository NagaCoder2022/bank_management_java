package ASimulatorSystem;

import java.sql.*;  

public class Conn2{
    Connection c;
    Statement s;
    public Conn2(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","welcome123");    
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
