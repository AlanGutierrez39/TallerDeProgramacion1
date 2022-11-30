package com.tallerDeProgra.enums;
/**
 * Clase enum que contiene los estados de una mesa
 * @author Nahuel
 *
 */
public enum EstadosMesa {
	LIBRE("Libre"), OCUPADA("Ocupada");
	
	private EstadosMesa(String estadoString) {
		this.estadoMesa=estadoString;
	}
	
	private String estadoMesa;
	public String getEstado() {
		return estadoMesa;
	}
}
