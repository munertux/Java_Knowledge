/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles.Mantenimiento;

import Paneles.Inventario.*;
import Concesionario.Main;
import Info.Inventario;
import Info.Mantenimiento;
import Info.Mecanicos;
import Operaciones.Crud_txt;
import Operaciones.Gestion_Mantenimiento;
import Operaciones.Gestion_inv;

import Tipografias.Fuentes;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class Agendar_man extends javax.swing.JPanel {

    int valor = 100000;
    static int duracion = 30;
    static public int elemento;
    static List<Mantenimiento> CitasAgendadas = new ArrayList<Mantenimiento>();
    static List<Mecanicos> Mecanicos = new ArrayList<Mecanicos>();

    public static String accion="Agendar";
    
    Fuentes tipoFuente;
    String Imagen;
    String Tlista; //tamaño de lista
 static ImageIcon icono;
    public Agendar_man() {
        initComponents();
        tipoFuente = new Fuentes();

    }

    private static void actualizarHoras() {

        horaCombo.removeAllItems();
        boolean ocupado = false;

        System.out.println("si pasa");
        // Obtener la fecha seleccionada
        // int dia = (int) diaCombo.getSelectedItem();
        //  int mes = (int) mesCombo.getSelectedItem();
        // int año = (int) añoCombo.getSelectedItem();

        int dia = Integer.parseInt((String) diaCombo.getSelectedItem());
        int mes = Integer.parseInt((String) mesCombo.getSelectedItem());
        int año = Integer.parseInt((String) añoCombo.getSelectedItem());

        System.out.println(dia + " " + mes + " " + año);

        System.out.println("tamaño=" + Mecanicos.size());

        for (Mecanicos mecanico : Mecanicos) {
            System.out.println("Nombre: " + mecanico.getNombre());
            System.out.println("Apellidos: " + mecanico.getApellidos());
            System.out.println("Identificador: " + mecanico.getIdentificador());
            System.out.println("-----------------------");
        }

        String fechaSeleccionada = año + "-" + (mes < 10 ? "0" : "") + mes + "-" + (dia < 10 ? "0" : "") + dia;

        // Obtener horas ocupadas en la fecha seleccionada
        Set<String> horasOcupadas = new HashSet<>();

        for (Mantenimiento cita : CitasAgendadas) {

            if (cita.getFecha().equals(fechaSeleccionada) && Mecanicos.get(Mecanico_jp.getSelectedIndex()).getIdentificador().equals(cita.getIdentificador())) {

                int startMinutes = horaToMinutes(cita.getHora());
                int endMinutes = startMinutes + cita.getDuracion();

                System.out.println(cita.getDuracion());
                for (int i = startMinutes; i < endMinutes; i += 30) {
                    horasOcupadas.add(minutesToHora(i));
                    System.out.println("pruebaaaa" + minutesToHora(i));

                }
            }

        }

        // Añadir horas disponibles
        String[] horasDisponibles = {
            "8:00 AM", "8:30 AM",
            "9:00 AM", "9:30 AM",
            "10:00 AM", "10:30 AM",
            "11:00 AM", "11:30 AM",
            "1:00 PM", "1:30 PM",
            "2:00 PM", "2:30 PM",
            "3:00 PM", "3:30 PM",
            "4:00 PM", "4:30 PM"
        };

        for (String hora : horasDisponibles) {
            int startMinutes = horaToMinutes(hora);
            boolean disponible = true;
            for (int i = startMinutes; i < startMinutes + duracion; i += 30) {
                if (horasOcupadas.contains(minutesToHora(i))) {
                    disponible = false;
                    break;
                }
            }

            if (disponible && startMinutes + duracion <= 17 * 60) {
                horaCombo.addItem(hora);
            }
        }
    }

    // Convertir hora en formato "h:mm AM/PM" a minutos desde la medianoche
    private static int horaToMinutes(String hora) {
        String[] parts = hora.split(":| ");
        int hour = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        String amPm = parts[2];

        if (amPm.equals("PM") && hour != 12) {
            hour += 12;
        } else if (amPm.equals("AM") && hour == 12) {
            hour = 0;
        }

        return hour * 60 + minutes;
    }

    // Convertir minutos desde la medianoche a hora en formato "h:mm AM/PM"
    private static String minutesToHora(int minutes) {
        int hour = minutes / 60;
        int minute = minutes % 60;
        String amPm = hour >= 12 ? "PM" : "AM";

        if (hour > 12) {
            hour -= 12;
        } else if (hour == 0) {
            hour = 12;
        }

        return String.format("%d:%02d %s", hour, minute, amPm);
    }
public void verDatos(){

}
    public void Inicializar() {
        
        
Mecanico_jp.setVisible(true);
Servicio_jp.setVisible(true);
diaCombo.setVisible(true);
mesCombo.setVisible(true);
añoCombo.setVisible(true);
horaCombo.setVisible(true);      
        
        
        
Hora_text.setEditable(false);
Hora_text.setText("");
Hora_text.setVisible(false);

Año_text.setEditable(false);
Año_text.setText("");
Año_text.setVisible(false);

Mes_text.setEditable(false);
Mes_text.setText("");
Mes_text.setVisible(false);

Dia_text.setEditable(false);
Dia_text.setText("");
Dia_text.setVisible(false);

Servicio_text.setEditable(false);
Servicio_text.setText("");
Servicio_text.setVisible(false);

Mecanico_text1.setEditable(false);
Mecanico_text1.setText("");
Mecanico_text1.setVisible(false);



Crud_txt lector = new Crud_txt();
        switch(accion){
            
            case "Agendar":
                       
        NombreCli.setText("");
        ApellidosCli.setText("");
        CelularCli.setText("");
        EmailCli.setText("");
        Valor_jp.setText(String.valueOf(valor));

         lector = new Crud_txt();
        Mecanicos = lector.leer_Login_U_Mecanicos();
        CitasAgendadas = lector.leer_Mantenimiento();
        Mecanico_jp.removeAllItems();
        for (Mecanicos mecanico : Mecanicos) {
            Mecanico_jp.addItem(mecanico.getNombre());
        }

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i <= currentYear + 5; i++) {
            añoCombo.addItem(String.valueOf(i));
        }

        for (int i = 8; i <= 11; i++) {
            horaCombo.addItem(i + ":00 AM");
            horaCombo.addItem(i + ":30 AM");
        }
        for (int i = 1; i <= 4; i++) {
            horaCombo.addItem(i + ":00 PM");
            horaCombo.addItem(i + ":30 PM");
        }

        actualizarHoras();  
        
                break;
            
            case "Eliminar":
        icono = new ImageIcon("src/Interfaces/Eliminar_man.png");
        jLabel2.setIcon(icono);  

Hora_text.setVisible(true);

Año_text.setVisible(true);
Mes_text.setVisible(true);
Dia_text.setVisible(true);
Servicio_text.setVisible(true);
Mecanico_text1.setVisible(true);

Mecanico_jp.setVisible(false);
Servicio_jp.setVisible(false);
diaCombo.setVisible(false);
mesCombo.setVisible(false);
añoCombo.setVisible(false);
horaCombo.setVisible(false);

NombreCli.setEditable(false);
ApellidosCli.setEditable(false);
EmailCli.setEditable(false);
CelularCli.setEditable(false);
Valor_jp.setEditable(false);
        lector = new Crud_txt();
        Mecanicos = lector.leer_Login_U_Mecanicos();
        CitasAgendadas = lector.leer_Mantenimiento();
// Supongamos que quieres extraer los datos del primer elemento de la lista CitasAgendadas
Mantenimiento primeraCita = CitasAgendadas.get(elemento); // Cambia el índice según la cita que quieras mostrar

// Extraer los datos usando los métodos get
String hora = primeraCita.getHora();
String año = primeraCita.getFecha().substring(0, 4); // Suponiendo que la fecha está en formato "yyyy-MM-dd"
String mes = primeraCita.getFecha().substring(5, 7);
String dia = primeraCita.getFecha().substring(8, 10);

String servicio = primeraCita.getServicio();
String mecanico = primeraCita.getIdentificador(); // O nombre del mecánico si se guarda así
String nombreCliente = primeraCita.getNombresCliente();
String apellidosCliente = primeraCita.getApellidosCliente();
String emailCliente = primeraCita.getEmail();
String celularCliente = primeraCita.getCelular();
String valor = primeraCita.getValor();

// Poner los datos en los JTextField correspondientes
Hora_text.setText(hora);
Año_text.setText(año);
Mes_text.setText(mes);
Dia_text.setText(dia);
Servicio_text.setText(servicio);
Mecanico_text1.setText(mecanico);

System.out.println("Nombre Cliente: " + nombreCliente);
System.out.println("Apellidos Cliente: " + apellidosCliente);
System.out.println("Email Cliente: " + emailCliente);
System.out.println("Celular Cliente: " + celularCliente);
System.out.println("Valor: " + valor);

NombreCli.setText(nombreCliente);
ApellidosCli.setText(apellidosCliente);
EmailCli.setText(emailCliente);
CelularCli.setText(celularCliente);
Valor_jp.setText(valor);

                break;
            
        }
        

       
        
        

    }
public void Vaciar(){
    
            NombreCli.setText("");
        ApellidosCli.setText("");
        CelularCli.setText("");
        EmailCli.setText("");
        Valor_jp.setText(String.valueOf(valor));

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

        Hora_text = new javax.swing.JTextField();
        Año_text = new javax.swing.JTextField();
        Mes_text = new javax.swing.JTextField();
        Dia_text = new javax.swing.JTextField();
        Servicio_text = new javax.swing.JTextField();
        Mecanico_text1 = new javax.swing.JTextField();
        Mecanico_jp = new javax.swing.JComboBox<>();
        Servicio_jp = new javax.swing.JComboBox<>();
        diaCombo = new javax.swing.JComboBox<>();
        mesCombo = new javax.swing.JComboBox<>();
        añoCombo = new javax.swing.JComboBox<>();
        horaCombo = new javax.swing.JComboBox<>();
        NombreCli = new javax.swing.JTextField();
        ApellidosCli = new javax.swing.JTextField();
        EmailCli = new javax.swing.JTextField();
        CelularCli = new javax.swing.JTextField();
        Valor_jp = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();
        BotonAgendar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(Hora_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 280, -1));
        add(Año_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 370, 70, -1));
        add(Mes_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, 50, -1));
        add(Dia_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 50, -1));
        add(Servicio_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 280, -1));
        add(Mecanico_text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 280, -1));

        Mecanico_jp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Mecanico_jpItemStateChanged(evt);
            }
        });
        add(Mecanico_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 280, -1));

        Servicio_jp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cambio de aceite y filtro $100,000 - 30 minutos", "Revisión y cambio de frenos $150,000 - 1 hora", "Alineación y balanceo de neumáticos $80,000 - 1 hora", "Revisión y cambio de bujías $60,000 - 1 hora", "Revisión y reemplazo de la batería $200,000 - 30 minutos", "Inspección del sistema de escape $90,000 - 1 hora", "Revisión del sistema de suspensión $120,000 - 1 hora", "Revisión de luces y señalización $40,000 - 30 minutos", "Revisión del sistema de aire acondicionado y calefacción $110,000 - 1 hora", "Inspección de correas y mangueras $50,000 - 30 minutos", "Cambio del líquido de transmisión $130,000 - 2 horas", "Revisión del sistema de dirección $100,000 - 1 hora" }));
        Servicio_jp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Servicio_jpItemStateChanged(evt);
            }
        });
        add(Servicio_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 280, -1));

        diaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        diaCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                diaComboItemStateChanged(evt);
            }
        });
        diaCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                diaComboKeyReleased(evt);
            }
        });
        add(diaCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 50, -1));

        mesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        mesCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mesComboItemStateChanged(evt);
            }
        });
        add(mesCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, 50, -1));

        añoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024" }));
        añoCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                añoComboItemStateChanged(evt);
            }
        });
        add(añoCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 370, 70, -1));

        add(horaCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 280, -1));
        add(NombreCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 280, -1));
        add(ApellidosCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 490, 280, -1));

        EmailCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EmailCliKeyReleased(evt);
            }
        });
        add(EmailCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 280, -1));
        add(CelularCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 570, 280, -1));

        Valor_jp.setEditable(false);
        Valor_jp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Valor_jpKeyReleased(evt);
            }
        });
        add(Valor_jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 620, 280, -1));

        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 54, 160, 40));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dia");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mes");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Año");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 370, -1, -1));

        Volver.setBorder(null);
        Volver.setContentAreaFilled(false);
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 160, 40));

        BotonAgendar.setBorder(null);
        BotonAgendar.setContentAreaFilled(false);
        BotonAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgendarActionPerformed(evt);
            }
        });
        add(BotonAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 650, 190, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Agendar_man.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Inicializar();
        Gestion_inv.inicializar();
        Main.ShowPanel("Gerente_inv");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void EmailCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailCliKeyReleased

    }//GEN-LAST:event_EmailCliKeyReleased

    private void Valor_jpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Valor_jpKeyReleased

    }//GEN-LAST:event_Valor_jpKeyReleased

    private void BotonAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgendarActionPerformed

switch(accion){
    case "Agendar":
 String seleccion = (String) Servicio_jp.getSelectedItem();

        int dia = Integer.parseInt((String) diaCombo.getSelectedItem());
        int mes = Integer.parseInt((String) mesCombo.getSelectedItem());
        int año = Integer.parseInt((String) añoCombo.getSelectedItem());
        String hora = (String) horaCombo.getSelectedItem();

        // Asignar valor y tiempo según el servicio seleccionado
        switch (seleccion) {
            case "Cambio de aceite y filtro $100,000 - 30 minutos":
                valor = 100000;
                duracion = 30;
                break;
            case "Revisión y cambio de frenos $150,000 - 1 hora":
                valor = 150000;
                duracion = 60;
                break;
            case "Alineación y balanceo de neumáticos $80,000 - 1 hora":
                valor = 80000;
                duracion = 60;
                break;
            case "Revisión y cambio de bujías $60,000 - 1 hora":
                valor = 60000;
                duracion = 60;
                break;
            case "Revisión y reemplazo de la batería $200,000 - 30 minutos":
                valor = 200000;
                duracion = 30;
                break;
            case "Inspección del sistema de escape $90,000 - 1 hora":
                valor = 90000;
                duracion = 60;
                break;
            case "Revisión del sistema de suspensión $120,000 - 1 hora":
                valor = 120000;
                duracion = 60;
                break;
            case "Revisión de luces y señalización $40,000 - 30 minutos":
                valor = 40000;
                duracion = 30;
                break;
            case "Revisión del sistema de aire acondicionado y calefacción $110,000 - 1 hora":
                valor = 110000;
                duracion = 60;
                break;
            case "Inspección de correas y mangueras $50,000 - 30 minutos":
                valor = 50000;
                duracion = 30;
                break;
            case "Cambio del líquido de transmisión $130,000 - 2 horas":
                valor = 130000;
                duracion = 120;
                break;
            case "Revisión del sistema de dirección $100,000 - 1 hora":
                valor = 100000;
                duracion = 60;
                break;

        }

        Valor_jp.setText(String.valueOf(valor));

        String mecanicoSeleccionado = (String) Mecanico_jp.getSelectedItem();
        String servicioSeleccionado = (String) Servicio_jp.getSelectedItem();
        
        
        
        
        int diaSeleccionado = Integer.parseInt((String) diaCombo.getSelectedItem());
        int mesSeleccionado = Integer.parseInt((String) mesCombo.getSelectedItem());
        int añoSeleccionado = Integer.parseInt((String) añoCombo.getSelectedItem());
        String horaSeleccionada = (String) horaCombo.getSelectedItem();

        String nombreCliente = NombreCli.getText();
        String apellidosCliente = ApellidosCli.getText();
        String emailCliente = EmailCli.getText();
        String celularCliente = CelularCli.getText();
        String valor = Valor_jp.getText();

// Formatear la fecha en el formato deseado (por ejemplo, "yyyy-MM-dd")
        String fecha = añoSeleccionado + "-" + (mesSeleccionado < 10 ? "0" : "") + mesSeleccionado + "-" + (diaSeleccionado < 10 ? "0" : "") + diaSeleccionado;

// Crear un nuevo objeto Mantenimiento con los valores obtenidos
        Mantenimiento nuevaCita = new Mantenimiento(
                Mecanicos.get(Mecanico_jp.getSelectedIndex()).getIdentificador(),
                mecanicoSeleccionado, // identificador (del mecánico)
                servicioSeleccionado, // servicio
                fecha, // fecha
                horaSeleccionada, // hora
                nombreCliente, // nombresCliente
                apellidosCliente, // apellidosCliente
                emailCliente, // email
                celularCliente, // celular
                valor, // valor
                duracion // duracion (puedes asignar el valor correspondiente)
        );

// Agregar la nueva cita a la lista de citas agendadas
        CitasAgendadas.add(nuevaCita);
        
        Crud_txt lector = new Crud_txt();
        
        lector.Editar_Citas_Mantenimiento(CitasAgendadas);
        
        Inicializar();

        
        break;
    case "Eliminar":
        
        Crud_txt editar = new Crud_txt();
     
            
            
            
            
        int response = JOptionPane.showConfirmDialog(null, "¿Está seguro de querer eliminar el elemento?", "Confirmación de eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // Comprobar la respuesta del usuario
        if (response == JOptionPane.YES_OPTION) {
            // Si el usuario selecciona "Sí"
            CitasAgendadas.remove(elemento);
            
            editar.Editar_Citas_Mantenimiento(CitasAgendadas);
            Main.ShowPanel("Gestion_man");
            
            JOptionPane.showMessageDialog(null, "Datos eliminados con éxito", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    
        
        } else {
        Vaciar();
        Main.ShowPanel("Gestion_man");
                    JOptionPane.showMessageDialog(null, "Cancelado", "Cancelado", JOptionPane.INFORMATION_MESSAGE);

        }
            
        break;
}
       Gestion_Mantenimiento.inicializar(); 
       

    }//GEN-LAST:event_BotonAgendarActionPerformed

    private void diaComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diaComboKeyReleased

    }//GEN-LAST:event_diaComboKeyReleased

    private void mesComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mesComboItemStateChanged
        actualizarHoras();
    }//GEN-LAST:event_mesComboItemStateChanged

    private void diaComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_diaComboItemStateChanged
        actualizarHoras();
    }//GEN-LAST:event_diaComboItemStateChanged

    private void añoComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_añoComboItemStateChanged
        actualizarHoras();
    }//GEN-LAST:event_añoComboItemStateChanged

    private void Servicio_jpItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Servicio_jpItemStateChanged

        String seleccion = (String) Servicio_jp.getSelectedItem();

        // Asignar valor y tiempo según el servicio seleccionado
        switch (seleccion) {
            case "Cambio de aceite y filtro $100,000 - 30 minutos":
                valor = 100000;
                duracion = 30;
                break;
            case "Revisión y cambio de frenos $150,000 - 1 hora":
                valor = 150000;
                duracion = 60;
                break;
            case "Alineación y balanceo de neumáticos $80,000 - 1 hora":
                valor = 80000;
                duracion = 60;
                break;
            case "Revisión y cambio de bujías $60,000 - 1 hora":
                valor = 60000;
                duracion = 60;
                break;
            case "Revisión y reemplazo de la batería $200,000 - 30 minutos":
                valor = 200000;
                duracion = 30;
                break;
            case "Inspección del sistema de escape $90,000 - 1 hora":
                valor = 90000;
                duracion = 60;
                break;
            case "Revisión del sistema de suspensión $120,000 - 1 hora":
                valor = 120000;
                duracion = 60;
                break;
            case "Revisión de luces y señalización $40,000 - 30 minutos":
                valor = 40000;
                duracion = 30;
                break;
            case "Revisión del sistema de aire acondicionado y calefacción $110,000 - 1 hora":
                valor = 110000;
                duracion = 60;
                break;
            case "Inspección de correas y mangueras $50,000 - 30 minutos":
                valor = 50000;
                duracion = 30;
                break;
            case "Cambio del líquido de transmisión $130,000 - 2 horas":
                valor = 130000;
                duracion = 120;
                break;
            case "Revisión del sistema de dirección $100,000 - 1 hora":
                valor = 100000;
                duracion = 60;
                break;

        }

        Valor_jp.setText(String.valueOf(valor));
    }//GEN-LAST:event_Servicio_jpItemStateChanged

    private void Mecanico_jpItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Mecanico_jpItemStateChanged
        actualizarHoras();
    }//GEN-LAST:event_Mecanico_jpItemStateChanged

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
       Main.ShowPanel("Gestion_man");
    }//GEN-LAST:event_VolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    static javax.swing.JTextField ApellidosCli;
    private static javax.swing.JTextField Año_text;
    private javax.swing.JButton BotonAgendar;
    static javax.swing.JTextField CelularCli;
    private static javax.swing.JTextField Dia_text;
    static javax.swing.JTextField EmailCli;
    static javax.swing.JTextField Hora_text;
    private static javax.swing.JComboBox<String> Mecanico_jp;
    private static javax.swing.JTextField Mecanico_text1;
    private static javax.swing.JTextField Mes_text;
    static javax.swing.JTextField NombreCli;
    private javax.swing.JComboBox<String> Servicio_jp;
    private static javax.swing.JTextField Servicio_text;
    private javax.swing.JTextField Valor_jp;
    private javax.swing.JButton Volver;
    private static javax.swing.JComboBox<String> añoCombo;
    private static javax.swing.JComboBox<String> diaCombo;
    private static javax.swing.JComboBox<String> horaCombo;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private static javax.swing.JComboBox<String> mesCombo;
    // End of variables declaration//GEN-END:variables
}
