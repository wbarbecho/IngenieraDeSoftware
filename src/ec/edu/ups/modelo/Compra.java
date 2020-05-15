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
	private ArrayList<LibroDigital> listaDigitales;
	private ArrayList<LibroImpreso> listaImpresos;

	public Compra(int id, Date fecha, Cliente cliente, ArrayList<LibroDigital> listaDigitales,
			ArrayList<LibroImpreso> listaImpresos) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
		this.listaDigitales = listaDigitales;
		this.listaImpresos = listaImpresos;
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
		return listaDigitales;
	}

	public void setListaDigitales(ArrayList<LibroDigital> listaDigitales) {
		listaDigitales = listaDigitales;
	}

	public ArrayList<LibroImpreso> getListaImpresos() {
		return listaImpresos;
	}

	public void setListaImpresos(ArrayList<LibroImpreso> listaImpresos) {
		listaImpresos = listaImpresos;
	}

	public void addLibroDigital(LibroDigital libro) {
		listaDigitales.add(libro);
	}

	public void addLibroImreso(LibroImpreso libro) {
		listaImpresos.add(libro);
	}

	public double totalCostes() {
		double total = 0;
		for (LibroDigital libroDigital : listaDigitales)
			total += libroDigital.getPrecio();
		for (LibroImpreso libroImpres : listaImpresos)
			total += libroImpres.getPrecio();
		return total;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", fecha=" + fecha + "]";
	}

}
