package clases;

/**
 * @author MendozaAnahi
 */

public class DetalleVenta {
    // Atributos de la tabla
    private int ventaID, productoID, cantidad;
    private double precioUnitario, subtotal;
    
    // Constructores
    //1. Vacío por defecto
    public DetalleVenta() {
    }
    
    //2. Parametrizado completo
    public DetalleVenta(int ventaID, int productoID, int cantidad, double precioUnitario, double subtotal) {
        this.ventaID = ventaID;
        this.productoID = productoID;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }
    
    // Getters y Setters
    public int getVentaID() {
        return ventaID;
    }

    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }    
}
