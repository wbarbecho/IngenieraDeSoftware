package ec.edu.ups.mysql.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.DAO.LibroImpresoDAO;
import ec.edu.ups.modelo.LibroImpreso;

public class JDBCLibroImpresoDAO extends JDBCGenericDAO<LibroImpreso, String> implements LibroImpresoDAO {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub

	}

	public void create(LibroImpreso libro) {
		// TODO Auto-generated method stub

		conexionUno.update(
				"INSERT Libros VALUES ('" + libro.getIsbn() + "', '" + libro.getTitulo() + "', '" + libro.getAutor()
						+ "', '" + libro.getEdicion() + "', " + libro.getPrecio() + ", '" + libro.getImagen() + "')");
		conexionUno.update("INSERT libros_impresos VALUES (" + libro.getId() + ", " + libro.getComision() + ", "
				+ libro.getCostoEnvio() + ", '" + libro.getIsbn() + "')");
	}

	@Override
	public LibroImpreso read(String isbn) {
		// TODO Auto-generated method stub
		LibroImpreso libro = null;
		ResultSet rs = conexionUno.query(
				"select * from libros inner join libros_impresos ON libros.lib_isbn = libros_impresos.lib_isbn WHERE libros.lib_isbn = '"
						+ isbn + "'");
		try {
			/**
			 * String isbn, String titulo, String autor, String edicion, String imagen,
			 * double precio, ec.edu.ups.modelo.Libro libro, int id, double comision, double
			 * costoEnvio
			 */
			if (rs != null && rs.next()) {
				libro = new LibroImpreso(rs.getString("libros.lib_isbn"), rs.getString("libros.lib_titulo"),
						rs.getString("libros.lib_autor"), rs.getString("libros.lib_edicion"),
						rs.getString("libros.lib_ubi_img"), rs.getDouble("libros.lib_precio"), null, 0,
						rs.getDouble("lib_impr_com"),rs.getDouble("lib_impr_costo_envio"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:read): " + e.getMessage());
		}
		return libro;
	}

	@Override
	public void update(LibroImpreso libro) {
		// TODO Auto-generated method stub
		/*
		 * conexionUno.update("UPDATE libros_impresos SET lib_impr_com = '" +
		 * libro.getComision() + "', lib_impr_costo= '" + libro.getCostoEnvio() +
		 * "' WHERE lib_isbn = '" + libro.getIsbn() + "'");
		 */
	}

	@Override
	public void delete(LibroImpreso libro) {
		// TODO Auto-generated method stub
		/*
		 * conexionUno.update("DELETE FROM libros_impresos WHERE lib_impr_id = '" +
		 * libro.getId() + "'");
		 */
	}

	@Override
	public List<LibroImpreso> find() {
		// TODO Auto-generated method stub
		List<LibroImpreso> list = new ArrayList<LibroImpreso>();
		ResultSet rs = conexionUno.query(
				"select * from libros inner join libros_impresos ON libros.lib_isbn = libros_impresos.lib_isbn");
		try {
			while (rs.next()) {
				LibroImpreso libro = new LibroImpreso(rs.getString("libros.lib_isbn"), rs.getString("libros.lib_titulo"),
						rs.getString("libros.lib_autor"), rs.getString("libros.lib_edicion"),
						rs.getString("libros.lib_ubi_img"), rs.getDouble("libros.lib_precio"), null, 0,
						rs.getDouble("lib_impr_com"),rs.getDouble("lib_impr_costo_envio"));
				list.add(libro);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCShoppingBasketDAO:find): " + e.getMessage());
		}
		return list;
	}

}
