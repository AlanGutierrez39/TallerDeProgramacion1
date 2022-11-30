package com.tallerDeProgra.capaDeDatos;

import java.io.Serializable;

/**
 * Clase que representa un local
 * @author Nahuel
 *
 */
public class Local implements Serializable{
	private String nombre;
	private Float sueldo;
	
	
	
	//----------------------------Constructor-------------------------//
	public Local(String nombre, Float sueldo) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
	}
	
	//----------------------------Getters y Setters-------------------------//

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getSueldo() {
		return sueldo;
	}
	public void setSueldo(Float sueldo) {
		this.sueldo = sueldo;
	}
	
	
	
}
