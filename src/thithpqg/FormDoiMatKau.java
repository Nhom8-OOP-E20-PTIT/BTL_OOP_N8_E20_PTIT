/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thithpqg;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class FormDoiMatKau extends javax.swing.JPanel {

    public FormDoiMatKau() {
        initComponents();
    }

  public void setBg(Color a){
  this.setBackground(a);
  this.jPanel1.setBackground(a);
  this.jPanel2.setBackground(a);
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMKC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMKM = new javax.swing.JTextField();
        gfghfg = new javax.swing.JLabel();
        txtMKMR = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnDN = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thí Sinh Đăng Nhập");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 10, 20));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nhập Mật Khẩu Cũ");
        jPanel1.add(jLabel2);

        txtMKC.setPreferredSize(new java.awt.Dimension(10, 30));
        txtMKC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMKCFocusLost(evt);
            }
        });
        txtMKC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMKCActionPerformed(evt);
            }
        });
        txtMKC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMKCKeyTyped(evt);
            }
        });
        jPanel1.add(txtMKC);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mật Khẩu");
        jPanel1.add(jLabel3);

        txtMKM.setMinimumSize(new java.awt.Dimension(6, 10));
        txtMKM.setPreferredSize(new java.awt.Dimension(10, 30));
        txtMKM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMKMFocusLost(evt);
            }
        });
        jPanel1.add(txtMKM);

        gfghfg.setText("          Nhập Lại Mật Khẩu Mới");
        jPanel1.add(gfghfg);

        txtMKMR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMKMRFocusLost(evt);
            }
        });
        jPanel1.add(txtMKMR);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        btnDN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.png"))); // NOI18N
        btnDN.setText("Lưu");
        btnDN.setPreferredSize(new java.awt.Dimension(78, 23));
        btnDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDNActionPerformed(evt);
            }
        });
        jPanel2.add(btnDN);

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnHuy.setText("Reset");
        btnHuy.setMaximumSize(new java.awt.Dimension(87, 23));
        btnHuy.setMinimumSize(new java.awt.Dimension(87, 23));
        btnHuy.setPreferredSize(new java.awt.Dimension(87, 25));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel2.add(btnHuy);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

     
    private void btnDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDNActionPerformed
        if(!"".equals(txtMKC.getText())&&!"".equals(txtMKM.getText())&&!"".equals(txtMKMR.getText())){
        try {
        
            if(ThiTHPTFrame.ts.doimatkhau(txtMKM.getText())==true){
             JOptionPane.showMessageDialog(null,"Đổi Mật khẩu thành công! ",
                  "Thông báo", JOptionPane.DEFAULT_OPTION);}
            }
         catch ( ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FormDoiMatKau.class.getName()).log(Level.SEVERE, null, ex);
    }//GEN-LAST:event_btnDNActionPerformed
    }else{ JOptionPane.showMessageDialog(null,"Nhập đủ thông tin! ",
                  "Thông báo", JOptionPane.DEFAULT_OPTION);}
}
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        txtMKC.setText("");
        txtMKM.setText("");
        txtMKMR.setText("");
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtMKCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMKCActionPerformed
       
    }//GEN-LAST:event_txtMKCActionPerformed

    private void txtMKCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMKCKeyTyped
      
    }//GEN-LAST:event_txtMKCKeyTyped

    private void txtMKCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMKCFocusLost
        if(txtMKC.getText().equals(ThiTHPTFrame.ts.getMatkhau().trim())==false){
         JOptionPane.showMessageDialog(null,"Sai mật khẩu! ",
                  "Thông báo", JOptionPane.DEFAULT_OPTION);
         txtMKC.setText("");
         txtMKC.requestFocus();
        }
    }//GEN-LAST:event_txtMKCFocusLost

    private void txtMKMFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMKMFocusLost
      if(txtMKM.getText().length()>10){
      JOptionPane.showMessageDialog(null,"Mật khẩu phải nhỏ hơn 10 kí tự! ",
                  "Thông báo", JOptionPane.DEFAULT_OPTION);
       txtMKM.setText("");
         txtMKM.requestFocus();
      }
    }//GEN-LAST:event_txtMKMFocusLost

    private void txtMKMRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMKMRFocusLost
      if(txtMKMR.getText().equals(txtMKM.getText())==false){
       JOptionPane.showMessageDialog(null,"Mật khẩu mới không khớp! ",
                  "Thông báo", JOptionPane.DEFAULT_OPTION);
       txtMKMR.setText("");
         txtMKMR.requestFocus();
      }
    }//GEN-LAST:event_txtMKMRFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDN;
    private javax.swing.JButton btnHuy;
    private javax.swing.JLabel gfghfg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtMKC;
    private javax.swing.JTextField txtMKM;
    private javax.swing.JTextField txtMKMR;
    // End of variables declaration//GEN-END:variables
}
