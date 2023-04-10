/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MAZEN
 */
public class Customer extends Person{
    private static int counter = 330;
    private int customerId = 331;
    private String name;
    private int age;
    private boolean loggedSuccesfully;
    private String nationalId;
    private String mobileNumber;
    private boolean isNew = true;
    private Contract contract;
    private int meterCode;
    private boolean status = false;     //Cancelled(true) or not(false)
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    Scanner input = new Scanner(System.in); 
    
    protected Customer(String s)    //for Admin usage
    {
          counter++;
    }
    
    public Customer() {
        
    }
    
    public boolean isLoggedSuccesfully() {
        return loggedSuccesfully;
    }
    
    private void getStatusOfUser()
    {
         ArrayList<String> list = Handlers.customersHandler.insertFileIntoList();
         Boolean bool ;
                
         int index = list.indexOf(this.customerId+"");
         index+=5;
         bool = new Boolean(list.get(index));
         isNew = bool.booleanValue();
                
            
    }
    private void oneTimeInfo()
    {
            String region, streetName, city;
            Boolean commercialOrNot = true;
            int buildingNumber, apartmentNumber;
            String str;
            System.out.println("This is one time info filling: ");
            System.out.print("Enter your name : ");
            name = input.nextLine();
            System.out.print("Enter your national id : ");
            this.nationalId = input.nextLine();
            System.out.print("Enter your mobile number : ");
            this.mobileNumber = input.nextLine();
            System.out.print("Enter ");
            System.out.print("Is the contract commercial ? (type true for yes, false for no)");     //not working yet
            str = input.nextLine();
            if(str.toUpperCase() == "FALSE")
            {
                commercialOrNot = false;
            }
            System.out.print("Enter the city : ");
            city = input.nextLine();
            System.out.print("Enter the region: ");
            region = input.nextLine();
            System.out.print("Enter the streetName: ");
            streetName = input.nextLine();
            System.out.print("Enter the Building number: ");
            buildingNumber = input.nextInt();
            System.out.print("Enter the Apartment Number : ");
            apartmentNumber = input.nextInt();
            System.out.print("Enter your age: ");
            age = input.nextInt();
            
            contract = new Contract(commercialOrNot.booleanValue(), city, region, streetName, buildingNumber, apartmentNumber, this.customerId);
            fillInfo( name, age, nationalId, mobileNumber, contract, meterCode);
    }
            
    protected void setId(boolean fileIsEmpty)      //admin only will invoke this
    {
        try
        {
            Scanner fr = new Scanner(new File(FilePaths.customerFile));
            String lastId="",data="";
            int newId = 0;
            if(fileIsEmpty)
            {
                Handlers.customersHandler.writeToFile(getCustomerId());
            }else{
               for(int i=0; i<3; i++)
                 {
                     data = fr.nextLine();
                     lastId = data;
                 }
               while(fr.hasNextLine())
               {
                   
                   for(int i =0; i<16; i++)
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
               this.customerId = n.intValue() +1;
               Handlers.customersHandler.writeToFile(n.intValue()+1);
               System.out.println(n.intValue()+1);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public boolean login(String username, String password)
    {
         try{
                Scanner fr = new Scanner(new File(FilePaths.customerFile));
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
                            this.customerId = i.intValue(); 
                            for(int j =0;j<13;j++)
                            {
                                line = fr.nextLine();
                            }
                            Boolean b = new Boolean(line);
                            this.status = b.booleanValue();
                            this.loggedSuccesfully = true;
                            this.getStatusOfUser();
                            if(isNew)
                            {
                                this.oneTimeInfo();         // Execute this only if the customer is new, go to file get his status
                            }else
                            {
                                System.out.println("Logged in Succesfully");
                            }
                            fr.close();
                            return true;
                        }else
                        {
                            for(int i =0;i<13; i++)
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
    
    private void fillInfo(String name, int age, String nationalId, String mobileNumber, Contract contract, int meterCode)
    {
        if(isNew == true && status == false)
        {
            
            Scanner fr;
            ArrayList<String> list = new ArrayList<>();
            try
            {
                fr = new Scanner(new File(FilePaths.customerFile));
                while(fr.hasNextLine())     //get the full content of the file
                {
                   list.add(fr.nextLine());
                }
                fr.close();
                int index = list.indexOf(this.customerId +"");

                if(index != -1)
                {
                        list.set(++index,name);
                        list.set(++index,age + "");
                        list.set(++index,nationalId);
                        list.set(++index,mobileNumber);
                        list.set(++index,"false");
                        list.set(++index,contract.isCommercialOrNot()+"");
                        list.set(++index,contract.getCity());
                        list.set(++index,contract.getRegion());
                        list.set(++index,contract.getStreetName());
                        list.set(++index,contract.getBuildingNumber()+"");
                        list.set(++index,contract.getApartmentNumber()+"");
                        list.set(++index,meterCode+"");
                        list.set(++index,status + "");
                }
                try
             {
                FileWriter fw = new FileWriter(new File(FilePaths.customerFile),false); //write the new data to the file
                for(String data: list)
                {
                    fw.append(data + "\n");
                }

                fw.close();

            }
           catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            }catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            attachContract(contract);
        }
        
        
    }

    private void attachContract(Contract contract) {
        this.contract = contract;
        isNew = false;
    }
    
    
    
    public void payBill(int index1, int index2)
    {
        System.out.println("Status " + this.status );
        if(status == false)
        {
            
                ArrayList<String> billsList = Handlers.billsHandler.insertFileIntoList();
                ArrayList<String> paymentsList = Handlers.paymentsHandler.insertFileIntoList();
                
                
                if(billsList.size()>9)        //bills file is not empty
                {
                    Double d = new Double(billsList.get(0));
                    billsList.set(0, d.doubleValue()+new Double(billsList.get(index1 +1)).doubleValue()+"");
                    paymentsList.set(index2 + 4, "true");
                    billsList.set(index1 + 4,"true");
                   
                }else
                {
                    billsList.set(0, new Double(billsList.get(0)) + new Double(billsList.get(4)) +"");
                    billsList.set(7, "true");
                    paymentsList.set(6, "true");
                }
                
                    Handlers.billsHandler.updateFile(billsList);
                    Handlers.paymentsHandler.updateFile(paymentsList);
                    
                    System.out.println("Bill Payed Successfully");
                    
                   
                    return;
            
            
            
        }
        System.out.println("This user subscription is cancelled");
        
    }
    
    public void complain(String text)
    {
        Handlers.complainsHandler.createFile();
        Handlers.complainsHandler.writeToFile(text);
    }
    
    public void enterReadingOfMeter(int reading)
    {
        if(isNew == false && status == false)
        {
            DecimalFormat df = new DecimalFormat("0.00");
            String region="port said";
            this.meterCode = reading;
            
            ArrayList <String> list = Handlers.customersHandler.insertFileIntoList();
            int index = list.indexOf(this.customerId+"");
            index += 8;
            region = list.get(index);
            index+=4;
            list.set(index, meterCode+"");
                
            Handlers.customersHandler.updateFile(list);
                
            
            double amount = 100+(int)(Math.random()*1000);
            Double d = new Double(df.format(amount));
            amount = d.doubleValue();
            int index1 = 0, index2 = 0;
            
            Bill bill = new Bill(customerId, region, amount, meterCode, LocalDateTime.now());
            Payment payment = new Payment(region, bill.getId(), this.customerId, meterCode, amount, LocalDateTime.now());
                
            ArrayList<String> billsList = Handlers.billsHandler.insertFileIntoList();
            ArrayList<String> paymentsList = Handlers.paymentsHandler.insertFileIntoList();
               
            index1 = billsList.lastIndexOf(this.customerId+"");
            index2 = paymentsList.lastIndexOf(this.customerId+"");
            System.out.println(index1);
            System.out.println(index2);
            this.payBill(index1, index2);
            return; 
        }
        System.out.println("This customer subscription is cancelled");
    }
    
    public int getCustomerId()
    {
        return customerId;
    }
}