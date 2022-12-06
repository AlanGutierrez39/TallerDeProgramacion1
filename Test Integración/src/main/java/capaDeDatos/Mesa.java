package capaDeDatos;

import java.io.Serializable;

/**
 * Clase que representa una mesa del restaurante
 * @author Nahuel
 *
 */
public class Mesa implements Serializable{
	private int id;
	private int cantComensales;
	private String estado;
	private static int identificador=-1;		//0 hace referencia a la barra
	
	//----------------------------Constructor-------------------------//
	
	
	/**
	 * Pre:
	 * - Mesa != null
	 * - cantComensales >= 2
	 * @param cantComensales
	 * @param estado
	 */
	public Mesa(int cantComensales, String estado) {
		super();
		this.identificador+=1;
		this.id = this.identificador;
		this.cantComensales = cantComensales;
		this.estado = estado;
	}
	
	//----------------------------Getters y Setters-------------------------//

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getCantComensales() {
		return cantComensales;
	}
	
	/**
	 * Pre:
	 * - Cantidad de comensales >= 2
	 * @param cantComensales
	 */
	public void setCantComensales(int cantComensales) {
		this.cantComensales = cantComensales;
	}
	public String getEstado() {
		return estado;
	}
	
	
	/**
	 * Pre:
	 * - estado != null
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Mesa: " + id + " - estado=" + estado;
	}
	
}
