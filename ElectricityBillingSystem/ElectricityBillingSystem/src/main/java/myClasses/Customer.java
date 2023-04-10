/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

/**
 *
 * @author MAZEN
 */
public class Customer extends Person{
    private String name;
    private int age;
    private String nationalId;
    private String mobileNumber;
    private boolean isNew = true;
    //private Contract contract;
    private int meterCode;
    private boolean status = false;     //Cancelled(true) or not(false)
            
    protected Customer(){}

    @Override
    public boolean login(String username, String password)
    {
        return true;
    }
    
    public void fillInfo(String name, int age, String nationalId, String mobileNumber)
    {
        if(isNew == true && status == false)
        {
            
        }
    }
    
    public void attachContract()    //until contract class
    {   
        
    }
    
    public boolean payBill(Payment payment)
    {
        if(isNew == false && status == false)
        {
            Operator.collectPayments(payment);
            return true;
        }
        return false;
    }
    
    public void complain(String text){}
    
    public void enterReadingOfMeter(int reading)
    {
        if(isNew == false && status == false)
        {
            this.meterCode = reading;
            //create a bill object with this new metercode and save it inside bills file
        }
    }
    
}
