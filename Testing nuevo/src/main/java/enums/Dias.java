package enums;
/**
 * Clase enum que contiene los dias de la semana
 * @author Nahuel
 *
 */
public enum Dias {
	LUNES("Lunes"), MARTES("Martes"), MIERCOLES("Miercoles"), JUEVES("Jueves"), VIERNES("Viernes"), SABADO("Sabado"), DOMINGO("Domingo");
	private Dias(String estadoString) {
		this.dia=estadoString;
	}
	private String dia;
	public String getDia() {
		return dia;
	}
	
}
