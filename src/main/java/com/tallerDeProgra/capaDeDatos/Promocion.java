package com.tallerDeProgra.capaDeDatos;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Clase que representa una promocion
 * @author Nahuel
 *
 */
public class Promocion extends PromocionPadre implements Serializable { 
	private int id;
	private Producto producto;
	private ArrayList<String> diasPromocion;
	private boolean aplicaDosXUno;
	private boolean aplicaDescXCantMin;
	private int descXCantMin;
	private float descXCantXPrecioUnitario ;
	private boolean activa;
	private static int identificador=0;
	
	//----------------------------Constructor-------------------------//

	/**
	 * @param producto
	 * @param diasPromocion
	 * @param aplicaDosXUno
	 * @param aplicaDescXCantMin
	 * @param descXCantMin
	 * @param descXCantXPrecioUnitario
	 * @param activa
	 * - producto != null <br>
	 * - diasPromocion != null <br>
	 * - aplicaDosXUno != null <br>
	 * - aplicaDescXCantMin != null <br>
	 * - descXCantMin != null <br>
	 * - descXCantXPrecioUnitario != null <br>
	 * - activa != null <br>
	 */
	public Promocion(Producto producto, ArrayList<String> diasPromocion, boolean aplicaDosXUno,
			boolean aplicaDescXCantMin, int descXCantMin, float descXCantXPrecioUnitario, boolean activa) {
		super();
		this.identificador+=1;
		this.id = this.identificador;
		this.producto = producto;
		this.diasPromocion = diasPromocion;
		this.aplicaDosXUno = aplicaDosXUno;
		this.aplicaDescXCantMin = aplicaDescXCantMin;
		this.descXCantMin = descXCantMin;
		this.descXCantXPrecioUnitario = descXCantXPrecioUnitario;
		this.activa = activa;
	}
	
	
	public Promocion() {
		this.identificador+=1;
		this.id = this.identificador;
	}
	
	//----------------------------Getters y Setters-------------------------//


	public int getId() {
		return id;
	}
	public Producto getProducto() {
		return producto;
	}
	/**
	 * - producto != null
	 * @param producto
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public ArrayList<String> getDiasPromocion() {
		return diasPromocion;
	}
	/**
	 * - diasDePromo != null
	 * - diasDePromo.size() != 0
	 * @param diasPromocion
	 */
	public void setDiasPromocion(ArrayList<String> diasPromocion) {
		this.diasPromocion = diasPromocion;
	}
	public boolean isAplicaDosXUno() {
		return aplicaDosXUno;
	}
	/**
	 * @param aplicaDosXUno
	 * - aplicaDosXUno > 0 <br>
	 */
	public void setAplicaDosXUno(boolean aplicaDosXUno) {
		this.aplicaDosXUno = aplicaDosXUno;
	}
	public boolean isAplicaDescXCantMin() {
		return aplicaDescXCantMin;
	}
	/**
	 * @param aplicaDescXCantMin
	 * - aplicaDescXCantMin != null <br>
	 */
	public void setAplicaDescXCantMin(boolean aplicaDescXCantMin) {
		this.aplicaDescXCantMin = aplicaDescXCantMin;
	}
	public int getDescXCantMin() {
		return descXCantMin;
	}
	/**
	 * @param descXCantMin
	 * - descXCantMin > 0 <br>
	 * - descXCantMin != null <br>
	 */
	public void setDescXCantMin(int descXCantMin) {
		this.descXCantMin = descXCantMin;
	}
	public float getDescXCantXPrecioUnitario() {
		return descXCantXPrecioUnitario;
	}
	/**
	 * @param descXCantXPrecioUnitario
	 * - descXCantXPrecioUnitario > 0 <br>
	 * - descXCantXPrecioUnitario != null <br>
	 */
	public void setDescXCantXPrecioUnitario(float descXCantXPrecioUnitario) {
		this.descXCantXPrecioUnitario = descXCantXPrecioUnitario;
	}
	public boolean isActiva() {
		return activa;
	}	
	/**
	 * @param activa
	 * - activa != null <br>
	 */
	public void setActiva(boolean activa) {
		this.activa = activa;
	}


	@Override
	public String toString() {
		return "Producto=" + producto + ", diasPromocion=" + diasPromocion
				+ ", aplicaDosXUno=" + aplicaDosXUno + ", aplicaDescXCantMin=" + aplicaDescXCantMin + ", descXCantMin="
				+ descXCantMin + ", descXCantXPrecioUnitario=" + descXCantXPrecioUnitario + ", activa=" + activa + "]";
	}
	
}
