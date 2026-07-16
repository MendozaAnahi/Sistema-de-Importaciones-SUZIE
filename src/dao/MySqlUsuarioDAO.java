package dao;

import clases.Usuario;
import interfaces.ICrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.MySqlConexion;

/**
 * @author MendozaAnahi
 */

public class MySqlUsuarioDAO implements ICrud<Usuario, Integer> {

    // 1. MÉTODO DE INICIO DE SESIÓN 
    public Usuario iniciarSesion(String correo, String contrasena) {
        Usuario usu = null;
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            cn = MySqlConexion.getConexion();
            String sql = "SELECT * FROM Usuario WHERE Correo = ? AND Contrasena = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, correo);
            pstm.setString(2, contrasena);
            
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                usu = new Usuario();
                usu.setUsuarioID(rs.getInt("UsuarioID"));
                usu.setNombre(rs.getString("Nombre"));
                usu.setApellido(rs.getString("Apellido"));
                usu.setCorreo(rs.getString("Correo"));
                usu.setContrasena(rs.getString("Contrasena"));
                usu.setRolID(rs.getInt("RolID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usu;
    }

    // 2. MÉTODOS DEL ICRUD 
    @Override
   public int save(Usuario bean) {
        int salida = -1;
        Connection cn = null;
        PreparedStatement pstm = null;
 
        try {
            cn = MySqlConexion.getConexion();
 
            String sql = "INSERT INTO Usuario(Nombre, Apellido, Correo, Contrasena, RolID) VALUES(?,?,?,?,?)";
 
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getNombre());
            pstm.setString(2, bean.getApellido());
            pstm.setString(3, bean.getCorreo());
            pstm.setString(4, bean.getContrasena());
            pstm.setInt(5, bean.getRolID());
 
            salida = pstm.executeUpdate();
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
                if (pstm != null) pstm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return salida;
    }

    @Override
   public int update(Usuario bean) {
        int salida = -1;
        Connection cn = null;
        PreparedStatement pstm = null;
 
        try {
            cn = MySqlConexion.getConexion();
 
            String sql = "UPDATE Usuario SET Nombre=?, Apellido=?, Correo=?, Contrasena=?, RolID=? WHERE UsuarioID=?";
 
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getNombre());
            pstm.setString(2, bean.getApellido());
            pstm.setString(3, bean.getCorreo());
            pstm.setString(4, bean.getContrasena());
            pstm.setInt(5, bean.getRolID());
            pstm.setInt(6, bean.getUsuarioID());
 
            salida = pstm.executeUpdate();
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
                if (pstm != null) pstm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return salida;
    }

    @Override
     public int delete(Integer id) {
        int salida = -1;
        Connection cn = null;
        PreparedStatement pstm = null;
 
        try {
            cn = MySqlConexion.getConexion();
 
            String sql = "DELETE FROM Usuario WHERE UsuarioID=?";
 
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id);
 
            salida = pstm.executeUpdate();
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
                if (pstm != null) pstm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return salida;
    }

    @Override
      public Usuario findById(Integer id) {
        Usuario bean = null;
 
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
 
        try {
            cn = MySqlConexion.getConexion();
 
            String sql = "SELECT * FROM Usuario WHERE UsuarioID=?";
 
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id);
 
            rs = pstm.executeQuery();
 
            if (rs.next()) {
                bean = new Usuario();
                bean.setUsuarioID(rs.getInt("UsuarioID"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido(rs.getString("Apellido"));
                bean.setCorreo(rs.getString("Correo"));
                bean.setContrasena(rs.getString("Contrasena"));
                bean.setRolID(rs.getInt("RolID"));
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
                if (pstm != null) pstm.close();
                if (rs != null) rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
    @Override
   public List<Usuario> findAll() {
        List<Usuario> lista = new ArrayList<>();
 
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
 
        try {
            cn = MySqlConexion.getConexion();
 
            String sql = "SELECT * FROM Usuario";
 
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
 
            while (rs.next()) {
                Usuario bean = new Usuario();
                bean.setUsuarioID(rs.getInt("UsuarioID"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido(rs.getString("Apellido"));
                bean.setCorreo(rs.getString("Correo"));
                bean.setContrasena(rs.getString("Contrasena"));
                bean.setRolID(rs.getInt("RolID"));
 
                lista.add(bean);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
                if (pstm != null) pstm.close();
                if (rs != null) rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
 

    @Override
   public List<Usuario> search(String texto) {
        List<Usuario> lista = new ArrayList<>();
 
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
 
        try {
            cn = MySqlConexion.getConexion();
 
            String sql = "SELECT * FROM Usuario WHERE Nombre LIKE ? OR Apellido LIKE ? OR Correo LIKE ?";
 
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            pstm.setString(3, "%" + texto + "%");
 
            rs = pstm.executeQuery();
 
            while (rs.next()) {
                Usuario bean = new Usuario();
                bean.setUsuarioID(rs.getInt("UsuarioID"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido(rs.getString("Apellido"));
                bean.setCorreo(rs.getString("Correo"));
                bean.setContrasena(rs.getString("Contrasena"));
                bean.setRolID(rs.getInt("RolID"));
 
                lista.add(bean);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
                if (pstm != null) pstm.close();
                if (rs != null) rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}