package com.tallerDeProgra.capaDeDatos;

import java.io.Serializable;
import java.util.Date;
/**
 * Clase que representa un pedido de una mesa
 * @author Nahuel
 *
 */
public class Pedido implements Serializable{
	private int id;
	private Date fecha;
	private int cantidad;
	private Producto producto;
	private static int identificador=0;

	//----------------------------Constructor-------------------------//

	public Pedido(int id, Date fecha, int cantidad, Producto producto) {
		super();
		this.identificador+=1;
		this.id = this.identificador;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.producto = producto;
	}
	
	
	
	
	
	//----------------------------Getters y Setters-------------------------//

	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	/**
	 * fecha != null
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * cantidad > 0
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	/**
	 * producto != null
	 * @param producto
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
