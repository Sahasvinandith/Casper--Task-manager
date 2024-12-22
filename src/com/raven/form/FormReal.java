/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import javax.swing.table.TableColumn;
//import com.raven.expense.ExpenseIncomeEntry;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import com.raven.expense.ExpenseIncomeTableModel;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Daham Tharinda
 */
public class FormReal extends javax.swing.JPanel {

    private double balance;
    //private final ExpenseIncomeTableModel tableModel;
    private Connection con;
    private DefaultTableModel model;

    /**
     * Creates new form Formmmm
     */
    public FormReal(Connection con) {

        initComponents();
        this.con=con;
        //tableModel = new ExpenseIncomeTableModel();
        Show_products_In_JTable();

        try {
            balance = getTotalExpenses();
            //JOptionPane.showMessageDialog(null, "Total expenses: " + balance);
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

        BalanceBox.setText("Rs." + balance);

        if (balance < 0) {
            BalanceBox.setBackground(Color.red);
            BalanceBox.setForeground(Color.white);
        } else if (balance > 0) {
            BalanceBox.setBackground(Color.GREEN);
            BalanceBox.setForeground(Color.BLACK);
        } else {
            BalanceBox.setBackground(Color.YELLOW);
        }

        TableOne.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                String type = (String) value;
                // Set background color based on the value in the "Type" column
                if ("Expense".equals(type)) {
                    renderer.setBackground(Color.RED);
                } else if ("Income".equals(type)) {
                    renderer.setBackground(Color.GREEN);
                }
                return renderer;
            }
        });

    }

    

    private double getTotalExpenses() throws SQLException {
        double totalSum = 0;
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT SUM(amount) AS total FROM expenses");
        if (resultSet.next()) {
            totalSum = resultSet.getDouble("total");
        }
        return totalSum;
    }

    private double getTotalExpensesPeriod(Date Startdate,Date Enddate) throws SQLException {
        double total = 0;
        String sql = "SELECT SUM(amount) AS total FROM expenses WHERE date BETWEEN ? AND ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setDate(1, new java.sql.Date(Startdate.getTime()));
            ps.setDate(2, new java.sql.Date(Enddate.getTime()));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    total = rs.getDouble("total");
                }

            }
        }
        return total;
    }

    private void displayRecordsInTimePeriod(Date startDate, Date endDate) {
        try {
            // Construct the SQL query with a condition to filter records by the time period
            String sql = "SELECT * FROM expenses WHERE date BETWEEN ? AND ?";

            // Prepare the SQL statement
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                // Set the start and end dates as parameters in the SQL query
                ps.setDate(1, new java.sql.Date(startDate.getTime()));
                ps.setDate(2, new java.sql.Date(endDate.getTime()));

                // Execute the query and retrieve the filtered records
                try (ResultSet rs = ps.executeQuery()) {
                    // Create a new DefaultTableModel to hold the filtered records
                    DefaultTableModel model = new DefaultTableModel();

                    // Add columns to the model (adjust column names based on your database schema)
                    //model.addColumn("index");
                    model.addColumn("Date");
                    model.addColumn("Description");
                    model.addColumn("Amount");
                    model.addColumn("Type");
                    model.addColumn("Transcation No.");
                    // Add more columns as needed
                    TableColumn column = TableOne.getColumnModel().getColumn(4); // Assuming "Transaction No." is the first column (index 4)
                    column.setMinWidth(10);
                    column.setMaxWidth(20);

                    // Add rows to the model with the filtered records
                    while (rs.next()) {
                        // Extract data from the ResultSet and add it to the model
                        Object[] row = new Object[]{rs.getDate("date"), rs.getString("description"), Float.parseFloat(rs.getString("amount")), rs.getString("type"), rs.getInt("id")};
                        model.addRow(row);
                    }

                    // Set the model to your JTable to display the filtered records
                    TableOne.setModel(model);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching records from the database.");
        }
    }

    public boolean checkInputs() {

        if (jDateChooser1.getDate() == null || DescriptionBox.getText() == null || AmountBox.getText() == null) {
            return false;
        } else {
            try {
                Float.parseFloat(AmountBox.getText());
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }

    public ArrayList<Products> getProductList() {
        ArrayList<Products> productList = new ArrayList<Products>();
        String query = "SELECT * FROM expenses";

        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(query);
            Products product;

            while (rs.next()) {
                product = new Products(rs.getInt("id"), rs.getDate("date"), rs.getString("description"), Float.parseFloat(rs.getString("amount")), rs.getString("type"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormReal.class.getName()).log(Level.SEVERE, null, ex);
        }

        return productList;

    }

    private void clearTable() {
        DefaultTableModel model = (DefaultTableModel) TableOne.getModel();
        model.setRowCount(0); // Set the row count to 0 to remove all rows
    }

    // 2- Populate the JTable
    public void Show_products_In_JTable() {
        ArrayList<Products> list = getProductList();
        DefaultTableModel model = (DefaultTableModel) TableOne.getModel();

        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getAddDate();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getPrice();
            row[3] = list.get(i).getType();
            row[4] = list.get(i).getId();

            model.addRow(row);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DescriptionBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        AmountBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Choice = new javax.swing.JComboBox<>();
        AddButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableOne = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        BalanceBox = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CheckButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        StartDate = new com.toedter.calendar.JDateChooser();
        EndDate = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(204, 204, 255));
        setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Date");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Description");

        DescriptionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriptionBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Amount");

        AmountBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountBoxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Type");

        Choice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Expense", "Income" }));
        Choice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoiceActionPerformed(evt);
            }
        });

        AddButton.setBackground(new java.awt.Color(0, 255, 153));
        AddButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        TableOne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Description", "Amount", "Type", "Transaction No."
            }
        ));
        TableOne.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TableOneAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(TableOne);
        if (TableOne.getColumnModel().getColumnCount() > 0) {
            TableOne.getColumnModel().getColumn(4).setMinWidth(10);
            TableOne.getColumnModel().getColumn(4).setMaxWidth(20);
        }

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Balance:");

        BalanceBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BalanceBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BalanceBoxActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Start Date:");

        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("End Date:");

        CheckButton.setText("Check");
        CheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckButtonActionPerformed(evt);
            }
        });

        DeleteButton.setBackground(new java.awt.Color(255, 0, 51));
        DeleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 255, 204));
        jButton1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton1.setText("View All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(CheckButton)
                .addGap(71, 71, 71)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BalanceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DescriptionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AmountBox, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Choice, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(DescriptionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1)
                                .addComponent(AmountBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(Choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AddButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BalanceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(CheckButton)
                            .addComponent(jButton1))
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DescriptionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriptionBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescriptionBoxActionPerformed

    private void AmountBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountBoxActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        if (checkInputs() == true) {
            String type = null;
            double amount;
            int id;
            amount = Double.parseDouble(AmountBox.getText());
            if (Choice.getSelectedIndex() == 0) {
                amount *= -1;
                type = "Expense";

            } else {
                type = "Income";

            }
            try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO expenses(date,description,amount,type)" + "values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS); //database table names
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String addDate = dateFormat.format(jDateChooser1.getDate());
                ps.setString(1, addDate);

                ps.setString(2, DescriptionBox.getText());

                ps.setDouble(3, amount);

                ps.setString(4, type);

                ps.executeUpdate();

                int generatedId = -1; // Default value
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
                DefaultTableModel model = (DefaultTableModel) TableOne.getModel();
                Object[] rowData = {addDate, DescriptionBox.getText(), amount, type, generatedId};
                model.addRow(rowData);

                //JOptionPane.showMessageDialog(null, "Data Added");
                TableOne.setModel(model);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            try {
                balance = getTotalExpenses();
                //JOptionPane.showMessageDialog(null, "Total expenses: " + balance);
            } catch (Exception ex) {
                //JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }

            BalanceBox.setText("Rs." + balance);

            if (balance < 0) {
                BalanceBox.setBackground(Color.red);
                BalanceBox.setForeground(Color.white);
            } else if (balance > 0) {
                BalanceBox.setBackground(Color.GREEN);
                BalanceBox.setForeground(Color.BLACK);
            } else {
                BalanceBox.setBackground(Color.YELLOW);
            }

        } else {
            JOptionPane.showMessageDialog(null, "One or More Field Are Empty");
        }


    }//GEN-LAST:event_AddButtonActionPerformed

    private void ChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChoiceActionPerformed

    private void BalanceBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BalanceBoxActionPerformed

    }//GEN-LAST:event_BalanceBoxActionPerformed

    private void TableOneAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TableOneAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_TableOneAncestorAdded

    private void CheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckButtonActionPerformed
        try {
            balance = getTotalExpensesPeriod(StartDate.getDate(),EndDate.getDate());
            displayRecordsInTimePeriod(StartDate.getDate(),EndDate.getDate());
            BalanceBox.setText("Rs."+ balance);

            if (balance < 0) {
                BalanceBox.setBackground(Color.red);
                BalanceBox.setForeground(Color.white);
            } else if (balance > 0) {
                BalanceBox.setBackground(Color.GREEN);
                BalanceBox.setForeground(Color.BLACK);
            } else {
                BalanceBox.setBackground(Color.YELLOW);
            }

            TableOne.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    String type = (String) value;
                    // Set background color based on the value in the "Type" column
                    if ("Expense".equals(type)) {
                        renderer.setBackground(Color.RED);
                    } else if ("Income".equals(type)) {
                        renderer.setBackground(Color.GREEN);
                    }
                    return renderer;
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(FormReal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_CheckButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) TableOne.getModel();
        int selectedRow = TableOne.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
            return;
        }

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM expenses WHERE id = ?");
            Object primaryKeyValue = TableOne.getValueAt(selectedRow, 4);
            Object obj = primaryKeyValue;
            int intValue = Integer.parseInt(obj.toString());

            ps.setInt(1, intValue);
            ps.executeUpdate();

            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(null, "Row deleted successfully!");

        } catch (SQLException ex) {
            Logger.getLogger(FormReal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error deleting row: " + ex.getMessage());
        }

        if (StartDate.getDate() == null) {
            try {
                

                balance = getTotalExpenses();
                BalanceBox.setText("Rs." + balance);
                //JOptionPane.showMessageDialog(null, "Total expenses: " + balance);
            } catch (Exception ex) {
                //JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }

        } else {
            try {

                balance = getTotalExpensesPeriod(StartDate.getDate(), EndDate.getDate());
                BalanceBox.setText("Rs." + balance); //update new balance
            } catch (SQLException ex) {
                Logger.getLogger(FormReal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Colour
        if (balance < 0) {
            BalanceBox.setBackground(Color.red);
            BalanceBox.setForeground(Color.white);
        } else if (balance > 0) {
            BalanceBox.setBackground(Color.GREEN);
            BalanceBox.setForeground(Color.BLACK);
        } else {
            BalanceBox.setBackground(Color.YELLOW);
        }


    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearTable();
        Show_products_In_JTable();
        StartDate.setDate(null);
        EndDate.setDate(null);

        try {
            balance = getTotalExpenses();
        } catch (SQLException ex) {
            Logger.getLogger(FormReal.class.getName()).log(Level.SEVERE, null, ex);
        }
        BalanceBox.setText("Rs." + balance);

        //Colour
        if (balance < 0) {
            BalanceBox.setBackground(Color.red);
            BalanceBox.setForeground(Color.white);
        } else if (balance > 0) {
            BalanceBox.setBackground(Color.GREEN);
            BalanceBox.setForeground(Color.BLACK);
        } else {
            BalanceBox.setBackground(Color.YELLOW);
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTextField AmountBox;
    private javax.swing.JTextField BalanceBox;
    private javax.swing.JButton CheckButton;
    private javax.swing.JComboBox<String> Choice;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField DescriptionBox;
    private com.toedter.calendar.JDateChooser EndDate;
    private com.toedter.calendar.JDateChooser StartDate;
    private javax.swing.JTable TableOne;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
