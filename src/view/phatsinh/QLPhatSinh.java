/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.phatsinh;

import dao.ChiNhanhDao;
import dao.NhanVienDao;
import dao.PhatSinhDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiNhanh;
import model.NhanVien;
import model.PhatSinh;

/**
 *
 * @author ThinkKING
 */
public class QLPhatSinh extends javax.swing.JFrame {

    private PhatSinhDao phatSinhDao = new PhatSinhDao();
    private PhatSinh psEdit;
    private NhanVienDao nhanVienDao = new NhanVienDao();
    DefaultTableModel tableModel;
    public QLPhatSinh() {
        initComponents();
        this.setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tablePS.getModel();
        loadTable(phatSinhDao.findAll());
    }
    
    public void loadTable(List<PhatSinh> list) {
        tableModel.setRowCount(0 );
        for (PhatSinh ps : list) {
            tableModel.addRow(new Object[]{
                ps.getPhieu(),
                ps.getNgay(),
                ps.getLoai(),
                ps.getHotenKH(),
                ps.getThanhtien(),
                ps.getNv().getMaNV()
            });
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
        MaPS = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        HotenKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        MaNV = new javax.swing.JTextField();
        Tìm = new javax.swing.JButton();
        Thêm = new javax.swing.JButton();
        Sửa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePS = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã phát sinh:");

        MaPS.setEditable(false);

        jLabel2.setText("Họ tên khách hàng:");

        jLabel3.setText("Mã Nhân viên:");

        Tìm.setText("Tìm");
        Tìm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TìmActionPerformed(evt);
            }
        });

        Thêm.setText("Thêm");
        Thêm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThêmActionPerformed(evt);
            }
        });

        Sửa.setText("Sửa");
        Sửa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SửaActionPerformed(evt);
            }
        });

        tablePS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Phieu", "Ngay", "Loai", "Ho ten KH", "Thanh Tien", "Ma NV"
            }
        ));
        jScrollPane2.setViewportView(tablePS);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(76, 76, 76)
                                .addComponent(MaPS, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HotenKH)
                                    .addComponent(MaNV))))
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Tìm, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sửa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(Thêm, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(MaPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tìm)
                    .addComponent(Thêm))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(HotenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sửa))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TìmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TìmActionPerformed
        // TODO add your handling code here:
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNV(Integer.parseInt(MaNV.getText()));
        List<PhatSinh> list = phatSinhDao.search(
                new PhatSinh(
                        MaPS.getText(),
                        null,
                        null,
                        HotenKH.getText(),
                        (float) 0.0,
                        nhanVien
                )
        );
        
        loadTable(list);
    }//GEN-LAST:event_TìmActionPerformed

    private void ThêmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThêmActionPerformed
        // TODO add your handling code here:
        ThemPhatSinh themPhatSinh = new ThemPhatSinh(this, rootPaneCheckingEnabled);
        themPhatSinh.setVisible(true);
        themPhatSinh.setLocationRelativeTo(null);
    }//GEN-LAST:event_ThêmActionPerformed

    private void SửaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SửaActionPerformed
        // TODO add your handling code here:
        try {
            String id = tableModel.getValueAt(tablePS.getSelectedRow(), 0).toString();
            psEdit = phatSinhDao.findByPhieu(id);
            SuaPhatSinh suaPs = new SuaPhatSinh(this, rootPaneCheckingEnabled);
            suaPs.setVisible(true);
            suaPs.setLocationRelativeTo(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn phat sinh ?");
        }
    }//GEN-LAST:event_SửaActionPerformed

    public PhatSinh getPsEdit() {
        return psEdit;
    }

    public void setPsEdit(PhatSinh psEdit) {
        this.psEdit = psEdit;
    }
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
            java.util.logging.Logger.getLogger(QLPhatSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLPhatSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLPhatSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLPhatSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLPhatSinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HotenKH;
    private javax.swing.JTextField MaNV;
    private javax.swing.JTextField MaPS;
    private javax.swing.JButton Sửa;
    private javax.swing.JButton Thêm;
    private javax.swing.JButton Tìm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablePS;
    // End of variables declaration//GEN-END:variables
}
