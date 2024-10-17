package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        Connection con=null;
        try {
            Scanner sc = new Scanner(System.in);

            int r;
            String s;
            String m;


 Class.forName("oracle.jdbc.driver.OracleDriver");

             con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

do{
     System.out.println("enter your choice 1 for insert 2 for view 5 for exit");
   int ch=sc.nextInt();
                
   if(ch==1){
            System.out.println("enter id employee name and company name");
            r = sc.nextInt();
            s = sc.next();
            m = sc.next();

           
                    PreparedStatement stmt = con.prepareStatement("insert into employee values(?,?,?)");
                    
                    // step4 execute query
                    
                    stmt.setInt(1, r);
                    stmt.setString(2, s);
                    stmt.setString(3, m);
                    
                    int i=stmt.executeUpdate();
            System.out.println(i+" records inserted");  
            
   }
   if(ch==2){
            Statement som= con.createStatement();
            ResultSet rs = som.executeQuery("select * from employee");
            rs.next();
            
            while (rs.next()) {

            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

            }
        }


        if(ch==5){
             con.close();
             System.out.println("exit...");
             break;
        }
    }
    while(true);
           
        } catch (Exception e) {
            System.out.println(e);

        }
   
   
  
   
   
   
   
    }
}
