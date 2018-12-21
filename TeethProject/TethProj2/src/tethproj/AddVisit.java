package tethproj;

import com.mxrck.autocompleter.TextAutoCompleter;
import UTIL.DBHelper;
import static UTIL.DBHelper.*;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author SamaherD
 */

public class AddVisit extends javax.swing.JFrame {

    /**
     * Creates new form AddVisit
     */
    String SelectedTeethIndex = "";
    JCheckBox[] arr;
    int paidValue;
    int amountValue;

    Date dcDate;
    ArrayList<Object> names_arr;
    ArrayList<Object> phones_arr;

    public AddVisit() {
        setPreferredSize(new Dimension(750, 600));
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        addCheckBoxesIntoArray();

        Teeth_frame.setTitle("Teeth");
        Teeth_frame.setVisible(false);
        setDate();
        names_arr = getPatientsNames();
        phones_arr = getPatientsPhones();

        // invoke auto complete methods
        nameAutoComplete();
        phoneAutoComplete();
    }

    private void setDate() {
        Date date = new Date();
        DateChooser.setDateFormatString("dd-MM-yyyy");
        DateChooser.setDate(date);

    }
// Auto complete methods

    private void nameAutoComplete() {
        TextAutoCompleter complete = new TextAutoCompleter(nameText, names_arr);
    }

    private void phoneAutoComplete() {
        TextAutoCompleter complete = new TextAutoCompleter(phoneText, phones_arr);
    }

    private void addCheckBoxesIntoArray() {
        arr = new JCheckBox[32];
        arr[0] = t1;
        arr[1] = t2;
        arr[2] = t3;
        arr[3] = t4;
        arr[4] = t5;
        arr[5] = t6;
        arr[6] = t7;
        arr[7] = t8;
        arr[8] = t9;
        arr[9] = t10;
        arr[10] = t11;
        arr[11] = t12;
        arr[12] = t13;
        arr[13] = t14;
        arr[14] = t15;
        arr[15] = t16;
        arr[16] = t17;
        arr[17] = t18;
        arr[18] = t19;
        arr[19] = t20;
        arr[20] = t21;
        arr[21] = t22;
        arr[22] = t23;
        arr[23] = t24;
        arr[24] = t25;
        arr[25] = t26;
        arr[26] = t27;
        arr[27] = t28;
        arr[28] = t29;
        arr[29] = t30;
        arr[30] = t31;
        arr[31] = t32;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        Teeth_frame = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        t16 = new javax.swing.JCheckBox();
        t15 = new javax.swing.JCheckBox();
        t14 = new javax.swing.JCheckBox();
        t13 = new javax.swing.JCheckBox();
        t12 = new javax.swing.JCheckBox();
        t11 = new javax.swing.JCheckBox();
        t10 = new javax.swing.JCheckBox();
        t9 = new javax.swing.JCheckBox();
        t8 = new javax.swing.JCheckBox();
        t7 = new javax.swing.JCheckBox();
        t6 = new javax.swing.JCheckBox();
        t5 = new javax.swing.JCheckBox();
        t4 = new javax.swing.JCheckBox();
        t3 = new javax.swing.JCheckBox();
        t2 = new javax.swing.JCheckBox();
        t1 = new javax.swing.JCheckBox();
        t31 = new javax.swing.JCheckBox();
        t30 = new javax.swing.JCheckBox();
        t29 = new javax.swing.JCheckBox();
        t28 = new javax.swing.JCheckBox();
        t27 = new javax.swing.JCheckBox();
        t26 = new javax.swing.JCheckBox();
        t25 = new javax.swing.JCheckBox();
        t24 = new javax.swing.JCheckBox();
        t23 = new javax.swing.JCheckBox();
        t22 = new javax.swing.JCheckBox();
        t21 = new javax.swing.JCheckBox();
        t19 = new javax.swing.JCheckBox();
        t18 = new javax.swing.JCheckBox();
        t17 = new javax.swing.JCheckBox();
        t32 = new javax.swing.JCheckBox();
        t20 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jButton_ok = new javax.swing.JButton();
        jButton_cancel_teeth = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        amountText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentsTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        medicenTextArea = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        phoneText = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton_Add = new javax.swing.JButton();
        jButton_cancel = new javax.swing.JButton();
        jButton_back = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_remains = new javax.swing.JTextField();
        paidText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        DateChooser = new com.toedter.calendar.JDateChooser();
        jLabel_backGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));
        setIconImages(null);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        Teeth_frame.setVisible(true);

        jPanel3.setLayout(null);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(30, 230, 90, 23);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Teeth"));
        jPanel2.setLayout(null);

        t16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t16ActionPerformed(evt);
            }
        });
        jPanel2.add(t16);
        t16.setBounds(40, 60, 21, 20);
        jPanel2.add(t15);
        t15.setBounds(80, 60, 20, 21);
        jPanel2.add(t14);
        t14.setBounds(120, 60, 20, 21);
        jPanel2.add(t13);
        t13.setBounds(160, 60, 20, 21);
        jPanel2.add(t12);
        t12.setBounds(210, 60, 20, 21);
        jPanel2.add(t11);
        t11.setBounds(250, 60, 20, 20);
        jPanel2.add(t10);
        t10.setBounds(290, 60, 21, 21);
        jPanel2.add(t9);
        t9.setBounds(330, 60, 20, 21);
        jPanel2.add(t8);
        t8.setBounds(370, 60, 21, 21);
        jPanel2.add(t7);
        t7.setBounds(410, 60, 20, 21);
        jPanel2.add(t6);
        t6.setBounds(450, 60, 20, 21);
        jPanel2.add(t5);
        t5.setBounds(500, 60, 20, 20);
        jPanel2.add(t4);
        t4.setBounds(540, 60, 20, 21);
        jPanel2.add(t3);
        t3.setBounds(580, 60, 20, 21);
        jPanel2.add(t2);
        t2.setBounds(620, 60, 20, 21);
        jPanel2.add(t1);
        t1.setBounds(660, 60, 20, 21);
        jPanel2.add(t31);
        t31.setBounds(80, 80, 20, 20);
        jPanel2.add(t30);
        t30.setBounds(120, 80, 21, 20);
        jPanel2.add(t29);
        t29.setBounds(160, 80, 21, 21);
        jPanel2.add(t28);
        t28.setBounds(210, 80, 20, 20);
        jPanel2.add(t27);
        t27.setBounds(250, 80, 21, 20);
        jPanel2.add(t26);
        t26.setBounds(290, 80, 21, 20);
        jPanel2.add(t25);
        t25.setBounds(330, 80, 20, 21);
        jPanel2.add(t24);
        t24.setBounds(370, 80, 21, 21);
        jPanel2.add(t23);
        t23.setBounds(410, 80, 20, 21);
        jPanel2.add(t22);
        t22.setBounds(450, 80, 20, 21);
        jPanel2.add(t21);
        t21.setBounds(500, 80, 20, 21);
        jPanel2.add(t19);
        t19.setBounds(580, 80, 20, 21);
        jPanel2.add(t18);
        t18.setBounds(620, 80, 21, 21);
        jPanel2.add(t17);
        t17.setBounds(660, 80, 20, 21);
        jPanel2.add(t32);
        t32.setBounds(40, 80, 20, 21);
        jPanel2.add(t20);
        t20.setBounds(540, 80, 20, 21);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tooth-Numbering-Systems-2.png"))); // NOI18N
        jPanel2.add(jLabel11);
        jLabel11.setBounds(30, 30, 711, 98);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(0, 0, 690, 150);

        jButton_ok.setText("Ok");
        jButton_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_okActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_ok);
        jButton_ok.setBounds(480, 170, 45, 23);

        jButton_cancel_teeth.setText("Cancel");
        jButton_cancel_teeth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancel_teethActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_cancel_teeth);
        jButton_cancel_teeth.setBounds(550, 170, 65, 23);

        Teeth_frame.getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(Teeth_frame);
        Teeth_frame.setBounds(10, 270, 720, 240);

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Date");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(29, 170, 50, 30);

        jLabel4.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Medicen");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 218, 59, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Comments");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 391, 79, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Amount");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 470, 61, 30);

        amountText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        amountText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountTextKeyReleased(evt);
            }
        });
        jPanel1.add(amountText);
        amountText.setBounds(80, 470, 70, 30);

        commentsTextArea.setColumns(20);
        commentsTextArea.setRows(5);
        jScrollPane1.setViewportView(commentsTextArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(97, 391, 530, 60);

        medicenTextArea.setColumns(20);
        medicenTextArea.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        medicenTextArea.setRows(5);
        jScrollPane2.setViewportView(medicenTextArea);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(100, 220, 530, 180);

        jButton3.setText("Teeth");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(650, 220, 75, 33);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toooo.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(540, 20, 125, 125);

        nameText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameTextMouseClicked(evt);
            }
        });
        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });
        nameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTextKeyReleased(evt);
            }
        });
        jPanel1.add(nameText);
        nameText.setBounds(280, 30, 205, 30);

        phoneText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneText.setEnabled(false);
        phoneText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phoneTextMouseClicked(evt);
            }
        });
        phoneText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneTextKeyReleased(evt);
            }
        });
        jPanel1.add(phoneText);
        phoneText.setBounds(280, 80, 205, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 154, 730, 10);

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(230, 30, 50, 30);

        jLabel10.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setText("Phone");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(230, 80, 60, 30);

        jButton_Add.setText("Add");
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Add);
        jButton_Add.setBounds(460, 530, 70, 30);

        jButton_cancel.setText("Cancel");
        jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_cancel);
        jButton_cancel.setBounds(640, 530, 70, 30);

        jButton_back.setText("Back");
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_back);
        jButton_back.setBounds(550, 530, 70, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Paid");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(270, 470, 42, 30);

        txt_remains.setEditable(false);
        txt_remains.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_remains.setText("0");
        txt_remains.setEnabled(false);
        jPanel1.add(txt_remains);
        txt_remains.setBounds(580, 470, 70, 30);

        paidText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        paidText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paidTextKeyReleased(evt);
            }
        });
        jPanel1.add(paidText);
        paidText.setBounds(310, 470, 70, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Remains");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(510, 470, 61, 30);

        DateChooser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DateChooserKeyPressed(evt);
            }
        });
        jPanel1.add(DateChooser);
        DateChooser.setBounds(100, 170, 190, 30);

        jLabel_backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edited.jpg"))); // NOI18N
        jPanel1.add(jLabel_backGround);
        jLabel_backGround.setBounds(-210, -160, 1100, 820);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 790, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelActionPerformed
        // TODO add your handling code here:
        System.exit(0);

    }//GEN-LAST:event_jButton_cancelActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        SelectedTeethIndex = "";
        Teeth_frame.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nameTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameTextMouseClicked
        // TODO add your handling code here:
        phoneText.setEnabled(false);
        nameText.setEnabled(true);
    }//GEN-LAST:event_nameTextMouseClicked

    private void phoneTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phoneTextMouseClicked
        // TODO add your handling code here:
        nameText.setEnabled(false);
        phoneText.setEnabled(true);
    }//GEN-LAST:event_phoneTextMouseClicked

    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
        // Variables declaration
        int patientId;
        String phone = phoneText.getText();
        String name = nameText.getText();
        String medicen = medicenTextArea.getText();
        String comments = commentsTextArea.getText();
        java.sql.Date sqlDate = new java.sql.Date(DateChooser.getDate().getTime());
         // Add new visit information for existing patient
        if (nameText.equals("") && phoneText.equals("")) {
            JOptionPane.showMessageDialog(null, "Search for a patient before trying to add a visit");
        } else {
            // to determine how to get patient id >> using phone or using name
            if (nameText.getText().equals("")) {
                patientId = DBHelper.getPatientId(2,phone);
            } else {
                patientId = DBHelper.getPatientId(1,name);
            }
            if (patientId == 0) {
                JOptionPane.showMessageDialog(null, "Your search information is invalid, insure that you entered the true name or phone");
            } else {
                if (medicenTextArea.getText().equals("") || amountText.getText().equals("") || paidText.getText().equals("") || SelectedTeethIndex.equals("")) {
                    JOptionPane.showMessageDialog(null, "There are an empty fields");
                } else {
                    int amount = Integer.parseInt(amountText.getText());
                    int paid = Integer.parseInt(paidText.getText());
                    if (DBHelper.addVisit(sqlDate, patientId, medicen, comments, amount, paid, SelectedTeethIndex)) {
                        JOptionPane.showMessageDialog(null, "Visit added, " + sqlDate.toString());
                    }

                }
            }

        }
    }//GEN-LAST:event_jButton_AddActionPerformed

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new controlPanel().setVisible(true);
    }//GEN-LAST:event_jButton_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_okActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isSelected()) {
                SelectedTeethIndex += i + " ";
            }
        }
        Teeth_frame.setVisible(false);
    }//GEN-LAST:event_jButton_okActionPerformed

    private void jButton_cancel_teethActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancel_teethActionPerformed
        Teeth_frame.setVisible(false);
    }//GEN-LAST:event_jButton_cancel_teethActionPerformed

    private void paidTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidTextKeyReleased
        // TODO add your handling code here:
        txt_remains.setText("");
        if (paidText.getText().equals("") == false) {

            try {
                amountValue = Integer.parseInt(amountText.getText());
                paidValue = Integer.parseInt(paidText.getText());
                int remains = amountValue - paidValue;
                txt_remains.setText(remains + "");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Wrong input please ensure your amount and paid values");
            }

    }//GEN-LAST:event_paidTextKeyReleased
    }
    private void amountTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountTextKeyReleased
        // TODO add your handling code here:
        txt_remains.setText("");
        if (amountText.getText().equals("") == false) {
            try {
                int amount = Integer.parseInt(amountText.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Wrong amount value please ensure your entered amount value");
            }
        }
    }//GEN-LAST:event_amountTextKeyReleased

    private void DateChooserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DateChooserKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateChooserKeyPressed

    private void nameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextKeyReleased
        // TODO add your handling code here:
        phoneText.setText(DBHelper.getPatiantPhone(nameText.getText().trim()));

    }//GEN-LAST:event_nameTextKeyReleased

    private void phoneTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneTextKeyReleased
        // TODO add your handling code here:
        nameText.setText(DBHelper.getPatiantName(phoneText.getText().trim()));
    }//GEN-LAST:event_phoneTextKeyReleased

    private void t16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t16ActionPerformed

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

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
            java.util.logging.Logger.getLogger(AddVisit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddVisit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddVisit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddVisit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddVisit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JInternalFrame Teeth_frame;
    private javax.swing.JTextField amountText;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea commentsTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JButton jButton_cancel_teeth;
    private javax.swing.JButton jButton_ok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_backGround;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea medicenTextArea;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField paidText;
    private javax.swing.JTextField phoneText;
    private javax.swing.JCheckBox t1;
    private javax.swing.JCheckBox t10;
    private javax.swing.JCheckBox t11;
    private javax.swing.JCheckBox t12;
    private javax.swing.JCheckBox t13;
    private javax.swing.JCheckBox t14;
    private javax.swing.JCheckBox t15;
    private javax.swing.JCheckBox t16;
    private javax.swing.JCheckBox t17;
    private javax.swing.JCheckBox t18;
    private javax.swing.JCheckBox t19;
    private javax.swing.JCheckBox t2;
    private javax.swing.JCheckBox t20;
    private javax.swing.JCheckBox t21;
    private javax.swing.JCheckBox t22;
    private javax.swing.JCheckBox t23;
    private javax.swing.JCheckBox t24;
    private javax.swing.JCheckBox t25;
    private javax.swing.JCheckBox t26;
    private javax.swing.JCheckBox t27;
    private javax.swing.JCheckBox t28;
    private javax.swing.JCheckBox t29;
    private javax.swing.JCheckBox t3;
    private javax.swing.JCheckBox t30;
    private javax.swing.JCheckBox t31;
    private javax.swing.JCheckBox t32;
    private javax.swing.JCheckBox t4;
    private javax.swing.JCheckBox t5;
    private javax.swing.JCheckBox t6;
    private javax.swing.JCheckBox t7;
    private javax.swing.JCheckBox t8;
    private javax.swing.JCheckBox t9;
    private javax.swing.JTextField txt_remains;
    // End of variables declaration//GEN-END:variables
}
