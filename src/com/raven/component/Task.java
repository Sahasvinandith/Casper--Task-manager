/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.component;
//this task class is tempory class to store task variables until we developed a databease or other storing method

import java.util.Date;

/**
 *
 * @author MSI
 */
public class Task {
    public String Task_name;
    public String Task_description;
    public String Deadline;
    public String time;
    public int hour;
    public int minute;
    public Date deadline_date;
    
    
    public Task(String Task_name,String Task_description,String Deadline,String Time,Date Deadline_date,int Hour,int Minute){
        
        this.Task_name=Task_name;
        this.Task_description=Task_description;
        this.Deadline=Deadline;
        this.time=Time;
        this.deadline_date=Deadline_date;
        this.hour=Hour;
        this.minute=Minute;
        
    
    }
    
}
