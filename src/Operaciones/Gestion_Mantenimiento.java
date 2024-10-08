
package Operaciones;

import Operaciones.*;
import Paneles.Inventario.*;
import Concesionario.Main;
import Info.Credenciales;
import Info.Inventario;
import Info.Mantenimiento;
import Operaciones.Busqueda;
import Operaciones.Crud_txt;
import static Paneles.Login.Login.panel;
import Paneles.Mantenimiento.Agendar_man;
import Tipografias.Fuentes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Stephen
 */
public class Gestion_Mantenimiento extends javax.swing.JPanel {

    /**
     * Creates new form Gerente_inv
     */
    static DefaultTableModel modelo;

    public static List<Mantenimiento> Mantenimientos = new ArrayList<Mantenimiento>();
    public static int indice;
    
    public Gestion_Mantenimiento() {
        initComponents();
        inicializar();

    }

    public static void inicializar() {
        Mantenimientos = new ArrayList<Mantenimiento>();
        Crud_txt lector = new Crud_txt();
        Mantenimientos = lector.leer_Mantenimiento();
        modelo = (DefaultTableModel) TablaInv.getModel();
        modelo.setRowCount(0);
        BarraBusqueda.setText("");
        //System.out.println(ListaInventario.get(0).getMarca() +" "+ListaInventario.get(0).getModelo()+" "+ListaInventario.get(0).getAbs()+" "+ListaInventario.get(0).getAireA()+" "+ListaInventario.get(0).getCilindraje()+" "+ListaInventario.get(0).getCombustible()+" "+ListaInventario.get(0).getDireccion()+" "+ListaInventario.get(0).getEspEle()+" "+ListaInventario.get(0).getF_fabricacion()+" "+ListaInventario.get(0).getImagen()+" "+ListaInventario.get(0).getKilometraje()+" "+ListaInventario.get(0).getPantTac()+" "+ListaInventario.get(0).getPlaca()+" "+ListaInventario.get(0).getPrecio()+" "+ListaInventario.get(0).getSensor()+" "+ListaInventario.get(0).getTransmision()+" "+ListaInventario.get(0).getVelmax()+" "+ListaInventario.get(0).getVidriosEl());
        int contador = 0;
        for (Mantenimiento item : Mantenimientos) {

            Object[] rowData = {
                item.getMecanico(),
                item.getFecha(),
                item.getHora(),
                item.getServicio(),
                item.getNombresCliente(),
                item.getValor(),
                contador

            };
            modelo.addRow(rowData);
            contador++;
        }
        //busqueda();
    }
/*
    public static void busqueda() {
        Busqueda.indices.clear();
        modelo.setRowCount(0);

        List<Inventario> resultado = Busqueda.filtrar(ListaInventario, Filtro_jp.getSelectedItem().toString(), BarraBusqueda.getText(), Filtro_Vendidos.isSelected());
        System.out.println(resultado.size());

        //System.out.println(ListaInventario.get(0).getMarca() +" "+ListaInventario.get(0).getModelo()+" "+ListaInventario.get(0).getAbs()+" "+ListaInventario.get(0).getAireA()+" "+ListaInventario.get(0).getCilindraje()+" "+ListaInventario.get(0).getCombustible()+" "+ListaInventario.get(0).getDireccion()+" "+ListaInventario.get(0).getEspEle()+" "+ListaInventario.get(0).getF_fabricacion()+" "+ListaInventario.get(0).getImagen()+" "+ListaInventario.get(0).getKilometraje()+" "+ListaInventario.get(0).getPantTac()+" "+ListaInventario.get(0).getPlaca()+" "+ListaInventario.get(0).getPrecio()+" "+ListaInventario.get(0).getSensor()+" "+ListaInventario.get(0).getTransmision()+" "+ListaInventario.get(0).getVelmax()+" "+ListaInventario.get(0).getVidriosEl());
        for (Inventario item : resultado) {
            String[] rowData = {
                item.getMarca(),
                item.getModelo(),
                item.getF_fabricacion(),
                item.getCilindraje(),
                item.getPlaca(),
                item.getPrecio(),
                item.getKilometraje(),
                item.getStatus()
            };
            modelo.addRow(rowData);
        }
        for (int i = 0; i < modelo.getRowCount(); i++) {

            modelo.setValueAt(Busqueda.indices.get(i), i, 8); // Columna 7 (índice 6)
        }

    }

*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ficha_jp = new javax.swing.JButton();
        eliminar_jp = new javax.swing.JButton();
        agregar_jp = new javax.swing.JButton();
        editar_jp = new javax.swing.JButton();
        BarraBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaInv = new javax.swing.JTable();
        Filtro_jp = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ficha_jp.setBackground(new java.awt.Color(27, 46, 62));
        ficha_jp.setBorder(null);
        ficha_jp.setContentAreaFilled(false);
        ficha_jp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ficha_jpActionPerformed(evt);
            }
        });
        add(ficha_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 662, 186, 50));

        eliminar_jp.setBackground(new java.awt.Color(27, 46, 62));
        eliminar_jp.setForeground(new java.awt.Color(27, 46, 62));
        eliminar_jp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Elementos/Eliminar_Boton.png"))); // NOI18N
        eliminar_jp.setBorder(null);
        eliminar_jp.setContentAreaFilled(false);
        eliminar_jp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_jpActionPerformed(evt);
            }
        });
        add(eliminar_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(927, 662, 184, 50));

        agregar_jp.setBackground(new java.awt.Color(27, 46, 62));
        agregar_jp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Elementos/Agregar_Boton.png"))); // NOI18N
        agregar_jp.setBorder(null);
        agregar_jp.setContentAreaFilled(false);
        agregar_jp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_jpActionPerformed(evt);
            }
        });
        add(agregar_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 662, 190, 50));

        editar_jp.setBackground(new java.awt.Color(27, 46, 62));
        editar_jp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Elementos/Editar_Boton.png"))); // NOI18N
        editar_jp.setBorder(null);
        editar_jp.setContentAreaFilled(false);
        editar_jp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_jpActionPerformed(evt);
            }
        });
        add(editar_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 662, 190, 50));

        BarraBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BarraBusqueda.setBorder(null);
        BarraBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarraBusquedaActionPerformed(evt);
            }
        });
        BarraBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BarraBusquedaKeyReleased(evt);
            }
        });
        add(BarraBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 230, 20));

        TablaInv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mecanico", "Fecha", "Hora", "Servicio", "Cliente", "Valor", "#"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaInv);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 880, 430));

        Filtro_jp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marca", "Modelo", "F_Fabricacion", "Cilindraje", "Placa", "Precio", "Kilometraje" }));
        Filtro_jp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Filtro_jpItemStateChanged(evt);
            }
        });
        add(Filtro_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 125, 150, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar Por");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 125, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Panel_man.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BarraBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarraBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarraBusquedaActionPerformed

    private void agregar_jpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_jpActionPerformed

            Agendar_man.accion="Agendar";
            Main.ShowPanel("Agendar_man");
        

    }//GEN-LAST:event_agregar_jpActionPerformed

    private void ficha_jpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ficha_jpActionPerformed
        
        /*
        int fila = TablaInv.getSelectedRow();
        
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.INFORMATION_MESSAGE);

        } else {
            int elemento = (int) (TablaInv.getValueAt(fila, 8));
            indice=elemento;
            Main.ShowPanel("VerFicha_inv");
            Main.verficha_inv.Inicializar(ListaInventario.get(elemento).getMarca(), ListaInventario.get(elemento).getModelo(), ListaInventario.get(elemento).getF_fabricacion(), ListaInventario.get(elemento).getPlaca(), ListaInventario.get(elemento).getTransmision(), ListaInventario.get(elemento).getCombustible(), ListaInventario.get(elemento).getCilindraje(), ListaInventario.get(elemento).getAbs(), ListaInventario.get(elemento).getSensor(), ListaInventario.get(elemento).getAireA(), ListaInventario.get(elemento).getVidriosEl(), ListaInventario.get(elemento).getPantTac(), ListaInventario.get(elemento).getDireccion(), ListaInventario.get(elemento).getEspEle(), ListaInventario.get(elemento).getVelmax(), ListaInventario.get(elemento).getKilometraje(), ListaInventario.get(elemento).getImagen(), ListaInventario.get(elemento).getPrecio());

        }
*/

    }//GEN-LAST:event_ficha_jpActionPerformed

    private void editar_jpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_jpActionPerformed
/*
        if (Filtro_Vendidos.isSelected() == false) {

            int fila = TablaInv.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.INFORMATION_MESSAGE);

            } else {
                int elemento = (int) TablaInv.getValueAt(fila, 8);
                Main.ShowPanel("Editar_inv");
                Main.editar_inv.Inicializar(elemento, ListaInventario, ListaInventario.get(elemento).getMarca(), ListaInventario.get(elemento).getModelo(), ListaInventario.get(elemento).getF_fabricacion(), ListaInventario.get(elemento).getPlaca(), ListaInventario.get(elemento).getTransmision(), ListaInventario.get(elemento).getCombustible(), ListaInventario.get(elemento).getCilindraje(), ListaInventario.get(elemento).getAbs(), ListaInventario.get(elemento).getSensor(), ListaInventario.get(elemento).getAireA(), ListaInventario.get(elemento).getVidriosEl(), ListaInventario.get(elemento).getPantTac(), ListaInventario.get(elemento).getDireccion(), ListaInventario.get(elemento).getEspEle(), ListaInventario.get(elemento).getVelmax(), ListaInventario.get(elemento).getKilometraje(), ListaInventario.get(elemento).getImagen(), ListaInventario.get(elemento).getPrecio());

            }
        }
        */
        
    }//GEN-LAST:event_editar_jpActionPerformed

    private void eliminar_jpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_jpActionPerformed

        
            int fila = TablaInv.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.INFORMATION_MESSAGE);

            } else {
                int elemento = (int) TablaInv.getValueAt(fila, 6);
                Agendar_man.accion="Eliminar";
                Agendar_man.elemento=elemento;
                Main.ShowPanel("Agendar_man");
                               
            }
        

    }//GEN-LAST:event_eliminar_jpActionPerformed

    private void BarraBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarraBusquedaKeyReleased
        //busqueda();

    }//GEN-LAST:event_BarraBusquedaKeyReleased

    private void Filtro_jpItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Filtro_jpItemStateChanged
       // busqueda();
    }//GEN-LAST:event_Filtro_jpItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField BarraBusqueda;
    private static javax.swing.JComboBox<String> Filtro_jp;
    private static javax.swing.JTable TablaInv;
    private javax.swing.JButton agregar_jp;
    private javax.swing.JButton editar_jp;
    private javax.swing.JButton eliminar_jp;
    private javax.swing.JButton ficha_jp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
