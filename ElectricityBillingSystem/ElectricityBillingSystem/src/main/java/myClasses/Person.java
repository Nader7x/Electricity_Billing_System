/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

/**
 *
 * @author MAZEN
 */
public abstract class Person {
    protected String username;
    protected String password;
    protected int id;
    
    public Person(){}
    
    public abstract boolean login(String username, String password);
    public void setUsername(String username){}
    public void setPassword(String password){}
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
    public int getId(){return this.id;}
}