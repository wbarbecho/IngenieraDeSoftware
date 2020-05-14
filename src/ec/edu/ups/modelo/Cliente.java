package ec.edu.ups.modelo;

import java.io.Serializable;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cedula;
	private String Nombre;
	private String Apellido;
	private Double credito;
	private String correo;
	private String contrasenia;
	private String rol;

	public Cliente(String cedula, String nombre, String apellido, Double credito, String correo, String contrasenia,
			String rol) {
		super();
		this.cedula = cedula;
		Nombre = nombre;
		Apellido = apellido;
		this.credito = credito;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.rol = rol;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public Double getCredito() {
		return credito;
	}

	public void setCredito(Double credito) {
		this.credito = credito;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", credito=" + credito
				+ ", correo=" + correo + ", contrasenia=" + contrasenia + ", rol=" + rol + "]";
	}

}
