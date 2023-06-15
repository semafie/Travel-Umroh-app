/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import entity.Paket;
import javax.swing.JFrame;
import repository.PaketRepository;
import view.panel.PaketForm;

/**
 *
 * @author adzaz
 */
public class DialogEditPaket extends Dialog {
    PaketRepository paketRepo = new PaketRepository();
    Paket pkt = new Paket();
    PaketForm pf = new PaketForm();
    private int id = PaketForm.id;
    /**
     * Creates new form DialogEditPaket
     */
    public DialogEditPaket(JFrame fram) {
        super(fram);
        initComponents();
        setValue();
    }
    public void setValue(){
    
   
    for(Paket paket:paketRepo.getByid(id)){
         String menu = paket.getMenu();
        String start = paket.getStart();
        String harga = String.valueOf(paket.getHarga());
        String diskon = String.valueOf(paket.getDiskon());
        String minimDp = String.valueOf(paket.getMinimDp());
       txtNama.setText(paket.getNama());
       txtDesc.setText(paket.getDeskripsi());
       txtHarga.setText(harga);
       txtDiskon.setText(diskon);
       txtMinimDp.setText(minimDp);
       lblId.setText(String.valueOf(paket.getId()));
       if(menu.equals("umrah")){
           rdUmrah.setSelected(true);
       }else if(menu.equals("haji")){
           rdHaji.setSelected(true);
       }else if(menu.equals("wisata halal")){
           rdWisataHalal.setSelected(true);
       }
        System.out.println(menu);
        System.out.println(paket.getNama());
       if(start.equals("Jakarta") ){
           rdJakarta.setSelected(true);
       }else if(start.equals("Surabaya")){
           rdSurabaya.setSelected(true);
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

        MenuGroup = new javax.swing.ButtonGroup();
        MenuStart = new javax.swing.ButtonGroup();
        lblId = new javax.swing.JLabel();
        txtMinimDp = new javax.swing.JTextField();
        txtDiskon = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        btnEdit = new javax.swing.JLabel();
        btnBatal = new javax.swing.JLabel();
        rdHaji = new javax.swing.JRadioButton();
        rdWisataHalal = new javax.swing.JRadioButton();
        rdUmrah = new javax.swing.JRadioButton();
        rdJakarta = new javax.swing.JRadioButton();
        rdSurabaya = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 260, 40));

        txtMinimDp.setBorder(null);
        getContentPane().add(txtMinimDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 345, 240, 40));

        txtDiskon.setBorder(null);
        getContentPane().add(txtDiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 240, 40));

        txtHarga.setBorder(null);
        getContentPane().add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 240, 40));

        txtNama.setBorder(null);
        getContentPane().add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 300, 40));

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        txtDesc.setBorder(null);
        jScrollPane1.setViewportView(txtDesc);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 300, 110));

        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, 160, 30));

        btnBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBatalMouseClicked(evt);
            }
        });
        getContentPane().add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 160, 30));

        MenuGroup.add(rdHaji);
        rdHaji.setText("Umrah");
        getContentPane().add(rdHaji, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 129, 20, 20));

        MenuGroup.add(rdWisataHalal);
        rdWisataHalal.setText("Umrah");
        getContentPane().add(rdWisataHalal, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 129, 20, 20));

        MenuGroup.add(rdUmrah);
        rdUmrah.setText("Umrah");
        getContentPane().add(rdUmrah, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 128, 20, -1));

        MenuStart.add(rdJakarta);
        getContentPane().add(rdJakarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 188, -1, -1));

        MenuStart.add(rdSurabaya);
        getContentPane().add(rdSurabaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 190, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/edit paket.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 552));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseClicked
        closeMessage();
    }//GEN-LAST:event_btnBatalMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        int id = Integer.valueOf(lblId.getText());
        String nama = txtNama.getText();
        String start = "";
        String menu = "";
        String desc = txtDesc.getText();
        int harga = Integer.valueOf(txtHarga.getText());
        int diskon = Integer.valueOf(txtDiskon.getText());
        int minimDp = Integer.valueOf(txtMinimDp.getText());
        
        if(rdHaji.isSelected()){
            menu = "Haji";
        }else if(rdUmrah.isSelected()){
            menu = "Umrah";
        }else if(rdWisataHalal.isSelected()){
            menu = "Wisata Halal";
        }
        
        if(rdSurabaya.isSelected()){
            start = "Surabaya";
        }else if(rdJakarta.isSelected()){
            start = "Jakarta";
        }
        
        Paket paket = new Paket(id, menu, start, nama, desc, minimDp, harga, diskon);
        boolean edit = paketRepo.update(paket);
        
        if(edit){
            System.out.println("Berhasil");
            closeMessage();
     
    
            
            
        }else{
            System.out.println("gagal");
        }
        
    }//GEN-LAST:event_btnEditMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup MenuGroup;
    private javax.swing.ButtonGroup MenuStart;
    private javax.swing.JLabel btnBatal;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JRadioButton rdHaji;
    private javax.swing.JRadioButton rdJakarta;
    private javax.swing.JRadioButton rdSurabaya;
    private javax.swing.JRadioButton rdUmrah;
    private javax.swing.JRadioButton rdWisataHalal;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtDiskon;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtMinimDp;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}