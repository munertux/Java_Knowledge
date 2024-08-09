/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles.Inventario;

import Concesionario.Main;
import Operaciones.Crud_txt;
import Operaciones.Gestion_inv;

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

/**
 *
 * @author Stephen
 */
public class Agregar_inv extends javax.swing.JPanel {

    Fuentes tipoFuente;
    String Imagen;
    String Tlista; //tamaño de lista
    public Agregar_inv() {
        initComponents();
        tipoFuente = new Fuentes();
        VelMaxT_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, 40));
        CilindrajeT_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, 40));
        TransmisionT_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, 35));
        PrecioT_jp.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, 40));
        TituloT_jp.setFont(tipoFuente.fuente(tipoFuente.Racing, 1, 40));

    }

    private void Inicializar() {
        Abs_jp.setSelectedIndex(0);
        Sensor_jp.setSelectedIndex(0);
        AireA_jp.setSelectedIndex(0);
        VidriosEl_jp.setSelectedIndex(0);
        PantTac_jp.setSelectedIndex(0);
        Direccion_jp.setSelectedIndex(0);
        EspEle_jp.setSelectedIndex(0);
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
        BotonImagen.setIcon(null);

    }

    private void copyFileToDestination(File source, File destination) {
        try {
            // Asegurarse de que el directorio de destino exista
            Files.createDirectories(destination.getParentFile().toPath());
            // Copiar el archivo, reemplazando si ya existe
            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
        }
    }

    private void SetImage(JButton BotonImagen, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(BotonImagen.getWidth(), BotonImagen.getHeight(), Image.SCALE_DEFAULT));
        BotonImagen.setIcon(icon);
        this.repaint();
    }

    private void SetImage(JLabel Imagen_jp, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(Imagen_jp.getWidth(), Imagen_jp.getHeight(), Image.SCALE_DEFAULT));
        Imagen_jp.setIcon(icon);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Precio_jp = new javax.swing.JTextField();
        Placa_jp = new javax.swing.JTextField();
        Kilometraje_jp = new javax.swing.JTextField();
        F_fabricacion_jp = new javax.swing.JTextField();
        Modelo_jp = new javax.swing.JTextField();
        Marca_jp = new javax.swing.JTextField();
        Combustible_jp = new javax.swing.JTextField();
        Transmision_jp = new javax.swing.JTextField();
        VelMax_jp = new javax.swing.JTextField();
        Cilindraje_jp = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        BotonImagen = new javax.swing.JButton();
        PrecioT_jp = new javax.swing.JLabel();
        TransmisionT_jp = new javax.swing.JLabel();
        VelMaxT_jp = new javax.swing.JLabel();
        CilindrajeT_jp = new javax.swing.JLabel();
        TituloT_jp = new javax.swing.JLabel();
        EspEle_jp = new javax.swing.JComboBox<>();
        Direccion_jp = new javax.swing.JComboBox<>();
        PantTac_jp = new javax.swing.JComboBox<>();
        VidriosEl_jp = new javax.swing.JComboBox<>();
        AireA_jp = new javax.swing.JComboBox<>();
        Sensor_jp = new javax.swing.JComboBox<>();
        Abs_jp = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Precio_jp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Precio_jpKeyReleased(evt);
            }
        });
        add(Precio_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 110, -1));
        add(Placa_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 353, 110, -1));
        add(Kilometraje_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 386, 110, -1));
        add(F_fabricacion_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 287, 110, -1));

        Modelo_jp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Modelo_jpKeyReleased(evt);
            }
        });
        add(Modelo_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 254, 110, -1));

        Marca_jp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Marca_jpKeyReleased(evt);
            }
        });
        add(Marca_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 221, 110, -1));
        add(Combustible_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, 110, -1));

        Transmision_jp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Transmision_jpKeyReleased(evt);
            }
        });
        add(Transmision_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 110, -1));

        VelMax_jp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                VelMax_jpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                VelMax_jpKeyTyped(evt);
            }
        });
        add(VelMax_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 560, 110, -1));

        Cilindraje_jp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Cilindraje_jpKeyReleased(evt);
            }
        });
        add(Cilindraje_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, 110, -1));

        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(917, 495, 180, 40));

        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 54, 160, 40));

        BotonImagen.setText("Agregar Imagen");
        BotonImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonImagenActionPerformed(evt);
            }
        });
        add(BotonImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, 290, 190));

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

        EspEle_jp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        add(EspEle_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 438, 110, -1));

        Direccion_jp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        add(Direccion_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 403, 110, -1));

        PantTac_jp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        add(PantTac_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 110, -1));

        VidriosEl_jp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        add(VidriosEl_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 110, -1));

        AireA_jp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        add(AireA_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 110, -1));

        Sensor_jp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        add(Sensor_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 257, 110, -1));

        Abs_jp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        add(Abs_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 223, 110, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Agregar_inv.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Inicializar();
        Gestion_inv.inicializar();
        Main.ShowPanel("Gerente_inv");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void VelMax_jpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VelMax_jpKeyTyped

    }//GEN-LAST:event_VelMax_jpKeyTyped

    private void VelMax_jpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VelMax_jpKeyReleased
        VelMaxT_jp.setText(VelMax_jp.getText());
    }//GEN-LAST:event_VelMax_jpKeyReleased

    private void Transmision_jpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Transmision_jpKeyReleased
        TransmisionT_jp.setText(Transmision_jp.getText());
    }//GEN-LAST:event_Transmision_jpKeyReleased

    private void Cilindraje_jpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cilindraje_jpKeyReleased
        CilindrajeT_jp.setText(Cilindraje_jp.getText());
    }//GEN-LAST:event_Cilindraje_jpKeyReleased

    private void BotonImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonImagenActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione un archivo");

        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            copyFileToDestination(selectedFile, new File("src/Imagenes/" + selectedFile.getName()));
            Imagen = selectedFile.getName();
            SetImage(BotonImagen, ("src/Imagenes/" + selectedFile.getName()));
        }


    }//GEN-LAST:event_BotonImagenActionPerformed

    private void Precio_jpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Precio_jpKeyReleased
        PrecioT_jp.setText(Precio_jp.getText());
    }//GEN-LAST:event_Precio_jpKeyReleased

    private void Marca_jpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Marca_jpKeyReleased


    }//GEN-LAST:event_Marca_jpKeyReleased

    private void Modelo_jpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Modelo_jpKeyReleased

        TituloT_jp.setText(Marca_jp.getText() + " " + Modelo_jp.getText());
    }//GEN-LAST:event_Modelo_jpKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        Crud_txt agregar = new Crud_txt();
        if (Marca_jp.getText().isEmpty()
                || Modelo_jp.getText().isEmpty()
                || F_fabricacion_jp.getText().isEmpty()
                || Placa_jp.getText().isEmpty()
                || Transmision_jp.getText().isEmpty()
                || Combustible_jp.getText().isEmpty()
                || Cilindraje_jp.getText().isEmpty()
                || VelMax_jp.getText().isEmpty()
                || Kilometraje_jp.getText().isEmpty()
                || Imagen == null 
                || Imagen.equals("")
                || Precio_jp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Uno o más campos están vacios", "Datos Vacios", JOptionPane.INFORMATION_MESSAGE);

        } else {
            
            agregar.Agregar_Inventario_U(Marca_jp.getText(), Modelo_jp.getText(), F_fabricacion_jp.getText(), Placa_jp.getText(), Transmision_jp.getText(), Combustible_jp.getText(), Cilindraje_jp.getText(), Abs_jp.getSelectedItem().toString(), Sensor_jp.getSelectedItem().toString(), AireA_jp.getSelectedItem().toString(), VidriosEl_jp.getSelectedItem().toString(), PantTac_jp.getSelectedItem().toString(), Direccion_jp.getSelectedItem().toString(), EspEle_jp.getSelectedItem().toString(), VelMax_jp.getText(), Kilometraje_jp.getText(), Imagen, Precio_jp.getText());
            Inicializar();
            JOptionPane.showMessageDialog(null, "Datos agregados con éxito", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

        }


    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Abs_jp;
    private javax.swing.JComboBox<String> AireA_jp;
    private javax.swing.JButton BotonImagen;
    private javax.swing.JLabel CilindrajeT_jp;
    private javax.swing.JTextField Cilindraje_jp;
    private javax.swing.JTextField Combustible_jp;
    private javax.swing.JComboBox<String> Direccion_jp;
    private javax.swing.JComboBox<String> EspEle_jp;
    private javax.swing.JTextField F_fabricacion_jp;
    private javax.swing.JTextField Kilometraje_jp;
    private javax.swing.JTextField Marca_jp;
    private javax.swing.JTextField Modelo_jp;
    private javax.swing.JComboBox<String> PantTac_jp;
    private javax.swing.JTextField Placa_jp;
    private javax.swing.JLabel PrecioT_jp;
    private javax.swing.JTextField Precio_jp;
    private javax.swing.JComboBox<String> Sensor_jp;
    private javax.swing.JLabel TituloT_jp;
    private javax.swing.JLabel TransmisionT_jp;
    private javax.swing.JTextField Transmision_jp;
    private javax.swing.JLabel VelMaxT_jp;
    private javax.swing.JTextField VelMax_jp;
    private javax.swing.JComboBox<String> VidriosEl_jp;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
