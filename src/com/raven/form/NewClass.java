/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.form;

import java.util.Date;

/**
 *
 * @author Daham Tharinda
 */
public class NewClass {
    
     private final int id;
    private final Date addDate;
    private final String description;
    private final String Choice;
    
    public NewClass(int pid,Date pAddDate, String pname,  String choice)
    {
        this.id = pid;
        this.description = pname;
        this.addDate = pAddDate;
        this.Choice = choice;
    }
    
    public int getId()
     {
         return id;
     }
    
    
    
    public Date getAddDate()
    {
        return addDate;
    }
      
    public String getName()
    {
        return description;
    }
   
    
    public String getType()
    {
       return Choice;
    }
    
}
