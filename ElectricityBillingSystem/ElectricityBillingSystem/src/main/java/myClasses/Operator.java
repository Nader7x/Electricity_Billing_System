/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

/**
 *
 * @author MAZEN
 */
public class Operator extends Person{
    private int salary;
    private String nationalId;
    private String workingRegion;
    
    protected Operator(){}

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
    
    @Override
    public boolean login(String username, String password)
    {
        return true;
    }
    
    public static void collectPayments(Payment payment)
    {
        
        printBill(payment.getBillId());
    }
    
    public static void printBill(int meterCode)
    {
        //search for the bill inside the file using the id and metercode 
        //change the boolean payed from false to true
        //print the bill for the user
    }
    
    public void viewBills(){
        //search inside bills file for all the bills with this.workingRegion
        //print each one on its own
    }
    
    public static void cancelSubscription(int uid)
    {
        //search for the customer inside Customers file 
        // change the status from false to true
    }
    
}
