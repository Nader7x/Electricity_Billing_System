/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MAZEN
 */
public class Operator extends Person{
    private static int counter = 440;
    private int operatorId = 441;
    private int salary;
    private String nationalId;
    private String workingRegion;
    private boolean loggedInSuccessfully;

    public boolean isLoggedInSuccessfully() {
        return loggedInSuccessfully;
    }
    Scanner input = new Scanner(System.in);
    
    protected Operator(String s)
    {
        counter++;
    }
    public Operator()
    {
        
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }
    
    public void setNationalId(String nationalId)
    {
        this.nationalId = nationalId;
    }
    
    public void setWorkingRegion(String workingRegion)
    {
        this.workingRegion = workingRegion;
    }
    
        protected void setId(boolean fileIsEmpty)      //admin only will invoke this
    {
        try
        {
            Scanner fr = new Scanner(new File(FilePaths.operatorsFile));
            String lastId="",data="";
            int newId = 0;
            if(fileIsEmpty)
            {
                Handlers.operatorsHandler.writeToFile(getOperatorId());
            }else{
               for(int i=0; i<3; i++)
                 {
                     data = fr.nextLine();
                     lastId = data;
                 }
               while(fr.hasNextLine())
               {
                   
                   for(int i =0; i<6; i++)
                   {
                       if(!fr.hasNextLine())
                           break;
                       data = fr.nextLine();
                   }
                   if(!fr.hasNextLine())
                       break;
                   lastId = data;
               }
               
               Integer n = new Integer(lastId);
               this.operatorId = n.intValue() +1;
               Handlers.operatorsHandler.writeToFile(n.intValue()+1);
               System.out.println(n.intValue()+1);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public int getOperatorId() {
        return operatorId;
    }
    
    @Override
    public boolean login(String username, String password)
    {
        try{
                Scanner fr = new Scanner(new File(FilePaths.operatorsFile));
                String line;
                while(fr.hasNextLine())
                {
                    line = fr.nextLine();
                    if(line == "\n")
                        line = fr.nextLine();
                    if(line.equals(username))
                    {
                        //line = line.trim();
                        line = fr.nextLine();
                        if(line.equals(password))
                        {
                            Integer i = new Integer(fr.nextLine());
                            this.operatorId = i.intValue();
                            
                            line = fr.nextLine();
                            line = fr.nextLine();
                            line = fr.nextLine();
                            
                            this.username = username;
                            this.password = password;
                            this.loggedInSuccessfully = true;    
                            this.workingRegion = line;
                            System.out.println("Logged in successfully");
                            fr.close();
                            return true;
                        }else
                        {
                            for(int i =0;i<5; i++)
                            {
                                if(!fr.hasNextLine())
                                {
                                    fr.close();
                                    System.out.println("Incorrect username or password");
                                    return false;
                                }
                                line = fr.nextLine();
                            }
                        }
                    }
                }
              
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        System.out.println("Incorrect username or password");
        return false;
    }
    
    public void collectPayments()
    {
         
            ArrayList<String> list = Handlers.paymentsHandler.insertFileIntoList();
            
            int index = list.indexOf(this.workingRegion);
            
            if(index == -1)
            {
                System.out.println("No current payments in " + this.workingRegion + " region");
                return;
            }
            int meterCode = 0;
            while(index != -1)
            {
                
                Integer n = new Integer(list.get(index + 3));
                meterCode = n.intValue();
                for(int i = index; i< index+7;i++)
                {
                    list.remove(index);
                }
                index = list.indexOf(this.workingRegion);
                printBill(meterCode);
            }
            
            Handlers.paymentsHandler.updateFile(list);
        
    }
    
    public void printBill(int meterCode)
    {
        System.out.println("===============================================");
        System.out.println("The following bill is collected by the operator");
        Scanner fr = null;
        try {
            fr = new Scanner(new File(FilePaths.billsFile));
        } catch (FileNotFoundException ex) 
        {
            System.out.println(ex.getMessage());
        }
        ArrayList <String> list = new ArrayList<>();
        String data;
        data = fr.nextLine();
        while(fr.hasNextLine())
            {
                for(int i = 0; i<5;i++)
                {
                    if(!fr.hasNextLine())
                        break;
                    data = fr.nextLine();
                    list.add(data);
                }
                if(data.equals(meterCode+""))
                {
                    data = fr.nextLine();
                    list.add(data);
                    System.out.println("Region : " + list.get(0));
                    System.out.println("Bill id : " + list.get(1));
                    System.out.println("Customer id : " + list.get(2));
                    System.out.println("Amount : " + list.get(3));
                    System.out.println("Meter Code : " + list.get(4));
                    System.out.println("Date : " + list.get(5));
                    list.clear();
                }else{
                    if(!fr.hasNextLine())
                        break;
                    data = fr.nextLine();
                    data = fr.nextLine();
                }
            }
            fr.close();
        //search for the bill inside the file using the id and metercode 
        //change the boolean payed from false to true
        //print the bill for the user
    }
    
    public void viewBills()
    {
        try
        {
            Scanner fr = new Scanner(new File(FilePaths.billsFile));
            Scanner fr2 = new Scanner(new File(FilePaths.operatorsFile));
            String region="",city;
            city = fr.nextLine();
            
            while(fr2.hasNextLine())
            {
                region = fr2.nextLine();
                if(region.equals(this.operatorId))
                {
                    for(int i =0;i<3;i++)
                        region = fr.nextLine();
                    break;
                }
            }
            while(fr.hasNextLine())
            {
                city = fr.nextLine();
                if(city.equals(region))
                {  
                    System.out.println("City : " +city);
                    city = fr.nextLine();
                    System.out.println("Bill Id : " +city);
                    city = fr.nextLine();
                    System.out.println("Customer Id : " +city);
                    city = fr.nextLine();
                    System.out.println("Amount : " + city);
                    city = fr.nextLine();
                    System.out.println("Meter Code : " + city);
                    city = fr.nextLine();
                    System.out.println("Date : " + city);
                    city = fr.nextLine();
                    System.out.println("Paid : " + city);
                    System.out.println("=======================================");
                }else{
                    for(int i = 0; i<6; i++){
                        if(!fr.hasNextLine())
                            break;
                        city = fr.nextLine();
                    }
                }
            }
            fr.close();
            fr2.close();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        //search inside bills file for all the bills with this specific region
        //print each one on its own
    }
    
    public  void cancelSubscription(String uid)
    {
        Scanner fr = null;
        int counter=0;
        try {
            fr = new Scanner(new File(FilePaths.customerFile));
        } catch (FileNotFoundException ex) 
        {
            System.out.println(ex.getMessage());
        }
        ArrayList <String> list = new ArrayList<>();
        String data = null;
        while(fr.hasNextLine())
            {
               
                for(int i = 0; i<3;i++)
                {
                    if(!fr.hasNextLine())
                        break;
                    data = fr.nextLine();
                    list.add(data);
                    counter++;
                    
                if(data.equals(uid))
                {
                    for(int j = 0; j<13; j++)
                    {
                        
                        data = fr.nextLine();
                        list.add(data);
                      
                    }   
                   list.set((counter+12), "true");
                   
                }
                else{
                    if(!fr.hasNextLine())
                        break;
                 
                    }
                }
          }
        FileHandler fh = new FileHandler(FilePaths.customerFile);
        fh.clearFile();
        
        for(String str : list)
        {
            fh.writeToFile(str);
        }
        
        
        //delete the contract from contracts file
        list = Handlers.contractsHandler.insertFileIntoList();
        
        if(!list.isEmpty())
        {
            int index = list.indexOf(uid);
            for(int i = index; i<index+3;i++)
            {
                list.remove(index);
            }

            Handlers.contractsHandler.updateFile(list);
        }
        
    }
        
}