package dao;

import conexion.Conexion;
import modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Mostrar clientes
    public ArrayList<Cliente> listar() {

        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM Cliente";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {

                Cliente c = new Cliente();

                c.setCliente_ID(rs.getInt("Cliente_ID"));
                c.setNombre(rs.getString("Nombre"));
                c.setApellido(rs.getString("Apellido"));
                c.setTelefono(rs.getString("Telefono"));
                c.setCorreo(rs.getString("Correo"));
                c.setDireccion(rs.getString("Direccion"));

                lista.add(c);
            }

        } catch(Exception e) {
            System.out.println(e);
        }

        return lista;
    }
}
