package tethproj;

import UTIL.AESCrypt;
import UTIL.DBHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SamaherD
 */
public class AddAdmin extends javax.swing.JFrame {

    public static String username;

    public AddAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        currentAdminPasswordText = new javax.swing.JTextField();
        newAdminPasswordText = new javax.swing.JTextField();
        newAdminUserNameText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addbtn = new javax.swing.JButton();
        cancletxt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Admin name :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 90, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Admin Password:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("          your password:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 140, -1));
        jPanel1.add(currentAdminPasswordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 240, 30));
        jPanel1.add(newAdminPasswordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 240, 30));

        newAdminUserNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAdminUserNameTextActionPerformed(evt);
            }
        });
        jPanel1.add(newAdminUserNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 240, 30));

        jLabel4.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        jLabel4.setText("Add New Admin ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 300, 40));

        addbtn.setText("Add");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        jPanel1.add(addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 80, 30));

        cancletxt.setText("cancel ");
        cancletxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancletxtActionPerformed(evt);
            }
        });
        jPanel1.add(cancletxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 80, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 52, 380, 10));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/schedule-an-appointment_1.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 530, 270));

        jPasswordField1.setText("jPasswordField1");
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancletxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancletxtActionPerformed

        dispose();

    }//GEN-LAST:event_cancletxtActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed

        String newAdminUserName = newAdminUserNameText.getText().trim();
        String newAdminPassword = newAdminPasswordText.getText().trim();
        String currentAdminPassword = this.currentAdminPasswordText.getText().trim();

        try {
            if (DBHelper.checkPassword(Login.getUserName(), AESCrypt.encrypt(currentAdminPassword))) { //Check if current admin password is correct
                if (DBHelper.isValidUserName(newAdminUserName)) {   // Check if new admin doesnt exists in database then it is valid name
                    if (DBHelper.addUser(1, newAdminUserName, AESCrypt.encrypt(newAdminPassword))) { // Add new admin
                        JOptionPane.showMessageDialog(null, "Added Successfully");
                        this.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "This admin name is exist please try another name");
                        newAdminUserNameText.setText("");
                        newAdminPasswordText.setText("");
                        currentAdminPasswordText.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Your password is wrong!");
                    currentAdminPasswordText.setText("");

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(AddAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addbtnActionPerformed

    private void newAdminUserNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAdminUserNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newAdminUserNameTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAdmin().setVisible(true);
            }
        });
    }

    public static void setUser(String s) {
        username = s;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton cancletxt;
    private javax.swing.JTextField currentAdminPasswordText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField newAdminPasswordText;
    private javax.swing.JTextField newAdminUserNameText;
    // End of variables declaration//GEN-END:variables

}
