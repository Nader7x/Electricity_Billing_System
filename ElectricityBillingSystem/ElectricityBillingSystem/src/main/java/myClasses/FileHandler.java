/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ali_f
 */
public class FileHandler 
{
    private String filePath;
    private File file;
    public FileHandler(String filePath)
    {
        this.filePath = filePath;
        file = new File(filePath);
        this.createFile();
    }
    
    
    public boolean createFile()
    {
       // File file = new File(filePath);
        try
            {
                if(file.createNewFile())
                    return true;
                else
                    return false;
             }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public void writeToFile(String data)
    {
         try
         {
            //File file = new File(filePath);
            FileWriter fw = new FileWriter(file,true);
            fw.append(data + "\n");
            fw.close();
            
        }
       catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void writeToFile(int data)
    {
         try
         {
            //File file = new File(filePath);
            FileWriter fw = new FileWriter(file,true);
            fw.append(data + "\n");
            fw.close();
            
        }
       catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void writeToFile(double data)
    {
         try
         {
            //File file = new File(filePath);
            FileWriter fw = new FileWriter(file,true);
            fw.append(data + "\n");
            fw.close();
            
        }
       catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
        public void writeToFile(boolean data)
    {
         try
         {
            //File file = new File(filePath);
            FileWriter fw = new FileWriter(file,true);
            fw.append(data + "\n");
            fw.close();
            
        }
       catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void changeTheTotal(double data)
    {
         try
         {
            Scanner fr = new Scanner(file);
            ArrayList <String> list = new ArrayList<>();
            while(fr.hasNextLine())
            {
                list.add(fr.nextLine());
            }
            //File file = new File(filePath);
            list.set(0,data + "");
            FileWriter fw = new FileWriter(file,false);
            for(String str: list)
            {
                fw.append(str + "\n");
            }
            fw.close();
            
        }
       catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public File getFile() {
        return file;
    }
    
    public void readFromFile()
    {
          try{
                Scanner fr = new Scanner(file);
                String name;
                while(fr.hasNextLine())
                {
                    name = fr.nextLine();
                    System.out.println("name = " + name);
                }
              
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    public boolean checkCredentals(String username, String password)
    {
         try{
                Scanner fr = new Scanner(file);
                String line;
                while(fr.hasNextLine())
                {
                    line = fr.nextLine();
                    if(line == "\n")
                        line = fr.nextLine();
                    if(line.equals(username))
                    {
                        line = fr.nextLine();
                        if(line.equals(password))
                        {
                            fr.close();
                            return true;
                        }
                    }
                }
              
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Incorrect username or password");
        return false;
    }
    
    public void clearFile()
    {
        try
        {
            String data = "";
            FileWriter fw = new FileWriter(file, false);
            fw.append(data);
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<String> insertFileIntoList()
    {
        try
         {
            ArrayList<String> list = new ArrayList<>();
            Scanner fr = new Scanner(this.file);
            while(fr.hasNextLine())
            {
                list.add(fr.nextLine());
            }
            
            fr.close();
            return list;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return new ArrayList<String>();
    }
    
    public boolean isEmpty()
    {
        try             //if there are no operators in the file, operator can not login 
        {
            Scanner fr = new Scanner(this.file);
            if(!fr.hasNextLine())
            {
                return true;
            }
            fr.close();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
       return false;
    }
    
    public void updateFile(ArrayList<String> list)
    {
        this.clearFile();
        
        for(String str : list)           //update file to be implemented
        {
           writeToFile(str);
        }
        
    }
    
}
