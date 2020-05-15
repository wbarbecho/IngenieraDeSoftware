package ec.edu.ups.mysql.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ec.edu.ups.DAO.LibroDigitalDAO;

import ec.edu.ups.modelo.LibroDigital;

public class JDBCLibroDigitalDAO extends JDBCGenericDAO<LibroDigital, String> implements LibroDigitalDAO {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(LibroDigital entity) {
		conexionUno.update("INSERT Libros VALUES ('" + entity.getIsbn() + "', '" + entity.getTitulo() + "', '"
				+ entity.getAutor() + "', '" + entity.getEdicion() + "', " + entity.getPrecio() + ", '"
				+ entity.getImagen() + "')");

		conexionUno.update("INSERT libros_digitales (lib_dig_comision, lib_isbn) VALUES (" + entity.getComision() + ", '"
				+ entity.getIsbn() + "')");

	}

	@Override
	public LibroDigital read(String isbn) {
		// TODO Auto-generated method stub
		LibroDigital libDig = null;
		ResultSet rs = conexionDos.query(
				"select * from libros inner join libros_digitales ON libros.lib_isbn = libros_digitales.lib_isbn WHERE libros_digitales.lib_isbn ='"
						+ isbn+"'");
		try {
			if (rs != null && rs.next()) {
				libDig = new LibroDigital(rs.getString("libros.lib_isbn"), rs.getString("libros.lib_titulo"),
						rs.getString("libros.lib_autor"), rs.getString("libros.lib_edicion"),
						rs.getString("libros.lib_ubi_img"), rs.getDouble("libros.lib_precio"), null,
						0,rs.getDouble("lib_dig_comision"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCLibroDigitalDAO:read): " + e.getMessage());
		}
		return libDig;
	}

	@Override
	public void update(LibroDigital entity) {
		conexionUno.update("UPDATE libros_digitales SET lib_dig_id = '" + entity.getId() + "', lib_dig_comision = '"
				+ entity.getComision() + "', lib_isbn = " + entity.getIsbn() + "' WHERE lib_dig_id = '" + entity.getId()
				+ "'");

	}

	@Override
	public void delete(LibroDigital entity) {
		// TODO Auto-generated method stub
		conexionUno.update("DELETE FROM libros_digitales WHERE lib_dig_id = '" + entity.getId() + "'");
	}

	@Override
	public List<LibroDigital> find() {
		List<LibroDigital> list = new ArrayList<LibroDigital>();
		ResultSet rs = conexionUno.query(
				"select * from libros inner join libros_digitales ON libros.lib_isbn = libros_digitales.lib_isbn");
		try {
			while (rs.next()) {
				LibroDigital libbDig = new LibroDigital(rs.getString("libros.lib_isbn"),
						rs.getString("libros.lib_titulo"), rs.getString("libros.lib_autor"),
						rs.getString("libros.lib_edicion"), rs.getString("libros.lib_ubi_img"),
						rs.getDouble("libros.lib_precio"), null, 0, rs.getDouble("lib_dig_comision"));
				list.add(libbDig);
			}

		} catch (SQLException E) {
			System.out.println(">>>WARNING (JDBCLibroDigitalDAO:read): \" + e.getMessage()");
		}
		return list;
	}

}
