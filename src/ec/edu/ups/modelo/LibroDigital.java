package ec.edu.ups.modelo;

import java.io.Serializable;

public class LibroDigital extends Libro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Libro Libro;
	private int id;
	private double comision;

	public LibroDigital(String isbn, String titulo, String autor, String edicion, String imagen, double precio,
			ec.edu.ups.modelo.Libro libro, int id, double comision) {
		super(isbn, titulo, autor, edicion, imagen, precio);
		Libro = libro;
		this.id = id;
		this.comision = comision;
	}

	@Override
	public double calcularPrecioFijo() {
		double precioFijo = super.getPrecio() + comision;
		super.setPrecio(precioFijo);
		return precioFijo;
	}

	@Override
	public double calcularComision() {
		// TODO Auto-generated method stub
		comision = super.getPrecio() * 0.03;
		return comision;
	}

	public Libro getLibro() {
		return Libro;
	}

	public void setLibro(Libro libro) {
		Libro = libro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	@Override
	public String toString() {
		return "Libro Digital :" + super.toString() + ", id=" + id + ", comision=" + comision;

	}

}
