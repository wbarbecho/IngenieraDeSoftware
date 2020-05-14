package ec.edu.ups.modelo;

import java.io.Serializable;

public class LibroDigital implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Libro Libro;
	private String id;
	private double comision;

	public LibroDigital(Libro libro, String id, double comision) {
		super();
		Libro = libro;
		this.id = id;
		this.comision = comision;
	}

	public Libro getLibro() {
		return Libro;
	}

	public void setLibro(Libro libro) {
		Libro = libro;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return "LibroDigital [Libro=" + Libro + ", id=" + id + ", comision=" + comision + "]";
	}

}
