package clases;

/**
 * @author MendozaAnahi
 */

public class Cliente {
    //Atributos de la tabla
    private int clienteID;
    private String nombre, apellido, telefono;
    
    //Constructores
    //1. Vacío por defecto
    public Cliente() {
    }
    
    //2. Parametrizado completo
    public Cliente(int clienteID, String nombre, String apellido, String telefono) {
        this.clienteID = clienteID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    
    //getters y setters
    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
