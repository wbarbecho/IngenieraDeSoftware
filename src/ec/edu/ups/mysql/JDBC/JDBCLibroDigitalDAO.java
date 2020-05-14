package ec.edu.ups.mysql.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ec.edu.ups.DAO.LibroDigitalDAO;

import ec.edu.ups.modelo.LibroDigital;
import ec.edu.ups.modelo.Libro;

import ec.edu.ups.modelo.LibroDigital;
public class JDBCLibroDigitalDAO extends JDBCGenericDAO<LibroDigital, String> implements LibroDigitalDAO{

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(LibroDigital entity) {
		conexionUno.update("INSERT libros_digitales VALUES ('" + entity.getId() + "', '" + entity.getComision()  + "', '"
				+ entity.getIsbn()+ ")");
		
	}

	@Override
	public LibroDigital read(String id) {
		// TODO Auto-generated method stub
		LibroDigital libDig = null;
		Libro lib= null;
		ResultSet rs = conexionUno.query("SELECT * FROM libros_digitales WHERE lib_dig_id ="+ id);
		try {
			if (rs != null && rs.next()) {

				libDig = new LibroDigital(rs.getInt("lib_dig_id"), rs.getDouble("lib_dig_comision"),rs.getString("lib_isbn"));

				ResultSet rs1 = conexionUno.query("SELECT * FROM libro WHERE lib_isbn"+ rs.getString("lib_isbn"));
				
				if(rs1 != null && rs1.next()) {
					lib = new Libro(rs.getS) {
					};
				}
			

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCLibroDigitalDAO:read): " + e.getMessage());

		}
		return libDig;
	}

	@Override
	public void update(LibroDigital entity) {
		conexionUno.update("UPDATE libros_digitales SET lib_dig_id = '" + entity.getId() + "', lib_dig_comision = '"
				+ entity.getComision() + "', lib_isbn = " + entity.getIsbn() +  "' WHERE lib_dig_id = '"
				+ entity.getId()+ "'");

	}
	

	@Override
	public void delete(LibroDigital entity) {
		// TODO Auto-generated method stub
		conexionUno.update("DELETE FROM libros_digitales WHERE lib_dig_id = '" + entity.getId() + "'");
	}

	@Override
	public List<LibroDigital> find() {
		List <LibroDigital> list = new ArrayList<LibroDigital>();
		ResultSet rs = conexionUno.query("SELECT * FROM libros_digitales");
		try {
			while(rs.next()) {
				LibroDigital libbDig = new LibroDigital(rs.getInt("lib_dig_id"), rs.getDouble("lib_dig_comision"),rs.getString("lib_isbn"));
				list.add(libbDig);
			}
		
		}catch(SQLException E) {
			System.out.println(">>>WARNING (JDBCLibroDigitalDAO:read): \" + e.getMessage()");
		}
		return null;
	}

}
