package ec.edu.ups.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Compra implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date fecha;
	private Cliente cliente;
	private ArrayList<LibroDigital> ListaDigitales;
	private ArrayList<LibroImpreso> ListaImpresos;

	public Compra(int id, Date fecha, Cliente cliente, ArrayList<LibroDigital> listaDigitales,
			ArrayList<LibroImpreso> listaImpresos) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
		ListaDigitales = listaDigitales;
		ListaImpresos = listaImpresos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<LibroDigital> getListaDigitales() {
		return ListaDigitales;
	}

	public void setListaDigitales(ArrayList<LibroDigital> listaDigitales) {
		ListaDigitales = listaDigitales;
	}

	public ArrayList<LibroImpreso> getListaImpresos() {
		return ListaImpresos;
	}

	public void setListaImpresos(ArrayList<LibroImpreso> listaImpresos) {
		ListaImpresos = listaImpresos;
	}

	public void addLibroDigital(LibroDigital libro) {
		ListaDigitales.add(libro);
	}

	public void addLibroImreso(LibroImpreso libro) {
		ListaImpresos.add(libro);
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", ListaDigitales=" + ListaDigitales
				+ ", ListaImpresos=" + ListaImpresos + "]";
	}

}
