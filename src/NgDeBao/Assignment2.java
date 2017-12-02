/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NgDeBao;

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;

public class Assignment2 {
           
    public static void main(String[] args) {
        
        Assignment2 ass = new Assignment2();
        ass.login();
    }
    
    private Formatter fM;
    private Scanner x;
    
    public void input(String user) {
        
        Scanner input = new Scanner(System.in);
        char num;
        
        openReadFile();
        readFile();
        closeReadFile();
        
        System.out.println("**********Delivery status************\n");
        System.out.println("1. available   2. delivery   3. break for clock out");
        System.out.print("Please enter your delivery status:");
        num = input.nextLine().charAt(0);
        System.out.println("\n");
        
        if(Character.isDigit(num) && !Character.isSpaceChar(num)) {
        openFile();
        addRecord(user, num);
        closeFile();
        
        if(num == '1') {
            input(user);
        }
        else if(num == '2') {
            input(user);
        }
        else if(num == '3') {
            System.exit(0);
        }
        else {
            System.out.println("\nPlease enter following the numbers above\n");
            input(user);
        }
       }
        else {
           System.err.println("\nYou can enter number only !\n");
           input(user); 
        }
        
    }
    public void login() {
        
        Scanner userName  = new Scanner(System.in);
        Scanner password  = new Scanner(System.in);
        String user;
        String pass;
        
        System.out.print("Enter username: ");
        user = userName.nextLine();
        System.out.print("Enter password: ");
        pass = password.nextLine();
        
        if(user.equals("AhSeng")&&pass.equals("12345")) {
          Calendar cal = new GregorianCalendar();
          Date date = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("  EE dd-MM-yyyy hh:mm aa");
          String dateString = sdf.format(date);
          
          System.out.print("\nWelcome " + user);
          System.out.println("  Date & Time you clock IN:" + dateString + "\n");
          input(user);
        }
        else {
            System.out.println("Wrong username or password, please enter them again");
            login();
        }
    }
    
    public void openFile() {
        
        try{
           fM = new Formatter("Record.txt");
        }catch(Exception e){
            System.err.println("You have error");
        }
    }
    public void addRecord(String user, char num) {
        
        if(num == '1') {
               fM.format(user + " is AVAILABLE");
           }
           else if(num == '2') {
               fM.format(user + " is DELIVERY");
           }
           else if(num == '3') {
             fM.format(user + " is BREAK");
             Calendar cal2 = new GregorianCalendar();
             Date date2 = cal2.getTime();
             SimpleDateFormat sdf2 = new SimpleDateFormat("  EE dd-MM-yyyy hh:mm aa");
             String dateString2 = sdf2.format(date2);
             System.out.print("Date & Time you clock OUT:" + dateString2 + "\n");
           }
    }    
    
    public void closeFile() {
        fM.close();
    }
    
    public void openReadFile() {
        
        try{
           x = new Scanner(new File("Record.txt"));
        }catch(Exception e){
            System.err.println("You have error");
        }
    }
        
    public void readFile() {
     while(x.hasNext()) {
         String a = x.next();
         System.out.printf("%s " ,a);
     }
        System.out.println("\n");
    }
    
    public void closeReadFile() {
        x.close();
    }
    
}
