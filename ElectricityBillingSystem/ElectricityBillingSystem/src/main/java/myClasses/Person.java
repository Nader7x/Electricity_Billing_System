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
    
    public Person(){}
    
    public abstract boolean login(String username, String password);

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
}