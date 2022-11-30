package com.tallerDeProgra.enums;
/**
 * Clase enum que contiene el booleano Verdadero y falso
 * @author Nahuel
 *
 */
public enum VerdaderoFalso {
	VERDADERO("Si"), FALSO("No");
	
	private VerdaderoFalso(String estadoString) {
		this.verdaderoFalso=estadoString;
	}
	
	private String verdaderoFalso;
	public String getTexto() {
		return verdaderoFalso;
	}
}
