import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ec.edu.ups.DAO.ClienteDAO;
import ec.edu.ups.DAO.DAOGuia;
import ec.edu.ups.DAO.LibroDigitalDAO;
import ec.edu.ups.DAO.LibroImpresoDAO;
import ec.edu.ups.controlador.CliController;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.LibroDigital;
import ec.edu.ups.modelo.LibroImpreso;
import ec.edu.ups.mysql.JDBC.JDBCClienteDAO;
import ec.edu.ups.mysql.JDBC.JDBCLibroDigitalDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido 'Template Method'");
		System.out.println("Integrante:");
		System.out.println("Bryam Guzman");
		System.out.println("Wilson Barbecho");
		System.out.println("Hugo Zhindon");
		System.out.println("Adrian Tene");
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion; //Guardaremos la opcion del usuario
		
		JDBCClienteDAO cli = new JDBCClienteDAO();
		List<Cliente> clientes = cli.find();
		Cliente clienteGlobal = null;
		boolean user = false;
		boolean correcto = false;
		System.out.println("Iniciar Sesion");
		while (!correcto) {
			
			System.out.println("Ingresar Correo:");
			String correo = sn.nextLine();

			System.out.println("Ingresar contrasenia:");
			String contrasenia = sn.nextLine();
			System.out.println("Mijo");
			for (Cliente cliente : clientes) {
				clienteGlobal = cli.readByAddress(correo);
				if (cliente.getCorreo().equals(correo) && cliente.getContrasenia().equals(contrasenia)) {
					
					correcto = true;
					
					System.out.println(clienteGlobal);
					System.out.println("Bienvenido usuari@: \n \t" + clienteGlobal.getNombre() + " " + clienteGlobal.getApellido());
					if (clienteGlobal.getRol().equals("User"))
						user = true;

				}
				
				
			}
			if (!correcto)
				System.out.println("Usuario invalido, ingrese nuevamente, por favor!");
		}
		while (!salir) {
			if(user) {

			}else {




				System.out.println("1. Registrar Libro:");
				System.out.println("2. Listar Libros");
				System.out.println("3. Listar Clientes");
				System.out.println("4. Salir");
				try {

					System.out.println("Escoge una de las opciones");
					opcion = sn.nextInt();

					switch (opcion) {
					case 1:
						System.out.println("Tipo de libro: 1. Digital; 2. Impreso");
						int tipo = sn.nextInt();
						System.out.println("Registrar Libro");
						System.out.print("Ingrese ISBN:");
						String isbn = sn.next();
					
						System.out.print("Ingrese Titulo:");
						String titulo = sn.next();
						System.out.print("Ingrese Autor:");
						String autor = sn.next();
						System.out.print("Ingrese Edicion:");
						String edicion = sn.next();
						System.out.print("Ingreso Precio: ");
						double precio = sn.nextDouble();
						if(tipo == 1) {

							LibroDigital lib = new LibroDigital(isbn, titulo, autor, edicion, "null", precio, null, 2, 0.04);

							LibroDigitalDAO libroDigitalDAO = DAOGuia.getGuia().getLibroDigitalDAO();
							libroDigitalDAO.create(lib); 
						}else {
							LibroImpreso lib = new LibroImpreso(isbn, titulo, autor, edicion, "null", precio, null, 3, 0.02, 20.00);
							LibroImpresoDAO libroImpresoDAO = DAOGuia.getGuia().getLibroImpresoDAO();
							libroImpresoDAO.create(lib);
						}

						break;
					case 2:
						System.out.println("Listar Libros");
						System.out.println("Escoger Tipo de libro: 1. Digital; 2. Impreso");
						int tipo1 = sn.nextInt();
						if(tipo1==1) {
							LibroDigitalDAO libroDigitalDAO = DAOGuia.getGuia().getLibroDigitalDAO();
							List<LibroDigital> libroDig = libroDigitalDAO.find();
							for (LibroDigital libroDigital : libroDig) {
								System.out.println("Libro: " + libroDigital);
							}
						}else {
							LibroImpresoDAO libroImpresoDAO = DAOGuia.getGuia().getLibroImpresoDAO();
							List<LibroImpreso> libroImpr = libroImpresoDAO.find();
							for (LibroImpreso libroImpreso : libroImpr) {
								System.out.println("Libro: " + libroImpreso );
							}
						}
						
						break;
					case 3:
						System.out.println("Listar Clientes");
						ClienteDAO clienteDAO = DAOGuia.getGuia().getClienteDAO();
						List<Cliente> cliList = clienteDAO.find();
						for (Cliente cliente : cliList) {
							System.out.println(cliente);
						}
						break;
					case 4:
						salir = true;
						break;
					default:
						System.out.println("Solo números entre 1 y 4");
					}
				} catch (InputMismatchException e) {
					System.out.println("Debes insertar un número");
					sn.next();
				}
			}
		}
		
		System.out.println("Gracias por su visita, vuelva pronto amig@!");


	}
}
