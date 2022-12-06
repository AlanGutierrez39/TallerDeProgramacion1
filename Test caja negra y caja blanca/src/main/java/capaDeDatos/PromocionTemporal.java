package capaDeDatos;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Clase que representa una promocion temporal
 * @author Nahuel
 *
 */
public class PromocionTemporal extends PromocionPadre implements Serializable{
	private int id;
	private String nombre;
	private String formaDePago;
	private int porcentajeDescuento;
	private ArrayList<String> diasPromocion;
	private boolean activo;
	private boolean acumulable;
	private static int identificador=0;
	
	//----------------------------Constructor-------------------------//
	/**
	 * @param id
	 * @param nombre
	 * @param formaDePago
	 * @param porcentajeDescuento
	 * @param diasPromocion
	 * @param activo
	 * @param acumulable
	 * 
	 * - id != null
	 * - nombre != null
	 * - formaDePago != null
	 * - porcentajeDescuento != null
 	 * - diasPromocion != null
	 * - activo != null
	 * - acumulable != null
	 */
	public PromocionTemporal(int id, String nombre, String formaDePago, int porcentajeDescuento,
			ArrayList<String> diasPromocion, boolean activo, boolean acumulable) {
		super();
		this.identificador+=1;
		this.id = this.identificador;
		this.nombre = nombre;
		this.formaDePago = formaDePago;
		this.porcentajeDescuento = porcentajeDescuento;
		this.diasPromocion = diasPromocion;
		this.activo = activo;
		this.acumulable = acumulable;
	}
	
	//----------------------------Getters y Setters-------------------------//

	
	public PromocionTemporal() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	/**
	 * @param id
	 * - id != null 
	 */
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre
	 * - nombre != null 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFormaDePago() {
		return formaDePago;
	}
	/**
	 * @param formaDePago
	 * - formaDePago != null
	 */
	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	/**
	 * @param porcentajeDescuento
	 * - porcentajeDescuento > 0
	 */
	public void setPorcentajeDescuento(int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	public ArrayList<String> getDiasPromocion() {
		return diasPromocion;
	}
	/**
	 * @param diasPromocion
	 * - diasDePromocion != null
	 * - diasDePromocion.size() == 0
	 */
	public void setDiasPromocion(ArrayList<String> diasPromocion) {
		this.diasPromocion = diasPromocion;
	}
	public boolean isActivo() {
		return activo;
	}
	/**
	 * @param activo
	 * - activo != null
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public boolean isAcumulable() {
		return acumulable;
	}
	/**
	 * @param acumulable
	 * - acumulable != null
	 */
	public void setAcumulable(boolean acumulable) {
		this.acumulable = acumulable;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", formaDePago=" + formaDePago
				+ ", porcentajeDescuento=" + porcentajeDescuento + ", diasPromocion=" + diasPromocion + ", activo="
				+ activo + ", acumulable=" + acumulable + "]";
	}
	
}
