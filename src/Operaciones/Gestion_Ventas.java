package Operaciones;

import Concesionario.Main;
import Info.Inventario;
import MenuPanels.Menu_Gerente;
import Tipografias.Fuentes;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Gestion_Ventas extends javax.swing.JPanel {
    
    static Fuentes tipoFuente;
    static List<Inventario> ListaInventario = new ArrayList<Inventario>();
    static List<Inventario> ListaInventario_Filtrado = new ArrayList<Inventario>();
    
    static int pagina;
    
    public static void VisibilidadCasillas(boolean VCasilla1, boolean VCasilla2, boolean VCasilla3, boolean VBoton1, boolean VBoton2, boolean VBoton3) {
        Casilla1.setVisible(VCasilla1);
        Casilla2.setVisible(VCasilla2);
        Casilla3.setVisible(VCasilla3);
        
        Boton1.setVisible(VBoton1);
        Boton2.setVisible(VBoton2);
        Boton3.setVisible(VBoton3);
        
    }
    
    public static void inicializar() {
        VaciarTexto();
        pagina = 1;
        tipoFuente = new Fuentes();
        Titulo1.setFont(tipoFuente.fuente(tipoFuente.Racing, 1, 40));
        Titulo2.setFont(tipoFuente.fuente(tipoFuente.Racing, 1, 40));
        Titulo3.setFont(tipoFuente.fuente(tipoFuente.Racing, 1, 40));
        PaginaT.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, 14));
        
        int tamañoFuente = 12;
        
        F_F1.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        Cil1.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        Pla1.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        Pre1.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        Kil1.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        
        F_F2.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        Cil2.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        Pla2.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        Pre2.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        Kil2.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        
        F_F3.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        Cil3.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        Pla3.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        Pre3.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        Kil3.setFont(tipoFuente.fuente(tipoFuente.Inter, 1, tamañoFuente));
        
        ListaInventario = new ArrayList<Inventario>();
        Crud_txt lector = new Crud_txt();
        ListaInventario = lector.leer_Inventario_U();
        ListaInventario_Filtrado = ListaInventario;
        ImageIcon icono;
        AnteriorB.setVisible(false);
        SiguienteB.setVisible(false);
        PaginaT.setText("1");
        BarraBusqueda.setText("");
        //System.out.println(ListaInventario.get(0).getMarca() +" "+ListaInventario.get(0).getModelo()+" "+ListaInventario.get(0).getAbs()+" "+ListaInventario.get(0).getAireA()+" "+ListaInventario.get(0).getCilindraje()+" "+ListaInventario.get(0).getCombustible()+" "+ListaInventario.get(0).getDireccion()+" "+ListaInventario.get(0).getEspEle()+" "+ListaInventario.get(0).getF_fabricacion()+" "+ListaInventario.get(0).getImagen()+" "+ListaInventario.get(0).getKilometraje()+" "+ListaInventario.get(0).getPantTac()+" "+ListaInventario.get(0).getPlaca()+" "+ListaInventario.get(0).getPrecio()+" "+ListaInventario.get(0).getSensor()+" "+ListaInventario.get(0).getTransmision()+" "+ListaInventario.get(0).getVelmax()+" "+ListaInventario.get(0).getVidriosEl());
        imprimir("iniciar");
    }
    
    public static void MostrarTexto(int actual, int casilla) {
        PaginaT.setText(String.valueOf(pagina));
        Inventario item = ListaInventario_Filtrado.get(actual);
        JLabel Casilla1_texto[] = {Titulo1, F_F1, Cil1, Pla1, Pre1, Kil1, Img1};
        JLabel Casilla2_texto[] = {Titulo2, F_F2, Cil2, Pla2, Pre2, Kil2, Img2};
        JLabel Casilla3_texto[] = {Titulo3, F_F3, Cil3, Pla3, Pre3, Kil3, Img3};
        JLabel Set[] = Casilla1_texto;
        
        switch (casilla) {
            case 1:
                Set = Casilla1_texto;
                break;
            case 2:
                Set = Casilla2_texto;
                break;
            case 3:
                Set = Casilla3_texto;
                break;
        }
        
        Set[0].setText((item.getMarca() + " " + item.getModelo()));
        Set[1].setText(item.getF_fabricacion());
        Set[2].setText(item.getCilindraje());
        Set[3].setText(item.getPlaca());
        Set[4].setText(item.getPrecio());
        Set[5].setText(item.getKilometraje());
        Main.gestion_ventas.SetImage(Set[6], ("src/Imagenes/" + item.getImagen()));
        
    }
    
    private void SetImage(JLabel Imagen_jp, String root) {
        ImageIcon image = new ImageIcon(root);
        
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(180, 120, Image.SCALE_DEFAULT));
        Imagen_jp.setIcon(icon);
        this.repaint();
    }
    
    public static void VaciarTexto() {
        
        Img1.setIcon(null);
        Titulo1.setText("");
        F_F1.setText("");
        Cil1.setText("");
        Pla1.setText("");
        Pre1.setText("");
        Kil1.setText("");
        Boton1.setText("");
        
        Img2.setIcon(null);
        Titulo2.setText("");
        F_F2.setText("");
        Cil2.setText("");
        Pla2.setText("");
        Pre2.setText("");
        Kil2.setText("");
        Boton2.setText("");
        
        Img3.setIcon(null);
        Titulo3.setText("");
        F_F3.setText("");
        Cil3.setText("");
        Pla3.setText("");
        Pre3.setText("");
        Kil3.setText("");
        Boton3.setText("");
        
    }
    
    public static void imprimir(String indicador) {
        
        int contador = 0;
        int inicio = 0;
        int limite = 0;
        switch (indicador) {
            case "iniciar":
                inicio = 0;
                limite = 3;
                AnteriorB.setVisible(false);
                
                switch (ListaInventario_Filtrado.size()) {
                    case 0:
                        VisibilidadCasillas(false, false, false, false, false, false);
                        break;
                    case 1:
                        VisibilidadCasillas(true, false, false, true, false, false);
                        break;
                    case 2:
                        VisibilidadCasillas(true, true, false, true, true, false);
                        break;
                    case 3:
                        
                        VisibilidadCasillas(true, true, true, true, true, true);
                        break;
                    
                    default:
                        VisibilidadCasillas(true, true, true, true, true, true);
                        
                        SiguienteB.setVisible(true);
                        
                        break;
                    
                }
                
                break;
            case "siguiente":
                inicio = ((pagina * 3) - 3);
                limite = (pagina * 3);
                break;
            case "anterior":
                inicio = (((pagina) * 3) - 3);
                limite = ((pagina) * 3);
                
                break;
        }
        
        int actual = inicio;
        
        do {
            switch (contador) {
                case 0 -> {
                    MostrarTexto(actual, 1);
                    
                }
                case 1 -> {
                    MostrarTexto(actual, 2);
                    
                }
                case 2 -> {
                    MostrarTexto(actual, 3);
                    
                }
            }
            
            actual++;
            contador++;
            
        } while ((actual <= ListaInventario_Filtrado.size() - 1) && actual < (limite));
        
        switch (contador) {
            
            case 1:
                VisibilidadCasillas(true, false, false, true, false, false);
                
                break;
            case 2:
                VisibilidadCasillas(true, true, false, true, true, false);
                
                break;
            default:
                VisibilidadCasillas(true, true, true, true, true, true);
                
                break;
        }
        
    }
    
    public Gestion_Ventas() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        Filtro_jp = new javax.swing.JComboBox<>();
        BarraBusqueda = new javax.swing.JTextField();
        PaginaT = new javax.swing.JLabel();
        Titulo3 = new javax.swing.JLabel();
        Titulo2 = new javax.swing.JLabel();
        Titulo1 = new javax.swing.JLabel();
        Img3 = new javax.swing.JLabel();
        Img2 = new javax.swing.JLabel();
        Img1 = new javax.swing.JLabel();
        F_F3 = new javax.swing.JLabel();
        Cil3 = new javax.swing.JLabel();
        Pla3 = new javax.swing.JLabel();
        Pre3 = new javax.swing.JLabel();
        Kil3 = new javax.swing.JLabel();
        Pla2 = new javax.swing.JLabel();
        Pre2 = new javax.swing.JLabel();
        Kil2 = new javax.swing.JLabel();
        Cil2 = new javax.swing.JLabel();
        F_F2 = new javax.swing.JLabel();
        Kil1 = new javax.swing.JLabel();
        Pre1 = new javax.swing.JLabel();
        Pla1 = new javax.swing.JLabel();
        F_F1 = new javax.swing.JLabel();
        Cil1 = new javax.swing.JLabel();
        Boton3 = new javax.swing.JButton();
        Boton2 = new javax.swing.JButton();
        Boton1 = new javax.swing.JButton();
        Casilla3 = new javax.swing.JLabel();
        Casilla2 = new javax.swing.JLabel();
        Casilla1 = new javax.swing.JLabel();
        SiguienteB = new javax.swing.JButton();
        AnteriorB = new javax.swing.JButton();
        PanelP = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar Por");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 125, -1, -1));

        Filtro_jp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marca", "Modelo", "F_Fabricacion", "Cilindraje", "Placa", "Precio", "Kilometraje" }));
        Filtro_jp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Filtro_jpItemStateChanged(evt);
            }
        });
        add(Filtro_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 125, 150, -1));

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
        add(BarraBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 210, 20));

        PaginaT.setForeground(new java.awt.Color(255, 255, 255));
        PaginaT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PaginaT.setText("10");
        add(PaginaT, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 710, 50, 20));

        Titulo3.setBackground(new java.awt.Color(255, 255, 255));
        Titulo3.setForeground(new java.awt.Color(255, 255, 255));
        Titulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Titulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 370, 280, 40));

        Titulo2.setBackground(new java.awt.Color(255, 255, 255));
        Titulo2.setForeground(new java.awt.Color(255, 255, 255));
        Titulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 370, 280, 40));

        Titulo1.setBackground(new java.awt.Color(255, 255, 255));
        Titulo1.setForeground(new java.awt.Color(255, 255, 255));
        Titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 280, 40));

        Img3.setForeground(new java.awt.Color(255, 255, 255));
        add(Img3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 220, 180, 120));

        Img2.setForeground(new java.awt.Color(255, 255, 255));
        add(Img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 220, 180, 120));

        Img1.setForeground(new java.awt.Color(255, 255, 255));
        add(Img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 180, 120));

        F_F3.setBackground(new java.awt.Color(255, 255, 255));
        F_F3.setForeground(new java.awt.Color(255, 255, 255));
        F_F3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(F_F3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 425, 110, 20));

        Cil3.setBackground(new java.awt.Color(255, 255, 255));
        Cil3.setForeground(new java.awt.Color(255, 255, 255));
        Cil3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Cil3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 455, 110, 20));

        Pla3.setBackground(new java.awt.Color(255, 255, 255));
        Pla3.setForeground(new java.awt.Color(255, 255, 255));
        Pla3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Pla3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 483, 110, 20));

        Pre3.setBackground(new java.awt.Color(255, 255, 255));
        Pre3.setForeground(new java.awt.Color(255, 255, 255));
        Pre3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Pre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 512, 110, 20));

        Kil3.setBackground(new java.awt.Color(255, 255, 255));
        Kil3.setForeground(new java.awt.Color(255, 255, 255));
        Kil3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Kil3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 540, 110, 20));

        Pla2.setBackground(new java.awt.Color(255, 255, 255));
        Pla2.setForeground(new java.awt.Color(255, 255, 255));
        Pla2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Pla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 483, 110, 20));

        Pre2.setBackground(new java.awt.Color(255, 255, 255));
        Pre2.setForeground(new java.awt.Color(255, 255, 255));
        Pre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Pre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 512, 110, 20));

        Kil2.setBackground(new java.awt.Color(255, 255, 255));
        Kil2.setForeground(new java.awt.Color(255, 255, 255));
        Kil2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Kil2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 540, 110, 20));

        Cil2.setBackground(new java.awt.Color(255, 255, 255));
        Cil2.setForeground(new java.awt.Color(255, 255, 255));
        Cil2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Cil2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 455, 110, 20));

        F_F2.setBackground(new java.awt.Color(255, 255, 255));
        F_F2.setForeground(new java.awt.Color(255, 255, 255));
        F_F2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(F_F2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 425, 110, 20));

        Kil1.setBackground(new java.awt.Color(255, 255, 255));
        Kil1.setForeground(new java.awt.Color(255, 255, 255));
        Kil1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Kil1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, 110, 20));

        Pre1.setBackground(new java.awt.Color(255, 255, 255));
        Pre1.setForeground(new java.awt.Color(255, 255, 255));
        Pre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Pre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 512, 110, 20));

        Pla1.setBackground(new java.awt.Color(255, 255, 255));
        Pla1.setForeground(new java.awt.Color(255, 255, 255));
        Pla1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Pla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 483, 110, 20));

        F_F1.setBackground(new java.awt.Color(255, 255, 255));
        F_F1.setForeground(new java.awt.Color(255, 255, 255));
        F_F1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(F_F1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 425, 110, 20));

        Cil1.setBackground(new java.awt.Color(255, 255, 255));
        Cil1.setForeground(new java.awt.Color(255, 255, 255));
        Cil1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Cil1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 455, 110, 20));

        Boton3.setBorder(null);
        Boton3.setContentAreaFilled(false);
        Boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3ActionPerformed(evt);
            }
        });
        add(Boton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 580, 163, 50));

        Boton2.setBorder(null);
        Boton2.setContentAreaFilled(false);
        Boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2ActionPerformed(evt);
            }
        });
        add(Boton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 581, 163, 50));

        Boton1.setBorder(null);
        Boton1.setContentAreaFilled(false);
        Boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1ActionPerformed(evt);
            }
        });
        add(Boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 581, 163, 50));

        Casilla3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Elementos/Casillas.png"))); // NOI18N
        add(Casilla3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 203, 300, 445));

        Casilla2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Elementos/Casillas.png"))); // NOI18N
        add(Casilla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 203, 300, 445));

        Casilla1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Elementos/Casillas.png"))); // NOI18N
        add(Casilla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 203, 300, 445));

        SiguienteB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Elementos/SiguienteB.png"))); // NOI18N
        SiguienteB.setBorder(null);
        SiguienteB.setContentAreaFilled(false);
        SiguienteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteBActionPerformed(evt);
            }
        });
        add(SiguienteB, new org.netbeans.lib.awtextra.AbsoluteConstraints(708, 690, 57, 57));

        AnteriorB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Elementos/AnteriorB.png"))); // NOI18N
        AnteriorB.setBorder(null);
        AnteriorB.setContentAreaFilled(false);
        AnteriorB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnteriorBActionPerformed(evt);
            }
        });
        add(AnteriorB, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 691, 57, 57));

        PanelP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Ventas.png"))); // NOI18N
        add(PanelP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));
    }// </editor-fold>//GEN-END:initComponents

    private void BarraBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarraBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarraBusquedaActionPerformed

    private void BarraBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarraBusquedaKeyReleased
        
        ListaInventario_Filtrado = Busqueda.filtrar(ListaInventario, Filtro_jp.getSelectedItem().toString(), BarraBusqueda.getText());
        if (ListaInventario_Filtrado.size() < 3) {
            SiguienteB.setVisible(false);
            AnteriorB.setVisible(false);
        }
        VaciarTexto();
        imprimir("iniciar");
        

    }//GEN-LAST:event_BarraBusquedaKeyReleased

    private void SiguienteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteBActionPerformed
        if ((pagina * 3) <= (ListaInventario_Filtrado.size() - 1)) {
            VaciarTexto();
            if ((((pagina + 1) * 3)) > (ListaInventario_Filtrado.size() - 1)) {
                SiguienteB.setVisible(false);
            }
            
            pagina++;
            AnteriorB.setVisible(true);
            imprimir("siguiente");
        }
    }//GEN-LAST:event_SiguienteBActionPerformed

    private void Filtro_jpItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Filtro_jpItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Filtro_jpItemStateChanged

    private void AnteriorBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnteriorBActionPerformed
        if ((pagina - 1) != 0) {
            VaciarTexto();
            if ((pagina - 1) == 1) {
                AnteriorB.setVisible(false);
            } else {
                AnteriorB.setVisible(true);
            }
            SiguienteB.setVisible(true);
            pagina--;
            
            imprimir("anterior");
        }
    }//GEN-LAST:event_AnteriorBActionPerformed

    private void Boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton1ActionPerformed
        
        int indice = (pagina * 3) - 3;
        Main.verficha_ven.Auto_indice= ListaInventario.indexOf(ListaInventario_Filtrado.get(indice)) ;

        Main.verficha_ven.Inicializar(ListaInventario_Filtrado.get(indice).getMarca(), ListaInventario_Filtrado.get(indice).getModelo(), ListaInventario_Filtrado.get(indice).getF_fabricacion(), ListaInventario_Filtrado.get(indice).getPlaca(), ListaInventario_Filtrado.get(indice).getTransmision(), ListaInventario_Filtrado.get(indice).getCombustible(), ListaInventario_Filtrado.get(indice).getCilindraje(), ListaInventario_Filtrado.get(indice).getAbs(), ListaInventario_Filtrado.get(indice).getSensor(), ListaInventario_Filtrado.get(indice).getAireA(), ListaInventario_Filtrado.get(indice).getVidriosEl(), ListaInventario_Filtrado.get(indice).getPantTac(), ListaInventario_Filtrado.get(indice).getDireccion(), ListaInventario_Filtrado.get(indice).getEspEle(), ListaInventario_Filtrado.get(indice).getVelmax(), ListaInventario_Filtrado.get(indice).getKilometraje(), ListaInventario_Filtrado.get(indice).getImagen(), ListaInventario_Filtrado.get(indice).getPrecio());
        
                
        Main.ShowPanel("VerFicha_ven");

        
    }//GEN-LAST:event_Boton1ActionPerformed

    private void Boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2ActionPerformed
        
        int indice = (pagina * 3) - 2;
                Main.verficha_ven.Auto_indice= ListaInventario.indexOf(ListaInventario_Filtrado.get(indice)) ;

        Main.verficha_ven.Inicializar(ListaInventario_Filtrado.get(indice).getMarca(), ListaInventario_Filtrado.get(indice).getModelo(), ListaInventario_Filtrado.get(indice).getF_fabricacion(), ListaInventario_Filtrado.get(indice).getPlaca(), ListaInventario_Filtrado.get(indice).getTransmision(), ListaInventario_Filtrado.get(indice).getCombustible(), ListaInventario_Filtrado.get(indice).getCilindraje(), ListaInventario_Filtrado.get(indice).getAbs(), ListaInventario_Filtrado.get(indice).getSensor(), ListaInventario_Filtrado.get(indice).getAireA(), ListaInventario_Filtrado.get(indice).getVidriosEl(), ListaInventario_Filtrado.get(indice).getPantTac(), ListaInventario_Filtrado.get(indice).getDireccion(), ListaInventario_Filtrado.get(indice).getEspEle(), ListaInventario_Filtrado.get(indice).getVelmax(), ListaInventario_Filtrado.get(indice).getKilometraje(), ListaInventario_Filtrado.get(indice).getImagen(), ListaInventario_Filtrado.get(indice).getPrecio());
       
        
        Main.ShowPanel("VerFicha_ven");
    
    }//GEN-LAST:event_Boton2ActionPerformed

    private void Boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton3ActionPerformed
        int indice = (pagina * 3) - 1;
                Main.verficha_ven.Auto_indice= ListaInventario.indexOf(ListaInventario_Filtrado.get(indice)) ;

        Main.verficha_ven.Inicializar(ListaInventario_Filtrado.get(indice).getMarca(), ListaInventario_Filtrado.get(indice).getModelo(), ListaInventario_Filtrado.get(indice).getF_fabricacion(), ListaInventario_Filtrado.get(indice).getPlaca(), ListaInventario_Filtrado.get(indice).getTransmision(), ListaInventario_Filtrado.get(indice).getCombustible(), ListaInventario_Filtrado.get(indice).getCilindraje(), ListaInventario_Filtrado.get(indice).getAbs(), ListaInventario_Filtrado.get(indice).getSensor(), ListaInventario_Filtrado.get(indice).getAireA(), ListaInventario_Filtrado.get(indice).getVidriosEl(), ListaInventario_Filtrado.get(indice).getPantTac(), ListaInventario_Filtrado.get(indice).getDireccion(), ListaInventario_Filtrado.get(indice).getEspEle(), ListaInventario_Filtrado.get(indice).getVelmax(), ListaInventario_Filtrado.get(indice).getKilometraje(), ListaInventario_Filtrado.get(indice).getImagen(), ListaInventario_Filtrado.get(indice).getPrecio());
                
                
        Main.ShowPanel("VerFicha_ven");

      
    }//GEN-LAST:event_Boton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton AnteriorB;
    private static javax.swing.JTextField BarraBusqueda;
    private static javax.swing.JButton Boton1;
    private static javax.swing.JButton Boton2;
    private static javax.swing.JButton Boton3;
    private static javax.swing.JLabel Casilla1;
    private static javax.swing.JLabel Casilla2;
    private static javax.swing.JLabel Casilla3;
    private static javax.swing.JLabel Cil1;
    private static javax.swing.JLabel Cil2;
    private static javax.swing.JLabel Cil3;
    private static javax.swing.JLabel F_F1;
    private static javax.swing.JLabel F_F2;
    private static javax.swing.JLabel F_F3;
    private javax.swing.JComboBox<String> Filtro_jp;
    private static javax.swing.JLabel Img1;
    private static javax.swing.JLabel Img2;
    private static javax.swing.JLabel Img3;
    private static javax.swing.JLabel Kil1;
    private static javax.swing.JLabel Kil2;
    private static javax.swing.JLabel Kil3;
    private static javax.swing.JLabel PaginaT;
    private static javax.swing.JLabel PanelP;
    private static javax.swing.JLabel Pla1;
    private static javax.swing.JLabel Pla2;
    private static javax.swing.JLabel Pla3;
    private static javax.swing.JLabel Pre1;
    private static javax.swing.JLabel Pre2;
    private static javax.swing.JLabel Pre3;
    private static javax.swing.JButton SiguienteB;
    private static javax.swing.JLabel Titulo1;
    private static javax.swing.JLabel Titulo2;
    private static javax.swing.JLabel Titulo3;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
