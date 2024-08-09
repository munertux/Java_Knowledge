package Paneles.Login;


import Concesionario.Main;
import Info.Credenciales;
import MenuPanels.Menu_Gerente;
import Operaciones.Crud_txt;
import Tipografias.Fuentes;
import java.util.ArrayList;
import java.util.List;

public class Login extends javax.swing.JPanel {

    Fuentes tipoFuente;
    Credenciales credenciales = new Credenciales();
    List<Credenciales> lista_credenciales = new ArrayList<Credenciales>();
    public static String panel;
    public Login(){
        initComponents();
        inicializar();

        //Mensaje.setVisible(true);
    }
    public void inicializar(){
        lista_credenciales = new ArrayList<Credenciales>();

        Crud_txt lector = new Crud_txt();

        lista_credenciales = lector.leer_Login_U();
        
        tipoFuente = new Fuentes();

        Mensaje.setFont(tipoFuente.fuente(tipoFuente.Inter, 0, 18));
        panel=null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user_jp = new javax.swing.JTextField();
        password_jp = new javax.swing.JPasswordField();
        Mensaje = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_jp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        user_jp.setBorder(null);
        add(user_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 340, 40));

        password_jp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        password_jp.setBorder(null);
        add(password_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 340, 50));

        Mensaje.setForeground(new java.awt.Color(255, 255, 255));
        add(Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 340, -1));

        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 360, 60));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Login.png"))); // NOI18N
        add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (credenciales.ValidarUsuario(lista_credenciales, user_jp.getText(), new String(password_jp.getPassword()))) {
            Mensaje.setText("");            
            
            user_jp.setText("");
            password_jp.setText("");
            
            Main.ShowPanel(panel);
            
            inicializar();

        } else {
            Mensaje.setText("Contraseña o usuario invalidos.");
            user_jp.setText("");
            password_jp.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Mensaje;
    private javax.swing.JButton jButton1;
    private javax.swing.JPasswordField password_jp;
    private javax.swing.JTextField user_jp;
    // End of variables declaration//GEN-END:variables
}
