package dao;

import clases.DetalleVenta;
import interfaces.ICrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import utils.MySqlConexion;

/**
 * @author MendozaAnahi
 */

public class MySqlDetalleVentaDAO implements ICrud<DetalleVenta, Integer>{

    @Override
    public int save(DetalleVenta bean) {
        int resultado = 0;
        Connection cn = null;
        PreparedStatement pstm = null;

        try {
            cn = MySqlConexion.getConexion();
            String sql = "INSERT INTO DetalleVenta (VentaID, ProductoID, Cantidad, PrecioUnitario, Subtotal) VALUES (?, ?, ?, ?, ?)";
            pstm = cn.prepareStatement(sql);

            pstm.setInt(1, bean.getVentaID());
            pstm.setInt(2, bean.getProductoID());
            pstm.setInt(3, bean.getCantidad());
            pstm.setDouble(4, bean.getPrecioUnitario());
            pstm.setDouble(5, bean.getSubtotal());

            resultado = pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (Exception e) { e.printStackTrace(); }
        }
        return resultado;
    }

    @Override
    public int update(DetalleVenta bean) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public DetalleVenta findById(Integer id) {
        return null;
    }

    @Override
    public List<DetalleVenta> findAll() {
        return new ArrayList<>();
    }

    @Override
    public List<DetalleVenta> search(String texto) {
        return new ArrayList<>();
    }
}
