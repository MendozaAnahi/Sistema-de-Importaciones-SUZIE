package clases;

public class MetodoPago {

    private int metodoPagoID;
    private String nombreMetodo;

    public MetodoPago() {
    }

    public MetodoPago(int metodoPagoID, String nombreMetodo) {
        this.metodoPagoID = metodoPagoID;
        this.nombreMetodo = nombreMetodo;
    }

    public int getMetodoPagoID() {
        return metodoPagoID;
    }

    public void setMetodoPagoID(int metodoPagoID) {
        this.metodoPagoID = metodoPagoID;
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }

    @Override
    public String toString() {
        return nombreMetodo;
    }
}
