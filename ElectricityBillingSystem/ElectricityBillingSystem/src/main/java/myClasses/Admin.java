/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

/**
 *
 * @author MAZEN
 */
public class Admin extends Person{
    public Admin(){}

    @Override
    public boolean login(String username, String password)
    {
        return true;
    }
    
    public void viewBills(String region)
    {
        //search inside bills file for all the bills with this specific region
        //print each one on its own
    }
    
    public String viewTotalCollected()
    {
        //get the total value from Bills file and print it
        return "";
    }
    
    public Customer addCustomer()
    {
        Customer c = new Customer();
        return c;
    }
    
    public Operator addOperator()
    {
        Operator o = new Operator();
        return o;
    }
    
    public void updateCustomer(int customerId, String whatToChange, String replacement)
    {
        //search inside customers file for this specific id 
    }
    
    public void updateOperator(int operatorId, String whatToChange, String replacement)
    {
        //search inside operator file for this specific id and change the whatTochange
    }
    
    public void deleteCustomer(int customerId)
    {
        
    }
    
    public void deleteOperator(int operatorId)
    {
        
    }
    
    public double makeStatisticsForRegion(String region)
    {
        return 0.0;
    }
}
