
package Info;

/**
 *
 * @author Stephen
 */
public class Mecanicos {
        // Atributos
    private String nombre;
    private String apellidos;
    private String identificador;

    public Mecanicos(String nombre, String apellidos, String identificador) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificador = identificador;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }



    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
