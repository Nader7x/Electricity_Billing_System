/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MAZEN
 */
public class Bill {
    private static int count = 220;
    private int customerId;
    private static int total = 0;
    private String region;
    private double amount;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private int meterCode;
    private boolean paidOrNot;
    private int billId = 221;
    
    public Bill(int customerId, String region, double amount, int meterCode,LocalDateTime now) 
    {
        Handlers.billsHandler.createFile();
        this.billId = count++;
        this.customerId = customerId;
        this.region = region;
        this.amount = amount;
        this.meterCode = meterCode;
        
        Scanner fr = null;
        try
        {
            fr = new Scanner(new File(FilePaths.billsFile));
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        if(Handlers.billsHandler.createFile() == true || !fr.hasNextLine())
        {
            Handlers.billsHandler.writeToFile(total);
        }
        fr.close();
        if(paidOrNot == true)
        {
            this.total += this.amount;
            Handlers.billsHandler.changeTheTotal(total);
        }
        
        Handlers.billsHandler.writeToFile(region);
        this.setId();
        Handlers.billsHandler.writeToFile(customerId);
        Handlers.billsHandler.writeToFile(amount);
        Handlers.billsHandler.writeToFile(meterCode);
        Handlers.billsHandler.writeToFile(dtf.format(now));
        Handlers.billsHandler.writeToFile(false);
    }
    
    public void setId()
    {
        try
        {
            Scanner fr = new Scanner(new File(FilePaths.billsFile));
            ArrayList<String> list = Handlers.billsHandler.insertFileIntoList();
            
            String lastId="",data="";
            int newId = 0;
            if(list.size()<8)
            {
                Handlers.billsHandler.writeToFile(this.getId());
                return;
            }else{
               data = fr.nextLine();
               data = fr.nextLine();
               data = fr.nextLine();
               lastId = data;
               while(fr.hasNextLine())
               {
                   
                   for(int i =0; i<7; i++)
                   {
                       if(!fr.hasNextLine())
                           break;
                       data = fr.nextLine();
                   }
                   if(!fr.hasNextLine())
                       break;
                   lastId = data;
               }
               fr.close();
               Integer n = new Integer(lastId);
               this.billId = n.intValue() +1;
               Handlers.billsHandler.writeToFile(n.intValue()+1);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void setCustomerId(int customerId) 
    {
        this.customerId = customerId;
    }

    public void setRegion(String region) 
    {
        this.region = region;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public void setMeterCode(int meterCode) 
    {
        this.meterCode = meterCode;
    }

    public void setPaidOrNot(boolean paidOrNot) 
    {
        this.paidOrNot = paidOrNot;
    }

    public int getCustomerId() 
    {
        return customerId;
    }

    public static double getTotal()
    {
        return total;
    }

    public String getRegion() 
    {
        return region;
    }

    public double getAmount() 
    {
        return amount;
    }

    public int getMeterCode()
    {
        return meterCode;
    }

    public boolean isPaidOrNot() 
    {
        return paidOrNot;
    }

    public int getId() {
        return billId;
    }
    
    
}
