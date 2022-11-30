package com.tallerDeProgra.capaDeNegocios;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.tallerDeProgra.capaDeDatos.Mozo;
import com.tallerDeProgra.capaDeDatos.Operario;
import com.tallerDeProgra.capaDeDatos.OperarioAdministrador;
import com.tallerDeProgra.enums.Estado;

import excepciones.DatosIncorrectosException;
import excepciones.WrongPasswordException;
import excepciones.WrongUserException;
/**
 * Clase que representa una de las subclases del patron facade de la clase Sistema
 * @author Nahuel
 *
 */
public class GestionDePersonal implements Serializable{
	private static GestionDePersonal instance = null;

	/**
	 * Constructor privado del sistema debido a que se utiliza el patron Singleton
	 */
	private GestionDePersonal() {
		
	}
	/**
	 * Metodo estatico para instanciar una clase por unica vez
	 * @return Devuelve la instancia de clase GestionDePersonal
	 */
	protected static GestionDePersonal getInstance() {
		if (GestionDePersonal.instance == null) {
			GestionDePersonal.instance = new GestionDePersonal();
		}
		return instance;
	}
	/**
	 * Agrega una cuenta de operario al sistema
	 * @param nombreDeUsuario : parametro de tipo String que representa el nombre de usuario de la cuenta a crear
	 * @param password : parametro de tipo String que representa la contrasenia de la cuenta a crear
	 * @param activo : parametro que determina si un usuario se encuentra activo o no
	 * @throws DatosIncorrectosException : Se lanza si el nombre de usuario es nulo, el password tiene menos de 6 caracteres, el password tiene mas de 12 caracteres, el password no tiene al menos una mayuscula o el password no tiene al menos un digito.
	 * activo != null 
	 */
	public void altaOperario(String nombreDeUsuario, String password, boolean activo) throws DatosIncorrectosException {
		if(nombreDeUsuario != null && passwordCumple(password)) {
			Sistema.getInstance().getOperarios().add(new Operario(nombreDeUsuario, password, activo));
		}
		else
			throw new DatosIncorrectosException("Ingrese datos correctamente.");
	}
	
	/**
	 * Verifica que un password tiene entre 6 y 12 caracteres, tenga al menos una mayuscula y tenga al menos un digito.
	 * @param password : Parametro de tipo String que representa la contrasenia de una cuenta 
	 * @return Devuelve false si la contrasenia no cumple las condiciones y true si cumple 
	 */
	public boolean passwordCumple(String password) {
		int i;
		if(password != null && password.length() <= 12 && password.length() >= 6) {
			i = 0;
			while (i < password.length() && !Character.isUpperCase(password.charAt(i)))
				i++;
			if(i < password.length()) {
				i = 0;
				while (i < password.length() && !Character.isDigit(password.charAt(i)))
					i++;
				if(i < password.length())
					return true;
				else
					return false;
			}else
				return false;
		}
		else
			return false;	
	}
	/**
	 * Agrega una cuenta de operario administrador al sistema
	 * @param nombreDeUsuario : Parametro de tipo String que representa el nombre de usuario de la cuenta a crear de tipo Operario Administrador
	 * @param password : Parametro de tipo String que representa la contrasenia de la cuenta a crear
	 * @param activo : parametro que determina si un usuario se encuentra activo o no
	 * - nombreDeUsuario != null
	 * - password != null
	 * - activo != null
	 */
	public void altaOperarioAdministrador(String nombreDeUsuario, String password, boolean activo) {
		Sistema.getInstance().getOperariosAdministradores().add(new OperarioAdministrador(nombreDeUsuario, password, activo));
	}
	/**
	 * Modifica el estado de un mozo
	 * @param mozo : Parametro de tipo Mozo que representa el mozo al cual se desea modificar el estado
	 * @param estado : Parametro de tipo String que representa el esta al cual se desea cambiar
	 * @throws DatosIncorrectosException : Se lanza si los datos enviados por parametro son invalidos
	 */
	public void cambiarEstadoMozo(Mozo mozo, String estado) throws DatosIncorrectosException{
		if(mozo== null || estado==null)
			throw new DatosIncorrectosException();
		mozo.setEstado(estado);
	}
	/**
	 * Agrega un mozo al sistema. Verifica que cantHijos sea mayor a 0. Verifica que la edad sea mayor de 18 anios. Verifica que el estado y nombres no sean nulos.
	 * @param cantHijos : Parametro que representa la cantidad de hijos de un mozo
	 * @param estado : Parametro que representa el estado de un mozo
	 * @param sueldo : Parametro que representa el suelo de un mozo
	 * @param nombre : Parametro que representa el nombre de un mozo
	 * @param anioNac : Parametro que representa el anio de nacimiento de un mozo
	 * @param mesNac : Parametro que representa el mes de nacimiento de un mozo
	 * @param diaNac : Parametro que representa el dia de nacimiento de un mozo 
	 * @throws DatosIncorrectosException : Se lanza si los datos enviados por parametro son invalidos
	 * cantHijos;
	 * sueldo != null
     * anioNac != null
	 * mesNac != null
	 * diaNac != null
	 */
	public void altaMozo(int cantHijos, String estado, double sueldo, String nombre, int anioNac, int mesNac, int diaNac) throws DatosIncorrectosException {
		
		if(cantHijos >= 0 && comparaEdad(anioNac, mesNac, diaNac) && estado!=null && nombre!=null) {
			Date fechaNac = new Date(anioNac, mesNac, diaNac);
			Sistema.getInstance().getMozos().add(new Mozo (cantHijos,estado,sueldo, nombre, fechaNac));
		}
		else
			throw new DatosIncorrectosException("Ingrese datos correctamente.");
	}
	
	/**
	 * Elimina un mozo de la lista de mozos sistema
	 * @param mozo : Parametro que representa el mozo a eliminar
	 * @throws DatosIncorrectosException : Se lanza si el mozo es nulo
	 */
	public void bajaMozo(Mozo mozo) throws DatosIncorrectosException{
		if (mozo==null)
			throw new DatosIncorrectosException("Parametros invalidos.");
		Sistema.getInstance().getMozos().remove(mozo);
		
	}
	
	/**
	 * Modifica un mozo del sistema. Verifica que el mozo este en la lista del sistema. Verifica que cantHijos sea mayor o igual a 0. Verifica que la edad sea mayor de 18 anios. Verifica que el estado y nombres no sean nulos.
	 * @param cantHijos : Parametro que representa la cantidad de hijos de un mozo
	 * @param estado : Parametro que representa el estado de un mozo
	 * @param sueldo : Parametro que representa el suelo de un mozo
	 * @param nombre : Parametro que representa el nombre de un mozo
	 * @param anioNac : Parametro que representa el anio de nacimiento de un mozo
	 * @param mesNac : Parametro que representa el mes de nacimiento de un mozo
	 * @param diaNac : Parametro que representa el dia de nacimiento de un mozo 
	 * @throws DatosIncorrectosException : Se lanza si los datos enviados por parametro son invalidos o si el mozo no se encontro en el sistema
	 * 
	 * cantHijos != null
	 * estado != null
	 * sueldo != null
	 * nombre != null
	 * anioNac != null
	 * mesNac != null
	 * diaNac != null  
	 */
	public void modificarMozo(int id, int cantHijos, String estado, double sueldo, String nombreYApel, int anioNac, int mesNac, int diaNac) throws DatosIncorrectosException {
		Sistema modelo = Sistema.getInstance();
		
		if(cantHijos >= 0 && comparaEdad(anioNac, mesNac, diaNac) && estado!=null && nombreYApel!=null) {		
			Date fechaNac = new Date(anioNac, mesNac, diaNac);
			int i = 0;

			while (i < modelo.getMozos().size() && modelo.getMozos().get(i).getId() != id)
				i++;
			if(modelo.getMozos().get(i).getId()!=i)
				throw new DatosIncorrectosException("El mozo a modificar no fue encontrado");
			modelo.getMozos().get(i).setCantHijos(cantHijos);
			modelo.getMozos().get(i).setEstado(estado);
			modelo.getMozos().get(i).setNacimiento(fechaNac);
			modelo.getMozos().get(i).setNombreYApellido(nombreYApel);
			modelo.getMozos().get(i).setSueldo(sueldo);
		}
		else
			throw new DatosIncorrectosException("Ingrese datos correctamente.");
		
	}
	
	/**
	 * Metodo que valida la fecha de nacimiento.
	 * @param anio : Parametro que representa el anio de nacimiento 
	 * @param mes : Parametro que representa el mes de nacimiento de un mozo
	 * @param dia : Parametro que representa el dia de nacimiento de un mozo 
	 * @return : Devuelve verdadero si la fecha es valida y falso si es invalida
	 */
	public boolean comparaEdad(int anio, int mes, int dia) {
		LocalDate fechaHoy = LocalDate.now();
		if(anio < fechaHoy.getYear() && mes <= 12 && mes >=1 && dia >= 1 && dia<=31) {
			LocalDate fechaNac = LocalDate.of(anio,mes,dia);
			if(Period.between(fechaNac, fechaHoy).getYears() >= 18) 
				return true;
			else
				return false;
		}
		else
			return false;
	}
		
	/**
	 * Modifica una cuenta de operario al sistema
	 * 
	 * @param nombreDeUsuario : parametro de tipo String que representa el nuevo nombre de usuario en la cuenta a modificar
	 * @param password : parametro de tipo String que representa la nueva contrasenia en la cuenta a modificar
	 * @param activo : parametro que determina si un usuario se encuentra activo o no
	 * @throws DatosIncorrectosException : Se lanza si el nombre de usuario es nulo, el password tiene menos de 6 caracteres, el password tiene mas de 12 caracteres, el password no tiene al menos una mayuscula o el password no tiene al menos un digito.
	 * <b>Pre: </b> <br>
	 * nombreUsuarioAnterior != null<br>
	 * <b>Post: </b> <br> 
	 * Se modifica una cuenta de operario al sistema<br> 
	 */
	public void modificacionOperario(String nombreUsuarioAnterior, String nombreUsuario, String password, boolean activo) throws DatosIncorrectosException {
		Sistema modelo = Sistema.getInstance();
		
		if(nombreUsuario != null && passwordCumple(password)) {
			int i = 0;
			
			while (i < modelo.getOperariosAdministradores().size() && !modelo.getOperariosAdministradores().get(i).getNombreDeUsuario().equals(nombreUsuarioAnterior)) 
				i++;
			
			if(i < modelo.getOperariosAdministradores().size()) {
				modelo.getOperariosAdministradores().get(i).setActivo(activo);
				modelo.getOperariosAdministradores().get(i).setNombreDeUsuario(nombreUsuario);
				modelo.getOperariosAdministradores().get(i).setPassword(password);
			}
			else {
				i = 0;
				while (i < modelo.getOperarios().size() && !modelo.getOperarios().get(i).getNombreDeUsuario().equals(nombreUsuarioAnterior)) 
					i++;
				if(i < modelo.getOperarios().size()) {
					System.out.println("modifica");
					modelo.getOperarios().get(i).setActivo(activo);
					modelo.getOperarios().get(i).setNombreDeUsuario(nombreUsuario);
					modelo.getOperarios().get(i).setPassword(password);
				}
			}
		}
		else
			throw new DatosIncorrectosException("Ingrese datos correctamente.");
	}
	
}
