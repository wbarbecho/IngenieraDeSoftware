import java.util.ArrayList;
import java.sql.Date;
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

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido 'Template Method'");
		System.out.println("Integrantes:");
		System.out.println("Bryam Guzman");
		System.out.println("Wilson Barbecho");
		System.out.println("Hugo Zhindon");
		System.out.println("Adrian Tene");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("************MENU************");
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion; // Guardaremos la opcion del usuario

		boolean seguir = true;

		boolean user = false;
		boolean correcto = false;
		int sesion = 0;
		Cliente clienteGlobal = null;

		while (seguir) {

			System.out.println("1. Inciar Sesion \n2. Registrar \n3. Salir");

			sesion = sn.nextInt();

			switch (sesion) {
			case 1:
				System.out.println("Iniciar Sesion");

				while (!correcto) {
					JDBCClienteDAO cli = new JDBCClienteDAO();
					List<Cliente> clientes = cli.find();

					System.out.println("Ingresar Correo:");
					String correo = sn.next();

					System.out.println("Ingresar contrasenia:");
					String contrasenia = sn.next();
					System.out.println("Mijo");
					for (Cliente cliente : clientes) {
						clienteGlobal = cli.readByAddress(correo);
						if (cliente.getCorreo().equals(correo) && cliente.getContrasenia().equals(contrasenia)) {

							correcto = true;

							System.out.println("Bienvenido usuari@: \n \t" + clienteGlobal.getNombre() + " "
									+ clienteGlobal.getApellido() + "\n \t$" + clienteGlobal.getCredito());
							if (clienteGlobal.getRol().equals("User"))
								user = true;

						}

					}
					if (!correcto)
						System.out.println("Usuario invalido, ingrese nuevamente, por favor!");
				}
				while (!salir) {
					if (user) {

						System.out.println("1. Actualizar Datos Personales");
						System.out.println("2. Listar Libros Disponibles");
						System.out.println("3. Listar Compras realizadas");
						System.out.println("4. Recargar Credito");
						System.out.println("5. Realizar Compra");

						System.out.println("Escoge una de las opciones:");
						opcion = sn.nextInt();

						switch (opcion) {
						case 1:
							System.out.println("Informacion Actual del Usuario");
							JDBCClienteDAO cli = new JDBCClienteDAO();
							clienteGlobal = cli.read(clienteGlobal.getCedula());
							System.out.println(clienteGlobal);
							System.out.println("Ingrese informacion que desea modificar:");
							String nombre = "";
							String apellido = "";
							String correo = "";
							String password = "";
							System.out.print("Ingrese Nombre: ");
							nombre = sn.next();
							System.out.print("Ingrese Apellido: ");
							apellido = sn.next();
							System.out.print("Recargar Credito: ");
							double credito = sn.nextDouble();
							double actual = clienteGlobal.getCredito();
							System.out.println("Ingrese Correo: ");
							correo = sn.next();
							System.out.println("Ingrese Contrasenia: ");
							password = sn.next();
							clienteGlobal.setNombre(nombre);
							clienteGlobal.setApellido(apellido);
							clienteGlobal.setCredito(actual += credito);
							clienteGlobal.setCorreo(correo);
							clienteGlobal.setContrasenia(password);
							ClienteDAO clienteDAO = DAOGuia.getGuia().getClienteDAO();
							clienteDAO.update(clienteGlobal);

							System.out.println("***Informacion Actualizada: ");

							System.out.println(clienteGlobal);

							break;

						case 2:
							System.out.println("Listar Libros");
							System.out.println("Escoger Tipo de libro: 1. Digital; 2. Impreso");
							int tipo1 = sn.nextInt();
							if (tipo1 == 1) {
								LibroDigitalDAO libroDigitalDAO = DAOGuia.getGuia().getLibroDigitalDAO();
								List<LibroDigital> libroDig = libroDigitalDAO.find();
								for (LibroDigital libroDigital : libroDig) {
									System.out.println("Libro: " + libroDigital);
								}
							} else {
								LibroImpresoDAO libroImpresoDAO = DAOGuia.getGuia().getLibroImpresoDAO();
								List<LibroImpreso> libroImpr = libroImpresoDAO.find();
								for (LibroImpreso libroImpreso : libroImpr) {
									System.out.println("Libro: " + libroImpreso);
								}
							}

							break;

						case 3:

							System.out.println("El usuario ha realizado las siguientes compras:");
							JDBCCompraDAO comp = new JDBCCompraDAO();
							int i = 0;
							for (Compra compra : comp.find()) {

								if (compra.getCliente().getCedula().equals(clienteGlobal.getCedula())) {
									System.out.println(i + ". " + compra);
									System.out.println("\t" + compra.getCliente());
									if (compra.getListaDigitales().size() > 0)
										System.out.println("\t" + compra.getListaDigitales());
									if (compra.getListaImpresos().size() > 0)
										System.out.println("\t" + compra.getListaImpresos());
									if (compra.getListaImpresos().size() == 0 || compra.getListaDigitales().size() == 0)
										System.out.println("El usuario no a realizado Compras");
									i++;

								}
							}

							break;
						case 4:

							System.out.println("Recargar Credito");
							System.out.println("Saldo Actual:" + clienteGlobal.getCredito());

							System.out.println("Ingresar monto a Recargar:");

							double monto = sn.nextDouble();
							double current = clienteGlobal.getCredito();
							current += monto;
							ClienteDAO clienteDAO1 = DAOGuia.getGuia().getClienteDAO();
							clienteGlobal.setCredito(current);
							clienteDAO1.updateBalance(current, clienteGlobal.getCedula());

							System.out.println("Se ha actualizado con exito!");
							System.out.println("Su credito actual es:");
							System.out.println(clienteGlobal.getCredito());

							break;

						case 5:
							System.out.println("Catalogo");

							LibroDigitalDAO libroDigitalDAO = DAOGuia.getGuia().getLibroDigitalDAO();
							List<LibroDigital> libroDig = libroDigitalDAO.find();
							for (LibroDigital libroDigital : libroDig) {
								System.out.println("Libro: " + libroDigital);
							}

							LibroImpresoDAO libroImpresoDAO = DAOGuia.getGuia().getLibroImpresoDAO();
							List<LibroImpreso> libroImpr = libroImpresoDAO.find();
							for (LibroImpreso libroImpreso : libroImpr) {
								System.out.println("Libro: " + libroImpreso);

							}

							System.out.println("******Realizar Compra******");

							JDBCCompraDAO compraDAO = new JDBCCompraDAO();

							boolean otro = true;
							Date fecha = new Date(System.currentTimeMillis());
							Compra comprado = new Compra(0, fecha, clienteGlobal, new ArrayList<LibroDigital>(),
									new ArrayList<LibroImpreso>());

							while (otro) {

								System.out.println("Ingrese ISBN de libro, por favor!");
								JDBCLibroDigitalDAO libroD = new JDBCLibroDigitalDAO();
								JDBCLibroImpresoDAO libroI = new JDBCLibroImpresoDAO();
								String codigo = sn.next();
								if (libroD.read(codigo) != null)
									comprado.addLibroDigital(libroD.read(codigo));
								else if (libroI.read(codigo) != null)
									comprado.addLibroImpreso(libroI.read(codigo));
								else
									System.out.println("Verifique codigo");

								System.out.println("Agregar otro libro:");
								System.out.println("1. Si");
								System.out.println("2. No");

								int decision = sn.nextInt();
								if (decision == 2)
									otro = false;

							}
							compraDAO.create(comprado);
							double saldoActual = clienteGlobal.getCredito();
							saldoActual -= comprado.totalCostes();
							ClienteDAO clienteControl = DAOGuia.getGuia().getClienteDAO();
							clienteGlobal.setCredito(saldoActual);
							clienteControl.update(clienteGlobal);
							System.out.println("Compra realizadada com Exito!");
							break;

						default:
							break;
						}

					} else {

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

								if (tipo == 1) {

									LibroDigital lib = new LibroDigital(isbn, titulo, autor, edicion, "null", precio,
											null, 2, 0.04);

									LibroDigitalDAO libroDigitalDAO = DAOGuia.getGuia().getLibroDigitalDAO();
									libroDigitalDAO.create(lib);
								} else {
									LibroImpreso lib = new LibroImpreso(isbn, titulo, autor, edicion, "null", precio,
											null, 3, 0.02, 20.00);
									LibroImpresoDAO libroImpresoDAO = DAOGuia.getGuia().getLibroImpresoDAO();
									libroImpresoDAO.create(lib);
								}

								break;
							case 2:
								System.out.println("Listar Libros");
								System.out.println("Escoger Tipo de libro: 1. Digital; 2. Impreso");
								int tipo1 = sn.nextInt();
								if (tipo1 == 1) {
									LibroDigitalDAO libroDigitalDAO = DAOGuia.getGuia().getLibroDigitalDAO();
									List<LibroDigital> libroDig = libroDigitalDAO.find();
									for (LibroDigital libroDigital : libroDig) {
										System.out.println("Libro: " + libroDigital);
									}
								} else {
									LibroImpresoDAO libroImpresoDAO = DAOGuia.getGuia().getLibroImpresoDAO();
									List<LibroImpreso> libroImpr = libroImpresoDAO.find();
									for (LibroImpreso libroImpreso : libroImpr) {
										System.out.println("Libro: " + libroImpreso);
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
								System.out.println("Solo n�meros entre 1 y 4");
							}
						} catch (InputMismatchException e) {
							System.out.println("Debes insertar un n�mero");
							sn.next();
						}
					}
				}

				System.out.println("Gracias por su visita, vuelva pronto amig@!");

				break;

			case 2:

				System.out.println("Registrar");
				System.out.print("Ingrese Cedula: ");
				String cedula = sn.next();
				System.out.print("Ingrese Nombre: ");
				String nombre = sn.next();
				System.out.print("Ingrese Apellido: ");
				String apellido = sn.next();
				System.out.print("Ingrese Credito: ");
				double credito = sn.nextDouble();
				System.out.println("Ingrese Correo: ");
				String correo = sn.next();
				System.out.println("Ingrese Contrasenia: ");
				String password = sn.next();
				Cliente cli = new Cliente(cedula, nombre, apellido, credito, correo, password, "User");
				ClienteDAO clienteDAO = DAOGuia.getGuia().getClienteDAO();
				clienteDAO.create(cli);
				System.out.println("Gracias por unirse a nosotros!");

				break;

			case 3:

				seguir = false;

			default:
				break;
			}
		}
	}
}
