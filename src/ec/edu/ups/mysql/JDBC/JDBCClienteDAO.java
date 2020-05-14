package ec.edu.ups.mysql.JDBC;

import java.util.List;

import ec.edu.ups.DAO.ClienteDAO;
import ec.edu.ups.modelo.Cliente;

public class JDBCClienteDAO extends JDBCGenericDAO<Cliente, String> implements ClienteDAO{

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Cliente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cliente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cliente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
