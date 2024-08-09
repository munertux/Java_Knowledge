package Paneles.Inventario;

import Concesionario.Main;
import Operaciones.Crud_txt;
import Tipografias.Fuentes;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VerFicha_inv extends javax.swing.JPanel {

    Fuentes tipoFuente;
    static String Imagen;
    public static String Volver_Clase;
    public VerFicha_inv() {
        initComponents();
        tipoFuente = new Fuentes();
        VelMaxT_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, 40));
        CilindrajeT_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, 40));
        TransmisionT_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, 35));
        PrecioT_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, 40));
        TituloT_jp.setFont(tipoFuente.fuente(tipoFuente.Racing, 1, 40));

        int tamanio = 12;
        Marca_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        Modelo_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        F_fabricacion_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        Placa_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        Transmision_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        Combustible_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        Cilindraje_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        Abs_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        Sensor_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        AireA_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        VidriosEl_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        PantTac_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        Direccion_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        EspEle_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        Kilometraje_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        Precio_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));
        VelMax_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamanio));

    }

    public void Vaciar() {
        Marca_jp.setText("");
        Modelo_jp.setText("");
        F_fabricacion_jp.setText("");
        Placa_jp.setText("");
        Transmision_jp.setText("");
        Combustible_jp.setText("");
        Cilindraje_jp.setText("");
        VelMax_jp.setText("");
        Kilometraje_jp.setText("");
        Imagen = null;
        Precio_jp.setText("");
        TituloT_jp.setText("");
        PrecioT_jp.setText("");
        VelMaxT_jp.setText("");
        CilindrajeT_jp.setText("");
        TransmisionT_jp.setText("");
        Imagen_jp.setIcon(null);

    }

    public void Inicializar(String marca, String modelo, String f_fabricacion, String placa, String transmision, String combustible, String cilindraje, String abs, String sensor, String AireA, String vidriosEl, String PantTac, String direccion, String EspEle, String velmax, String kilometraje, String Imagen, String precio) {

        Marca_jp.setText(marca);
        Modelo_jp.setText(modelo);
        F_fabricacion_jp.setText(f_fabricacion);
        Placa_jp.setText(placa);
        Transmision_jp.setText(transmision);
        Combustible_jp.setText(combustible);
        Cilindraje_jp.setText(cilindraje);
        Abs_jp.setText(abs);
        Sensor_jp.setText(sensor);
        AireA_jp.setText(AireA);
        VidriosEl_jp.setText(vidriosEl);
        PantTac_jp.setText(PantTac);
        Direccion_jp.setText(direccion);
        EspEle_jp.setText(EspEle);
        Kilometraje_jp.setText(kilometraje);
        Precio_jp.setText(precio);
        VelMax_jp.setText(velmax);
        TituloT_jp.setText(marca + " " + modelo);
        PrecioT_jp.setText(precio);
        VelMaxT_jp.setText(velmax);
        CilindrajeT_jp.setText(cilindraje);
        TransmisionT_jp.setText(transmision);
        SetImage(Imagen_jp, ("src/Imagenes/" + Imagen));
    }

    private void SetImage(JLabel Imagen_jp, String root) {
        ImageIcon image = new ImageIcon(root);
        
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(290, 190, Image.SCALE_DEFAULT));
        Imagen_jp.setIcon(icon);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        Marca_jp = new javax.swing.JLabel();
        Imagen_jp = new javax.swing.JLabel();
        PrecioT_jp = new javax.swing.JLabel();
        TransmisionT_jp = new javax.swing.JLabel();
        VelMaxT_jp = new javax.swing.JLabel();
        CilindrajeT_jp = new javax.swing.JLabel();
        TituloT_jp = new javax.swing.JLabel();
        AireA_jp = new javax.swing.JLabel();
        VidriosEl_jp = new javax.swing.JLabel();
        PantTac_jp = new javax.swing.JLabel();
        Direccion_jp = new javax.swing.JLabel();
        EspEle_jp = new javax.swing.JLabel();
        Abs_jp = new javax.swing.JLabel();
        Sensor_jp = new javax.swing.JLabel();
        VelMax_jp = new javax.swing.JLabel();
        Cilindraje_jp = new javax.swing.JLabel();
        Combustible_jp = new javax.swing.JLabel();
        Transmision_jp = new javax.swing.JLabel();
        Kilometraje_jp = new javax.swing.JLabel();
        Placa_jp = new javax.swing.JLabel();
        Precio_jp = new javax.swing.JLabel();
        F_fabricacion_jp = new javax.swing.JLabel();
        Modelo_jp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 54, 160, 40));

        Marca_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(Marca_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 224, 110, 20));

        Imagen_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(Imagen_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, 290, 190));

        PrecioT_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(PrecioT_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 405, 280, 40));

        TransmisionT_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(TransmisionT_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 660, 200, 50));

        VelMaxT_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(VelMaxT_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 660, 110, 50));

        CilindrajeT_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(CilindrajeT_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 660, 200, 50));

        TituloT_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(TituloT_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 610, 60));

        AireA_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(AireA_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 110, 20));

        VidriosEl_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(VidriosEl_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 110, 20));

        PantTac_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(PantTac_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 374, 110, 20));

        Direccion_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(Direccion_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 406, 110, 20));

        EspEle_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(EspEle_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 110, 20));

        Abs_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(Abs_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 223, 110, 20));

        Sensor_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(Sensor_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 257, 110, 20));

        VelMax_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(VelMax_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 564, 110, 20));

        Cilindraje_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(Cilindraje_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 533, 110, 20));

        Combustible_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(Combustible_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 502, 110, 20));

        Transmision_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(Transmision_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 110, 20));

        Kilometraje_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(Kilometraje_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 386, 110, 20));

        Placa_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(Placa_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 353, 110, 20));

        Precio_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(Precio_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 110, 20));

        F_fabricacion_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(F_fabricacion_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 287, 110, 20));

        Modelo_jp.setForeground(new java.awt.Color(255, 255, 255));
        add(Modelo_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 254, 110, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/VerFicha_inv.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Vaciar();
        if(Volver_Clase.equals("Inventario")){
        Main.ShowPanel("Gerente_inv");
        }else if(Volver_Clase.equals("Ventas")){
        Main.ShowPanel("Gerente_Ventas");          
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel Abs_jp;
    private static javax.swing.JLabel AireA_jp;
    private static javax.swing.JLabel CilindrajeT_jp;
    private static javax.swing.JLabel Cilindraje_jp;
    private static javax.swing.JLabel Combustible_jp;
    private static javax.swing.JLabel Direccion_jp;
    private static javax.swing.JLabel EspEle_jp;
    private static javax.swing.JLabel F_fabricacion_jp;
    private static javax.swing.JLabel Imagen_jp;
    private static javax.swing.JLabel Kilometraje_jp;
    private static javax.swing.JLabel Marca_jp;
    private static javax.swing.JLabel Modelo_jp;
    private static javax.swing.JLabel PantTac_jp;
    private static javax.swing.JLabel Placa_jp;
    private static javax.swing.JLabel PrecioT_jp;
    private static javax.swing.JLabel Precio_jp;
    private static javax.swing.JLabel Sensor_jp;
    private static javax.swing.JLabel TituloT_jp;
    private static javax.swing.JLabel TransmisionT_jp;
    private static javax.swing.JLabel Transmision_jp;
    private static javax.swing.JLabel VelMaxT_jp;
    private static javax.swing.JLabel VelMax_jp;
    private static javax.swing.JLabel VidriosEl_jp;
    private javax.swing.JButton jButton3;
    private static javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
