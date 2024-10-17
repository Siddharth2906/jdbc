package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

            PreparedStatement stmt = con.prepareStatement("select * from  shop5 where id=?");

            int i = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("enter id for search=");
            i = sc.nextInt();

            stmt.setInt(1, i);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));

            System.out.println(rs.getInt(3));

            System.out.println("enter id,update name and contact");
            // int p=sc.nextInt();
            String n = sc.next();
            int c = sc.nextInt();
            stmt = con.prepareStatement("update shop5 set name=? ,contact_no=? where id=?");
            stmt.setString(1, n);
            stmt.setInt(2, c);
            // stmt.setString(1, n);

            stmt.setInt(3, i);
            int z=stmt.executeUpdate();
            System.out.println("updated rows="+z);

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
