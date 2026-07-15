package clases;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Venta {

    private int ventaID;
    private LocalDateTime fechaVenta;
    private BigDecimal total;
    private Cliente cliente;
    private Usuario usuario;
    private MetodoPago metodoPago;

    public Venta() {
    }

    public Venta(Cliente cliente, Usuario usuario, MetodoPago metodoPago) {
        this.cliente = cliente;
        this.usuario = usuario;
        this.metodoPago = metodoPago;
        this.fechaVenta = LocalDateTime.now();
        this.total = BigDecimal.ZERO;
    }

    public int getVentaID() {
        return ventaID;
    }

    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "Venta N° " + ventaID;
    }
}
