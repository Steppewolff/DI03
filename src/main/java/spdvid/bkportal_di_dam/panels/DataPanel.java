package spdvid.bkportal_di_dam.panels;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import spdvid.bkportal_di_dam.MainScreen;
import spdvid.bkportal_di_dam.data.DataAccess;
import spdvid.bkportal_di_dam.dto.Alojamiento;
import spdvid.bkportal_di_dam.dto.Municipi;
import spdvid.bkportal_di_dam.dto.Servei;
import spdvid.bkportal_di_dam.panels.SecondaryScreen;
import spdvid.evtmallorca.dto.Comentari;

/**
 *
 * @author Fer
 */
public class DataPanel extends javax.swing.JPanel {

    private Alojamiento alojamiento = null;
    private DataAccess da = new DataAccess();
    private MainScreen JFrameMainScreen = null;

    /**
     * Creates new form DataPanel
     */
    public DataPanel(Alojamiento alojamiento, MainScreen JFrameMainScreen) {
        initComponents();
        this.JFrameMainScreen = JFrameMainScreen;
        this.alojamiento = alojamiento;
        setBounds(0, 0, 700, 650);
        
        rellenarCampos();
    }
    
    public void rellenarCampos(){
        txtName.setText(alojamiento.getNom());
        txtAdress.setText(alojamiento.getAdresa());
        txaDescription.setText(alojamiento.getDescripcio());
        initCmbMunicipis();
        spnNumPersones.setValue(alojamiento.getNum_persones());
        txtPrice.setText(Float.toString(alojamiento.getPreu_per_nit()));
        initServeis();
        initComentaris();
        txtValoracio.setText(Float.toString(da.getValoracioAllotjamentAvg(alojamiento.getId())));
        
    }

    private void initCmbMunicipis() {
        var municipis = da.getMunicipis();
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<>();
        for (Municipi m : municipis) {
            cbm.addElement(m.getNom());
        }
        cmbMunicipi.setModel(cbm);
        cmbMunicipi.setSelectedItem(alojamiento.getId_municipi());
    }

    private void initServeis() {
        var serveis = da.getServeisAllotjament(alojamiento.getId());
        for (Servei s : serveis) {
            switch (s.getDescripcio()) {
                case "Piscina":
                    chkService1.setSelected(true);
                    break;
                case "Aire condicionat":
                    chkService2.setSelected(true);
                    break;
                case "Wifi":
                    chkService3.setSelected(true);
                    break;
                case "Aparcament":
                    chkService4.setSelected(true);
                    break;
                case "Admet mascotes":
                    chkService5.setSelected(true);
                    break;
                case "Ascensor":
                    chkService6.setSelected(true);
                    break;
            }
        }
    }
    
    private void initComentaris() {
        var comentaris = da.getComentaris(alojamiento.getId());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (Comentari comentari : comentaris) {
            LocalDateTime dataihora = LocalDateTime.parse(comentari.getDataihora(), dtf);
            txaComentaris.append(comentari.getIdUsuari()
                    + " said:\n " + comentari.getText() + "\nOn "
                    + dataihora.toString() + "\n\n");
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

        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        scrDescription = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        lblAdress = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        lblCity = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        lblGuestNr = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        chkService1 = new javax.swing.JCheckBox();
        chkService2 = new javax.swing.JCheckBox();
        chkService3 = new javax.swing.JCheckBox();
        chkService4 = new javax.swing.JCheckBox();
        chkService5 = new javax.swing.JCheckBox();
        chkService6 = new javax.swing.JCheckBox();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaComentaris = new javax.swing.JTextArea();
        txtValoracio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        spnNumPersones = new javax.swing.JSpinner();
        cmbMunicipi = new javax.swing.JComboBox<>();

        setLayout(null);

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        add(txtName);
        txtName.setBounds(30, 60, 170, 22);

        lblName.setText("Nombre");
        add(lblName);
        lblName.setBounds(30, 40, 200, 16);
        lblName.getAccessibleContext().setAccessibleName("lblName");

        lblDescription.setText("Descripción");
        add(lblDescription);
        lblDescription.setBounds(30, 100, 62, 16);

        txaDescription.setColumns(20);
        txaDescription.setRows(5);
        scrDescription.setViewportView(txaDescription);

        add(scrDescription);
        scrDescription.setBounds(30, 120, 234, 100);

        lblAdress.setText("Dirección");
        add(lblAdress);
        lblAdress.setBounds(310, 40, 60, 16);
        add(txtAdress);
        txtAdress.setBounds(310, 60, 370, 22);

        lblCity.setText("Población");
        add(lblCity);
        lblCity.setBounds(310, 100, 53, 16);

        txtCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityActionPerformed(evt);
            }
        });
        add(txtCity);
        txtCity.setBounds(310, 120, 170, 22);

        lblGuestNr.setText("Nº de huéspedes");
        add(lblGuestNr);
        lblGuestNr.setBounds(310, 170, 90, 16);

        lblPrice.setText("Precio/noche (€)");
        add(lblPrice);
        lblPrice.setBounds(450, 170, 100, 16);

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        add(txtPrice);
        txtPrice.setBounds(450, 190, 64, 22);

        jLabel1.setText("Servicios");
        add(jLabel1);
        jLabel1.setBounds(30, 240, 50, 16);

        chkService1.setText("Piscina");
        add(chkService1);
        chkService1.setBounds(150, 240, 60, 20);

        chkService2.setText("Admite mascotas");
        add(chkService2);
        chkService2.setBounds(150, 270, 130, 20);

        chkService3.setText("AC");
        add(chkService3);
        chkService3.setBounds(300, 240, 130, 20);

        chkService4.setText("Ascensor");
        add(chkService4);
        chkService4.setBounds(300, 270, 71, 20);

        chkService5.setText("Aparcamiento");
        add(chkService5);
        chkService5.setBounds(460, 240, 110, 20);

        chkService6.setText("WiFi");
        add(chkService6);
        chkService6.setBounds(460, 270, 46, 20);

        btnBack.setText("< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(10, 10, 72, 23);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Imatges"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
        );

        add(jPanel1);
        jPanel1.setBounds(20, 300, 320, 270);

        txaComentaris.setColumns(20);
        txaComentaris.setRows(5);
        txaComentaris.setText("Comentaris");
        jScrollPane2.setViewportView(txaComentaris);

        add(jScrollPane2);
        jScrollPane2.setBounds(360, 310, 300, 260);

        txtValoracio.setEditable(false);
        txtValoracio.setText("5");
        add(txtValoracio);
        txtValoracio.setBounds(360, 580, 30, 22);

        jLabel2.setText("stars");
        add(jLabel2);
        jLabel2.setBounds(400, 580, 60, 20);
        add(spnNumPersones);
        spnNumPersones.setBounds(310, 190, 64, 22);

        cmbMunicipi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alaró", "Inca" }));
        add(cmbMunicipi);
        cmbMunicipi.setBounds(490, 120, 190, 22);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        JFrameMainScreen.showListaAlojamientos();
    }//GEN-LAST:event_btnBackActionPerformed

//    public void setTitle(String title){
//        lblTitulo.setText(title);
//    }
    
    public void setName(String name){
        txtName.setText(name);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JCheckBox chkService1;
    private javax.swing.JCheckBox chkService2;
    private javax.swing.JCheckBox chkService3;
    private javax.swing.JCheckBox chkService4;
    private javax.swing.JCheckBox chkService5;
    private javax.swing.JCheckBox chkService6;
    private javax.swing.JComboBox<String> cmbMunicipi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblGuestNr;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JScrollPane scrDescription;
    private javax.swing.JSpinner spnNumPersones;
    private javax.swing.JTextArea txaComentaris;
    private javax.swing.JTextArea txaDescription;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtValoracio;
    // End of variables declaration//GEN-END:variables
}
