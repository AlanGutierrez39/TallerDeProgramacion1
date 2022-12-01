package excepciones;
/**
 * Excepcion que trata cantidad insuficiente a la hora de iniciar un dia 
 * @author Nahuel
 *
 */
public class CantidadInsuficienteActivosException extends Exception{
	public CantidadInsuficienteActivosException(String message) {
		super(message);
	}
}
