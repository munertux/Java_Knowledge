
package Info;

import MenuPanels.Menu_Gerente;
import Paneles.Login.*;
import Operaciones.*;
import Paneles.Login.Login;
import java.util.ArrayList;
import java.util.List;

public class Credenciales  {



public boolean ValidarUsuario(List<Credenciales> lista, String user, String password) {
    
    for (Credenciales cred : lista) {
        if (cred.getUser().equals(user) && cred.getPassword().equals(password)) {
            switch(cred.getRol()){
                case "gerente":
                    Menu_Gerente.setMenu(0);
                    Login.panel="Gerente_Ventas";
                    
                    break;
        }
            
            return true; // Retorna el objeto Credenciales si el usuario coincide
        }
    }
    return false; // Retorna false si no se encuentra el usuario
}    
    
    
  
    
private String user,password,rol,nombre,apellido,identificador;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Credenciales(String user, String password, String rol, String nombre, String apellido, String identificador) {
        this.user = user;
        this.password = password;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificador = identificador;
    }


    public Credenciales() {
    }

}
