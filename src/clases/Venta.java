package clases;

public class Venta {
    private int codigoVenta,codigoUsuario,codigoSede,codigoMetodoPago;
    private String fecha;
    private double total;

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public int getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(int codigoSese) {
        this.codigoSede = codigoSese;
    }

    public int getCodigoMetodoPago() {
        return codigoMetodoPago;
    }

    public void setCodigoMetodoPago(int codigoMetodoPago) {
        this.codigoMetodoPago = codigoMetodoPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
