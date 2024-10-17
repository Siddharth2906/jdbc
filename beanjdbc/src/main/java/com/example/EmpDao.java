package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpDao {

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

    public int save(Emp e){
   int ii=0;
   try{

        con=getconnection();
        PreparedStatement stmt = con.prepareStatement("insert into employee values(?,?,?)");
                    
                 int i=e.getId();
                 String n=e.getName();
                 String c=e.getCountry();
                    
                    stmt.setInt(1, i);
                    stmt.setString(2, n);
                    stmt.setString(3, c);
                    
                     ii=stmt.executeUpdate();
                   
    }
    catch(Exception ee){
    System.out.println(e);

}

return ii;
}

public void showAllEmp(){
    try{
con=getconnection();
    Statement som= con.createStatement();
            ResultSet rs = som.executeQuery("select * from employee");
            rs.next();
            
            while (rs.next()) {

            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

            }



    }
    catch(Exception ec){
        System.out.println(ec);
    }




}


public ArrayList<Emp> getEmp(){
    ArrayList<Emp> ee=new ArrayList<>();

    try{
con=getconnection();
    Statement som= con.createStatement();
            ResultSet rs = som.executeQuery("select * from employee");
            
            
            while (rs.next()) {

            
                int j=rs.getInt(1);
                String k=rs.getString(2);
                String l=rs.getString(3);
                Emp p=new Emp(j,k,l);

                ee.add(p);
           // System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));


//System.out.println(i+ " "+n+" "+c);





            }



    }
    catch(Exception ec){
        System.out.println(ec);
    }



    return ee;
}




}
