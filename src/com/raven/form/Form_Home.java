package com.raven.form;

import com.raven.main.Main;
import com.raven.model.Model_Card;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_Home extends javax.swing.JPanel {
    
    private Main my_main=null;
    public Form_Home() {
        initComponents();
        String motivation_with_author,expression;
        Date current_date=new Date();
        int day=current_date.getDay();
        
        switch (day) {
            case 1:
                motivation_with_author="The only way to achieve the impossible is to believe it is possible - Charles Kingsleigh";
                expression="New week, new goals. Embrace the opportunity to start fresh and make this week count.";
                break;
                
            case 2:
                motivation_with_author="Believe you can and you're halfway there - Theodore Roosevelt";
                expression="Stay focused and determined. Success doesn't come from what you do occasionally, but from what you do consistently";
                break;
            case 3:
                motivation_with_author="\"Success is not final, failure is not fatal: It is the courage to continue that counts.\" - Winston Churchill";
                expression="Halfway there! Keep pushing forward. Your hard work will pay off.";
                break;
            case 4:
                motivation_with_author="\"Hardships often prepare ordinary people for an extraordinary destiny.\" - C.S. Lewis";
                expression="Don't stop now. You're closer than you were yesterday. Keep going and finish the week strong";
                break;
            case 5:
                motivation_with_author="\"It does not matter how slowly you go as long as you do not stop.\" - Confucius";
                expression="Finish the week on a high note. Your dedication and perseverance have brought you this far.";
                break;
            case 6:
                motivation_with_author="\"Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.\" - Albert Schweitzer";
                expression="oday is a day to recharge and reflect. Take time to rest and rejuvenate, but don't lose sight of your goals";
                break;
            case 7:
                motivation_with_author="\"Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.\" - Albert Schweitzer";
                expression="oday is a day to recharge and reflect. Take time to rest and rejuvenate, but don't lose sight of your goals";
                break;
            default:
                throw new AssertionError();
        }
        card3.setData(new Model_Card("Hello Sahas..",motivation_with_author, expression));
        card3.setSize(400, 300);
        //  add row table
        
        //assigning values to card 2- task manager
        card2.setData(new Model_Card("Task Manager","Casper the task manager ghost","Click here to summon...."));
        card5.setData(new Model_Card("Notes","Casper the Note taker","Click here to summon...."));
        card1.setData(new Model_Card("Digital Diary","Casper the friendly diary","Click here to summon...."));
        card4.setData(new Model_Card("Digital Wallet","Casper the Treasurer","Click here to summon...."));
        card6.setData(new Model_Card("Week Planer","Casper the Journey buddy","Click here to summon...."));
        
        
        
    }
    public void getMain(Main enter_main){
        this.my_main=enter_main;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card3 = new com.raven.component.Card();
        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        card1 = new com.raven.component.Card();
        card2 = new com.raven.component.Card();
        card4 = new com.raven.component.Card();
        card5 = new com.raven.component.Card();
        card6 = new com.raven.component.Card();

        card3.setColor1(new java.awt.Color(64, 190, 44));
        card3.setColor2(new java.awt.Color(211, 184, 61));

        panel.setLayer(card3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(jDayChooser1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDayChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jDayChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        card1.setColor1(new java.awt.Color(255, 102, 0));
        card1.setColor2(new java.awt.Color(255, 204, 102));
        card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card1MouseClicked(evt);
            }
        });

        card2.setColor1(new java.awt.Color(102, 19, 139));
        card2.setColor2(new java.awt.Color(122, 86, 203));
        card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card2MouseClicked(evt);
            }
        });

        card4.setColor1(new java.awt.Color(153, 0, 153));
        card4.setColor2(new java.awt.Color(255, 102, 255));
        card4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card4MouseClicked(evt);
            }
        });

        card5.setColor1(new java.awt.Color(0, 102, 255));
        card5.setColor2(new java.awt.Color(131, 204, 204));
        card5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card5MouseClicked(evt);
            }
        });

        card6.setColor1(new java.awt.Color(0, 102, 51));
        card6.setColor2(new java.awt.Color(0, 255, 51));
        card6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(350, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card2MouseClicked
        // TODO add your handling code here:
        this.my_main.setForm(this.my_main.form1);
        
    }//GEN-LAST:event_card2MouseClicked

    private void card5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card5MouseClicked
        // TODO add your handling code here:
        this.my_main.setForm(this.my_main.form2);
    }//GEN-LAST:event_card5MouseClicked

    private void card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card1MouseClicked
        // TODO add your handling code here:
        this.my_main.setForm(this.my_main.form3);
       
    }//GEN-LAST:event_card1MouseClicked

    private void card4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card4MouseClicked
        // TODO add your handling code here:
        this.my_main.setForm(this.my_main.form4);
    }//GEN-LAST:event_card4MouseClicked

    private void card6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card6MouseClicked
        // TODO add your handling code here:
        this.my_main.setForm(this.my_main.form5);
    }//GEN-LAST:event_card6MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private com.raven.component.Card card4;
    private com.raven.component.Card card5;
    private com.raven.component.Card card6;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLayeredPane panel;
    // End of variables declaration//GEN-END:variables
}
