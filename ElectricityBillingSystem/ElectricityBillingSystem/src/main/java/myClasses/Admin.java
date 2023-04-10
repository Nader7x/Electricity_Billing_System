/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MAZEN
 */
public class Admin extends Person{
    private static int count = 110;
    private int id;
    private boolean loggedInSuccessfully;
    public Admin(){}
    

    @Override
    public boolean login(String username, String password)
    {
        FileHandler fh = new FileHandler(FilePaths.adminFile);
        loggedInSuccessfully = fh.checkCredentals(username, password);
        return loggedInSuccessfully;
    }

    public boolean isLoggedInSuccessfully() {
        return loggedInSuccessfully;
    }
    
    public void viewBills(String region)
    {
        try
        {
            Scanner fr = new Scanner(new File(FilePaths.billsFile));
            String city;
            city = fr.nextLine();
            while(fr.hasNextLine())
            {
                city = fr.nextLine();
                if(city.equals(region))
                {
                    for(int i = 0;i<6;i++){
                        System.out.println(city);
                        city = fr.nextLine();
                    }
                }else{
                    for(int i = 0; i<6; i++){
                        if(!fr.hasNextLine())
                            break;
                        city = fr.nextLine();
                    }
                }
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        //search inside bills file for all the bills with this specific region
        //print each one on its own
    }
    
    public String viewTotalCollected()
    {
        try
        {
            Scanner fr = new Scanner(new File(FilePaths.billsFile));
            String data = fr.nextLine();
            fr.close();
            return data;
        }catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        return "File not opened";
    }
    
    public void addCustomer()
    {
        Scanner input = new Scanner(System.in);
        String username, password;
        boolean fileIsEmpty = false;
        
        System.out.print("Enter the username of the customer: ");
        username = input.nextLine();
        System.out.print("Enter the password of the customer: ");
        password = input.nextLine();
        
        Customer c = new Customer("");
        c.setUsername(username);
        c.setPassword(password);
        
        Handlers.customersHandler.createFile();
        try
        {
            Scanner fr = new Scanner(new File(FilePaths.customerFile));
            if(!fr.hasNextLine())
                fileIsEmpty = true;
            Handlers.customersHandler.writeToFile(username);
            Handlers.customersHandler.writeToFile(password);
            c.setId(fileIsEmpty);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        for(int i =0;i<13;i++)
        {
            if(i == 4)
            {
                Handlers.customersHandler.writeToFile("true"); 
                continue;
            }
            if(i == 12)
            {
                Handlers.customersHandler.writeToFile("false");
                continue;
            }
            Handlers.customersHandler.writeToFile("null");
        }
        
    }
    
    public void addOperator()
    {
        Scanner input = new Scanner(System.in);
        String username, password, nationalId, workingRegion;
         int salary =0;
         int flag=0;
       
        boolean fileIsEmpty = false;
        
        System.out.print("Enter the username of the operator: ");
        username = input.nextLine();
        System.out.print("Enter the password of the operator: ");
        password = input.nextLine();
        System.out.print("Enter the National ID of the operator: ");
        nationalId = input.nextLine();
        
        System.out.print("Enter the Working Region of the operator: ");
        workingRegion = input.nextLine();
        
        System.out.print("Enter the Salary of the operator: ");
        try{
        salary = input.nextInt();}
        catch(Exception e){
        System.out.println("adding failed ,please enter the salary all numbers");
        flag++;
        }
        if(flag==0)
        {
        Operator c = new Operator("");
        c.setUsername(username);
        c.setPassword(password);
        
        Handlers.operatorsHandler.createFile();
        try
        {
            Scanner fr = new Scanner(new File(FilePaths.operatorsFile));
            if(!fr.hasNextLine())
                fileIsEmpty = true;
            
            Handlers.operatorsHandler.writeToFile(username);
            Handlers.operatorsHandler.writeToFile(password);
            c.setId(fileIsEmpty);       //set and write in the file
            
            
            Handlers.operatorsHandler.writeToFile(salary);
            Handlers.operatorsHandler.writeToFile(nationalId);
            Handlers.operatorsHandler.writeToFile(workingRegion);
            
            
            c.setSalary(salary);
            c.setNationalId(nationalId);
            c.setWorkingRegion(workingRegion);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        }
    }
    
    public void updateCustomer(String customerId, String whatToChange, String replacement)
    {
        //search inside customers file for this specific id 
        ArrayList<String> list = Handlers.customersHandler.insertFileIntoList();
        int index;
            
        index = list.indexOf(customerId);
            
        if(index != -1)
        {
                
            whatToChange = whatToChange.toUpperCase();
            if (whatToChange.equals("USERNAME"))
            {
                 list.set(index - 2, replacement);
                    
            }else if (whatToChange.equals("PASS"))
            {
                list.set(index - 1, replacement);
                    
            }else if (whatToChange.equals("AGE"))
            {
                list.set(index + 2, replacement);
                    
            }else if (whatToChange.equals("MOBILE"))
            {
                list.set(index + 4, replacement);
                    
            }else if (whatToChange.equals("CITY"))
            {
                list.set(index + 7, replacement);
                    
            }else if (whatToChange.equals("REGION"))
            {
                list.set(index + 8, replacement);
                  
            }else if (whatToChange.equals("STREET"))
            {
                list.set(index + 9, replacement);
                    
            }else if (whatToChange.equals("BUILDING"))
            {
                list.set(index + 10, replacement);
                    
            }else if (whatToChange.equals("APARTMENT"))
            {
                list.set(index + 11, replacement);
            }else
            {
                System.out.println("Can not update " + whatToChange + " Because it is invalid input");
                return;
            }
 
            Handlers.customersHandler.clearFile();
                
            for(String str : list)      //update file to be implemented
            {
                Handlers.customersHandler.writeToFile(str);
            }
                
        }else
        {
            System.out.println("There is no Id of number " + customerId);
            return;
        }
            
    }
    
    public void updateOperator(String operatorId, String whatToChange, String replacement)
    {
        //search inside operator file for this specific id and change the whatTochange
        ArrayList<String> list = Handlers.operatorsHandler.insertFileIntoList();
        int index;

        index = list.indexOf(operatorId);
            
        if(index != -1)
        {
            whatToChange = whatToChange.toUpperCase();
            if (whatToChange.equals("USERNAME"))
            {
                list.set(index - 2, replacement);
            }else if (whatToChange.equals("PASS"))
            {
                list.set(index - 1, replacement);
            }else if (whatToChange.equals("SALARY"))
            {
                list.set(index + 1, replacement);
                    
            }else if (whatToChange.equals("NATIONALID"))
            {
                list.set(index + 2, replacement);
                    
            }else if (whatToChange.equals("WORKINGREGION"))
            {
                list.set(index + 3, replacement);
                    
            }else
            {
                System.out.println("Can not update " + whatToChange + " Because it is invalid input");
                return;
            }
                
            FileHandler fh = new FileHandler(FilePaths.operatorsFile);
            fh.clearFile();
                
            for(String str : list)
            {
                fh.writeToFile(str);
            }
                
        }else
        {
            System.out.println("There is no Id of number " + operatorId);
            return;
        }
    }
    
    public void deleteCustomer(String customerId)
    {
        ArrayList<String> list = Handlers.customersHandler.insertFileIntoList();
        if(list.isEmpty() || list.size() == 1)       //if file is empty
        {
            System.out.println("File is EMPTY, can not delete customers");
        }else
        {
           int index = list.indexOf(customerId);
//           System.out.println(index);
           if(index == -1)  //did not found the id in the file
           {
               System.out.println("Did not find customer with id " + customerId + " in the file");
               
           }else
           {
               for(int i =index-2; i<index+14; i++)
                {
                    list.remove(index-2);
                }
               
                Handlers.customersHandler.updateFile(list);
           }
               
           System.out.println("Successfully deleted customer with id: " + customerId);
        }
        
        //delete the contract from contracts file
        list = Handlers.contractsHandler.insertFileIntoList();
        FileHandler fh5  = new FileHandler(FilePaths.contractFile);
            
        int index = list.indexOf(customerId);
        try{   
           for(int i = index; i<index+3;i++)
            {
           
                 list.remove(index);
           
            
            } 
        }  
        catch(Exception e )
            { 
                System.out.println("this customer don't have contract");
            }
        Handlers.contractsHandler.updateFile(list);
        
    }
    
    public void deleteOperator(String operatorId)
    {
        
        ArrayList<String> list = Handlers.operatorsHandler.insertFileIntoList();
            
        if(list.isEmpty() || list.size() ==1)       //if file is empty
        {
            System.out.println("File is EMPTY, can not delete operators");
        }else
        {
           int index = list.indexOf(operatorId);
           if(index == -1)  //did not found the id in the file
           {
               System.out.println("Did not find operator with id " + operatorId + " in the file");
               return;
           }else
           {
                for(int i =index -2; i<index+4; i++)
                {
                    list.remove(index-2);
                }
               
                Handlers.operatorsHandler.updateFile(list);
           }
           
           System.out.println("Successfully deleted operator with id: " + operatorId);
        }
    }
    
    public double makeStatisticsForRegion(String region)
    {
        String line ="";
        double total =0, average = 0;
        int count =0;
        Double d = null;
        try
        {
            Scanner fr = new Scanner(new File(FilePaths.billsFile));
            
            while(fr.hasNextLine())
            {
                line = fr.nextLine();
                
                if(line.equals(region))
                {
                    count++;
                    for(int i =0;i<3;i++)
                        line = fr.nextLine();
                    d = new Double(line);
                    total += d.doubleValue();
                    
                }
            }
            fr.close();
            
            if(count == 0)
            {
                System.out.println("There are no bills in " + region + " region");
            }else
            {
                average = total/count;
            }
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return average;
    }

    
}