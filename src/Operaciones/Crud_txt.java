/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import Info.Credenciales;
import Info.Inventario;
import Info.Mantenimiento;
import Info.Mecanicos;
import Paneles.Login.Login;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crud_txt {

    public List<Inventario> leer_Inventario_U() {
        List<Inventario> lista = new ArrayList<Inventario>();
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/Info/Inventario_U.txt"));
            String linea = "";

            while ((linea = lector.readLine()) != null) {

                String[] bloques = linea.split("\t");

                lista.add(new Inventario(bloques[0], bloques[1], bloques[2], bloques[3], bloques[4], bloques[5], bloques[6], bloques[7], bloques[8], bloques[9], bloques[10], bloques[11], bloques[12], bloques[13], bloques[14], bloques[15], bloques[16], bloques[17], bloques[18], bloques[19], bloques[20], bloques[21], bloques[22], bloques[23], bloques[24]));

            }
            lector.close();
        } catch (Exception E) {
            System.out.println("problema");
            E.printStackTrace();
        }
        //System.out.println(lista.get(1).getUser());
        return lista;
    }

    public int leer_Contador() {

        int contador = 0;
        List<Inventario> lista = new ArrayList<Inventario>();
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/Contrato/Contador.txt"));
            String linea = "";

            while ((linea = lector.readLine()) != null) {

                String[] bloques = linea.split("\t");

                contador = Integer.parseInt(bloques[0]);
            }
            lector.close();
        } catch (Exception E) {
            System.out.println("problema");
            E.printStackTrace();
        }
        //System.out.println(lista.get(1).getUser());
        return contador;
    }

    public void escribir_Contador(int nuevoContador) {
        // Convertir el contador a una cadena
        String contenido = Integer.toString(nuevoContador);

        // Usando try-with-resources para asegurar que el recurso se cierra adecuadamente
        try (FileWriter escritor = new FileWriter("src/Contrato/Contador.txt", false)) {
            // Escribir el contenido en el archivo
            escritor.write(contenido);
            System.out.println("Contador actualizado con éxito.");
        } catch (IOException e) {
            System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void Agregar_Inventario_U(String marca, String modelo, String f_fabricacion, String placa, String transmision, String combustible, String cilindraje, String abs, String sensor, String AireA, String vidriosEl, String PantTac, String direccion, String EspEle, String velmax, String kilometraje, String Imagen, String precio) {

        String textToAppend = marca + "\t" + modelo + "\t" + f_fabricacion + "\t" + placa + "\t" + transmision + "\t" + combustible + "\t" + cilindraje + "\t" + abs + "\t" + sensor + "\t" + AireA + "\t" + vidriosEl + "\t" + PantTac + "\t" + direccion + "\t" + EspEle + "\t" + velmax + "\t" + kilometraje + "\t" + Imagen + "\t" + precio + "\t" + "No\t" + "null\t" + "null\t" + "null\t" + "null\t" + "null\t" + "null" + "\n"; // Texto para agregar

        // Usando try-with-resources para asegurar que los recursos se cierran adecuadamente
        try (FileWriter escritura = new FileWriter("src/Info/Inventario_U.txt", true)) { // El segundo argumento 'true' es para el modo append
            escritura.write(textToAppend);
            System.out.println("Texto añadido con éxito.");
        } catch (IOException e) {
            System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void Editar_Inventario_U(List<Inventario> ListaInventario) {

        StringBuilder nuevoInventario = new StringBuilder();
        for (Inventario inventario : ListaInventario) {
            String textToAppend = inventario.getMarca() + "\t"
                    + inventario.getModelo() + "\t"
                    + inventario.getF_fabricacion() + "\t"
                    + inventario.getPlaca() + "\t"
                    + inventario.getTransmision() + "\t"
                    + inventario.getCombustible() + "\t"
                    + inventario.getCilindraje() + "\t"
                    + inventario.getAbs() + "\t"
                    + inventario.getSensor() + "\t"
                    + inventario.getAireA() + "\t"
                    + inventario.getVidriosEl() + "\t"
                    + inventario.getPantTac() + "\t"
                    + inventario.getDireccion() + "\t"
                    + inventario.getEspEle() + "\t"
                    + inventario.getVelmax() + "\t"
                    + inventario.getKilometraje() + "\t"
                    + inventario.getImagen() + "\t"
                    + inventario.getPrecio() + "\t"
                    + inventario.getStatus() + "\t"
                    + inventario.getNombreCom() + "\t"
                    + inventario.getNumeroCom() + "\t"
                    + inventario.getApellidosCom() + "\t"
                    + inventario.getEmailCom() + "\t"
                    + inventario.getCiudadCom() + "\t"
                    + inventario.getCedulaCom() + "\n";

            nuevoInventario.append(textToAppend);
        }

        // Usando try-with-resources para asegurar que los recursos se cierran adecuadamente
        try (FileWriter escritura = new FileWriter("src/Info/Inventario_U.txt", false)) { // El segundo argumento 'true' es para el modo append
            escritura.write(nuevoInventario.toString());
            System.out.println("Texto añadido con éxito.");
        } catch (IOException e) {
            System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }

    public List<Credenciales> leer_Login_U() {
        List<Credenciales> lista = new ArrayList<Credenciales>();
        
        
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/Info/Login_U.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {

                String[] bloques = linea.split("\t");
                System.out.println(bloques.length);
                lista.add(new Credenciales(bloques[0], bloques[1], bloques[2],bloques[3],bloques[4],bloques[5]));
                
                //bloques[0]= usuario bloques[1]=coontraseña bloques[2]=rol bloques[3]=Nombres bloques[4]=Apellidos bloques[5]=                
            }
            lector.close();
        } catch (Exception E) {
            System.out.println("problema");
            E.printStackTrace();
        }
        //System.out.println(lista.get(1).getUser());
        return lista;
    }
    
        public List<Mecanicos> leer_Login_U_Mecanicos() {
        
        List<Mecanicos> mecanicos = new ArrayList<Mecanicos>();
        
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/Info/Login_U.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {

                String[] bloques = linea.split("\t");

                    if(bloques[2].equals("mecanico")){
                        mecanicos.add(new Mecanicos(bloques[3],bloques[4],bloques[5]));                    
                    }                                    
                
                //bloques[0]= usuario bloques[1]=coontraseña bloques[2]=rol bloques[3]=Nombres bloques[4]=Apellidos bloques[5]=                
            }
            lector.close();
        } catch (Exception E) {
            System.out.println("problema");
            E.printStackTrace();
        }
        //System.out.println(lista.get(1).getUser());
        return mecanicos;
    }
        
                public List<Mantenimiento> leer_Mantenimiento() {
        
        List<Mantenimiento> mantenimientos = new ArrayList<Mantenimiento>();
        
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/Info/Mantenimientos.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {

                String[] bloques = linea.split("\t");

                    
                        mantenimientos.add(new Mantenimiento(bloques[0],bloques[1],bloques[2],bloques[3],bloques[4],bloques[5],bloques[6],bloques[7],bloques[8],bloques[9],Integer.parseInt(bloques[10])));                    
                                                     
                
                //bloques[0]= usuario bloques[1]=coontraseña bloques[2]=rol bloques[3]=Nombres bloques[4]=Apellidos bloques[5]=                
            }
            lector.close();
        } catch (Exception E) {
            System.out.println("problema");
            E.printStackTrace();
        }
        //System.out.println(lista.get(1).getUser());
        return mantenimientos;
    }
    
                
public void Editar_Citas_Mantenimiento(List<Mantenimiento> ListaMantenimiento) {

    StringBuilder nuevoMantenimiento = new StringBuilder();
    for (Mantenimiento mantenimiento : ListaMantenimiento) {
        String textToAppend = 
                mantenimiento.getIdentificador() + "\t"
                + mantenimiento.getMecanico() + "\t"
                + mantenimiento.getServicio() + "\t"
                + mantenimiento.getFecha() + "\t"
                + mantenimiento.getHora() + "\t"
                + mantenimiento.getNombresCliente() + "\t"
                + mantenimiento.getApellidosCliente() + "\t"
                + mantenimiento.getEmail() + "\t"
                + mantenimiento.getCelular() + "\t"
                + mantenimiento.getValor() + "\t"
                + mantenimiento.getDuracion() + "\n"; // Asegúrate de añadir la duración

        nuevoMantenimiento.append(textToAppend);
    }

    // Usando try-with-resources para asegurar que los recursos se cierran adecuadamente
    try (FileWriter escritura = new FileWriter("src/Info/Mantenimientos.txt", false)) { // El segundo argumento 'false' es para sobrescribir el archivo
        escritura.write(nuevoMantenimiento.toString());
        System.out.println("Texto añadido con éxito.");
    } catch (IOException e) {
        System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
    }
}
}
