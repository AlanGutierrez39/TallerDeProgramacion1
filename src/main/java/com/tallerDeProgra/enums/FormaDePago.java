package com.tallerDeProgra.enums;
/**
 * Clase enum que contiene las formas de pago
 * @author Nahuel
 *
 */
public enum FormaDePago {
	EFECTIVO("Efectivo"), TARJETA("Tarjeta"), MERCPAGO("Mercado Pago"), CUENTADNI("Cuenta DNI");
	
	private FormaDePago(String estadoString) {
		this.formaDePago=estadoString;
	}
	
	private String formaDePago;
	public String getText() {
		return formaDePago;
	}
}
