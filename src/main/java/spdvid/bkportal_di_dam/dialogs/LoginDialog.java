package spdvid.bkportal_di_dam.dialogs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import spdvid.bkportal_di_dam.MainScreen;
import spdvid.bkportal_di_dam.data.DataAccess;
import spdvid.bkportal_di_dam.dto.Usuari;

/**
 *
 * @author Fer
 */
public class LoginDialog extends javax.swing.JDialog {
    DataAccess da;
    MainScreen JFrameMainScreen;
    
    /**
     * Creates new form LoginDialog
     */
    public LoginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
//        setBounds(600, 200, 300, 200);
        setLocationRelativeTo(parent);
        setSize(new java.awt.Dimension(300, 200));        
//       setVisible(true);
//        this.JFrameMainScreen = JFrameMainScreen;
        da = new DataAccess();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        pwdPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(100, 90, 75, 23);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(100, 10, 170, 22);

        lblUsuario.setText("Contraseña:");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(20, 40, 70, 20);

        lblPassword.setText("Usuario:");
        getContentPane().add(lblPassword);
        lblPassword.setBounds(20, 10, 60, 20);

        pwdPassword.setText("jPasswordField1");
        getContentPane().add(pwdPassword);
        pwdPassword.setBounds(100, 40, 170, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String usuariLogin = null;
        Usuari user = new Usuari();
        int idUsuari = 0;
        char pwdLogin[] = pwdPassword.getPassword();
        usuariLogin = txtUsuario.getText();

        //En la query para bucar en la BDD, se hace una búsqueda que devuelve email (usuario) y contraseña, usando el nombre y la contraseña como filtros, para luego usar el SelectStatement.setString
        String sql = "SELECT * FROM usuari where email=? and password=?";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/etvmallorca", "root", "0Castorp0");
            PreparedStatement selectStatement = conn.prepareStatement(sql);
            
            //Aquí obtendremos True cuando la query encuentre un resultado (exista la combinacion email+password que se busca) y false cuando no 
            selectStatement.setString(1, usuariLogin);
            selectStatement.setString(2, String.copyValueOf(pwdLogin));            
            
            ResultSet resultset = selectStatement.executeQuery();            

            //Si el resultado es True se permitirá el login, sino se rechazará
            if (resultset.next()){
                dispose();
                user.setId (resultset.getInt("id"));
                user.setNom(resultset.getString("nom"));
                user.setLlinatges(resultset.getString("llinatges"));
                user.setEmail(resultset.getString("email"));
                user.setPassword(resultset.getString("password"));
                user.setAdmin(resultset.getBoolean("isAdmin"));
                JOptionPane.showMessageDialog(btnLogin, "Login correcto");
//                JFrameMainScreen.showListaAlojamientos(user);
//                JFrameMainScreen.bienvenidaUsuario(user);
                ((MainScreen)getParent()).userLoggedIn(user);
                setVisible(false);

//                JFrameMainScreen.showDataPanel();
//                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(btnLogin, "Usuario o contraseña incorrectos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginDialog dialog = new LoginDialog(new MainScreen(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
