package Concesionario;

import MenuPanels.Menu_Gerente;
import Operaciones.Gestion_Ventas;
import Operaciones.Gestion_inv;
import Paneles.Inventario.Agregar_inv;
import Paneles.Inventario.Editar_inv;
import Paneles.Inventario.Eliminar_inv;
import Paneles.Inventario.VerFicha_inv;
import Paneles.Ventas.VerFicha_ven;
import Paneles.Login.Login;
import Paneles.Ventas.Form_ven;

import Tipografias.Fuentes;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class Main extends javax.swing.JFrame {

    Fuentes tipoFuente;

    static Login login = new Login();
    static Gestion_inv gestion_inv = new Gestion_inv();
    static Agregar_inv agregar_inv = new Agregar_inv();
    public static VerFicha_inv verficha_inv = new VerFicha_inv();
    public static Editar_inv editar_inv = new Editar_inv();
    public static Eliminar_inv eliminar_inv = new Eliminar_inv();
    public static Menu_Gerente menu_gerente = new Menu_Gerente();
    public static Gestion_Ventas gestion_ventas = new Gestion_Ventas();
    public static VerFicha_ven verficha_ven = new VerFicha_ven();
public static Form_ven form_ven = new Form_ven();

    public static void ShowPanel(String Panel) {
        JPanel p = null;
        JPanel m = null;
        switch (Panel) {
            case "login":
                p = login;
                break;
            case "Gerente_inv":
                p = gestion_inv;
                m = menu_gerente;
                
                Gestion_inv.inicializar();
                break;
            case "Gerente_Ventas":
                p = gestion_ventas;
                m = menu_gerente;                
                Gestion_Ventas.inicializar();
                
                break;                
            case "Agregar_inv":
                p = agregar_inv;  
                m = menu_gerente;
                break;
              
                
            case "VerFicha_ven":
                m = menu_gerente;
                p = verficha_ven;
                verficha_ven.Volver_Clase="Ventas";

                break;   
                
                
            case "Form_ven":
                m = menu_gerente;
                p = form_ven;
                

                break;                  
            case "VerFicha_inv":
                m = menu_gerente;
                p = verficha_inv;
                verficha_inv.Volver_Clase="Inventario";

                break;
            case "Editar_inv":
                m = menu_gerente;
                p = editar_inv;

                break;
            case "Eliminar_inv":
m = menu_gerente;
                p = eliminar_inv;

                break;

        }
if(Panel!="login")       {
        m.setSize(93, 800);
        m.setLocation(0, 0);
        Menu_Panel.setVisible(true);
        Menu_Panel.removeAll();
        Menu_Panel.add(m, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Menu_Panel.revalidate();
        Menu_Panel.repaint(); 
}else{
Menu_Panel.setVisible(false);
}

        p.setSize(100, 800);
        p.setLocation(0, 0);

        content.removeAll();
        content.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        content.revalidate();
        content.repaint();


        
        

    }

    public Main() {
        initComponents();
        tipoFuente = new Fuentes();

        ShowPanel("login");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu_Panel = new javax.swing.JPanel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu_Panel.setBackground(new java.awt.Color(153, 153, 153));
        Menu_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Menu_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 800));

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setPreferredSize(new java.awt.Dimension(1280, 800));
        content.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Menu_Panel;
    public static javax.swing.JPanel content;
    // End of variables declaration//GEN-END:variables
}
