/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import entity.User;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import repository.UserRepository;
import view.panel.Pegawai;

/**
 *
 * @author adzaz
 */
public class DialogEditPegawai extends Dialog {
    UserRepository userRepo = new UserRepository();
    private int id = Pegawai.id;
    private String newPath = "";
    private String Path ;
    /**
     * Creates new form DialogEditPegawai
     */
    public DialogEditPegawai(JFrame fram) {
        super(fram);
        initComponents();
        setValue();
    }
    
    public void setValue(){
        for(User usr:userRepo.getById(id)){
            txtNama.setText(usr.getNama());
            txtEmail.setText(usr.getEmail());
            txtUsername.setText(usr.getUsername());
            txtAlamat.setText(usr.getAlamat());
            txtIdCard.setText(String.valueOf(usr.getICard()));
            cmbJenisKelamin.setSelectedItem(usr.getJenisKelamin());
            lblId.setText(String.valueOf(usr.getId()));
            
            try {
                String pathDb = usr.getFoto();
                String path = "D:/RahmatanTravel/"+pathDb;
                Path = pathDb;
                File f = new File(path);
                ImageIcon icon = new ImageIcon(f.toString());
                Image image = icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(image);
                lblFoto.setIcon(ic);
            } catch (Exception e) {
                System.out.println(e);
            }
            
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

        txtEmail = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtIdCard = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        txtNotelp = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        cmbJenisKelamin = new javax.swing.JComboBox<>();
        lblFoto = new javax.swing.JLabel();
        btnTambah = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEmail.setBorder(null);
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 280, 50));

        txtUsername.setBorder(null);
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 290, 50));

        txtIdCard.setBorder(null);
        getContentPane().add(txtIdCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 290, 45));

        txtAlamat.setBorder(null);
        getContentPane().add(txtAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, 290, 45));

        txtNotelp.setBorder(null);
        getContentPane().add(txtNotelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 290, 45));

        txtNama.setBorder(null);
        getContentPane().add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 290, 45));

        cmbJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "laki-laki", "perempuan" }));
        getContentPane().add(cmbJenisKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 300, 40));
        getContentPane().add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 240, 300));

        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        getContentPane().add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 445, 150, 30));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 90, 40));

        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 540, 140, 30));
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 280, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/edit pegawai.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
         String nama = txtNama.getText();
        String role = "employee";
        String pass = "12345678";
        String noTelp = txtNotelp.getText();
        String alamat = txtAlamat.getText();
        String username = txtUsername.getText();
        String email = txtEmail.getText();
        String jenisKelamin = String.valueOf(cmbJenisKelamin.getSelectedItem());
        String idCard = txtIdCard.getText();
        int id = Integer.valueOf(lblId.getText());
        if(newPath.equals("")){
            User user = new User(nama, username, role, pass, email, alamat, noTelp, Path, jenisKelamin, idCard);
            boolean update = userRepo.update(user);
            if(update){
                System.out.println("berhasil di update");
                closeMessage();
            }else{
                System.out.println("gagal");
            }
        }else{
            try{
            File sourceFile = new File(Path);
            File fileDelete = new File("D:/RahmatanTravel/"+sourceFile);

            if(fileDelete.exists()){
                boolean deleteImage = fileDelete.delete();
                if(deleteImage){
                    System.out.println("foto berhasil di hapus");
                }else{
                    System.out.println("foto gagal di hapus");
                }
            }
            String pathFolder = "src/upload";
            File fileAwal = null;
            File fileAkhir = null;
            String ext = newPath.substring(newPath.lastIndexOf('.')+1);
            fileAwal = new File(newPath);
            fileAkhir = new File(pathFolder+"/"+txtUsername.getText()+"."+ext);
            
            User user = new User(nama, username, role, pass, email, alamat, noTelp, fileAkhir.toString(), jenisKelamin, idCard);
            user.setId(id);
            boolean update = userRepo.update(user);
            if(update){
                System.out.println("Berhasil di update");
                Files.copy(fileAwal.toPath(), fileAkhir.toPath());
                closeMessage();
            }else{
                System.out.println("gagal di update");
            }
            }catch(Exception e){
                    System.out.println(e);
             }
        }

    }//GEN-LAST:event_btnEditMouseClicked

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
         try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(f.toString());
            Image img = icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon ic = new ImageIcon(img);
            lblFoto.setIcon(ic);
            newPath = f.getAbsolutePath();
            System.out.println(newPath);
             System.out.println(Path);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnTambahMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JComboBox<String> cmbJenisKelamin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdCard;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNotelp;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}