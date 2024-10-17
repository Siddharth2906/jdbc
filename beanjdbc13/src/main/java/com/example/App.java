package com.example;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc= new Scanner(System.in);
        shop1 s1=new shop1();
     System.out.println("enter 1 for insert 2 for view data");
     int ch=sc.nextInt();
     if(ch==1){
        System.out.println("enter id name and contact_no");
        int id =sc.nextInt();
        String n=sc.next();
        int c=sc.nextInt();
        shop s=new shop(id, c, n);
       int m= s1.save(s);
       if(m>0){
        System.out.println("inserted");
       }
       else{
        System.out.println("not");
       }
     }
     if(ch==2){
        s1.showAllshop();
     }
    }
}
