/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.raven.component.InputForms.Add_task;
import com.raven.component.InputForms.Showtask;
import com.raven.component.Task;
import com.raven.component.form1_card;
import com.raven.model.StatusType;
import com.raven.swing.Deadline_show;
import com.raven.swing.Table;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RAVEN
 */
public class Form_1 extends javax.swing.JPanel {

    private ArrayList<Task> Task_list=new ArrayList<Task>();
    private int current_task=-1;
    public Form_1() {
        initComponents();
        
        jLabel1.setForeground(Color.white);
        
         table.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                String type = (String) value;
                // Set background color based on the value in the "Type" column
                if ("Oncoming".equals(type)) {
                    renderer.setBackground(Color.decode("#B2FBA5"));
                } else if ("Deadline passed".equals(type)) {
                    renderer.setBackground(Color.decode("#ff6242"));
                } else if("on time".equals(type)){
                    renderer.setBackground(Color.YELLOW);
                }
                return renderer;
            }
        });
        
       
    }
    
    
    
    public void removetask(Task cur_Task){
        for(int i=0;i<Task_list.size();i++){
            if(cur_Task==Task_list.get(i)){
                Task_list.remove(i);
            }
        }
        String Taskname,Desc,deadl,time;
        DefaultTableModel temptable_model=(DefaultTableModel)table.getModel();
        temptable_model.setRowCount(0);
        for(int i=0;i<Task_list.size();i++){
            Taskname=Task_list.get(i).Task_name;
            Desc=Task_list.get(i).Task_description;
            deadl=Task_list.get(i).Deadline;
            time=Task_list.get(i).time;
            deadl=deadl+" "+time;
            
            Date deadline_date=Task_list.get(i).deadline_date;
        
            LocalDateTime deadline = LocalDateTime.of(deadline_date.getYear()+1900, deadline_date.getMonth()+1, deadline_date.getDate(), deadline_date.getHours()+1, deadline_date.getMinutes()+1); // Example deadline: January 31, 2024, 12:00 PM
            LocalDateTime currentTime = LocalDateTime.now(); // Current time
        
            Duration duration = Duration.between(currentTime, deadline);

            if (duration.isNegative()) {
                time="Deadline passed";

            } else if (duration.isZero()) {
                System.out.println("You have reached the deadline.");
                time="on time";
            } else {
                time="Oncoming";
            }
            
            Object[] tempr={Taskname,Desc,deadl,time};
            temptable_model.addRow(tempr);
          
            
            
        }
    }
    
    public void addTask(Task New_Task){
        
        int indecx=Task_list.size()-1;
        DefaultTableModel temptable_model=(DefaultTableModel)table.getModel();
        temptable_model.setRowCount(0);
        boolean task_added=false;
        String Taskname,Desc,deadl,time;
        if(Task_list.size()==0){
            Task_list.add(New_Task);
            Taskname=New_Task.Task_name;
            Desc=New_Task.Task_description;
            deadl=New_Task.Deadline;
            time=New_Task.time;
            deadl=deadl+" "+time;
            
            Date deadline_date=New_Task.deadline_date;
        
            LocalDateTime deadline = LocalDateTime.of(deadline_date.getYear()+1900, deadline_date.getMonth()+1, deadline_date.getDate(), deadline_date.getHours()+1, deadline_date.getMinutes()+1); // Example deadline: January 31, 2024, 12:00 PM
            LocalDateTime currentTime = LocalDateTime.now(); // Current time
        
        Duration duration = Duration.between(currentTime, deadline);
            
        if (duration.isNegative()) {
            time="Deadline passed";
            
        } else if (duration.isZero()) {
            System.out.println("You have reached the deadline.");
            time="on time";
        } else {
            time="Oncoming";
        }
        Object[] tempr={Taskname,Desc,deadl,time};
       
            temptable_model.addRow(tempr);
           
            
            System.out.println("first row added");
            return;
            
        
        }
        for(int i=0;i<Task_list.size();i++){
            
            if(Task_list.get(i).deadline_date.getTime()>New_Task.deadline_date.getTime()){
                Task_list.add(i, New_Task);
                task_added=true;
                System.out.println("out with index");
                break;
               
                
            }
            
        }
        if(!task_added){
            Task_list.add(New_Task);
        }
        for(int i=0;i<Task_list.size();i++){
            Taskname=Task_list.get(i).Task_name;
            Desc=Task_list.get(i).Task_description;
            deadl=Task_list.get(i).Deadline;
            time=Task_list.get(i).time;
            deadl=deadl+" "+time;
            
            Date deadline_date=Task_list.get(i).deadline_date;
            LocalDateTime deadline = LocalDateTime.of(deadline_date.getYear()+1900, deadline_date.getMonth()+1, deadline_date.getDate(), deadline_date.getHours(), deadline_date.getMinutes()); // Example deadline: January 31, 2024, 12:00 PM
            LocalDateTime currentTime = LocalDateTime.now(); // Current time
            System.out.println("Year: "+(deadline_date.getYear()+1900)+" month: "+(deadline_date.getMonth()+1)+" "+(deadline_date.getDate())+(deadline_date.getHours())+" mins "+(deadline_date.getMinutes()));
        
            Duration duration = Duration.between(currentTime, deadline);

            if (duration.isNegative()) {
                time="Deadline passed";

            } else if (duration.isZero()) {
                System.out.println("You have reached the deadline.");
                time="on time";
            } else {
                time="Oncoming";
            }
            
            Object[] tempr={Taskname,Desc,deadl,time};
            temptable_model.addRow(tempr);
          
            
            
        }
        
        
    }
    
    public void refresh(){
        this.form1_card2.refresh_status(this.Task_list);
        DefaultTableModel temptable_model=(DefaultTableModel)table.getModel();
        temptable_model.setRowCount(0);
        String Taskname,Desc,deadl,time;
        for(int i=0;i<Task_list.size();i++){
            Taskname=Task_list.get(i).Task_name;
            Desc=Task_list.get(i).Task_description;
            deadl=Task_list.get(i).Deadline;
            time=Task_list.get(i).time;
            deadl=deadl+" "+time;
            
            Date deadline_date=Task_list.get(i).deadline_date;
        
            LocalDateTime deadline = LocalDateTime.of(deadline_date.getYear()+1900, deadline_date.getMonth()+1, deadline_date.getDate(), deadline_date.getHours(), deadline_date.getMinutes()); // Example deadline: January 31, 2024, 12:00 PM
            LocalDateTime currentTime = LocalDateTime.now(); // Current time
        
            Duration duration = Duration.between(currentTime, deadline);

            if (duration.isNegative()) {
                time="Deadline passed";

            } else if (duration.isZero()) {
                System.out.println("You have reached the deadline.");
                time="on time";
            } else {
                time="Oncoming";
            }
            
            Object[] tempr={Taskname,Desc,deadl,time};
            temptable_model.addRow(tempr);
          
            
            
        }
    }
    
    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#2C3584"), getWidth(), getHeight(), Color.decode("#A74292"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    public Form_1(form1_card form1_card2, JButton jButton1, JDialog jDialog1, JDialog jDialog2, JLabel jLabel1, JScrollPane jScrollPane1, JTable table) {
        this.form1_card2 = form1_card2;
        this.jButton1 = jButton1;
        this.jDialog1 = jDialog1;
        this.jDialog2 = jDialog2;
        this.jLabel1 = jLabel1;
        this.jScrollPane1 = jScrollPane1;
        this.table = table;
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        form1_card2 = new com.raven.component.form1_card();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Task Manager");
        jLabel1.setToolTipText("");

        form1_card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                form1_card2MouseClicked(evt);
            }
        });

        jButton1.setText("Add Task");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Task ", "Description", "Deadline", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setOpaque(false);
        table.setRowHeight(20);
        table.setSelectionBackground(new java.awt.Color(31, 87, 129));
        table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        table.setShowVerticalLines(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form1_card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(539, 539, 539)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(form1_card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        JFrame tempFrame=new JFrame();
        Add_task newtask_add=new Add_task(tempFrame, true, this);
        newtask_add.setVisible(true);
 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
       
        int row=this.table.getSelectedRow();
        JFrame tempframe=new JFrame();
        Showtask selected_task=new Showtask(tempframe, true,Task_list.get(row), this);
        selected_task.setVisible(true);
        
    }//GEN-LAST:event_tableMouseClicked

    private void form1_card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_form1_card2MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_form1_card2MouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.form1_card form1_card2;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
