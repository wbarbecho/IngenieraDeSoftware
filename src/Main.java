import ec.edu.ups.controlador.CliController;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.LibroDigital;
import ec.edu.ups.mysql.JDBC.JDBCClienteDAO;
import ec.edu.ups.mysql.JDBC.JDBCLibroDigitalDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBCClienteDAO t1 = new JDBCClienteDAO();
		System.out.println(t1.read("0000000000"));
		Cliente cliente = new Cliente("1234567890", "JU", "sad", 123.0, "adsa123", "asdas");
		// t1.create(cliente);

		System.out.println(t1.find());
		for (Cliente cli : t1.find()) {
			System.out.println(cli);
		}

		System.out.println("----------------------");
		JDBCLibroDigitalDAO digital = new JDBCLibroDigitalDAO();
		LibroDigital lib = new LibroDigital("isbn", "titulo", "autor", "edicion", "imagen", 200, null, 11, 20.0);
		// digital.create(lib);
		System.out.println(digital.read("isbn").toString());

		System.out.println(digital.find());
		for (LibroDigital digi : digital.find()) {
			System.out.println(digi);

		}

	}

}
