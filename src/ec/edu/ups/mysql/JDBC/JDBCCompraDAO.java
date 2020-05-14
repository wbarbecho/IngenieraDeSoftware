package ec.edu.ups.mysql.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.DAO.CompraDAO;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Compra;
import ec.edu.ups.modelo.Libro;
import ec.edu.ups.modelo.LibroDigital;
import ec.edu.ups.modelo.LibroImpreso;

public class JDBCCompraDAO extends JDBCGenericDAO<Compra, String> implements CompraDAO {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(Compra compra) {
		// TODO Auto-generated method stub
		for (Libro libro : compra.getListaDigitales()) {
			conexionUno.update("INSERT compras VALUES ('" + "null" + compra.getFecha() + compra.getCliente().getCedula()
					+ libro + ")");

		}
		for (Libro libro : compra.getListaImpresos()) {
			conexionUno.update("INSERT compras VALUES ('" + "null" + compra.getFecha() + compra.getCliente().getCedula()
					+ libro + ")");

		}
	}

	@Override
	public Compra read(String cedula) {
		// TODO Auto-generated method stub
		JDBCClienteDAO buscarCliente = new JDBCClienteDAO();
		Cliente cliente = buscarCliente.read(cedula);
		JDBCLibroDigitalDAO buscarDigital = new JDBCLibroDigitalDAO();
		ArrayList<LibroDigital> listaDigitales = new ArrayList<LibroDigital>();
		ArrayList<LibroImpreso> ListaImpresos = new ArrayList<LibroImpreso>();

		Compra compra = null;
		ResultSet rs = conexionDos.query("select * from compras where cli_cedula = " + cedula);
		try {
			if (rs != null && rs.next()) {
				listaDigitales.add(buscarDigital.read(rs.getString("lib_isbn")));
				// Ingresar Busqueda libro
				compra = new Compra(rs.getInt("compr_id"), rs.getDate("compr_fecha"), cliente, listaDigitales,
						ListaImpresos);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:read): " + e.getMessage());
		}
		if (compra == null) {
			return null;
		}
		return compra;
	}

	@Override
	public void update(Compra entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Compra entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Compra> find() {
		List<Compra> list = new ArrayList<Compra>();
		ResultSet rs = conexionUno.query("SELECT * FROM compras");
		JDBCLibroDigitalDAO buscarDigital = new JDBCLibroDigitalDAO();
		ArrayList<LibroDigital> listaDigitales = new ArrayList<LibroDigital>();
		ArrayList<LibroImpreso> ListaImpresos = new ArrayList<LibroImpreso>();
		try {
			JDBCClienteDAO buscarCliente = new JDBCClienteDAO();
			while (rs.next()) {
				Cliente cliente = buscarCliente.read(rs.getString("CLI_CEDULA"));
				listaDigitales.add(buscarDigital.read(rs.getString("lib_isbn")));
				// Ingresar Busqueda libro

				Compra comp = new Compra(rs.getInt("compr_id"), rs.getDate("compr_fecha"), cliente, listaDigitales,
						ListaImpresos);

				list.add(comp);

			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCShoppingBasketDAO:find): " + e.getMessage());
		}

		return list;
	}
}
