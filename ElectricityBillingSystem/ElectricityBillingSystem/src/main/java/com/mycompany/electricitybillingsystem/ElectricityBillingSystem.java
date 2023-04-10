/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.electricitybillingsystem;

/**
 *
 * @author MAZEN
 */
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import myClasses.*;
public class ElectricityBillingSystem {

    public static void main(String[] args) {

            displayMenu();

    }
    
    
    
    public static void displayMenu()
    {
        Scanner input = new Scanner(System.in);
        char choice = ' ';
        Admin a;
        Operator o;
        Customer c;
        String username,password,region = null, com , whatToChange  , replacement, str  ;
        
        while(choice != 'Q')
        {
            System.out.println("Enter A to enter as Admin");
            System.out.println("Enter O to enter as Operator");
            System.out.println("Enter C to enter as Customer");
            System.out.println("Enter Q to terminate the program");
            
            str =input.nextLine();
            
            if(str.equals(""))
            {
                System.out.println("Empty input");
                continue;
            }
            choice = str.toUpperCase().charAt(0);    
            if(choice == 'A')
            {
                Handlers.adminsHandler.createFile();
                a = new Admin();
                while(choice != 'M')
                {
                    
                    
                    if(!a.isLoggedInSuccessfully())
                    {
                       System.out.print("Enter your username: ");
                       username = input.nextLine();
                       System.out.print("Enter your password: ");
                       password = input.nextLine(); 
                       a.login(username.trim(), password.trim());
                    }
                    

                    if(a.isLoggedInSuccessfully())
                    {
                        System.out.println("===========AVAILABLE FUNCTIONALITY================");
                        System.out.println("Enter 1 to - viewAllBills() ");
                        System.out.println("Enter 2 to - viewTotalCollected() ");
                        System.out.println("Enter 3 to - addUser() ");
                        System.out.println("Enter 4 to - updateUser() ");
                        System.out.println("Enter 5 to - deleteUser() ");
                        System.out.println("Enter 6 to - makeStatisticsForSpecificRegion() ");
                        System.out.println("Enter M to - return to main menu");

                        
                        str =input.nextLine();
            
                        if(str.equals(""))
                        {
                            System.out.println("Empty input");
                            continue;
                        }
                        choice = str.charAt(0);

                        if(choice == '1')
                        {
                            System.out.print("Enter the region you want to view its bills: ");
                            region = input.nextLine();
                            a.viewBills(region);
                        }else if(choice == '2')
                        {
                            if(a.viewTotalCollected().equals("File not opened"))
                                System.out.println("Total Collected : " + a.viewTotalCollected());

                            System.out.println(a.viewTotalCollected());
                        }else if(choice == '3')
                        {
                            System.out.print("Enter C to add Customer , Enter O to add Operator: ");
                            
                            str =input.nextLine();
            
                            if(str.equals(""))
                            {
                                System.out.println("Empty input");
                                continue;
                            }
                            choice = str.toUpperCase().charAt(0);

                            switch(choice)
                            {
                                case 'C' -> a.addCustomer();
                                case 'O' -> a.addOperator();
                                default -> System.out.println("Invalid Input");
                            }
                        }else if(choice == '4')
                        {
                            System.out.print("Enter C to update Customer , Enter O to update Operator: ");
                            choice = input.nextLine().toUpperCase().charAt(0);

                            if(choice == 'C')
                            {
                                System.out.println("====Type one of the following words to update in the Customer====");
                                System.out.println("USERNAME -- PASS -- AGE -- MOBILE -- CITY -- REGION -- STREET -- BUILDING -- APARTMENT");
                                whatToChange = input.nextLine().toUpperCase();
                                System.out.print("Enter the new value: ");
                                replacement = input.nextLine();
                                System.out.print("Enter the id of user you want to update: ");
                                String id = input.nextLine();

                                a.updateCustomer(id, whatToChange, replacement);

                            }else if(choice == 'O')
                            {
                                System.out.println("====Type one of the following words to update in the Operator====");
                                System.out.println("USERNAME -- PASS -- SALARY -- NATIONALID -- WORKINGREGION");
                                whatToChange = input.nextLine();
                                System.out.print("Enter the new value: ");
                                replacement = input.nextLine();
                                System.out.print("Enter the id of user you want to update: ");
                                String id = input.nextLine();

                                a.updateOperator(id, whatToChange, replacement);
                            }else
                            {
                                System.out.println("Invalid Input");
                            }

                        }else if(choice == '5')
                        {
                            System.out.print("Enter C to delete Customer , Enter O to delete Operator: ");
                            
                            str =input.nextLine();
            
                            if(str.equals(""))
                            {
                                System.out.println("Empty input");
                                continue;
                            }
                            choice = str.toUpperCase().charAt(0);

                            System.out.print("Enter the id of user you want to delete: ");
                            String id = input.nextLine();

                            if(choice == 'C')
                            {
                                a.deleteCustomer(id);
                            }else if(choice == 'O')
                            {
                                a.deleteOperator(id);
                            }else
                            {
                                System.out.println("Invalid Input");
                            }
                        }else if(choice == '6')
                        {
                            System.out.print("Enter region: ");
                            region = input.nextLine();
                            double d = a.makeStatisticsForRegion(region);
                            if(d != 0.0)
                            {
                                System.out.println("The Average amount for region " + region + " is : " + a.makeStatisticsForRegion(region));
                            }
                            
                        }else if(choice == 'M' || choice == 'm')
                        {
                            break;
                        }else
                        {
                            System.out.println("Invalid Input");
                            continue;
                        }

                    }else
                    {
                        continue;
                    }


                }
                
            }
            else if(choice == 'O')
            {
                Handlers.operatorsHandler.createFile();
                
                if(Handlers.operatorsHandler.isEmpty())
                {
                    System.out.println("Can not login, no accounts saved inside the file!");
                    continue;
                }
                
                
                o = new Operator();
                
                while(choice != 'M')
                {
                    if(!o.isLoggedInSuccessfully())
                    {
                            System.out.print("Enter your username: ");
                            username = input.nextLine();
                            System.out.print("Enter your password: ");
                            password = input.nextLine();
                            o.login(username.trim(), password.trim());
                    }
                    if(o.isLoggedInSuccessfully())
                    {
                        System.out.println("===========AVAILABLE FUNCTIONALITY================");
                        System.out.println("Enter 1 to - collectPaymentsAndPrintBill() ");
                        System.out.println("Enter 2 to - viewBills() ");
                        System.out.println("Enter 3 to - cancelSubscribtionForACustomer() ");
                        System.out.println("Enter M to - return to main menu");

                        str =input.nextLine();
            
                        if(str.equals(""))
                        {
                            System.out.println("Empty input");
                            continue;
                        }
                        choice = str.charAt(0);

                        if(choice == '1')
                        {
                            o.collectPayments();
                        }else if(choice == '2')
                        {
                            o.viewBills();
                        }else if(choice == '3')
                        {
                            System.out.print("Enter id of the customer you want to delete subscription for: ");
                            String id = input.nextLine();
                            o.cancelSubscription(id);
                        }else if(choice == 'm' || choice == 'M')
                        {
                            break;
                        }else
                        {
                            System.out.println("Invalid Input");
                        }
                    }else
                    {
                        continue;
                    }
                }
                
            }else if(choice == 'C')
            {
                Handlers.customersHandler.createFile();
                
                if(Handlers.customersHandler.isEmpty())
                {
                    System.out.println("Can not login, no accounts saved in the file!");
                    continue;
                }
                
                c = new Customer();
                
                while(choice != 'M')
                {
                    
                    if(!c.isLoggedSuccesfully())
                    {
                        System.out.print("Enter your username: ");
                        username = input.nextLine();
                        System.out.print("Enter your password: ");
                        password = input.nextLine();
                        c.login(username.trim(), password.trim());
                    }
                    
                    if(c.isLoggedSuccesfully())
                    {
                        System.out.println("===========AVAILABLE FUNCTIONALITY================");
                        System.out.println("Enter 1 to - enterReadingOfMeter() , based on that reading a bill is automatically created and customer automatically invoke payBill()");
                        System.out.println("Enter 2 to - Complain()");
                        System.out.println("Enter M to - return to main menu");
                        
                        str =input.nextLine();
            
                        if(str.equals(""))
                        {
                            System.out.println("Empty input");
                            continue;
                        }

                        choice = str.charAt(0);

                        if(choice == '1')
                        {
                            System.out.println("Enter reading of meter");
                            String reading = input.nextLine();
                            Integer n = new Integer(reading);
                            c.enterReadingOfMeter(n.intValue());
                        }else if(choice == '2')
                        {
                            System.out.print("Enter the text you want to complain: ");
                            com = input.nextLine();

                            c.complain(com);
                        }else if(choice == 'm' || choice == 'M')
                        {
                            break;
                        }else
                        {
                            System.out.println("Invalid Input");
                        }
                    }else
                    {
                        continue;
                    }
                }
                
            }else if(choice == 'Q')
            {
                
            }else
            {
                System.out.println("Invalid Input");
                System.out.println("=========================================");
                continue;
            }
        }
        
    }
}
