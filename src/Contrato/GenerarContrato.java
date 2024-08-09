package Contrato;

import Operaciones.Crud_txt;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.util.ArrayList;

public class GenerarContrato {

    String NombreVen, CiudadVen, CCVen, NombreCom, CiudadCom, CCCom, Marca, Modelo, Placa, Motor, Precio;
    int contador = 0;

    public GenerarContrato(String NombreVen, String CiudadVen, String CCVen, String NombreCom, String CiudadCom, String CCCom, String Marca, String Modelo, String Placa, String Motor, String Precio) {
       
        this.NombreVen = NombreVen;
        this.CiudadVen = CiudadVen;
        this.CCVen = CCVen;
        this.NombreCom = NombreCom;
        this.CiudadCom = CiudadCom;
        this.CCCom = CCCom ;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Placa = Placa;
        this.Motor = Motor;
        this.Precio = Precio;
        LeerContador();
        editPdf();
    }

    public void LeerContador() {

        Crud_txt lector = new Crud_txt();

        contador = lector.leer_Contador();
    }

    public void editPdf() {

        LocalDate fechaActual = LocalDate.now();

        String dia = Integer.toString(fechaActual.getDayOfMonth());
        String mes = Integer.toString(fechaActual.getMonthValue());
        String año = Integer.toString(fechaActual.getYear());

        try {
            // Ruta del archivo PDF existente
            String src = "src/Contrato/Contrato.pdf";
            // Ruta del archivo PDF de salida
            String dest = "Contrato_" + contador + ".pdf";

            // Cargar el archivo PDF existente
            PdfReader reader = new PdfReader(src);
            // Crear un PdfStamper para editar el PDF
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
            // Obtener el PdfContentByte del PdfStamper para agregar contenido
            PdfContentByte cb = stamper.getOverContent(1);

            // Crear gráficos para dibujar en el PDF
            Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());

            //--------------------- página 1 --------------------------
            Font font1 = new Font("Tahoma", Font.PLAIN, 11);
            g.setFont(font1);

            g.setColor(Color.BLACK);
            g.drawString(NombreVen, 120, 125);

            g.drawString(CiudadVen, 125, 143);

            g.drawString(NombreCom, 325, 162);

            g.drawString(CiudadCom, 255, 181);

            g.drawString(Marca, 105, 325);

            g.drawString(Modelo, 225, 325);

            g.drawString(Placa, 105, 354);

            g.drawString(Motor, 225, 354);

            g.drawString(Precio, 80, 440);

            g.drawString("Forma de pago", 300, 485);

            // Cerrar gráficos
            g.dispose();

            // --------------------- Página 2 --------------------------
            // Obtener el PdfContentByte de la página 2
            PdfContentByte cb2 = stamper.getOverContent(2);

            // Crear gráficos para dibujar en la página 2 del PDF
            Graphics g2 = cb2.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());

            Font font2 = new Font("Tahoma", Font.PLAIN, 11);
            g2.setFont(font2);

            g2.setColor(Color.BLACK);
            g2.drawString(dia, 340, 230);

            g2.drawString(mes, 65, 248);

            g2.drawString(año, 210, 248);

            g2.drawString(CCVen, 90, 472);

            g2.drawString(CCCom, 370, 472);

            // Cerrar gráficos de la página 2
            g2.dispose();

            // Cerrar el PdfStamper
            stamper.close();
            reader.close();

        } catch (DocumentException | IOException ex) {
            System.err.println(ex.getMessage());
        }
        Crud_txt lector = new Crud_txt();
        contador++;
        lector.escribir_Contador(contador);
    }
}
