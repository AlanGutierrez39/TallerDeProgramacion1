package capaDeDatos;

import java.io.Serializable;
import java.util.Date;
/**
 * Clase que representa una persona 
 * @author Nahuel
 *
 */
public class Persona implements Serializable{
	protected int id;
	protected String NombreYApellido;
	protected Date nacimiento;
	private static int identificador=0;
	
	//----------------------------Constructor-------------------------//

	/**
	 * @param nombreYApellido
	 * @param fecha
	 * - fecha != null <br>
	 * - nombreYApellido != null <br>
	 */
	public Persona(String nombreYApellido, Date fecha) {
		super();
		this.identificador+=1;
		this.id = this.identificador;
		NombreYApellido = nombreYApellido;
		this.nacimiento = fecha;
	}
	
	
	
	
	//----------------------------Getters y Setters-------------------------//

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreYApellido() {
		return NombreYApellido;
	}
	/**
	 * - nombreYApellido != null
	 * @param nombreYApellido
	 */
	public void setNombreYApellido(String nombreYApellido) {
		NombreYApellido = nombreYApellido;
	}
	public Date getNacimiento() {
		return nacimiento;
	}
	/**
	 * - Fecha, edad >= 18
	 * @param nacimiento
	 */
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}




	@Override
	public String toString() {
		return "Persona [id=" + id + ", NombreYApellido=" + NombreYApellido + ", nacimiento=" + nacimiento + "]";
	}
	
}
