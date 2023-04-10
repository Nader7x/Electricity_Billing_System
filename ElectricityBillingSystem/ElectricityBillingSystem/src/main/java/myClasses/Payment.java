/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

/**
 *
 * @author MAZEN
 */
public class Payment {
    private int billId;
    //private Date date;
    private int amount;

    public Payment(int billId, int amount, int meterCode) {
        this.billId = billId;
        this.amount = amount;
    }

    public int getBillId() {
        return billId;
    }

    public int getAmount() {
        return amount;
    }

    
    
}
