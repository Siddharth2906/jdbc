package com.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
       Scanner sc=new Scanner(System.in);
        EmpDao ed=new EmpDao();
System.out.println("enter 1 for inset 2 for view 3 for object array");

int ch=sc.nextInt();
if(ch==1){
       System.out.println( "enter id name and country");
       int id=sc.nextInt();
       String n=sc.next();
         
       String c=sc.next();
       Emp ee=new Emp(id,n,c);
      
       int status=ed.save(ee);
       if(status>0){
    System.out.println("inserted..");
       }
       else{
        System.out.println("not");
       }
    }

if(ch==2){
    ed.showAllEmp();

}

if(ch==3){
    System.out.println("object array");
    ArrayList <Emp>al=ed.getEmp();
    for (Emp emp : al) {
        System.out.println(emp.getId());
        System.out.println(emp.getName());
        System.out.println(emp.getCountry());
        
    }

    
}
}
}
