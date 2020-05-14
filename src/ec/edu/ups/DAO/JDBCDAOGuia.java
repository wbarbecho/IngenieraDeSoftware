package ec.edu.ups.DAO;

import ec.edu.ups.mysql.JDBC.JDBCClienteDAO;
import ec.edu.ups.mysql.JDBC.JDBCCompraDAO;
import ec.edu.ups.mysql.JDBC.JDBCLibroDigitalDAO;
import ec.edu.ups.mysql.JDBC.JDBCLibroImpresoDAO;

public class JDBCDAOGuia extends DAOGuia{

	
	
	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new JDBCClienteDAO();
	}

	@Override
	public LibroImpresoDAO getLibroImpresoDAO() {
		// TODO Auto-generated method stub
		return new JDBCLibroImpresoDAO();
	}

	@Override
	public LibroDigitalDAO getLibroDigitalDAO() {
		// TODO Auto-generated method stub
		return new JDBCLibroDigitalDAO();
	}

	@Override
	public CompraDAO getCompraDAO() {
		// TODO Auto-generated method stub
		return new JDBCCompraDAO();
	}

	@Override
	public void createTables() {
		// TODO Auto-generated method stub
		this.getClienteDAO().createTable();
		this.getCompraDAO().createTable();
		this.getLibroDigitalDAO().createTable();
		this.getLibroImpresoDAO().createTable();
		
	}

}
