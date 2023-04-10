/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MAZEN
 */
public class Payment {
    private String region;
    private int billId;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private double amount;
    private boolean paid;

    public Payment(String region, int billId, int customerId, int meterCode, double amount, LocalDateTime now) {
        Handlers.paymentsHandler.createFile();
        
        Handlers.paymentsHandler.writeToFile(region);
        Handlers.paymentsHandler.writeToFile(billId);
        Handlers.paymentsHandler.writeToFile(customerId);
        Handlers.paymentsHandler.writeToFile(meterCode);
        Handlers.paymentsHandler.writeToFile(amount);
        Handlers.paymentsHandler.writeToFile(dtf.format(now));
        Handlers.paymentsHandler.writeToFile(false);
        
        this.region = region;
        this.billId = billId;
        this.amount = amount;
        this.paid = false;
    }

    public String getRegion()
    {
        return region;
    }

    public boolean isPaid() 
    {
        return paid;
    }

    public int getBillId() 
    {
        return billId;
    }

    public double getAmount() 
    {
        return amount;
    }

    
    
}
