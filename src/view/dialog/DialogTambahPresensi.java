/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import entity.Presensi;
import entity.User;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import repository.PresensiRepository;
import repository.UserRepository;
import util.DateUtil;

/**
 *
 * @author adzaz
 */
public class DialogTambahPresensi extends Dialog {
    DateUtil dateUtil = new DateUtil();
    private String latePresensi = Presensi.LatePresensi;
    UserRepository userRepo = new UserRepository();
    PresensiRepository presensiRepo = new PresensiRepository();
    /**
     * Creates new form DialogTambahPresensi
     */
    public DialogTambahPresensi(JFrame fram) {
        super(fram);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 170, 40));

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 90, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/tambah presensi.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        closeMessage();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        String idCard = txtID.getText();
        try {
            String timeNow = dateUtil.timeNow();
            String dateTime = dateUtil.typeDateTime();
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime);
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date date1 = format.parse(timeNow);
            Date date2 = format.parse(latePresensi);
            
           
            long difference = date1.getTime() - date2.getTime();
            String keterangan;
            if(difference > 0){
                keterangan = "Terlambat";
            }else{
                keterangan = "Masuk";
            }
            int idUser = 0; 
            for(User u:userRepo.getByIdCard(idCard)){
                idUser = u.getId();
            }
           if(idUser == 0){
               System.out.println("Kartu tidak terdaftar");
           }else{
                boolean checkData = presensiRepo.checkData(idUser,dateUtil.dateStart(),dateUtil.dateEnd());
            if(checkData){
                System.out.println("Sudah absen");
            }else{
                User user = new UserRepository().get(idUser);
            Presensi presensi = new Presensi(user, date, keterangan);
            boolean tambah = presensiRepo.add(presensi);
            if(tambah){
                System.out.println("Berhasil");
                closeMessage();
            }else{
                System.out.println("Gagal");
            }
            }
           }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_txtIDActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
