package ec.edu.ups.DAO;

import ec.edu.ups.modelo.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente, String>{

	Cliente readByAddress(String id);
	
	void updateBalance(Double balance, String id);
	

}
