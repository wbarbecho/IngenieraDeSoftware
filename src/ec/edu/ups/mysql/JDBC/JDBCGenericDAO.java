package ec.edu.ups.mysql.JDBC;

import ec.edu.ups.DAO.GenericDAO;

public abstract class JDBCGenericDAO <T, ID> implements GenericDAO<T, ID>{
	
	protected ContextJDBC conexionUno = ContextJDBC.getJDBC1();
	protected ContextJDBC conexionDos = ContextJDBC.getJDBC2();

}
