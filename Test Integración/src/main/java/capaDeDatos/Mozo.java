package capaDeDatos;
/**
 * Clase que representa un mozo
 * @author Nahuel
 *
 */
import java.util.Calendar;
import java.util.Date;

public class Mozo extends Persona{
	private int cantHijos;
	private String estado;
	private double sueldo;
	private double acumulado; //Cantidad facturado
	private int acumulado_mesas;//Cantidad de mesas atendidas

	//----------------------------Constructor-------------------------//
	/**
	 * Pre:
	 * - cantHijos >= 0 
	 * - Fecha, edad >= 18
	 * - estado != null 
	 * - nombre != null
	 * @param cantHijos
	 * @param estado
	 * @param sueldo
	 * @param nombreYApellido
	 * @param fecha, edad del mozo
	 */
	public Mozo(int cantHijos, String estado, double sueldo, String nombreYApellido, Date fecha ) {
		super(nombreYApellido, fecha);
		this.cantHijos = cantHijos;
		this.estado = estado;
		this.sueldo = sueldo;
		this.acumulado = 0;
		this.acumulado_mesas=0;
	}
	
	
	
	//----------------------------Getters y Setters-------------------------//

	
	public int getCantHijos() {
		return cantHijos;
	}
	/**
	 * - cantHijos >= 0 
	 * @param cantHijos
	 */
	public void setCantHijos(int cantHijos) {
		this.cantHijos = cantHijos;
	}
	public String getEstado() {
		return estado;
	}
	/**
	 * Pre:
	 * - Estado != null
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public double getAcumulado() {
		return acumulado;
	}
	public void setAcumulado(double d) {
		this.acumulado = d;
	}

	public int getAcumulado_mesas() {
		return acumulado_mesas;
	}
	public void setAcumulado_mesas(int acumulado_mesas) {
		this.acumulado_mesas = acumulado_mesas;
	}





	@Override
	public String toString() {
		return "Nombre:" + this.NombreYApellido +"  Estado:" + this.estado;
	}










	
	
}
