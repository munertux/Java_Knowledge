/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import Info.Inventario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Stephen
 */
public class Busqueda {

    public static List<Integer> indices = new ArrayList<Integer>();

    public static List<Inventario> filtrar(List<Inventario> inventarioList, String filtro, String buscar) {

        return inventarioList.stream()
                .filter(inventario -> {
                    boolean match = false;
                    switch (filtro) {
                        case "Marca":
                            match = inventario.getMarca().toLowerCase().contains(buscar.toLowerCase());
                            if (match == true) {
                                indices.add(inventarioList.indexOf(inventario));
                            }

                            break;
                        case "Modelo":
                            match = inventario.getModelo().toLowerCase().contains(buscar.toLowerCase());
                            inventarioList.indexOf(inventario);
                            if (match == true) {
                                indices.add(inventarioList.indexOf(inventario));
                            }
                            break;
                            
                           
                        case "F_Fabricacion":
                            match = inventario.getF_fabricacion().toLowerCase().contains(buscar.toLowerCase());
                            inventarioList.indexOf(inventario);
                            if (match == true) {
                                indices.add(inventarioList.indexOf(inventario));
                            }
                            break;
                        case "Cilindraje":
                            match = inventario.getCilindraje().toLowerCase().contains(buscar.toLowerCase());
                            inventarioList.indexOf(inventario);
                            if (match == true) {
                                indices.add(inventarioList.indexOf(inventario));
                            }
                            break;
                        case "Placa":
                            match = inventario.getPlaca().toLowerCase().contains(buscar.toLowerCase());
                            inventarioList.indexOf(inventario);
                            if (match == true) {
                                indices.add(inventarioList.indexOf(inventario));
                            }
                            break;
                        case "Precio":
                            match = inventario.getPrecio().toLowerCase().contains(buscar.toLowerCase());
                            inventarioList.indexOf(inventario);
                            if (match == true) {
                                indices.add(inventarioList.indexOf(inventario));
                            }
                            break;
                        case "Kilometraje":
                            match = inventario.getKilometraje().toLowerCase().contains(buscar.toLowerCase());
                            inventarioList.indexOf(inventario);
                            if (match == true) {
                                indices.add(inventarioList.indexOf(inventario));
                            }
                            break;
                    }

                    return match;
                })
                .collect(Collectors.toList());
    }

}
