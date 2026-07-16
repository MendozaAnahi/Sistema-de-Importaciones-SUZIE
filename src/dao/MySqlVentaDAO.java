package dao;

import clases.Venta;
import interfaces.ICrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MySqlConexion;

/**
 * @author MendozaAnahi
 */

public class MySqlVentaDAO implements ICrud<Venta, Integer> {
    // Nota: Este método retorna el ID generado en lugar de solo 0 o 1
    public int saveAndReturnId(Venta bean) {
        int idGenerado = 0;
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            cn = MySqlConexion.getConexion();
            // SQL: No incluimos VentaID ni FechaVenta porque son autoincrement y DEFAULT
            String sql = "INSERT INTO Venta (Total, ClienteID, UsuarioID, MetodoPagoID) VALUES (?, ?, ?, ?)";
            
            // IMPORTANTE: Le decimos a Java que queremos recuperar el ID que se creó
            pstm = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pstm.setDouble(1, bean.getTotal());
            pstm.setInt(2, bean.getClienteID());
            pstm.setInt(3, bean.getUsuarioID());
            pstm.setInt(4, bean.getMetodoPagoID());

            int filasAfectadas = pstm.executeUpdate();

            if (filasAfectadas > 0) {
                rs = pstm.getGeneratedKeys();
                if (rs.next()) {
                    idGenerado = rs.getInt(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (Exception e) { e.printStackTrace(); }
        }
        return idGenerado;
    }
    
    
    @Override
    public int save(Venta bean) {
        // Implementación estándar si solo necesitas confirmar que se guardó
        return (saveAndReturnId(bean) > 0) ? 1 : 0;
    }
    
    // Métodos restantes de ICrud
    @Override
    public int update(Venta bean) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public Venta findById(Integer id) {
        return null;
    }

    @Override
    public List<Venta> findAll() {
        return new ArrayList<>();
    }

    @Override
    public List<Venta> search(String texto) {
        return new ArrayList<>();
    }
}
