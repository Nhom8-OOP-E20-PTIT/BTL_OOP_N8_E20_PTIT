/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thithpqg;

import java.awt.Color;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class FromLichThi extends javax.swing.JPanel {
 
    /**
     * Creates new form DangnhapJpanl
     */
    public FromLichThi() throws ClassNotFoundException {
        initComponents();
       if(ThiTHPTFrame.ts!=null){
        initTable();}
    }
public void setBg(Color a){
this.setBackground(a);
this.TBLichThi.setBackground(a);
this.jPanel1.setBackground(a);
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBLichThi = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lịch Thi Của Thí Sinh");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new java.awt.BorderLayout());

        TBLichThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TBLichThi);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBLichThi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void initTable() throws ClassNotFoundException {
        Vector column = new Vector(1);
        column.add("Tên Môn");
        column.add("Hệ Số");
        column.add("Ngày Thi");
        column.add("Giờ Thi");
        column.add("Phòng Thi");
     DefaultTableModel  model = new DefaultTableModel( ThiTHPTFrame.ts.XemLichThi(),column);
        TBLichThi.setModel(model);
        }

       
    }

