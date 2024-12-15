/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
/**
 *
 * @author RAVEN
 */
public class Form_5 extends javax.swing.JPanel {
    
    private JLabel[] dayLabels;
    private JTextArea[] dayTasks;
    private JButton[] plusButtons;
    private JButton saveButton;
    private JButton clearButton;
    
    private static final String TASKS_FILE = "tasks.txt";
    
    public Form_5() {
        initComponents();
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(1, 7));
        //mainPanel.setBackground(Color.MAGENTA);

        dayLabels = new JLabel[7];
        dayTasks = new JTextArea[7];
        plusButtons = new JButton[7];

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        Color[] dayColors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA};

        for (int i = 0; i < 7; i++) {
            JPanel dayPanel = new JPanel(new BorderLayout());
            dayPanel.setBackground(dayColors[i]);

            dayLabels[i] = new JLabel(daysOfWeek[i]);
            dayLabels[i].setFont(new Font("Arial", Font.BOLD, 16));
            dayLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            dayLabels[i].setOpaque(true);
            dayLabels[i].setBackground(Color.CYAN);//(new Color(220, 220, 220)); // Light Gray

            dayTasks[i] = new JTextArea();
            dayTasks[i].setFont(new Font("Arial", Font.PLAIN, 14));
            dayTasks[i].setLineWrap(true);
            dayTasks[i].setWrapStyleWord(true);
            dayTasks[i].setPreferredSize(new Dimension(300, 150)); // Increase size
            JScrollPane scrollPane = new JScrollPane(dayTasks[i]);

            plusButtons[i] = new JButton("+");
            plusButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            plusButtons[i].setPreferredSize(new Dimension(50, 50));
            plusButtons[i].addActionListener(new PlusButtonActionListener(i));

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(plusButtons[i]);

            dayPanel.add(dayLabels[i], BorderLayout.NORTH);
            dayPanel.add(scrollPane, BorderLayout.CENTER);
            dayPanel.add(buttonPanel, BorderLayout.SOUTH);

            mainPanel.add(dayPanel);
        }

        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));
        saveButton.setPreferredSize(new Dimension(100, 30));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTasks();
            }
        });
        
        clearButton = new JButton("Clear All");
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.setPreferredSize(new Dimension(100, 30));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAllEntries();
            }
        });
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        loadTasks();

        //pack();
    }
    
    private void saveTasks() {
    try (PrintWriter writer = new PrintWriter(new FileWriter(TASKS_FILE))) {
        for (int i = 0; i < 7; i++) {
            String tasks = dayTasks[i].getText();
            writer.println(tasks.replace("\n", ";")); // Replace newline with delimiter
        }
        JOptionPane.showMessageDialog(this, "Tasks saved successfully!");
    } catch (IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error saving tasks!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void loadTasks() {
    try (BufferedReader reader = new BufferedReader(new FileReader(TASKS_FILE))) {
        for (int i = 0; i < 7; i++) {
            String line = reader.readLine();
            if (line != null) {
                dayTasks[i].setText(line.replace(";", "\n")); // Replace delimiter with newline
            }
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
    
    private void clearAllEntries() {
        for (int i = 0; i < 7; i++) {
            dayTasks[i].setText("");
        }
    }
    
    /**
     * Creates new form Form_1
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_5().setVisible(true);
            }
        });
    }
    
    private class PlusButtonActionListener implements ActionListener {
        private int index;
        //private int taskCounter = 0;

        public PlusButtonActionListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Add new task for the selected day
            String currentTasks = dayTasks[index].getText();
            String newTask = JOptionPane.showInputDialog(Form_5.this, "Enter your Plan:", "Plan the Day", JOptionPane.PLAIN_MESSAGE);
            if (newTask != null && !newTask.isEmpty()) {
                if (!currentTasks.isEmpty()) {
                    currentTasks += "\n\n";
                }
                //int taskNumber = currentTasks.split("\n").length + 1;
                //taskCounter++;
                currentTasks +=/* taskCounter + ". " + */newTask;
                dayTasks[index].setText(currentTasks);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 849, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
