package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class App 
{
    public static void main( String[] args )
    {
       

try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","1234");  
  
//step3 create the statement object  
Statement stmt=con.createStatement();  
  
//step4 execute query  
ResultSet rs=stmt.executeQuery("select * from food");  
// rs.next();

// System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "  +rs.getInt(4)+" "+rs.getString(5));  
  
// rs.next();
// System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "  +rs.getInt(4)+" "+rs.getString(5));  
  
while (rs.next()) {
    
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
  
    
}
//step5 close the connection object  
con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  
}  

    }

