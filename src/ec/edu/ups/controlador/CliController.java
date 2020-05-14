package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.DAO.ClienteDAO;
import ec.edu.ups.DAO.DAOGuia;
import ec.edu.ups.modelo.Cliente;

/**
 * Servlet implementation class CliController
 */
@WebServlet("/CliController")
public class CliController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CliController() {
        super();
        // TODO Auto-generated constructor stub
        
        /*
        ClienteDAO clienteDAO = DAOGuia.getGuia().getClienteDAO();
        Cliente cli = new Cliente("0102944816", "Wilson", "Guzman", 25.00, "mg@gmail.com", "Magaly00");
        clienteDAO.create(cli);
        Cliente cli2 = new Cliente("1702577832", "William", "Guzman", 25.00, "mg@gmail.com", "Magaly00");
        clienteDAO.update(cli2);
        clienteDAO.delete(cli);
        System.out.println("ProbarList"+clienteDAO.find());
        System.out.println("Uno solo"+clienteDAO.read("0106786031"));
        /*
		UsuarioDAO usuarioDAO = DAOGuia.getGuia().getUsuarioDAO();
		usuarioDAO.createTable(); 
		TelefonoDAO telefonoDAO = DAOGuia.getGuia().getTelefonoDAO();
		telefonoDAO.createTable(); 
		// TODO Auto-generated constructor stub

		Usuario u = new Usuario("0123456753", "Bryam", "Guzman", "bryamgmfn@gmail.com", "Magaly00");

		Usuario u1 = new Usuario("0102541487", "Wilson", "Guzman", "wilson@gmail.com", "LIGAdequito00");

		Telefono tel = new Telefono("0984966328", "Movil", "Movistar");
		Telefono tel2 = new Telefono("0968420404", "Movil", "Claro");
		Telefono tel3 = new Telefono("0987654321", "Movil", "Claro");

		Set<Telefono> telefonos1 = new HashSet<Telefono>();
		telefonos1.add(tel);
		telefonos1.add(tel2);
		telefonos1.add(tel3);

		u.setTelefonos(telefonos1);

		usuarioDAO.create(u);
		usuarioDAO.create(u1);
		// TODO Auto-generated constructor stub

		 */
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
