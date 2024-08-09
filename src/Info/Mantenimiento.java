
package Info;


public class Mantenimiento {
    // Atributos
    private String identificador; //para identificar al mecanico
    private String mecanico;
    private String servicio;
    private String fecha;
    private String hora;
    private String nombresCliente;
    private String apellidosCliente;
    private String email;
    private String celular;
    private String valor;
    private int duracion; // duración del servicio en minutos

    // Constructor
    public Mantenimiento(String identificador,String mecanico, String servicio, String fecha, String hora, String nombresCliente, String apellidosCliente, String email, String celular, String valor, int duracion) {
        this.identificador = identificador;
        this.mecanico=mecanico;
        this.servicio = servicio;
        this.fecha = fecha;
        this.hora = hora;
        this.nombresCliente = nombresCliente;
        this.apellidosCliente = apellidosCliente;
        this.email = email;
        this.celular = celular;
        this.valor = valor;
        this.duracion = duracion;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    // Métodos getter y setter
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombresCliente() {
        return nombresCliente;
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    public String getApellidosCliente() {
        return apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
