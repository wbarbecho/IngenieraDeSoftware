package ec.edu.ups.DAO;

public abstract class DAOGuia {

	protected static DAOGuia guia = new JDBCDAOGuia();
	/**
	 * @return the guia
	 */
	public static DAOGuia getGuia() {
		return guia;
	}

	public abstract void createTables();
	
	public abstract ClienteDAO getClienteDAO();
	public abstract LibroImpresoDAO getLibroImpresoDAO();
	public abstract LibroDigitalDAO getLibroDigitalDAO();
	public abstract CompraDAO getCompraDAO();

}
