/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bankingsystem;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Niel Adrian
 */
public class MainMenu extends javax.swing.JFrame {

    static JLabel clickedLabel;

    public MainMenu() {

        initComponents();
        jdc_date.setDate(new Date());
    }

    private void set_Balance_Deposit() {
        String account_number = lbl_accountnumber.getText();
        String account = MainMenu.cmb_account.getSelectedItem().toString();
        String sql = "SELECT SUM(savings_account_amount),SUM(checking_account_amount)  "
                + "FROM open_account INNER JOIN bank_transaction "
                + "ON open_account.account_number = bank_transaction.bank_transactionaccountnumber "
                + "WHERE open_account.account_number='" + account_number + "'";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Copy the url of database connection from connection properties
            String url = "jdbc:mysql://localhost:3306/db_bank?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String sqlusername = "root";//username of MySQL Connection
            String sqlpassword = "";//password of MYSQL Connection
            //Register the Connection
            Connection conn = DriverManager.getConnection(url, sqlusername, sqlpassword);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                if (account.equals("Savings Account")) {
                    double amount = rs.getDouble(1);
                    String a = String.format("%.2f", amount);
                    DecimalFormat decimal = new DecimalFormat("#.00");
                    decimal.setGroupingUsed(true);
                    decimal.setGroupingSize(3);
                    double aa = Double.parseDouble(a);
                    Deposit.lbl_amount.setText(decimal.format(aa));

                } else {
                    double amount = rs.getDouble(2);
                    String a = String.format("%.2f", amount);
                    DecimalFormat decimal = new DecimalFormat("#.00");
                    decimal.setGroupingUsed(true);
                    decimal.setGroupingSize(3);
                    double aa = Double.parseDouble(a);

                    Deposit.lbl_amount.setText(decimal.format(aa));
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void set_Balance_Withdraw() {
        String account_number = lbl_accountnumber.getText();
        String account = MainMenu.cmb_account.getSelectedItem().toString();
        String sql = "SELECT SUM(savings_account_amount),SUM(checking_account_amount)  "
                + "FROM open_account INNER JOIN bank_transaction "
                + "ON open_account.account_number = bank_transaction.bank_transactionaccountnumber "
                + "WHERE open_account.account_number='" + account_number + "'";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Copy the url of database connection from connection properties
            String url = "jdbc:mysql://localhost:3306/db_bank?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String sqlusername = "root";//username of MySQL Connection
            String sqlpassword = "";//password of MYSQL Connection
            //Register the Connection
            Connection conn = DriverManager.getConnection(url, sqlusername, sqlpassword);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                if (account.equals("Savings Account")) {
                    double amount = rs.getDouble(1);
                    String a = String.format("%.2f", amount);
                    DecimalFormat decimal = new DecimalFormat("#.00");
                    decimal.setGroupingUsed(true);
                    decimal.setGroupingSize(3);
                    double aa = Double.parseDouble(a);
                    Withdraw.lbl_amount.setText(decimal.format(aa));

                } else {
                    double amount = rs.getDouble(2);
                    String a = String.format("%.2f", amount);
                    DecimalFormat decimal = new DecimalFormat("#.00");
                    decimal.setGroupingUsed(true);
                    decimal.setGroupingSize(3);
                    double aa = Double.parseDouble(a);
                    Withdraw.lbl_amount.setText(decimal.format(aa));

                }

            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl_accountnumber = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbl_amount = new javax.swing.JLabel();
        cmb_account = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        lbl_deposit = new javax.swing.JLabel();
        lbl_withdraw = new javax.swing.JLabel();
        lbl_createaccount2 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        lbl_transaction = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl_deleteaccount = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jdc_date = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(24, 64, 114));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255), 3));

        jPanel3.setBackground(new java.awt.Color(218, 231, 248));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Your Account", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(24, 64, 114))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("₱");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Name:");

        lbl_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Account Number:");

        lbl_accountnumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_accountnumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Balance:");

        lbl_amount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        cmb_account.setForeground(new java.awt.Color(255, 255, 255));
        cmb_account.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Savings Account", "Checking Account" }));
        cmb_account.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmb_accountPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_accountnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                    .addComponent(lbl_name, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(cmb_account, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_accountnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(lbl_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmb_account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );

        jPanel4.setBackground(new java.awt.Color(53, 205, 255));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        lbl_deposit.setBackground(new java.awt.Color(204, 204, 204));
        lbl_deposit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_deposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deposit.png"))); // NOI18N
        lbl_deposit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.black));
        lbl_deposit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_depositMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_depositMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_depositMouseExited(evt);
            }
        });

        lbl_withdraw.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_withdraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/withdraw.png"))); // NOI18N
        lbl_withdraw.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.black));
        lbl_withdraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_withdrawMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_withdrawMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_withdrawMouseExited(evt);
            }
        });

        lbl_createaccount2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_createaccount2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transaction.png"))); // NOI18N
        lbl_createaccount2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.black));
        lbl_createaccount2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_createaccount2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_createaccount2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_createaccount2MouseExited(evt);
            }
        });

        label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label.setForeground(new java.awt.Color(0, 0, 0));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("DEPOSIT");

        label2.setBackground(new java.awt.Color(24, 64, 114));
        label2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label2.setForeground(new java.awt.Color(0, 0, 0));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setText("WITHDRAW");

        lbl_transaction.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_transaction.setForeground(new java.awt.Color(0, 0, 0));
        lbl_transaction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_transaction.setText("TRANSACTION");

        jPanel5.setBackground(new java.awt.Color(53, 205, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "DELETE ACCOUNT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(114, 114));

        lbl_deleteaccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deleteicon (1).png"))); // NOI18N
        lbl_deleteaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_deleteaccountMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl_deleteaccount, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_deleteaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_transaction, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_deposit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_createaccount2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_withdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(label2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_withdraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_deposit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_transaction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_createaccount2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 0));
        jButton3.setText("EXIT");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jdc_date.setBackground(new java.awt.Color(218, 231, 248));
        jdc_date.setForeground(new java.awt.Color(255, 255, 255));
        jdc_date.setDateFormatString("yyyy-MM-dd");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainmenulogo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainmenulogoname.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdc_date, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdc_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_depositMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_depositMouseClicked
        new Deposit().show();
        String name = lbl_name.getText();
        String acctnumber = lbl_accountnumber.getText();
        Deposit.lbl_name1.setText(name);
        Deposit.lbl_accountnumber1.setText(acctnumber);
        set_Balance_Deposit();


    }//GEN-LAST:event_lbl_depositMouseClicked

    private void lbl_depositMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_depositMouseEntered
        lbl_deposit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Font font = new Font("Segoe UI", Font.BOLD, 18);
        Map attr = font.getAttributes();
        attr.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label.setFont(font.deriveFont(attr));
    }//GEN-LAST:event_lbl_depositMouseEntered

    private void lbl_depositMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_depositMouseExited
        Font font = new Font("Segoe UI", Font.BOLD, 18);
        Map attr = font.getAttributes();
        attr.put(TextAttribute.UNDERLINE, -1);
        label.setFont(font.deriveFont(attr));
    }//GEN-LAST:event_lbl_depositMouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        new Bank().show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void lbl_withdrawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_withdrawMouseClicked
        new Withdraw().show();
        String name = lbl_name.getText();
        String acctnumber = lbl_accountnumber.getText();
        Withdraw.lbl_name1.setText(name);
        Withdraw.lbl_accountnumber1.setText(acctnumber);
        set_Balance_Withdraw();
    }//GEN-LAST:event_lbl_withdrawMouseClicked

    private void lbl_withdrawMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_withdrawMouseEntered
        lbl_withdraw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Font font = new Font("Segoe UI", Font.BOLD, 18);
        Map attr = font.getAttributes();
        attr.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label2.setFont(font.deriveFont(attr));
    }//GEN-LAST:event_lbl_withdrawMouseEntered

    private void lbl_withdrawMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_withdrawMouseExited
        Font font = new Font("Segoe UI", Font.BOLD, 18);
        Map attr = font.getAttributes();
        attr.put(TextAttribute.UNDERLINE, -1);
        label2.setFont(font.deriveFont(attr));
    }//GEN-LAST:event_lbl_withdrawMouseExited

    private void lbl_createaccount2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_createaccount2MouseClicked
        new Transaction().show();
        String name = lbl_name.getText();
        String acctnumber = lbl_accountnumber.getText();
        Transaction.lbl_name2.setText(name);
        Transaction.lbl_accountnumber2.setText(acctnumber);
    }//GEN-LAST:event_lbl_createaccount2MouseClicked

    private void lbl_createaccount2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_createaccount2MouseEntered
        lbl_createaccount2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Font font = new Font("Segoe UI", Font.BOLD, 18);
        Map attr = font.getAttributes();
        attr.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lbl_transaction.setFont(font.deriveFont(attr));
    }//GEN-LAST:event_lbl_createaccount2MouseEntered

    private void lbl_createaccount2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_createaccount2MouseExited
        Font font = new Font("Segoe UI", Font.BOLD, 18);
        Map attr = font.getAttributes();
        attr.put(TextAttribute.UNDERLINE, -1);
        lbl_transaction.setFont(font.deriveFont(attr));
    }//GEN-LAST:event_lbl_createaccount2MouseExited

    private void cmb_accountPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmb_accountPopupMenuWillBecomeInvisible
        String account = cmb_account.getSelectedItem().toString();
        int account_number = Integer.parseInt(lbl_accountnumber.getText());
        String sql = "SELECT * FROM open_account WHERE account_number='" + account_number + "'";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Copy the url of database connection from connection properties
            String url = "jdbc:mysql://localhost:3306/db_bank?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String sqlusername = "root";//username of MySQL Connection
            String sqlpassword = "";//password of MYSQL Connection
            //Register the Connection
            Connection conn = DriverManager.getConnection(url, sqlusername, sqlpassword);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                if (cmb_account.getSelectedItem() == "Savings Account") {
                    double amount = rs.getDouble("sa_balance");
                    String a = String.format("%.2f", amount);
                    DecimalFormat decimal = new DecimalFormat("#.00");
                    decimal.setGroupingUsed(true);
                    decimal.setGroupingSize(3);
                    double aa = Double.parseDouble(a);
                    lbl_amount.setText(decimal.format(aa));
                } else {
                    double amount = rs.getDouble("ca_balance");
                    String a = String.format("%.2f", amount);
                    DecimalFormat decimal = new DecimalFormat("#.00");
                    decimal.setGroupingUsed(true);
                    decimal.setGroupingSize(3);
                    double aa = Double.parseDouble(a);
                    lbl_amount.setText(decimal.format(aa));
                }

            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cmb_accountPopupMenuWillBecomeInvisible

    private void lbl_deleteaccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_deleteaccountMouseClicked
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this account?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            int account_number = Integer.parseInt(lbl_accountnumber.getText());

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/db_bank?zeroDateTimeBehavior=CONVERT_TO_NULL";
                String sqlusername = "root";
                String sqlpassword = "";

                Connection conn = DriverManager.getConnection(url, sqlusername, sqlpassword);

                String sql = "DELETE FROM open_account WHERE account_number = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, account_number);
                int result = pst.executeUpdate();

                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Account deleted.");
                    this.dispose();
                    new Bank().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete account.");
                }

                pst.close();
                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_lbl_deleteaccountMouseClicked

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> cmb_account;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private com.toedter.calendar.JDateChooser jdc_date;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label2;
    public static javax.swing.JLabel lbl_accountnumber;
    public static javax.swing.JLabel lbl_amount;
    private javax.swing.JLabel lbl_createaccount2;
    private javax.swing.JLabel lbl_deleteaccount;
    private javax.swing.JLabel lbl_deposit;
    public static javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_transaction;
    private javax.swing.JLabel lbl_withdraw;
    // End of variables declaration//GEN-END:variables
}
