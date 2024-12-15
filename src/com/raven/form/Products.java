
package com.raven.form;

import java.util.Date;


public class Products {
    
    private final int id;
    private final Date addDate;
    private final String description;
    private final float amount;
    private final String Choice;
    
    public Products(int pid,Date pAddDate, String pname,float pprice,  String choice)
    {
        this.id = pid;
        this.description = pname;
        this.amount= pprice;
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
    
    public float getPrice()
    {
        return amount;
    }
    
    public String getType()
    {
       return Choice;
    }
   
}
