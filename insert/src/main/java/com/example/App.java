package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       

try{  
    Scanner sc=new Scanner(System.in);
    System.out.println("enter rollno name and marks");
    int r=sc.nextInt();
    String s=sc.next();
    int m=sc.nextInt();
    
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","1234");  
  
  
PreparedStatement stmt=con.prepareStatement("insert into stud values(?,?,?)");  
// stmt.setInt(1,101);//1 specifies the first parameter in the query  
// stmt.setString(2,"Ratan"); 
// stmt.setInt(3,99);  
stmt.setInt(1,r);//1 specifies the first parameter in the query  
stmt.setString(2,s); 
stmt.setInt(3,m); 
  
int i=stmt.executeUpdate();  
System.out.println(i+" records inserted");  
  
    

//step5 close the connection object  
con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  

    }
}
