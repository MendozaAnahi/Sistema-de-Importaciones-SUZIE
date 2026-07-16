package dao;

import clases.Cliente;
import utils.MySqlConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO {

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    // ============================
    // LISTAR CLIENTES
    // ============================
    public ArrayList<Cliente> listar() {

        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM Cliente";

        try {

            cn = MySqlConexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Cliente c = new Cliente();

                c.setClienteID(rs.getInt("Cliente_ID"));
                c.setNombre(rs.getString("Nombre"));
                c.setApellido(rs.getString("Apellido"));
                c.setTelefono(rs.getString("Telefono"));
                c.setCorreo(rs.getString("Correo"));
                c.setDireccion(rs.getString("Direccion"));

                lista.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }


    // ============================
    // INSERTAR CLIENTE
    // ============================
    public boolean insertar(Cliente c) {

        String sql = "INSERT INTO Cliente "
                + "(Cliente_ID, Nombre, Apellido, Telefono, Correo, Direccion) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {

            cn = MySqlConexion.getConexion();
            ps = cn.prepareStatement(sql);

            ps.setInt(1, c.getClienteID());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getCorreo());
            ps.setString(6, c.getDireccion());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // ============================
    // ACTUALIZAR CLIENTE
    // ============================
    public boolean actualizar(Cliente c) {

        String sql = "UPDATE Cliente SET "
                + "Nombre=?, "
                + "Apellido=?, "
                + "Telefono=?, "
                + "Correo=?, "
                + "Direccion=? "
                + "WHERE Cliente_ID=?";

        try {

            cn = MySqlConexion.getConexion();
            ps = cn.prepareStatement(sql);

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getCorreo());
            ps.setString(5, c.getDireccion());
            ps.setInt(6, c.getClienteID());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // ============================
    // ELIMINAR CLIENTE
    // ============================
    public boolean eliminar(int clienteID) {

        String sql = "DELETE FROM Cliente WHERE Cliente_ID=?";

        try {

            cn = MySqlConexion.getConexion();
            ps = cn.prepareStatement(sql);

            ps.setInt(1, clienteID);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // ============================
    // BUSCAR CLIENTE POR ID
    // ============================
    public Cliente buscar(int clienteID) {

        Cliente c = null;

        String sql = "SELECT * FROM Cliente WHERE Cliente_ID=?";

        try {

            cn = MySqlConexion.getConexion();
            ps = cn.prepareStatement(sql);

            ps.setInt(1, clienteID);

            rs = ps.executeQuery();

            if (rs.next()) {

                c = new Cliente();

                c.setClienteID(rs.getInt("Cliente_ID"));
                c.setNombre(rs.getString("Nombre"));
                c.setApellido(rs.getString("Apellido"));
                c.setTelefono(rs.getString("Telefono"));
                c.setCorreo(rs.getString("Correo"));
                c.setDireccion(rs.getString("Direccion"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }
}
