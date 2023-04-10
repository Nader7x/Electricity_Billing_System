/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

/**
 *
 * @author MAZEN
 */
public class Handlers {
    public static final FileHandler billsHandler = new FileHandler(FilePaths.billsFile);
    public static final FileHandler customersHandler = new FileHandler(FilePaths.customerFile);
    public static final FileHandler operatorsHandler = new FileHandler(FilePaths.operatorsFile);
    public static final FileHandler paymentsHandler = new FileHandler(FilePaths.paymentsFile);
    public static final FileHandler contractsHandler = new FileHandler(FilePaths.contractFile);
    public static final FileHandler complainsHandler = new FileHandler(FilePaths.customerComplain);
    public static final FileHandler adminsHandler = new FileHandler(FilePaths.adminFile);
}
