package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class shop1 {

       Connection con = null;

    public Connection getconnection() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }
  public int save(shop s){
    int ii=0;
    try{
        con=getconnection();
        PreparedStatement stmt = con.prepareStatement("insert into employee values(?,?,?)");
        int i=s.getId();
        String n=s.getName();
        int c=s.getContact_no();
        stmt.setInt(1, i);
        stmt.setString(2, n);
        stmt.setInt(3, c);
        ii=stmt.executeUpdate();
    }
    catch (Exception e){
        System.out.println(e);

    }
    return ii;
  }
  public void showAllshop(){
    try{
con=getconnection();
Statement som=con.createStatement();
ResultSet rs=som.executeQuery("select * from shop5");
// rs.next();
while(rs.next()){
    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
}
    }
    catch(Exception e){
        System.out.println(e);

    }
  }
  public ArrayList<shop> getshop(){
    ArrayList<shop> s=new ArrayList<>();

    try{
con=getconnection();
    Statement som= con.createStatement();
            ResultSet rs = som.executeQuery("select * from employee");
            
            
            while (rs.next()) {

            
                int j=rs.getInt(1);
                String k=rs.getString(2);
                int l=rs.getInt(3);
                
            shop p= new shop(j, l, k);
             
          s.add(p);kk





            }



    }
    catch(Exception ec){
        System.out.println(ec);
    }



    return s;
}
}


