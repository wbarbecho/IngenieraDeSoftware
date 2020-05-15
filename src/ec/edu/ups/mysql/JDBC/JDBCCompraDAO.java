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
			conexionUno.update("INSERT compras VALUES (null," + "curdate()," + "'" + compra.getCliente().getCedula()
					+ "','" + libro.getIsbn() + "')");
		}

		for (Libro libro : compra.getListaImpresos()) {
			conexionUno.update("INSERT compras VALUES (null," + "curdate()," + "'" + compra.getCliente().getCedula()
					+ "','" + libro.getIsbn() + "')");

		}
	}

	@Override
	public Compra read(String cedula) {
		// TODO Auto-generated method stub
		JDBCClienteDAO buscarCliente = new JDBCClienteDAO();
		Cliente cliente = buscarCliente.read(cedula);
		JDBCLibroDigitalDAO buscarDigital = new JDBCLibroDigitalDAO();
		JDBCLibroImpresoDAO buscarImpres = new JDBCLibroImpresoDAO();
		ArrayList<LibroDigital> listaDigitales = new ArrayList<LibroDigital>();
		ArrayList<LibroImpreso> ListaImpresos = new ArrayList<LibroImpreso>();

		Compra compra = null;
		ResultSet rs3 = conexionTres.query("select * from compras where cli_cedula = " + cedula);
		try {
			if (rs3 != null && rs3.next()) {
				if (buscarDigital.read(rs3.getString("lib_isbn")) != null) {
					listaDigitales.add(buscarDigital.read(rs3.getString("lib_isbn")));
				} else if (buscarImpres.read(rs3.getString("lib_isbn")) != null) {
					ListaImpresos.add(buscarImpres.read(rs3.getString("lib_isbn")));
				}
				compra = new Compra(rs3.getInt("compr_id"), rs3.getDate("compr_fecha"), cliente, listaDigitales,
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
		JDBCLibroImpresoDAO buscarImpres = new JDBCLibroImpresoDAO();
		JDBCClienteDAO buscarCliente = new JDBCClienteDAO();
		ArrayList<String> cedulas = new ArrayList<String>();
		ArrayList<String> isbnLista = new ArrayList<String>();
		try {
			while (rs.next()) {
				isbnLista.add(rs.getString("lib_isbn"));
				cedulas.add(rs.getString("cli_cedula"));
				Compra comp = new Compra(rs.getInt("compr_id"), rs.getDate("compr_fecha"), null,
						new ArrayList<LibroDigital>(), new ArrayList<LibroImpreso>());
				list.add(comp);
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCShoppingBasketDAO:find): " + e.getMessage());
		}

		for (int i = 0; i < list.size(); i++) {
			list.get(i).setCliente(buscarCliente.read(cedulas.get(i)));
			if (buscarDigital.read(isbnLista.get(i)) != null) {
				list.get(i).getListaDigitales().add(buscarDigital.read(isbnLista.get(i)));
			} else if (buscarImpres.read(isbnLista.get(i)) != null) {
				list.get(i).getListaImpresos().add(buscarImpres.read(isbnLista.get(i)));
			}
		}

		return list;
	}
	
	public List<Compra> findById(String id) {
		List<Compra> list = new ArrayList<Compra>();
		ResultSet rs = conexionUno.query("SELECT * FROM compras where cli_cedula = '" + id + "'");
		JDBCLibroDigitalDAO buscarDigital = new JDBCLibroDigitalDAO();
		JDBCLibroImpresoDAO buscarImpres = new JDBCLibroImpresoDAO();
		JDBCClienteDAO buscarCliente = new JDBCClienteDAO();
		ArrayList<String> cedulas = new ArrayList<String>();
		ArrayList<String> isbnLista = new ArrayList<String>();
		try {
			while (rs.next()) {
				isbnLista.add(rs.getString("lib_isbn"));
				cedulas.add(rs.getString("cli_cedula"));
				Compra comp = new Compra(rs.getInt("compr_id"), rs.getDate("compr_fecha"), null,
						new ArrayList<LibroDigital>(), new ArrayList<LibroImpreso>());
				list.add(comp);
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCShoppingBasketDAO:find): " + e.getMessage());
		}

		for (int i = 0; i < list.size(); i++) {
			list.get(i).setCliente(buscarCliente.read(cedulas.get(i)));
			if (buscarDigital.read(isbnLista.get(i)) != null) {
				list.get(i).getListaDigitales().add(buscarDigital.read(isbnLista.get(i)));
			} else if (buscarImpres.read(isbnLista.get(i)) != null) {
				list.get(i).getListaImpresos().add(buscarImpres.read(isbnLista.get(i)));
			}
		}

		return list;
	}
}
