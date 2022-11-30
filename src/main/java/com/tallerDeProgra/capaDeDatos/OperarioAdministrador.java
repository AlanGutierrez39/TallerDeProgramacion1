package com.tallerDeProgra.capaDeDatos;
/**
 * Clase que representa una operario administrador y su cuenta
 * @author Nahuel
 *
 */
public class OperarioAdministrador extends Operario {
	
		
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
	public OperarioAdministrador(String nombreDeUsuario, String password, boolean activo) {
		super(nombreDeUsuario, password, activo);
		this.tipoOperario = 0;
	}

	@Override
	public String toString() {
		return "OperarioAdministrador [Nombre = " + super.nombreDeUsuario + ", activo = " + super.activo + "]";
	}
}