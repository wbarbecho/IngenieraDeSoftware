package ec.edu.ups.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Compra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date fecha;
	private Cliente cliente;
	private ArrayList<Libro> ListaLibros;

	public Compra(int id, Date fecha, Cliente cliente, ArrayList<Libro> libros) {
		super();
		libros = new ArrayList<Libro>();
		this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
		this.ListaLibros = libros;
	}

	public Compra(int id, Date fecha, Cliente cliente) {
		super();
		ListaLibros = new ArrayList<Libro>();
		this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
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

	public ArrayList<Libro> getListaLibros() {
		return ListaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		ListaLibros = listaLibros;
	}

	public void addLibro(Libro libro) {
		ListaLibros.add(libro);
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", ListaLibros=" + ListaLibros + "]";
	}

}
