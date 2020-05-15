package ec.edu.ups.mysql.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.DAO.ClienteDAO;
import ec.edu.ups.modelo.Cliente;

public class JDBCClienteDAO extends JDBCGenericDAO<Cliente, String> implements ClienteDAO {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(Cliente cliente) {

		// TODO Auto-generated method stub
		conexionUno.update("INSERT clientes VALUES ('" + cliente.getCedula() + "', '" + cliente.getNombre() + "', '"
				+ cliente.getApellido() + "', " + cliente.getCredito() + ", '" + cliente.getCorreo() + "', '"
				+ cliente.getContrasenia() + "', 'User'" + ")");

	}

	@Override
	public Cliente read(String id) {
		Cliente cli = null;
		ResultSet rs = conexionUno.query("Select * from Clientes where CLI_CEDULA =" + id);
		try {
			if (rs != null && rs.next()) {

				cli = new Cliente(rs.getString("CLI_CEDULA"), rs.getString("CLI_NOMBRE"), rs.getString("CLI_APELLIDO"),
						rs.getDouble("CLI_CREDITO"), rs.getString("CLI_CORREO"), rs.getString("CLI_CONTRASENIA"));

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:read): " + e.getMessage());

		}
		return cli;

	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		conexionUno.update("UPDATE Clientes SET CLI_NOMBRE = '" + cliente.getNombre() + "', CLI_APELLIDO = '"
				+ cliente.getApellido() + "', CLI_CREDITO = " + cliente.getCredito() + ", CLI_CORREO = '"
				+ cliente.getCorreo() + "', CLI_CONTRASENIA = '" + cliente.getContrasenia() + "' WHERE CLI_CEDULA = '"
				+ cliente.getCedula() + "'");

	}

	@Override
	public void delete(Cliente cliente) {
		// TODO Auto-generated method stub
		conexionUno.update("DELETE FROM Clientes WHERE CLI_CEDULA = '" + cliente.getCedula() + "'");

	}

	@Override
	public List<Cliente> find() {
		List<Cliente> list = new ArrayList<Cliente>();
		ResultSet rs = conexionUno.query("SELECT * FROM CLIENTES");
		try {
			while (rs.next()) {
				Cliente cli = new Cliente(rs.getString("CLI_CEDULA"), rs.getString("CLI_NOMBRE"),
						rs.getString("CLI_APELLIDO"), rs.getDouble("CLI_CREDITO"), rs.getString("CLI_CORREO"),
						rs.getString("CLI_CONTRASENIA"));
				list.add(cli);
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCShoppingBasketDAO:find): " + e.getMessage());
		}

		return list;
	}
	
	@Override
	public Cliente readByAddress(String id) {
		Cliente cli = null;
		ResultSet rs = conexionUno.query("Select * from Clientes where CLI_CORREO =" + id);
		try {
			if (rs != null && rs.next()) {

				cli = new Cliente(rs.getString("CLI_CEDULA"), rs.getString("CLI_NOMBRE"), rs.getString("CLI_APELLIDO"),
						rs.getDouble("CLI_CREDITO"), rs.getString("CLI_CORREO"), rs.getString("CLI_CONTRASENIA"));

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:read): " + e.getMessage());

		}
		return cli;

	}

}
