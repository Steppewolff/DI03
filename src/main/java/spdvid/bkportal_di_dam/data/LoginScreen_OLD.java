package spdvid.bkportal_di_dam.data;

import javax.swing.DefaultListModel;
import spdvid.bkportal_di_dam.data.DataAccess;
import spdvid.bkportal_di_dam.data.DataAccess;
import spdvid.bkportal_di_dam.dto.Municipi;
import spdvid.bkportal_di_dam.dto.Usuari;

/**
 *
 * @author Fer
 */
public class LoginScreen_OLD extends javax.swing.JFrame {
    private DataAccess da = new DataAccess();
    private javax.swing.JList<Usuari> lstUsuaris;
    
    /**
     * Creates new form LoginScreen
     */
    public LoginScreen_OLD() {
        initComponents();
        setBounds(100, 100, 600, 500);
        
        lstUsuaris = new javax.swing.JList<>(); 
        scrUsuaris.setViewportView(lstUsuaris);
        lstUsuaris.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuarisValueChanged(evt);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGetUsuaris = new javax.swing.JButton();
        scrUsuaris = new javax.swing.JScrollPane();
        txtUserInfo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnGetUsuaris.setText("Obtener usuarios");
        btnGetUsuaris.setToolTipText("");
        btnGetUsuaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetUsuarisActionPerformed(evt);
            }
        });
        getContentPane().add(btnGetUsuaris);
        btnGetUsuaris.setBounds(150, 30, 120, 23);
        getContentPane().add(scrUsuaris);
        scrUsuaris.setBounds(310, 70, 200, 210);

        txtUserInfo.setText("jTextField1");
        txtUserInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserInfoActionPerformed(evt);
            }
        });
        getContentPane().add(txtUserInfo);
        txtUserInfo.setBounds(311, 290, 200, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetUsuarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetUsuarisActionPerformed
        
        var usuaris = da.getAllUsers();// También serviría si defino el tipo de variable ArrayList<Usuari> = da.getAllUsers();
        DefaultListModel<Usuari> dfm = new DefaultListModel();
        for (Usuari u: usuaris){
            dfm.addElement(u);
        }
        lstUsuaris.setModel(dfm);
    }//GEN-LAST:event_btnGetUsuarisActionPerformed

    private void txtUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserInfoActionPerformed

    }//GEN-LAST:event_txtUserInfoActionPerformed

    private void lstUsuarisValueChanged(javax.swing.event.ListSelectionEvent evt){
        Usuari selectedUsuari = lstUsuaris.getSelectedValue();
        txtUserInfo.setText(selectedUsuari.getNom() + selectedUsuari.getLlinatges());        
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
            java.util.logging.Logger.getLogger(LoginScreen_OLD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen_OLD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen_OLD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen_OLD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen_OLD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGetUsuaris;
    private javax.swing.JScrollPane scrUsuaris;
    private javax.swing.JTextField txtUserInfo;
    // End of variables declaration//GEN-END:variables
}
