package dao;

import clases.Cliente;
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

public class MySqlClienteDAO implements ICrud<Cliente, Integer>{

    @Override
    public int save(Cliente bean) {
        int idGenerado = 0; // Cambiamos 'resultado' por 'idGenerado'
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null; // Necesitamos esto para capturar el ID

        try {
            cn = MySqlConexion.getConexion();
            String sql = "INSERT INTO Cliente (Nombre, Apellido, Telefono) VALUES (?, ?, ?)";
            pstm = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // <--- Clave
        
            pstm.setString(1, bean.getNombre());
            pstm.setString(2, bean.getApellido());
            pstm.setString(3, bean.getTelefono());
        
            int filas = pstm.executeUpdate();
            if (filas > 0) {
                rs = pstm.getGeneratedKeys();
                if (rs.next()) idGenerado = rs.getInt(1);
            }
        } catch (Exception e) { 
            e.printStackTrace(); }
        finally { 
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (Exception e) { e.printStackTrace(); }
        }
    return idGenerado; // Retorna el ID (ej: 1, 2, 3...)
    }
    
    // 2. MÉTODOS RESTANTES DEL ICRUD
    @Override
    public int update(Cliente bean) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public Cliente findById(Integer id) {
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        return new ArrayList<>();
    }

    @Override
    public List<Cliente> search(String texto) {
        return new ArrayList<>();
    }
}
