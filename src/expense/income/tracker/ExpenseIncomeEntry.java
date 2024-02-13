/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expense.income.tracker;

/**
 *
 * @author Dishmi
 */
public class ExpenseIncomeEntry {
    private String date;
    private String description;
    private double amount;
    private String type;
    
    public ExpenseIncomeEntry(String date, String description, double amount, String type)
    {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }
    
    public String getDate(){ return date; }
    public String getDescription(){ return description; }
    public double getAmount(){ return amount; }
    public String getType(){ return type; }
}