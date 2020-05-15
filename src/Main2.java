import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ec.edu.ups.DAO.ClienteDAO;
import ec.edu.ups.DAO.DAOGuia;
import ec.edu.ups.DAO.LibroDigitalDAO;
import ec.edu.ups.DAO.LibroImpresoDAO;
import ec.edu.ups.controlador.CliController;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Compra;
import ec.edu.ups.modelo.Libro;
import ec.edu.ups.modelo.LibroDigital;
import ec.edu.ups.modelo.LibroImpreso;
import ec.edu.ups.mysql.JDBC.JDBCClienteDAO;
import ec.edu.ups.mysql.JDBC.JDBCCompraDAO;
import ec.edu.ups.mysql.JDBC.JDBCLibroDigitalDAO;
import ec.edu.ups.mysql.JDBC.JDBCLibroImpresoDAO;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Libro libro;
		JDBCClienteDAO cli = new JDBCClienteDAO();
		JDBCLibroDigitalDAO catalogoDigi = new JDBCLibroDigitalDAO();
		JDBCLibroImpresoDAO catalogoImp = new JDBCLibroImpresoDAO();

		System.out.println(catalogoDigi.read("isb1"));
		System.out.println(catalogoImp.read("isb2"));
		
		System.out.println("digital");
		libro = catalogoDigi.read("isb1");
		libro.calcularPrecio();
		System.out.println("Impreso");
		libro = catalogoImp.read("isb2");
		libro.calcularPrecio();

	}

}
