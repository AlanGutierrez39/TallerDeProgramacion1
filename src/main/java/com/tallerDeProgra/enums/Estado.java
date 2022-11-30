package com.tallerDeProgra.enums;
/**
 * Clase enum que contiene los estados de los mozos
 * @author Nahuel
 *
 */
public enum Estado {
	ACTIVO("Activo"), AUSENTE("Ausente"), DE_FRANCO("Franco");
	
	private Estado(String estadoString) {
		this.estado=estadoString;
	}
	private String estado;
	public String getEstado() {
		return estado;
	}
	
	
}
