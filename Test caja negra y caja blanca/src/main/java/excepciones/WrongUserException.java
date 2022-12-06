package excepciones;
/**
 * Excepcion que trata nombres de usuarios incorrectos
 * @author Nahuel
 *
 */
public class WrongUserException extends Exception {
	public WrongUserException(String message) {
		super(message);
	}
}