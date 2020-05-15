import java.sql.Date;
import java.util.ArrayList;

import ec.edu.ups.modelo.Compra;
import ec.edu.ups.modelo.Libro;
import ec.edu.ups.modelo.LibroDigital;
import ec.edu.ups.modelo.LibroImpreso;
import ec.edu.ups.mysql.JDBC.JDBCClienteDAO;
import ec.edu.ups.mysql.JDBC.JDBCLibroDigitalDAO;
import ec.edu.ups.mysql.JDBC.JDBCLibroImpresoDAO;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Libro libro;
		JDBCClienteDAO cli = new JDBCClienteDAO();
		JDBCLibroDigitalDAO catalogoDigi = new JDBCLibroDigitalDAO();
		JDBCLibroImpresoDAO catalogoImp = new JDBCLibroImpresoDAO();

		System.out.println(cli.read("1111111111"));
		System.out.println(catalogoDigi.read("isb1"));
		System.out.println(catalogoImp.read("isb2"));
		System.out.println("digital");
		libro = catalogoDigi.read("isb1");
		System.out.println(libro);
		System.out.println();
		System.out.println("Impreso");
		libro = catalogoImp.read("isb2");
		System.out.println(libro);

		Date today = new Date(System.currentTimeMillis());
		System.out.println(today);

		Compra comprado = new Compra(0, today, cli.read("1111111111"), new ArrayList<LibroDigital>(), new ArrayList<LibroImpreso>());
		
		System.out.println(comprado);
	}

}
