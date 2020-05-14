package ec.edu.ups.mysql.JDBC;

import java.util.List;

import ec.edu.ups.DAO.LibroImpresoDAO;
import ec.edu.ups.modelo.LibroImpreso;

public class JDBCLibroImpresoDAO extends JDBCGenericDAO<LibroImpreso, String> implements LibroImpresoDAO{

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}
//Create
	@Override
	public void create(LibroImpreso entity) {
		conexionUno.update("INSERT libros_digitales VALUES ('" + entity.getId() + "', '" + entity.getComision() + "', '"
				+ entity.getCostoEnvio() + ")");
		
	}

	@Override
	public void update(LibroImpreso entity) {
		// TODO Auto-generated method stub
		conexionUno.update("UPDATE libros_digitales SET lib_dig_id = '" + entity.getId() + "', lib_dig_comision = '"
				+ entity.getComision() + "', lib_isbn = " + entity.getIsbn() +  "' WHERE lib_dig_id = '"
				+ entity.getId()+ "'");
	}

	@Override
	public void delete(LibroImpreso entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LibroImpreso> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LibroImpreso read(String id) {
		// TODO Auto-generated method stub
		return null;
	}



}
