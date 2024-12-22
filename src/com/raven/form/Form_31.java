/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;
//DASDS

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import jdk.internal.agent.Agent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Form_31 extends javax.swing.JPanel {
    
    private Connection con;

    //private DiaryTableModel tableModel;
    public Form_31(Connection con) {
        initComponents();
        this.con=con;
        Show_products_In_JTable();
//        tableModel = new DiaryTableModel();
//        jTable1.setModel(tableModel);

    }

    

    public boolean checkInputs() {
        if (ChooseDate.getDate() == null || txtTitle.getText() == null || txtEntry.getText() == null) {
            return false;
        } else {
            return true;

        }
    }

    public ArrayList<NewClass> getProductList1() {
        ArrayList<NewClass> DiaryList = new ArrayList<NewClass>();
        String query = "SELECT * FROM diary";

        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(query);
            NewClass diary;

            while (rs.next()) {
                diary = new NewClass(rs.getInt("id"), rs.getDate("date"), rs.getString("title"), rs.getString("entry"));
                DiaryList.add(diary);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form_31.class.getName()).log(Level.SEVERE, null, ex);
        }

        return DiaryList;

    }

    // 2- Populate the JTable
    public void Show_products_In_JTable() {
        ArrayList<NewClass> list = getProductList1();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getAddDate();
            row[2] = list.get(i).getName();
            row[3] = list.get(i).getType();
            //  

            model.addRow(row);

        }
    }

    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#e6220c"), getWidth(), getHeight(), Color.decode("#ffad5c"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        ChooseDate = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEntry = new javax.swing.JTextArea();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(172, 246, 172));
        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("My Diary ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hi there, welcome back!!  How you feeling today??? Let's write them down!!!!");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Title:");

        jLabel5.setBackground(new java.awt.Color(227, 224, 224));
        jLabel5.setFont(new java.awt.Font("Papyrus", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 102));
        jLabel5.setText("Write your thoughts, Experiences here..");

        txtTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });
        txtTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTitleKeyPressed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(153, 255, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.gray, null, null));
        jTable1.setFont(new java.awt.Font("Pristina", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Date", "Title", "Entry"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(51, 102, 255));
        jTable1.setRowHeight(25);
        jTable1.setSelectionForeground(new java.awt.Color(153, 255, 153));
        jTable1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jTable1HierarchyChanged(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(20);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("View Entry");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ChooseDate.setDateFormatString("yyyy-MM-dd");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Add Entry");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        txtEntry.setColumns(20);
        txtEntry.setFont(new java.awt.Font("Artifakt Element Book", 3, 14)); // NOI18N
        txtEntry.setForeground(new java.awt.Color(255, 102, 51));
        txtEntry.setRows(5);
        jScrollPane2.setViewportView(txtEntry);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 546, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2))
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(445, 445, 445)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ChooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(77, 77, 77))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Delete)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTitleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitleKeyPressed
        if (evt.getKeyCode() == 10) {
            txtEntry.requestFocus();
        }
    }//GEN-LAST:event_txtTitleKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTable1.getRowCount() > 0) {
            // Get the selected row index
            int selectedRowIndex = jTable1.getSelectedRow();

            if (selectedRowIndex != -1) {
                // Get data from the selected row
                String id = jTable1.getValueAt(selectedRowIndex, 0).toString();
                String date = jTable1.getValueAt(selectedRowIndex, 1).toString();
                String title = jTable1.getValueAt(selectedRowIndex, 2).toString();
                String entry = jTable1.getValueAt(selectedRowIndex, 3).toString();

                // Create a new JFrame to display the details
                JFrame detailsFrame = new JFrame("Entry Details");
                detailsFrame.setSize(400, 300);

                // Create a JTextArea to display the details
                JTextArea detailsTextArea = new JTextArea();
                detailsTextArea.setEditable(false);
                detailsTextArea.append("Date   : " + date + "\n\n");
                detailsTextArea.append("Title  : " + title + "\n\n");
                detailsTextArea.append("Entry  : " + entry);

                // Add the JTextArea to the JFrame
                detailsFrame.add(new JScrollPane(detailsTextArea));

                // Set JFrame properties
                detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                detailsFrame.setLocationRelativeTo(null);
                detailsFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please select an entry from the table.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No entries to display.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTable1HierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1HierarchyChanged

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow != -1) {
                // Get data from the selected row and display details
                Object data1 = jTable1.getValueAt(selectedRow, 0);
                Object data2 = jTable1.getValueAt(selectedRow, 1);
                // Add more lines to retrieve other data from the selected row

                // Example: Displaying details in a JOptionPane
                String details = "Data1: " + data1 + "\nData2: " + data2;
                javax.swing.JOptionPane.showMessageDialog(null, details, "Row Details", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (checkInputs() == true) {

            try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO diary(date,title,entry)" + "values(?,?,?)", Statement.RETURN_GENERATED_KEYS); //database table names
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String addDate = dateFormat.format(ChooseDate.getDate());
                ps.setString(1, addDate);

                ps.setString(2, txtTitle.getText());
                ps.setString(3, txtEntry.getText());

                ps.executeUpdate();

                int generatedId = -1; // Default value
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
                //Show_products_In_JTable();
                //JOptionPane.showMessageDialog(null, "Data Added");
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                Object[] rowData = {generatedId, addDate, txtTitle.getText(), txtEntry.getText()};
                model.addRow(rowData);
                this.txtEntry.setText("");
                this.txtTitle.setText("");
                this.ChooseDate.setDate(null);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "One or More Field Are Empty");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
            return;
        }

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM diary WHERE id = ?");
            Object primaryKeyValue = jTable1.getValueAt(selectedRow, 0);
            Object obj = primaryKeyValue;
            int intValue = Integer.parseInt(obj.toString());

            ps.setInt(1, intValue);
            ps.executeUpdate();

            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(null, "Page deleted successfully!" + primaryKeyValue);

        } catch (SQLException ex) {
            Logger.getLogger(Form_31.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error deleting row: " + ex.getMessage());
        }
    }//GEN-LAST:event_DeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser ChooseDate;
    private javax.swing.JButton Delete;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtEntry;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
