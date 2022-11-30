package excepciones;
/**
 * Excepcion que trata cantidad incorrecta de mozos de franco
 * @author Nahuel
 *
 */
public class DemasiadosMozosDeFrancoException extends Exception{
	public DemasiadosMozosDeFrancoException(String message) {
		super(message);
	}
}
