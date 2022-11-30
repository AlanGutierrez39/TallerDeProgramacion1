package com.tallerDeProgra.capaDeDatos;

import java.io.Serializable;

/**
 * Clase que representa un producto
 * @author Nahuel
 *
 */
public class Producto implements Serializable{
	private int id;
	private String nombre;
	private float precioCosto;
	private float precioVenta;
	private int stock;
	private static int identificador=0;
	
	//----------------------------Constructor-------------------------//

	/**
	 * Pre:
	 * - nombre!= null 
	 * - precioVenta > 0 
	 * - precioCosto > 0 
	 * - precioVenta >= precioCosto
	 * @param nombre
	 * @param precioCosto
	 * @param precioVenta
	 * @param stock
	 */
	public Producto(String nombre, float precioCosto, float precioVenta, int stock) {
		super();
		this.identificador+=1;
		this.id = this.identificador;
		this.nombre = nombre;
		this.precioCosto = precioCosto;
		this.precioVenta = precioVenta;
		this.stock = stock;
	}
	
	
	
	
	//----------------------------Getters y Setters-------------------------//
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecioCosto() {
		return precioCosto;
	}
	/**
	 * Pre:
	 * - precioCosto > 0
	 * @param precioCosto
	 */
	public void setPrecioCosto(float precioCosto) {
		this.precioCosto = precioCosto;
	}
	public float getPrecioVenta() {
		return precioVenta;
	}
	/**
	 * Pre:
	 * - precioVenta >= precioCosto
	 * - precioVenta > 0
	 * @param precioVenta
	 */
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}




	@Override
	public String toString() {
		return "id = " + id + " | nombre = " + nombre + " stock = " + stock;
	}


}