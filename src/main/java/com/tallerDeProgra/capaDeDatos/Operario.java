package com.tallerDeProgra.capaDeDatos;

import java.io.Serializable;

/**
 * Clase que representa un operario y su cuenta
 * @author Nahuel
 *
 */
public class Operario implements Serializable{
	protected String nombreDeUsuario;
	protected String nombreYapellido;
	protected String password;
	protected boolean activo;
	protected int tipoOperario;

	
	//----------------------------Constructor-------------------------//
	/**
	 * Pre:
	 * - nombreDeUsuario != null <br>
	 * - password != null  <br>
	 * - password.length() <= 12 <br>
	 * - password.length() >= 6 <br>
	 * - password contiene al menos un caracter Mayuscula <br>
	 * - password contiene al menos un numero <br>
	 * - activo != null <br>
	 * @param nombreDeUsuario
	 * @param password
	 * @param activo
	 */
	public Operario(String nombreDeUsuario, String password, boolean activo) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
		this.password = password;
		this.activo = activo;
		this.tipoOperario = 1;
	}
	
	
	//----------------------------Getters y Setters-------------------------//

	
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	/**
	 * - nombreUsuario != null<br>
	 * @param nombreDeUsuario
	 */
	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}
	public String getPassword() {
		return password;
	}
	/**	 
	 * - password != null <br>
	 * - password.length() <= 12 <br>
	 * - password.length() >= 6 <br>
	 * - password contiene al menos un caracter Mayuscula
	 * - password contiene al menos un numero
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActivo() {
		return activo;
	}
	/**
	 * - activo != null <br>
	 * @param activo
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public int getTipoOperario() {
		return tipoOperario;
	}
	public String getNombreYapellido() {
		return nombreYapellido;
	}





	@Override
	public String toString() {
		return "Operario [Nombre = " + nombreDeUsuario + ", activo = " + activo + "]";
	}
	
	
}
