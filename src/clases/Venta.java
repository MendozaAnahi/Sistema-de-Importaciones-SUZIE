package clases; 

import java.sql.Date;

/**
 * @author MendozaAnahi
 */

public class Venta { 
    // Atributos de la tabla
    private int ventaID, clienteID, usuarioID, metodoPagoID;
    private Date fechaVenta;
    private double total;

    // Constructores
    //1. Vacío por defecto
    public Venta() {
    }
    
    //2. Parametrizado completo
    public Venta(int ventaID, int clienteID, int usuarioID, int metodoPagoID, Date fechaVenta, double total) {
        this.ventaID = ventaID;
        this.clienteID = clienteID;
        this.usuarioID = usuarioID;
        this.metodoPagoID = metodoPagoID;
        this.fechaVenta = fechaVenta;
        this.total = total;
    }
    
    // Getters y Setters
    public int getVentaID() {
        return ventaID;
    }

    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public int getMetodoPagoID() {
        return metodoPagoID;
    }

    public void setMetodoPagoID(int metodoPagoID) {
        this.metodoPagoID = metodoPagoID;
    }
}
