package com.tallerDeProgra.capaDeDatos;

import java.io.Serializable;

/**
 * Clase que representa una relacion que surje entre una entidad mozo y una entidad mesa cuando a un mozo se le asigna una mesa
 * @author Nahuel
 *
 */
public class RelacionMesaMozo implements Serializable {
	private Mesa mesa;
	private Mozo mozo;
	
	
	
	//----------------------------Constructor-------------------------//

	/**
	 * mesa != null
	 * mozo != null
	 * @param mesa
	 * @param mozo
	 */
	public RelacionMesaMozo(Mesa mesa, Mozo mozo) {
		super();
		this.mesa = mesa;
		this.mozo = mozo;
	}
	
	
	//----------------------------Getters y Setters-------------------------//

	
	
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public Mozo getMozo() {
		return mozo;
	}
	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}
	
}
