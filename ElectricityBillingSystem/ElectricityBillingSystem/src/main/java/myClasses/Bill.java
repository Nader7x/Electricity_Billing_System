/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

/**
 *
 * @author MAZEN
 */
public class Bill {
    private int id;
    private int customerId;
    private static double total;
    private String region;
    private int amount;
    //private Date date;
    private int meterCode;
    private boolean paidOrNot;

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

    public int getAmount() 
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
        return id;
    }
    
    
}
