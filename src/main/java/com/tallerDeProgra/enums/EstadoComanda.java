package com.tallerDeProgra.enums;
/**
 * Clase enum que contiene los estados de una comanda
 * @author Nahuel
 *
 */
public enum EstadoComanda {
	ABIERTA("Abierta"), CERRADA("Cerrada");
	
	private EstadoComanda(String estadoString) {
		this.estadoComanda=estadoString;
	}
	
	private String estadoComanda;
	public String getEstado() {
		return estadoComanda;
	}
}
