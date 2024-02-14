
package com.raven.notes;
import com.raven.form.Form_2;
import com.raven.notes.recordernew;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

public class recorder extends javax.swing.JDialog {
private recordernew audioRecorderInstance;
private Form_2 Form_2Instancenew;
    /**
     * Creates new form recorder
     */
    public recorder(java.awt.Frame parent, boolean modal,Form_2 form2Instancenew) {
        super(parent, modal);
        initComponents();
        audioRecorderInstance=new recordernew();
        jTabbedPane1.setSelectedIndex(1);
        this.Form_2Instancenew=form2Instancenew;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textField1 = new java.awt.TextField();
        Title = new java.awt.Label();
        Title1 = new java.awt.Label();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(248, 216, 248));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-microphone-64.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(50, 64));
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 64));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 72, 132));

        jButton1.setText("Start Recording");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 124, 31));

        jButton2.setText("Stop Recording");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 124, 34));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-audio-wave_1.gif"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(59, 59, 59))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-audio-wave-48 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel3)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, -40, -1, 330));

        textField1.setCaretPosition(6);
        textField1.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        textField1.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(textField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 150, 30));

        Title.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        Title.setForeground(new java.awt.Color(0, 153, 153));
        Title.setText("Date");
        getContentPane().add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        Title1.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        Title1.setForeground(new java.awt.Color(0, 153, 153));
        Title1.setText("Title");
        getContentPane().add(Title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 150, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(textField1.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter a Title !");
        
        }
        else{
        String fileName=textField1.getText();
        audioRecorderInstance.startRecording(fileName);
        jTabbedPane1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        audioRecorderInstance.stopRecording();
        jTabbedPane1.setSelectedIndex(1);
        String audioName=textField1.getText();
        Date audiodate=jDateChooser1.getDate();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestring=dateFormat.format(audiodate);
        Form_2Instancenew.addAudio(audioName,datestring);
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                recorder dialog = new recorder(new javax.swing.JFrame(), true,new Form_2());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label Title;
    private java.awt.Label Title1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
